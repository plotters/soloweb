package is.us.soloweb.admin;

import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.search.SWGenericSearch;
import is.us.util.USArrayUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

/**
 * The first page in the system.
 * 
 * @author Hugi Þórðarson 
 * @version 2.9.2b6
 * @since 2.9.2b4
 */

public class SWStartPage extends SWAdminComponent {

	public SWNewsItem currentObject;

	public SWStartPage( WOContext context ) {
		super( context );
	}

	public NSArray<? extends SWInspectable> recentlyChanged() {
		return USArrayUtilities.maxObjectsFromArray( SWGenericSearch.recentStuff( ec() ), null );
	}
}
