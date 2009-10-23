package is.us.soloweb.util;

import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.*;
import is.us.util.USUtilities;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.extensions.eof.*;

/**
 * For updating customInfo attributes.
 * 
 * @author Hugi Þórðarson
 */

public class SWTransactionManager {

	/**
	 * The transaction watcher is a singleton - this is the instance.
	 */
	private static SWTransactionManager _defaultTransactionManager;

	private static NSMutableArray<SWTransaction> transactionsMissingPrimaryKeys = new NSMutableArray<SWTransaction>();

	/**
	 * Actions that can be performed (and logged) on EOs.
	 */
	private static final String ACTION_INSERT = "I";
	private static final String ACTION_UPDATE = "U";
	private static final String ACTION_DELETE = "D";

	/**
	 * Key set in userinfo dictionary for EditingContexts where transactions should not be logged.
	 */
	private static final String DO_NOT_LOG_MARKER = "DO_NOT_LOG_TRANSACTIONS_IN_THIS_EC";

	/**
	 * Logging happens in this EC.
	 */
	private ERXEC _loggingEC = (ERXEC)ERXEC.newEditingContext();

	/**
	 * It's a singleton.
	 * 
	 * We set the logging editing context so that transactions in it are not logged
	 * (logging transactions in the loggingEC would result in an infinite loop).
	 */
	private SWTransactionManager() {
		_loggingEC.setUserInfoForKey( true, DO_NOT_LOG_MARKER );
	}

	/**
	 * Creates our default transaction manager. 
	 */
	public static SWTransactionManager defaultTransactionManager() {
		if( _defaultTransactionManager == null ) {
			_defaultTransactionManager = new SWTransactionManager();
		}

		return _defaultTransactionManager;
	}

	/**
	 * This method is invoked each time changes are saved in *any* EC in the application.
	 */
	public void beforeSaveChangesInEditingContext( NSNotification notification ) {
		EOEditingContext ec = (EOEditingContext)notification.object();

		SWUser user = (SWUser)ec.userInfoForKey( SWC.SW_USER_USERINFO_KEY );

		Object shouldNotLog = ec.userInfoForKey( DO_NOT_LOG_MARKER );

		if( shouldNotLog == null ) {
			for( Object o : ec.registeredObjects() ) {
				if( o instanceof SWCustomInfo ) {
					SWCustomInfo ci = (SWCustomInfo)o;
					String currentCustomInfoSerialized = NSPropertyListSerialization.stringFromPropertyList( ci.customInfo() );

					if( !USUtilities.eq( ci.customInfoString(), currentCustomInfoSerialized ) ) {
						ci.setCustomInfoString( currentCustomInfoSerialized );
					}
				}
			}

			for( EOEnterpriseObject eo : ec.insertedObjects() ) {
				if( eo instanceof SWTransactionLogged ) {
					((SWTransactionLogged)eo).setCreationDate( new NSTimestamp() );
					((SWTransactionLogged)eo).setModificationDate( new NSTimestamp() );

					if( user != null ) {
						((SWTransactionLogged)eo).setModifiedBy( user );
						((SWTransactionLogged)eo).setCreatedBy( user );
					}
				}
				SWTransaction t = createAndInsertTransactionForEO( ACTION_INSERT, eo );
				transactionsMissingPrimaryKeys.addObject( t );
			}

			for( EOEnterpriseObject eo : ec.updatedObjects() ) {
				if( eo instanceof SWTransactionLogged ) {
					((SWTransactionLogged)eo).setModificationDate( new NSTimestamp() );

					if( user != null ) {
						((SWTransactionLogged)eo).setModifiedBy( user );
					}
				}

				createAndInsertTransactionForEO( ACTION_UPDATE, eo );
			}

			// Deleted objects
			for( EOEnterpriseObject eo : ec.deletedObjects() ) {
				createAndInsertTransactionForEO( ACTION_DELETE, eo );
			}

			_loggingEC.saveChanges();
		}
	}

	public void afterSaveChangesInEditingContext( NSNotification notification ) {
		EOEditingContext ec = (EOEditingContext)notification.object();
		Object shouldNotLog = ec.userInfoForKey( DO_NOT_LOG_MARKER );

		if( shouldNotLog == null ) {
			for( SWTransaction t : transactionsMissingPrimaryKeys ) {
				ERXEnterpriseObject eo = ((ERXGenericRecord)t.record());
				t.setObjectID( USUtilities.integerFromObject( eo.primaryKey() ) );
				transactionsMissingPrimaryKeys.removeObject( eo );
			}

			_loggingEC.saveChanges();
		}
	}

	private SWTransaction createAndInsertTransactionForEO( String action, EOEnterpriseObject eo ) {
		SWTransaction t = new SWTransaction();
		_loggingEC.insertObject( t );
		t.setDate( new NSTimestamp() );

		// FIXME: Look into this, it might be breaking with proper MVC design.
		SWUser user = (SWUser)eo.editingContext().userInfoForKey( SWC.SW_USER_USERINFO_KEY );

		if( user != null )
			t.setUserID( user.userID() );

		t.setBefore( NSPropertyListSerialization.stringFromPropertyList( ((ERXGenericRecord)eo).committedSnapshot() ) );
		t.setAfter( NSPropertyListSerialization.stringFromPropertyList( ((ERXGenericRecord)eo).changesFromCommittedSnapshot() ) );
		t.setAction( action );
		t.setEntityNameString( eo.entityName() );
		t.setObjectID( USUtilities.integerFromObject( ((ERXGenericRecord)eo).primaryKey() ) );
		t.setRecord( eo );

		return t;
	}

	/**
	 * Registers the transaction manager so it starts listening and watching transactions.
	 */
	public static void register() {
		NSSelector<SWTransactionManager> beforeSaveSelector = new NSSelector<SWTransactionManager>( "beforeSaveChangesInEditingContext", new Class[] { NSNotification.class } );
		NSNotificationCenter.defaultCenter().addObserver( defaultTransactionManager(), beforeSaveSelector, ERXEC.EditingContextWillSaveChangesNotification, null );

		NSSelector<SWTransactionManager> afterSaveSelector = new NSSelector<SWTransactionManager>( "afterSaveChangesInEditingContext", new Class[] { NSNotification.class } );
		NSNotificationCenter.defaultCenter().addObserver( defaultTransactionManager(), afterSaveSelector, ERXEC.EditingContextDidSaveChangesNotification, null );
	}
}