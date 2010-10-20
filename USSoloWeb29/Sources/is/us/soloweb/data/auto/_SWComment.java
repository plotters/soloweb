// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWComment.java instead.
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
public abstract class _SWComment extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWComment";

  // Attribute Keys
  public static final ERXKey<Integer> COMMENT_ID = new ERXKey<Integer>("commentID");
  public static final ERXKey<NSTimestamp> DATE = new ERXKey<NSTimestamp>("date");
  public static final ERXKey<String> EMAIL_ADDRESS = new ERXKey<String>("emailAddress");
  public static final ERXKey<String> IP_ADDRESS = new ERXKey<String>("ipAddress");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> NEWS_ITEM_ID = new ERXKey<Integer>("newsItemID");
  public static final ERXKey<Integer> NOTIFY_ON_NEW_COMMENTS = new ERXKey<Integer>("notifyOnNewComments");
  public static final ERXKey<String> TEXT = new ERXKey<String>("text");
  public static final ERXKey<String> URL = new ERXKey<String>("url");
  public static final ERXKey<String> USER_AGENT = new ERXKey<String>("userAgent");
  public static final ERXKey<Integer> USER_ID = new ERXKey<Integer>("userID");
  public static final ERXKey<NSData> USER_PICTURE = new ERXKey<NSData>("userPicture");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWNewsItem> NEWSITEM = new ERXKey<is.us.soloweb.data.SWNewsItem>("newsitem");
  public static final ERXKey<is.us.soloweb.data.SWExternalUser> USER = new ERXKey<is.us.soloweb.data.SWExternalUser>("user");

  // Attributes
  public static final String COMMENT_ID_KEY = COMMENT_ID.key();
  public static final String DATE_KEY = DATE.key();
  public static final String EMAIL_ADDRESS_KEY = EMAIL_ADDRESS.key();
  public static final String IP_ADDRESS_KEY = IP_ADDRESS.key();
  public static final String NAME_KEY = NAME.key();
  public static final String NEWS_ITEM_ID_KEY = NEWS_ITEM_ID.key();
  public static final String NOTIFY_ON_NEW_COMMENTS_KEY = NOTIFY_ON_NEW_COMMENTS.key();
  public static final String TEXT_KEY = TEXT.key();
  public static final String URL_KEY = URL.key();
  public static final String USER_AGENT_KEY = USER_AGENT.key();
  public static final String USER_ID_KEY = USER_ID.key();
  public static final String USER_PICTURE_KEY = USER_PICTURE.key();
  // Relationships
  public static final String NEWSITEM_KEY = NEWSITEM.key();
  public static final String USER_KEY = USER.key();

  private static Logger LOG = Logger.getLogger(_SWComment.class);

  public is.us.soloweb.data.SWComment localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWComment localInstance = (is.us.soloweb.data.SWComment)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer commentID() {
    return (Integer) storedValueForKey(_SWComment.COMMENT_ID_KEY);
  }

  public void setCommentID(Integer value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating commentID from " + commentID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.COMMENT_ID_KEY);
  }

  public NSTimestamp date() {
    return (NSTimestamp) storedValueForKey(_SWComment.DATE_KEY);
  }

  public void setDate(NSTimestamp value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating date from " + date() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.DATE_KEY);
  }

  public String emailAddress() {
    return (String) storedValueForKey(_SWComment.EMAIL_ADDRESS_KEY);
  }

  public void setEmailAddress(String value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating emailAddress from " + emailAddress() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.EMAIL_ADDRESS_KEY);
  }

  public String ipAddress() {
    return (String) storedValueForKey(_SWComment.IP_ADDRESS_KEY);
  }

  public void setIpAddress(String value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating ipAddress from " + ipAddress() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.IP_ADDRESS_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_SWComment.NAME_KEY);
  }

  public void setName(String value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.NAME_KEY);
  }

  public Integer newsItemID() {
    return (Integer) storedValueForKey(_SWComment.NEWS_ITEM_ID_KEY);
  }

  public void setNewsItemID(Integer value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating newsItemID from " + newsItemID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.NEWS_ITEM_ID_KEY);
  }

  public Integer notifyOnNewComments() {
    return (Integer) storedValueForKey(_SWComment.NOTIFY_ON_NEW_COMMENTS_KEY);
  }

  public void setNotifyOnNewComments(Integer value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating notifyOnNewComments from " + notifyOnNewComments() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.NOTIFY_ON_NEW_COMMENTS_KEY);
  }

  public String text() {
    return (String) storedValueForKey(_SWComment.TEXT_KEY);
  }

  public void setText(String value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating text from " + text() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.TEXT_KEY);
  }

  public String url() {
    return (String) storedValueForKey(_SWComment.URL_KEY);
  }

  public void setUrl(String value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating url from " + url() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.URL_KEY);
  }

  public String userAgent() {
    return (String) storedValueForKey(_SWComment.USER_AGENT_KEY);
  }

  public void setUserAgent(String value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating userAgent from " + userAgent() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.USER_AGENT_KEY);
  }

  public Integer userID() {
    return (Integer) storedValueForKey(_SWComment.USER_ID_KEY);
  }

  public void setUserID(Integer value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.USER_ID_KEY);
  }

  public NSData userPicture() {
    return (NSData) storedValueForKey(_SWComment.USER_PICTURE_KEY);
  }

  public void setUserPicture(NSData value) {
    if (_SWComment.LOG.isDebugEnabled()) {
    	_SWComment.LOG.debug( "updating userPicture from " + userPicture() + " to " + value);
    }
    takeStoredValueForKey(value, _SWComment.USER_PICTURE_KEY);
  }

  public is.us.soloweb.data.SWNewsItem newsitem() {
    return (is.us.soloweb.data.SWNewsItem)storedValueForKey(_SWComment.NEWSITEM_KEY);
  }
  
  public void setNewsitem(is.us.soloweb.data.SWNewsItem value) {
    takeStoredValueForKey(value, _SWComment.NEWSITEM_KEY);
  }

  public void setNewsitemRelationship(is.us.soloweb.data.SWNewsItem value) {
    if (_SWComment.LOG.isDebugEnabled()) {
      _SWComment.LOG.debug("updating newsitem from " + newsitem() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setNewsitem(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWNewsItem oldValue = newsitem();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWComment.NEWSITEM_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWComment.NEWSITEM_KEY);
    }
  }
  
  public is.us.soloweb.data.SWExternalUser user() {
    return (is.us.soloweb.data.SWExternalUser)storedValueForKey(_SWComment.USER_KEY);
  }
  
  public void setUser(is.us.soloweb.data.SWExternalUser value) {
    takeStoredValueForKey(value, _SWComment.USER_KEY);
  }

  public void setUserRelationship(is.us.soloweb.data.SWExternalUser value) {
    if (_SWComment.LOG.isDebugEnabled()) {
      _SWComment.LOG.debug("updating user from " + user() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setUser(value);
    }
    else if (value == null) {
    	is.us.soloweb.data.SWExternalUser oldValue = user();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _SWComment.USER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _SWComment.USER_KEY);
    }
  }
  

  public static is.us.soloweb.data.SWComment createSWComment(EOEditingContext editingContext, Integer commentID
) {
    is.us.soloweb.data.SWComment eo = (is.us.soloweb.data.SWComment) EOUtilities.createAndInsertInstance(editingContext, _SWComment.ENTITY_NAME);    
		eo.setCommentID(commentID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWComment> fetchAllSWComments(EOEditingContext editingContext) {
    return _SWComment.fetchAllSWComments(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWComment> fetchAllSWComments(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWComment.fetchSWComments(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWComment> fetchSWComments(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWComment> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWComment>(_SWComment.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWComment> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWComment fetchSWComment(EOEditingContext editingContext, String keyName, Object value) {
    return _SWComment.fetchSWComment(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWComment fetchSWComment(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWComment> eoObjects = _SWComment.fetchSWComments(editingContext, qualifier, null);
    is.us.soloweb.data.SWComment eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWComment that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWComment fetchRequiredSWComment(EOEditingContext editingContext, String keyName, Object value) {
    return _SWComment.fetchRequiredSWComment(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWComment fetchRequiredSWComment(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWComment eoObject = _SWComment.fetchSWComment(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWComment that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWComment localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWComment eo) {
    is.us.soloweb.data.SWComment localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
