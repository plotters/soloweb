package is.us.soloweb;

import is.us.soloweb.util.SWExternalUserUtilities;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

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
		/*
				if( SWSettings.useTidy( request ) && USHTTPUtilities.contentTypeHTML( response ) ) {
					USHTTPUtilities.tidyResponse( response );
				}
		*/
		//		logger.debug( "req_uri: " + request.uri() );
		//		logger.debug( "req_ip: " + USHTTPUtilities.ipAddressFromRequest( request ) );
		//		logger.debug( "req_useragent: " + USHTTPUtilities.userAgent( request ) );
		//		logger.debug( "resp_h_string: " + response.headers() );
		//		logger.debug( "resp_h_content-encoding: " + USHTTPUtilities.contentEncoding( response ) );
		//		logger.debug( "resp_h_content-type: " + USHTTPUtilities.contentType( response ) );
		//		logger.debug( "resp_h_content-length: " + USHTTPUtilities.contentLength( response ) );
		//		logger.debug( "real_content_length: " + response.content().length() );
		return response;
	}

	public NSArray<String> additionalModels() {
		return NSArray.emptyArray();
	}

	public NSDictionary<String, String> additionalSystems() {
		return NSDictionary.emptyDictionary();
	}

	public NSDictionary<String, String> additionalComponents() {
		return NSDictionary.emptyDictionary();
	}

	public NSDictionary<String, String> additionalSystemsAndComponents() {
		return NSDictionary.emptyDictionary();
	}

	public NSDictionary<String, String> additionalSettingsTabs() {
		return NSDictionary.emptyDictionary();
	}

	public NSDictionary<String, String> additionalPageEditingComponents() {
		return NSDictionary.emptyDictionary();
	}

	public NSDictionary<String, String> additionalSiteEditingComponents() {
		return NSDictionary.emptyDictionary();
	}
}