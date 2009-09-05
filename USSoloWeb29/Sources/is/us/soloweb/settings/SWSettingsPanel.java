package is.us.soloweb.settings;

import is.us.soloweb.*;
import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.util.SWDictionary;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * The Settings management component.
 *
 * @author Hugi Þórðarson
 * @version 2.5
 * @since 2.5
 */

public class SWSettingsPanel extends SWAdminComponent {

	/**
	 * The currently selected tab
	 */
	public String tabPanelSelection = SWLoc.string( "settingsTabGeneral", session() );

	/**
	 * The tabs to display in the settings component
	 */
	public NSArray<String> tabs = tabDictionary().allKeys();

	public String currentSettingName;

	public SWSettingsPanel( WOContext context ) {
		super( context );
	}

	public NSDictionary<String, String> tabDictionary() {
		NSMutableDictionary<String, String> activeSettingsTabs = new NSMutableDictionary<String, String>( SoloWeb.sw().activeSettingsTabs() );
		activeSettingsTabs.setObjectForKey( SWSettingsGeneral.class.getSimpleName(), SWLoc.string( "settingsTabGeneral", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsDatabase.class.getSimpleName(), SWLoc.string( "settingsTabDatabase", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsAction.class.getSimpleName(), SWLoc.string( "settingsTabAdministration", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsAccessControl.class.getSimpleName(), SWLoc.string( "settingsTabAccessControls", session() ) );
		activeSettingsTabs.setObjectForKey( SWSettingsStatistics.class.getSimpleName(), SWLoc.string( "settingsTabStatistics", session() ) );
		// TODO: Delete the associated component, once new functionality is proven.
		//		activeSettingsTabs.setObjectForKey( SWSettingsNews.class.getSimpleName(), SWLoc.string( "settingsTabNews", session() ) );
		//		activeSettingsTabs.setObjectForKey( SWSettingsLocalization.class.getSimpleName(), SWLoc.string( "settingsTabLocalization", session() ) );
		return activeSettingsTabs;
	}

	/**
	 * Returns all settings in the SWSettings file, as in SWSettings.allSettings()
	 */
	public SWDictionary selectedDictionary() {
		return SWSettings.allSettings();
	}

	/**
	 * Saves changes made to settings
	 */
	public WOActionResults save() {
		selectedDictionary().write();
		SWSettings.init();
		return context().page();
	}

	/**
	 * The name of the currently selected component for view in settings. 
	 */
	public String selectedSettingsComponent() {
		return tabDictionary().objectForKey( tabPanelSelection );
	}

	/**
	 * Selects the current setting. 
	 */
	public WOActionResults selectSetting() {
		tabPanelSelection = currentSettingName;
		return null;
	}
}