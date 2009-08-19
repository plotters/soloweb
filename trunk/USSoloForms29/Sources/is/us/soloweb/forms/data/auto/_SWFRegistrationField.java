// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to is.us.soloweb.forms.data.SWFRegistrationField.java instead.
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
public abstract class _SWFRegistrationField extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWFRegistrationField";

  // Attribute Keys
  public static final ERXKey<NSData> BINARY_VALUE = new ERXKey<NSData>("binaryValue");
  public static final ERXKey<Integer> FIELD_ID = new ERXKey<Integer>("fieldID");
  public static final ERXKey<String> MIME_TYPE = new ERXKey<String>("mimeType");
  public static final ERXKey<Integer> REGISTRATION_FIELD_ID = new ERXKey<Integer>("registrationFieldID");
  public static final ERXKey<Integer> REGISTRATION_ID = new ERXKey<Integer>("registrationID");
  public static final ERXKey<String> VALUE = new ERXKey<String>("value");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.forms.data.SWFField> FIELD = new ERXKey<is.us.soloweb.forms.data.SWFField>("field");
  public static final ERXKey<is.us.soloweb.forms.data.SWFRegistration> REGISTRATION = new ERXKey<is.us.soloweb.forms.data.SWFRegistration>("registration");

  // Attributes
  public static final String BINARY_VALUE_KEY = BINARY_VALUE.key();
  public static final String FIELD_ID_KEY = FIELD_ID.key();
  public static final String MIME_TYPE_KEY = MIME_TYPE.key();
  public static final String REGISTRATION_FIELD_ID_KEY = REGISTRATION_FIELD_ID.key();
  public static final String REGISTRATION_ID_KEY = REGISTRATION_ID.key();
  public static final String VALUE_KEY = VALUE.key();
  // Relationships
  public static final String FIELD_KEY = FIELD.key();
  public static final String REGISTRATION_KEY = REGISTRATION.key();

  private static Logger LOG = Logger.getLogger(_SWFRegistrationField.class);

  public is.us.soloweb.forms.data.SWFRegistrationField localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.forms.data.SWFRegistrationField localInstance = (is.us.soloweb.forms.data.SWFRegistrationField)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSData binaryValue() {
    return (NSData) storedValueForKey("binaryValue");
  }

  public void setBinaryValue(NSData value) {
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
    	_SWFRegistrationField.LOG.debug( "updating binaryValue from " + binaryValue() + " to " + value);
    }
    takeStoredValueForKey(value, "binaryValue");
  }

  public Integer fieldID() {
    return (Integer) storedValueForKey("fieldID");
  }

  public void setFieldID(Integer value) {
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
    	_SWFRegistrationField.LOG.debug( "updating fieldID from " + fieldID() + " to " + value);
    }
    takeStoredValueForKey(value, "fieldID");
  }

  public String mimeType() {
    return (String) storedValueForKey("mimeType");
  }

  public void setMimeType(String value) {
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
    	_SWFRegistrationField.LOG.debug( "updating mimeType from " + mimeType() + " to " + value);
    }
    takeStoredValueForKey(value, "mimeType");
  }

  public Integer registrationFieldID() {
    return (Integer) storedValueForKey("registrationFieldID");
  }

  public void setRegistrationFieldID(Integer value) {
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
    	_SWFRegistrationField.LOG.debug( "updating registrationFieldID from " + registrationFieldID() + " to " + value);
    }
    takeStoredValueForKey(value, "registrationFieldID");
  }

  public Integer registrationID() {
    return (Integer) storedValueForKey("registrationID");
  }

  public void setRegistrationID(Integer value) {
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
    	_SWFRegistrationField.LOG.debug( "updating registrationID from " + registrationID() + " to " + value);
    }
    takeStoredValueForKey(value, "registrationID");
  }

  public String value() {
    return (String) storedValueForKey("value");
  }

  public void setValue(String value) {
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
    	_SWFRegistrationField.LOG.debug( "updating value from " + value() + " to " + value);
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
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
      _SWFRegistrationField.LOG.debug("updating field from " + field() + " to " + value);
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
  
  public is.us.soloweb.forms.data.SWFRegistration registration() {
    return (is.us.soloweb.forms.data.SWFRegistration)storedValueForKey("registration");
  }
  
  public void setRegistration(is.us.soloweb.forms.data.SWFRegistration value) {
    takeStoredValueForKey(value, "registration");
  }

  public void setRegistrationRelationship(is.us.soloweb.forms.data.SWFRegistration value) {
    if (_SWFRegistrationField.LOG.isDebugEnabled()) {
      _SWFRegistrationField.LOG.debug("updating registration from " + registration() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setRegistration(value);
    }
    else if (value == null) {
    	is.us.soloweb.forms.data.SWFRegistration oldValue = registration();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "registration");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "registration");
    }
  }
  

  public static is.us.soloweb.forms.data.SWFRegistrationField createSWFRegistrationField(EOEditingContext editingContext, Integer registrationFieldID
) {
    is.us.soloweb.forms.data.SWFRegistrationField eo = (is.us.soloweb.forms.data.SWFRegistrationField) EOUtilities.createAndInsertInstance(editingContext, _SWFRegistrationField.ENTITY_NAME);    
		eo.setRegistrationFieldID(registrationFieldID);
    return eo;
  }

  public static NSArray<is.us.soloweb.forms.data.SWFRegistrationField> fetchAllSWFRegistrationFields(EOEditingContext editingContext) {
    return _SWFRegistrationField.fetchAllSWFRegistrationFields(editingContext, null);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFRegistrationField> fetchAllSWFRegistrationFields(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWFRegistrationField.fetchSWFRegistrationFields(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFRegistrationField> fetchSWFRegistrationFields(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWFRegistrationField.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.forms.data.SWFRegistrationField> eoObjects = (NSArray<is.us.soloweb.forms.data.SWFRegistrationField>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static is.us.soloweb.forms.data.SWFRegistrationField fetchSWFRegistrationField(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFRegistrationField.fetchSWFRegistrationField(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFRegistrationField fetchSWFRegistrationField(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.forms.data.SWFRegistrationField> eoObjects = _SWFRegistrationField.fetchSWFRegistrationFields(editingContext, qualifier, null);
    is.us.soloweb.forms.data.SWFRegistrationField eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (is.us.soloweb.forms.data.SWFRegistrationField)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWFRegistrationField that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFRegistrationField fetchRequiredSWFRegistrationField(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFRegistrationField.fetchRequiredSWFRegistrationField(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFRegistrationField fetchRequiredSWFRegistrationField(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.forms.data.SWFRegistrationField eoObject = _SWFRegistrationField.fetchSWFRegistrationField(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWFRegistrationField that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFRegistrationField localInstanceIn(EOEditingContext editingContext, is.us.soloweb.forms.data.SWFRegistrationField eo) {
    is.us.soloweb.forms.data.SWFRegistrationField localInstance = (eo == null) ? null : (is.us.soloweb.forms.data.SWFRegistrationField)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
