package is.us.soloweb.admin;

import is.us.soloweb.SWSession;
import is.us.soloweb.data.*;
import is.us.soloweb.util.*;
import is.us.util.*;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSArray;

/**
 * Displays all sites in the current SoloWeb system and their subpages in a hierarchical list.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.3
 */

public class SWSiteListing extends SWAdminComponent {

	private static final String PLUS_GIF = "plus.gif";

	private static final String MINUS_GIF = "minus.gif";

	private static final String SPACER_GIF = "spacer.gif";

	/**
	 * The hyperlink around all subpages of this page is disabled, including itself.
	 * null if no pages should be disabled.
	 */
	public SWPage recordToDisableSubPagesOf;

	/**
	 * Index of the current page being iterated over in a repetition (reset for each branch in the hierarchy).
	 */
	public int currentIndex;

	/**
	 * The current site being iterated over in the repetition.
	 */
	public SWSite currentSite;

	/**
	 * The current site being iterated over in the repetition.
	 */
	public SWPage currentPage;

	/**
	 * Name of an action to perform in the parent component when a page is clicked.
	 */
	public String pageAction;

	/**
	 * Name of an access privilege required to have the page active
	 */
	public String requiredPrivilege;

	/**
	 * The selected page.
	 */
	public SWPage selectedPage;

	/**
	 * Determines if arrows to move pages up and down in the site tree should be shown.
	 */
	public boolean showArrows;

	public SWSiteListing( WOContext context ) {
		super( context );
	}

	/**
	 * Selects the current site for editing in an SWEditSite component.
	 */
	public WOActionResults selectSite() {
		return SWUtilities.editObjectInContext( ((SWSession)session()).selectedSite(), context() );
	}

	/**
	 * Selects the current page and performs the action specified in "action"
	 */
	public WOActionResults selectPage() {
		selectedPage = currentPage;
		return performParentAction( pageAction );
	}

	/**
	 * The css class to set for a page link.
	 */
	public String currentClass() {

		if( !currentPage.isAccessible() )
			return SWC.CSS_INACCESSIBLE;

		if( !currentPage.isPublished() )
			return SWC.CSS_UNPUBLISHED;

		return SWC.CSS_PUBLISHED;
	}

	/**
	 * Checks if the current branch is expanded or not, and returns either the
	 * page's subpages, or an empty array, based on that info.
	 */
	public NSArray<SWPage> theSubPages() {
		return isExpanded( currentPage ) ? currentPage.sortedSubPages() : NSArray.EmptyArray;
	}

	/**
	 * Toggles the subpage display status for the current page, if it's subpages should be displayed or not.
	 */
	public WOActionResults toggleBranch() {
		if( isExpanded( currentPage ) )
			collapseBranch( currentPage );
		else
			expandBranch( currentPage );

		return null;
	}

	/**
	 * Determines if the plus sign or the minus sign should be displayed in
	 * front of the current page, based on if it's branch is expanded or not.
	 * Returns the name of the picture to display.
	 */
	public String toggleString() {
		if( currentPage.hasNoSubPages() )
			return WOApplication.application().resourceManager().urlForResourceNamed( SPACER_GIF, SWC.FRAMEWORK_NAME, null, context().request() );

		if( isExpanded( currentPage ) )
			return WOApplication.application().resourceManager().urlForResourceNamed( MINUS_GIF, SWC.FRAMEWORK_NAME, null, context().request() );

		return WOApplication.application().resourceManager().urlForResourceNamed( PLUS_GIF, SWC.FRAMEWORK_NAME, null, context().request() );
	}

	/**
	 * Determines if the link for the current page should be disabled.
	 */
	public boolean pageIsDisabled() {

		if( recordToDisableSubPagesOf != null )
			if( currentPage.isSubPageOfPage( recordToDisableSubPagesOf, true ) )
				return true;

		if( USStringUtilities.stringHasValue( requiredPrivilege ) )
			if( !user().hasPrivilegeFor( currentPage, requiredPrivilege ) )
				return true;

		return false;
	}

	/**
	 * Determines if the link for the current site should be disabled.
	 * It's active only if the current user is an administrator.
	 */
	public boolean siteIsDisabled() {
		if( user() == null )
			return false;

		return !USUtilities.numberIsTrue( user().isAdministrator() );
	}

	/**
	 * Determines if the current branch should be expanded (if subpages should be displayed)
	 */
	private boolean isExpanded( SWPage aPage ) {
		return ((SWSession)session()).arrayWithKeyContainsObject( SWPage.ENTITY_NAME, aPage );
	}

	/**
	 * Expands the current branch.
	 */
	private void expandBranch( SWPage aPage ) {
		((SWSession)session()).addObjectToArrayWithKey( aPage, SWPage.ENTITY_NAME );
	}

	/**
	 * Collapses the current branch.
	 */
	private void collapseBranch( SWPage aPage ) {
		((SWSession)session()).removeObjectFromArrayWithKey( aPage, SWPage.ENTITY_NAME );
	}

	/**
	 * Indicates if the site pop up menu should be shown. 
	 */
	public boolean showSitePopUp() {
		if( user() == null )
			return false;

		return user().sites().count() > 1;
	}
}