// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWComponent.java instead.
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
public abstract class _SWComponent extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWComponent";

  // Attribute Keys
  public static final ERXKey<Integer> COMPONENT_ID = new ERXKey<Integer>("componentID");
  public static final ERXKey<String> CUSTOM_INFO_STRING = new ERXKey<String>("customInfoString");
  public static final ERXKey<Integer> DOCUMENT_ID = new ERXKey<Integer>("documentID");
  public static final ERXKey<Integer> ENCODE_BREAKS = new ERXKey<Integer>("encodeBreaks");
  public static final ERXKey<Integer> PAGE_ID = new ERXKey<Integer>("pageID");
  public static final ERXKey<Integer> PICTURE_ID = new ERXKey<Integer>("pictureID");
  public static final ERXKey<Integer> PUBLISHED = new ERXKey<Integer>("published");
  public static final ERXKey<Integer> SORT_NUMBER = new ERXKey<Integer>("sortNumber");
  public static final ERXKey<String> TEMPLATE_NAME = new ERXKey<String>("templateName");
  public static final ERXKey<String> TEXT_ONE = new ERXKey<String>("textOne");
  public static final ERXKey<String> TEXT_TWO = new ERXKey<String>("textTwo");
  public static final ERXKey<NSTimestamp> TIME_IN = new ERXKey<NSTimestamp>("timeIn");
  public static final ERXKey<NSTimestamp> TIME_OUT = new ERXKey<NSTimestamp>("timeOut");
  public static final ERXKey<Integer> WIKI_MARKUP = new ERXKey<Integer>("wikiMarkup");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWDocument> DOCUMENT = new ERXKey<is.us.soloweb.data.SWDocument>("document");
  public static final ERXKey<is.us.soloweb.data.SWPage> PAGE = new ERXKey<is.us.soloweb.data.SWPage>("page");

  // Attributes
  public static final String COMPONENT_ID_KEY = COMPONENT_ID.key();
  public static final String CUSTOM_INFO_STRING_KEY = CUSTOM_INFO_STRING.key();
  public static final String DOCUMENT_ID_KEY = DOCUMENT_ID.key();
  public static final String ENCODE_BREAKS_KEY = ENCODE_BREAKS.key();
  public static final String PAGE_ID_KEY = PAGE_ID.key();
  public static final String PICTURE_ID_KEY = PICTURE_ID.key();
  public static final String PUBLISHED_KEY = PUBLISHED.key();
  public static final String SORT_NUMBER_KEY = SORT_NUMBER.key();
  public static final String TEMPLATE_NAME_KEY = TEMPLATE_NAME.key();
  public static final String TEXT_ONE_KEY = TEXT_ONE.key();
  public static final String TEXT_TWO_KEY = TEXT_TWO.key();
  public static final String TIME_IN_KEY = TIME_IN.key();
  public static final String TIME_OUT_KEY = TIME_OUT.key();
  public static final String WIKI_MARKUP_KEY = WIKI_MARKUP.key();
  // Relationships
  public static final String DOCUMENT_KEY = DOCUMENT.key();
  public static final String PAGE_KEY = PAGE.key();

  private static Logger LOG = Logger.getLogger(_SWComponent.class);

  public is.us.soloweb.data.SWComponent localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWComponent localInstance = (is.us.soloweb.data.SWComponent)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer componentID() {
    return (Integer) storedValueForKey(_SWComponent.COMPONENT_ID_KEY);
  }

  public void setComponentID(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating componentID from " + componentID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.COMPONENT_ID_KEY);
  }

  public String customInfoString() {
    return (String) storedValueForKey(_SWComponent.CUSTOM_INFO_STRING_KEY);
  }

  public void setCustomInfoString(String value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating customInfoString from " + customInfoString() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.CUSTOM_INFO_STRING_KEY);
  }

  public Integer documentID() {
    return (Integer) storedValueForKey(_SWComponent.DOCUMENT_ID_KEY);
  }

  public void setDocumentID(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating documentID from " + documentID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.DOCUMENT_ID_KEY);
  }

  public Integer encodeBreaks() {
    return (Integer) storedValueForKey(_SWComponent.ENCODE_BREAKS_KEY);
  }

  public void setEncodeBreaks(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating encodeBreaks from " + encodeBreaks() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.ENCODE_BREAKS_KEY);
  }

  public Integer pageID() {
    return (Integer) storedValueForKey(_SWComponent.PAGE_ID_KEY);
  }

  public void setPageID(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating pageID from " + pageID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.PAGE_ID_KEY);
  }

  public Integer pictureID() {
    return (Integer) storedValueForKey(_SWComponent.PICTURE_ID_KEY);
  }

  public void setPictureID(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating pictureID from " + pictureID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.PICTURE_ID_KEY);
  }

  public Integer published() {
    return (Integer) storedValueForKey(_SWComponent.PUBLISHED_KEY);
  }

  public void setPublished(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating published from " + published() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.PUBLISHED_KEY);
  }

  public Integer sortNumber() {
    return (Integer) storedValueForKey(_SWComponent.SORT_NUMBER_KEY);
  }

  public void setSortNumber(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating sortNumber from " + sortNumber() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.SORT_NUMBER_KEY);
  }

  public String templateName() {
    return (String) storedValueForKey(_SWComponent.TEMPLATE_NAME_KEY);
  }

  public void setTemplateName(String value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating templateName from " + templateName() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.TEMPLATE_NAME_KEY);
  }

  public String textOne() {
    return (String) storedValueForKey(_SWComponent.TEXT_ONE_KEY);
  }

  public void setTextOne(String value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating textOne from " + textOne() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.TEXT_ONE_KEY);
  }

  public String textTwo() {
    return (String) storedValueForKey(_SWComponent.TEXT_TWO_KEY);
  }

  public void setTextTwo(String value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating textTwo from " + textTwo() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.TEXT_TWO_KEY);
  }

  public NSTimestamp timeIn() {
    return (NSTimestamp) storedValueForKey(_SWComponent.TIME_IN_KEY);
  }

  public void setTimeIn(NSTimestamp value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating timeIn from " + timeIn() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.TIME_IN_KEY);
  }

  public NSTimestamp timeOut() {
    return (NSTimestamp) storedValueForKey(_SWComponent.TIME_OUT_KEY);
  }

  public void setTimeOut(NSTimestamp value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating timeOut from " + timeOut() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.TIME_OUT_KEY);
  }

  public Integer wikiMarkup() {
    return (Integer) storedValueForKey(_SWComponent.WIKI_MARKUP_KEY);
  }

  public void setWikiMarkup(Integer value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
    	_SWComponent.LOG.debug( "updating wikiMarkup from " + wikiMarkup() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComponent.WIKI_MARKUP_KEY);
  }

  public is.us.soloweb.data.SWDocument document() {
    return (is.us.soloweb.data.SWDocument)storedValueForKey(_SWComponent.DOCUMENT_KEY);
  }
  
  public void setDocument(is.us.soloweb.data.SWDocument value) {
    takeStoredValueForKey(value, _SWComponent.DOCUMENT_KEY);
  }

  public void setDocumentRelationship(is.us.soloweb.data.SWDocument value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
      _SWComponent.LOG.debug("updating document from " + document() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocument(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocument oldValue = document();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWComponent.DOCUMENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWComponent.DOCUMENT_KEY);
    }
  }
  
  public is.us.soloweb.data.SWPage page() {
    return (is.us.soloweb.data.SWPage)storedValueForKey(_SWComponent.PAGE_KEY);
  }
  
  public void setPage(is.us.soloweb.data.SWPage value) {
    takeStoredValueForKey(value, _SWComponent.PAGE_KEY);
  }

  public void setPageRelationship(is.us.soloweb.data.SWPage value) {
    if (_SWComponent.LOG.isDebugEnabled()) {
      _SWComponent.LOG.debug("updating page from " + page() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setPage(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWPage oldValue = page();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWComponent.PAGE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWComponent.PAGE_KEY);
    }
  }
  

  public static is.us.soloweb.data.SWComponent createSWComponent(EOEditingContext editingContext, Integer componentID
) {
    is.us.soloweb.data.SWComponent eo = (is.us.soloweb.data.SWComponent) EOUtilities.createAndInsertInstance(editingContext, _SWComponent.ENTITY_NAME);    
		eo.setComponentID(componentID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWComponent> fetchAllSWComponents(EOEditingContext editingContext) {
    return _SWComponent.fetchAllSWComponents(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWComponent> fetchAllSWComponents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWComponent.fetchSWComponents(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWComponent> fetchSWComponents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWComponent> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWComponent>(_SWComponent.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWComponent> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWComponent fetchSWComponent(EOEditingContext editingContext, String keyName, Object value) {
    return _SWComponent.fetchSWComponent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWComponent fetchSWComponent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWComponent> eoObjects = _SWComponent.fetchSWComponents(editingContext, qualifier, null);
    is.us.soloweb.data.SWComponent eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWComponent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWComponent fetchRequiredSWComponent(EOEditingContext editingContext, String keyName, Object value) {
    return _SWComponent.fetchRequiredSWComponent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWComponent fetchRequiredSWComponent(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWComponent eoObject = _SWComponent.fetchSWComponent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWComponent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWComponent localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWComponent eo) {
    is.us.soloweb.data.SWComponent localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
