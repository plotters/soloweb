package is.us.soloweb.forms;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.forms.data.SWFField;
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
 * A simple form display for a single step form.
 * 
 * @author Hugi Þórðarson
 */

public class SWFOldFormDisplay extends SWGenericComponent {

	private EOEditingContext ec = session().defaultEditingContext();

	public SWFForm selectedForm;
	public SWFField currentField;
	public SWFRegistration registration = new SWFRegistration();

	public String errorString;
	public boolean hasRegistered = false;
	public NSMutableDictionary<SWFField, Object> someFields = new NSMutableDictionary<SWFField, Object>();
	public NSMutableDictionary<SWFField, NSData> someDataFields = new NSMutableDictionary<SWFField, NSData>();

	public SWFOldFormDisplay( WOContext context ) {
		super( context );
	}

	@Override
	protected boolean useDefaultComponentCSS() {
		return true;
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
		hasRegistered = true;
		registration.sendNotification();

		return context().page();
	}

	public void appendToResponse( WOResponse r, WOContext c ) {

		if( selectedForm != null ) {
			if( registration.editingContext() == null ) {
				ec.insertObject( registration );

				Enumeration<SWFField> e = selectedForm.fields().objectEnumerator();

				while( e.hasMoreElements() ) {
					SWFField nextElement = e.nextElement();
					String defaultValue = nextElement.defaultValue();

					if( defaultValue != null )
						someFields.setObjectForKey( defaultValue, nextElement );
				}
			}
		}

		super.appendToResponse( r, c );
	}

	public String currentString() {
		return (String)someFields.objectForKey( currentField );
	}

	public void setCurrentString( String s ) {
		if( USStringUtilities.stringHasValue( s ) )
			someFields.setObjectForKey( s, currentField );
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
}