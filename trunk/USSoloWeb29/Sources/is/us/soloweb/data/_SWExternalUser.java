// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWExternalUser.java instead.
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
public abstract class _SWExternalUser extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWExternalUser";

  // Attribute Keys
  public static final ERXKey<String> EMAIL_ADDRESS = new ERXKey<String>("emailAddress");
  public static final ERXKey<Integer> NOTIFY_ON_NEW_COMMENTS = new ERXKey<Integer>("notifyOnNewComments");
  public static final ERXKey<String> TWITTER_USERNAME = new ERXKey<String>("twitterUsername");
  public static final ERXKey<String> URL = new ERXKey<String>("url");
  public static final ERXKey<Integer> USER_ID = new ERXKey<Integer>("userID");
  public static final ERXKey<String> USERNAME = new ERXKey<String>("username");
  public static final ERXKey<NSData> USER_PICTURE = new ERXKey<NSData>("userPicture");
  public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
  // Relationship Keys
  public static final ERXKey<is.us.soloweb.data.SWComment> COMMENTS = new ERXKey<is.us.soloweb.data.SWComment>("comments");

  // Attributes
  public static final String EMAIL_ADDRESS_KEY = EMAIL_ADDRESS.key();
  public static final String NOTIFY_ON_NEW_COMMENTS_KEY = NOTIFY_ON_NEW_COMMENTS.key();
  public static final String TWITTER_USERNAME_KEY = TWITTER_USERNAME.key();
  public static final String URL_KEY = URL.key();
  public static final String USER_ID_KEY = USER_ID.key();
  public static final String USERNAME_KEY = USERNAME.key();
  public static final String USER_PICTURE_KEY = USER_PICTURE.key();
  public static final String UUID_KEY = UUID.key();
  // Relationships
  public static final String COMMENTS_KEY = COMMENTS.key();

  private static Logger LOG = Logger.getLogger(_SWExternalUser.class);

  public SWExternalUser localInstanceIn(EOEditingContext editingContext) {
    SWExternalUser localInstance = (SWExternalUser)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String emailAddress() {
    return (String) storedValueForKey("emailAddress");
  }

  public void setEmailAddress(String value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating emailAddress from " + emailAddress() + " to " + value);
    }
    takeStoredValueForKey(value, "emailAddress");
  }

  public Integer notifyOnNewComments() {
    return (Integer) storedValueForKey("notifyOnNewComments");
  }

  public void setNotifyOnNewComments(Integer value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating notifyOnNewComments from " + notifyOnNewComments() + " to " + value);
    }
    takeStoredValueForKey(value, "notifyOnNewComments");
  }

  public String twitterUsername() {
    return (String) storedValueForKey("twitterUsername");
  }

  public void setTwitterUsername(String value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating twitterUsername from " + twitterUsername() + " to " + value);
    }
    takeStoredValueForKey(value, "twitterUsername");
  }

  public String url() {
    return (String) storedValueForKey("url");
  }

  public void setUrl(String value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating url from " + url() + " to " + value);
    }
    takeStoredValueForKey(value, "url");
  }

  public Integer userID() {
    return (Integer) storedValueForKey("userID");
  }

  public void setUserID(Integer value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, "userID");
  }

  public String username() {
    return (String) storedValueForKey("username");
  }

  public void setUsername(String value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating username from " + username() + " to " + value);
    }
    takeStoredValueForKey(value, "username");
  }

  public NSData userPicture() {
    return (NSData) storedValueForKey("userPicture");
  }

  public void setUserPicture(NSData value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating userPicture from " + userPicture() + " to " + value);
    }
    takeStoredValueForKey(value, "userPicture");
  }

  public String uuid() {
    return (String) storedValueForKey("uuid");
  }

  public void setUuid(String value) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
    	_SWExternalUser.LOG.debug( "updating uuid from " + uuid() + " to " + value);
    }
    takeStoredValueForKey(value, "uuid");
  }

  public NSArray<is.us.soloweb.data.SWComment> comments() {
    return (NSArray<is.us.soloweb.data.SWComment>)storedValueForKey("comments");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(is.us.soloweb.data.SWComment.USER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
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
    includeObjectIntoPropertyWithKey(object, "comments");
  }

  public void removeFromComments(is.us.soloweb.data.SWComment object) {
    excludeObjectFromPropertyWithKey(object, "comments");
  }

  public void addToCommentsRelationship(is.us.soloweb.data.SWComment object) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
      _SWExternalUser.LOG.debug("adding " + object + " to comments relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToComments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "comments");
    }
  }

  public void removeFromCommentsRelationship(is.us.soloweb.data.SWComment object) {
    if (_SWExternalUser.LOG.isDebugEnabled()) {
      _SWExternalUser.LOG.debug("removing " + object + " from comments relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromComments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "comments");
    }
  }

  public is.us.soloweb.data.SWComment createCommentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SWComment");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "comments");
    return (is.us.soloweb.data.SWComment) eo;
  }

  public void deleteCommentsRelationship(is.us.soloweb.data.SWComment object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "comments");
    editingContext().deleteObject(object);
  }

  public void deleteAllCommentsRelationships() {
    Enumeration objects = comments().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCommentsRelationship((is.us.soloweb.data.SWComment)objects.nextElement());
    }
  }


  public static SWExternalUser createSWExternalUser(EOEditingContext editingContext, Integer userID
) {
    SWExternalUser eo = (SWExternalUser) EOUtilities.createAndInsertInstance(editingContext, _SWExternalUser.ENTITY_NAME);    
		eo.setUserID(userID);
    return eo;
  }

  public static NSArray<SWExternalUser> fetchAllSWExternalUsers(EOEditingContext editingContext) {
    return _SWExternalUser.fetchAllSWExternalUsers(editingContext, null);
  }

  public static NSArray<SWExternalUser> fetchAllSWExternalUsers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWExternalUser.fetchSWExternalUsers(editingContext, null, sortOrderings);
  }

  public static NSArray<SWExternalUser> fetchSWExternalUsers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWExternalUser.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWExternalUser> eoObjects = (NSArray<SWExternalUser>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWExternalUser fetchSWExternalUser(EOEditingContext editingContext, String keyName, Object value) {
    return _SWExternalUser.fetchSWExternalUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWExternalUser fetchSWExternalUser(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWExternalUser> eoObjects = _SWExternalUser.fetchSWExternalUsers(editingContext, qualifier, null);
    SWExternalUser eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWExternalUser)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWExternalUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWExternalUser fetchRequiredSWExternalUser(EOEditingContext editingContext, String keyName, Object value) {
    return _SWExternalUser.fetchRequiredSWExternalUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWExternalUser fetchRequiredSWExternalUser(EOEditingContext editingContext, EOQualifier qualifier) {
    SWExternalUser eoObject = _SWExternalUser.fetchSWExternalUser(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWExternalUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWExternalUser localInstanceIn(EOEditingContext editingContext, SWExternalUser eo) {
    SWExternalUser localInstance = (eo == null) ? null : (SWExternalUser)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
