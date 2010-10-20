// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWGroup.java instead.
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
public abstract class _SWGroup extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWGroup";

  // Attribute Keys
  public static final ERXKey<Integer> GROUP_ID = new ERXKey<Integer>("groupID");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWAccessPrivilege> ACCESS_PRIVILEGES = new ERXKey<is.us.soloweb.data.SWAccessPrivilege>("accessPrivileges");
  public static final ERXKey<is.us.soloweb.data.SWUser> USERS = new ERXKey<is.us.soloweb.data.SWUser>("users");

  // Attributes
  public static final String GROUP_ID_KEY = GROUP_ID.key();
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String ACCESS_PRIVILEGES_KEY = ACCESS_PRIVILEGES.key();
  public static final String USERS_KEY = USERS.key();

  private static Logger LOG = Logger.getLogger(_SWGroup.class);

  public is.us.soloweb.data.SWGroup localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWGroup localInstance = (is.us.soloweb.data.SWGroup)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer groupID() {
    return (Integer) storedValueForKey(_SWGroup.GROUP_ID_KEY);
  }

  public void setGroupID(Integer value) {
    if (_SWGroup.LOG.isDebugEnabled()) {
    	_SWGroup.LOG.debug( "updating groupID from " + groupID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWGroup.GROUP_ID_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWGroup.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWGroup.LOG.isDebugEnabled()) {
    	_SWGroup.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWGroup.NAME_KEY);
  }

  public NSArray<is.us.soloweb.data.SWAccessPrivilege> accessPrivileges() {
    return (NSArray<is.us.soloweb.data.SWAccessPrivilege>)storedValueForKey(_SWGroup.ACCESS_PRIVILEGES_KEY);
  }

  public NSArray<is.us.soloweb.data.SWAccessPrivilege> accessPrivileges(EOQualifier qualifier) {
    return accessPrivileges(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWAccessPrivilege> accessPrivileges(EOQualifier qualifier, boolean fetch) {
    return accessPrivileges(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWAccessPrivilege> accessPrivileges(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWAccessPrivilege> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWAccessPrivilege.GROUP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWAccessPrivilege.fetchSWAccessPrivileges(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = accessPrivileges();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWAccessPrivilege>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWAccessPrivilege>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToAccessPrivileges(is.us.soloweb.data.SWAccessPrivilege object) {
    includeObjectIntoPropertyWithKey(object, _SWGroup.ACCESS_PRIVILEGES_KEY);
  }

  public void removeFromAccessPrivileges(is.us.soloweb.data.SWAccessPrivilege object) {
    excludeObjectFromPropertyWithKey(object, _SWGroup.ACCESS_PRIVILEGES_KEY);
  }

  public void addToAccessPrivilegesRelationship(is.us.soloweb.data.SWAccessPrivilege object) {
    if (_SWGroup.LOG.isDebugEnabled()) {
      _SWGroup.LOG.debug("adding " + object + " to accessPrivileges relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAccessPrivileges(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWGroup.ACCESS_PRIVILEGES_KEY);
    }
  }

  public void removeFromAccessPrivilegesRelationship(is.us.soloweb.data.SWAccessPrivilege object) {
    if (_SWGroup.LOG.isDebugEnabled()) {
      _SWGroup.LOG.debug("removing " + object + " from accessPrivileges relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAccessPrivileges(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWGroup.ACCESS_PRIVILEGES_KEY);
    }
  }

  public is.us.soloweb.data.SWAccessPrivilege createAccessPrivilegesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWAccessPrivilege.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWGroup.ACCESS_PRIVILEGES_KEY);
    return (is.us.soloweb.data.SWAccessPrivilege) eo;
  }

  public void deleteAccessPrivilegesRelationship(is.us.soloweb.data.SWAccessPrivilege object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWGroup.ACCESS_PRIVILEGES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAccessPrivilegesRelationships() {
    Enumeration<is.us.soloweb.data.SWAccessPrivilege> objects = accessPrivileges().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAccessPrivilegesRelationship(objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.data.SWUser> users() {
    return (NSArray<is.us.soloweb.data.SWUser>)storedValueForKey(_SWGroup.USERS_KEY);
  }

  public NSArray<is.us.soloweb.data.SWUser> users(EOQualifier qualifier) {
    return users(qualifier, null);
  }

  public NSArray<is.us.soloweb.data.SWUser> users(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<is.us.soloweb.data.SWUser> results;
      results = users();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWUser>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWUser>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToUsers(is.us.soloweb.data.SWUser object) {
    includeObjectIntoPropertyWithKey(object, _SWGroup.USERS_KEY);
  }

  public void removeFromUsers(is.us.soloweb.data.SWUser object) {
    excludeObjectFromPropertyWithKey(object, _SWGroup.USERS_KEY);
  }

  public void addToUsersRelationship(is.us.soloweb.data.SWUser object) {
    if (_SWGroup.LOG.isDebugEnabled()) {
      _SWGroup.LOG.debug("adding " + object + " to users relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToUsers(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWGroup.USERS_KEY);
    }
  }

  public void removeFromUsersRelationship(is.us.soloweb.data.SWUser object) {
    if (_SWGroup.LOG.isDebugEnabled()) {
      _SWGroup.LOG.debug("removing " + object + " from users relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromUsers(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWGroup.USERS_KEY);
    }
  }

  public is.us.soloweb.data.SWUser createUsersRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWUser.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWGroup.USERS_KEY);
    return (is.us.soloweb.data.SWUser) eo;
  }

  public void deleteUsersRelationship(is.us.soloweb.data.SWUser object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWGroup.USERS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllUsersRelationships() {
    Enumeration<is.us.soloweb.data.SWUser> objects = users().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteUsersRelationship(objects.nextElement());
    }
  }


  public static is.us.soloweb.data.SWGroup createSWGroup(EOEditingContext editingContext, Integer groupID
) {
    is.us.soloweb.data.SWGroup eo = (is.us.soloweb.data.SWGroup) EOUtilities.createAndInsertInstance(editingContext, _SWGroup.ENTITY_NAME);    
		eo.setGroupID(groupID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWGroup> fetchAllSWGroups(EOEditingContext editingContext) {
    return _SWGroup.fetchAllSWGroups(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWGroup> fetchAllSWGroups(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWGroup.fetchSWGroups(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWGroup> fetchSWGroups(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWGroup> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWGroup>(_SWGroup.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWGroup> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWGroup fetchSWGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _SWGroup.fetchSWGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWGroup fetchSWGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWGroup> eoObjects = _SWGroup.fetchSWGroups(editingContext, qualifier, null);
    is.us.soloweb.data.SWGroup eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWGroup fetchRequiredSWGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _SWGroup.fetchRequiredSWGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWGroup fetchRequiredSWGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWGroup eoObject = _SWGroup.fetchSWGroup(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWGroup localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWGroup eo) {
    is.us.soloweb.data.SWGroup localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
