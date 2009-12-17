package is.us.soloweb.forms;

import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFRegistration;
import is.us.soloweb.interfaces.SWInspectionComponent;
import is.us.util.USStringUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSData;

/**
 * For editing a single SWRegistration.
 * 
 * @author Hugi Þórðarson
 */

public class SWFEditRegistration extends SWInspectionComponent<SWFRegistration> {

	public SWFField currentField;

	public SWFEditRegistration( WOContext context ) {
		super( context );
	}

	public String currentString() {
		return SWFUtilities.valueForFieldAndRegistration( ec(), currentField, selectedObject() );
	}

	public String currentStringWithBreaks() {
		return USStringUtilities.convertBreakString( currentString() );
	}

	public void setCurrentString( String newString ) {
		SWFUtilities.setStringValueForFieldAndRegistration( newString, currentField, selectedObject() );
		ec().saveChanges();
	}

	public NSData currentData() {
		return SWFUtilities.binaryValueForFieldAndRegistration( ec(), currentField, selectedObject() );
	}

	public void setCurrentData( NSData newData ) {
		SWFUtilities.setBinaryValueForFieldAndRegistration( newData, currentField, selectedObject() );
		ec().saveChanges();
	}
}