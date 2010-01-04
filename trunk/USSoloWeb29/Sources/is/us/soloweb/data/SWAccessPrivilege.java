package is.us.soloweb.data;

import is.us.soloweb.SoloWeb;
import is.us.soloweb.util.SWC;
import is.us.util.USEOUtilities;
import is.us.util.USUtilities;

import java.util.Enumeration;

import com.webobjects.eoaccess.EOEntity;
import com.webobjects.eoaccess.EOUtilities;

/**
 * An SWAccessPrivilege stores an array of access privileges for a user/group
 * 
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.7
 */

public class SWAccessPrivilege extends _SWAccessPrivilege {

	/**
	 * returns true if this privilege is a user privilege, rather than a group
	 * privilege
	 */
	public boolean isUserPrivilege() {
		return user() != null;
	}

	/**
	 * returns true if this privilege is a group privilege, rather than a user
	 * privilege
	 */
	public boolean isGroupPrivilege() {
		return group() != null;
	}

	/**
	 * Returns the name of the group if this is a group privilege, but user, if
	 * it`s a user privilege
	 */
	public String name() {

		if( isUserPrivilege() )
			return user().name();

		if( isGroupPrivilege() )
			return group().name();

		return null;
	}

	/**
	 * If an unbound key request comes in, it is handled by valueForIdentifier(
	 * String )
	 */
	public Object handleQueryWithUnboundKey( String myKey ) {
		return valueForIdentifier( myKey );
	}

	/**
	 * If a value is set for an unbound key, it is handled by
	 * setValueForIdentifier( Number, String )
	 */
	public void handleTakeValueForUnboundKey( Object myValue, String myKey ) {

		if( myValue instanceof Boolean ) {
			if( ((Boolean)myValue).booleanValue() )
				setValueForIdentifier( SWC.TRUE_INTEGER, myKey );
			else
				setValueForIdentifier( SWC.FALSE_INTEGER, myKey );
		}

		if( myValue instanceof Number ) {
			setValueForIdentifier( USUtilities.integerFromObject( myValue ), myKey );
		}
	}

	/**
	 * Returns the value for the named privilege
	 */
	public Number valueForIdentifier( String identifier ) {
		SWAccessPrivilegeValue apv = privilegeValueForIdentifier( identifier );

		if( apv != null )
			return apv.value();

		return null;
	}

	/**
	 * Sets the value for the named privilege
	 */
	public void setValueForIdentifier( Integer value, String identifier ) {

		SWAccessPrivilegeValue apv = privilegeValueForIdentifier( identifier );

		if( apv == null && USUtilities.numberIsTrue( value ) ) {
			apv = new SWAccessPrivilegeValue();
			editingContext().insertObject( apv );
			apv.addObjectToBothSidesOfRelationshipWithKey( this, "accessPrivilege" );
			apv.setIdentifier( identifier );
			apv.setValue( value );
		}

		if( apv != null && !USUtilities.numberIsTrue( value ) ) {
			editingContext().deleteObject( apv );
		}
	}

	/**
	 * Returns the SWAccessPrivilegeValue object for the named privilege
	 */
	private SWAccessPrivilegeValue privilegeValueForIdentifier( String identifier ) {

		if( identifier.equals( null ) )
			return null;

		Enumeration<SWAccessPrivilegeValue> e = values().objectEnumerator();

		while( e.hasMoreElements() ) {
			SWAccessPrivilegeValue apv = e.nextElement();

			if( identifier.equals( apv.identifier() ) )
				return apv;
		}

		return null;
	}

	/**
	 * the entity of the record this privilege applies to.
	 */
	private EOEntity destinationEntityEntity() {
		return EOUtilities.entityNamed( editingContext(), destinationEntity() );
	}

	/**
	 * The database record that this privilege applies to.
	 */
	public Object record() {
		Object record = USEOUtilities.objectMatchingKeyAndValue( editingContext(), destinationEntity(), destinationEntityEntity().primaryKeyAttributeNames().objectAtIndex( 0 ), destinationID() );
		return record;
	}

	/**
	 * Localized description of the entity this record applies to.
	 */
	public String localizedDescriptionOfEntity() {
		return SoloWeb.sw().localizedNames().get( destinationEntity() );
	}
}