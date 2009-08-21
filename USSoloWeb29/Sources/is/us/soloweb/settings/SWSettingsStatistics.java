package is.us.soloweb.settings;

import is.us.soloweb.SWSession;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 */

public class SWSettingsStatistics extends SWSettingsPanel {

	public SWSession currentSession;

	public SWSettingsStatistics( WOContext context ) {
		super( context );
	}

	public int totalMemory() {
		Number n = (Number)WOApplication.application().statisticsStore().memoryUsage().valueForKey( "Total Memory" );
		int i = n.intValue();
		return i / 1024 / 1024;
	}

	public int freeMemory() {
		Number n = (Number)WOApplication.application().statisticsStore().memoryUsage().valueForKey( "Free Memory" );
		int i = n.intValue();
		return i / 1024 / 1024;
	}

	public NSNumberFormatter europeanNumberFormatter() {
		NSNumberFormatter numberFormatter = new NSNumberFormatter( "0.00" );
		numberFormatter.setHasThousandSeparators( true );
		numberFormatter.setThousandSeparator( "." );
		numberFormatter.setDecimalSeparator( "," );
		return numberFormatter;
	}

	public NSTimestamp now() {
		return new NSTimestamp();
	}
}