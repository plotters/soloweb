package is.us.soloweb.looks;

import is.us.soloweb.SWGenericSiteLook;
import is.us.soloweb.data.SWPage;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWDefaultLook3 extends SWGenericSiteLook {

	public SWPage currentPage;
	public SWPage currentBreadcrumbPage;

	public SWDefaultLook3( WOContext context ) {
		super( context );
	}
}
