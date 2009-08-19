package is.us.soloweb.admin;

import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.SWInspectionComponent;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSArray;

/**
 * For management of users in the SoloWeb system
 *
 * @author Hugi Þórðarson
 * @version 2.5
 * @since 2.5
 */

public class SWEditUser extends SWInspectionComponent<SWUser> {

	/**
	 * The site being iterated over in the pop-up menu
	 */
	public SWSite currentSite;

	/**
	 * The current group being iterated over in the add-group pop-up menu
	 */
	public SWGroup currentGroup;

	/**
	 * The selected group in the add-group pop-up menu
	 */
	public SWGroup selectedGroup;

	/**
	 * The current group being iterated over in the list of groups the selected user is a member of.
	 */
	public SWGroup currentUserGroup;

	/**
	 * Index of the current row being drawn in the member groups list.
	 */
	public int tableIndex;

	/**
	 * Access privilege currently being iterated through.
	 */
	public SWAccessPrivilege currentPrivilege;

	public SWEditUser( WOContext context ) {
		super( context );
	}

	/**
	 * A list of all groups in the system, sorted by name.
	 */
	public NSArray<SWGroup> allGroups() {
		return SWGroup.allGroups( ec() );
	}

	/**
	 * A list of all sites in the system, sorted by name.
	 */
	public NSArray<SWSite> allSites() {
		return SWSite.allSites( ec() );
	}

	/**
	 * Makes the selected user a member of the group selected in the group pop-up menu.
	 */
	public WOActionResults addGroupToUser() {

		if( selectedGroup == null )
			return context().page();

		selectedGroup.addObjectToBothSidesOfRelationshipWithKey( selectedObject(), "users" );

		return saveChanges();
	}

	/**
	 * Removes the current group from the list of this user's groups.
	 */
	public WOActionResults removeGroupFromUser() {
		currentUserGroup.removeObjectFromBothSidesOfRelationshipWithKey( selectedObject(), "users" );
		ec().saveChanges();
		return context().page();
	}

	/**
	 * Determines the color of the current row in the member-group table, based on the tableIndex.
	 */
	public String rowClass() {
		return (tableIndex % 2 == 0) ? SWC.CSS_EVEN_ROW : SWC.CSS_ODD_ROW;
	}
}