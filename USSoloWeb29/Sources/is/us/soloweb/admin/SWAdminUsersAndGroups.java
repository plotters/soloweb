package is.us.soloweb.admin;

import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.util.SWUtilities;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSArray;

/**
 * For management of users and groups
 *
 * @author Hugi Þórðarson
 * @since 2.3
 */

public class SWAdminUsersAndGroups extends SWAdminComponent {

	/**
	 * The current user being iterated over in the user pop-up menu.
	 */
	public SWInspectable currentObject;

	public SWAdminUsersAndGroups( WOContext context ) {
		super( context );
	}

	/**
	 * Fetches a list of all groups in the SoloWeb system.
	 */
	public NSArray<SWGroup> allGroups() {
		return SWGroup.allGroups( ec() );
	}

	/**
	 * Fetches a list of all users in the SoloWeb system.
	 */
	public NSArray<SWUser> allUsers() {
		return SWUser.allUsers( ec() );
	}

	/**
	 * Creates a new user object and saves it to the database.
	 */
	public WOActionResults createUser() {
		SWUser u = SWUser.create( ec() );
		return SWUtilities.editObjectInContext( u, context() );
	}

	/**
	 * Creates a new group object and saves it to the database.
	 */
	public WOActionResults createGroup() {
		SWGroup g = SWGroup.create( ec() );
		return SWUtilities.editObjectInContext( g, context() );
	}
}