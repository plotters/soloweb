package is.us.soloweb.settings;

import is.us.soloweb.*;
import is.us.soloweb.util.SWSQLUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXEC;

/**
 * @author Hugi Þórðarson
 */

public class SWSettingsDatabase extends SWSettingsPanel {

	public String connectionsTabName = SWLoc.string( "dbsTabConnections", session() );
	public String switchTabName = SWLoc.string( "dbsTabSwitchAndConstruct", session() );
	public NSArray<String> dbTabs = new NSArray<String>( new String[] { connectionsTabName, switchTabName } );
	public String dbSelectedTab = connectionsTabName;

	/**
	* A list of all plugins registered with the SoloWeb system
	 */
	public NSMutableArray<SWPluginItem> plugins;

	/**
	* The plugin currently being iterated over in the list of plugins in the SQL-schema generation menu.
	 */
	public SWPluginItem currentPlugin;

	/**
	* The database name currently being iterated over in the list of databases ("Frontbase" or "Oracle")
	 */
	public String currentDatabase;

	public SWSettingsDatabase( WOContext context ) {
		super( context );
	}

	/**
	* Initializes the plugins array to a list of all plugins registered with the SoloWeb system and their EOModels.
	 */
	public NSArray<SWPluginItem> plugins() {
		if( plugins == null ) {

			NSMutableArray<SWPluginItem> anArray = new NSMutableArray<SWPluginItem>();

			SWPluginItem pi2 = new SWPluginItem();
			pi2.setName( "SoloWeb" );
			pi2.setVersion( SoloWeb.sw().productVersion() );
			pi2.setModels( new NSArray<String>( "SoloWeb" ) );
			anArray.addObject( pi2 );

			Enumeration<SWPlugin> e = SWPluginHandler.registeredPlugins().objectEnumerator();

			while( e.hasMoreElements() ) {
				SWPlugin aPlugin = e.nextElement();

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
		NSMutableDictionary<String, Object> cd = new NSMutableDictionary<String, Object>();
		cd.setObjectForKey( "", "URL" );
		SWSettings.takeSettingForKey( cd, SWSettings.CONN_DICT );
		return null;
	}

	/**
	* Invokes reconnect() and returns SWLoggedOut
	 */
	public WOActionResults switchConnection() {
		SWSQLUtilities.reconnectToDatabase();
		session().terminate();
		return pageWithName( "SWLoggedOut" );
	}

	/**
	* Creates the SQL string to execute, based on selections made in the SQL generation window
	 */
	public WOActionResults executeSQL() {

		SWSQLUtilities.reconnectToDatabase();

		Enumeration<SWPluginItem> b = plugins.objectEnumerator();
		SWPluginItem pi;

		while( b.hasMoreElements() ) {
			pi = b.nextElement();

			Enumeration<String> e = pi.models().objectEnumerator();

			String aModelName;
			EOModel aModel;
			String sqlString = null;

			while( e.hasMoreElements() ) {
				aModelName = e.nextElement();
				aModel = EOModelGroup.defaultGroup().modelNamed( aModelName );

				if( pi.dropSchema() && pi.constructSchema() )
					sqlString = SWSQLUtilities.sqlForModel( aModel, "YES" );
				else if( !pi.dropSchema() && pi.constructSchema() )
					sqlString = SWSQLUtilities.sqlForModel( aModel, "NO" );
				else if( pi.dropSchema() && !pi.constructSchema() )
					sqlString = SWSQLUtilities.sqlToDropTablesForModel( aModel );
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
		return SWSettings.connectionDictionary() != null;
	}
}