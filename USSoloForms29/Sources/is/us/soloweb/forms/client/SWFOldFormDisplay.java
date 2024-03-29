package is.us.soloweb.forms.client;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.forms.SWFUtilities;
import is.us.soloweb.forms.data.*;
import is.us.util.*;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

/**
 * A simple form display for a single step form.
 * 
 * @author Hugi Þórðarson
 */

public class SWFOldFormDisplay extends SWGenericComponent {

	private static final String ERROR_REQUIRED = "Vinsamlegast fyllið út alla reiti sem merktir eru með stjörnu";
	private static final String ERROR_MAX = "Hámarksfjölda skráninga fyrir þetta form hefur verið náð.";

	/**
	 * Perhaps the session's editing context is not the best place for this.
	 */
	private final EOEditingContext ec = session().defaultEditingContext();

	public SWFForm selectedForm;
	public SWFField currentField;
	public SWFRegistration registration = new SWFRegistration();

	public String errorString;
	public boolean hasRegistered = false;

	private final NSMutableDictionary<SWFField, Object> fields = new NSMutableDictionary<SWFField, Object>();
	private final NSMutableDictionary<SWFField, NSData> dataFields = new NSMutableDictionary<SWFField, NSData>();

	public String hatesSpamString;
	public String expectedSpamAnswer = "já";

	public SWFOldFormDisplay( WOContext context ) {
		super( context );
	}

	@Override
	protected boolean useDefaultComponentCSS() {
		return true;
	}

	/**
	 * Submits the current form.
	 */
	public WOActionResults submitForm() {

		System.out.println( hatesSpamString );

		if( !expectedSpamAnswer.equalsIgnoreCase( hatesSpamString ) ) {
			errorString = "Í Spam-reit verður að standa \"já\"";
			return context().page();
		}

		if( selectedForm.maxRegistrations() != null && (selectedForm.registrations().count() >= selectedForm.maxRegistrations()) ) {
			errorString = ERROR_MAX;
			return context().page();
		}

		if( !requiredFieldsFilledOut() ) {
			errorString = requiredFieldEmptyString();
			return context().page();
		}

		SWFRegistration registration = SWFUtilities.registrationFromDictionary( ec, selectedForm, fields, dataFields );
		hasRegistered = true;
		registration.sendNotification();

		return context().page();
	}

	/**
	 * Most of our initialization happens here.
	 */
	@Override
	public void appendToResponse( WOResponse r, WOContext c ) {

		if( selectedForm != null ) {
			if( registration.editingContext() == null ) {
				ec.insertObject( registration );

				for( SWFField field : selectedForm.fields() ) {
					String defaultValue = field.defaultValue();

					if( defaultValue != null ) {
						fields.setObjectForKey( defaultValue, field );
					}
				}
			}
		}

		super.appendToResponse( r, c );
	}

	/**
	 * @return The string value for the current field.
	 */
	public String currentString() {
		return (String)fields.objectForKey( currentField );
	}

	/**
	 * Sets the string value for the current field.
	 * 
	 * @param data The data to set
	 */
	public void setCurrentString( String string ) {
		if( USStringUtilities.stringHasValue( string ) ) {
			fields.setObjectForKey( string, currentField );
		}
		else {
			fields.removeObjectForKey( currentField );
		}
	}

	/**
	 * @return The binary data value for the current field.
	 */
	public NSData currentData() {
		return dataFields.objectForKey( currentField );
	}

	/**
	 * Sets the binary data value for the current field.
	 * 
	 * @param data The data to set
	 */
	public void setCurrentData( NSData data ) {
		if( data != null && data.length() > 0 ) {
			dataFields.setObjectForKey( data, currentField );
		}
		else {
			dataFields.removeObjectForKey( currentField );
		}
	}

	/**
	 * @return The string to show if not all required fields are filled out.
	 */
	public String requiredFieldEmptyString() {
		if( selectedForm != null ) {
			if( USStringUtilities.stringHasValue( selectedForm.requiredFieldEmptyString() ) ) {
				return selectedForm.requiredFieldEmptyString();
			}
		}

		return ERROR_REQUIRED;
	}

	/**
	 * @return A boolean indicating if all the required fields have been filled out.
	 */
	private boolean requiredFieldsFilledOut() {
		NSArray<SWFField> req = selectedForm.requiredFields();

		if( !USArrayUtilities.arrayHasObjects( req ) ) {
			return true;
		}

		for( SWFField f : req ) {
			if( fields.objectForKey( f ) == null ) {
				return false;
			}
		}

		return true;
	}
}