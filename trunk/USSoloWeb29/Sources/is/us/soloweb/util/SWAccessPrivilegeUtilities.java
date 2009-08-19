package is.us.soloweb.util;

import is.us.soloweb.*;
import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.*;
import is.us.util.*;

import java.util.Enumeration;

import com.webobjects.appserver.WOSession;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * A utility class for working with access privileges
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.7
 */

public class SWAccessPrivilegeUtilities extends Object {

	/**
	 * Gets all privileges for the given object.
	 */
	public static NSArray<SWAccessPrivilege> privilegesForObjectAndUser( EOEnterpriseObject record, SWUser user ) {

		NSSet<SWAccessPrivilege> userSet = new NSSet<SWAccessPrivilege>( user.accessPrivileges() );
		NSSet<SWAccessPrivilege> groupSet = new NSSet<SWAccessPrivilege>( user.groupPrivileges() );
		NSSet<SWAccessPrivilege> recordSet = new NSSet<SWAccessPrivilege>( SWAccessPrivilegeUtilities.privilegesIncludingInheritedPrivilegesForObject( record ) );
		NSSet<SWAccessPrivilege> allSet = userSet.setByUnioningSet( groupSet ).setByIntersectingSet( recordSet );

		NSArray<SWAccessPrivilege> allArray = allSet.allObjects();

		return allArray;
	}

	/**
	 * Returns an array containing privileges specified for the specified object (does not include inherited privileges)
	 */
	public static NSArray<SWAccessPrivilege> privilegesForObject( EOEnterpriseObject record ) {
		EOEditingContext ec = record.editingContext();
		Number primaryKey = (Number)((EOKeyGlobalID)ec.globalIDForObject( record )).keyValuesArray().objectAtIndex( 0 );

		EOQualifier q1 = new EOKeyValueQualifier( SWAccessPrivilege.DESTINATION_ENTITY_KEY, EOQualifier.QualifierOperatorEqual, record.entityName() );
		EOQualifier q2 = new EOKeyValueQualifier( SWAccessPrivilege.DESTINATION_ID_KEY, EOQualifier.QualifierOperatorEqual, primaryKey );
		NSArray<EOQualifier> qualArray = new NSArray<EOQualifier>( new EOQualifier[] { q1, q2 } );
		EOQualifier andQual = new EOAndQualifier( qualArray );
		EOFetchSpecification fs = new EOFetchSpecification( SWAccessPrivilege.ENTITY_NAME, andQual, null );

		return ec.objectsWithFetchSpecification( fs );
	}

	/**
	 * Returns an array containing all inherited privileges for the specified object
	 */
	public static NSArray<SWAccessPrivilege> inheritedPrivilegesForObject( SWInheritsPrivileges record ) {

		EOEnterpriseObject parent = record.inheritsPrivilegesFrom();

		if( parent == null )
			return NSArray.emptyArray();

		NSMutableArray<SWAccessPrivilege> allParentPrivileges = privilegesIncludingInheritedPrivilegesForObject( parent ).mutableClone();
		Enumeration<SWAccessPrivilege> e = allParentPrivileges.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWAccessPrivilege nextPrivilege = e.nextElement();

			if( nextPrivilege != null )
				if( USUtilities.numberIsTrue( nextPrivilege.notInherited() ) )
					allParentPrivileges.removeObject( nextPrivilege );
		}

		return allParentPrivileges;
	}

	/**
	 * Returns an array containing all privileges and inherited privileges for the specified object
	 */
	public static NSArray<SWAccessPrivilege> privilegesIncludingInheritedPrivilegesForObject( EOEnterpriseObject record ) {

		NSArray<SWAccessPrivilege> localPrivileges = SWAccessPrivilegeUtilities.privilegesForObject( record );

		if( record instanceof SWInheritsPrivileges )
			if( USUtilities.numberIsTrue( ((SWInheritsPrivileges)record).inheritsPrivileges() ) )
				return localPrivileges.arrayByAddingObjectsFromArray( inheritedPrivilegesForObject( ((SWInheritsPrivileges)record) ) );

		return localPrivileges;
	}

	/**
	 * TODO: This should not be like this. (superuser is always null)
	 */
	public static NSArray filteredArrayWithUserAndPrivilege( NSArray a, SWUser aUser, String privilegeName ) {

		if( USArrayUtilities.arrayHasObjects( a ) ) {
			Enumeration e = a.objectEnumerator();
			NSMutableArray b = new NSMutableArray();

			while( e.hasMoreElements() ) {
				EOEnterpriseObject nextCategory = (EOEnterpriseObject)e.nextElement();

				if( aUser == null || aUser.hasPrivilegeFor( nextCategory, SWC.PRIVILEGE_ALLOW_TO_SEE ) )
					b.addObject( nextCategory );
			}

			return b;
		}

		return NSArray.EmptyArray;
	}

	/**
	 * Returns applicable privileges for the given object. 
	 */
	public static NSMutableDictionary<String, String> privilegePairsForObject( Object object, WOSession session ) {
		if( object instanceof SWFolder ) {
			NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
			d.setObjectForKey( SWC.PRIVILEGE_ALLOW_TO_SEE, SWLoc.string( "docpSeeFolders", session ) );
			d.setObjectForKey( SWC.PRIVILEGE_CAN_MANAGE_USERS, SWLoc.string( "docpManagePrivileges", session ) );
			return d;
		}

		if( object instanceof SWPage ) {
			NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
			d.setObjectForKey( SWC.PRIVILEGE_CAN_DELETE_PAGE, SWLoc.string( "ppDeletePages", session ) );
			d.setObjectForKey( SWC.PRIVILEGE_CAN_MANAGE_PAGE, SWLoc.string( "ppModifyPage", session ) );
			d.setObjectForKey( SWC.PRIVILEGE_CAN_MANAGE_CONTENT, SWLoc.string( "ppModifyContent", session ) );
			d.setObjectForKey( SWC.PRIVILEGE_CAN_MANAGE_USERS, SWLoc.string( "ppControlPrivileges", session ) );
			return d;
		}

		if( object instanceof SWSite ) {
			NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
			d.setObjectForKey( SWC.PRIVILEGE_ALLOW_TO_SEE, SWLoc.string( "spHasAccess", session ) );
			return d;
		}

		return null;
	}

	/**
	 * Indicates if the current user is granted the specified privilege
	 *
	 * @param privilegeName The name of the privilege
	 */
	public static boolean hasPrivilegeFor( SWUser user, EOEnterpriseObject record, String privilegeName ) {

		if( !SWSettings.privilegesEnabled() )
			return true;

		if( USUtilities.numberIsTrue( user.isAdministrator() ) )
			return true;

		Enumeration<SWAccessPrivilege> e = privilegesForObjectAndUser( record, user ).objectEnumerator();

		while( e.hasMoreElements() ) {
			SWAccessPrivilege p = e.nextElement();

			if( USUtilities.numberIsTrue( (Number)p.valueForKey( privilegeName ) ) )
				return true;
		}

		return false;
	}
}