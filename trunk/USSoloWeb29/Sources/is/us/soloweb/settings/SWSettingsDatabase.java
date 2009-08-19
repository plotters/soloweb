package is.us.soloweb.settings;

import is.us.soloweb.*;
import is.us.soloweb.util.*;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXEC;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * 
 * FIXME: Refactor and review
 */

public class SWSettingsDatabase extends SWSettingsPanel {

	public String connectionsTabName = SWLoc.string( "dbsTabConnections", session() );
	public String switchTabName = SWLoc.string( "dbsTabSwitchAndConstruct", session() );
	public NSArray<String> tabs = new NSArray<String>( new String[] { connectionsTabName, switchTabName } );
	public String selectedTab = connectionsTabName;

	/**
	* A list of all plugins registered with the SoloWeb system
	 */
	public NSMutableArray<SWPlugin> plugins;

	/**
	* The plugin currently being iterated over in the list of plugins in the SQL-schema generation menu.
	 */
	public SWPluginItem currentPlugin;

	/**
	* The database name currently being iterated over in the list of databases ("Frontbase" or "Oracle")
	 */
	public String currentDatabase;

	/**
	* The selected plugins to construct DB schema for
	 */
	public NSMutableArray pluginsToConstruct = new NSMutableArray();

	/**
	    * The selected plugins to drop DB schema for
	 */
	public NSMutableArray pluginsToDrop = new NSMutableArray();

	public SWSettingsDatabase( WOContext context ) {
		super( context );
	}

	/**
	* Initializes the plugins array to a list of all plugins registered with the SoloWeb system and their EOModels.
	 */
	public NSArray plugins() {
		if( plugins == null ) {

			NSMutableArray anArray = new NSMutableArray();

			SWPluginItem pi2 = new SWPluginItem();
			pi2.setName( "SoloWeb" );
			pi2.setVersion( SWC.SOLOWEB_VERSION );
			pi2.setModels( new NSArray( "SoloWeb" ) );
			anArray.addObject( pi2 );

			Enumeration e = SWPluginHandler.registeredPlugins().objectEnumerator();
			SWPlugin aPlugin;

			while( e.hasMoreElements() ) {
				aPlugin = (SWPlugin)e.nextElement();
				if( aPlugin.models() != null ) {
					SWPluginItem pi = new SWPluginItem();
					pi.setName( aPlugin.name() );
					pi.setModels( aPlugin.models() );
					pi.setVersion( aPlugin.version() );
					anArray.addObject( pi );
				}
			}
			plugins = anArray;
		}

		return plugins;
	}

	/**
	* A list of supported databases. Legacy from WO 4.5
	 */
	public NSArray<String> databases() {
		return new NSArray<String>( new String[] { "FrontBase", "MSSQL2000", "Oracle", "Postgresql" } );
	}

	/**
	* Constructs a connection dictionary for the selected database type and inserts it into the settings
	 */
	public WOActionResults switchAdaptors() {
		NSMutableDictionary dict = new NSMutableDictionary();

		if( selectedDictionary().valueForKey( "adaptorName" ).equals( "FrontBase" ) ) {
			dict.setObjectForKey( "", "URL" );
		}
		else {
			dict.setObjectForKey( "", "userName" );
			dict.setObjectForKey( "", "password" );
			dict.setObjectForKey( "", "serverId" );
		}

		SWSettings.takeSettingForKey( dict, SWSettings.CONN_DICT );

		return null;
	}

	/**
	* Invokes reconnect() and returns SWLoggedOut
	 */
	public WOActionResults switchConnection() {
		SoloWeb.reconnectToDatabase();
		session().terminate();
		return pageWithName( "SWLoggedOut" );
	}

	/**
	* Creates the SQL string to execute, based on selections made in the SQL generation window
	 */
	public WOActionResults executeSQL() {

		SoloWeb.reconnectToDatabase();

		Enumeration b = plugins.objectEnumerator();
		SWPluginItem pi;

		while( b.hasMoreElements() ) {
			pi = (SWPluginItem)b.nextElement();

			Enumeration e = pi.models().objectEnumerator();

			String aModelName;
			EOModel aModel;
			String sqlString = null;

			while( e.hasMoreElements() ) {
				aModelName = (String)e.nextElement();
				aModel = EOModelGroup.defaultGroup().modelNamed( aModelName );

				if( pi.dropSchema() && pi.constructSchema() )
					sqlString = SWSQLCreationUtilities.sqlForModel( aModel, "YES" );
				else if( !pi.dropSchema() && pi.constructSchema() )
					sqlString = SWSQLCreationUtilities.sqlForModel( aModel, "NO" );
				else if( pi.dropSchema() && !pi.constructSchema() )
					sqlString = SWSQLCreationUtilities.sqlToDropTablesForModel( aModel );
				else if( !pi.dropSchema() && !pi.constructSchema() )
					sqlString = null;

				if( sqlString != null )
					executeSQL2( ERXEC.newEditingContext(), aModelName, sqlString );
			}
		}

		return switchConnection();
	}

	/**
	 * Executes the given SQL string, using the expression class from the given model and the
	 * DatabaseContext from the Model in the EC
	 *
	 * @param ec The Editing context to execute the SQL in
	 * @param modelName The model to base the database connection on
	 * @param sqlString The SQL to execute
	 */
	public void executeSQL2( EOEditingContext ec, String modelName, String sqlString ) {

		EODatabaseContext databaseContext;
		EODatabaseChannel databaseChannel;
		EOAdaptorChannel adaptorChannel;

		databaseContext = EOUtilities.databaseContextForModelNamed( ec, modelName );
		databaseChannel = databaseContext.availableChannel();
		adaptorChannel = databaseChannel.adaptorChannel();

		if( !adaptorChannel.isOpen() ) {
			adaptorChannel.openChannel();
		}
		databaseContext.lock();
		EOSQLExpressionFactory e = new EOSQLExpressionFactory( EOAdaptor.adaptorWithModel( EOModelGroup.defaultGroup().modelNamed( modelName ) ) );

		adaptorChannel.evaluateExpression( e.expressionForString( sqlString ) );
		databaseContext.unlock();
		adaptorChannel.closeChannel();
	}

	/**
	* Indicates if a connection dictionary has been created.
	 */
	public boolean connectionDictionary() {
		return SWSettings.settingForKey( SWSettings.CONN_DICT ) != null;
	}
}