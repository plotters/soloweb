package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;

import com.webobjects.appserver.WOContext;

/**
 * One of four default component templates for text/picture layout in SoloWeb
 * This one specifies left-aligned text with a left aligned picture, 5px spacing, in a table of 100% width.
 *
 * @author Hugi Þórðarson
 */

public class ButurTemplate002 extends SWGenericComponent {

	public ButurTemplate002( WOContext context ) {
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