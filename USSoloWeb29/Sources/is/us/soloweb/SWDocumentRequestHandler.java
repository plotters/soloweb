package is.us.soloweb;

import is.us.soloweb.data.SWDocument;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;

import er.extensions.eof.ERXEC;

/**
 * Handles requests for documents
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.7
 */

public class SWDocumentRequestHandler extends WORequestHandler {

	public static final String KEY = "swdocument";

	/**
	 * Handles the request and returns a corresponding document.
	 */
	public WOResponse handleRequest( WORequest request ) {

		WOResponse response = null;

		String s = request.requestHandlerPath();
		s = s.substring( 0, s.indexOf( "/" ) );
		SWDocument document = SWDocument.documentWithID( ERXEC.newEditingContext(), new Integer( s ) );

		if( document == null ) {
			return USHTTPUtilities.response404();
		}

		response = responseForDocument( document );

		return response;
	}

	/**
	 * Returns the data for this document, wrapped in a WOResponse object.
	 */
	public static WOResponse responseForDocument( SWDocument document ) {
		return USHTTPUtilities.responseWithDataAndMimeType( document.nameForDownload(), document.data(), document.mimeType() );
	}
}