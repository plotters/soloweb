package is.us.soloweb.settings;

import is.us.soloweb.*;
import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.util.SWDictionary;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * The settings management component.
 *
 * @author Hugi Þórðarson
 */

public class SWSettingsPanel extends SWAdminComponent {

	/**
	 * Tab currently being iterated over.
	 */
	public String currentTab;

	/**
	 * The currently selected tab.
	 */
	public String selectedTab = SWLoc.string( "settingsTabGeneral", session() );

	public SWSettingsPanel( WOContext context ) {
		super( context );
	}

	/**
	 * @return A dictionary of available settings tabs.
	 */
	public NSDictionary<String, String> tabs() {
		NSMutableDictionary<String, String> activeSettingsTabs = new NSMutableDictionary<String, String>( SoloWeb.sw().activeSettingsTabs() );
		activeSettingsTabs.setObjectForKey( SWSettingsGeneral.class.getSimpleName(), SWLoc.string( "settingsTabGeneral", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsDatabase.class.getSimpleName(), SWLoc.string( "settingsTabDatabase", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsAction.class.getSimpleName(), SWLoc.string( "settingsTabAdministration", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsAccessControl.class.getSimpleName(), SWLoc.string( "settingsTabAccessControls", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsStatistics.class.getSimpleName(), SWLoc.string( "settingsTabStatistics", session() ) );
		return activeSettingsTabs;
	}

	/**
	 * @return SoloWeb's settings.
	 */
	public SWDictionary<String, Object> settings() {
		return SWSettings.allSettings();
	}

	/**
	 * Saves changes made to settings
	 */
	public WOActionResults save() {
		settings().write();
		SWSettings.init();
		return context().page();
	}

	/**
	 * @return The name of the currently selected component for view in settings. 
	 */
	public String selectedComponent() {
		return tabs().objectForKey( selectedTab );
	}

	/**
	 * Selects the current setting. 
	 */
	public WOActionResults selectSetting() {
		selectedTab = currentTab;
		return null;
	}
}