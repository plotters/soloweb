// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWDocumentType.java instead.
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
public abstract class _SWDocumentType extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWDocumentType";

  // Attribute Keys
  public static final ERXKey<Integer> DOCUMENT_ID = new ERXKey<Integer>("documentID");
  public static final ERXKey<Integer> DOCUMENT_TYPE_ID = new ERXKey<Integer>("documentTypeID");
  public static final ERXKey<String> EXTENSION = new ERXKey<String>("extension");
  public static final ERXKey<String> MIME_TYPE = new ERXKey<String>("mimeType");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> PICTURE_ID = new ERXKey<Integer>("pictureID");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWDocument> DOCUMENT = new ERXKey<is.us.soloweb.data.SWDocument>("document");

  // Attributes
  public static final String DOCUMENT_ID_KEY = DOCUMENT_ID.key();
  public static final String DOCUMENT_TYPE_ID_KEY = DOCUMENT_TYPE_ID.key();
  public static final String EXTENSION_KEY = EXTENSION.key();
  public static final String MIME_TYPE_KEY = MIME_TYPE.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PICTURE_ID_KEY = PICTURE_ID.key();
  // Relationships
  public static final String DOCUMENT_KEY = DOCUMENT.key();

  private static Logger LOG = Logger.getLogger(_SWDocumentType.class);

  public SWDocumentType localInstanceIn(EOEditingContext editingContext) {
    SWDocumentType localInstance = (SWDocumentType)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer documentID() {
    return (Integer) storedValueForKey("documentID");
  }

  public void setDocumentID(Integer value) {
    if (_SWDocumentType.LOG.isDebugEnabled()) {
    	_SWDocumentType.LOG.debug( "updating documentID from " + documentID() + " to " + value);
    }
    takeStoredValueForKey(value, "documentID");
  }

  public Integer documentTypeID() {
    return (Integer) storedValueForKey("documentTypeID");
  }

  public void setDocumentTypeID(Integer value) {
    if (_SWDocumentType.LOG.isDebugEnabled()) {
    	_SWDocumentType.LOG.debug( "updating documentTypeID from " + documentTypeID() + " to " + value);
    }
    takeStoredValueForKey(value, "documentTypeID");
  }

  public String extension() {
    return (String) storedValueForKey("extension");
  }

  public void setExtension(String value) {
    if (_SWDocumentType.LOG.isDebugEnabled()) {
    	_SWDocumentType.LOG.debug( "updating extension from " + extension() + " to " + value);
    }
    takeStoredValueForKey(value, "extension");
  }

  public String mimeType() {
    return (String) storedValueForKey("mimeType");
  }

  public void setMimeType(String value) {
    if (_SWDocumentType.LOG.isDebugEnabled()) {
    	_SWDocumentType.LOG.debug( "updating mimeType from " + mimeType() + " to " + value);
    }
    takeStoredValueForKey(value, "mimeType");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWDocumentType.LOG.isDebugEnabled()) {
    	_SWDocumentType.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public Integer pictureID() {
    return (Integer) storedValueForKey("pictureID");
  }

  public void setPictureID(Integer value) {
    if (_SWDocumentType.LOG.isDebugEnabled()) {
    	_SWDocumentType.LOG.debug( "updating pictureID from " + pictureID() + " to " + value);
    }
    takeStoredValueForKey(value, "pictureID");
  }

  public is.us.soloweb.data.SWDocument document() {
    return (is.us.soloweb.data.SWDocument)storedValueForKey("document");
  }
  
  public void setDocument(is.us.soloweb.data.SWDocument value) {
    takeStoredValueForKey(value, "document");
  }

  public void setDocumentRelationship(is.us.soloweb.data.SWDocument value) {
    if (_SWDocumentType.LOG.isDebugEnabled()) {
      _SWDocumentType.LOG.debug("updating document from " + document() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocument(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocument oldValue = document();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "document");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "document");
    }
  }
  

  public static SWDocumentType createSWDocumentType(EOEditingContext editingContext, Integer documentTypeID
) {
    SWDocumentType eo = (SWDocumentType) EOUtilities.createAndInsertInstance(editingContext, _SWDocumentType.ENTITY_NAME);    
		eo.setDocumentTypeID(documentTypeID);
    return eo;
  }

  public static NSArray<SWDocumentType> fetchAllSWDocumentTypes(EOEditingContext editingContext) {
    return _SWDocumentType.fetchAllSWDocumentTypes(editingContext, null);
  }

  public static NSArray<SWDocumentType> fetchAllSWDocumentTypes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWDocumentType.fetchSWDocumentTypes(editingContext, null, sortOrderings);
  }

  public static NSArray<SWDocumentType> fetchSWDocumentTypes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWDocumentType.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWDocumentType> eoObjects = (NSArray<SWDocumentType>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWDocumentType fetchSWDocumentType(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocumentType.fetchSWDocumentType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWDocumentType fetchSWDocumentType(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWDocumentType> eoObjects = _SWDocumentType.fetchSWDocumentTypes(editingContext, qualifier, null);
    SWDocumentType eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWDocumentType)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWDocumentType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWDocumentType fetchRequiredSWDocumentType(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocumentType.fetchRequiredSWDocumentType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWDocumentType fetchRequiredSWDocumentType(EOEditingContext editingContext, EOQualifier qualifier) {
    SWDocumentType eoObject = _SWDocumentType.fetchSWDocumentType(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWDocumentType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWDocumentType localInstanceIn(EOEditingContext editingContext, SWDocumentType eo) {
    SWDocumentType localInstance = (eo == null) ? null : (SWDocumentType)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
