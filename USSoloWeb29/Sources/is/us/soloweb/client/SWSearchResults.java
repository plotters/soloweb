package is.us.soloweb.client;

import is.us.soloweb.SWGenericTemplate;
import is.us.soloweb.data.SWPage;
import is.us.soloweb.util.SWC;
import is.us.util.USArrayUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

/**
 * This is the page returned by SWDirectAction.search().
 *
 * @author Hugi Þórðarson
 * @version 2.8
 * @since 2.4
 */

public class SWSearchResults extends SWGenericTemplate {

	/**
	* All results returned by the search
	*/
	public NSArray<SWPage> results;

	/**
	 * Current page being displayed in the found page list
	 */
	public SWPage currentPage;

	public SWSearchResults( WOContext context ) {
		super( context );
	}

	/**
	 * The search string
	 */
	public String searchString() {
		return context().request().stringFormValueForKey( SWC.URL_SEARCH_STRING );
	}

	/**
	 * Indicates if there was only one result from the search (so we can customize the result string for singular if required).
	 */
	public boolean oneResult() {
		return USArrayUtilities.arrayHasObjects( results ) && results.count() == 1;
	}
}