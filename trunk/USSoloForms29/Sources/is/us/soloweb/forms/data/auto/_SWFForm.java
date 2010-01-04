// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to is.us.soloweb.forms.data.SWFForm.java instead.
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
public abstract class _SWFForm extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWFForm";

  // Attribute Keys
  public static final ERXKey<Integer> DONT_STORE_DATA = new ERXKey<Integer>("dontStoreData");
  public static final ERXKey<Integer> FOLDER_ID = new ERXKey<Integer>("folderID");
  public static final ERXKey<Integer> FORM_ID = new ERXKey<Integer>("formID");
  public static final ERXKey<String> FROM_EMAIL_ADDRESS = new ERXKey<String>("fromEmailAddress");
  public static final ERXKey<Integer> MAX_REGISTRATIONS = new ERXKey<Integer>("maxRegistrations");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> NOTIFY_EMAIL_ADDRESSES = new ERXKey<String>("notifyEmailAddresses");
  public static final ERXKey<String> REGISTRATION_MESSAGE = new ERXKey<String>("registrationMessage");
  public static final ERXKey<String> REQUIRED_FIELD_EMPTY_STRING = new ERXKey<String>("requiredFieldEmptyString");
  public static final ERXKey<Integer> USERS_CAN_DELETE_REGISTRATIONS = new ERXKey<Integer>("usersCanDeleteRegistrations");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.forms.data.SWFField> FIELDS = new ERXKey<is.us.soloweb.forms.data.SWFField>("fields");
  public static final ERXKey<is.us.soloweb.forms.data.SWFFieldSet> FIELD_SETS = new ERXKey<is.us.soloweb.forms.data.SWFFieldSet>("fieldSets");
  public static final ERXKey<is.us.soloweb.forms.data.SWFFixedSearch> FIXED_SEARCHES = new ERXKey<is.us.soloweb.forms.data.SWFFixedSearch>("fixedSearches");
  public static final ERXKey<is.us.soloweb.forms.data.SWFFormFolder> FOLDER = new ERXKey<is.us.soloweb.forms.data.SWFFormFolder>("folder");
  public static final ERXKey<is.us.soloweb.forms.data.SWFRegistration> REGISTRATIONS = new ERXKey<is.us.soloweb.forms.data.SWFRegistration>("registrations");

  // Attributes
  public static final String DONT_STORE_DATA_KEY = DONT_STORE_DATA.key();
  public static final String FOLDER_ID_KEY = FOLDER_ID.key();
  public static final String FORM_ID_KEY = FORM_ID.key();
  public static final String FROM_EMAIL_ADDRESS_KEY = FROM_EMAIL_ADDRESS.key();
  public static final String MAX_REGISTRATIONS_KEY = MAX_REGISTRATIONS.key();
  public static final String NAME_KEY = NAME.key();
  public static final String NOTIFY_EMAIL_ADDRESSES_KEY = NOTIFY_EMAIL_ADDRESSES.key();
  public static final String REGISTRATION_MESSAGE_KEY = REGISTRATION_MESSAGE.key();
  public static final String REQUIRED_FIELD_EMPTY_STRING_KEY = REQUIRED_FIELD_EMPTY_STRING.key();
  public static final String USERS_CAN_DELETE_REGISTRATIONS_KEY = USERS_CAN_DELETE_REGISTRATIONS.key();
  // Relationships
  public static final String FIELDS_KEY = FIELDS.key();
  public static final String FIELD_SETS_KEY = FIELD_SETS.key();
  public static final String FIXED_SEARCHES_KEY = FIXED_SEARCHES.key();
  public static final String FOLDER_KEY = FOLDER.key();
  public static final String REGISTRATIONS_KEY = REGISTRATIONS.key();

  private static Logger LOG = Logger.getLogger(_SWFForm.class);

  public is.us.soloweb.forms.data.SWFForm localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.forms.data.SWFForm localInstance = (is.us.soloweb.forms.data.SWFForm)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer dontStoreData() {
    return (Integer) storedValueForKey("dontStoreData");
  }

  public void setDontStoreData(Integer value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating dontStoreData from " + dontStoreData() + " to " + value);
    }
    takeStoredValueForKey(value, "dontStoreData");
  }

  public Integer folderID() {
    return (Integer) storedValueForKey("folderID");
  }

  public void setFolderID(Integer value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating folderID from " + folderID() + " to " + value);
    }
    takeStoredValueForKey(value, "folderID");
  }

  public Integer formID() {
    return (Integer) storedValueForKey("formID");
  }

  public void setFormID(Integer value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating formID from " + formID() + " to " + value);
    }
    takeStoredValueForKey(value, "formID");
  }

  public String fromEmailAddress() {
    return (String) storedValueForKey("fromEmailAddress");
  }

  public void setFromEmailAddress(String value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating fromEmailAddress from " + fromEmailAddress() + " to " + value);
    }
    takeStoredValueForKey(value, "fromEmailAddress");
  }

  public Integer maxRegistrations() {
    return (Integer) storedValueForKey("maxRegistrations");
  }

  public void setMaxRegistrations(Integer value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating maxRegistrations from " + maxRegistrations() + " to " + value);
    }
    takeStoredValueForKey(value, "maxRegistrations");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public String notifyEmailAddresses() {
    return (String) storedValueForKey("notifyEmailAddresses");
  }

  public void setNotifyEmailAddresses(String value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating notifyEmailAddresses from " + notifyEmailAddresses() + " to " + value);
    }
    takeStoredValueForKey(value, "notifyEmailAddresses");
  }

  public String registrationMessage() {
    return (String) storedValueForKey("registrationMessage");
  }

  public void setRegistrationMessage(String value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating registrationMessage from " + registrationMessage() + " to " + value);
    }
    takeStoredValueForKey(value, "registrationMessage");
  }

  public String requiredFieldEmptyString() {
    return (String) storedValueForKey("requiredFieldEmptyString");
  }

  public void setRequiredFieldEmptyString(String value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating requiredFieldEmptyString from " + requiredFieldEmptyString() + " to " + value);
    }
    takeStoredValueForKey(value, "requiredFieldEmptyString");
  }

  public Integer usersCanDeleteRegistrations() {
    return (Integer) storedValueForKey("usersCanDeleteRegistrations");
  }

  public void setUsersCanDeleteRegistrations(Integer value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
    	_SWFForm.LOG.debug( "updating usersCanDeleteRegistrations from " + usersCanDeleteRegistrations() + " to " + value);
    }
    takeStoredValueForKey(value, "usersCanDeleteRegistrations");
  }

  public is.us.soloweb.forms.data.SWFFormFolder folder() {
    return (is.us.soloweb.forms.data.SWFFormFolder)storedValueForKey("folder");
  }
  
  public void setFolder(is.us.soloweb.forms.data.SWFFormFolder value) {
    takeStoredValueForKey(value, "folder");
  }

  public void setFolderRelationship(is.us.soloweb.forms.data.SWFFormFolder value) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("updating folder from " + folder() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setFolder(value);
    }
    else if (value == null) {
    	is.us.soloweb.forms.data.SWFFormFolder oldValue = folder();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "folder");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "folder");
    }
  }
  
  public NSArray<is.us.soloweb.forms.data.SWFField> fields() {
    return (NSArray<is.us.soloweb.forms.data.SWFField>)storedValueForKey("fields");
  }

  public NSArray<is.us.soloweb.forms.data.SWFField> fields(EOQualifier qualifier) {
    return fields(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.forms.data.SWFField> fields(EOQualifier qualifier, boolean fetch) {
    return fields(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.forms.data.SWFField> fields(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.forms.data.SWFField> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFField.FORM_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.forms.data.SWFField.fetchSWFFields(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = fields();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFField>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFField>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToFields(is.us.soloweb.forms.data.SWFField object) {
    includeObjectIntoPropertyWithKey(object, "fields");
  }

  public void removeFromFields(is.us.soloweb.forms.data.SWFField object) {
    excludeObjectFromPropertyWithKey(object, "fields");
  }

  public void addToFieldsRelationship(is.us.soloweb.forms.data.SWFField object) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("adding " + object + " to fields relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToFields(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "fields");
    }
  }

  public void removeFromFieldsRelationship(is.us.soloweb.forms.data.SWFField object) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("removing " + object + " from fields relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromFields(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "fields");
    }
  }

  public is.us.soloweb.forms.data.SWFField createFieldsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWFField");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "fields");
    return (is.us.soloweb.forms.data.SWFField) eo;
  }

  public void deleteFieldsRelationship(is.us.soloweb.forms.data.SWFField object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "fields");
    editingContext().deleteObject(object);
  }

  public void deleteAllFieldsRelationships() {
    Enumeration objects = fields().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteFieldsRelationship((is.us.soloweb.forms.data.SWFField)objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.forms.data.SWFFieldSet> fieldSets() {
    return (NSArray<is.us.soloweb.forms.data.SWFFieldSet>)storedValueForKey("fieldSets");
  }

  public NSArray<is.us.soloweb.forms.data.SWFFieldSet> fieldSets(EOQualifier qualifier) {
    return fieldSets(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.forms.data.SWFFieldSet> fieldSets(EOQualifier qualifier, boolean fetch) {
    return fieldSets(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.forms.data.SWFFieldSet> fieldSets(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.forms.data.SWFFieldSet> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFFieldSet.FORM_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.forms.data.SWFFieldSet.fetchSWFFieldSets(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = fieldSets();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFFieldSet>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFFieldSet>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToFieldSets(is.us.soloweb.forms.data.SWFFieldSet object) {
    includeObjectIntoPropertyWithKey(object, "fieldSets");
  }

  public void removeFromFieldSets(is.us.soloweb.forms.data.SWFFieldSet object) {
    excludeObjectFromPropertyWithKey(object, "fieldSets");
  }

  public void addToFieldSetsRelationship(is.us.soloweb.forms.data.SWFFieldSet object) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("adding " + object + " to fieldSets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToFieldSets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "fieldSets");
    }
  }

  public void removeFromFieldSetsRelationship(is.us.soloweb.forms.data.SWFFieldSet object) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("removing " + object + " from fieldSets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromFieldSets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "fieldSets");
    }
  }

  public is.us.soloweb.forms.data.SWFFieldSet createFieldSetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWFFieldSet");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "fieldSets");
    return (is.us.soloweb.forms.data.SWFFieldSet) eo;
  }

  public void deleteFieldSetsRelationship(is.us.soloweb.forms.data.SWFFieldSet object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "fieldSets");
    editingContext().deleteObject(object);
  }

  public void deleteAllFieldSetsRelationships() {
    Enumeration objects = fieldSets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteFieldSetsRelationship((is.us.soloweb.forms.data.SWFFieldSet)objects.nextElement());
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFFixedSearch.FORM_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("adding " + object + " to fixedSearches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToFixedSearches(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "fixedSearches");
    }
  }

  public void removeFromFixedSearchesRelationship(is.us.soloweb.forms.data.SWFFixedSearch object) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("removing " + object + " from fixedSearches relationship");
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

  public NSArray<is.us.soloweb.forms.data.SWFRegistration> registrations() {
    return (NSArray<is.us.soloweb.forms.data.SWFRegistration>)storedValueForKey("registrations");
  }

  public NSArray<is.us.soloweb.forms.data.SWFRegistration> registrations(EOQualifier qualifier) {
    return registrations(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.forms.data.SWFRegistration> registrations(EOQualifier qualifier, boolean fetch) {
    return registrations(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.forms.data.SWFRegistration> registrations(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.forms.data.SWFRegistration> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFRegistration.FORM_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.forms.data.SWFRegistration.fetchSWFRegistrations(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = registrations();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFRegistration>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFRegistration>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToRegistrations(is.us.soloweb.forms.data.SWFRegistration object) {
    includeObjectIntoPropertyWithKey(object, "registrations");
  }

  public void removeFromRegistrations(is.us.soloweb.forms.data.SWFRegistration object) {
    excludeObjectFromPropertyWithKey(object, "registrations");
  }

  public void addToRegistrationsRelationship(is.us.soloweb.forms.data.SWFRegistration object) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("adding " + object + " to registrations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToRegistrations(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "registrations");
    }
  }

  public void removeFromRegistrationsRelationship(is.us.soloweb.forms.data.SWFRegistration object) {
    if (_SWFForm.LOG.isDebugEnabled()) {
      _SWFForm.LOG.debug("removing " + object + " from registrations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromRegistrations(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "registrations");
    }
  }

  public is.us.soloweb.forms.data.SWFRegistration createRegistrationsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWFRegistration");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "registrations");
    return (is.us.soloweb.forms.data.SWFRegistration) eo;
  }

  public void deleteRegistrationsRelationship(is.us.soloweb.forms.data.SWFRegistration object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "registrations");
    editingContext().deleteObject(object);
  }

  public void deleteAllRegistrationsRelationships() {
    Enumeration objects = registrations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRegistrationsRelationship((is.us.soloweb.forms.data.SWFRegistration)objects.nextElement());
    }
  }


  public static is.us.soloweb.forms.data.SWFForm createSWFForm(EOEditingContext editingContext, Integer formID
) {
    is.us.soloweb.forms.data.SWFForm eo = (is.us.soloweb.forms.data.SWFForm) EOUtilities.createAndInsertInstance(editingContext, _SWFForm.ENTITY_NAME);    
		eo.setFormID(formID);
    return eo;
  }

  public static NSArray<is.us.soloweb.forms.data.SWFForm> fetchAllSWFForms(EOEditingContext editingContext) {
    return _SWFForm.fetchAllSWFForms(editingContext, null);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFForm> fetchAllSWFForms(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWFForm.fetchSWFForms(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFForm> fetchSWFForms(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWFForm.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.forms.data.SWFForm> eoObjects = (NSArray<is.us.soloweb.forms.data.SWFForm>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static is.us.soloweb.forms.data.SWFForm fetchSWFForm(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFForm.fetchSWFForm(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFForm fetchSWFForm(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.forms.data.SWFForm> eoObjects = _SWFForm.fetchSWFForms(editingContext, qualifier, null);
    is.us.soloweb.forms.data.SWFForm eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (is.us.soloweb.forms.data.SWFForm)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWFForm that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFForm fetchRequiredSWFForm(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFForm.fetchRequiredSWFForm(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFForm fetchRequiredSWFForm(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.forms.data.SWFForm eoObject = _SWFForm.fetchSWFForm(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWFForm that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFForm localInstanceIn(EOEditingContext editingContext, is.us.soloweb.forms.data.SWFForm eo) {
    is.us.soloweb.forms.data.SWFForm localInstance = (eo == null) ? null : (is.us.soloweb.forms.data.SWFForm)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
