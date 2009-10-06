package is.us.soloweb.client;

import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.util.*;
import is.us.wo.util.USHTTPUtilities;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

/**
 * RSS-generator for news in SoloWeb.
 * 
 * @author Hugi Þórðarson
 */

public class SWRSSComponent extends ERXComponent {

	private EOEditingContext _ec;
	public SWNewsItem currentItem;
	private Integer _folderID;
	private Integer _count;
	private String _detailPageName;

	/**
	 * Dates in RSS-feeds are in RFC822 format.
	 */
	public SimpleDateFormat dateFormat = new SimpleDateFormat( "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US );

	public SWRSSComponent( WOContext context ) {
		super( context );
	}

	/**
	 * Set the document's content type to XML.
	 */
	public void appendToResponse( WOResponse r, WOContext c ) {
		r.setHeader( "text/xml", USHTTPUtilities.HEADER_CONTENT_TYPE );
		super.appendToResponse( r, c );
	}

	/**
	 * Our editing context.
	 */
	private EOEditingContext ec() {
		if( _ec == null ) {
			_ec = ERXEC.newEditingContext();
		}

		return _ec;
	}

	public NSArray<SWNewsItem> items() {
		return SWNewsUtilities.recentNewsFromFolderWithID( ec(), count(), categoryID().intValue() );
	}

	/**
	 * @return The URL for the channel. 
	 */
	public String channelLink() {
		return urlPrefix();
	}

	/**
	 * @return The URL for the current item.
	 */
	public String urlString() {
		NSMutableDictionary<String, Object> d = new NSMutableDictionary<String, Object>();
		d.setObjectForKey( detailPageName(), SWC.URL_PAGE_NAME );
		d.setObjectForKey( currentItem.newsItemID(), SWC.URL_NEWS_DETAIL );
		return urlPrefix() + context().directActionURLForActionNamed( SWC.PAGE_DIRECT_ACTION_NAME, d );
	}

	public void setFolderID( Integer newFolderID ) {
		_folderID = newFolderID;
	}

	public Integer categoryID() {
		return _folderID;
	}

	public void setCount( Integer newCount ) {
		_count = newCount;
	}

	public Integer count() {
		return _count;
	}

	public void setDetailPageName( String detailPageName ) {
		_detailPageName = detailPageName;
	}

	public String detailPageName() {
		return _detailPageName;
	}

	/**
	 * The prefix of the newsitem URLs. 
	 */
	private String urlPrefix() {
		return "http://" + USHTTPUtilities.host( context().request() );
	}
}