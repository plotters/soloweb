package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;

import com.webobjects.appserver.WOContext;

/**
 * One of four default component templates for text/picture layout in SoloWeb.
 * This one displays the component heading in H1 size.
 *
 * @author Hugi Þórðarson
 */

public class ButurTemplate001 extends SWGenericComponent {

	public ButurTemplate001( WOContext context ) {
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