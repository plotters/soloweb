// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to is.us.soloweb.forms.data.SWFRegistration.java instead.
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
public abstract class _SWFRegistration extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWFRegistration";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> DATE = new ERXKey<NSTimestamp>("date");
  public static final ERXKey<Integer> FORM_ID = new ERXKey<Integer>("formID");
  public static final ERXKey<Integer> REGISTRATION_ID = new ERXKey<Integer>("registrationID");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.forms.data.SWFForm> FORM = new ERXKey<is.us.soloweb.forms.data.SWFForm>("form");
  public static final ERXKey<is.us.soloweb.forms.data.SWFRegistrationField> REGISTRATION_FIELDS = new ERXKey<is.us.soloweb.forms.data.SWFRegistrationField>("registrationFields");

  // Attributes
  public static final String DATE_KEY = DATE.key();
  public static final String FORM_ID_KEY = FORM_ID.key();
  public static final String REGISTRATION_ID_KEY = REGISTRATION_ID.key();
  // Relationships
  public static final String FORM_KEY = FORM.key();
  public static final String REGISTRATION_FIELDS_KEY = REGISTRATION_FIELDS.key();

  private static Logger LOG = Logger.getLogger(_SWFRegistration.class);

  public is.us.soloweb.forms.data.SWFRegistration localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.forms.data.SWFRegistration localInstance = (is.us.soloweb.forms.data.SWFRegistration)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp date() {
    return (NSTimestamp) storedValueForKey("date");
  }

  public void setDate(NSTimestamp value) {
    if (_SWFRegistration.LOG.isDebugEnabled()) {
    	_SWFRegistration.LOG.debug( "updating date from " + date() + " to " + value);
    }
    takeStoredValueForKey(value, "date");
  }

  public Integer formID() {
    return (Integer) storedValueForKey("formID");
  }

  public void setFormID(Integer value) {
    if (_SWFRegistration.LOG.isDebugEnabled()) {
    	_SWFRegistration.LOG.debug( "updating formID from " + formID() + " to " + value);
    }
    takeStoredValueForKey(value, "formID");
  }

  public Integer registrationID() {
    return (Integer) storedValueForKey("registrationID");
  }

  public void setRegistrationID(Integer value) {
    if (_SWFRegistration.LOG.isDebugEnabled()) {
    	_SWFRegistration.LOG.debug( "updating registrationID from " + registrationID() + " to " + value);
    }
    takeStoredValueForKey(value, "registrationID");
  }

  public is.us.soloweb.forms.data.SWFForm form() {
    return (is.us.soloweb.forms.data.SWFForm)storedValueForKey("form");
  }
  
  public void setForm(is.us.soloweb.forms.data.SWFForm value) {
    takeStoredValueForKey(value, "form");
  }

  public void setFormRelationship(is.us.soloweb.forms.data.SWFForm value) {
    if (_SWFRegistration.LOG.isDebugEnabled()) {
      _SWFRegistration.LOG.debug("updating form from " + form() + " to " + value);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFRegistrationField.REGISTRATION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_SWFRegistration.LOG.isDebugEnabled()) {
      _SWFRegistration.LOG.debug("adding " + object + " to registrationFields relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToRegistrationFields(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "registrationFields");
    }
  }

  public void removeFromRegistrationFieldsRelationship(is.us.soloweb.forms.data.SWFRegistrationField object) {
    if (_SWFRegistration.LOG.isDebugEnabled()) {
      _SWFRegistration.LOG.debug("removing " + object + " from registrationFields relationship");
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


  public static is.us.soloweb.forms.data.SWFRegistration createSWFRegistration(EOEditingContext editingContext, Integer registrationID
) {
    is.us.soloweb.forms.data.SWFRegistration eo = (is.us.soloweb.forms.data.SWFRegistration) EOUtilities.createAndInsertInstance(editingContext, _SWFRegistration.ENTITY_NAME);    
		eo.setRegistrationID(registrationID);
    return eo;
  }

  public static NSArray<is.us.soloweb.forms.data.SWFRegistration> fetchAllSWFRegistrations(EOEditingContext editingContext) {
    return _SWFRegistration.fetchAllSWFRegistrations(editingContext, null);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFRegistration> fetchAllSWFRegistrations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWFRegistration.fetchSWFRegistrations(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFRegistration> fetchSWFRegistrations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWFRegistration.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.forms.data.SWFRegistration> eoObjects = (NSArray<is.us.soloweb.forms.data.SWFRegistration>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static is.us.soloweb.forms.data.SWFRegistration fetchSWFRegistration(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFRegistration.fetchSWFRegistration(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFRegistration fetchSWFRegistration(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.forms.data.SWFRegistration> eoObjects = _SWFRegistration.fetchSWFRegistrations(editingContext, qualifier, null);
    is.us.soloweb.forms.data.SWFRegistration eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (is.us.soloweb.forms.data.SWFRegistration)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWFRegistration that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFRegistration fetchRequiredSWFRegistration(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFRegistration.fetchRequiredSWFRegistration(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFRegistration fetchRequiredSWFRegistration(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.forms.data.SWFRegistration eoObject = _SWFRegistration.fetchSWFRegistration(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWFRegistration that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFRegistration localInstanceIn(EOEditingContext editingContext, is.us.soloweb.forms.data.SWFRegistration eo) {
    is.us.soloweb.forms.data.SWFRegistration localInstance = (eo == null) ? null : (is.us.soloweb.forms.data.SWFRegistration)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
