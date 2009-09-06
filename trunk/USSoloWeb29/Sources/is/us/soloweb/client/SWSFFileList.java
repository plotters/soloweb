package is.us.soloweb.client;

import is.us.soloweb.data.SWDocument;
import is.us.util.USUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.foundation.ERXArrayUtilities;

/**
 * The display component for a list of SWDocuments.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.3
 */

public class SWSFFileList extends SWSFComponent {

	private static final String REVERSE_SORT_ORDER = "reverseSortOrder";

	public SWDocument currentDocument;

	public SWSFFileList( WOContext context ) {
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

	@Override
	protected boolean useDefaultComponentCSS() {
		return true;
	}

	/**
	 * @return the list of documents to show.
	 */
	public NSArray<SWDocument> documents() {

		if( selectedDocument() == null )
			return NSArray.emptyArray();

		NSArray<SWDocument> documents = selectedDocument().folder().sortedDocuments();

		Object o = currentComponent().customInfo().valueForKey( REVERSE_SORT_ORDER );
		Boolean reverseSortOrder = USUtilities.booleanFromObject( o );

		if( reverseSortOrder )
			documents = ERXArrayUtilities.reverse( documents );

		return documents;
	}
}