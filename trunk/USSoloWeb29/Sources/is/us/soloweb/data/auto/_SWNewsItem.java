// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWNewsItem.java instead.
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
public abstract class _SWNewsItem extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWNewsItem";

  // Attribute Keys
  public static final ERXKey<Integer> CREATED_BY_ID = new ERXKey<Integer>("createdByID");
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<NSTimestamp> DATE = new ERXKey<NSTimestamp>("date");
  public static final ERXKey<Integer> DOCUMENT_ID = new ERXKey<Integer>("documentID");
  public static final ERXKey<Integer> ENCODE_BREAKS = new ERXKey<Integer>("encodeBreaks");
  public static final ERXKey<String> EXCERPT = new ERXKey<String>("excerpt");
  public static final ERXKey<Integer> FOLDER_ID = new ERXKey<Integer>("folderID");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  public static final ERXKey<Integer> MODIFIED_BY_ID = new ERXKey<Integer>("modifiedByID");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> NEWS_ITEM_ID = new ERXKey<Integer>("newsItemID");
  public static final ERXKey<Integer> PICTURE_ID = new ERXKey<Integer>("pictureID");
  public static final ERXKey<Integer> PUBLISHED = new ERXKey<Integer>("published");
  public static final ERXKey<String> SUBHEADING = new ERXKey<String>("subheading");
  public static final ERXKey<String> TEXT = new ERXKey<String>("text");
  public static final ERXKey<NSTimestamp> TIME_IN = new ERXKey<NSTimestamp>("timeIn");
  public static final ERXKey<NSTimestamp> TIME_OUT = new ERXKey<NSTimestamp>("timeOut");
  public static final ERXKey<Integer> WIKI_MARKUP = new ERXKey<Integer>("wikiMarkup");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWComment> COMMENTS = new ERXKey<is.us.soloweb.data.SWComment>("comments");
  public static final ERXKey<is.us.soloweb.data.SWUser> CREATED_BY = new ERXKey<is.us.soloweb.data.SWUser>("createdBy");
  public static final ERXKey<is.us.soloweb.data.SWDocument> DOCUMENT = new ERXKey<is.us.soloweb.data.SWDocument>("document");
  public static final ERXKey<is.us.soloweb.data.SWNewsFolder> FOLDER = new ERXKey<is.us.soloweb.data.SWNewsFolder>("folder");
  public static final ERXKey<is.us.soloweb.data.SWUser> MODIFIED_BY = new ERXKey<is.us.soloweb.data.SWUser>("modifiedBy");

  // Attributes
  public static final String CREATED_BY_ID_KEY = CREATED_BY_ID.key();
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String DATE_KEY = DATE.key();
  public static final String DOCUMENT_ID_KEY = DOCUMENT_ID.key();
  public static final String ENCODE_BREAKS_KEY = ENCODE_BREAKS.key();
  public static final String EXCERPT_KEY = EXCERPT.key();
  public static final String FOLDER_ID_KEY = FOLDER_ID.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  public static final String MODIFIED_BY_ID_KEY = MODIFIED_BY_ID.key();
  public static final String NAME_KEY = NAME.key();
  public static final String NEWS_ITEM_ID_KEY = NEWS_ITEM_ID.key();
  public static final String PICTURE_ID_KEY = PICTURE_ID.key();
  public static final String PUBLISHED_KEY = PUBLISHED.key();
  public static final String SUBHEADING_KEY = SUBHEADING.key();
  public static final String TEXT_KEY = TEXT.key();
  public static final String TIME_IN_KEY = TIME_IN.key();
  public static final String TIME_OUT_KEY = TIME_OUT.key();
  public static final String WIKI_MARKUP_KEY = WIKI_MARKUP.key();
  // Relationships
  public static final String COMMENTS_KEY = COMMENTS.key();
  public static final String CREATED_BY_KEY = CREATED_BY.key();
  public static final String DOCUMENT_KEY = DOCUMENT.key();
  public static final String FOLDER_KEY = FOLDER.key();
  public static final String MODIFIED_BY_KEY = MODIFIED_BY.key();

  private static Logger LOG = Logger.getLogger(_SWNewsItem.class);

  public is.us.soloweb.data.SWNewsItem localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWNewsItem localInstance = (is.us.soloweb.data.SWNewsItem)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer createdByID() {
    return (Integer) storedValueForKey(_SWNewsItem.CREATED_BY_ID_KEY);
  }

  public void setCreatedByID(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating createdByID from " + createdByID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.CREATED_BY_ID_KEY);
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_SWNewsItem.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.CREATION_DATE_KEY);
  }

  public NSTimestamp date() {
    return (NSTimestamp) storedValueForKey(_SWNewsItem.DATE_KEY);
  }

  public void setDate(NSTimestamp value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating date from " + date() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.DATE_KEY);
  }

  public Integer documentID() {
    return (Integer) storedValueForKey(_SWNewsItem.DOCUMENT_ID_KEY);
  }

  public void setDocumentID(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating documentID from " + documentID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.DOCUMENT_ID_KEY);
  }

  public Integer encodeBreaks() {
    return (Integer) storedValueForKey(_SWNewsItem.ENCODE_BREAKS_KEY);
  }

  public void setEncodeBreaks(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating encodeBreaks from " + encodeBreaks() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.ENCODE_BREAKS_KEY);
  }

  public String excerpt() {
    return (String) storedValueForKey(_SWNewsItem.EXCERPT_KEY);
  }

  public void setExcerpt(String value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating excerpt from " + excerpt() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.EXCERPT_KEY);
  }

  public Integer folderID() {
    return (Integer) storedValueForKey(_SWNewsItem.FOLDER_ID_KEY);
  }

  public void setFolderID(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating folderID from " + folderID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.FOLDER_ID_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_SWNewsItem.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.MODIFICATION_DATE_KEY);
  }

  public Integer modifiedByID() {
    return (Integer) storedValueForKey(_SWNewsItem.MODIFIED_BY_ID_KEY);
  }

  public void setModifiedByID(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating modifiedByID from " + modifiedByID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.MODIFIED_BY_ID_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWNewsItem.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.NAME_KEY);
  }

  public Integer newsItemID() {
    return (Integer) storedValueForKey(_SWNewsItem.NEWS_ITEM_ID_KEY);
  }

  public void setNewsItemID(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating newsItemID from " + newsItemID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.NEWS_ITEM_ID_KEY);
  }

  public Integer pictureID() {
    return (Integer) storedValueForKey(_SWNewsItem.PICTURE_ID_KEY);
  }

  public void setPictureID(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating pictureID from " + pictureID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.PICTURE_ID_KEY);
  }

  public Integer published() {
    return (Integer) storedValueForKey(_SWNewsItem.PUBLISHED_KEY);
  }

  public void setPublished(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating published from " + published() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.PUBLISHED_KEY);
  }

  public String subheading() {
    return (String) storedValueForKey(_SWNewsItem.SUBHEADING_KEY);
  }

  public void setSubheading(String value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating subheading from " + subheading() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.SUBHEADING_KEY);
  }

  public String text() {
    return (String) storedValueForKey(_SWNewsItem.TEXT_KEY);
  }

  public void setText(String value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating text from " + text() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.TEXT_KEY);
  }

  public NSTimestamp timeIn() {
    return (NSTimestamp) storedValueForKey(_SWNewsItem.TIME_IN_KEY);
  }

  public void setTimeIn(NSTimestamp value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating timeIn from " + timeIn() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.TIME_IN_KEY);
  }

  public NSTimestamp timeOut() {
    return (NSTimestamp) storedValueForKey(_SWNewsItem.TIME_OUT_KEY);
  }

  public void setTimeOut(NSTimestamp value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating timeOut from " + timeOut() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.TIME_OUT_KEY);
  }

  public Integer wikiMarkup() {
    return (Integer) storedValueForKey(_SWNewsItem.WIKI_MARKUP_KEY);
  }

  public void setWikiMarkup(Integer value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
    	_SWNewsItem.LOG.debug( "updating wikiMarkup from " + wikiMarkup() + " to " + value);
    }
    takeStoredValueForKey(value, _SWNewsItem.WIKI_MARKUP_KEY);
  }

  public is.us.soloweb.data.SWUser createdBy() {
    return (is.us.soloweb.data.SWUser)storedValueForKey(_SWNewsItem.CREATED_BY_KEY);
  }
  
  public void setCreatedBy(is.us.soloweb.data.SWUser value) {
    takeStoredValueForKey(value, _SWNewsItem.CREATED_BY_KEY);
  }

  public void setCreatedByRelationship(is.us.soloweb.data.SWUser value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
      _SWNewsItem.LOG.debug("updating createdBy from " + createdBy() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setCreatedBy(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWUser oldValue = createdBy();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWNewsItem.CREATED_BY_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWNewsItem.CREATED_BY_KEY);
    }
  }
  
  public is.us.soloweb.data.SWDocument document() {
    return (is.us.soloweb.data.SWDocument)storedValueForKey(_SWNewsItem.DOCUMENT_KEY);
  }
  
  public void setDocument(is.us.soloweb.data.SWDocument value) {
    takeStoredValueForKey(value, _SWNewsItem.DOCUMENT_KEY);
  }

  public void setDocumentRelationship(is.us.soloweb.data.SWDocument value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
      _SWNewsItem.LOG.debug("updating document from " + document() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocument(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocument oldValue = document();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWNewsItem.DOCUMENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWNewsItem.DOCUMENT_KEY);
    }
  }
  
  public is.us.soloweb.data.SWNewsFolder folder() {
    return (is.us.soloweb.data.SWNewsFolder)storedValueForKey(_SWNewsItem.FOLDER_KEY);
  }
  
  public void setFolder(is.us.soloweb.data.SWNewsFolder value) {
    takeStoredValueForKey(value, _SWNewsItem.FOLDER_KEY);
  }

  public void setFolderRelationship(is.us.soloweb.data.SWNewsFolder value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
      _SWNewsItem.LOG.debug("updating folder from " + folder() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setFolder(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWNewsFolder oldValue = folder();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWNewsItem.FOLDER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWNewsItem.FOLDER_KEY);
    }
  }
  
  public is.us.soloweb.data.SWUser modifiedBy() {
    return (is.us.soloweb.data.SWUser)storedValueForKey(_SWNewsItem.MODIFIED_BY_KEY);
  }
  
  public void setModifiedBy(is.us.soloweb.data.SWUser value) {
    takeStoredValueForKey(value, _SWNewsItem.MODIFIED_BY_KEY);
  }

  public void setModifiedByRelationship(is.us.soloweb.data.SWUser value) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
      _SWNewsItem.LOG.debug("updating modifiedBy from " + modifiedBy() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setModifiedBy(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWUser oldValue = modifiedBy();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWNewsItem.MODIFIED_BY_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWNewsItem.MODIFIED_BY_KEY);
    }
  }
  
  public NSArray<is.us.soloweb.data.SWComment> comments() {
    return (NSArray<is.us.soloweb.data.SWComment>)storedValueForKey(_SWNewsItem.COMMENTS_KEY);
  }

  public NSArray<is.us.soloweb.data.SWComment> comments(EOQualifier qualifier) {
    return comments(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWComment> comments(EOQualifier qualifier, boolean fetch) {
    return comments(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWComment> comments(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWComment> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWComment.NEWSITEM_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWComment.fetchSWComments(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = comments();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWComment>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWComment>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToComments(is.us.soloweb.data.SWComment object) {
    includeObjectIntoPropertyWithKey(object, _SWNewsItem.COMMENTS_KEY);
  }

  public void removeFromComments(is.us.soloweb.data.SWComment object) {
    excludeObjectFromPropertyWithKey(object, _SWNewsItem.COMMENTS_KEY);
  }

  public void addToCommentsRelationship(is.us.soloweb.data.SWComment object) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
      _SWNewsItem.LOG.debug("adding " + object + " to comments relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToComments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _SWNewsItem.COMMENTS_KEY);
    }
  }

  public void removeFromCommentsRelationship(is.us.soloweb.data.SWComment object) {
    if (_SWNewsItem.LOG.isDebugEnabled()) {
      _SWNewsItem.LOG.debug("removing " + object + " from comments relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromComments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _SWNewsItem.COMMENTS_KEY);
    }
  }

  public is.us.soloweb.data.SWComment createCommentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( is.us.soloweb.data.SWComment.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _SWNewsItem.COMMENTS_KEY);
    return (is.us.soloweb.data.SWComment) eo;
  }

  public void deleteCommentsRelationship(is.us.soloweb.data.SWComment object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _SWNewsItem.COMMENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllCommentsRelationships() {
    Enumeration<is.us.soloweb.data.SWComment> objects = comments().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCommentsRelationship(objects.nextElement());
    }
  }


  public static is.us.soloweb.data.SWNewsItem createSWNewsItem(EOEditingContext editingContext, Integer newsItemID
) {
    is.us.soloweb.data.SWNewsItem eo = (is.us.soloweb.data.SWNewsItem) EOUtilities.createAndInsertInstance(editingContext, _SWNewsItem.ENTITY_NAME);    
		eo.setNewsItemID(newsItemID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWNewsItem> fetchAllSWNewsItems(EOEditingContext editingContext) {
    return _SWNewsItem.fetchAllSWNewsItems(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWNewsItem> fetchAllSWNewsItems(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWNewsItem.fetchSWNewsItems(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWNewsItem> fetchSWNewsItems(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWNewsItem> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWNewsItem>(_SWNewsItem.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWNewsItem> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWNewsItem fetchSWNewsItem(EOEditingContext editingContext, String keyName, Object value) {
    return _SWNewsItem.fetchSWNewsItem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWNewsItem fetchSWNewsItem(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWNewsItem> eoObjects = _SWNewsItem.fetchSWNewsItems(editingContext, qualifier, null);
    is.us.soloweb.data.SWNewsItem eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWNewsItem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWNewsItem fetchRequiredSWNewsItem(EOEditingContext editingContext, String keyName, Object value) {
    return _SWNewsItem.fetchRequiredSWNewsItem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWNewsItem fetchRequiredSWNewsItem(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWNewsItem eoObject = _SWNewsItem.fetchSWNewsItem(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWNewsItem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWNewsItem localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWNewsItem eo) {
    is.us.soloweb.data.SWNewsItem localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
