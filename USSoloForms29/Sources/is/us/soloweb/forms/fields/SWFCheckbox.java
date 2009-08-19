package is.us.soloweb.forms.fields;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWFCheckbox extends ERXComponent {

	public static final String TRUE_STRING = "TRUE";
	public static final String FALSE_STRING = "FALSE";

	public SWFCheckbox( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public boolean checked() {
		return TRUE_STRING.equals( valueForBinding( "stringValue" ) );
	}

	public void setChecked( boolean newChecked ) {
		if( newChecked )
			setValueForBinding( TRUE_STRING, "stringValue" );
		else
			setValueForBinding( FALSE_STRING, "stringValue" );
	}
}
