package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.data.SWComponent;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.WOContext;

/**
 * One of four default component templates for text/picture layout in SoloWeb
 * This one specifies left-aligned text with a right aligned picture, 5px spacing, in a table of 100% width.
 *
 * @author Hugi Þórðarson
 */

public class ButurTemplate003 extends SWGenericComponent {

	public ButurTemplate003( WOContext context ) {
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