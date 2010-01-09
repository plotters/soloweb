package is.us.soloweb.util;

import is.us.wo.util.USHTTPUtilities;

import java.io.ByteArrayInputStream;

import org.w3c.tidy.Tidy;

import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSData;

import er.extensions.foundation.ERXRefByteArrayOutputStream;

/**
 * Various utility methods for cleaning up the HTML in HTTP Responses.
 * 
 * @author Hugi Thordarson
 */

public class SWHTMLCleaner {

	/**
	 * TODO: IS there some way to re-use instances of Tidy?
	 */
	public static Tidy tidy() {
		Tidy tidy = new Tidy();

		tidy.setTidyMark( false );
		tidy.setXHTML( true );
		tidy.setBreakBeforeBR( false );
		tidy.setIndentContent( false );
		tidy.setSmartIndent( false );
		tidy.setIndentAttributes( false );
		tidy.setAltText( "" );
		tidy.setQuiet( true );
		tidy.setNumEntities( false );
		tidy.setInputEncoding( "UTF-8" );
		tidy.setOutputEncoding( "UTF-8" );
		//		tidy.setDropProprietaryAttributes( true );

		return tidy;
	}

	/**
	 * Cleans up the HTML in the response with JTidy.
	 * 
	 * Add properties for use when tidying.
	 */
	public static void tidyResponse( WOResponse response ) {
		ByteArrayInputStream in = response.content().stream();
		ERXRefByteArrayOutputStream out = new ERXRefByteArrayOutputStream();
		tidy().parse( in, out );
		NSData data = out.toNSData();
		USHTTPUtilities.setContent( response, data );
	}

	/**
	 * Cleans up the HTML, using the DOM.
	 * 
	 * WARNING: Experimental! Use at your own risk.
	 * 
	 * public static void tidyResponseUsingDOM( WOResponse response ) {
	 * ByteArrayInputStream in = response.content().stream(); Document d =
	 * tidy().parseDOM( in, null );
	 * 
	 * 
	 * // NodeList nl = d.getElementsByTagName( "div" ); // int i =
	 * nl.getLength(); // // while( i > 0 ) { // Node n = nl.item( --i ); //
	 * logger.info( n ); // n.appendChild( d.createTextNode( "YARRRR" ) ); // }
	 * //
	 * 
	 * String prettyPrinted = null;
	 * 
	 * try { prettyPrinted = USUtilities.convertDOMDocumentToString( d ); }
	 * catch( Exception e ) { logger.error(
	 * "Couldnt convert DOM document to string", e ); }
	 * 
	 * response.setContent( prettyPrinted ); }
	 */

	/**
	 * Cleans up the HTML in the string.
	 */
	public static String tidyString( String htmlString ) {
		WOResponse response = new WOResponse();
		response.setContent( htmlString );
		ByteArrayInputStream in = response.content().stream();
		ERXRefByteArrayOutputStream out = new ERXRefByteArrayOutputStream();
		tidy().parse( in, out );
		NSData data = out.toNSData();
		response.setContent( data );
		response.setHeader( String.valueOf( data.length() ), "content-length" );
		return response.contentString();
	}
}