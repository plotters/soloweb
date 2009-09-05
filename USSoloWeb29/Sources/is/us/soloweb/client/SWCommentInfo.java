package is.us.soloweb.client;

import is.us.soloweb.SWAbstractComponent;
import is.us.soloweb.data.*;
import is.us.util.USArrayUtilities;

import com.webobjects.appserver.WOContext;

/**
 * The component displayed in the news list.
 * 
 * @author Hugi Þórðarson
 */

public class SWCommentInfo extends SWAbstractComponent {

	public SWCommentInfo( WOContext context ) {
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

	public SWNewsItem selectedNewsItem() {
		return (SWNewsItem)valueForBinding( "selectedNewsItem" );
	}

	public SWComment lastComment() {
		return USArrayUtilities.arrayHasObjects( selectedNewsItem().comments() ) ? selectedNewsItem().comments().lastObject() : null;
	}
}