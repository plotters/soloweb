package is.us.soloweb.admin;

import is.us.soloweb.data.SWSite;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 */

public class SWMySettings extends SWAdminComponent {

	public SWSite currentSite;

	public SWMySettings( WOContext context ) {
		super( context );
	}

	public NSArray<SWSite> allSites() {
		return SWSite.allSites( ec() );
	}
}
