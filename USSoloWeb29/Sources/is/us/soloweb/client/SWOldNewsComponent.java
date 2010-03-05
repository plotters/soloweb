package is.us.soloweb.client;

import is.us.soloweb.data.SWNewsItem;
import is.us.util.USTimestampUtilities;

import java.text.SimpleDateFormat;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXEC;

/**
 * Displays newsitems sorted by date. 
 * 
 * @author Hugi Þórðarson
 */

public class SWOldNewsComponent extends SoloNewsNewsList {

	public SimpleDateFormat format = new java.text.SimpleDateFormat( "MMMM yyyy", selectedPage().locale() );
	public NSTimestamp currentMonth;
	public SWNewsItem currentNewsItem;
	private NSArray<SWNewsItem> _allItems;

	public SWOldNewsComponent( WOContext context ) {
		super( context );
	}

	private NSArray<SWNewsItem> allItems() {
		if( _allItems == null ) {
			_allItems = SWNewsItem.fetchSWNewsItems( ERXEC.newEditingContext(), SWNewsItem.FOLDER_ID.eq( folderID() ).and( SWNewsItem.PUBLISHED.eq( 1 ) ), SWNewsItem.DATE.descs() );
		}

		return _allItems;
	}

	/**
	 * All months containing stuff. 
	 */
	public NSArray<NSTimestamp> months() {
		NSMutableArray<NSTimestamp> months = new NSMutableArray<NSTimestamp>();

		for( SWNewsItem n : allItems() ) {

			NSTimestamp beginning = USTimestampUtilities.normalizeTimestampForMonth( n.date() );

			if( !months.containsObject( beginning ) ) {
				months.addObject( beginning );
			}
		}

		return months;
	}

	public NSArray<SWNewsItem> newsitems() {
		NSTimestamp nextMonth = currentMonth.timestampByAddingGregorianUnits( 0, 1, 0, 0, 0, 0 );
		return SWNewsItem.DATE.gte( currentMonth ).and( SWNewsItem.DATE.lt( nextMonth ) ).filtered( allItems() );
	}
}