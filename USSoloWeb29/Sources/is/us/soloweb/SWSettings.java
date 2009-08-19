package is.us.soloweb;

import is.us.soloweb.util.*;
import is.us.util.*;

import java.io.File;

import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSKeyValueCoding;

/**
 * SWSettings allows the programmer to create persistent settings and access them in a simple fashion
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.7
 */

public class SWSettings extends Object implements NSKeyValueCoding {

	private static SWDictionary settingsDictionary;

	/**
	 * Constants.
	 */
	private static final String DEFAULT_USERNAME_AND_PASSWORD = "admin";

	/**
	 * Settings available.
	 */
	public static final String SESSION_TIME_OUT = "sessionTimeOut";
	public static final String ENABLE_PRIVILEGES = "enablePrivileges";
	public static final String NO_PAGE_FOUND_ERROR_PAGE_LINKING_NAME = "noPageFoundErrorPageLinkingName";
	public static final String INDEX_LOCATION_ON_DISK = "indexLocationOndisk";
	public static final String DEFAULT_MAIL_SERVER = "defaultMailServer";
	public static final String WEBMASTER_EMAIL = "webmasterEmail";
	public static final String ADAPTOR_NAME = "adaptorName";
	public static final String ALL_USER_GROUP_ID = "allUserGroupID";
	public static final String RSS_PAGE = "rssPage";
	public static final String RSS_DOMAIN = "rssDomain";
	public static final String DEFAULT_PASSWORD = "defaultPassword";
	public static final String DEFAULT_USERNAME = "defaultUsername";
	public static final String DOCUMENT_LOCATION_ON_DISK = "documentLocationOnDisk";
	public static final String CONN_DICT = "connDict";
	public static final String ONLY_SHOW_GROUP_PRIVILEGES = "onlyShowGroupPrivileges";

	/**
	 * Initializes SWSettings
	 */
	public static void init() {
		if( !USStringUtilities.stringHasValue( storageLocation() ) ) {
			throw new Error( USStringUtilities.stringWithFormat( "No settings file specified. Make sure the property {} is set", SWProperties.SETTINGS_LOCATION_PROPERTY ) );
		}

		setSettingsDictionary( new SWDictionary( new File( storageLocation() ) ) );
	}

	/**
	 * Sets the dictionary of SWSettings to the specified dictionary
	 */
	public static void setSettingsDictionary( SWDictionary newDict ) {
		settingsDictionary = newDict;
	}

	/**
	 * Returns the entire settingsDictionary
	 */
	public static SWDictionary allSettings() {
		return settingsDictionary;
	}

	/**
	 * Returns the specified setting
	 */
	public static Object settingForKey( String aKey ) {
		return settingsDictionary.valueForKey( aKey );
	}

	/**
	 * Returns the specified setting
	 */
	public static String stringForKey( String aKey ) {
		return (String)settingsDictionary.valueForKey( aKey );
	}

	/**
	 * Returns the specified setting, returning the default value if no setting is found
	 */
	public static Object settingForKeyWithDefaultValue( String aKey, Object defaultValue ) {
		Object obj = settingsDictionary.valueForKey( aKey );

		if( obj == null )
			return defaultValue;

		return obj;
	}

	/**
	 * Sets the specified setting value
	 */
	public static void takeSettingForKey( Object myValue, String myKey ) {
		settingsDictionary.takeValueForKey( myValue, myKey );
	}

	/**
	 * Returns the specified setting
	 */
	public Object valueForKey( String aKey ) {
		return settingsDictionary.valueForKey( aKey );
	}

	/**
	 * Sets the specified setting to the specified value
	 */
	public void takeValueForKey( Object myValue, String myKey ) {
		settingsDictionary.takeValueForKey( myValue, myKey );
	}

	public static boolean booleanForKey( String key ) {
		return USUtilities.booleanFromObject( settingForKey( key ) );
	}

	public static Integer integerForKey( String key ) {
		return USUtilities.integerFromObject( settingForKey( key ) );
	}

	/**
	 * Returns the location of the settings file
	 */
	private static String storageLocation() {
		return System.getProperty( SWProperties.SETTINGS_LOCATION_PROPERTY );
	}

	/**
	 * Location of Lucene index on disk.
	 */
	public static String indexLocationOnDisk() {
		String location = (String)SWSettings.settingForKey( SWSettings.INDEX_LOCATION_ON_DISK );
		if( location == null )
			location = SWSettings.INDEX_LOCATION_ON_DISK;
		return location;
	}

	/**
	 * Indicates if a settings file has been created
	 */
	public static boolean hasSettingsFile() {
		return settingsDictionary.hasFile();
	}

	/**
	 * Indicates if access privileges are enabled for this SoloWeb system. 
	 */
	public static boolean privilegesEnabled() {
		return booleanForKey( ENABLE_PRIVILEGES );
	}

	/**
	 * Indicates if we want to compress the response using GZip.
	 * Will always return false if the requesting user agent does not support Gzip.
	 */
	public static boolean useGzip( WORequest r ) {
		boolean propertyValue = SWC.TRUE_STRING.equals( System.getProperty( SWProperties.USE_GZIP_PROPERTY ) );
		boolean disabled = SWC.FALSE_STRING.equals( r.stringFormValueForKey( SWProperties.USE_GZIP ) );
		boolean enabled = SWC.TRUE_STRING.equals( r.stringFormValueForKey( SWProperties.USE_GZIP ) );
		boolean result = (propertyValue || enabled) && !disabled;

		return result;
	}

	/**
	 * Indicates if we want to use HTML tidy to automatically clean up HTML-code.
	 */
	public static boolean useTidy( WORequest r ) {
		boolean propertyValue = SWC.TRUE_STRING.equals( System.getProperty( SWProperties.USE_TIDY_PROPERTY ) );
		boolean disabled = SWC.FALSE_STRING.equals( r.stringFormValueForKey( SWProperties.USE_TIDY ) );
		boolean enabled = SWC.TRUE_STRING.equals( r.stringFormValueForKey( SWProperties.USE_TIDY ) );
		boolean result = (propertyValue || enabled) && !disabled;

		return result;
	}

	/**
	 * Indicates if macro handling should be active.
	 */
	public static boolean useMacros( WORequest r ) {
		boolean propertyValue = SWC.TRUE_STRING.equals( System.getProperty( SWProperties.USE_MACROS_PROPERTY ) );
		boolean disabled = SWC.FALSE_STRING.equals( r.stringFormValueForKey( SWProperties.USE_MACROS ) );
		boolean enabled = SWC.TRUE_STRING.equals( r.stringFormValueForKey( SWProperties.USE_MACROS ) );
		boolean result = (propertyValue || enabled) && !disabled;

		return result;
	}

	/**
	 * Indicates if traffic should be logged.
	 */
	public static boolean logHits( WORequest r ) {
		boolean propertyValue = SWC.TRUE_STRING.equals( System.getProperty( SWProperties.LOG_HITS_PROPERTY ) );
		boolean disabled = SWC.FALSE_STRING.equals( r.stringFormValueForKey( SWProperties.LOG_HITS ) );
		boolean enabled = SWC.TRUE_STRING.equals( r.stringFormValueForKey( SWProperties.LOG_HITS ) );
		boolean result = (propertyValue || enabled) && !disabled;

		return result;
	}

	/**
	 * Indicates if SEO should be active.
	 */
	public static boolean generateFriendlyURLs( WORequest r ) {
		boolean urlFriendlyServer = SWC.TRUE_STRING.equals( System.getProperty( SWProperties.GENERATE_FRIENDLY_URLS_PROPERTY ) );
		boolean urlFriendlyDisabled = SWC.FALSE_STRING.equals( r.stringFormValueForKey( SWProperties.GENERATE_FRIENDLY_URLS ) );
		boolean urlFriendlyEnabled = SWC.TRUE_STRING.equals( r.stringFormValueForKey( SWProperties.GENERATE_FRIENDLY_URLS ) );
		boolean shouldGenerateFriendlyURLs = (urlFriendlyServer || urlFriendlyEnabled) && !urlFriendlyDisabled;

		return shouldGenerateFriendlyURLs;
	}

	public static boolean onlyAllowGrantingOfPrivilegesToGroups() {
		return booleanForKey( ONLY_SHOW_GROUP_PRIVILEGES );
	}

	/**
	 * The ID of the group that contains all users. 
	 */
	public static Integer allUsersGroupID() {
		return integerForKey( ALL_USER_GROUP_ID );
	}

	/**
	 * The default admin username for SoloWeb. 
	 */
	public static String defaultUsername() {
		return (String)SWSettings.settingForKeyWithDefaultValue( SWSettings.DEFAULT_USERNAME, DEFAULT_USERNAME_AND_PASSWORD );
	}

	/**
	 * The default admin password for SoloWeb. 
	 */
	public static String defaultPassword() {
		return (String)SWSettings.settingForKeyWithDefaultValue( SWSettings.DEFAULT_PASSWORD, DEFAULT_USERNAME_AND_PASSWORD );
	}

	/**
	 * The default admin password for SoloWeb. 
	 */
	public static String webmasterEmail() {
		return (String)SWSettings.settingForKeyWithDefaultValue( SWSettings.WEBMASTER_EMAIL, null );
	}
}