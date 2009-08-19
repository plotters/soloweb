package is.us.soloweb.util;

/**
 * Java properties settable in SoloWeb.
 * 
 * @author Hugi Þórðarson
 */

public class SWProperties {

	/**
	 * All properties use this prefix.
	 */
	public static final String PROPERTY_PREFIX = "is.karlmenn.soloweb.";

	/**
	 * Indicates if we want to generate friendly URLs.
	 */
	public static final String GENERATE_FRIENDLY_URLS = "generateFriendlyURLs";
	public static final String GENERATE_FRIENDLY_URLS_PROPERTY = PROPERTY_PREFIX + GENERATE_FRIENDLY_URLS;

	/**
	 * Indicates if we want to dynamically clean HTML.
	 */
	public static final String USE_TIDY = "useTidy";
	public static final String USE_TIDY_PROPERTY = PROPERTY_PREFIX + USE_TIDY;

	/**
	 * Indicates if we want to use Gzip to compress the response.
	 */
	public static final String USE_GZIP = "useGzip";
	public static final String USE_GZIP_PROPERTY = PROPERTY_PREFIX + USE_GZIP;

	/**
	 * Indicates if we want to use Gzip to compress the response.
	 */
	public static final String USE_MACROS = "useMacros";
	public static final String USE_MACROS_PROPERTY = PROPERTY_PREFIX + USE_MACROS;

	/**
	 * Indicates if we want to use Gzip to compress the response.
	 */
	public static final String USE_DYNAMIC_TEMPLATES = "useDynamicTemplates";
	public static final String USE_DYNAMIC_TEMPLATES_PROPERTY = PROPERTY_PREFIX + USE_DYNAMIC_TEMPLATES;

	/**
	 * Indicates if we want to log hits.
	 */
	public static final String LOG_HITS = "logHits";
	public static final String LOG_HITS_PROPERTY = PROPERTY_PREFIX + LOG_HITS;

	/**
	 * Location of the properties file.
	 */
	public static final String SETTINGS_LOCATION = "settingsFileLocation";
	public static final String SETTINGS_LOCATION_PROPERTY = PROPERTY_PREFIX + SETTINGS_LOCATION;
}