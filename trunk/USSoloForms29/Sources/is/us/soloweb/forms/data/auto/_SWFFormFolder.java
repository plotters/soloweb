// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to is.us.soloweb.forms.data.SWFFormFolder.java instead.
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
public abstract class _SWFFormFolder extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWFFormFolder";

  // Attribute Keys
  public static final ERXKey<Integer> FOLDER_ID = new ERXKey<Integer>("folderID");
  public static final ERXKey<Integer> INHERITS_PRIVILEGES = new ERXKey<Integer>("inheritsPrivileges");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> PARENT_FOLDER_ID = new ERXKey<Integer>("parentFolderID");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.forms.data.SWFFormFolder> CHILDREN = new ERXKey<is.us.soloweb.forms.data.SWFFormFolder>("children");
  public static final ERXKey<is.us.soloweb.forms.data.SWFForm> DOCUMENTS = new ERXKey<is.us.soloweb.forms.data.SWFForm>("documents");
  public static final ERXKey<is.us.soloweb.forms.data.SWFFormFolder> PARENT = new ERXKey<is.us.soloweb.forms.data.SWFFormFolder>("parent");

  // Attributes
  public static final String FOLDER_ID_KEY = FOLDER_ID.key();
  public static final String INHERITS_PRIVILEGES_KEY = INHERITS_PRIVILEGES.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PARENT_FOLDER_ID_KEY = PARENT_FOLDER_ID.key();
  // Relationships
  public static final String CHILDREN_KEY = CHILDREN.key();
  public static final String DOCUMENTS_KEY = DOCUMENTS.key();
  public static final String PARENT_KEY = PARENT.key();

  private static Logger LOG = Logger.getLogger(_SWFFormFolder.class);

  public is.us.soloweb.forms.data.SWFFormFolder localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.forms.data.SWFFormFolder localInstance = (is.us.soloweb.forms.data.SWFFormFolder)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer folderID() {
    return (Integer) storedValueForKey("folderID");
  }

  public void setFolderID(Integer value) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
    	_SWFFormFolder.LOG.debug( "updating folderID from " + folderID() + " to " + value);
    }
    takeStoredValueForKey(value, "folderID");
  }

  public Integer inheritsPrivileges() {
    return (Integer) storedValueForKey("inheritsPrivileges");
  }

  public void setInheritsPrivileges(Integer value) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
    	_SWFFormFolder.LOG.debug( "updating inheritsPrivileges from " + inheritsPrivileges() + " to " + value);
    }
    takeStoredValueForKey(value, "inheritsPrivileges");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
    	_SWFFormFolder.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public Integer parentFolderID() {
    return (Integer) storedValueForKey("parentFolderID");
  }

  public void setParentFolderID(Integer value) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
    	_SWFFormFolder.LOG.debug( "updating parentFolderID from " + parentFolderID() + " to " + value);
    }
    takeStoredValueForKey(value, "parentFolderID");
  }

  public is.us.soloweb.forms.data.SWFFormFolder parent() {
    return (is.us.soloweb.forms.data.SWFFormFolder)storedValueForKey("parent");
  }
  
  public void setParent(is.us.soloweb.forms.data.SWFFormFolder value) {
    takeStoredValueForKey(value, "parent");
  }

  public void setParentRelationship(is.us.soloweb.forms.data.SWFFormFolder value) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
      _SWFFormFolder.LOG.debug("updating parent from " + parent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setParent(value);
    }
    else if (value == null) {
    	is.us.soloweb.forms.data.SWFFormFolder oldValue = parent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "parent");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "parent");
    }
  }
  
  public NSArray<is.us.soloweb.forms.data.SWFFormFolder> children() {
    return (NSArray<is.us.soloweb.forms.data.SWFFormFolder>)storedValueForKey("children");
  }

  public NSArray<is.us.soloweb.forms.data.SWFFormFolder> children(EOQualifier qualifier) {
    return children(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.forms.data.SWFFormFolder> children(EOQualifier qualifier, boolean fetch) {
    return children(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.forms.data.SWFFormFolder> children(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.forms.data.SWFFormFolder> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFFormFolder.PARENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.forms.data.SWFFormFolder.fetchSWFFormFolders(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = children();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFFormFolder>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFFormFolder>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToChildren(is.us.soloweb.forms.data.SWFFormFolder object) {
    includeObjectIntoPropertyWithKey(object, "children");
  }

  public void removeFromChildren(is.us.soloweb.forms.data.SWFFormFolder object) {
    excludeObjectFromPropertyWithKey(object, "children");
  }

  public void addToChildrenRelationship(is.us.soloweb.forms.data.SWFFormFolder object) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
      _SWFFormFolder.LOG.debug("adding " + object + " to children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChildren(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "children");
    }
  }

  public void removeFromChildrenRelationship(is.us.soloweb.forms.data.SWFFormFolder object) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
      _SWFFormFolder.LOG.debug("removing " + object + " from children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromChildren(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "children");
    }
  }

  public is.us.soloweb.forms.data.SWFFormFolder createChildrenRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWFFormFolder");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "children");
    return (is.us.soloweb.forms.data.SWFFormFolder) eo;
  }

  public void deleteChildrenRelationship(is.us.soloweb.forms.data.SWFFormFolder object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "children");
    editingContext().deleteObject(object);
  }

  public void deleteAllChildrenRelationships() {
    Enumeration objects = children().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChildrenRelationship((is.us.soloweb.forms.data.SWFFormFolder)objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.forms.data.SWFForm> documents() {
    return (NSArray<is.us.soloweb.forms.data.SWFForm>)storedValueForKey("documents");
  }

  public NSArray<is.us.soloweb.forms.data.SWFForm> documents(EOQualifier qualifier) {
    return documents(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.forms.data.SWFForm> documents(EOQualifier qualifier, boolean fetch) {
    return documents(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.forms.data.SWFForm> documents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.forms.data.SWFForm> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.forms.data.SWFForm.FOLDER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.forms.data.SWFForm.fetchSWFForms(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = documents();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFForm>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.forms.data.SWFForm>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToDocuments(is.us.soloweb.forms.data.SWFForm object) {
    includeObjectIntoPropertyWithKey(object, "documents");
  }

  public void removeFromDocuments(is.us.soloweb.forms.data.SWFForm object) {
    excludeObjectFromPropertyWithKey(object, "documents");
  }

  public void addToDocumentsRelationship(is.us.soloweb.forms.data.SWFForm object) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
      _SWFFormFolder.LOG.debug("adding " + object + " to documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocuments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "documents");
    }
  }

  public void removeFromDocumentsRelationship(is.us.soloweb.forms.data.SWFForm object) {
    if (_SWFFormFolder.LOG.isDebugEnabled()) {
      _SWFFormFolder.LOG.debug("removing " + object + " from documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDocuments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "documents");
    }
  }

  public is.us.soloweb.forms.data.SWFForm createDocumentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWFForm");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "documents");
    return (is.us.soloweb.forms.data.SWFForm) eo;
  }

  public void deleteDocumentsRelationship(is.us.soloweb.forms.data.SWFForm object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "documents");
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsRelationships() {
    Enumeration objects = documents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsRelationship((is.us.soloweb.forms.data.SWFForm)objects.nextElement());
    }
  }


  public static is.us.soloweb.forms.data.SWFFormFolder createSWFFormFolder(EOEditingContext editingContext, Integer folderID
) {
    is.us.soloweb.forms.data.SWFFormFolder eo = (is.us.soloweb.forms.data.SWFFormFolder) EOUtilities.createAndInsertInstance(editingContext, _SWFFormFolder.ENTITY_NAME);    
		eo.setFolderID(folderID);
    return eo;
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFormFolder> fetchAllSWFFormFolders(EOEditingContext editingContext) {
    return _SWFFormFolder.fetchAllSWFFormFolders(editingContext, null);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFormFolder> fetchAllSWFFormFolders(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWFFormFolder.fetchSWFFormFolders(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.forms.data.SWFFormFolder> fetchSWFFormFolders(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWFFormFolder.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.forms.data.SWFFormFolder> eoObjects = (NSArray<is.us.soloweb.forms.data.SWFFormFolder>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static is.us.soloweb.forms.data.SWFFormFolder fetchSWFFormFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFFormFolder.fetchSWFFormFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFFormFolder fetchSWFFormFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.forms.data.SWFFormFolder> eoObjects = _SWFFormFolder.fetchSWFFormFolders(editingContext, qualifier, null);
    is.us.soloweb.forms.data.SWFFormFolder eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (is.us.soloweb.forms.data.SWFFormFolder)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWFFormFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFFormFolder fetchRequiredSWFFormFolder(EOEditingContext editingContext, String keyName, Object value) {
    return _SWFFormFolder.fetchRequiredSWFFormFolder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.forms.data.SWFFormFolder fetchRequiredSWFFormFolder(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.forms.data.SWFFormFolder eoObject = _SWFFormFolder.fetchSWFFormFolder(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWFFormFolder that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.forms.data.SWFFormFolder localInstanceIn(EOEditingContext editingContext, is.us.soloweb.forms.data.SWFFormFolder eo) {
    is.us.soloweb.forms.data.SWFFormFolder localInstance = (eo == null) ? null : (is.us.soloweb.forms.data.SWFFormFolder)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
