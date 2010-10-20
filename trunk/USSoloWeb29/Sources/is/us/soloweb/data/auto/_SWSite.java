// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWSite.java instead.
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

  public is.us.soloweb.data.SWSite localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWSite localInstance = (is.us.soloweb.data.SWSite)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String customInfoString() {
    return (String) storedValueForKey(_SWSite.CUSTOM_INFO_STRING_KEY);
  }

  public void setCustomInfoString(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating customInfoString from " + customInfoString() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.CUSTOM_INFO_STRING_KEY);
  }

  public String language() {
    return (String) storedValueForKey(_SWSite.LANGUAGE_KEY);
  }

  public void setLanguage(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating language from " + language() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.LANGUAGE_KEY);
  }

  public String look() {
    return (String) storedValueForKey(_SWSite.LOOK_KEY);
  }

  public void setLook(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating look from " + look() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.LOOK_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWSite.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.NAME_KEY);
  }

  public String noPageFoundErrorPageLinkingName() {
    return (String) storedValueForKey(_SWSite.NO_PAGE_FOUND_ERROR_PAGE_LINKING_NAME_KEY);
  }

  public void setNoPageFoundErrorPageLinkingName(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating noPageFoundErrorPageLinkingName from " + noPageFoundErrorPageLinkingName() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.NO_PAGE_FOUND_ERROR_PAGE_LINKING_NAME_KEY);
  }

  public Integer pageID() {
    return (Integer) storedValueForKey(_SWSite.PAGE_ID_KEY);
  }

  public void setPageID(Integer value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating pageID from " + pageID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.PAGE_ID_KEY);
  }

  public String qual() {
    return (String) storedValueForKey(_SWSite.QUAL_KEY);
  }

  public void setQual(String value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating qual from " + qual() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.QUAL_KEY);
  }

  public Integer siteID() {
    return (Integer) storedValueForKey(_SWSite.SITE_ID_KEY);
  }

  public void setSiteID(Integer value) {
    if (_SWSite.LOG.isDebugEnabled()) {
    	_SWSite.LOG.debug( "updating siteID from " + siteID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWSite.SITE_ID_KEY);
  }

  public is.us.soloweb.data.SWPage frontpage() {
    return (is.us.soloweb.data.SWPage)storedValueForKey(_SWSite.FRONTPAGE_KEY);
  }
  
  public void setFrontpage(is.us.soloweb.data.SWPage value) {
    takeStoredValueForKey(value, _SWSite.FRONTPAGE_KEY);
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
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWSite.FRONTPAGE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWSite.FRONTPAGE_KEY);
    }
  }
  

  public static is.us.soloweb.data.SWSite createSWSite(EOEditingContext editingContext, Integer siteID
) {
    is.us.soloweb.data.SWSite eo = (is.us.soloweb.data.SWSite) EOUtilities.createAndInsertInstance(editingContext, _SWSite.ENTITY_NAME);    
		eo.setSiteID(siteID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWSite> fetchAllSWSites(EOEditingContext editingContext) {
    return _SWSite.fetchAllSWSites(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWSite> fetchAllSWSites(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWSite.fetchSWSites(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWSite> fetchSWSites(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWSite> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWSite>(_SWSite.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWSite> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWSite fetchSWSite(EOEditingContext editingContext, String keyName, Object value) {
    return _SWSite.fetchSWSite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWSite fetchSWSite(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWSite> eoObjects = _SWSite.fetchSWSites(editingContext, qualifier, null);
    is.us.soloweb.data.SWSite eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWSite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWSite fetchRequiredSWSite(EOEditingContext editingContext, String keyName, Object value) {
    return _SWSite.fetchRequiredSWSite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWSite fetchRequiredSWSite(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWSite eoObject = _SWSite.fetchSWSite(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWSite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWSite localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWSite eo) {
    is.us.soloweb.data.SWSite localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
