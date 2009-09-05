package is.us.soloweb;

import com.webobjects.appserver.WOSession;

/**
 * A shorthand for simplifying localization of strings (see documentation for the "string"-method).
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.5
 */

public class SWLoc {

	/**
	 * We don't want any instances of this class.
	 */
	private SWLoc() {}

	/**
	 * Returns a localized string based on a key (the string's key in the localizedStrings-file) and
	 * the language selected in the given session.
	 */
	public static String string( String key, WOSession session ) {
		return ((SWSession)session).localizedStringForKey( key );
	}

	/**
	 * Returns a localized string based on a key (the string's key in the localizedStrings-file) and
	 * the language selected in the given session.
	 */
	public static String appString( String key, WOSession session ) {
		return ((SWSession)session).localizedApplicationStringForKey( key );
	}
}