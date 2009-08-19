package is.us.soloweb.forms;

import is.us.soloweb.forms.data.*;
import is.us.util.USStringUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWFPrintableRegistration extends ERXComponent {

	public SWFRegistration selectedRegistration;
	public SWFField currentField;
	public EOEditingContext ec = session().defaultEditingContext();
	public NSArray<SWFField> fieldList;

	public SWFPrintableRegistration( WOContext context ) {
		super( context );
	}

	public String colspan() {
		return USStringUtilities.stringHasValue( currentField.name() ) ? "1" : "2";
	}

	public String currentString() {
		String string = SWFUtilities.valueForFieldAndRegistration( ec, currentField, selectedRegistration );
		return USStringUtilities.convertBreakString( string );
	}

	public NSArray<SWFField> fieldList() {
		return fieldList;
	}

	public void setFieldList( NSArray<SWFField> newFieldList ) {
		fieldList = newFieldList;
	}
}
