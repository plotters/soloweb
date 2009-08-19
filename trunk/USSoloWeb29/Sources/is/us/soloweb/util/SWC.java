package is.us.soloweb.util;

import com.webobjects.foundation.*;

/**
 * Various constants in SoloWeb.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 */

public class SWC {

	public static final String LANGUAGE_IELANDIC = "Icelandic";
	public static final String LANGUAGE_ENGLISH = "English";
	public static final NSArray<String> AVAILABLE_LANGUAGES = new NSArray<String>( new String[] { LANGUAGE_IELANDIC, LANGUAGE_ENGLISH } );
	public static final String DEFAULT_LANGUAGE = LANGUAGE_IELANDIC;

	public static final String CSS_UNPUBLISHED = "unpublished";
	public static final String CSS_INACCESSIBLE = "inaccessible";
	public static final String CSS_PUBLISHED = "published";

	public static final String CSS_ODD_ROW = "oddRow";
	public static final String CSS_EVEN_ROW = "evenRow";

	public static final String SOLOWEB_VERSION = "2.9.2b6";
	public static final String FRAMEWORK_NAME = "USSoloWeb29";
	public static final String STRINGS_FILE_NAME = "localizedStrings";

	public static final Integer TRUE_INTEGER = new Integer( 1 );
	public static final Integer FALSE_INTEGER = new Integer( 0 );

	public static final String TRUE_STRING = "true";
	public static final String FALSE_STRING = "false";

	public static final String SPACE = " ";
	public static final String QUOTE = "\"";
	public static final String LF = "\n";
	public static final String TAB = "\t";
	public static final String EMPTY_STRING = "";

	/**
	 * Parameters used in URLs in SoloWeb
	 */
	public static final String URL_PAGE_ID = "id";
	public static final String URL_PAGE_NAME = "name";
	public static final String URL_HOST_NAME = "host";
	public static final String URL_SEARCH_STRING = "searchString";
	public static final String URL_BRANCH_ID = "branchID";
	public static final String URL_PASSWORD_STRING = "pw";
	public static final String URL_LOOK = "look";
	public static final String URL_NEWS_DETAIL = "detail";

	public static final String ENCODING_UTF_8 = "UTF-8";
	public static final String ENCODING_ISO_8859_1 = "ISO-8859-1";

	public static final String PAGE_DIRECT_ACTION_NAME = "dp";

	/**
	 * The string that delimits site names.
	 */
	private static final String VERTICAL_TAB = String.valueOf( (char)13 );
	private static final String BACKSPACE = String.valueOf( (char)10 );
	public static final String SITENAME_DELIMITER = VERTICAL_TAB + BACKSPACE;

	public static final String MAIN_CSS_FILE_NAME = "soloweb.css";
	public static final String MAIN_JAVASCRIPT_NAME = "soloweb.js";

	public static final String PRIVILEGE_CAN_MANAGE_USERS = "canManageUsers";
	public static final String PRIVILEGE_CAN_MANAGE_CONTENT = "canManageContent";
	public static final String PRIVILEGE_CAN_MANAGE_PAGE = "canManagePage";
	public static final String PRIVILEGE_CAN_DELETE_PAGE = "canDeletePage";
	public static final String PRIVILEGE_ALLOW_TO_SEE = "allowToSee";

	public static final String CURRENT_COMPONENT = "currentComponent";
	public static final String SELECTED_PAGE = "selectedPage";
	public static final String SW_USER_USERINFO_KEY = "blabalablabla";

	@SuppressWarnings( "deprecation" )
	public static NSTimestampFormatter TS_FORMATTER_WITH_TIME = new NSTimestampFormatter( "%d.%m.%Y, %H:%M" );
	public static final String FORWARD_SLASH = "/";
	public static final String LOCALIZED_STRING_NOT_FOUND = "!!LOCALIZED_STRING_NOT_FOUND!!";
	public static final String COOKIE_SW_USER_ID = "SW_USER_ID";
	static final String DOT = ".";
	public static final String SOLOWEB_EOMODEL_NAME = "SoloWeb";
}