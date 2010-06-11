package is.us.soloweb.admin;

import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.util.SWUtilities;

import com.webobjects.appserver.*;

import er.extensions.components.ERXStatelessComponent;

/**
 * Generic stuff editing.
 * 
 * @author Hugi Þórðarson
 */

public class SWObjectHyperlink extends ERXStatelessComponent {

	public SWObjectHyperlink( WOContext context ) {
		super( context );
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