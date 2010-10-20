// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWAccessPrivilege.java instead.
package is.us.soloweb.data.auto;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _SWAccessPrivilege extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWAccessPrivilege";

  // Attribute Keys
  public static final ERXKey<Integer> ACCESS_PRIVILEGE_ID = new ERXKey<Integer>("accessPrivilegeID");
  public static final ERXKey<String> DESTINATION_ENTITY = new ERXKey<String>("destinationEntity");
  public static final ERXKey<Integer> DESTINATION_ID = new ERXKey<Integer>("destinationID");
  public static final ERXKey<Integer> GROUP_ID = new ERXKey<Integer>("groupID");
  public static final ERXKey<Integer> NOT_INHERITED = new ERXKey<Integer>("notInherited");
  public static final ERXKey<Integer> USER_ID = new ERXKey<Integer>("userID");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWGroup> GROUP = new ERXKey<is.us.soloweb.data.SWGroup>("group");
  public static final ERXKey<is.us.soloweb.data.SWUser> USER = new ERXKey<is.us.soloweb.data.SWUser>("user");
  public static final ERXKey<is.us.soloweb.data.SWAccessPrivilegeValue> VALUES = new ERXKey<is.us.soloweb.data.SWAccessPrivilegeValue>("values");

  // Attributes
  public static final String ACCESS_PRIVILEGE_ID_KEY = ACCESS_PRIVILEGE_ID.key();
  public static final String DESTINATION_ENTITY_KEY = DESTINATION_ENTITY.key();
  public static final String DESTINATION_ID_KEY = DESTINATION_ID.key();
  public static final String GROUP_ID_KEY = GROUP_ID.key();
  public static final String NOT_INHERITED_KEY = NOT_INHERITED.key();
  public static final String USER_ID_KEY = USER_ID.key();
  // Relationships
  public static final String GROUP_KEY = GROUP.key();
  public static final String USER_KEY = USER.key();
  public static final String VALUES_KEY = VALUES.key();

  private static Logger LOG = Logger.getLogger(_SWAccessPrivilege.class);

  public is.us.soloweb.data.SWAccessPrivilege localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWAccessPrivilege localInstance = (is.us.soloweb.data.SWAccessPrivilege)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer accessPrivilegeID() {
    return (Integer) storedValueForKey(_SWAccessPrivilege.ACCESS_PRIVILEGE_ID_KEY);
  }

  public void setAccessPrivilegeID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating accessPrivilegeID from " + accessPrivilegeID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilege.ACCESS_PRIVILEGE_ID_KEY);
  }

  public String destinationEntity() {
    return (String) storedValueForKey(_SWAccessPrivilege.DESTINATION_ENTITY_KEY);
  }

  public void setDestinationEntity(String value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating destinationEntity from " + destinationEntity() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilege.DESTINATION_ENTITY_KEY);
  }

  public Integer destinationID() {
    return (Integer) storedValueForKey(_SWAccessPrivilege.DESTINATION_ID_KEY);
  }

  public void setDestinationID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating destinationID from " + destinationID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilege.DESTINATION_ID_KEY);
  }

  public Integer groupID() {
    return (Integer) storedValueForKey(_SWAccessPrivilege.GROUP_ID_KEY);
  }

  public void setGroupID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating groupID from " + groupID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilege.GROUP_ID_KEY);
  }

  public Integer notInherited() {
    return (Integer) storedValueForKey(_SWAccessPrivilege.NOT_INHERITED_KEY);
  }

  public void setNotInherited(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating notInherited from " + notInherited() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilege.NOT_INHERITED_KEY);
  }

  public Integer userID() {
    return (Integer) storedValueForKey(_SWAccessPrivilege.USER_ID_KEY);
  }

  public void setUserID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilege.USER_ID_KEY);
  }

  public is.us.soloweb.data.SWGroup group() {
    return (is.us.soloweb.data.SWGroup)storedValueForKey(_SWAccessPrivilege.GROUP_KEY);
  }
  
  public void setGroup(is.us.soloweb.data.SWGroup value) {
    takeStoredValueForKey(value, _SWAccessPrivilege.GROUP_KEY);
  }

  public void setGroupRelationship(is.us.soloweb.data.SWGroup value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
      _SWAccessPrivilege.LOG.debug("updating group from " + group() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setGroup(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWGroup oldValue = group();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWAccessPrivilege.GROUP_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWAccessPrivilege.GROUP_KEY);
    }
  }
  
  public is.us.soloweb.data.SWUser user() {
    return (is.us.soloweb.data.SWUser)storedValueForKey(_SWAccessPrivilege.USER_KEY);
  }
  
  public void setUser(is.us.soloweb.data.SWUser value) {
    takeStoredValueForKey(value, _SWAccessPrivilege.USER_KEY);
  }

  public void setUserRelationship(is.us.soloweb.data.SWUser value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
      _SWAccessPrivilege.LOG.debug("updating user from " + user() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setUser(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWUser oldValue = user();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWAccessPrivilege.USER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWAccessPrivilege.USER_KEY);
    }
  }
  
  public NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> values() {
    return (NSArray<is.us.soloweb.data.SWAccessPrivilegeValue>)storedValueForKey(_SWAccessPrivilege.VALUES_KEY);
  }

  public NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> values(EOQualifier qualifier) {
    return values(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> values(EOQualifier qualifier, boolean fetch) {
    return values(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> values(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWAccessPrivilegeValue.ACCESS_PRIVILEGE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWAccessPrivilegeValue.fetchSWAccessPrivilegeValues(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = values();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWAccessPrivilegeValue>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWAccessPrivilegeValue>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToValues(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    includeObjectIntoPropertyWithKey(object, _SWAccessPrivilege.VALUES_KEY);
  }

  public void removeFromValues(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    excludeObjectFromPropertyWithKey(object, _SWAccessPrivilege.VALUES_KEY);
  }

  public void addToValuesRelationship(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
      _SWAccessPrivilege.LOG.debug("adding " + object + " to values relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToValues(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWAccessPrivilege.VALUES_KEY);
    }
  }

  public void removeFromValuesRelationship(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
      _SWAccessPrivilege.LOG.debug("removing " + object + " from values relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromValues(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWAccessPrivilege.VALUES_KEY);
    }
  }

  public is.us.soloweb.data.SWAccessPrivilegeValue createValuesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWAccessPrivilegeValue.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWAccessPrivilege.VALUES_KEY);
    return (is.us.soloweb.data.SWAccessPrivilegeValue) eo;
  }

  public void deleteValuesRelationship(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWAccessPrivilege.VALUES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllValuesRelationships() {
    Enumeration<is.us.soloweb.data.SWAccessPrivilegeValue> objects = values().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteValuesRelationship(objects.nextElement());
    }
  }


  public static is.us.soloweb.data.SWAccessPrivilege createSWAccessPrivilege(EOEditingContext editingContext, Integer accessPrivilegeID
) {
    is.us.soloweb.data.SWAccessPrivilege eo = (is.us.soloweb.data.SWAccessPrivilege) EOUtilities.createAndInsertInstance(editingContext, _SWAccessPrivilege.ENTITY_NAME);    
		eo.setAccessPrivilegeID(accessPrivilegeID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWAccessPrivilege> fetchAllSWAccessPrivileges(EOEditingContext editingContext) {
    return _SWAccessPrivilege.fetchAllSWAccessPrivileges(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWAccessPrivilege> fetchAllSWAccessPrivileges(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWAccessPrivilege.fetchSWAccessPrivileges(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWAccessPrivilege> fetchSWAccessPrivileges(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWAccessPrivilege> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWAccessPrivilege>(_SWAccessPrivilege.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWAccessPrivilege> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWAccessPrivilege fetchSWAccessPrivilege(EOEditingContext editingContext, String keyName, Object value) {
    return _SWAccessPrivilege.fetchSWAccessPrivilege(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWAccessPrivilege fetchSWAccessPrivilege(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWAccessPrivilege> eoObjects = _SWAccessPrivilege.fetchSWAccessPrivileges(editingContext, qualifier, null);
    is.us.soloweb.data.SWAccessPrivilege eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWAccessPrivilege that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWAccessPrivilege fetchRequiredSWAccessPrivilege(EOEditingContext editingContext, String keyName, Object value) {
    return _SWAccessPrivilege.fetchRequiredSWAccessPrivilege(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWAccessPrivilege fetchRequiredSWAccessPrivilege(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWAccessPrivilege eoObject = _SWAccessPrivilege.fetchSWAccessPrivilege(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWAccessPrivilege that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWAccessPrivilege localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWAccessPrivilege eo) {
    is.us.soloweb.data.SWAccessPrivilege localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
