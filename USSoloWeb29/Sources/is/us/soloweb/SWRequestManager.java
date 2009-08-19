package is.us.soloweb;

import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 */

public class SWRequestManager {

	private static SWRequestManager _singleton;

	/**
	 * It's a singleton.
	 */
	private SWRequestManager() {}

	/**
	 * Creates our default transaction manager. 
	 */
	public static SWRequestManager singleton() {
		if( _singleton == null ) {
			_singleton = new SWRequestManager();
		}

		return _singleton;
	}

	/**
	 * Registers the transaction manager so it starts listening and watching transactions.
	 */
	public static void register() {
		NSSelector<SWRequestManager> selector1 = new NSSelector<SWRequestManager>( "willDispatchRequest", new Class[] { NSNotification.class } );
		NSNotificationCenter.defaultCenter().addObserver( singleton(), selector1, WOApplication.ApplicationWillDispatchRequestNotification, null );

		NSSelector<SWRequestManager> selector2 = new NSSelector<SWRequestManager>( "didDispatchRequest", new Class[] { NSNotification.class } );
		NSNotificationCenter.defaultCenter().addObserver( singleton(), selector2, WOApplication.ApplicationDidDispatchRequestNotification, null );
	}

	/**
	 * 
	 */
	public void willDispatchRequest( NSNotification notification ) {
		WORequest request = (WORequest)notification.object();
		USHTTPUtilities.removeNullCookies( request );
	}

	/**
	 * 
	 */
	public void didDispatchRequest( NSNotification notification ) {
		WOResponse response = (WOResponse)notification.object();
		SoloWeb.sw().incrementNumberOfRequestsSinceStartup();
		SoloWeb.sw().incrementNumberOfServedBytesSinceStartup( response.content().length() );
	}
}