// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWUser.java instead.
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
public abstract class _SWUser extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWUser";

  // Attribute Keys
  public static final ERXKey<Integer> DEFAULT_SITE_ID = new ERXKey<Integer>("defaultSiteID");
  public static final ERXKey<Integer> IS_ADMINISTRATOR = new ERXKey<Integer>("isAdministrator");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> PASSWORD = new ERXKey<String>("password");
  public static final ERXKey<Integer> USER_ID = new ERXKey<Integer>("userID");
  public static final ERXKey<String> USERNAME = new ERXKey<String>("username");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWAccessPrivilege> ACCESS_PRIVILEGES = new ERXKey<is.us.soloweb.data.SWAccessPrivilege>("accessPrivileges");
  public static final ERXKey<is.us.soloweb.data.SWSite> DEFAULT_SITE = new ERXKey<is.us.soloweb.data.SWSite>("defaultSite");
  public static final ERXKey<is.us.soloweb.data.SWGroup> GROUPS = new ERXKey<is.us.soloweb.data.SWGroup>("groups");

  // Attributes
  public static final String DEFAULT_SITE_ID_KEY = DEFAULT_SITE_ID.key();
  public static final String IS_ADMINISTRATOR_KEY = IS_ADMINISTRATOR.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  public static final String USER_ID_KEY = USER_ID.key();
  public static final String USERNAME_KEY = USERNAME.key();
  // Relationships
  public static final String ACCESS_PRIVILEGES_KEY = ACCESS_PRIVILEGES.key();
  public static final String DEFAULT_SITE_KEY = DEFAULT_SITE.key();
  public static final String GROUPS_KEY = GROUPS.key();

  private static Logger LOG = Logger.getLogger(_SWUser.class);

  public is.us.soloweb.data.SWUser localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWUser localInstance = (is.us.soloweb.data.SWUser)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer defaultSiteID() {
    return (Integer) storedValueForKey(_SWUser.DEFAULT_SITE_ID_KEY);
  }

  public void setDefaultSiteID(Integer value) {
    if (_SWUser.LOG.isDebugEnabled()) {
    	_SWUser.LOG.debug( "updating defaultSiteID from " + defaultSiteID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWUser.DEFAULT_SITE_ID_KEY);
  }

  public Integer isAdministrator() {
    return (Integer) storedValueForKey(_SWUser.IS_ADMINISTRATOR_KEY);
  }

  public void setIsAdministrator(Integer value) {
    if (_SWUser.LOG.isDebugEnabled()) {
    	_SWUser.LOG.debug( "updating isAdministrator from " + isAdministrator() + " to " + value);
    }
    takeStoredValueForKey(value, _SWUser.IS_ADMINISTRATOR_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWUser.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWUser.LOG.isDebugEnabled()) {
    	_SWUser.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWUser.NAME_KEY);
  }

  public String password() {
    return (String) storedValueForKey(_SWUser.PASSWORD_KEY);
  }

  public void setPassword(String value) {
    if (_SWUser.LOG.isDebugEnabled()) {
    	_SWUser.LOG.debug( "updating password from " + password() + " to " + value);
    }
    takeStoredValueForKey(value, _SWUser.PASSWORD_KEY);
  }

  public Integer userID() {
    return (Integer) storedValueForKey(_SWUser.USER_ID_KEY);
  }

  public void setUserID(Integer value) {
    if (_SWUser.LOG.isDebugEnabled()) {
    	_SWUser.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWUser.USER_ID_KEY);
  }

  public String username() {
    return (String) storedValueForKey(_SWUser.USERNAME_KEY);
  }

  public void setUsername(String value) {
    if (_SWUser.LOG.isDebugEnabled()) {
    	_SWUser.LOG.debug( "updating username from " + username() + " to " + value);
    }
    takeStoredValueForKey(value, _SWUser.USERNAME_KEY);
  }

  public is.us.soloweb.data.SWSite defaultSite() {
    return (is.us.soloweb.data.SWSite)storedValueForKey(_SWUser.DEFAULT_SITE_KEY);
  }
  
  public void setDefaultSite(is.us.soloweb.data.SWSite value) {
    takeStoredValueForKey(value, _SWUser.DEFAULT_SITE_KEY);
  }

  public void setDefaultSiteRelationship(is.us.soloweb.data.SWSite value) {
    if (_SWUser.LOG.isDebugEnabled()) {
      _SWUser.LOG.debug("updating defaultSite from " + defaultSite() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDefaultSite(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWSite oldValue = defaultSite();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWUser.DEFAULT_SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWUser.DEFAULT_SITE_KEY);
    }
  }
  
  public NSArray<is.us.soloweb.data.SWAccessPrivilege> accessPrivileges() {
    return (NSArray<is.us.soloweb.data.SWAccessPrivilege>)storedValueForKey(_SWUser.ACCESS_PRIVILEGES_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWAccessPrivilege.USER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _SWUser.ACCESS_PRIVILEGES_KEY);
  }

  public void removeFromAccessPrivileges(is.us.soloweb.data.SWAccessPrivilege object) {
    excludeObjectFromPropertyWithKey(object, _SWUser.ACCESS_PRIVILEGES_KEY);
  }

  public void addToAccessPrivilegesRelationship(is.us.soloweb.data.SWAccessPrivilege object) {
    if (_SWUser.LOG.isDebugEnabled()) {
      _SWUser.LOG.debug("adding " + object + " to accessPrivileges relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAccessPrivileges(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWUser.ACCESS_PRIVILEGES_KEY);
    }
  }

  public void removeFromAccessPrivilegesRelationship(is.us.soloweb.data.SWAccessPrivilege object) {
    if (_SWUser.LOG.isDebugEnabled()) {
      _SWUser.LOG.debug("removing " + object + " from accessPrivileges relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAccessPrivileges(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWUser.ACCESS_PRIVILEGES_KEY);
    }
  }

  public is.us.soloweb.data.SWAccessPrivilege createAccessPrivilegesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWAccessPrivilege.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWUser.ACCESS_PRIVILEGES_KEY);
    return (is.us.soloweb.data.SWAccessPrivilege) eo;
  }

  public void deleteAccessPrivilegesRelationship(is.us.soloweb.data.SWAccessPrivilege object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWUser.ACCESS_PRIVILEGES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAccessPrivilegesRelationships() {
    Enumeration<is.us.soloweb.data.SWAccessPrivilege> objects = accessPrivileges().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAccessPrivilegesRelationship(objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.data.SWGroup> groups() {
    return (NSArray<is.us.soloweb.data.SWGroup>)storedValueForKey(_SWUser.GROUPS_KEY);
  }

  public NSArray<is.us.soloweb.data.SWGroup> groups(EOQualifier qualifier) {
    return groups(qualifier, null);
  }

  public NSArray<is.us.soloweb.data.SWGroup> groups(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<is.us.soloweb.data.SWGroup> results;
      results = groups();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWGroup>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWGroup>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToGroups(is.us.soloweb.data.SWGroup object) {
    includeObjectIntoPropertyWithKey(object, _SWUser.GROUPS_KEY);
  }

  public void removeFromGroups(is.us.soloweb.data.SWGroup object) {
    excludeObjectFromPropertyWithKey(object, _SWUser.GROUPS_KEY);
  }

  public void addToGroupsRelationship(is.us.soloweb.data.SWGroup object) {
    if (_SWUser.LOG.isDebugEnabled()) {
      _SWUser.LOG.debug("adding " + object + " to groups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToGroups(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWUser.GROUPS_KEY);
    }
  }

  public void removeFromGroupsRelationship(is.us.soloweb.data.SWGroup object) {
    if (_SWUser.LOG.isDebugEnabled()) {
      _SWUser.LOG.debug("removing " + object + " from groups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromGroups(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWUser.GROUPS_KEY);
    }
  }

  public is.us.soloweb.data.SWGroup createGroupsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWGroup.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWUser.GROUPS_KEY);
    return (is.us.soloweb.data.SWGroup) eo;
  }

  public void deleteGroupsRelationship(is.us.soloweb.data.SWGroup object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWUser.GROUPS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllGroupsRelationships() {
    Enumeration<is.us.soloweb.data.SWGroup> objects = groups().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteGroupsRelationship(objects.nextElement());
    }
  }


  public static is.us.soloweb.data.SWUser createSWUser(EOEditingContext editingContext, Integer userID
) {
    is.us.soloweb.data.SWUser eo = (is.us.soloweb.data.SWUser) EOUtilities.createAndInsertInstance(editingContext, _SWUser.ENTITY_NAME);    
		eo.setUserID(userID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWUser> fetchAllSWUsers(EOEditingContext editingContext) {
    return _SWUser.fetchAllSWUsers(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWUser> fetchAllSWUsers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWUser.fetchSWUsers(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWUser> fetchSWUsers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWUser> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWUser>(_SWUser.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWUser> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWUser fetchSWUser(EOEditingContext editingContext, String keyName, Object value) {
    return _SWUser.fetchSWUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWUser fetchSWUser(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWUser> eoObjects = _SWUser.fetchSWUsers(editingContext, qualifier, null);
    is.us.soloweb.data.SWUser eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWUser fetchRequiredSWUser(EOEditingContext editingContext, String keyName, Object value) {
    return _SWUser.fetchRequiredSWUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWUser fetchRequiredSWUser(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWUser eoObject = _SWUser.fetchSWUser(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWUser localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWUser eo) {
    is.us.soloweb.data.SWUser localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
