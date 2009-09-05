package is.us.soloweb;

import is.us.soloweb.admin.SWAdminErrorMessage;
import is.us.soloweb.client.SWNoPageFoundErrorComponent;
import is.us.soloweb.util.*;

import java.util.HashMap;

import org.slf4j.*;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

import er.extensions.appserver.ERXMessageEncoding;

/**
 * A singleton class to contain the setup of a SoloWeb system
 * 
 * @author Hugi Þórðarson
 */

public class SoloWeb {

	private static final Logger logger = LoggerFactory.getLogger( SoloWeb.class );
	private NSMutableArray<String> _pluginModels = new NSMutableArray<String>( new String[] { SWC.SOLOWEB_EOMODEL_NAME } );
	private NSTimestamp _startupTime;
	private int _numberOfServedPagesSinceStartup;
	private int _numberOfServedRequestsSinceStartup;
	private int _numberOfServedBytesSinceStartup;

	private NSMutableDictionary<String, String> _activeSettingsTabs;
	private NSMutableDictionary<String, String> _activePageEditingComponents;
	private NSMutableDictionary<String, String> _activeSiteEditingComponents;
	private NSMutableDictionary<String, String> _activeSystems;
	private NSMutableDictionary<String, String> _activeComponents;
	private NSMutableDictionary<String, String> _activeSystemsAndComponents;

	private NSMutableArray<SWSession> _solowebSessions = new NSMutableArray<SWSession>();

	private static SoloWeb _singleton;

	/**
	 * @return the SoloWeb instance.
	 */
	public static SoloWeb sw() {
		if( _singleton == null ) {
			_singleton = new SoloWeb();
			_singleton.initSoloWeb();
		}

		return _singleton;
	}

	/**
	 * It's a singleton.
	 */
	private SoloWeb() {}

	/**
	 * Types of objects this system can manage.
	 * 
	 * FIXME: This should be implemented in a more extensible way.
	 */
	public HashMap<String, String> localizedNames() {
		HashMap<String, String> h = new HashMap<String, String>();

		h.put( "SWDocument", "Skjal" );
		h.put( "SWDocumentFolder", "Mappa (skjöl)" );
		h.put( "SWComponent", "Efni á síðu" );
		h.put( "SWGroup", "Hópur" );
		h.put( "SWNewsFolder", "Mappa (fréttir)" );
		h.put( "SWNewsItem", "Frétt" );
		h.put( "SWPage", "Síða" );
		h.put( "SWSite", "Vefur" );
		h.put( "SWUser", "Notandi" );

		h.put( "SWFField", "Reitur (form)" );
		h.put( "SWFForm", "Form" );
		h.put( "SWFFormFolder", "Mappa (form)" );
		h.put( "SWFRegistration", "Skráning í form" );
		h.put( "SWFRegistrationField", "Reitur í skráningarformi" );

		return h;
	}

	/**
	 * Basic initialization for SoloWeb.
	 */
	private void initSoloWeb() {
		logger.info( "*** Welcome to SoloWeb, version " + SWC.SOLOWEB_VERSION );

		SWSettings.init();
		SWDBConnectionManager.init();
		SWTransactionManager.register();
		SWRequestManager.register();

		WOApplication app = WOApplication.application();
		app.setDefaultRequestHandler( WOApplication.application().requestHandlerForKey( app.directActionRequestHandlerKey() ) );
		app.registerRequestHandler( new SWDocumentRequestHandler(), SWDocumentRequestHandler.KEY );

		_startupTime = new NSTimestamp();

		_activeSystems = new NSMutableDictionary<String, String>( additionalSystems() );
		_activeComponents = new NSMutableDictionary<String, String>( additionalComponents() );
		_activePageEditingComponents = new NSMutableDictionary<String, String>( additionalPageEditingComponents() );
		_activeSiteEditingComponents = new NSMutableDictionary<String, String>( additionalSiteEditingComponents() );
		_activeSystemsAndComponents = new NSMutableDictionary<String, String>( additionalSystemsAndComponents() );
		_activeSettingsTabs = new NSMutableDictionary<String, String>( additionalSettingsTabs() );
		_numberOfServedPagesSinceStartup = 0;

		ERXMessageEncoding.setDefaultEncodingForAllLanguages( SWC.ENCODING_UTF_8 );

		try {
			SWPluginHandler.defaultInstance().loadRegisteredPlugins();
			app.setSMTPHost( SWSettings.defaultMailServer() );
			int sessionTimeOutInSeconds = new Integer( SWSettings.sessionTimeOut() ) * 60;
			app.setSessionTimeOut( sessionTimeOutInSeconds );
			logger.info( "*** SoloWeb ready at " + new NSTimestamp() );
		}
		catch( Exception e ) {
			logger.error( "An exception was thrown while initializing SoloWeb" );
			logger.error( e.toString() );
		}
	}

	/**
	 * Indicates if setup of this Soloweb system is complete.
	 */
	public boolean systemSetupNotFinished() {
		return !SWSettings.hasSettingsFile();
	}

	public String frameworkBundleName() {
		return SWC.FRAMEWORK_NAME;
	}

	public String solowebVersion() {
		return SWC.SOLOWEB_VERSION;
	}

	/**
	 * This method is intentionally undocumented.
	 */
	public WOResponse handleException( Throwable anException, WOContext aContext ) {

		if( anException instanceof NSForwardException ) {

			NSForwardException forwardException = (NSForwardException)anException;
			Throwable realThrowable = forwardException.originalException();

			if( realThrowable instanceof Error )
				Runtime.getRuntime().exit( 1 );
		}

		return SWAdminErrorMessage.handleException( anException, aContext );
	}

	public NSMutableDictionary<String, String> activeSettingsTabs() {
		return _activeSettingsTabs;
	}

	public NSTimestamp startupTime() {
		return _startupTime;
	}

	public NSMutableDictionary<String, String> activePageEditingComponents() {
		return _activePageEditingComponents;
	}

	public NSMutableDictionary<String, String> activeSiteEditingComponents() {
		return _activeSiteEditingComponents;
	}

	public NSMutableDictionary<String, String> activeSystems() {
		return _activeSystems;
	}

	public NSMutableDictionary<String, String> activeComponents() {
		return _activeComponents;
	}

	public NSMutableDictionary<String, String> activeSystemsAndComponents() {
		return _activeSystemsAndComponents;
	}

	public NSDictionary<String, String> additionalSystems() {
		return SWApplication.swapplication().additionalSystems();
	}

	public NSDictionary<String, String> additionalComponents() {
		return SWApplication.swapplication().additionalComponents();
	}

	public NSDictionary<String, String> additionalSystemsAndComponents() {
		return SWApplication.swapplication().additionalSystemsAndComponents();
	}

	public NSDictionary<String, String> additionalSettingsTabs() {
		return SWApplication.swapplication().additionalSettingsTabs();
	}

	public NSDictionary<String, String> additionalPageEditingComponents() {
		return SWApplication.swapplication().additionalPageEditingComponents();
	}

	public NSDictionary<String, String> additionalSiteEditingComponents() {
		return SWApplication.swapplication().additionalSiteEditingComponents();
	}

	public NSArray<String> additionalModels() {
		return SWApplication.swapplication().additionalModels();
	}

	public NSMutableArray<String> pluginModels() {
		return _pluginModels;
	}

	public NSArray<String> activeModels() {
		return pluginModels().arrayByAddingObjectsFromArray( additionalModels() );
	}

	public String noPageFoundErrorComponentName() {
		return SWNoPageFoundErrorComponent.class.getSimpleName();
	}

	public NSDictionary<String, String> solowebSettings() {
		return SWSettings.allSettings();
	}

	public NSMutableArray<SWSession> solowebSessions() {
		return _solowebSessions;
	}

	public int numberOfServedPagesSinceStartup() {
		return _numberOfServedPagesSinceStartup;
	}

	public int numberOfRequestsSinceStartup() {
		return _numberOfServedRequestsSinceStartup;
	}

	public int numberOfServedBytesSinceStartup() {
		return _numberOfServedBytesSinceStartup;
	}

	public void incrementNumberOfServedPagesSinceStartup() {
		_numberOfServedPagesSinceStartup++;
	}

	public void incrementNumberOfRequestsSinceStartup() {
		_numberOfServedRequestsSinceStartup++;
	}

	public void incrementNumberOfServedBytesSinceStartup( int bytes ) {
		_numberOfServedBytesSinceStartup += bytes;
	}
}