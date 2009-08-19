package is.us.soloweb.client;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.data.SWPage;
import is.us.soloweb.util.SWC;
import is.us.util.USArrayUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

/**
 * A heavily CSS-tagged navigation menu for use in SoloWeb. 
 * Can also be used as a breadcrumbtrail.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.7
 */

public class SWNavigation extends SWGenericComponent {

	private static final String LIST_BINDING = "list";

	private static final String LEVEL_NORMAL = "swLevelNormal";
	private static final String LEVEL_OPEN = "swLevelOpen";
	private static final String LEVEL_CLOSED = "swLevelClosed";
	private static final String LEVEL_SELECTED = "swLevelSelected";
	private static final String LEVEL_FIRST_IN_LIST = "swLevelFirstInList";
	private static final String LEVEL_LAST_IN_LIST = "swLevelLastInList";

	public SWPage currentPage;
	public int currentIndex;

	public SWNavigation( WOContext context ) {
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

	public NSArray<SWPage> list() {
		return (NSArray<SWPage>)valueForBinding( LIST_BINDING );
	}

	public boolean isNotSelected() {
		return currentPage.equals( selectedPage() );
	}

	public String currentClass() {

		StringBuffer b = new StringBuffer();

		if( currentIndex == 0 ) {
			b.append( LEVEL_FIRST_IN_LIST );
			b.append( SWC.SPACE );
		}

		if( currentPage.parentPage() == null || currentIndex == currentPage.parentPage().sortedAndApprovedSubPages().count() - 1 ) {
			b.append( LEVEL_LAST_IN_LIST );
			b.append( SWC.SPACE );
		}

		if( currentPage.equals( selectedPage() ) ) {
			b.append( LEVEL_SELECTED );
			b.append( SWC.SPACE );
		}

		if( USArrayUtilities.arrayHasObjects( currentPage.sortedAndApprovedSubPages() ) ) {
			if( selectedPage().isSubPageOfPage( currentPage, true ) )
				b.append( LEVEL_OPEN );
			else
				b.append( LEVEL_CLOSED );
		}
		else {
			b.append( LEVEL_NORMAL );
		}

		return b.toString();
	}

	public boolean subPageIsSelected() {
		return selectedPage().isSubPageOfPage( currentPage, true );
	}
}