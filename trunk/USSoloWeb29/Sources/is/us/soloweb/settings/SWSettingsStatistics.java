package is.us.soloweb.settings;

import is.us.soloweb.SWSession;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Hugi Þórðarson
 */

public class SWSettingsStatistics extends SWSettingsPanel {

	public SWSession currentSession;

	public SWSettingsStatistics( WOContext context ) {
		super( context );
	}

	public long totalMemory() {
		Long l = Runtime.getRuntime().totalMemory();
		return l / 1024 / 1024;
	}

	public long freeMemory() {
		Long l = Runtime.getRuntime().freeMemory();
		return l / 1024 / 1024;
	}

	public NSTimestamp now() {
		return new NSTimestamp();
	}
}