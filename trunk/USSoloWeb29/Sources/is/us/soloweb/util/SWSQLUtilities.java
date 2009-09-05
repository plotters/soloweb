package is.us.soloweb.util;

import is.us.soloweb.SWSettings;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXEC;

/**
 * SWSQLCreation generates SQL to create and drop database schema for specified EOModels in SoloWeb.
 *
 * @author Hugi Þórðarson
 * @version 2.8
 * @since 2.4
 */

public class SWSQLUtilities {

	private static final String NO = "NO";
	private static final String YES = "YES";

	/**
	 * Generates SQL code to create schema for the specified EOModel
	 *
	 * @param aModel The EOModel to generate DB schema for
	 * @param shouldDropTables Specifies if Database tables should be dropped before creating the schema.
	 */
	public static String sqlForModel( EOModel aModel, String shouldDropTables ) {
		EOSchemaGeneration sf = EOAdaptor.adaptorWithModel( aModel ).synchronizationFactory();

		NSMutableDictionary d = new NSMutableDictionary();
		d.setObjectForKey( YES, EOSchemaGeneration.CreateTablesKey );
		d.setObjectForKey( shouldDropTables, EOSchemaGeneration.DropTablesKey );
		d.setObjectForKey( YES, EOSchemaGeneration.CreatePrimaryKeySupportKey );
		d.setObjectForKey( NO, EOSchemaGeneration.DropPrimaryKeySupportKey );
		d.setObjectForKey( YES, EOSchemaGeneration.PrimaryKeyConstraintsKey );
		d.setObjectForKey( NO, EOSchemaGeneration.ForeignKeyConstraintsKey );
		d.setObjectForKey( NO, EOSchemaGeneration.CreateDatabaseKey );
		d.setObjectForKey( NO, EOSchemaGeneration.DropDatabaseKey );

		return sf.schemaCreationScriptForEntities( aModel.entities(), d );
	}

	/**
	 * Generates SQL code to drop the database schema for the specified EOModel
	 *
	 * @param aModel The EOModel to generate "drop tables"-SQL code for
	 */
	public static String sqlToDropTablesForModel( EOModel aModel ) {
		EOSchemaGeneration sf = EOAdaptor.adaptorWithModel( aModel ).synchronizationFactory();

		NSMutableDictionary d = new NSMutableDictionary();
		d.setObjectForKey( NO, EOSchemaGeneration.CreateTablesKey );
		d.setObjectForKey( YES, EOSchemaGeneration.DropTablesKey );
		d.setObjectForKey( NO, EOSchemaGeneration.CreatePrimaryKeySupportKey );
		d.setObjectForKey( NO, EOSchemaGeneration.DropPrimaryKeySupportKey );
		d.setObjectForKey( NO, EOSchemaGeneration.PrimaryKeyConstraintsKey );
		d.setObjectForKey( NO, EOSchemaGeneration.ForeignKeyConstraintsKey );
		d.setObjectForKey( NO, EOSchemaGeneration.CreateDatabaseKey );
		d.setObjectForKey( NO, EOSchemaGeneration.DropDatabaseKey );

		return sf.schemaCreationScriptForEntities( aModel.entities(), d );
	}

	/**
	 * Terminates all outstanding database connections, and connects all models in the
	 * default EOModelGroup to the specified database.
	 */
	public static void reconnectToDatabase() {
		EOObjectStoreCoordinator osc = new EOObjectStoreCoordinator();
		EOObjectStoreCoordinator.setDefaultCoordinator( osc );
		EOEditingContext ec = ERXEC.newEditingContext( osc );

		for( EOModel model : EOModelGroup.defaultGroup().models() ) {
			EODatabaseContext dc = EODatabaseContext.registeredDatabaseContextForModel( model, ec );
			EOAdaptor ad = dc.adaptorContext().adaptor();

			for( EOAdaptorContext a : (NSArray<EOAdaptorContext>)ad.contexts() ) {
				for( EOAdaptorChannel c : (NSArray<EOAdaptorChannel>)a.channels() ) {
					c.closeChannel();
				}
			}

			NSMutableDictionary<String, Object> connDict = new NSMutableDictionary<String, Object>( ad.connectionDictionary() );
			connDict.addEntriesFromDictionary( SWSettings.connectionDictionary() );
			ad.setConnectionDictionary( connDict );
			ad.assertConnectionDictionaryIsValid();
		}
	}
}