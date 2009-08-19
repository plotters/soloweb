// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to is.us.soloweb.forms.data.SWFField.java instead.
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
public abstract class _SWFField extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWFField";

  // Attribute Keys
  public static final ERXKey<String> ABOVE_TEXT = new ERXKey<String>("aboveText");
  public static final ERXKey<Integer> ADMIN_FIELD = new ERXKey<Integer>("adminField");
  public static final ERXKey<String> DEFAULT_VALUE = new ERXKey<String>("defaultValue");
  public static final ERXKey<String> EXPLANATORY_TEXT = new ERXKey<String>("explanatoryText");
  public static final ERXKey<Integer> FIELD_ID = new ERXKey<Integer>("fieldID");
  public static final ERXKey<Integer> FIELD_SET_ID = new ERXKey<Integer>("fieldSetID");
  public static final ERXKey<Integer> FORM_ID = new ERXKey<Integer>("formID");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> NO_SELECTION_STRING = new ERXKey<String>("noSelectionString");
  public static final ERXKey<Integer> PRIMARY_FIELD = new ERXKey<Integer>("primaryField");
  public static final ERXKey<Integer> REQUIRED = new ERXKey<Integer>("required");
  public static final ERXKey<Integer> ROWS = new ERXKey<Integer>("rows");
  public static final ERXKey<Integer> SIZE = new ERXKey<Integer>("size");
  public static final ERXKey<Integer> SORT_NUMBER = new ERXKey<Integer>("sortNumber");
  public static final ERXKey<String> TYPE = new ERXKey<String>("type");
  public static final ERXKey<String> VALUELIST_STRING = new ERXKey<String>("valuelistString");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.forms.data.SWFFieldSet> FIELD_SET = new ERXKey<is.us.soloweb.forms.data.SWFFieldSet>("fieldSet");
  public static final ERXKey<is.us.soloweb.forms.data.SWFFixedSearch> FIXED_SEARCHES = new ERXKey<is.us.soloweb.forms.data.SWFFixedSearch>("fixedSearches");
  public static final ERXKey<is.us.soloweb.forms.data.SWFForm> FORM = new ERXKey<is.us.soloweb.forms.data.SWFForm>("form");
  public static final ERXKey<is.us.soloweb.forms.data.SWFRegistrationField> REGISTRATION_FIELDS = new ERXKey<is.us.soloweb.forms.data.SWFRegistrationField>("registrationFields");

  // Attributes
  public static final String ABOVE_TEXT_KEY = ABOVE_TEXT.key();
  public static final String ADMIN_FIELD_KEY = ADMIN_FIELD.key();
  public static final String DEFAULT_VALUE_KEY = DEFAULT_VALUE.key();
  public static final String EXPLANATORY_TEXT_KEY = EXPLANATORY_TEXT.key();
  public static final String FIELD_ID_KEY = FIELD_ID.key();
  public static final String FIELD_SET_ID_KEY = FIELD_SET_ID.key();
  public static final String FORM_ID_KEY = FORM_ID.key();
  public static final String NAME_KEY = NAME.key();
  public static final String NO_SELECTION_STRING_KEY = NO_SELECTION_STRING.key();
  public static final String PRIMARY_FIELD_KEY = PRIMARY_FIELD.key();
  public static final String REQUIRED_KEY = REQUIRED.key();
  public static final String ROWS_KEY = ROWS.key();
  public static final String SIZE_KEY = SIZE.key();
  public static final String SORT_NUMBER_KEY = SORT_NUMBER.key();
  public static final String TYPE_KEY = TYPE.key();
  public static final String VALUELIST_STRING_KEY = VALUELIST_STRING.key();
  // Relationships
  public static final String FIELD_SET_KEY = FIELD_SET.key();
  public static final String FIXED_SEARCHES_KEY = FIXED_SEARCHES.key();
  public static final String FORM_KEY = FORM.key();
  public static final String REGISTRATION_FIELDS_KEY = REGISTRATION_FIELDS.key();

  private static Logger LOG = Logger.getLogger(_SWFField.class);

  public is.us.soloweb.forms.data.SWFField localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.forms.data.SWFField localInstance = (is.us.soloweb.forms.data.SWFField)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String aboveText() {
    return (String) storedValueForKey("aboveText");
  }

  public void setAboveText(String value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating aboveText from " + aboveText() + " to " + value);
    }
    takeStoredValueForKey(value, "aboveText");
  }

  public Integer adminField() {
    return (Integer) storedValueForKey("adminField");
  }

  public void setAdminField(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating adminField from " + adminField() + " to " + value);
    }
    takeStoredValueForKey(value, "adminField");
  }

  public String defaultValue() {
    return (String) storedValueForKey("defaultValue");
  }

  public void setDefaultValue(String value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating defaultValue from " + defaultValue() + " to " + value);
    }
    takeStoredValueForKey(value, "defaultValue");
  }

  public String explanatoryText() {
    return (String) storedValueForKey("explanatoryText");
  }

  public void setExplanatoryText(String value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating explanatoryText from " + explanatoryText() + " to " + value);
    }
    takeStoredValueForKey(value, "explanatoryText");
  }

  public Integer fieldID() {
    return (Integer) storedValueForKey("fieldID");
  }

  public void setFieldID(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating fieldID from " + fieldID() + " to " + value);
    }
    takeStoredValueForKey(value, "fieldID");
  }

  public Integer fieldSetID() {
    return (Integer) storedValueForKey("fieldSetID");
  }

  public void setFieldSetID(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating fieldSetID from " + fieldSetID() + " to " + value);
    }
    takeStoredValueForKey(value, "fieldSetID");
  }

  public Integer formID() {
    return (Integer) storedValueForKey("formID");
  }

  public void setFormID(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating formID from " + formID() + " to " + value);
    }
    takeStoredValueForKey(value, "formID");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public String noSelectionString() {
    return (String) storedValueForKey("noSelectionString");
  }

  public void setNoSelectionString(String value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating noSelectionString from " + noSelectionString() + " to " + value);
    }
    takeStoredValueForKey(value, "noSelectionString");
  }

  public Integer primaryField() {
    return (Integer) storedValueForKey("primaryField");
  }

  public void setPrimaryField(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating primaryField from " + primaryField() + " to " + value);
    }
    takeStoredValueForKey(value, "primaryField");
  }

  public Integer required() {
    return (Integer) storedValueForKey("required");
  }

  public void setRequired(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating required from " + required() + " to " + value);
    }
    takeStoredValueForKey(value, "required");
  }

  public Integer rows() {
    return (Integer) storedValueForKey("rows");
  }

  public void setRows(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating rows from " + rows() + " to " + value);
    }
    takeStoredValueForKey(value, "rows");
  }

  public Integer size() {
    return (Integer) storedValueForKey("size");
  }

  public void setSize(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating size from " + size() + " to " + value);
    }
    takeStoredValueForKey(value, "size");
  }

  public Integer sortNumber() {
    return (Integer) storedValueForKey("sortNumber");
  }

  public void setSortNumber(Integer value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating sortNumber from " + sortNumber() + " to " + value);
    }
    takeStoredValueForKey(value, "sortNumber");
  }

  public String type() {
    return (String) storedValueForKey("type");
  }

  public void setType(String value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating type from " + type() + " to " + value);
    }
    takeStoredValueForKey(value, "type");
  }

  public String valuelistString() {
    return (String) storedValueForKey("valuelistString");
  }

  public void setValuelistString(String value) {
    if (_SWFField.LOG.isDebugEnabled()) {
    	_SWFField.LOG.debug( "updating valuelistString from " + valuelistString() + " to " + value);
    }
    takeStoredValueForKey(value, "valuelistString");
  }

  public is.us.soloweb.forms.data.SWFFieldSet fieldSet() {
    return (is.us.soloweb.forms.data.SWFFieldSet)storedValueForKey("fieldSet");
  }
  
  public void setFieldSet(is.us.soloweb.forms.data.SWFFieldSet value) {
    takeStoredValueForKey(value, "fieldSet");
  }

  public void setFieldSetRelationship(is.us.soloweb.forms.data.SWFFieldSet value) {
    if (_SWFField.LOG.isDebugEnabled()) {
      _SWFField.LOG.debug("updating fieldSet from " + fieldSet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setFieldSet(value);
    }
    else if (value == null) {
    	is.us.soloweb.forms.data.SWFFieldSet oldValue = fieldSet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "fieldSet");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "fieldSet");
    }
  }
  
  public is.us.soloweb.forms.data.SWFForm form() {
    return (is.us.soloweb.forms.data.SWFForm)storedValueForKey("form");
  }
  
  public void setForm(is.us.soloweb.forms.data.SWFForm value) {
    takeStoredValueForKey(value, "form");
  }

  public void setFormRelationship(is.us.soloweb.forms.data.SWFForm value) {
    if (_SWFField.LOG.isDebugEnabled()) {
      _SWFField.LOG.debug("updating form from " + form() + " to " + value);
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
  
  public NSArray<is.us.soloweb.forms.data.SWFFixedSearch> fixedSearches() {
    return (NSArray<is.us.soloweb.forms.data.SWFFixedSearch>)storedValueForKey("fixedSearches");
  }

  public NSArray<is.us.soloweb.forms.data.SWFFixedSearch> fixedSearches(EOQualifier qualifier) {
    return fixedSearches(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.forms.data.SWFFixedSearch> fixedSearches(EOQualifier qualifier, boolean fetch) {
    return fixedSearches(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.forms.data.SWFFixedSearch> fixedSearches(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.forms.data.SWFFixedSearch> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFFixedSearch.FIELD_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.forms.data.SWFFixedSearch.fetchSWFFixedSearchs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = fixedSearches();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFFixedSearch>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFFixedSearch>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToFixedSearches(is.us.soloweb.forms.data.SWFFixedSearch object) {
    includeObjectIntoPropertyWithKey(object, "fixedSearches");
  }

  public void removeFromFixedSearches(is.us.soloweb.forms.data.SWFFixedSearch object) {
    excludeObjectFromPropertyWithKey(object, "fixedSearches");
  }

  public void addToFixedSearchesRelationship(is.us.soloweb.forms.data.SWFFixedSearch object) {
    if (_SWFField.LOG.isDebugEnabled()) {
      _SWFField.LOG.debug("adding " + object + " to fixedSearches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToFixedSearches(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "fixedSearches");
    }
  }

  public void removeFromFixedSearchesRelationship(is.us.soloweb.forms.data.SWFFixedSearch object) {
    if (_SWFField.LOG.isDebugEnabled()) {
      _SWFField.LOG.debug("removing " + object + " from fixedSearches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromFixedSearches(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "fixedSearches");
    }
  }

  public is.us.soloweb.forms.data.SWFFixedSearch createFixedSearchesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWFFixedSearch");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "fixedSearches");
    return (is.us.soloweb.forms.data.SWFFixedSearch) eo;
  }

  public void deleteFixedSearchesRelationship(is.us.soloweb.forms.data.SWFFixedSearch object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "fixedSearches");
    editingContext().deleteObject(object);
  }

  public void deleteAllFixedSearchesRelationships() {
    Enumeration objects = fixedSearches().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteFixedSearchesRelationship((is.us.soloweb.forms.data.SWFFixedSearch)objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.forms.data.SWFRegistrationField> registrationFields() {
    return (NSArray<is.us.soloweb.forms.data.SWFRegistrationField>)storedValueForKey("registrationFields");
  }

  public NSArray<is.us.soloweb.forms.data.SWFRegistrationField> registrationFields(EOQualifier qualifier) {
    return registrationFields(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.forms.data.SWFRegistrationField> registrationFields(EOQualifier qualifier, boolean fetch) {
    return registrationFields(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.forms.data.SWFRegistrationField> registrationFields(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.forms.data.SWFRegistrationField> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFRegistrationField.FIELD_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.forms.data.SWFRegistrationField.fetchSWFRegistrationFields(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = registrationFields();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFRegistrationField>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFRegistrationField>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToRegistrationFields(is.us.soloweb.forms.data.SWFRegistrationField object) {
    includeObjectIntoPropertyWithKey(object, "registrationFields");
  }

  public void removeFromRegistrationFields(is.us.soloweb.forms.data.SWFRegistrationField object) {
    excludeObjectFromPropertyWithKey(object, "registrationFields");
  }

  public void addToRegistrationFieldsRelationship(is.us.soloweb.forms.data.SWFRegistrationField object) {
    if (_SWFField.LOG.isDebugEnabled()) {
      _SWFField.LOG.debug("adding " + object + " to registrationFields relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToRegistrationFields(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "registrationFields");
    }
  }

  public void removeFromRegistrationFieldsRelationship(is.us.soloweb.forms.data.SWFRegistrationField object) {
    if (_SWFField.LOG.isDebugEnabled()) {
      _SWFField.LOG.debug("removing " + object + " from registrationFields relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromRegistrationFields(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "registrationFields");
    }
  }

  public is.us.soloweb.forms.data.SWFRegistrationField createRegistrationFieldsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWFRegistrationField");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "registrationFields");
    return (is.us.soloweb.forms.data.SWFRegistrationField) eo;
  }

  public void deleteRegistrationFieldsRelationship(is.us.soloweb.forms.data.SWFRegistrationField object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "registrationFields");
    editingContext().deleteObject(object);
  }

  public void deleteAllRegistrationFieldsRelationships() {
    Enumeration objects = registrationFields().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRegistrationFieldsRelationship((is.us.soloweb.forms.data.SWFRegistrationField)objects.nextElement());
    }
  }


  public static is.us.soloweb.forms.data.SWFField createSWFField(EOEditingContext editingContext, Integer fieldID
) {
    is.us.soloweb.forms.data.SWFField eo = (is.us.soloweb.forms.data.SWFField) EOUtilities.createAndInsertInstance(editingContext, _SWFField.ENTITY_NAME);    
		eo.setFieldID(fieldID);
    return eo;
  }

  public static NSArray<is.us.soloweb.forms.data.SWFField> fetchAllSWFFields(EOEditingContext editingContext) {
    return _SWFField.fetchAllSWFFields(editingContext, null);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFField> fetchAllSWFFields(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWFField.fetchSWFFields(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFField> fetchSWFFields(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWFField.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.forms.data.SWFField> eoObjects = (NSArray<is.us.soloweb.forms.data.SWFField>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static is.us.soloweb.forms.data.SWFField fetchSWFField(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFField.fetchSWFField(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFField fetchSWFField(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.forms.data.SWFField> eoObjects = _SWFField.fetchSWFFields(editingContext, qualifier, null);
    is.us.soloweb.forms.data.SWFField eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (is.us.soloweb.forms.data.SWFField)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWFField that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFField fetchRequiredSWFField(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFField.fetchRequiredSWFField(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFField fetchRequiredSWFField(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.forms.data.SWFField eoObject = _SWFField.fetchSWFField(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWFField that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFField localInstanceIn(EOEditingContext editingContext, is.us.soloweb.forms.data.SWFField eo) {
    is.us.soloweb.forms.data.SWFField localInstance = (eo == null) ? null : (is.us.soloweb.forms.data.SWFField)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
