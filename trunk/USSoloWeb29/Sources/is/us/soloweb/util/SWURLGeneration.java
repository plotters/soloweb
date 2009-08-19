package is.us.soloweb.util;

import is.us.soloweb.*;
import is.us.soloweb.data.*;
import is.us.util.USStringUtilities;

import org.slf4j.*;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableDictionary;

/**
 * Class for generating URLs for objects.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.9.2
 */

public class SWURLGeneration {

	private static final Logger logger = LoggerFactory.getLogger( SWURLGeneration.class );

	/**
	 * Generates an URL for the given object in the given context. 
	 */
	public static String urlForObjectInContext( Object object, WOContext context ) {

		if( object == null || context == null )
			return null;

		if( object instanceof SWDocument ) {
			return urlForDocumentInContext( (SWDocument)object, context );
		}
		if( object instanceof SWPage ) {
			return urlForPageInContext( (SWPage)object, context );
		}
		if( object instanceof SWNewsItem ) {
			return urlForNewsItemInContext( (SWNewsItem)object, context );
		}
		else {
			throw new RuntimeException( object.getClass().getName() + " - url generation not implemented for this object type" );
		}
	}

	/**
	 * FIXME: Implement. 
	 */
	private static String urlForNewsItemInContext( SWNewsItem object, WOContext context ) {
		return context.request().uri() + "&detail=" + object.newsItemID();
	}

	/**
	 * Generates an URL for an SWPage-object.
	 * 
	 * TODO: Implement paths in URLs.
	 */
	private static String urlForPageInContext( SWPage page, WOContext context ) {

		String look = context.request().stringFormValueForKey( SWC.URL_LOOK );

		if( !SWSettings.generateFriendlyURLs( context.request() ) || look != null ) {
			NSMutableDictionary<String, Object> d = new NSMutableDictionary<String, Object>();

			if( look != null ) {
				d.setObjectForKey( look, SWC.URL_LOOK );
			}

			d.setObjectForKey( page.pageID(), SWC.URL_PAGE_ID );
			return context.directActionURLForActionNamed( SWC.PAGE_DIRECT_ACTION_NAME, d );
		}

		return "/id/" + page.pageID();
	}

	/**
	 * Attempts to generate an URL for the given document.
	 */
	private static String urlForDocumentInContext( SWDocument document, WOContext context ) {

		String documentName = document.nameForDownload();

		try {
			documentName = java.net.URLEncoder.encode( documentName, SWC.ENCODING_UTF_8 );
		}
		catch( Exception e ) {
			logger.error( "Cannot encode document name for URLs", e );
		}

		return context.urlWithRequestHandlerKey( SWDocumentRequestHandler.KEY, document.documentID() + "/" + documentName, null );
	}

	/**
	 * FIXME: Move to consolidated URL-generation. 
	 */
	public static String moreURLForNewsItem( WOContext context, Integer newsItemID, SWPage selectedPage, String detailPageName, String detailPageID ) {

		NSMutableDictionary<String, Object> d = new NSMutableDictionary<String, Object>( newsItemID, SWC.URL_NEWS_DETAIL );

		if( (detailPageName == null) && (detailPageID == null) && (selectedPage != null) )
			d.setObjectForKey( selectedPage.pageID(), SWC.URL_PAGE_ID );

		if( detailPageName != null )
			d.setObjectForKey( detailPageName, SWC.URL_PAGE_NAME );

		if( detailPageID != null )
			d.setObjectForKey( detailPageID, SWC.URL_PAGE_ID );

		String look = context.request().stringFormValueForKey( SWC.URL_LOOK );

		if( USStringUtilities.stringHasValue( look ) )
			d.setObjectForKey( look, SWC.URL_LOOK );

		return context.directActionURLForActionNamed( SWC.PAGE_DIRECT_ACTION_NAME, d );
	}

}