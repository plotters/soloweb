// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SWTransaction.java instead.
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

  public SWTransaction localInstanceIn(EOEditingContext editingContext) {
    SWTransaction localInstance = (SWTransaction)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String action() {
    return (String) storedValueForKey("action");
  }

  public void setAction(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating action from " + action() + " to " + value);
    }
    takeStoredValueForKey(value, "action");
  }

  public String after() {
    return (String) storedValueForKey("after");
  }

  public void setAfter(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating after from " + after() + " to " + value);
    }
    takeStoredValueForKey(value, "after");
  }

  public String before() {
    return (String) storedValueForKey("before");
  }

  public void setBefore(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating before from " + before() + " to " + value);
    }
    takeStoredValueForKey(value, "before");
  }

  public NSTimestamp date() {
    return (NSTimestamp) storedValueForKey("date");
  }

  public void setDate(NSTimestamp value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating date from " + date() + " to " + value);
    }
    takeStoredValueForKey(value, "date");
  }

  public String entityNameString() {
    return (String) storedValueForKey("entityNameString");
  }

  public void setEntityNameString(String value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating entityNameString from " + entityNameString() + " to " + value);
    }
    takeStoredValueForKey(value, "entityNameString");
  }

  public Integer objectID() {
    return (Integer) storedValueForKey("objectID");
  }

  public void setObjectID(Integer value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating objectID from " + objectID() + " to " + value);
    }
    takeStoredValueForKey(value, "objectID");
  }

  public Integer transactionID() {
    return (Integer) storedValueForKey("transactionID");
  }

  public void setTransactionID(Integer value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating transactionID from " + transactionID() + " to " + value);
    }
    takeStoredValueForKey(value, "transactionID");
  }

  public Integer userID() {
    return (Integer) storedValueForKey("userID");
  }

  public void setUserID(Integer value) {
    if (_SWTransaction.LOG.isDebugEnabled()) {
    	_SWTransaction.LOG.debug( "updating userID from " + userID() + " to " + value);
    }
    takeStoredValueForKey(value, "userID");
  }


  public static SWTransaction createSWTransaction(EOEditingContext editingContext, Integer transactionID
) {
    SWTransaction eo = (SWTransaction) EOUtilities.createAndInsertInstance(editingContext, _SWTransaction.ENTITY_NAME);    
		eo.setTransactionID(transactionID);
    return eo;
  }

  public static NSArray<SWTransaction> fetchAllSWTransactions(EOEditingContext editingContext) {
    return _SWTransaction.fetchAllSWTransactions(editingContext, null);
  }

  public static NSArray<SWTransaction> fetchAllSWTransactions(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SWTransaction.fetchSWTransactions(editingContext, null, sortOrderings);
  }

  public static NSArray<SWTransaction> fetchSWTransactions(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SWTransaction.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SWTransaction> eoObjects = (NSArray<SWTransaction>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SWTransaction fetchSWTransaction(EOEditingContext editingContext, String keyName, Object value) {
    return _SWTransaction.fetchSWTransaction(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWTransaction fetchSWTransaction(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SWTransaction> eoObjects = _SWTransaction.fetchSWTransactions(editingContext, qualifier, null);
    SWTransaction eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SWTransaction)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SWTransaction that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWTransaction fetchRequiredSWTransaction(EOEditingContext editingContext, String keyName, Object value) {
    return _SWTransaction.fetchRequiredSWTransaction(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SWTransaction fetchRequiredSWTransaction(EOEditingContext editingContext, EOQualifier qualifier) {
    SWTransaction eoObject = _SWTransaction.fetchSWTransaction(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SWTransaction that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SWTransaction localInstanceIn(EOEditingContext editingContext, SWTransaction eo) {
    SWTransaction localInstance = (eo == null) ? null : (SWTransaction)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
