// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to is.us.soloweb.forms.data.SWFFieldSet.java instead.
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
public abstract class _SWFFieldSet extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWFFieldSet";

  // Attribute Keys
  public static final ERXKey<Integer> FIELD_SET_ID = new ERXKey<Integer>("fieldSetID");
  public static final ERXKey<Integer> FORM_ID = new ERXKey<Integer>("formID");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> SORT_NUMBER = new ERXKey<Integer>("sortNumber");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.forms.data.SWFField> FIELDS = new ERXKey<is.us.soloweb.forms.data.SWFField>("fields");
  public static final ERXKey<is.us.soloweb.forms.data.SWFForm> FORM = new ERXKey<is.us.soloweb.forms.data.SWFForm>("form");

  // Attributes
  public static final String FIELD_SET_ID_KEY = FIELD_SET_ID.key();
  public static final String FORM_ID_KEY = FORM_ID.key();
  public static final String NAME_KEY = NAME.key();
  public static final String SORT_NUMBER_KEY = SORT_NUMBER.key();
  // Relationships
  public static final String FIELDS_KEY = FIELDS.key();
  public static final String FORM_KEY = FORM.key();

  private static Logger LOG = Logger.getLogger(_SWFFieldSet.class);

  public is.us.soloweb.forms.data.SWFFieldSet localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.forms.data.SWFFieldSet localInstance = (is.us.soloweb.forms.data.SWFFieldSet)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer fieldSetID() {
    return (Integer) storedValueForKey("fieldSetID");
  }

  public void setFieldSetID(Integer value) {
    if (_SWFFieldSet.LOG.isDebugEnabled()) {
    	_SWFFieldSet.LOG.debug( "updating fieldSetID from " + fieldSetID() + " to " + value);
    }
    takeStoredValueForKey(value, "fieldSetID");
  }

  public Integer formID() {
    return (Integer) storedValueForKey("formID");
  }

  public void setFormID(Integer value) {
    if (_SWFFieldSet.LOG.isDebugEnabled()) {
    	_SWFFieldSet.LOG.debug( "updating formID from " + formID() + " to " + value);
    }
    takeStoredValueForKey(value, "formID");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWFFieldSet.LOG.isDebugEnabled()) {
    	_SWFFieldSet.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public Integer sortNumber() {
    return (Integer) storedValueForKey("sortNumber");
  }

  public void setSortNumber(Integer value) {
    if (_SWFFieldSet.LOG.isDebugEnabled()) {
    	_SWFFieldSet.LOG.debug( "updating sortNumber from " + sortNumber() + " to " + value);
    }
    takeStoredValueForKey(value, "sortNumber");
  }

  public is.us.soloweb.forms.data.SWFForm form() {
    return (is.us.soloweb.forms.data.SWFForm)storedValueForKey("form");
  }
  
  public void setForm(is.us.soloweb.forms.data.SWFForm value) {
    takeStoredValueForKey(value, "form");
  }

  public void setFormRelationship(is.us.soloweb.forms.data.SWFForm value) {
    if (_SWFFieldSet.LOG.isDebugEnabled()) {
      _SWFFieldSet.LOG.debug("updating form from " + form() + " to " + value);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFField.FIELD_SET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_SWFFieldSet.LOG.isDebugEnabled()) {
      _SWFFieldSet.LOG.debug("adding " + object + " to fields relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToFields(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "fields");
    }
  }

  public void removeFromFieldsRelationship(is.us.soloweb.forms.data.SWFField object) {
    if (_SWFFieldSet.LOG.isDebugEnabled()) {
      _SWFFieldSet.LOG.debug("removing " + object + " from fields relationship");
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


  public static is.us.soloweb.forms.data.SWFFieldSet createSWFFieldSet(EOEditingContext editingContext, Integer fieldSetID
) {
    is.us.soloweb.forms.data.SWFFieldSet eo = (is.us.soloweb.forms.data.SWFFieldSet) EOUtilities.createAndInsertInstance(editingContext, _SWFFieldSet.ENTITY_NAME);    
		eo.setFieldSetID(fieldSetID);
    return eo;
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFieldSet> fetchAllSWFFieldSets(EOEditingContext editingContext) {
    return _SWFFieldSet.fetchAllSWFFieldSets(editingContext, null);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFieldSet> fetchAllSWFFieldSets(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWFFieldSet.fetchSWFFieldSets(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFieldSet> fetchSWFFieldSets(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWFFieldSet.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.forms.data.SWFFieldSet> eoObjects = (NSArray<is.us.soloweb.forms.data.SWFFieldSet>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static is.us.soloweb.forms.data.SWFFieldSet fetchSWFFieldSet(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFFieldSet.fetchSWFFieldSet(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFFieldSet fetchSWFFieldSet(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.forms.data.SWFFieldSet> eoObjects = _SWFFieldSet.fetchSWFFieldSets(editingContext, qualifier, null);
    is.us.soloweb.forms.data.SWFFieldSet eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (is.us.soloweb.forms.data.SWFFieldSet)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWFFieldSet that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFFieldSet fetchRequiredSWFFieldSet(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFFieldSet.fetchRequiredSWFFieldSet(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFFieldSet fetchRequiredSWFFieldSet(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.forms.data.SWFFieldSet eoObject = _SWFFieldSet.fetchSWFFieldSet(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWFFieldSet that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFFieldSet localInstanceIn(EOEditingContext editingContext, is.us.soloweb.forms.data.SWFFieldSet eo) {
    is.us.soloweb.forms.data.SWFFieldSet localInstance = (eo == null) ? null : (is.us.soloweb.forms.data.SWFFieldSet)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
