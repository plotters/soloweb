package is.us.soloweb.util;

import is.us.soloweb.*;

import org.slf4j.*;

import com.webobjects.eoaccess.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 */

public class SWDBConnectionManager {

	final Logger logger = LoggerFactory.getLogger( SWDBConnectionManager.class );

	private static final String CONN_DICT = "connDict";
	private static final String HANDLE_MODEL_ADDED_NOTIFICATION_NAME = "handleModelAddedNotification";

	private static SWDBConnectionManager _singleton;

	/**
	 * It's a singleton.
	 */
	private SWDBConnectionManager() {}

	/**
	 * Creates our default transaction manager. 
	 */
	public static SWDBConnectionManager defaultConfigurator() {
		if( _singleton == null ) {
			_singleton = new SWDBConnectionManager();
		}

		return _singleton;
	}

	public static void init() {
		NSSelector<Void> modelAddedSelector = new NSSelector<Void>( HANDLE_MODEL_ADDED_NOTIFICATION_NAME, new Class[] { NSNotification.class } );
		NSNotificationCenter.defaultCenter().addObserver( defaultConfigurator(), modelAddedSelector, EOModelGroup.ModelAddedNotification, null );
	}

	/**
	 * This method has several main responsibilities.
	 */
	public void handleModelAddedNotification( NSNotification aNotication ) {
		EOModel theModel = (EOModel)aNotication.object();

		// Disabling project wonder's lovely DB configuration manager.
		theModel.setUserInfo( new NSDictionary<String, Object>() );

		logger.debug( "SoloWeb is handling EOModel: " + theModel.name() );

		if( SoloWeb.sw().activeModels().containsObject( theModel.name() ) ) {
			logger.debug( "SoloWeb will reconfigure the connection for EOModel:  " + theModel.name() );
			NSDictionary<String, Object> settingsConnectionDictionary = (NSDictionary<String, Object>)SWSettings.settingForKey( CONN_DICT );
			theModel.setConnectionDictionary( settingsConnectionDictionary );
		}
		else {
			logger.debug( "SoloWeb will NOT reconfigure the connection for EOModel:  " + theModel.name() );
		}
		/**
		 * FIXME: This is required to switch DB types, but functionality is not guaranteed.
		 */
		if( theModel.name().equals( SWC.SOLOWEB_EOMODEL_NAME ) ) {
			String databaseType = (String)SWSettings.settingForKey( "adaptorName" );
			logger.debug( "Database type is: " + databaseType );

			EOEntity orginalTypes = theModel.entityNamed( "EOPrototypes" );
			EOEntity newTypes = null;

			if( "FrontBase".equals( databaseType ) ) {
				newTypes = theModel.entityNamed( "EOFrontBasePrototypes" );
			}
			if( "Postgresql".equals( databaseType ) ) {
				newTypes = theModel.entityNamed( "EOPostgresqlPrototypes" );
			}
			if( "MSSQL2000".equals( databaseType ) ) {
				newTypes = theModel.entityNamed( "EOMSSQL2000Prototypes" );
			}
			if( "Oracle".equals( databaseType ) ) {
				newTypes = theModel.entityNamed( "EOOraclePrototypes" );
			}

			for( int i = 0; i < orginalTypes.attributes().count(); i++ ) {
				EOAttribute originalType = orginalTypes.attributes().objectAtIndex( i );
				String prototypesName = originalType.name();
				EOAttribute newType = newTypes.attributeNamed( prototypesName );

				if( newType != null ) {
					originalType.setDefinition( newType.definition() );
					originalType.setExternalType( newType.externalType() );
					originalType.setPrecision( newType.precision() );
					originalType.setReadFormat( newType.readFormat() );
					originalType.setScale( newType.scale() );
					originalType.setUserInfo( newType.userInfo() );
					originalType.setValueType( newType.valueType() );
					originalType.setWidth( newType.width() );
					originalType.setWriteFormat( newType.writeFormat() );
				}
			}
		}
	}
}