package is.us.soloweb.forms;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFFieldSet;
import is.us.soloweb.forms.data.SWFForm;
import is.us.soloweb.forms.data.SWFRegistration;
import is.us.util.USArrayUtilities;
import is.us.util.USStringUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSMutableDictionary;

/**
 * @author Hugi Þórðarson
 */

public class SWFNewFormDisplay extends SWGenericComponent {

	private EOEditingContext ec = session().defaultEditingContext();

	private static final String LEVEL_1 = "first";
	private static final String LEVEL_2 = "second";
	private static final String LEVEL_3 = "third";
	public String currentLevel = LEVEL_1;

	public SWFForm selectedForm;
	public SWFField currentField;
	public SWFRegistration theRegistration;

	public String errorString;
	public NSMutableDictionary<SWFField, Object> someFields = new NSMutableDictionary<SWFField, Object>();
	public NSMutableDictionary<SWFField, NSData> someDataFields = new NSMutableDictionary<SWFField, NSData>();

	private boolean firstTime = true;
	private int _currentFieldSetIndex = 0;

	public SWFNewFormDisplay( WOContext context ) {
		super( context );
	}

	public WOComponent goToPreview() {
		currentLevel = LEVEL_2;
		return context().page();
	}

	public WOComponent performCorrections() {
		currentLevel = LEVEL_1;
		_currentFieldSetIndex = 0;
		return context().page();
	}

	public WOComponent submitForm() {

		if( selectedForm.maxRegistrations() != null && (selectedForm.registrations().count() >= selectedForm.maxRegistrations()) ) {
			errorString = "Hámarksfjölda skráninga fyrir þetta form hefur verið náð.";
			return context().page();
		}

		if( !requiredFieldsFilledOut() ) {
			errorString = requiredFieldEmptyString();
			return context().page();
		}

		SWFRegistration registration = SWFUtilities.registrationFromDictionary( ec, selectedForm, someFields, someDataFields );
		currentLevel = LEVEL_3;
		registration.sendNotification();
		theRegistration = registration;

		return context().page();
	}

	public void appendToResponse( WOResponse r, WOContext c ) {

		if( firstTime ) {
			firstTime = false;

			Enumeration<SWFField> e = selectedForm.fields().objectEnumerator();

			while( e.hasMoreElements() ) {
				SWFField nextElement = e.nextElement();
				String defaultValue = nextElement.defaultValue();

				if( USStringUtilities.stringHasValue( defaultValue ) )
					someFields.setObjectForKey( defaultValue, nextElement );
			}
		}

		super.appendToResponse( r, c );
	}

	public Object currentString() {
		return someFields.objectForKey( currentField );
	}

	public void setCurrentString( Object o ) {
		if( o != null )
			someFields.setObjectForKey( o, currentField );
		else
			someFields.removeObjectForKey( currentField );
	}

	public NSData currentData() {
		return someDataFields.objectForKey( currentField );
	}

	public void setCurrentData( NSData d ) {
		if( d != null && d.length() > 0 )
			someDataFields.setObjectForKey( d, currentField );
		else
			someDataFields.removeObjectForKey( currentField );
	}

	public String currentStringWithBreaks() {
		if( currentString() instanceof String )
			return USStringUtilities.convertBreakString( ((String)currentString()) );

		return null;
	}

	public String requiredFieldEmptyString() {
		if( selectedForm != null )
			if( USStringUtilities.stringHasValue( selectedForm.requiredFieldEmptyString() ) )
				return selectedForm.requiredFieldEmptyString();

		return "Vinsamlegast fylli&eth; &uacute;t alla reiti sem merktir eru me&eth; stj&ouml;rnu";
	}

	private boolean requiredFieldsFilledOut() {
		NSArray<SWFField> a = selectedForm.requiredFields();

		if( !USArrayUtilities.arrayHasObjects( a ) )
			return true;

		Enumeration<SWFField> e = a.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWFField f = e.nextElement();

			if( someFields.objectForKey( f ) == null )
				return false;
		}

		return true;
	}

	public String colspan() {
		return USStringUtilities.stringHasValue( currentField.name() ) ? "1" : "2";
	}

	public SWFFieldSet currentFieldSet() {
		return (SWFFieldSet)selectedForm.sortedFieldSets().objectAtIndex( _currentFieldSetIndex );
	}

	public WOComponent nextFieldSet() {
		_currentFieldSetIndex++;
		return context().page();
	}

	public WOComponent previousFieldSet() {
		_currentFieldSetIndex--;
		return context().page();
	}

	public int currentIndexDisplay() {
		return _currentFieldSetIndex + 1;
	}

	public WOComponent showPrintableVersion() {
		SWFPrintableRegistration nextPage = pageWithName( SWFPrintableRegistration.class );
		nextPage.selectedRegistration = theRegistration;
		nextPage.setFieldList( theRegistration.form().sortedFieldsExcludingAdminFields() );
		return nextPage;
	}
}