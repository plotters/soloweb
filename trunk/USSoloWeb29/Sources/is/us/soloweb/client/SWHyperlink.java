package is.us.soloweb.client;

import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.util.SWURLGeneration;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWHyperlink extends ERXStatelessComponent {

	public SWHyperlink( WOContext context ) {
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
	public String url() {
		return SWURLGeneration.urlForObjectInContext( object(), context() );
	}
}