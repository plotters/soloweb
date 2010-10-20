// DO NOT EDIT.  Make changes to is.us.soloweb.data.SWTransaction.java instead.
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
public abstract class _SWTransaction extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "SWTransaction";

  // Attribute Keys
  public static final ERXKey<String> ACTION = new ERXKey<String>("action");
  public static final ERXKey<String> AFTER = new ERXKey<String>("after");
  public static final ERXKey<String> BEFORE = new ERXKey<String>("before");
  public static final ERXKey<NSTimestamp> DATE = new ERXKey<NSTimestamp>("date");
  public static final ERXKey<String> ENTITY_NAME_STRING = new ERXKey<String>("entityNameString");
  public static final ERXKey<Integer> OBJECT_ID = new ERXKey<Integer>("objectID");
  public static final ERXKey<Integer> TRANSACTION_ID = new ERXKey<Integer>("transactionID");
  public static final ERXKey<Integer> USER_ID = new ERXKey<Integer>("userID");
  // Relationship Keys

  // Attributes
  public static final String ACTION_KEY = ACTION.key();
  public static final String AFTER_KEY = AFTER.key();
  public static final String BEFORE_KEY = BEFORE.key();
  public static final String DATE_KEY = DATE.key();
  public static final String ENTITY_NAME_STRING_KEY = ENTITY_NAME_STRING.key();
  public static final String OBJECT_ID_KEY = OBJECT_ID.key();
  public static final String TRANSACTION_ID_KEY = TRANSACTION_ID.key();
  public static final String USER_ID_KEY = USER_ID.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_SWTransaction.class);

  public is.us.soloweb.data.SWTransaction localInstanceIn(EOEditingContext editingContext) {
    is.us.soloweb.data.SWTransaction localInstance = (is.us.soloweb.data.SWTransaction)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String action() {
    return (String) storedValueForKey(_SWTransaction.ACTION_KEY);
  }

  public void setAction(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating action from " + action() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.ACTION_KEY);
  }

  public String after() {
    return (String) storedValueForKey(_SWTransaction.AFTER_KEY);
  }

  public void setAfter(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating after from " + after() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.AFTER_KEY);
  }

  public String before() {
    return (String) storedValueForKey(_SWTransaction.BEFORE_KEY);
  }

  public void setBefore(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating before from " + before() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.BEFORE_KEY);
  }

  public NSTimestamp date() {
    return (NSTimestamp) storedValueForKey(_SWTransaction.DATE_KEY);
  }

  public void setDate(NSTimestamp value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating date from " + date() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.DATE_KEY);
  }

  public String entityNameString() {
    return (String) storedValueForKey(_SWTransaction.ENTITY_NAME_STRING_KEY);
  }

  public void setEntityNameString(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating entityNameString from " + entityNameString() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.ENTITY_NAME_STRING_KEY);
  }

  public Integer objectID() {
    return (Integer) storedValueForKey(_SWTransaction.OBJECT_ID_KEY);
  }

  public void setObjectID(Integer value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating objectID from " + objectID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.OBJECT_ID_KEY);
  }

  public Integer transactionID() {
    return (Integer) storedValueForKey(_SWTransaction.TRANSACTION_ID_KEY);
  }

  public void setTransactionID(Integer value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating transactionID from " + transactionID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.TRANSACTION_ID_KEY);
  }

  public Integer userID() {
    return (Integer) storedValueForKey(_SWTransaction.USER_ID_KEY);
  }

  public void setUserID(Integer value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, _SWTransaction.USER_ID_KEY);
  }


  public static is.us.soloweb.data.SWTransaction createSWTransaction(EOEditingContext editingContext, Integer transactionID
) {
    is.us.soloweb.data.SWTransaction eo = (is.us.soloweb.data.SWTransaction) EOUtilities.createAndInsertInstance(editingContext, _SWTransaction.ENTITY_NAME);    
		eo.setTransactionID(transactionID);
    return eo;
  }

  public static NSArray<is.us.soloweb.data.SWTransaction> fetchAllSWTransactions(EOEditingContext editingContext) {
    return _SWTransaction.fetchAllSWTransactions(editingContext, null);
  }

  public static NSArray<is.us.soloweb.data.SWTransaction> fetchAllSWTransactions(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWTransaction.fetchSWTransactions(editingContext, null, sortOrderings);
  }

  public static NSArray<is.us.soloweb.data.SWTransaction> fetchSWTransactions(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<is.us.soloweb.data.SWTransaction> fetchSpec = new ERXFetchSpecification<is.us.soloweb.data.SWTransaction>(_SWTransaction.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<is.us.soloweb.data.SWTransaction> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static is.us.soloweb.data.SWTransaction fetchSWTransaction(EOEditingContext editingContext, String keyName, Object value) {
    return _SWTransaction.fetchSWTransaction(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWTransaction fetchSWTransaction(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<is.us.soloweb.data.SWTransaction> eoObjects = _SWTransaction.fetchSWTransactions(editingContext, qualifier, null);
    is.us.soloweb.data.SWTransaction eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWTransaction that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWTransaction fetchRequiredSWTransaction(EOEditingContext editingContext, String keyName, Object value) {
    return _SWTransaction.fetchRequiredSWTransaction(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static is.us.soloweb.data.SWTransaction fetchRequiredSWTransaction(EOEditingContext editingContext, EOQualifier qualifier) {
    is.us.soloweb.data.SWTransaction eoObject = _SWTransaction.fetchSWTransaction(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWTransaction that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static is.us.soloweb.data.SWTransaction localInstanceIn(EOEditingContext editingContext, is.us.soloweb.data.SWTransaction eo) {
    is.us.soloweb.data.SWTransaction localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
