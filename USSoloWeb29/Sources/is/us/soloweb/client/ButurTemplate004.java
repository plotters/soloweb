package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.data.SWComponent;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.WOContext;

/**
 * One of four default component templates for text/picture layout in SoloWeb
 * This one specifies just text, no picture, aligned to the left in a table of 100% width.
 *
 * @author Hugi Þórðarson
 */

public class ButurTemplate004 extends SWGenericComponent {

	public ButurTemplate004( WOContext context ) {
		super( context );
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public boolean isStateless() {
		return true;
	}
}