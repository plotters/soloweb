// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to is.us.soloweb.forms.data.SWFFixedSearch.java instead.
package is.us.soloweb.forms.data.auto;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _SWFFixedSearch extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWFFixedSearch";

  // Attribute Keys
  public static final ERXKey<Integer> FIELD_ID = new ERXKey<Integer>("fieldID");
  public static final ERXKey<Integer> FIXED_SEARCH_ID = new ERXKey<Integer>("fixedSearchID");
  public static final ERXKey<Integer> FORM_ID = new ERXKey<Integer>("formID");
  public static final ERXKey<Integer> GROUP_ID = new ERXKey<Integer>("groupID");
  public static final ERXKey<Integer> USER_ID = new ERXKey<Integer>("userID");
  public static final ERXKey<String> VALUE = new ERXKey<String>("value");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.forms.data.SWFField> FIELD = new ERXKey<is.us.soloweb.forms.data.SWFField>("field");
  public static final ERXKey<is.us.soloweb.forms.data.SWFForm> FORM = new ERXKey<is.us.soloweb.forms.data.SWFForm>("form");
  public static final ERXKey<is.us.soloweb.data.SWGroup> GROUP = new ERXKey<is.us.soloweb.data.SWGroup>("group");
  public static final ERXKey<is.us.soloweb.data.SWUser> USER = new ERXKey<is.us.soloweb.data.SWUser>("user");

  // Attributes
  public static final String FIELD_ID_KEY = FIELD_ID.key();
  public static final String FIXED_SEARCH_ID_KEY = FIXED_SEARCH_ID.key();
  public static final String FORM_ID_KEY = FORM_ID.key();
  public static final String GROUP_ID_KEY = GROUP_ID.key();
  public static final String USER_ID_KEY = USER_ID.key();
  public static final String VALUE_KEY = VALUE.key();
  // Relationships
  public static final String FIELD_KEY = FIELD.key();
  public static final String FORM_KEY = FORM.key();
  public static final String GROUP_KEY = GROUP.key();
  public static final String USER_KEY = USER.key();

  private static Logger LOG = Logger.getLogger(_SWFFixedSearch.class);

  public is.us.soloweb.forms.data.SWFFixedSearch localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.forms.data.SWFFixedSearch localInstance = (is.us.soloweb.forms.data.SWFFixedSearch)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer fieldID() {
    return (Integer) storedValueForKey("fieldID");
  }

  public void setFieldID(Integer value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
    	_SWFFixedSearch.LOG.debug( "updating fieldID from " + fieldID() + " to " + value);
    }
    takeStoredValueForKey(value, "fieldID");
  }

  public Integer fixedSearchID() {
    return (Integer) storedValueForKey("fixedSearchID");
  }

  public void setFixedSearchID(Integer value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
    	_SWFFixedSearch.LOG.debug( "updating fixedSearchID from " + fixedSearchID() + " to " + value);
    }
    takeStoredValueForKey(value, "fixedSearchID");
  }

  public Integer formID() {
    return (Integer) storedValueForKey("formID");
  }

  public void setFormID(Integer value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
    	_SWFFixedSearch.LOG.debug( "updating formID from " + formID() + " to " + value);
    }
    takeStoredValueForKey(value, "formID");
  }

  public Integer groupID() {
    return (Integer) storedValueForKey("groupID");
  }

  public void setGroupID(Integer value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
    	_SWFFixedSearch.LOG.debug( "updating groupID from " + groupID() + " to " + value);
    }
    takeStoredValueForKey(value, "groupID");
  }

  public Integer userID() {
    return (Integer) storedValueForKey("userID");
  }

  public void setUserID(Integer value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
    	_SWFFixedSearch.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, "userID");
  }

  public String value() {
    return (String) storedValueForKey("value");
  }

  public void setValue(String value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
    	_SWFFixedSearch.LOG.debug( "updating value from " + value() + " to " + value);
    }
    takeStoredValueForKey(value, "value");
  }

  public is.us.soloweb.forms.data.SWFField field() {
    return (is.us.soloweb.forms.data.SWFField)storedValueForKey("field");
  }
  
  public void setField(is.us.soloweb.forms.data.SWFField value) {
    takeStoredValueForKey(value, "field");
  }

  public void setFieldRelationship(is.us.soloweb.forms.data.SWFField value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
      _SWFFixedSearch.LOG.debug("updating field from " + field() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setField(value);
    }
    else if (value == null) {
    	is.us.soloweb.forms.data.SWFField oldValue = field();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "field");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "field");
    }
  }
  
  public is.us.soloweb.forms.data.SWFForm form() {
    return (is.us.soloweb.forms.data.SWFForm)storedValueForKey("form");
  }
  
  public void setForm(is.us.soloweb.forms.data.SWFForm value) {
    takeStoredValueForKey(value, "form");
  }

  public void setFormRelationship(is.us.soloweb.forms.data.SWFForm value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
      _SWFFixedSearch.LOG.debug("updating form from " + form() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setForm(value);
    }
    else if (value == null) {
    	is.us.soloweb.forms.data.SWFForm oldValue = form();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "form");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "form");
    }
  }
  
  public is.us.soloweb.data.SWGroup group() {
    return (is.us.soloweb.data.SWGroup)storedValueForKey("group");
  }
  
  public void setGroup(is.us.soloweb.data.SWGroup value) {
    takeStoredValueForKey(value, "group");
  }

  public void setGroupRelationship(is.us.soloweb.data.SWGroup value) {
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
      _SWFFixedSearch.LOG.debug("updating group from " + group() + " to " + value);
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
    if (_SWFFixedSearch.LOG.isDebugEnabled()) {
      _SWFFixedSearch.LOG.debug("updating user from " + user() + " to " + value);
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
  

  public static is.us.soloweb.forms.data.SWFFixedSearch createSWFFixedSearch(EOEditingContext editingContext, Integer fixedSearchID
) {
    is.us.soloweb.forms.data.SWFFixedSearch eo = (is.us.soloweb.forms.data.SWFFixedSearch) EOUtilities.createAndInsertInstance(editingContext, _SWFFixedSearch.ENTITY_NAME);    
		eo.setFixedSearchID(fixedSearchID);
    return eo;
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFixedSearch> fetchAllSWFFixedSearchs(EOEditingContext editingContext) {
    return _SWFFixedSearch.fetchAllSWFFixedSearchs(editingContext, null);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFixedSearch> fetchAllSWFFixedSearchs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWFFixedSearch.fetchSWFFixedSearchs(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFixedSearch> fetchSWFFixedSearchs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWFFixedSearch.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.forms.data.SWFFixedSearch> eoObjects = (NSArray<is.us.soloweb.forms.data.SWFFixedSearch>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static is.us.soloweb.forms.data.SWFFixedSearch fetchSWFFixedSearch(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFFixedSearch.fetchSWFFixedSearch(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFFixedSearch fetchSWFFixedSearch(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.forms.data.SWFFixedSearch> eoObjects = _SWFFixedSearch.fetchSWFFixedSearchs(editingContext, qualifier, null);
    is.us.soloweb.forms.data.SWFFixedSearch eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (is.us.soloweb.forms.data.SWFFixedSearch)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWFFixedSearch that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFFixedSearch fetchRequiredSWFFixedSearch(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFFixedSearch.fetchRequiredSWFFixedSearch(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFFixedSearch fetchRequiredSWFFixedSearch(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.forms.data.SWFFixedSearch eoObject = _SWFFixedSearch.fetchSWFFixedSearch(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWFFixedSearch that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFFixedSearch localInstanceIn(EOEditingContext editingContext, is.us.soloweb.forms.data.SWFFixedSearch eo) {
    is.us.soloweb.forms.data.SWFFixedSearch localInstance = (eo == null) ? null : (is.us.soloweb.forms.data.SWFFixedSearch)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
