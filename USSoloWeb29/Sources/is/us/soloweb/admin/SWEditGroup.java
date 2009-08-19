package is.us.soloweb.admin;

import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.SWInspectionComponent;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSArray;

/**
 * Manages Groups and memberships
 * 
 * @author Hugi Þórðarson
 * @version 2.5
 * @since 2.4
 */

public class SWEditGroup extends SWInspectionComponent<SWGroup> {

	/**
	 * The user currently being displayed in the pop-up menu
	 */
	public SWUser currentUser;

	/**
	 * The user currently being displayed in the list of group members
	 */
	public SWUser currentGroupUser;

	/**
	 * The user currently selected in the user pop-up menu
	 */
	public SWUser selectedUser;

	/**
	 * Current index of the table displaying group members. Used for alternating bgcolor
	 */
	public int tableIndex;

	/**
	 * Access privilege currently being iterated through.
	 */
	public SWAccessPrivilege currentPrivilege;

	public SWEditGroup( WOContext context ) {
		super( context );
	}

	/**
	 * All users registered in the SoloWeb system
	 */
	public NSArray<SWUser> allUsers() {
		return SWUser.allUsers( ec() );
	}

	/**
	 * Adds the selected user to the selected group
	 */
	public WOActionResults addUserToGroup() {

		if( selectedUser == null )
			return context().page();

		selectedUser.addObjectToBothSidesOfRelationshipWithKey( selectedObject(), "groups" );

		return saveChanges();
	}

	/**
	 * Removes the current groupUser from the selected group
	 */
	public WOActionResults removeUserFromGroup() {
		currentGroupUser.removeObjectFromBothSidesOfRelationshipWithKey( selectedObject(), "groups" );
		return saveChanges();
	}

	/**
	 * Returns a color for the user rows
	 */
	public String rowClass() {
		return (tableIndex % 2 == 0) ? SWC.CSS_EVEN_ROW : SWC.CSS_ODD_ROW;
	}
}