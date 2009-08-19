package is.us.soloweb.data;

import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.util.*;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * An SWUser represents a user with access to the SoloWeb system
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.4
 */

public class SWUser extends _SWUser implements SWInspectable {

	/**
	 * All the users in SoloWeb. 
	 */
	public static NSArray<SWUser> allUsers( EOEditingContext ec ) {
		return SWUser.fetchSWUsers( ec, null, NAME.ascInsensitives() );
	}

	/**
	 * Returns all privileges this user has for the specified object, including the group privileges
	 *
	 * @param record The record to work with
	 */
	public NSArray<SWAccessPrivilege> groupPrivileges() {
		NSMutableArray<SWAccessPrivilege> gp = new NSMutableArray<SWAccessPrivilege>();

		for( SWGroup g : groups() ) {
			gp.addObjectsFromArray( g.accessPrivileges() );
		}

		return gp;
	}

	/**
	 * Indicates if the current user is granted the specified privilege
	 *
	 * @param privilegeName The name of the privilege
	 */
	public boolean hasPrivilegeFor( EOEnterpriseObject record, String privilegeName ) {
		return SWAccessPrivilegeUtilities.hasPrivilegeFor( this, record, privilegeName );
	}

	/**
	 * Creates a new user in SoloWeb. 
	 */
	public static SWUser create( EOEditingContext ec ) {
		SWUser user = new SWUser();
		ec.insertObject( user );

		SWGroup g = SWGroup.allUsersGroup( ec );

		if( g != null )
			user.addObjectToBothSidesOfRelationshipWithKey( g, "groups" );

		return user;
	}

	/**
	 * All the sites this user has access to.
	 */
	public NSArray<SWSite> sites() {
		NSArray<SWSite> sites = SWAccessPrivilegeUtilities.filteredArrayWithUserAndPrivilege( SWSite.allSites( editingContext() ), this, SWC.PRIVILEGE_ALLOW_TO_SEE );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( sites, SWSite.NAME.ascInsensitives() );
	}

	/**
	 * Returns a list of all groups, in the system, except those the user is already a member of.
	 */
	public NSArray<SWGroup> groupsNotIn() {
		NSMutableArray<SWGroup> groups = SWGroup.allGroups( editingContext() ).mutableClone();
		groups.removeObjectsInArray( groups() );
		return groups;
	}

	/**
	 * All transactions that this user has ever performed.
	 */
	public NSArray<SWTransaction> transactions() {
		return SWTransaction.fetchSWTransactions( editingContext(), SWTransaction.USER_ID.eq( userID() ), SWTransaction.DATE.descs() );
	}
}