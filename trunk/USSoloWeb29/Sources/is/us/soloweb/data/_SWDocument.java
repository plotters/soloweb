// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWDocument.java instead.
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
public abstract class _SWDocument extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWDocument";

  // Attribute Keys
  public static final ERXKey<Integer> DOCUMENT_FOLDER_ID = new ERXKey<Integer>("documentFolderID");
  public static final ERXKey<Integer> DOCUMENT_ID = new ERXKey<Integer>("documentID");
  public static final ERXKey<Integer> DOCUMENT_TYPE_ID = new ERXKey<Integer>("documentTypeID");
  public static final ERXKey<String> EXTENSION = new ERXKey<String>("extension");
  public static final ERXKey<String> MIME_TYPE = new ERXKey<String>("mimeType");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> PICTURE_ID = new ERXKey<Integer>("pictureID");
  public static final ERXKey<String> TEXT = new ERXKey<String>("text");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWDocumentType> DOCUMENT_TYPE = new ERXKey<is.us.soloweb.data.SWDocumentType>("documentType");
  public static final ERXKey<is.us.soloweb.data.SWDocumentFolder> FOLDER = new ERXKey<is.us.soloweb.data.SWDocumentFolder>("folder");

  // Attributes
  public static final String DOCUMENT_FOLDER_ID_KEY = DOCUMENT_FOLDER_ID.key();
  public static final String DOCUMENT_ID_KEY = DOCUMENT_ID.key();
  public static final String DOCUMENT_TYPE_ID_KEY = DOCUMENT_TYPE_ID.key();
  public static final String EXTENSION_KEY = EXTENSION.key();
  public static final String MIME_TYPE_KEY = MIME_TYPE.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PICTURE_ID_KEY = PICTURE_ID.key();
  public static final String TEXT_KEY = TEXT.key();
  // Relationships
  public static final String DOCUMENT_TYPE_KEY = DOCUMENT_TYPE.key();
  public static final String FOLDER_KEY = FOLDER.key();

  private static Logger LOG = Logger.getLogger(_SWDocument.class);

  public SWDocument localInstanceIn(EOEditingContext editingContext) {
    SWDocument localInstance = (SWDocument)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer documentFolderID() {
    return (Integer) storedValueForKey("documentFolderID");
  }

  public void setDocumentFolderID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating documentFolderID from " + documentFolderID() + " to " + value);
    }
    takeStoredValueForKey(value, "documentFolderID");
  }

  public Integer documentID() {
    return (Integer) storedValueForKey("documentID");
  }

  public void setDocumentID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating documentID from " + documentID() + " to " + value);
    }
    takeStoredValueForKey(value, "documentID");
  }

  public Integer documentTypeID() {
    return (Integer) storedValueForKey("documentTypeID");
  }

  public void setDocumentTypeID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating documentTypeID from " + documentTypeID() + " to " + value);
    }
    takeStoredValueForKey(value, "documentTypeID");
  }

  public String extension() {
    return (String) storedValueForKey("extension");
  }

  public void setExtension(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating extension from " + extension() + " to " + value);
    }
    takeStoredValueForKey(value, "extension");
  }

  public String mimeType() {
    return (String) storedValueForKey("mimeType");
  }

  public void setMimeType(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating mimeType from " + mimeType() + " to " + value);
    }
    takeStoredValueForKey(value, "mimeType");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public Integer pictureID() {
    return (Integer) storedValueForKey("pictureID");
  }

  public void setPictureID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating pictureID from " + pictureID() + " to " + value);
    }
    takeStoredValueForKey(value, "pictureID");
  }

  public String text() {
    return (String) storedValueForKey("text");
  }

  public void setText(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating text from " + text() + " to " + value);
    }
    takeStoredValueForKey(value, "text");
  }

  public is.us.soloweb.data.SWDocumentType documentType() {
    return (is.us.soloweb.data.SWDocumentType)storedValueForKey("documentType");
  }
  
  public void setDocumentType(is.us.soloweb.data.SWDocumentType value) {
    takeStoredValueForKey(value, "documentType");
  }

  public void setDocumentTypeRelationship(is.us.soloweb.data.SWDocumentType value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
      _SWDocument.LOG.debug("updating documentType from " + documentType() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocumentType(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocumentType oldValue = documentType();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "documentType");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "documentType");
    }
  }
  
  public is.us.soloweb.data.SWDocumentFolder folder() {
    return (is.us.soloweb.data.SWDocumentFolder)storedValueForKey("folder");
  }
  
  public void setFolder(is.us.soloweb.data.SWDocumentFolder value) {
    takeStoredValueForKey(value, "folder");
  }

  public void setFolderRelationship(is.us.soloweb.data.SWDocumentFolder value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
      _SWDocument.LOG.debug("updating folder from " + folder() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setFolder(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocumentFolder oldValue = folder();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "folder");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "folder");
    }
  }
  

  public static SWDocument createSWDocument(EOEditingContext editingContext, Integer documentID
) {
    SWDocument eo = (SWDocument) EOUtilities.createAndInsertInstance(editingContext, _SWDocument.ENTITY_NAME);    
		eo.setDocumentID(documentID);
    return eo;
  }

  public static NSArray<SWDocument> fetchAllSWDocuments(EOEditingContext editingContext) {
    return _SWDocument.fetchAllSWDocuments(editingContext, null);
  }

  public static NSArray<SWDocument> fetchAllSWDocuments(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWDocument.fetchSWDocuments(editingContext, null, sortOrderings);
  }

  public static NSArray<SWDocument> fetchSWDocuments(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWDocument.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWDocument> eoObjects = (NSArray<SWDocument>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWDocument fetchSWDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocument.fetchSWDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWDocument fetchSWDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWDocument> eoObjects = _SWDocument.fetchSWDocuments(editingContext, qualifier, null);
    SWDocument eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWDocument)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWDocument fetchRequiredSWDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocument.fetchRequiredSWDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWDocument fetchRequiredSWDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    SWDocument eoObject = _SWDocument.fetchSWDocument(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWDocument localInstanceIn(EOEditingContext editingContext, SWDocument eo) {
    SWDocument localInstance = (eo == null) ? null : (SWDocument)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
