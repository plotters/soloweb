// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWSite.java instead.
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
public abstract class _SWSite extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWSite";

  // Attribute Keys
  public static final ERXKey<String> CUSTOM_INFO_STRING = new ERXKey<String>("customInfoString");
  public static final ERXKey<String> LANGUAGE = new ERXKey<String>("language");
  public static final ERXKey<String> LOOK = new ERXKey<String>("look");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> NO_PAGE_FOUND_ERROR_PAGE_LINKING_NAME = new ERXKey<String>("noPageFoundErrorPageLinkingName");
  public static final ERXKey<Integer> PAGE_ID = new ERXKey<Integer>("pageID");
  public static final ERXKey<String> QUAL = new ERXKey<String>("qual");
  public static final ERXKey<Integer> SITE_ID = new ERXKey<Integer>("siteID");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWPage> FRONTPAGE = new ERXKey<is.us.soloweb.data.SWPage>("frontpage");

  // Attributes
  public static final String CUSTOM_INFO_STRING_KEY = CUSTOM_INFO_STRING.key();
  public static final String LANGUAGE_KEY = LANGUAGE.key();
  public static final String LOOK_KEY = LOOK.key();
  public static final String NAME_KEY = NAME.key();
  public static final String NO_PAGE_FOUND_ERROR_PAGE_LINKING_NAME_KEY = NO_PAGE_FOUND_ERROR_PAGE_LINKING_NAME.key();
  public static final String PAGE_ID_KEY = PAGE_ID.key();
  public static final String QUAL_KEY = QUAL.key();
  public static final String SITE_ID_KEY = SITE_ID.key();
  // Relationships
  public static final String FRONTPAGE_KEY = FRONTPAGE.key();

  private static Logger LOG = Logger.getLogger(_SWSite.class);

  public SWSite localInstanceIn(EOEditingContext editingContext) {
    SWSite localInstance = (SWSite)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String customInfoString() {
    return (String) storedValueForKey("customInfoString");
  }

  public void setCustomInfoString(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating customInfoString from " + customInfoString() + " to " + value);
    }
    takeStoredValueForKey(value, "customInfoString");
  }

  public String language() {
    return (String) storedValueForKey("language");
  }

  public void setLanguage(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating language from " + language() + " to " + value);
    }
    takeStoredValueForKey(value, "language");
  }

  public String look() {
    return (String) storedValueForKey("look");
  }

  public void setLook(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating look from " + look() + " to " + value);
    }
    takeStoredValueForKey(value, "look");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public String noPageFoundErrorPageLinkingName() {
    return (String) storedValueForKey("noPageFoundErrorPageLinkingName");
  }

  public void setNoPageFoundErrorPageLinkingName(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating noPageFoundErrorPageLinkingName from " + noPageFoundErrorPageLinkingName() + " to " + value);
    }
    takeStoredValueForKey(value, "noPageFoundErrorPageLinkingName");
  }

  public Integer pageID() {
    return (Integer) storedValueForKey("pageID");
  }

  public void setPageID(Integer value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating pageID from " + pageID() + " to " + value);
    }
    takeStoredValueForKey(value, "pageID");
  }

  public String qual() {
    return (String) storedValueForKey("qual");
  }

  public void setQual(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating qual from " + qual() + " to " + value);
    }
    takeStoredValueForKey(value, "qual");
  }

  public Integer siteID() {
    return (Integer) storedValueForKey("siteID");
  }

  public void setSiteID(Integer value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating siteID from " + siteID() + " to " + value);
    }
    takeStoredValueForKey(value, "siteID");
  }

  public is.us.soloweb.data.SWPage frontpage() {
    return (is.us.soloweb.data.SWPage)storedValueForKey("frontpage");
  }
  
  public void setFrontpage(is.us.soloweb.data.SWPage value) {
    takeStoredValueForKey(value, "frontpage");
  }

  public void setFrontpageRelationship(is.us.soloweb.data.SWPage value) {
    if (_SWSite.LOG.isDebugEnabled()) {
      _SWSite.LOG.debug("updating frontpage from " + frontpage() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setFrontpage(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWPage oldValue = frontpage();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "frontpage");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "frontpage");
    }
  }
  

  public static SWSite createSWSite(EOEditingContext editingContext, Integer siteID
) {
    SWSite eo = (SWSite) EOUtilities.createAndInsertInstance(editingContext, _SWSite.ENTITY_NAME);    
		eo.setSiteID(siteID);
    return eo;
  }

  public static NSArray<SWSite> fetchAllSWSites(EOEditingContext editingContext) {
    return _SWSite.fetchAllSWSites(editingContext, null);
  }

  public static NSArray<SWSite> fetchAllSWSites(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWSite.fetchSWSites(editingContext, null, sortOrderings);
  }

  public static NSArray<SWSite> fetchSWSites(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWSite.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWSite> eoObjects = (NSArray<SWSite>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWSite fetchSWSite(EOEditingContext editingContext, String keyName, Object value) {
    return _SWSite.fetchSWSite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWSite fetchSWSite(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWSite> eoObjects = _SWSite.fetchSWSites(editingContext, qualifier, null);
    SWSite eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWSite)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWSite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWSite fetchRequiredSWSite(EOEditingContext editingContext, String keyName, Object value) {
    return _SWSite.fetchRequiredSWSite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWSite fetchRequiredSWSite(EOEditingContext editingContext, EOQualifier qualifier) {
    SWSite eoObject = _SWSite.fetchSWSite(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWSite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWSite localInstanceIn(EOEditingContext editingContext, SWSite eo) {
    SWSite localInstance = (eo == null) ? null : (SWSite)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
