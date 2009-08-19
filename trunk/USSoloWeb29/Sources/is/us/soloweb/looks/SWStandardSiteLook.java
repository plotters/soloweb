package is.us.soloweb.looks;

import is.us.soloweb.SWGenericSiteLook;

import com.webobjects.appserver.WOContext;

/**
 * The default SiteLook for a SoloWeb site. Returned if no other look is specified for the current site.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2.b4
 * @since 2.3
 */

public class SWStandardSiteLook extends SWGenericSiteLook {

	public SWStandardSiteLook( WOContext context ) {
		super( context );
	}

	@Override
	protected boolean useDefaultComponentCSS() {
		return true;
	}
}