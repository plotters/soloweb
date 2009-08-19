package is.us.soloweb.client;

import is.us.soloweb.data.SWDocument;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

/**
 * The SoloWeb Equivalent to WOImage. Takes an SWPicture as an argument and displays it.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.5
 */

public class SWImage extends ERXComponent {

	public SWImage( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public boolean isStateless() {
		return true;
	}

	public SWDocument document() {
		return (SWDocument)valueForBinding( "document" );
	}

	public String url() {
		if( document() == null )
			return null;

		return document().documentURL( context() );
	}
}