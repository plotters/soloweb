package is.us.soloweb.admin;

import is.us.soloweb.*;
import is.us.soloweb.data.*;
import is.us.soloweb.settings.SWSettingsPanel;
import is.us.soloweb.util.SWC;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.ajax.AjaxUtils;
import er.extensions.components.ERXComponent;

/**
 * The SoloWeb login window
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.3
 */

public class SWLogin extends ERXComponent {

	private static final int COOKIE_LIFETIME_IN_SECONDS = 2592000;
	private static final String COOKIE_SW_USERNAME = "SW_USER_NAME";
	private static final String COOKIE_SW_LANGUAGE = "SW_LANGUAGE";

	/**
	 * The username entered
	 */
	private String _username;

	/**
	 * The password entered
	 */
	public String _password;

	/**
	 * The error string displayed if authentication fails
	 */
	private String _errorMessage;

	/**
	 * The language currently displayed in the language pop-up menu
	 */
	public String currentLanguage;
	public NSArray<String> availableLanguages = SWC.AVAILABLE_LANGUAGES;
	private EOEditingContext ec = session().defaultEditingContext();

	public SWLogin( WOContext context ) {
		super( context );
	}

	/**
	 * Executes a login attempt
	 */
	public WOActionResults login() {

		if( SWSettings.defaultUsername().equals( username() ) && SWSettings.defaultPassword().equals( password() ) ) {
			((SWSession)session()).setIsLoggedIn( true );
			return pageWithName( SWSettingsPanel.class );
		}

		if( username() == null ) {
			return error( "Vinsamlegast tilgreinið notandanafn." );
		}

		SWUser user = SWUser.fetchSWUser( ec, SWUser.USERNAME.eq( username() ) );

		if( user == null ) {
			return error( "Enginn notandi fannst með þetta notandanafn." );
		}

		if( !USUtilities.eq( password(), user.password() ) ) {
			return error( "Rangt aðgangsorð." );
		}

		((SWSession)session()).setSolowebUser( user );
		((SWSession)session()).setIsLoggedIn( true );

		if( user.defaultSite() != null ) {
			((SWSession)session()).setSelectedSite( user.defaultSite() );
		}
		else {
			NSArray<SWSite> sites = user.sites();

			if( USArrayUtilities.arrayHasObjects( sites ) ) {
				((SWSession)session()).setSelectedSite( sites.objectAtIndex( 0 ) );
			}
		}

		SWStartPage nextPage = pageWithName( SWStartPage.class );
		nextPage.context().response().addCookie( usernameCookie() );
		nextPage.context().response().addCookie( languageCookie() );
		return nextPage;
	}

	/**
	 * Check for a cookie with the username
	 */
	public String username() {

		if( _username == null ) {
			String cookieString = context().request().cookieValueForKey( SWC.COOKIE_SW_USER_ID );

			if( cookieString != null ) {
				_username = cookieString;
			}
		}

		return _username;
	}

	public void setUsername( String s ) {
		_username = s;
	}

	public String password() {
		return _password;
	}

	public void setPassword( String newValue ) {
		_password = newValue;
	}

	public void setErrorMessage( String errorMessage ) {
		_errorMessage = errorMessage;
	}

	public String errorMessage() {
		return _errorMessage;
	}

	/**
	 * Creates and returns the username cookie
	 */
	private WOCookie usernameCookie() {
		return new WOCookie( COOKIE_SW_USERNAME, username(), "/", "." + USHTTPUtilities.domain( context().request() ), COOKIE_LIFETIME_IN_SECONDS, false );
	}

	/**
	 * Creates and returns the language cookie
	 */
	private WOCookie languageCookie() {
		return new WOCookie( COOKIE_SW_LANGUAGE, selectedLanguage(), "/", "." + USHTTPUtilities.domain( context().request() ), COOKIE_LIFETIME_IN_SECONDS, false );
	}

	/**
	 * A convenience method to fetch and return return the session's selected language
	 */
	public String selectedLanguage() {
		return session().languages().lastObject();
	}

	/**
	 * Sets the session's selected language
	 */
	public void setSelectedLanguage( String newSelectedLanguage ) {
		session().setLanguages( new NSArray<String>( new String[] { newSelectedLanguage, SWC.DEFAULT_LANGUAGE } ) );
	}

	/**
	 * Adding the required stylesheets.
	 */
	public void appendToResponse( WOResponse r, WOContext c ) {
		super.appendToResponse( r, c );
		AjaxUtils.addStylesheetResourceInHead( context(), r, SWC.FRAMEWORK_NAME, SWC.MAIN_CSS_FILE_NAME );
		AjaxUtils.addScriptResourceInHead( context(), r, SWC.FRAMEWORK_NAME, SWC.MAIN_JAVASCRIPT_NAME );
	}

	/**
	 * For returning an error message to the user. 
	 */
	public WOActionResults error( String message ) {
		setErrorMessage( message );
		return context().page();
	}
}