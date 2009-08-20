package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.util.*;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import java.text.DateFormatSymbols;
import java.util.Locale;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.*;

/**
 * The default news list
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b5
 * @since 2.7
 */

public class SoloNewsNewsList extends SWGenericComponent {

	private static final String VALUE_SORT_KEY_RANDOM = "Random";
	private static final String VALUE_SORT_KEY_ALPHABETICALLY = "Alphabetically";
	private static final String VALUE_SORT_ORDER_ASCENDING = "Ascending";

	private static final String PARAM_CATEGORY = "category";
	private static final String PARAM_DAYS_TO_EXCLUDE = "daysToExclude";
	private static final String PARAM_DAYS_TO_INCLUDE = "daysToInclude";
	private static final String DETAIL_DETAIL_PAGE_ID = "detailPageID";
	private static final String PARAM_VIEW_MODE = "viewMode";
	private static final String PARAM_DETAIL_PAGE_NAME = "detailPageName";
	private static final String PARAM_ITEMS_TO_SHOW = "itemsToShow";
	private static final String PARAM_ITEMS_TO_SKIP = "itemsToSkip";
	private static final String PARAM_SORT_ORDER = "sortOrder";
	private static final String PARAM_SORT_KEY = "sortKey";

	private static final int VALUE_VIEW_MODE_HEADING = 1;
	private static final int VALUE_VIEW_MODE_EXCERPT = 2;
	private static final int VALUE_VIEW_MODE_TEXT = 3;

	private NSArray<SWNewsItem> _newsItems;
	private SWNewsItem _selectedNewsItem;
	public SWNewsItem currentNewsItem;

	public SoloNewsNewsList( WOContext context ) {
		super( context );
	}

	public NSArray<SWNewsItem> newsItems() {
		return _newsItems;
	}

	public void setNewsItems( NSArray<SWNewsItem> a ) {
		_newsItems = a;
	}

	/**
	 * @return the list of news to show on the page.
	 */
	public NSArray<SWNewsItem> newslist() {
		if( USArrayUtilities.arrayHasObjects( newsItems() ) )
			return newsItems();

		return SWNewsUtilities.news( ec(), folderID(), daysToInclude(), daysToExclude(), sortOrdering(), itemsToShow(), itemsToSkip(), randomSort() );
	}

	/**
	 * Indicates if a newsitem is currently selected.
	 */
	public boolean displayDetail() {
		return selectedNewsItem() != null;
	}

	/**
	 * @return The currently selected newsitem.
	 */
	public SWNewsItem selectedNewsItem() {
		String detail = context().request().stringFormValueForKey( SWC.URL_NEWS_DETAIL );

		if( detail != null && _selectedNewsItem == null ) {
			_selectedNewsItem = SWNewsItem.fetchSWNewsItem( ec(), SWNewsItem.NEWS_ITEM_ID.eq( new Integer( detail ) ) );
		}

		return _selectedNewsItem;
	}

	/**
	 * FIXME: Move to consolidated URL-generation. 
	 */
	public String moreURL() {
		return SWURLGeneration.moreURLForNewsItem( context(), currentNewsItem.newsItemID(), selectedPage(), detailPageName(), detailPageID() );
	}

	/**
	 * FIXME: Move to consolidated URL-generation. 
	 */
	public String moreURLIncludingDomain() {
		String domain = USHTTPUtilities.host( context().request() );
		return "http://" + domain + moreURL();
	}

	/**
	 * 
	 */
	private Integer integerValueForKeyWithDefaultValue( String key, Integer defaultValue ) {
		Object o = valueForKeyWithDefaultValue( key, defaultValue );
		return USUtilities.integerFromObject( o );
	}

	/**
	 * 
	 */
	private String stringValueForKeyWithDefaultValue( String key, String defaultValue ) {
		Object o = valueForKeyWithDefaultValue( key, defaultValue );
		return USUtilities.stringFromObject( o );
	}

	/**
	 * 
	 */
	private Object valueForKeyWithDefaultValue( String key, Object defaultValue ) {
		if( currentComponent() == null )
			return defaultValue;

		Object o = currentComponent().customInfo().valueForKey( key );

		if( o == null )
			return defaultValue;

		return o;
	}

	/**
	 * 
	 */
	private NSArray<EOSortOrdering> sortOrdering() {
		return new NSArray<EOSortOrdering>( new EOSortOrdering( sortKey(), sortSelector() ) );
	}

	/**
	 * 
	 */
	private String sortKey() {
		if( VALUE_SORT_KEY_ALPHABETICALLY.equals( stringValueForKeyWithDefaultValue( PARAM_SORT_KEY, null ) ) )
			return SWNewsItem.NAME_KEY;

		return SWNewsItem.DATE_KEY;
	}

	/**
	 * 
	 */
	private NSSelector sortSelector() {
		if( VALUE_SORT_ORDER_ASCENDING.equals( stringValueForKeyWithDefaultValue( PARAM_SORT_ORDER, null ) ) )
			return EOSortOrdering.CompareCaseInsensitiveAscending;

		return EOSortOrdering.CompareCaseInsensitiveDescending;
	}

	public Integer itemsToSkip() {
		return integerValueForKeyWithDefaultValue( PARAM_ITEMS_TO_SKIP, null );
	}

	public Integer itemsToShow() {
		return integerValueForKeyWithDefaultValue( PARAM_ITEMS_TO_SHOW, 10000 );
	}

	public boolean displayLinkOnly() {
		return (integerValueForKeyWithDefaultValue( PARAM_VIEW_MODE, -1 ) == VALUE_VIEW_MODE_HEADING);
	}

	public boolean displayExcerpt() {
		return (integerValueForKeyWithDefaultValue( PARAM_VIEW_MODE, -1 ) == VALUE_VIEW_MODE_EXCERPT);
	}

	public boolean displayText() {
		return (integerValueForKeyWithDefaultValue( PARAM_VIEW_MODE, -1 ) == VALUE_VIEW_MODE_TEXT);
	}

	public String detailPageName() {
		return stringValueForKeyWithDefaultValue( PARAM_DETAIL_PAGE_NAME, null );
	}

	public String detailPageID() {
		return stringValueForKeyWithDefaultValue( DETAIL_DETAIL_PAGE_ID, null );
	}

	public Integer folderID() {
		return integerValueForKeyWithDefaultValue( PARAM_CATEGORY, null );
	}

	public Integer daysToInclude() {
		return integerValueForKeyWithDefaultValue( PARAM_DAYS_TO_INCLUDE, null );
	}

	public Integer daysToExclude() {
		return integerValueForKeyWithDefaultValue( PARAM_DAYS_TO_EXCLUDE, null );
	}

	public boolean randomSort() {
		return VALUE_SORT_KEY_RANDOM.equals( stringValueForKeyWithDefaultValue( PARAM_SORT_KEY, null ) );
	}

	/**
	 * Currently only used in karlmenn.is news detail component.
	 */
	public java.text.Format timestampFormatter() {
		Locale locale = selectedPage().locale();

		if( locale != null ) {
			return new NSTimestampFormatter( "%A %e. %B %Y", new DateFormatSymbols( locale ) );
		}

		return new NSTimestampFormatter( "%d.%m.%Y" );
	}
}