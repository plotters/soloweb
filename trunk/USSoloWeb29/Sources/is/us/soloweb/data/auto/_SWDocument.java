// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWDocument.java instead.
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
public abstract class _SWDocument extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWDocument";

  // Attribute Keys
  public static final ERXKey<Integer> DOCUMENT_ID = new ERXKey<Integer>("documentID");
  public static final ERXKey<Integer> DOCUMENT_TYPE_ID = new ERXKey<Integer>("documentTypeID");
  public static final ERXKey<String> EXTENSION = new ERXKey<String>("extension");
  public static final ERXKey<Integer> FOLDER_ID = new ERXKey<Integer>("folderID");
  public static final ERXKey<String> MIME_TYPE = new ERXKey<String>("mimeType");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> PICTURE_ID = new ERXKey<Integer>("pictureID");
  public static final ERXKey<String> TEXT = new ERXKey<String>("text");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWDocumentFolder> FOLDER = new ERXKey<is.us.soloweb.data.SWDocumentFolder>("folder");

  // Attributes
  public static final String DOCUMENT_ID_KEY = DOCUMENT_ID.key();
  public static final String DOCUMENT_TYPE_ID_KEY = DOCUMENT_TYPE_ID.key();
  public static final String EXTENSION_KEY = EXTENSION.key();
  public static final String FOLDER_ID_KEY = FOLDER_ID.key();
  public static final String MIME_TYPE_KEY = MIME_TYPE.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PICTURE_ID_KEY = PICTURE_ID.key();
  public static final String TEXT_KEY = TEXT.key();
  // Relationships
  public static final String FOLDER_KEY = FOLDER.key();

  private static Logger LOG = Logger.getLogger(_SWDocument.class);

  public is.us.soloweb.data.SWDocument localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWDocument localInstance = (is.us.soloweb.data.SWDocument)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer documentID() {
    return (Integer) storedValueForKey(_SWDocument.DOCUMENT_ID_KEY);
  }

  public void setDocumentID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating documentID from " + documentID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.DOCUMENT_ID_KEY);
  }

  public Integer documentTypeID() {
    return (Integer) storedValueForKey(_SWDocument.DOCUMENT_TYPE_ID_KEY);
  }

  public void setDocumentTypeID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating documentTypeID from " + documentTypeID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.DOCUMENT_TYPE_ID_KEY);
  }

  public String extension() {
    return (String) storedValueForKey(_SWDocument.EXTENSION_KEY);
  }

  public void setExtension(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating extension from " + extension() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.EXTENSION_KEY);
  }

  public Integer folderID() {
    return (Integer) storedValueForKey(_SWDocument.FOLDER_ID_KEY);
  }

  public void setFolderID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating folderID from " + folderID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.FOLDER_ID_KEY);
  }

  public String mimeType() {
    return (String) storedValueForKey(_SWDocument.MIME_TYPE_KEY);
  }

  public void setMimeType(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating mimeType from " + mimeType() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.MIME_TYPE_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWDocument.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.NAME_KEY);
  }

  public Integer pictureID() {
    return (Integer) storedValueForKey(_SWDocument.PICTURE_ID_KEY);
  }

  public void setPictureID(Integer value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating pictureID from " + pictureID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.PICTURE_ID_KEY);
  }

  public String text() {
    return (String) storedValueForKey(_SWDocument.TEXT_KEY);
  }

  public void setText(String value) {
    if (_SWDocument.LOG.isDebugEnabled()) {
    	_SWDocument.LOG.debug( "updating text from " + text() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocument.TEXT_KEY);
  }

  public is.us.soloweb.data.SWDocumentFolder folder() {
    return (is.us.soloweb.data.SWDocumentFolder)storedValueForKey(_SWDocument.FOLDER_KEY);
  }
  
  public void setFolder(is.us.soloweb.data.SWDocumentFolder value) {
    takeStoredValueForKey(value, _SWDocument.FOLDER_KEY);
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
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWDocument.FOLDER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWDocument.FOLDER_KEY);
    }
  }
  

  public static is.us.soloweb.data.SWDocument createSWDocument(EOEditingContext editingContext, Integer documentID
) {
    is.us.soloweb.data.SWDocument eo = (is.us.soloweb.data.SWDocument) EOUtilities.createAndInsertInstance(editingContext, _SWDocument.ENTITY_NAME);    
		eo.setDocumentID(documentID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWDocument> fetchAllSWDocuments(EOEditingContext editingContext) {
    return _SWDocument.fetchAllSWDocuments(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWDocument> fetchAllSWDocuments(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWDocument.fetchSWDocuments(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWDocument> fetchSWDocuments(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWDocument> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWDocument>(_SWDocument.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWDocument> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWDocument fetchSWDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocument.fetchSWDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWDocument fetchSWDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWDocument> eoObjects = _SWDocument.fetchSWDocuments(editingContext, qualifier, null);
    is.us.soloweb.data.SWDocument eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWDocument fetchRequiredSWDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocument.fetchRequiredSWDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWDocument fetchRequiredSWDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWDocument eoObject = _SWDocument.fetchSWDocument(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWDocument localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWDocument eo) {
    is.us.soloweb.data.SWDocument localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
