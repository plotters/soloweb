package is.us.soloweb;

import is.us.soloweb.data.SWNewsItem;
import is.us.util.*;

import com.webobjects.appserver.WOContext;

import er.extensions.eof.ERXEC;

/**
 * SWGenericSiteLook is the common ancestor of all Site Looks created for SoloWeb.
 * Subclass this to create your own custom look component.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b2
 * @since 2.3
 */

public abstract class SWGenericSiteLook extends SWAbstractComponent {

	public SWGenericSiteLook( WOContext context ) {
		super( context );
	}

	/**
	 * Name of the given page.
	 */
	public String pageTitle() {
		SWNewsItem newsItem = selectedItem();

		if( newsItem != null ) {
			return newsItem.name();
		}

		return selectedPage().nameWithPrefix();
	}

	/**
	 * Meta description of the page.
	 */
	public String pageDescription() {
		SWNewsItem newsItem = selectedItem();

		if( newsItem != null ) {
			return selectedItem().excerpt();
		}

		return selectedPage().text();
	}

	/**
	 * The currently selected newsitem.  
	 */
	private SWNewsItem selectedItem() {
		String newsitemIDString = context().request().stringFormValueForKey( "detail" );

		if( USStringUtilities.stringHasValue( newsitemIDString ) ) {
			Integer newsitemID = USUtilities.integerFromObject( newsitemIDString );
			return SWNewsItem.fetchSWNewsItem( ERXEC.newEditingContext(), SWNewsItem.NEWS_ITEM_ID.eq( newsitemID ) );
		}

		return null;
	}
}