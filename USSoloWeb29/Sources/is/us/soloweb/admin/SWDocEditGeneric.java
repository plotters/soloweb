package is.us.soloweb.admin;

import is.us.soloweb.data.SWDocument;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 * @since 2.9.2
 */

public abstract class SWDocEditGeneric extends SWAdminComponent {

	private SWDocument _document;

	public SWDocEditGeneric( WOContext context ) {
		super( context );
	}

	public void setDocument( SWDocument newDocument ) {
		_document = newDocument;
	}

	public SWDocument document() {
		return _document;
	}
}
