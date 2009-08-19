package is.us.soloweb.data;

import is.us.soloweb.SoloWeb;
import is.us.util.USEOUtilities;

import java.util.HashMap;

import com.webobjects.eoaccess.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 * 
 * TODO: Perhaps we should be storing the name of deleted objects - just in case.
 * TODO: Symmetrize with SWAccessPrivilege.
 */

public class SWTransaction extends _SWTransaction {

	private Object _record;

	private HashMap<String, String> _actionTypes;

	private HashMap<String, String> actionTypes() {
		if( _actionTypes == null ) {
			_actionTypes = new HashMap<String, String>();
			_actionTypes.put( "D", "Eyða" );
			_actionTypes.put( "I", "Búa til" );
			_actionTypes.put( "U", "Uppfæra" );
		}

		return _actionTypes;
	}

	/**
	 * the entity of the record this privilege applies to. 
	 */
	private EOEntity destinationEntityEntity() {
		return EOUtilities.entityNamed( editingContext(), entityNameString() );
	}

	/**
	 * The object that this transaction refers to. 
	 */
	public Object record() {
		if( _record == null ) {
			_record = USEOUtilities.objectMatchingKeyAndValue( editingContext(), entityNameString(), destinationEntityEntity().primaryKeyAttributeNames().objectAtIndex( 0 ), objectID() );
		}

		return _record;
	}

	/**
	 * Sets the record this transaction applies to. 
	 */
	public void setRecord( Object value ) {
		_record = value;
	}

	/**
	 * The object that this transaction refers to. 
	 */
	public SWUser user() {
		return SWUser.fetchSWUser( editingContext(), SWUser.USER_ID.eq( userID() ) );
	}

	/**
	 * Localized description of the entity this record applies to.
	 */
	public String localizedDescriptionOfEntity() {
		return SoloWeb.sw().localizedNames().get( entityNameString() );
	}

	/**
	 * Localized description of the entity this record applies to.
	 */
	public String localizedDescriptionOfAction() {
		return actionTypes().get( action() );
	}

	public NSDictionary beforeDictionary() {
		return (NSDictionary)NSPropertyListSerialization.propertyListFromString( before() );
	}

	public NSDictionary afterDictionary() {
		return (NSDictionary)NSPropertyListSerialization.propertyListFromString( after() );
	}
}