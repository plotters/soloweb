// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWNewsFolder.java instead.
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
public abstract class _SWNewsFolder extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWNewsFolder";

  // Attribute Keys
  public static final ERXKey<Integer> FOLDER_ID = new ERXKey<Integer>("folderID");
  public static final ERXKey<Integer> INHERITS_PRIVILEGES = new ERXKey<Integer>("inheritsPrivileges");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> PARENT_FOLDER_ID = new ERXKey<Integer>("parentFolderID");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWNewsFolder> CHILDREN = new ERXKey<is.us.soloweb.data.SWNewsFolder>("children");
  public static final ERXKey<is.us.soloweb.data.SWNewsItem> DOCUMENTS = new ERXKey<is.us.soloweb.data.SWNewsItem>("documents");
  public static final ERXKey<is.us.soloweb.data.SWNewsFolder> PARENT = new ERXKey<is.us.soloweb.data.SWNewsFolder>("parent");

  // Attributes
  public static final String FOLDER_ID_KEY = FOLDER_ID.key();
  public static final String INHERITS_PRIVILEGES_KEY = INHERITS_PRIVILEGES.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PARENT_FOLDER_ID_KEY = PARENT_FOLDER_ID.key();
  // Relationships
  public static final String CHILDREN_KEY = CHILDREN.key();
  public static final String DOCUMENTS_KEY = DOCUMENTS.key();
  public static final String PARENT_KEY = PARENT.key();

  private static Logger LOG = Logger.getLogger(_SWNewsFolder.class);

  public is.us.soloweb.data.SWNewsFolder localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWNewsFolder localInstance = (is.us.soloweb.data.SWNewsFolder)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer folderID() {
    return (Integer) storedValueForKey(_SWNewsFolder.FOLDER_ID_KEY);
  }

  public void setFolderID(Integer value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating folderID from " + folderID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsFolder.FOLDER_ID_KEY);
  }

  public Integer inheritsPrivileges() {
    return (Integer) storedValueForKey(_SWNewsFolder.INHERITS_PRIVILEGES_KEY);
  }

  public void setInheritsPrivileges(Integer value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating inheritsPrivileges from " + inheritsPrivileges() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsFolder.INHERITS_PRIVILEGES_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWNewsFolder.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsFolder.NAME_KEY);
  }

  public Integer parentFolderID() {
    return (Integer) storedValueForKey(_SWNewsFolder.PARENT_FOLDER_ID_KEY);
  }

  public void setParentFolderID(Integer value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating parentFolderID from " + parentFolderID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsFolder.PARENT_FOLDER_ID_KEY);
  }

  public is.us.soloweb.data.SWNewsFolder parent() {
    return (is.us.soloweb.data.SWNewsFolder)storedValueForKey(_SWNewsFolder.PARENT_KEY);
  }
  
  public void setParent(is.us.soloweb.data.SWNewsFolder value) {
    takeStoredValueForKey(value, _SWNewsFolder.PARENT_KEY);
  }

  public void setParentRelationship(is.us.soloweb.data.SWNewsFolder value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
      _SWNewsFolder.LOG.debug("updating parent from " + parent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setParent(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWNewsFolder oldValue = parent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWNewsFolder.PARENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWNewsFolder.PARENT_KEY);
    }
  }
  
  public NSArray<is.us.soloweb.data.SWNewsFolder> children() {
    return (NSArray<is.us.soloweb.data.SWNewsFolder>)storedValueForKey(_SWNewsFolder.CHILDREN_KEY);
  }

  public NSArray<is.us.soloweb.data.SWNewsFolder> children(EOQualifier qualifier) {
    return children(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWNewsFolder> children(EOQualifier qualifier, boolean fetch) {
    return children(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWNewsFolder> children(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWNewsFolder> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWNewsFolder.PARENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWNewsFolder.fetchSWNewsFolders(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = children();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWNewsFolder>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWNewsFolder>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToChildren(is.us.soloweb.data.SWNewsFolder object) {
    includeObjectIntoPropertyWithKey(object, _SWNewsFolder.CHILDREN_KEY);
  }

  public void removeFromChildren(is.us.soloweb.data.SWNewsFolder object) {
    excludeObjectFromPropertyWithKey(object, _SWNewsFolder.CHILDREN_KEY);
  }

  public void addToChildrenRelationship(is.us.soloweb.data.SWNewsFolder object) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
      _SWNewsFolder.LOG.debug("adding " + object + " to children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChildren(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWNewsFolder.CHILDREN_KEY);
    }
  }

  public void removeFromChildrenRelationship(is.us.soloweb.data.SWNewsFolder object) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
      _SWNewsFolder.LOG.debug("removing " + object + " from children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromChildren(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWNewsFolder.CHILDREN_KEY);
    }
  }

  public is.us.soloweb.data.SWNewsFolder createChildrenRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWNewsFolder.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWNewsFolder.CHILDREN_KEY);
    return (is.us.soloweb.data.SWNewsFolder) eo;
  }

  public void deleteChildrenRelationship(is.us.soloweb.data.SWNewsFolder object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWNewsFolder.CHILDREN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllChildrenRelationships() {
    Enumeration<is.us.soloweb.data.SWNewsFolder> objects = children().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChildrenRelationship(objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.data.SWNewsItem> documents() {
    return (NSArray<is.us.soloweb.data.SWNewsItem>)storedValueForKey(_SWNewsFolder.DOCUMENTS_KEY);
  }

  public NSArray<is.us.soloweb.data.SWNewsItem> documents(EOQualifier qualifier) {
    return documents(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWNewsItem> documents(EOQualifier qualifier, boolean fetch) {
    return documents(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWNewsItem> documents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWNewsItem> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWNewsItem.FOLDER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWNewsItem.fetchSWNewsItems(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = documents();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWNewsItem>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWNewsItem>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToDocuments(is.us.soloweb.data.SWNewsItem object) {
    includeObjectIntoPropertyWithKey(object, _SWNewsFolder.DOCUMENTS_KEY);
  }

  public void removeFromDocuments(is.us.soloweb.data.SWNewsItem object) {
    excludeObjectFromPropertyWithKey(object, _SWNewsFolder.DOCUMENTS_KEY);
  }

  public void addToDocumentsRelationship(is.us.soloweb.data.SWNewsItem object) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
      _SWNewsFolder.LOG.debug("adding " + object + " to documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocuments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWNewsFolder.DOCUMENTS_KEY);
    }
  }

  public void removeFromDocumentsRelationship(is.us.soloweb.data.SWNewsItem object) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
      _SWNewsFolder.LOG.debug("removing " + object + " from documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDocuments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWNewsFolder.DOCUMENTS_KEY);
    }
  }

  public is.us.soloweb.data.SWNewsItem createDocumentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWNewsItem.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWNewsFolder.DOCUMENTS_KEY);
    return (is.us.soloweb.data.SWNewsItem) eo;
  }

  public void deleteDocumentsRelationship(is.us.soloweb.data.SWNewsItem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWNewsFolder.DOCUMENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsRelationships() {
    Enumeration<is.us.soloweb.data.SWNewsItem> objects = documents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsRelationship(objects.nextElement());
    }
  }


  public static is.us.soloweb.data.SWNewsFolder createSWNewsFolder(EOEditingContext editingContext, Integer folderID
) {
    is.us.soloweb.data.SWNewsFolder eo = (is.us.soloweb.data.SWNewsFolder) EOUtilities.createAndInsertInstance(editingContext, _SWNewsFolder.ENTITY_NAME);    
		eo.setFolderID(folderID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWNewsFolder> fetchAllSWNewsFolders(EOEditingContext editingContext) {
    return _SWNewsFolder.fetchAllSWNewsFolders(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWNewsFolder> fetchAllSWNewsFolders(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWNewsFolder.fetchSWNewsFolders(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWNewsFolder> fetchSWNewsFolders(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWNewsFolder> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWNewsFolder>(_SWNewsFolder.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWNewsFolder> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWNewsFolder fetchSWNewsFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWNewsFolder.fetchSWNewsFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWNewsFolder fetchSWNewsFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWNewsFolder> eoObjects = _SWNewsFolder.fetchSWNewsFolders(editingContext, qualifier, null);
    is.us.soloweb.data.SWNewsFolder eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWNewsFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWNewsFolder fetchRequiredSWNewsFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWNewsFolder.fetchRequiredSWNewsFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWNewsFolder fetchRequiredSWNewsFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWNewsFolder eoObject = _SWNewsFolder.fetchSWNewsFolder(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWNewsFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWNewsFolder localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWNewsFolder eo) {
    is.us.soloweb.data.SWNewsFolder localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
