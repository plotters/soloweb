package is.us.soloweb.forms.fields;

import is.us.soloweb.forms.SWFUtilities;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWFCheckbox extends ERXComponent {

	public SWFCheckbox( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public boolean checked() {
		return SWFUtilities.TRUE_STRING.equals( valueForBinding( "stringValue" ) );
	}

	public void setChecked( boolean newChecked ) {
		if( newChecked )
			setValueForBinding( SWFUtilities.TRUE_STRING, "stringValue" );
		else
			setValueForBinding( SWFUtilities.FALSE_STRING, "stringValue" );
	}
}
