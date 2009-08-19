// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWAccessPrivilege.java instead.
package is.us.soloweb.data;

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

  public SWAccessPrivilege localInstanceIn(EOEditingContext editingContext) {
    SWAccessPrivilege localInstance = (SWAccessPrivilege)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer accessPrivilegeID() {
    return (Integer) storedValueForKey("accessPrivilegeID");
  }

  public void setAccessPrivilegeID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating accessPrivilegeID from " + accessPrivilegeID() + " to " + value);
    }
    takeStoredValueForKey(value, "accessPrivilegeID");
  }

  public String destinationEntity() {
    return (String) storedValueForKey("destinationEntity");
  }

  public void setDestinationEntity(String value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating destinationEntity from " + destinationEntity() + " to " + value);
    }
    takeStoredValueForKey(value, "destinationEntity");
  }

  public Integer destinationID() {
    return (Integer) storedValueForKey("destinationID");
  }

  public void setDestinationID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating destinationID from " + destinationID() + " to " + value);
    }
    takeStoredValueForKey(value, "destinationID");
  }

  public Integer groupID() {
    return (Integer) storedValueForKey("groupID");
  }

  public void setGroupID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating groupID from " + groupID() + " to " + value);
    }
    takeStoredValueForKey(value, "groupID");
  }

  public Integer notInherited() {
    return (Integer) storedValueForKey("notInherited");
  }

  public void setNotInherited(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating notInherited from " + notInherited() + " to " + value);
    }
    takeStoredValueForKey(value, "notInherited");
  }

  public Integer userID() {
    return (Integer) storedValueForKey("userID");
  }

  public void setUserID(Integer value) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
    	_SWAccessPrivilege.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, "userID");
  }

  public is.us.soloweb.data.SWGroup group() {
    return (is.us.soloweb.data.SWGroup)storedValueForKey("group");
  }
  
  public void setGroup(is.us.soloweb.data.SWGroup value) {
    takeStoredValueForKey(value, "group");
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
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "group");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "group");
    }
  }
  
  public is.us.soloweb.data.SWUser user() {
    return (is.us.soloweb.data.SWUser)storedValueForKey("user");
  }
  
  public void setUser(is.us.soloweb.data.SWUser value) {
    takeStoredValueForKey(value, "user");
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
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "user");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "user");
    }
  }
  
  public NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> values() {
    return (NSArray<is.us.soloweb.data.SWAccessPrivilegeValue>)storedValueForKey("values");
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
        NSMutableArray qualifiers = new NSMutableArray();
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
    includeObjectIntoPropertyWithKey(object, "values");
  }

  public void removeFromValues(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    excludeObjectFromPropertyWithKey(object, "values");
  }

  public void addToValuesRelationship(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    if (_SWAccessPrivilege.LOG.isDebugEnabled()) {
      _SWAccessPrivilege.LOG.debug("adding " + object + " to values relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToValues(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "values");
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
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "values");
    }
  }

  public is.us.soloweb.data.SWAccessPrivilegeValue createValuesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWAccessPrivilegeValue");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "values");
    return (is.us.soloweb.data.SWAccessPrivilegeValue) eo;
  }

  public void deleteValuesRelationship(is.us.soloweb.data.SWAccessPrivilegeValue object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "values");
    editingContext().deleteObject(object);
  }

  public void deleteAllValuesRelationships() {
    Enumeration objects = values().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteValuesRelationship((is.us.soloweb.data.SWAccessPrivilegeValue)objects.nextElement());
    }
  }


  public static SWAccessPrivilege createSWAccessPrivilege(EOEditingContext editingContext, Integer accessPrivilegeID
) {
    SWAccessPrivilege eo = (SWAccessPrivilege) EOUtilities.createAndInsertInstance(editingContext, _SWAccessPrivilege.ENTITY_NAME);    
		eo.setAccessPrivilegeID(accessPrivilegeID);
    return eo;
  }

  public static NSArray<SWAccessPrivilege> fetchAllSWAccessPrivileges(EOEditingContext editingContext) {
    return _SWAccessPrivilege.fetchAllSWAccessPrivileges(editingContext, null);
  }

  public static NSArray<SWAccessPrivilege> fetchAllSWAccessPrivileges(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWAccessPrivilege.fetchSWAccessPrivileges(editingContext, null, sortOrderings);
  }

  public static NSArray<SWAccessPrivilege> fetchSWAccessPrivileges(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWAccessPrivilege.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWAccessPrivilege> eoObjects = (NSArray<SWAccessPrivilege>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWAccessPrivilege fetchSWAccessPrivilege(EOEditingContext editingContext, String keyName, Object value) {
    return _SWAccessPrivilege.fetchSWAccessPrivilege(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWAccessPrivilege fetchSWAccessPrivilege(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWAccessPrivilege> eoObjects = _SWAccessPrivilege.fetchSWAccessPrivileges(editingContext, qualifier, null);
    SWAccessPrivilege eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWAccessPrivilege)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWAccessPrivilege that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWAccessPrivilege fetchRequiredSWAccessPrivilege(EOEditingContext editingContext, String keyName, Object value) {
    return _SWAccessPrivilege.fetchRequiredSWAccessPrivilege(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWAccessPrivilege fetchRequiredSWAccessPrivilege(EOEditingContext editingContext, EOQualifier qualifier) {
    SWAccessPrivilege eoObject = _SWAccessPrivilege.fetchSWAccessPrivilege(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWAccessPrivilege that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWAccessPrivilege localInstanceIn(EOEditingContext editingContext, SWAccessPrivilege eo) {
    SWAccessPrivilege localInstance = (eo == null) ? null : (SWAccessPrivilege)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
