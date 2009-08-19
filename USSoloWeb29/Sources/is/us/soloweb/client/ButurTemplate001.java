package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.data.SWComponent;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.WOContext;

/**
 * One of four default component templates for text/picture layout in SoloWeb.
 * This one displays the component heading in H1 size.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 1.4
 */

public class ButurTemplate001 extends SWGenericComponent {

	public ButurTemplate001( WOContext context ) {
		super( context );
	}

	public SWComponent currentComponent() {
		return (SWComponent)valueForBinding( SWC.CURRENT_COMPONENT );
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public boolean isStateless() {
		return true;
	}
}