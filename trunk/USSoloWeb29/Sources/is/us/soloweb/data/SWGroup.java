package is.us.soloweb.data;

import is.us.soloweb.SWSettings;
import is.us.soloweb.interfaces.SWInspectable;
import is.us.util.USEOUtilities;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

/**
 * An SWGroup represents a group of users with access to the SoloWeb system
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.4
 */

public class SWGroup extends _SWGroup implements SWInspectable {

	/**
	 * All the users in SoloWeb. 
	 */
	public static NSArray<SWGroup> allGroups( EOEditingContext ec ) {
		return SWGroup.fetchSWGroups( ec, null, NAME.ascInsensitives() );
	}

	/**
	 * The group that contains all users. 
	 */
	public static SWGroup allUsersGroup( EOEditingContext ec ) {
		return (SWGroup)USEOUtilities.objectMatchingKeyAndValue( ec, SWGroup.ENTITY_NAME, SWGroup.GROUP_ID_KEY, SWSettings.allUsersGroupID() );
	}

	/**
	 * Creates a new SWGroup and inserts into ec. 
	 */
	public static SWGroup create( EOEditingContext ec ) {
		SWGroup g = new SWGroup();
		ec.insertObject( g );
		return g;
	}

	/**
	 * Returns an array of all users, excluding users registered in this group
	 */
	public NSArray<SWUser> usersNotInGroup() {
		NSMutableArray<SWUser> users = SWUser.allUsers( editingContext() ).mutableClone();
		users.removeObjectsInArray( users() );
		return users;
	}
}