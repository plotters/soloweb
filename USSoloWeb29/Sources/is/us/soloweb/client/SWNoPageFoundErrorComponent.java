package is.us.soloweb.client;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

/**
 * 404!
 * 
 * @author Hugi Þórðarson
 */

public class SWNoPageFoundErrorComponent extends ERXComponent {

	public SWNoPageFoundErrorComponent( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public boolean isStateless() {
		return true;
	}
}
