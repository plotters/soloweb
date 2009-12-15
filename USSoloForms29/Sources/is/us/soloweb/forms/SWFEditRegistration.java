package is.us.soloweb.forms;

import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFRegistration;
import is.us.util.USStringUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSData;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditRegistration extends SWAdminComponent {

	private SWFRegistration _selectedRegistration;
	public SWFField currentField;

	public SWFEditRegistration( WOContext context ) {
		super( context );
	}

	public void setSelectedRegistration( SWFRegistration reg ) {
		_selectedRegistration = reg;
	}

	public SWFRegistration selectedRegistration() {
		return _selectedRegistration;
	}

	public String currentString() {
		return SWFUtilities.valueForFieldAndRegistration( ec(), currentField, selectedRegistration() );
	}

	public String currentStringWithBreaks() {
		return USStringUtilities.convertBreakString( currentString() );
	}

	public void setCurrentString( String newString ) {
		SWFUtilities.setStringValueForFieldAndRegistration( newString, currentField, selectedRegistration() );
		ec().saveChanges();
	}

	public NSData currentData() {
		return SWFUtilities.binaryValueForFieldAndRegistration( ec(), currentField, selectedRegistration() );
	}

	public void setCurrentData( NSData newData ) {
		SWFUtilities.setBinaryValueForFieldAndRegistration( newData, currentField, selectedRegistration() );
		ec().saveChanges();
	}
}