package is.us.soloweb.client;

import is.us.soloweb.data.SWDocument;
import is.us.soloweb.util.SWURLGeneration;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;

/**
 * The SoloWeb Equivalent to WOImage. Takes an SWPicture as an argument and displays it.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.5
 */

public class SWImage extends ERXStatelessComponent {

	public SWImage( WOContext context ) {
		super( context );
	}

	public SWDocument document() {
		return (SWDocument)valueForBinding( "document" );
	}

	public String url() {
		return SWURLGeneration.urlForObjectInContext( document(), context() );
	}
}