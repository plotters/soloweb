package is.us.soloweb.admin;

import is.us.soloweb.SWSettings;
import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.SWInheritsPrivileges;
import is.us.soloweb.util.*;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * SWAssignPrivileges takes a single EOEnterpriseObject as a binding, and allows the user to set access privileges for it
 *
 * @author Hugi Þórðarson
 * @since 2.7
 */

public class SWAssignPrivileges extends SWAdminComponent {

	/**
	 * The current index of the repetition in the table. Used to calculate the bgcolor for the table row.
	 */
	public int tableIndex;

	/**
	 * The SWAccessPrivilege currently being iterated over.
	 */
	public SWAccessPrivilege currentPrivilege;

	/**
	 * The current user or group being iterated over in the user/group pop-up-menu
	 */
	public EOEnterpriseObject currentObject;

	/**
	 * The EOEnterpriseObject currently being worked on
	 */
	public EOEnterpriseObject record;

	/**
	 * The selected user or group in the user/group pop-up-menu
	 */
	public EOEnterpriseObject selectedObject;

	/**
	 * Indicates if the new privilege should be inherited to the select page's subpages
	 */
	public Integer notInherited;

	/**
	 * Name of the current Privilege value being displayed
	 */
	public String currentFieldHeader;

	/**
	 * Identifier of the current Privilege value being displayed
	 */
	public String currentFieldName;

	/**
	 * The pairs of privilege names and identifiers passed to the component
	 */
	public NSDictionary<String, String> privilegePairs;

	/**
	 * Indicates if the privilegePairs array has been populated or not
	 */
	public boolean hasInitializedPairs = false;

	/**
	 * The array of privilege value headers
	 */
	public NSMutableArray<String> fieldHeaders = new NSMutableArray<String>();

	/**
	 * The array of privilege value identifiers
	 */
	public NSMutableArray<String> fieldNames = new NSMutableArray<String>();

	/**
	 * The dictionary that takes on values for a new privilege
	 */
	public NSMutableDictionary<String, Number> newPrivilegeValues = new NSMutableDictionary<String, Number>();

	public SWAssignPrivileges( WOContext context ) {
		super( context );
	}

	public NSDictionary<String, String> privilegePairs() {
		return privilegePairs;
	}

	public void setPrivilegePairs( NSDictionary<String, String> d ) {
		privilegePairs = d;

		if( !hasInitializedPairs ) {
			Enumeration<String> e = privilegePairs.allKeys().objectEnumerator();

			while( e.hasMoreElements() ) {
				String nextKey = e.nextElement();
				fieldHeaders.addObject( nextKey );
				fieldNames.addObject( (String)privilegePairs.valueForKey( nextKey ) );
				hasInitializedPairs = true;
			}
		}
	}

	public Number currentAddPrivilege() {
		return (Number)newPrivilegeValues.valueForKey( currentFieldName );
	}

	public void setCurrentAddPrivilege( Number newCurrentAddPrivilege ) {
		newPrivilegeValues.takeValueForKey( newCurrentAddPrivilege, currentFieldName );
	}

	public Number currentPrivilegeValue() {
		return (Number)currentPrivilege.valueForKey( currentFieldName );
	}

	public void setCurrentPrivilegeValue( Number newSetCurrentPrivilegeValue ) {
		currentPrivilege.takeValueForKey( newSetCurrentPrivilegeValue, currentFieldName );
	}

	/**
	 * Revokes the current privilege
	 */
	public WOActionResults removePrivilege() {
		ec().deleteObject( currentPrivilege );
		return saveChanges();
	}

	/**
	 * Retrieves all groups in the SoloWeb system sorted by name
	 */
	private NSArray<SWGroup> allGroups() {
		return SWGroup.allGroups( ec() );
	}

	/**
	 * Retrieves all users in the SoloWeb system sorted by name
	 */
	private NSArray<SWUser> allUsers() {
		return SWUser.allUsers( ec() );
	}

	/**
	 * All Users and Groups in the SoloWeb system in a single array.
	 */
	public NSArray<EOEnterpriseObject> allUsersAndGroups() {
		NSMutableArray<EOEnterpriseObject> a = new NSMutableArray<EOEnterpriseObject>();

		a.addObjectsFromArray( allGroups() );

		if( !SWSettings.onlyAllowGrantingOfPrivilegesToGroups() )
			a.addObjectsFromArray( allUsers() );

		return a;
	}

	/**
	 * Adds the current user/group to the page with the selected set of privileges.
	 */
	public WOActionResults addGroupOrUserToPage() {
		if( selectedObject.entityName().equals( SWGroup.ENTITY_NAME ) )
			addPrivilege( selectedObject, "group" );
		else
			addPrivilege( selectedObject, "user" );

		return saveChanges();
	}

	/**
	 * Adds an SWAccessPrivilege with the selectedObject (user or group) to the page
	 *
	 * @param object The User or Group to add
	 * @param relationshipName The name of the relationship to add the object to ("user" or "group")
	 */
	private void addPrivilege( EOEnterpriseObject object, String relationshipName ) {
		SWAccessPrivilege newPrivilege = new SWAccessPrivilege();
		ec().insertObject( newPrivilege );

		newPrivilege.addObjectToBothSidesOfRelationshipWithKey( object, relationshipName );
		newPrivilege.setDestinationID( primaryKey() );
		newPrivilege.setDestinationEntity( record.entityName() );
		newPrivilege.setNotInherited( notInherited );

		Enumeration<String> e = newPrivilegeValues.allKeys().objectEnumerator();

		while( e.hasMoreElements() ) {
			String nextKey = e.nextElement();
			newPrivilege.takeValueForKey( newPrivilegeValues.valueForKey( nextKey ), nextKey );
		}

		newPrivilegeValues = new NSMutableDictionary<String, Number>();
	}

	/**
	 * Determines the color of the current row being drawn, based on the tableIndex variable
	 */
	public String rowClass() {
		return (tableIndex % 2 == 0) ? SWC.CSS_EVEN_ROW : SWC.CSS_ODD_ROW;
	}

	/**
	 * The privileges that belong to this object only
	 */
	public NSArray<SWAccessPrivilege> privileges() {
		return SWAccessPrivilegeUtilities.privilegesForObject( record );
	}

	/**
	 * This object's inherited privileges (if any)
	 */
	public NSArray<SWAccessPrivilege> inheritedPrivileges() {
		if( recordSupportsInheritance() )
			return SWAccessPrivilegeUtilities.inheritedPrivilegesForObject( (SWInheritsPrivileges)record );

		return null;
	}

	/**
	 * Finds and returns the primary key of the selected record
	 */
	private Integer primaryKey() {
		return (Integer)((EOKeyGlobalID)ec().globalIDForObject( record )).keyValuesArray().objectAtIndex( 0 );
	}

	/**
	 * Indicates if the selected record supports privilege inheritance
	 */
	public boolean recordSupportsInheritance() {
		return (record instanceof SWInheritsPrivileges);
	}
}