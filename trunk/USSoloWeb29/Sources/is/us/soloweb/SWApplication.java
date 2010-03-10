package is.us.soloweb;

import is.us.soloweb.util.*;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;

import er.extensions.appserver.ERXApplication;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.3
 */

public abstract class SWApplication extends ERXApplication {

	public SWApplication() {
		sw();
	}

	/**
	 * SoloWeb
	 */
	public SoloWeb sw() {
		return SoloWeb.sw();
	}

	public static SWApplication swapplication() {
		return (SWApplication)application();
	}

	public WOResponse dispatchRequest( WORequest request ) {

		String uri = request.uri();

		if( "/favicon.ico".equals( uri ) ) {
			return USHTTPUtilities.response404();
		}

		if( uri.equals( "/sw" ) ) {
			return USHTTPUtilities.redirectTemporary( "/Apps/WebObjects/" + name() + ".woa/wa/login" );
		}

		if( uri.startsWith( "/id/" ) ) {
			String id = uri.substring( 4, uri.length() );
			return USHTTPUtilities.redirectTemporary( "/Apps/WebObjects/" + name() + ".woa/wa/dp?id=" + id );
		}

		if( request.uri().startsWith( "/page/" ) ) {
			String name = uri.substring( 6, uri.length() );
			return USHTTPUtilities.redirectTemporary( "/Apps/WebObjects/" + name() + ".woa/wa/dp?name=" + name );
		}

		WOResponse response = super.dispatchRequest( request );

		String userUUID = SWExternalUserUtilities.readUserIDFromRequest( request );

		if( userUUID == null ) {
			userUUID = java.util.UUID.randomUUID().toString();
		}

		String domain = USHTTPUtilities.domain( request );

		SWExternalUserUtilities.writeUserIDToRequest( userUUID, request );
		SWExternalUserUtilities.writeUserIDToResponse( userUUID, response, domain );

		USHTTPUtilities.resetCookieHeaderInResponse( response );

		if( SWSettings.useTidy( request ) && USHTTPUtilities.contentTypeHTML( response ) ) {
			SWHTMLCleaner.tidyResponse( response );
		}

		if( SWSettings.useGzip( request ) && USHTTPUtilities.supportsGzip( request ) && USHTTPUtilities.contentTypeHTML( response ) ) {
			USHTTPUtilities.compressResponse( response );
		}

		return response;
	}
}