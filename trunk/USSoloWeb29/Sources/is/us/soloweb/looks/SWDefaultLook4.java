package is.us.soloweb.looks;

import is.us.soloweb.SWGenericSiteLook;
import is.us.soloweb.data.SWPage;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWDefaultLook4 extends SWGenericSiteLook {

	public SWPage currentPage;
	public SWPage currentBreadcrumbPage;

	public SWDefaultLook4( WOContext context ) {
		super( context );
	}
}
