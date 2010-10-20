// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWDocumentFolder.java instead.
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
public abstract class _SWDocumentFolder extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWDocumentFolder";

  // Attribute Keys
  public static final ERXKey<Integer> FOLDER_ID = new ERXKey<Integer>("folderID");
  public static final ERXKey<Integer> INHERITS_PRIVILEGES = new ERXKey<Integer>("inheritsPrivileges");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> PARENT_FOLDER_ID = new ERXKey<Integer>("parentFolderID");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWDocumentFolder> CHILDREN = new ERXKey<is.us.soloweb.data.SWDocumentFolder>("children");
  public static final ERXKey<is.us.soloweb.data.SWDocument> DOCUMENTS = new ERXKey<is.us.soloweb.data.SWDocument>("documents");
  public static final ERXKey<is.us.soloweb.data.SWDocumentFolder> PARENT = new ERXKey<is.us.soloweb.data.SWDocumentFolder>("parent");

  // Attributes
  public static final String FOLDER_ID_KEY = FOLDER_ID.key();
  public static final String INHERITS_PRIVILEGES_KEY = INHERITS_PRIVILEGES.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PARENT_FOLDER_ID_KEY = PARENT_FOLDER_ID.key();
  // Relationships
  public static final String CHILDREN_KEY = CHILDREN.key();
  public static final String DOCUMENTS_KEY = DOCUMENTS.key();
  public static final String PARENT_KEY = PARENT.key();

  private static Logger LOG = Logger.getLogger(_SWDocumentFolder.class);

  public is.us.soloweb.data.SWDocumentFolder localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWDocumentFolder localInstance = (is.us.soloweb.data.SWDocumentFolder)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer folderID() {
    return (Integer) storedValueForKey(_SWDocumentFolder.FOLDER_ID_KEY);
  }

  public void setFolderID(Integer value) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
    	_SWDocumentFolder.LOG.debug( "updating folderID from " + folderID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocumentFolder.FOLDER_ID_KEY);
  }

  public Integer inheritsPrivileges() {
    return (Integer) storedValueForKey(_SWDocumentFolder.INHERITS_PRIVILEGES_KEY);
  }

  public void setInheritsPrivileges(Integer value) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
    	_SWDocumentFolder.LOG.debug( "updating inheritsPrivileges from " + inheritsPrivileges() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocumentFolder.INHERITS_PRIVILEGES_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWDocumentFolder.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
    	_SWDocumentFolder.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocumentFolder.NAME_KEY);
  }

  public Integer parentFolderID() {
    return (Integer) storedValueForKey(_SWDocumentFolder.PARENT_FOLDER_ID_KEY);
  }

  public void setParentFolderID(Integer value) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
    	_SWDocumentFolder.LOG.debug( "updating parentFolderID from " + parentFolderID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWDocumentFolder.PARENT_FOLDER_ID_KEY);
  }

  public is.us.soloweb.data.SWDocumentFolder parent() {
    return (is.us.soloweb.data.SWDocumentFolder)storedValueForKey(_SWDocumentFolder.PARENT_KEY);
  }
  
  public void setParent(is.us.soloweb.data.SWDocumentFolder value) {
    takeStoredValueForKey(value, _SWDocumentFolder.PARENT_KEY);
  }

  public void setParentRelationship(is.us.soloweb.data.SWDocumentFolder value) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
      _SWDocumentFolder.LOG.debug("updating parent from " + parent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setParent(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocumentFolder oldValue = parent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWDocumentFolder.PARENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWDocumentFolder.PARENT_KEY);
    }
  }
  
  public NSArray<is.us.soloweb.data.SWDocumentFolder> children() {
    return (NSArray<is.us.soloweb.data.SWDocumentFolder>)storedValueForKey(_SWDocumentFolder.CHILDREN_KEY);
  }

  public NSArray<is.us.soloweb.data.SWDocumentFolder> children(EOQualifier qualifier) {
    return children(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWDocumentFolder> children(EOQualifier qualifier, boolean fetch) {
    return children(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWDocumentFolder> children(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWDocumentFolder> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWDocumentFolder.PARENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWDocumentFolder.fetchSWDocumentFolders(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = children();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWDocumentFolder>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWDocumentFolder>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToChildren(is.us.soloweb.data.SWDocumentFolder object) {
    includeObjectIntoPropertyWithKey(object, _SWDocumentFolder.CHILDREN_KEY);
  }

  public void removeFromChildren(is.us.soloweb.data.SWDocumentFolder object) {
    excludeObjectFromPropertyWithKey(object, _SWDocumentFolder.CHILDREN_KEY);
  }

  public void addToChildrenRelationship(is.us.soloweb.data.SWDocumentFolder object) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
      _SWDocumentFolder.LOG.debug("adding " + object + " to children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChildren(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWDocumentFolder.CHILDREN_KEY);
    }
  }

  public void removeFromChildrenRelationship(is.us.soloweb.data.SWDocumentFolder object) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
      _SWDocumentFolder.LOG.debug("removing " + object + " from children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromChildren(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWDocumentFolder.CHILDREN_KEY);
    }
  }

  public is.us.soloweb.data.SWDocumentFolder createChildrenRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWDocumentFolder.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWDocumentFolder.CHILDREN_KEY);
    return (is.us.soloweb.data.SWDocumentFolder) eo;
  }

  public void deleteChildrenRelationship(is.us.soloweb.data.SWDocumentFolder object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWDocumentFolder.CHILDREN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllChildrenRelationships() {
    Enumeration<is.us.soloweb.data.SWDocumentFolder> objects = children().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChildrenRelationship(objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.data.SWDocument> documents() {
    return (NSArray<is.us.soloweb.data.SWDocument>)storedValueForKey(_SWDocumentFolder.DOCUMENTS_KEY);
  }

  public NSArray<is.us.soloweb.data.SWDocument> documents(EOQualifier qualifier) {
    return documents(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWDocument> documents(EOQualifier qualifier, boolean fetch) {
    return documents(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWDocument> documents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWDocument> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWDocument.FOLDER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWDocument.fetchSWDocuments(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = documents();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWDocument>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWDocument>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToDocuments(is.us.soloweb.data.SWDocument object) {
    includeObjectIntoPropertyWithKey(object, _SWDocumentFolder.DOCUMENTS_KEY);
  }

  public void removeFromDocuments(is.us.soloweb.data.SWDocument object) {
    excludeObjectFromPropertyWithKey(object, _SWDocumentFolder.DOCUMENTS_KEY);
  }

  public void addToDocumentsRelationship(is.us.soloweb.data.SWDocument object) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
      _SWDocumentFolder.LOG.debug("adding " + object + " to documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocuments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWDocumentFolder.DOCUMENTS_KEY);
    }
  }

  public void removeFromDocumentsRelationship(is.us.soloweb.data.SWDocument object) {
    if (_SWDocumentFolder.LOG.isDebugEnabled()) {
      _SWDocumentFolder.LOG.debug("removing " + object + " from documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDocuments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWDocumentFolder.DOCUMENTS_KEY);
    }
  }

  public is.us.soloweb.data.SWDocument createDocumentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWDocument.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWDocumentFolder.DOCUMENTS_KEY);
    return (is.us.soloweb.data.SWDocument) eo;
  }

  public void deleteDocumentsRelationship(is.us.soloweb.data.SWDocument object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWDocumentFolder.DOCUMENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsRelationships() {
    Enumeration<is.us.soloweb.data.SWDocument> objects = documents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsRelationship(objects.nextElement());
    }
  }


  public static is.us.soloweb.data.SWDocumentFolder createSWDocumentFolder(EOEditingContext editingContext, Integer folderID
) {
    is.us.soloweb.data.SWDocumentFolder eo = (is.us.soloweb.data.SWDocumentFolder) EOUtilities.createAndInsertInstance(editingContext, _SWDocumentFolder.ENTITY_NAME);    
		eo.setFolderID(folderID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWDocumentFolder> fetchAllSWDocumentFolders(EOEditingContext editingContext) {
    return _SWDocumentFolder.fetchAllSWDocumentFolders(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWDocumentFolder> fetchAllSWDocumentFolders(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWDocumentFolder.fetchSWDocumentFolders(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWDocumentFolder> fetchSWDocumentFolders(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWDocumentFolder> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWDocumentFolder>(_SWDocumentFolder.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWDocumentFolder> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWDocumentFolder fetchSWDocumentFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocumentFolder.fetchSWDocumentFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWDocumentFolder fetchSWDocumentFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWDocumentFolder> eoObjects = _SWDocumentFolder.fetchSWDocumentFolders(editingContext, qualifier, null);
    is.us.soloweb.data.SWDocumentFolder eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWDocumentFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWDocumentFolder fetchRequiredSWDocumentFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWDocumentFolder.fetchRequiredSWDocumentFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWDocumentFolder fetchRequiredSWDocumentFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWDocumentFolder eoObject = _SWDocumentFolder.fetchSWDocumentFolder(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWDocumentFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWDocumentFolder localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWDocumentFolder eo) {
    is.us.soloweb.data.SWDocumentFolder localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
