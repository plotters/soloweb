// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWPage.java instead.
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
public abstract class _SWPage extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWPage";

  // Attribute Keys
  public static final ERXKey<Integer> ACCESSIBLE = new ERXKey<Integer>("accessible");
  public static final ERXKey<String> CUSTOM_INFO_STRING = new ERXKey<String>("customInfoString");
  public static final ERXKey<Integer> DOCUMENT_ONE_ID = new ERXKey<Integer>("documentOneID");
  public static final ERXKey<Integer> DOCUMENT_TWO_ID = new ERXKey<Integer>("documentTwoID");
  public static final ERXKey<String> EXTERNAL_URL = new ERXKey<String>("externalURL");
  public static final ERXKey<Integer> INHERITS_PRIVILEGES = new ERXKey<Integer>("inheritsPrivileges");
  public static final ERXKey<String> KEYWORDS = new ERXKey<String>("keywords");
  public static final ERXKey<String> LANGUAGE = new ERXKey<String>("language");
  public static final ERXKey<String> LOOK = new ERXKey<String>("look");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> NAME_PREFIX = new ERXKey<String>("namePrefix");
  public static final ERXKey<Integer> PAGE_ID = new ERXKey<Integer>("pageID");
  public static final ERXKey<Integer> PARENT_PAGE_ID = new ERXKey<Integer>("parentPageID");
  public static final ERXKey<String> PASSWORD = new ERXKey<String>("password");
  public static final ERXKey<Integer> PICTURE_ONE_ID = new ERXKey<Integer>("pictureOneID");
  public static final ERXKey<Integer> PICTURE_TWO_ID = new ERXKey<Integer>("pictureTwoID");
  public static final ERXKey<Integer> PUBLISHED = new ERXKey<Integer>("published");
  public static final ERXKey<Integer> SORT_NUMBER = new ERXKey<Integer>("sortNumber");
  public static final ERXKey<String> SYMBOL = new ERXKey<String>("symbol");
  public static final ERXKey<String> TEXT = new ERXKey<String>("text");
  public static final ERXKey<NSTimestamp> TIME_IN = new ERXKey<NSTimestamp>("timeIn");
  public static final ERXKey<NSTimestamp> TIME_OUT = new ERXKey<NSTimestamp>("timeOut");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWComponent> COMPONENTS = new ERXKey<is.us.soloweb.data.SWComponent>("components");
  public static final ERXKey<is.us.soloweb.data.SWDocument> DOCUMENT_ONE = new ERXKey<is.us.soloweb.data.SWDocument>("documentOne");
  public static final ERXKey<is.us.soloweb.data.SWDocument> DOCUMENT_TWO = new ERXKey<is.us.soloweb.data.SWDocument>("documentTwo");
  public static final ERXKey<is.us.soloweb.data.SWPage> PARENT_PAGE = new ERXKey<is.us.soloweb.data.SWPage>("parentPage");
  public static final ERXKey<is.us.soloweb.data.SWSite> SITE = new ERXKey<is.us.soloweb.data.SWSite>("site");
  public static final ERXKey<is.us.soloweb.data.SWPage> SUB_PAGES = new ERXKey<is.us.soloweb.data.SWPage>("subPages");

  // Attributes
  public static final String ACCESSIBLE_KEY = ACCESSIBLE.key();
  public static final String CUSTOM_INFO_STRING_KEY = CUSTOM_INFO_STRING.key();
  public static final String DOCUMENT_ONE_ID_KEY = DOCUMENT_ONE_ID.key();
  public static final String DOCUMENT_TWO_ID_KEY = DOCUMENT_TWO_ID.key();
  public static final String EXTERNAL_URL_KEY = EXTERNAL_URL.key();
  public static final String INHERITS_PRIVILEGES_KEY = INHERITS_PRIVILEGES.key();
  public static final String KEYWORDS_KEY = KEYWORDS.key();
  public static final String LANGUAGE_KEY = LANGUAGE.key();
  public static final String LOOK_KEY = LOOK.key();
  public static final String NAME_KEY = NAME.key();
  public static final String NAME_PREFIX_KEY = NAME_PREFIX.key();
  public static final String PAGE_ID_KEY = PAGE_ID.key();
  public static final String PARENT_PAGE_ID_KEY = PARENT_PAGE_ID.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  public static final String PICTURE_ONE_ID_KEY = PICTURE_ONE_ID.key();
  public static final String PICTURE_TWO_ID_KEY = PICTURE_TWO_ID.key();
  public static final String PUBLISHED_KEY = PUBLISHED.key();
  public static final String SORT_NUMBER_KEY = SORT_NUMBER.key();
  public static final String SYMBOL_KEY = SYMBOL.key();
  public static final String TEXT_KEY = TEXT.key();
  public static final String TIME_IN_KEY = TIME_IN.key();
  public static final String TIME_OUT_KEY = TIME_OUT.key();
  // Relationships
  public static final String COMPONENTS_KEY = COMPONENTS.key();
  public static final String DOCUMENT_ONE_KEY = DOCUMENT_ONE.key();
  public static final String DOCUMENT_TWO_KEY = DOCUMENT_TWO.key();
  public static final String PARENT_PAGE_KEY = PARENT_PAGE.key();
  public static final String SITE_KEY = SITE.key();
  public static final String SUB_PAGES_KEY = SUB_PAGES.key();

  private static Logger LOG = Logger.getLogger(_SWPage.class);

  public SWPage localInstanceIn(EOEditingContext editingContext) {
    SWPage localInstance = (SWPage)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer accessible() {
    return (Integer) storedValueForKey("accessible");
  }

  public void setAccessible(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating accessible from " + accessible() + " to " + value);
    }
    takeStoredValueForKey(value, "accessible");
  }

  public String customInfoString() {
    return (String) storedValueForKey("customInfoString");
  }

  public void setCustomInfoString(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating customInfoString from " + customInfoString() + " to " + value);
    }
    takeStoredValueForKey(value, "customInfoString");
  }

  public Integer documentOneID() {
    return (Integer) storedValueForKey("documentOneID");
  }

  public void setDocumentOneID(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating documentOneID from " + documentOneID() + " to " + value);
    }
    takeStoredValueForKey(value, "documentOneID");
  }

  public Integer documentTwoID() {
    return (Integer) storedValueForKey("documentTwoID");
  }

  public void setDocumentTwoID(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating documentTwoID from " + documentTwoID() + " to " + value);
    }
    takeStoredValueForKey(value, "documentTwoID");
  }

  public String externalURL() {
    return (String) storedValueForKey("externalURL");
  }

  public void setExternalURL(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating externalURL from " + externalURL() + " to " + value);
    }
    takeStoredValueForKey(value, "externalURL");
  }

  public Integer inheritsPrivileges() {
    return (Integer) storedValueForKey("inheritsPrivileges");
  }

  public void setInheritsPrivileges(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating inheritsPrivileges from " + inheritsPrivileges() + " to " + value);
    }
    takeStoredValueForKey(value, "inheritsPrivileges");
  }

  public String keywords() {
    return (String) storedValueForKey("keywords");
  }

  public void setKeywords(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating keywords from " + keywords() + " to " + value);
    }
    takeStoredValueForKey(value, "keywords");
  }

  public String language() {
    return (String) storedValueForKey("language");
  }

  public void setLanguage(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating language from " + language() + " to " + value);
    }
    takeStoredValueForKey(value, "language");
  }

  public String look() {
    return (String) storedValueForKey("look");
  }

  public void setLook(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating look from " + look() + " to " + value);
    }
    takeStoredValueForKey(value, "look");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public String namePrefix() {
    return (String) storedValueForKey("namePrefix");
  }

  public void setNamePrefix(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating namePrefix from " + namePrefix() + " to " + value);
    }
    takeStoredValueForKey(value, "namePrefix");
  }

  public Integer pageID() {
    return (Integer) storedValueForKey("pageID");
  }

  public void setPageID(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating pageID from " + pageID() + " to " + value);
    }
    takeStoredValueForKey(value, "pageID");
  }

  public Integer parentPageID() {
    return (Integer) storedValueForKey("parentPageID");
  }

  public void setParentPageID(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating parentPageID from " + parentPageID() + " to " + value);
    }
    takeStoredValueForKey(value, "parentPageID");
  }

  public String password() {
    return (String) storedValueForKey("password");
  }

  public void setPassword(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating password from " + password() + " to " + value);
    }
    takeStoredValueForKey(value, "password");
  }

  public Integer pictureOneID() {
    return (Integer) storedValueForKey("pictureOneID");
  }

  public void setPictureOneID(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating pictureOneID from " + pictureOneID() + " to " + value);
    }
    takeStoredValueForKey(value, "pictureOneID");
  }

  public Integer pictureTwoID() {
    return (Integer) storedValueForKey("pictureTwoID");
  }

  public void setPictureTwoID(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating pictureTwoID from " + pictureTwoID() + " to " + value);
    }
    takeStoredValueForKey(value, "pictureTwoID");
  }

  public Integer published() {
    return (Integer) storedValueForKey("published");
  }

  public void setPublished(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating published from " + published() + " to " + value);
    }
    takeStoredValueForKey(value, "published");
  }

  public Integer sortNumber() {
    return (Integer) storedValueForKey("sortNumber");
  }

  public void setSortNumber(Integer value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating sortNumber from " + sortNumber() + " to " + value);
    }
    takeStoredValueForKey(value, "sortNumber");
  }

  public String symbol() {
    return (String) storedValueForKey("symbol");
  }

  public void setSymbol(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating symbol from " + symbol() + " to " + value);
    }
    takeStoredValueForKey(value, "symbol");
  }

  public String text() {
    return (String) storedValueForKey("text");
  }

  public void setText(String value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating text from " + text() + " to " + value);
    }
    takeStoredValueForKey(value, "text");
  }

  public NSTimestamp timeIn() {
    return (NSTimestamp) storedValueForKey("timeIn");
  }

  public void setTimeIn(NSTimestamp value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating timeIn from " + timeIn() + " to " + value);
    }
    takeStoredValueForKey(value, "timeIn");
  }

  public NSTimestamp timeOut() {
    return (NSTimestamp) storedValueForKey("timeOut");
  }

  public void setTimeOut(NSTimestamp value) {
    if (_SWPage.LOG.isDebugEnabled()) {
    	_SWPage.LOG.debug( "updating timeOut from " + timeOut() + " to " + value);
    }
    takeStoredValueForKey(value, "timeOut");
  }

  public is.us.soloweb.data.SWDocument documentOne() {
    return (is.us.soloweb.data.SWDocument)storedValueForKey("documentOne");
  }
  
  public void setDocumentOne(is.us.soloweb.data.SWDocument value) {
    takeStoredValueForKey(value, "documentOne");
  }

  public void setDocumentOneRelationship(is.us.soloweb.data.SWDocument value) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("updating documentOne from " + documentOne() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocumentOne(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocument oldValue = documentOne();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "documentOne");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "documentOne");
    }
  }
  
  public is.us.soloweb.data.SWDocument documentTwo() {
    return (is.us.soloweb.data.SWDocument)storedValueForKey("documentTwo");
  }
  
  public void setDocumentTwo(is.us.soloweb.data.SWDocument value) {
    takeStoredValueForKey(value, "documentTwo");
  }

  public void setDocumentTwoRelationship(is.us.soloweb.data.SWDocument value) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("updating documentTwo from " + documentTwo() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocumentTwo(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWDocument oldValue = documentTwo();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "documentTwo");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "documentTwo");
    }
  }
  
  public is.us.soloweb.data.SWPage parentPage() {
    return (is.us.soloweb.data.SWPage)storedValueForKey("parentPage");
  }
  
  public void setParentPage(is.us.soloweb.data.SWPage value) {
    takeStoredValueForKey(value, "parentPage");
  }

  public void setParentPageRelationship(is.us.soloweb.data.SWPage value) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("updating parentPage from " + parentPage() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setParentPage(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWPage oldValue = parentPage();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "parentPage");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "parentPage");
    }
  }
  
  public NSArray<is.us.soloweb.data.SWComponent> components() {
    return (NSArray<is.us.soloweb.data.SWComponent>)storedValueForKey("components");
  }

  public NSArray<is.us.soloweb.data.SWComponent> components(EOQualifier qualifier) {
    return components(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWComponent> components(EOQualifier qualifier, boolean fetch) {
    return components(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWComponent> components(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWComponent> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWComponent.PAGE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWComponent.fetchSWComponents(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = components();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWComponent>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWComponent>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToComponents(is.us.soloweb.data.SWComponent object) {
    includeObjectIntoPropertyWithKey(object, "components");
  }

  public void removeFromComponents(is.us.soloweb.data.SWComponent object) {
    excludeObjectFromPropertyWithKey(object, "components");
  }

  public void addToComponentsRelationship(is.us.soloweb.data.SWComponent object) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("adding " + object + " to components relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToComponents(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "components");
    }
  }

  public void removeFromComponentsRelationship(is.us.soloweb.data.SWComponent object) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("removing " + object + " from components relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromComponents(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "components");
    }
  }

  public is.us.soloweb.data.SWComponent createComponentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWComponent");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "components");
    return (is.us.soloweb.data.SWComponent) eo;
  }

  public void deleteComponentsRelationship(is.us.soloweb.data.SWComponent object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "components");
    editingContext().deleteObject(object);
  }

  public void deleteAllComponentsRelationships() {
    Enumeration objects = components().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteComponentsRelationship((is.us.soloweb.data.SWComponent)objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.data.SWSite> site() {
    return (NSArray<is.us.soloweb.data.SWSite>)storedValueForKey("site");
  }

  public NSArray<is.us.soloweb.data.SWSite> site(EOQualifier qualifier) {
    return site(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWSite> site(EOQualifier qualifier, boolean fetch) {
    return site(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWSite> site(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWSite> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWSite.FRONTPAGE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWSite.fetchSWSites(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = site();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWSite>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWSite>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToSite(is.us.soloweb.data.SWSite object) {
    includeObjectIntoPropertyWithKey(object, "site");
  }

  public void removeFromSite(is.us.soloweb.data.SWSite object) {
    excludeObjectFromPropertyWithKey(object, "site");
  }

  public void addToSiteRelationship(is.us.soloweb.data.SWSite object) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("adding " + object + " to site relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToSite(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "site");
    }
  }

  public void removeFromSiteRelationship(is.us.soloweb.data.SWSite object) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("removing " + object + " from site relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromSite(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "site");
    }
  }

  public is.us.soloweb.data.SWSite createSiteRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWSite");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "site");
    return (is.us.soloweb.data.SWSite) eo;
  }

  public void deleteSiteRelationship(is.us.soloweb.data.SWSite object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "site");
    editingContext().deleteObject(object);
  }

  public void deleteAllSiteRelationships() {
    Enumeration objects = site().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteSiteRelationship((is.us.soloweb.data.SWSite)objects.nextElement());
    }
  }

  public NSArray<is.us.soloweb.data.SWPage> subPages() {
    return (NSArray<is.us.soloweb.data.SWPage>)storedValueForKey("subPages");
  }

  public NSArray<is.us.soloweb.data.SWPage> subPages(EOQualifier qualifier) {
    return subPages(qualifier, null, false);
  }

  public NSArray<is.us.soloweb.data.SWPage> subPages(EOQualifier qualifier, boolean fetch) {
    return subPages(qualifier, null, fetch);
  }

  public NSArray<is.us.soloweb.data.SWPage> subPages(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<is.us.soloweb.data.SWPage> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWPage.PARENT_PAGE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = is.us.soloweb.data.SWPage.fetchSWPages(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = subPages();
      if (qualifier != null) {
        results = (NSArray<is.us.soloweb.data.SWPage>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<is.us.soloweb.data.SWPage>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToSubPages(is.us.soloweb.data.SWPage object) {
    includeObjectIntoPropertyWithKey(object, "subPages");
  }

  public void removeFromSubPages(is.us.soloweb.data.SWPage object) {
    excludeObjectFromPropertyWithKey(object, "subPages");
  }

  public void addToSubPagesRelationship(is.us.soloweb.data.SWPage object) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("adding " + object + " to subPages relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToSubPages(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "subPages");
    }
  }

  public void removeFromSubPagesRelationship(is.us.soloweb.data.SWPage object) {
    if (_SWPage.LOG.isDebugEnabled()) {
      _SWPage.LOG.debug("removing " + object + " from subPages relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromSubPages(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "subPages");
    }
  }

  public is.us.soloweb.data.SWPage createSubPagesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWPage");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "subPages");
    return (is.us.soloweb.data.SWPage) eo;
  }

  public void deleteSubPagesRelationship(is.us.soloweb.data.SWPage object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "subPages");
    editingContext().deleteObject(object);
  }

  public void deleteAllSubPagesRelationships() {
    Enumeration objects = subPages().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteSubPagesRelationship((is.us.soloweb.data.SWPage)objects.nextElement());
    }
  }


  public static SWPage createSWPage(EOEditingContext editingContext, Integer pageID
) {
    SWPage eo = (SWPage) EOUtilities.createAndInsertInstance(editingContext, _SWPage.ENTITY_NAME);    
		eo.setPageID(pageID);
    return eo;
  }

  public static NSArray<SWPage> fetchAllSWPages(EOEditingContext editingContext) {
    return _SWPage.fetchAllSWPages(editingContext, null);
  }

  public static NSArray<SWPage> fetchAllSWPages(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWPage.fetchSWPages(editingContext, null, sortOrderings);
  }

  public static NSArray<SWPage> fetchSWPages(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWPage.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWPage> eoObjects = (NSArray<SWPage>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWPage fetchSWPage(EOEditingContext editingContext, String keyName, Object value) {
    return _SWPage.fetchSWPage(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWPage fetchSWPage(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWPage> eoObjects = _SWPage.fetchSWPages(editingContext, qualifier, null);
    SWPage eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWPage)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWPage that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWPage fetchRequiredSWPage(EOEditingContext editingContext, String keyName, Object value) {
    return _SWPage.fetchRequiredSWPage(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWPage fetchRequiredSWPage(EOEditingContext editingContext, EOQualifier qualifier) {
    SWPage eoObject = _SWPage.fetchSWPage(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWPage that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWPage localInstanceIn(EOEditingContext editingContext, SWPage eo) {
    SWPage localInstance = (eo == null) ? null : (SWPage)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
