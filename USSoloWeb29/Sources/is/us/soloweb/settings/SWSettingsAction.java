package is.us.soloweb.settings;

import com.webobjects.appserver.*;

/**
 * Various actions that can be performed in the administrative interface.
 * 
 * @author Hugi Þórðarson
 */

public class SWSettingsAction extends SWSettingsPanel {

	public SWSettingsAction( WOContext context ) {
		super( context );
	}

	/**
	 * Resets all component definitions. 
	 */
	public WOActionResults flushComponentCache() {
		WOApplication.application()._removeComponentDefinitionCacheContents();
		return null;
	}
}