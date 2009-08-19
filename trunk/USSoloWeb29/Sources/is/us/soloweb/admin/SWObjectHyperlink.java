package is.us.soloweb.admin;

import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.util.SWUtilities;

import com.webobjects.appserver.*;

import er.extensions.components.ERXComponent;

/**
 * Generic stuff editing.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.9.4b6
 */

public class SWObjectHyperlink extends ERXComponent {

	public SWObjectHyperlink( WOContext context ) {
		super( context );
	}

	@Override
	public boolean isStateless() {
		return true;
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	/**
	 * The object bound to this link. 
	 */
	public SWInspectable object() {
		return (SWInspectable)valueForBinding( "object" );
	}

	/**
	 * Selects the current object for inspection. 
	 */
	public WOActionResults selectObject() {
		return SWUtilities.editObjectInContext( object(), context() );
	}
}