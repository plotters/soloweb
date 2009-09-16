package is.us.soloweb;

import com.webobjects.appserver.WOContext;

/**
 * SWGenericSiteLook is the common ancestor of all Site Looks created for SoloWeb.
 * Subclass this to create your own custom look component.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b2
 * @since 2.3
 */

public abstract class SWGenericSiteLook extends SWAbstractComponent {

	public SWGenericSiteLook( WOContext context ) {
		super( context );
	}
}