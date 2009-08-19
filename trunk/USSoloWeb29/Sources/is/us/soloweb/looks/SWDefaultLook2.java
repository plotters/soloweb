package is.us.soloweb.looks;

import is.us.soloweb.SWGenericSiteLook;
import is.us.soloweb.data.SWPage;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWDefaultLook2 extends SWGenericSiteLook {

	public SWPage currentPage;
	public SWPage currentBreadcrumbPage;

	public SWDefaultLook2( WOContext context ) {
		super( context );
	}

	public boolean isSelected() {
		return currentPage.isParentPageOfPage( selectedPage(), true );
	}
}
