package is.us.soloweb.client;

import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.util.SWURLGeneration;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWHyperlink extends ERXComponent {

	public SWHyperlink( WOContext context ) {
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
	public String url() {
		return SWURLGeneration.urlForObjectInContext( object(), context() );
	}
}