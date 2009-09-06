package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.data.SWDocument;
import is.us.util.USUtilities;

import com.webobjects.appserver.WOContext;

/**
 * The display component for a single SWDocument.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2.b3
 * @since 2.3
 */

public class SWSFComponent extends SWGenericComponent {

	private static final String DOCUMENT_ID = "documentID";

	public SWSFComponent( WOContext c ) {
		super( c );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public boolean isStateless() {
		return true;
	}

	/**
	 * @return the selected document.
	 */
	public SWDocument selectedDocument() {
		Object o = currentComponent().customInfo().valueForKey( DOCUMENT_ID );
		Integer i = USUtilities.integerFromObject( o );
		SWDocument d = SWDocument.documentWithID( ec(), i );
		return d;
	}
}