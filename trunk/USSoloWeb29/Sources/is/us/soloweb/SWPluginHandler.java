package is.us.soloweb;

import com.webobjects.foundation.*;

/**
 * SWPluginHandler handles the loading of plugins, management of EOModel connections etc. Documentation forthcoming.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b3
 * @since 2.4
 */

public class SWPluginHandler {

	private static NSMutableArray<SWPlugin> _registeredPlugins = new NSMutableArray<SWPlugin>();
	private static SWPluginHandler _defaultInstance = new SWPluginHandler();

	private SWPluginHandler() {}

	public static SWPluginHandler defaultInstance() {
		return _defaultInstance;
	}

	public static NSMutableArray<SWPlugin> registeredPlugins() {
		return _registeredPlugins;
	}

	public void registerPlugin( SWPlugin aPlugin ) {
		registeredPlugins().addObject( aPlugin );
	}

	public void loadRegisteredPlugins() {
		for( SWPlugin p : registeredPlugins() ) {
			loadPlugin( p );
		}
	}

	private void loadPlugin( SWPlugin aPlugin ) {

		if( aPlugin.componentAdminComponent() != null )
			SoloWeb.sw().activeComponents().setObjectForKey( aPlugin.componentAdminComponent(), aPlugin.name() );

		if( aPlugin.mainAdminComponent() != null )
			SoloWeb.sw().activeSystems().setObjectForKey( aPlugin.mainAdminComponent(), aPlugin.name() );

		if( aPlugin.settingsComponent() != null )
			SoloWeb.sw().activeSettingsTabs().setObjectForKey( aPlugin.settingsComponent(), aPlugin.name() );

		NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();

		for( String currentComponentName : aPlugin.components() ) {
			d.setObjectForKey( aPlugin.name(), currentComponentName );
		}

		SoloWeb.sw().activeSystemsAndComponents().addEntriesFromDictionary( d );

		for( String currentModelName : aPlugin.models() ) {
			SoloWeb.sw().pluginModels().addObject( currentModelName );
		}
	}
}