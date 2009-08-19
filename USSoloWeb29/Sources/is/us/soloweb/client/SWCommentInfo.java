package is.us.soloweb.client;

import is.us.soloweb.SWAbstractComponent;
import is.us.soloweb.data.*;
import is.us.util.USArrayUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEC;

/**
 * THe component displayed in the news list.
 * 
 * @author Hugi Þórðarson
 */

public class SWCommentInfo extends SWAbstractComponent {

	private NSArray<SWComment> _allComments;

	public SWCommentInfo( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public SWNewsItem selectedNewsItem() {
		return (SWNewsItem)valueForBinding( "selectedNewsItem" );
	}

	public NSArray<SWComment> allComments() {
		if( _allComments == null ) {
			EOQualifier q = new EOKeyValueQualifier( SWComment.NEWS_ITEM_ID_KEY, EOQualifier.QualifierOperatorEqual, selectedNewsItem().newsItemID() );
			EOFetchSpecification fs = new EOFetchSpecification( SWComment.ENTITY_NAME, q, SWComment.DATE.ascs() );
			_allComments = ERXEC.newEditingContext().objectsWithFetchSpecification( fs );
		}

		return _allComments;
	}

	public SWComment lastComment() {
		return USArrayUtilities.arrayHasObjects( allComments() ) ? (SWComment)allComments().lastObject() : null;
	}
}