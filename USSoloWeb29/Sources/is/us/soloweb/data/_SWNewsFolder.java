// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWNewsFolder.java instead.
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

  public SWNewsFolder localInstanceIn(EOEditingContext editingContext) {
    SWNewsFolder localInstance = (SWNewsFolder)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer folderID() {
    return (Integer) storedValueForKey("folderID");
  }

  public void setFolderID(Integer value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating folderID from " + folderID() + " to " + value);
    }
    takeStoredValueForKey(value, "folderID");
  }

  public Integer inheritsPrivileges() {
    return (Integer) storedValueForKey("inheritsPrivileges");
  }

  public void setInheritsPrivileges(Integer value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating inheritsPrivileges from " + inheritsPrivileges() + " to " + value);
    }
    takeStoredValueForKey(value, "inheritsPrivileges");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public Integer parentFolderID() {
    return (Integer) storedValueForKey("parentFolderID");
  }

  public void setParentFolderID(Integer value) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
    	_SWNewsFolder.LOG.debug( "updating parentFolderID from " + parentFolderID() + " to " + value);
    }
    takeStoredValueForKey(value, "parentFolderID");
  }

  public is.us.soloweb.data.SWNewsFolder parent() {
    return (is.us.soloweb.data.SWNewsFolder)storedValueForKey("parent");
  }
  
  public void setParent(is.us.soloweb.data.SWNewsFolder value) {
    takeStoredValueForKey(value, "parent");
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
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "parent");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "parent");
    }
  }
  
  public NSArray<is.us.soloweb.data.SWNewsFolder> children() {
    return (NSArray<is.us.soloweb.data.SWNewsFolder>)storedValueForKey("children");
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
        NSMutableArray qualifiers = new NSMutableArray();
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
    includeObjectIntoPropertyWithKey(object, "children");
  }

  public void removeFromChildren(is.us.soloweb.data.SWNewsFolder object) {
    excludeObjectFromPropertyWithKey(object, "children");
  }

  public void addToChildrenRelationship(is.us.soloweb.data.SWNewsFolder object) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
      _SWNewsFolder.LOG.debug("adding " + object + " to children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChildren(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "children");
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
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "children");
    }
  }

  public is.us.soloweb.data.SWNewsFolder createChildrenRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWNewsFolder");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "children");
    return (is.us.soloweb.data.SWNewsFolder) eo;
  }

  public void deleteChildrenRelationship(is.us.soloweb.data.SWNewsFolder object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "children");
    editingContext().deleteObject(object);
  }

  public void deleteAllChildrenRelationships() {
    Enumeration objects = children().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChildrenRelationship((is.us.soloweb.data.SWNewsFolder)objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.data.SWNewsItem> documents() {
    return (NSArray<is.us.soloweb.data.SWNewsItem>)storedValueForKey("documents");
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
        NSMutableArray qualifiers = new NSMutableArray();
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
    includeObjectIntoPropertyWithKey(object, "documents");
  }

  public void removeFromDocuments(is.us.soloweb.data.SWNewsItem object) {
    excludeObjectFromPropertyWithKey(object, "documents");
  }

  public void addToDocumentsRelationship(is.us.soloweb.data.SWNewsItem object) {
    if (_SWNewsFolder.LOG.isDebugEnabled()) {
      _SWNewsFolder.LOG.debug("adding " + object + " to documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocuments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "documents");
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
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "documents");
    }
  }

  public is.us.soloweb.data.SWNewsItem createDocumentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWNewsItem");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "documents");
    return (is.us.soloweb.data.SWNewsItem) eo;
  }

  public void deleteDocumentsRelationship(is.us.soloweb.data.SWNewsItem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "documents");
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsRelationships() {
    Enumeration objects = documents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsRelationship((is.us.soloweb.data.SWNewsItem)objects.nextElement());
    }
  }


  public static SWNewsFolder createSWNewsFolder(EOEditingContext editingContext, Integer folderID
) {
    SWNewsFolder eo = (SWNewsFolder) EOUtilities.createAndInsertInstance(editingContext, _SWNewsFolder.ENTITY_NAME);    
		eo.setFolderID(folderID);
    return eo;
  }

  public static NSArray<SWNewsFolder> fetchAllSWNewsFolders(EOEditingContext editingContext) {
    return _SWNewsFolder.fetchAllSWNewsFolders(editingContext, null);
  }

  public static NSArray<SWNewsFolder> fetchAllSWNewsFolders(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWNewsFolder.fetchSWNewsFolders(editingContext, null, sortOrderings);
  }

  public static NSArray<SWNewsFolder> fetchSWNewsFolders(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWNewsFolder.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWNewsFolder> eoObjects = (NSArray<SWNewsFolder>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWNewsFolder fetchSWNewsFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWNewsFolder.fetchSWNewsFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWNewsFolder fetchSWNewsFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWNewsFolder> eoObjects = _SWNewsFolder.fetchSWNewsFolders(editingContext, qualifier, null);
    SWNewsFolder eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWNewsFolder)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWNewsFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWNewsFolder fetchRequiredSWNewsFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWNewsFolder.fetchRequiredSWNewsFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWNewsFolder fetchRequiredSWNewsFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    SWNewsFolder eoObject = _SWNewsFolder.fetchSWNewsFolder(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWNewsFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWNewsFolder localInstanceIn(EOEditingContext editingContext, SWNewsFolder eo) {
    SWNewsFolder localInstance = (eo == null) ? null : (SWNewsFolder)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
