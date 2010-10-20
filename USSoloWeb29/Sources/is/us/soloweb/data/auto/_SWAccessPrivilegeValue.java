// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWAccessPrivilegeValue.java instead.
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
public abstract class _SWAccessPrivilegeValue extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWAccessPrivilegeValue";

  // Attribute Keys
  public static final ERXKey<Integer> ACCESS_PRIVILEGE_ID = new ERXKey<Integer>("accessPrivilegeID");
  public static final ERXKey<Integer> ACCESS_PRIVILEGE_VALUE_ID = new ERXKey<Integer>("accessPrivilegeValueID");
  public static final ERXKey<String> IDENTIFIER = new ERXKey<String>("identifier");
  public static final ERXKey<Integer> VALUE = new ERXKey<Integer>("value");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWAccessPrivilege> ACCESS_PRIVILEGE = new ERXKey<is.us.soloweb.data.SWAccessPrivilege>("accessPrivilege");

  // Attributes
  public static final String ACCESS_PRIVILEGE_ID_KEY = ACCESS_PRIVILEGE_ID.key();
  public static final String ACCESS_PRIVILEGE_VALUE_ID_KEY = ACCESS_PRIVILEGE_VALUE_ID.key();
  public static final String IDENTIFIER_KEY = IDENTIFIER.key();
  public static final String VALUE_KEY = VALUE.key();
  // Relationships
  public static final String ACCESS_PRIVILEGE_KEY = ACCESS_PRIVILEGE.key();

  private static Logger LOG = Logger.getLogger(_SWAccessPrivilegeValue.class);

  public is.us.soloweb.data.SWAccessPrivilegeValue localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWAccessPrivilegeValue localInstance = (is.us.soloweb.data.SWAccessPrivilegeValue)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer accessPrivilegeID() {
    return (Integer) storedValueForKey(_SWAccessPrivilegeValue.ACCESS_PRIVILEGE_ID_KEY);
  }

  public void setAccessPrivilegeID(Integer value) {
    if (_SWAccessPrivilegeValue.LOG.isDebugEnabled()) {
    	_SWAccessPrivilegeValue.LOG.debug( "updating accessPrivilegeID from " + accessPrivilegeID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilegeValue.ACCESS_PRIVILEGE_ID_KEY);
  }

  public Integer accessPrivilegeValueID() {
    return (Integer) storedValueForKey(_SWAccessPrivilegeValue.ACCESS_PRIVILEGE_VALUE_ID_KEY);
  }

  public void setAccessPrivilegeValueID(Integer value) {
    if (_SWAccessPrivilegeValue.LOG.isDebugEnabled()) {
    	_SWAccessPrivilegeValue.LOG.debug( "updating accessPrivilegeValueID from " + accessPrivilegeValueID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilegeValue.ACCESS_PRIVILEGE_VALUE_ID_KEY);
  }

  public String identifier() {
    return (String) storedValueForKey(_SWAccessPrivilegeValue.IDENTIFIER_KEY);
  }

  public void setIdentifier(String value) {
    if (_SWAccessPrivilegeValue.LOG.isDebugEnabled()) {
    	_SWAccessPrivilegeValue.LOG.debug( "updating identifier from " + identifier() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilegeValue.IDENTIFIER_KEY);
  }

  public Integer value() {
    return (Integer) storedValueForKey(_SWAccessPrivilegeValue.VALUE_KEY);
  }

  public void setValue(Integer value) {
    if (_SWAccessPrivilegeValue.LOG.isDebugEnabled()) {
    	_SWAccessPrivilegeValue.LOG.debug( "updating value from " + value() + " to " + value);
    }
    takeStoredValueForKey(value, _SWAccessPrivilegeValue.VALUE_KEY);
  }

  public is.us.soloweb.data.SWAccessPrivilege accessPrivilege() {
    return (is.us.soloweb.data.SWAccessPrivilege)storedValueForKey(_SWAccessPrivilegeValue.ACCESS_PRIVILEGE_KEY);
  }
  
  public void setAccessPrivilege(is.us.soloweb.data.SWAccessPrivilege value) {
    takeStoredValueForKey(value, _SWAccessPrivilegeValue.ACCESS_PRIVILEGE_KEY);
  }

  public void setAccessPrivilegeRelationship(is.us.soloweb.data.SWAccessPrivilege value) {
    if (_SWAccessPrivilegeValue.LOG.isDebugEnabled()) {
      _SWAccessPrivilegeValue.LOG.debug("updating accessPrivilege from " + accessPrivilege() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setAccessPrivilege(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWAccessPrivilege oldValue = accessPrivilege();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWAccessPrivilegeValue.ACCESS_PRIVILEGE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWAccessPrivilegeValue.ACCESS_PRIVILEGE_KEY);
    }
  }
  

  public static is.us.soloweb.data.SWAccessPrivilegeValue createSWAccessPrivilegeValue(EOEditingContext editingContext, Integer accessPrivilegeValueID
) {
    is.us.soloweb.data.SWAccessPrivilegeValue eo = (is.us.soloweb.data.SWAccessPrivilegeValue) EOUtilities.createAndInsertInstance(editingContext, _SWAccessPrivilegeValue.ENTITY_NAME);    
		eo.setAccessPrivilegeValueID(accessPrivilegeValueID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> fetchAllSWAccessPrivilegeValues(EOEditingContext editingContext) {
    return _SWAccessPrivilegeValue.fetchAllSWAccessPrivilegeValues(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> fetchAllSWAccessPrivilegeValues(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWAccessPrivilegeValue.fetchSWAccessPrivilegeValues(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> fetchSWAccessPrivilegeValues(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWAccessPrivilegeValue> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWAccessPrivilegeValue>(_SWAccessPrivilegeValue.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWAccessPrivilegeValue fetchSWAccessPrivilegeValue(EOEditingContext editingContext, String keyName, Object value) {
    return _SWAccessPrivilegeValue.fetchSWAccessPrivilegeValue(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWAccessPrivilegeValue fetchSWAccessPrivilegeValue(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWAccessPrivilegeValue> eoObjects = _SWAccessPrivilegeValue.fetchSWAccessPrivilegeValues(editingContext, qualifier, null);
    is.us.soloweb.data.SWAccessPrivilegeValue eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWAccessPrivilegeValue that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWAccessPrivilegeValue fetchRequiredSWAccessPrivilegeValue(EOEditingContext editingContext, String keyName, Object value) {
    return _SWAccessPrivilegeValue.fetchRequiredSWAccessPrivilegeValue(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWAccessPrivilegeValue fetchRequiredSWAccessPrivilegeValue(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWAccessPrivilegeValue eoObject = _SWAccessPrivilegeValue.fetchSWAccessPrivilegeValue(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWAccessPrivilegeValue that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWAccessPrivilegeValue localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWAccessPrivilegeValue eo) {
    is.us.soloweb.data.SWAccessPrivilegeValue localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
