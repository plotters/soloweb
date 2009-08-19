package is.us.soloweb.util;

import is.us.soloweb.data.SWExternalUser;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

/**
 * Various utility methods related to user handling.
 *  
 * @author Hugi Þórðarson
 * 
 * FIXME: Use session where possible.
 */

public class SWExternalUserUtilities {

	/**
	 * The key used in the WORequest's userInfo to identify the user.
	 */
	private static final String SW_USER_ID_KEY = "SW_USER_ID_KEY";

	/**
	 * Name of the user cookie.
	 */
	private static final String USER_ID_COOKIE_NAME = "userID";
	private static final String USER_ID_COOKIE_PATH = "/";
	//	private static final String USER_ID_COOKIE_DOMAIN = ".karlmenn.is";
	private static final int USER_ID_COOKIE_LIFETIME_IN_MONTHS = 3;
	private static final int USER_ID_COOKIE_LIFETIME_IN_SECONDS = USER_ID_COOKIE_LIFETIME_IN_MONTHS * 60 * 60 * 24 * 30;

	/**
	 * We attempt to fetch a user based on information retrieved from a cookie.
	 * If no cookie exists, we create a new user object. Hopefully for eventual insertion :-).
	 */
	public static SWExternalUser userFromRequest( EOEditingContext ec, WORequest request ) {

		String userIDFromRequest = readUserIDFromRequest( request );

		if( userIDFromRequest == null )
			return null;

		return SWExternalUser.fetchSWExternalUser( ec, SWExternalUser.UUID.eq( userIDFromRequest ) );
	}

	/**
	 * A cookie with the user ID.
	 */
	public static WOCookie createCookieWithUserID( String userID, String domain ) {
		if( userID != null ) {
			NSTimestamp expires = new NSTimestamp().timestampByAddingGregorianUnits( 0, USER_ID_COOKIE_LIFETIME_IN_MONTHS, 0, 0, 0, 0 );
			WOCookie cookie = new WOCookie( USER_ID_COOKIE_NAME, userID.toString(), USER_ID_COOKIE_PATH, domain, expires, false );
			return cookie;
		}

		return new WOCookie( USER_ID_COOKIE_NAME, null, USER_ID_COOKIE_PATH, domain, USER_ID_COOKIE_LIFETIME_IN_SECONDS, false );
	}

	/**
	 * Writes he value of the cookie to the response.
	 */
	public static void writeUserIDToResponse( String userUUID, WOResponse response, String domain ) {
		WOCookie c = createCookieWithUserID( userUUID, domain );
		response.addCookie( c );
	}

	/**
	 * Writes he value of the cookie to the response.
	 */
	public static void writeUserIDToRequest( String userUUID, WORequest request ) {
		request.setUserInfoForKey( userUUID, SWExternalUserUtilities.SW_USER_ID_KEY );
	}

	/**
	 * Attempts to read a user id from a request.
	 */
	public static String readUserIDFromRequest( WORequest request ) {
		return request.cookieValueForKey( SWExternalUserUtilities.USER_ID_COOKIE_NAME );
	}
}