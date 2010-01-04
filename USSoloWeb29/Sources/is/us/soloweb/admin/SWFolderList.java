package is.us.soloweb.admin;

import is.us.soloweb.SWSession;
import is.us.soloweb.interfaces.SWFolder;
import is.us.soloweb.util.SWAccessPrivilegeUtilities;
import is.us.soloweb.util.SWC;
import is.us.util.USArrayUtilities;
import is.us.util.USHierarchyUtilities;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 */

public class SWFolderList extends SWAdminComponent {

	public SWFolder selectedFolder;
	public SWFolder currentFolder;
	public int currentIndex;

	public SWFolderList( WOContext context ) {
		super( context );
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	/**
	 * FIXME: This is major voodoo. Stop. Doing. This.
	 */
	public NSArray<SWFolder> rootFolders() {
		NSArray<SWFolder> a = NSArray.emptyArray();

		try {
			a = ((SWFolder)Class.forName( className() ).newInstance()).sortedRootFolders( ec() );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}

		a = SWAccessPrivilegeUtilities.filteredArrayWithUserAndPrivilege( a, user(), SWC.PRIVILEGE_ALLOW_TO_SEE );

		return a;
	}

	public boolean isDisabled() {

		if( disabledFolder() != null )
			if( currentFolder.equals( disabledFolder() ) )
				return true;

		if( disabledBranch() != null )
			if( USHierarchyUtilities.isChildOfNode( currentFolder, disabledBranch(), false ) )
				return true;

		return false;
	}

	public WOActionResults selectFolder() {
		setSelectedFolder( currentFolder );

		if( actionName() == null )
			return null;

		return performParentAction( actionName() );
	}

	public String entityName() {
		return (String)valueForBinding( "entityName" );
	}

	public String className() {
		return EOUtilities.entityNamed( ec(), entityName() ).className();
	}

	public String actionName() {
		return (String)valueForBinding( "actionName" );
	}

	public SWFolder disabledFolder() {
		return (SWFolder)valueForBinding( "disabledFolder" );
	}

	public SWFolder disabledBranch() {
		return (SWFolder)valueForBinding( "disabledBranch" );
	}

	public SWFolder selectedFolder() {
		return (SWFolder)valueForBinding( "selectedFolder" );
	}

	public void setSelectedFolder( SWFolder newSelectedFolder ) {
		selectedFolder = newSelectedFolder;
		setValueForBinding( selectedFolder, "selectedFolder" );
	}

	public NSArray<SWFolder> subFolders() {
		if( isExpanded( currentFolder ) )
			return SWAccessPrivilegeUtilities.filteredArrayWithUserAndPrivilege( currentFolder.sortedSubFolders(), user(), SWC.PRIVILEGE_ALLOW_TO_SEE );

		return NSArray.emptyArray();
	}

	/**
	 * Determines if the current branch should be expanded (if subpages should
	 * be displayed)
	 */
	public boolean isExpanded( SWFolder anObject ) {
		return ((SWSession)session()).arrayWithKeyContainsObject( entityName(), anObject );
	}

	/**
	 * Expands the current branch.
	 */
	public void expandBranch( SWFolder anObject ) {
		((SWSession)session()).addObjectToArrayWithKey( anObject, entityName() );
	}

	/**
	 * Collapses the current branch.
	 */
	public void collapseBranch( SWFolder anObject ) {
		((SWSession)session()).removeObjectFromArrayWithKey( anObject, entityName() );
	}

	/**
	 * Determines if the plus sign or the minus sign should be displayed in
	 * front of the current page, based on if it's branch is expanded or not.
	 * Returns the name of the picture to display.
	 */
	public String toggleString() {
		if( hasNoSubFolders() )
			return WOApplication.application().resourceManager().urlForResourceNamed( "spacer.gif", SWC.FRAMEWORK_NAME, null, context().request() );
		else if( isExpanded( currentFolder ) )
			return WOApplication.application().resourceManager().urlForResourceNamed( "minus.gif", SWC.FRAMEWORK_NAME, null, context().request() );
		else
			return WOApplication.application().resourceManager().urlForResourceNamed( "plus.gif", SWC.FRAMEWORK_NAME, null, context().request() );
	}

	/**
	 * Toggles visibility of subfolders.
	 */
	public WOActionResults toggleDisplay() {
		if( isExpanded( currentFolder ) )
			collapseBranch( currentFolder );
		else
			expandBranch( currentFolder );

		return null;
	}

	/**
	 * True if the current folder has no subfolders.
	 */
	public boolean hasNoSubFolders() {
		return !USArrayUtilities.arrayHasObjects( currentFolder.sortedSubFolders() );
	}
}