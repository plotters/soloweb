package is.us.soloweb;

import is.us.soloweb.admin.*;
import is.us.soloweb.client.*;
import is.us.soloweb.data.*;
import is.us.soloweb.search.SWContentSearch;
import is.us.soloweb.settings.SWSettingsPanel;
import is.us.soloweb.util.*;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.appserver.ERXDirectAction;
import er.extensions.eof.ERXEC;
import er.extensions.localization.ERXLocalizer;

/**
 * SWDirectAction serves as the primary direct action class for the SoloWeb application.
 * The most important method is dp, the method that takes a page name or ID and displays the corresponding page.
 * 
 * You can subclass SWDirectAction and override it's methods to customize it's behavior,
 * but that is not recommended, since it might break compatibility with future versions of SoloWeb.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.3
 */

public abstract class SWDirectAction extends ERXDirectAction {

	private EOEditingContext _ec;

	private static final String URL_COUNT = "count";
	private static final String URL_CATEGORY = "category";
	private static final String SW_PASSWORD_PROTECTED_PAGES = "swPasswordProtectedPages";

	public SWDirectAction( WORequest aRequest ) {
		super( aRequest );
	}

	/**
	 * The default editingContext
	 */
	protected EOEditingContext ec() {
		if( _ec == null ) {
			_ec = ERXEC.newEditingContext();
		}

		return _ec;
	}

	/**
	 * The default action is executed when the SoloWeb application is entered.
	 * Checks the request for what site was requested, and returns that page.
	 */
	public WOActionResults defaultAction() {
		SWSite requestedSite = requestedSite();

		if( requestedSite == null ) {
			requestedSite = randomSite();

			if( requestedSite == null ) {
				return handleError();
			}
		}

		return displayPageWithTemplate( requestedSite.frontpage(), SWStandardTemplate.class );
	}

	/**
	 * Retrieves the page specified by the arguments and displays it to the user.
	 */
	public WOActionResults dpAction() {
		SWPage thePage = SWPageUtilities.pageFromRequest( ec(), request() );
		return displayPageWithTemplate( thePage, SWStandardTemplate.class );
	}

	/**
	 * The "login" action takes you to SoloWeb's administration login screen.
	 */
	public WOActionResults loginAction() {
		if( SoloWeb.sw().systemSetupNotFinished() ) {
			((SWSession)session()).setIsLoggedIn( true );
			return pageWithName( SWSettingsPanel.class );
		}

		return pageWithName( SWLogin.class );
	}

	/**
	 * The search action performs a search of the SoloWeb site, and returns an SWSearchResults-page, displaying the results. You can pass in a branchID to narrow the search.
	 * Arguments:
	 * 
	 * <ul>
	 * <li> <b>searchString</b><br />The String to search for
	 * <li> <b>branchID</b><br />The branch to search (see docs for SWContentSearch for further information)
	 * </ul>
	 */
	public WOActionResults searchAction() {
		String indexLocationOndisk = (String)SWSettings.settingForKey( SWSettings.INDEX_LOCATION_ON_DISK );

		SWPage thePage = SWPageUtilities.pageFromRequest( ec(), request() );

		SWSearchResults nextPage = (SWSearchResults)displayPageWithTemplate( thePage, SWSearchResults.class );

		Integer branchID = null;

		if( branchID != null ) {
			branchID = Integer.parseInt( branchID() );
		}

		//		if( KMStringUtilities.stringHasValue( indexLocationOndisk ) ) {
		//nextPage.results = new SWLuceneSearch( ec(), searchString(), branchID ).search();
		//		}
		//		else {
		nextPage.results = new SWContentSearch( ec(), searchString(), branchID ).search();
		//		}

		return nextPage;
	}

	/**
	 * Returns a most unfriendly error message to the user.
	 * 
	 * TODO: Implement in a better way.
	 */
	private WOActionResults handleError() {
		String errorPageLinkingName = null;
		WOResponse errorResponse = null;
		SWSite requestedSite = requestedSite();

		if( requestedSite != null ) {
			errorPageLinkingName = requestedSite.noPageFoundErrorPageLinkingName();
		}

		if( errorPageLinkingName == null ) {
			errorPageLinkingName = (String)SWSettings.settingForKey( SWSettings.NO_PAGE_FOUND_ERROR_PAGE_LINKING_NAME );
		}

		if( errorPageLinkingName != null ) {
			SWPage thePage = SWPageUtilities.pageNamed( ec(), errorPageLinkingName );
			errorResponse = displayPageWithTemplate( thePage, SWStandardTemplate.class ).generateResponse();
		}
		else {
			String errorComponentName = SoloWeb.sw().noPageFoundErrorComponentName();
			errorResponse = pageWithName( errorComponentName ).generateResponse();
		}

		errorResponse.setStatus( 404 );

		return errorResponse;
	}

	/**
	 * When a user enters a password into the password field of a password protected page, this method checks if he has entered the correct password and if so, adds the page to his list of password pages he's allowed to see (an NSArray in his Session object).
	 * 
	 * TODO: Implement in a better way.
	 */
	public WOActionResults passwordAction() {
		SWPage aPage = SWPageUtilities.pageFromRequest( ec(), request() );

		String guess = request().stringFormValueForKey( SWC.URL_PASSWORD_STRING );
		String correctPassword = aPage.passwordProtectedParent().password();

		if( guess != null && guess.equals( correctPassword ) )
			((SWSession)session()).addObjectToArrayWithKey( aPage.pageID(), SW_PASSWORD_PROTECTED_PAGES );

		return performActionNamed( SWC.PAGE_DIRECT_ACTION_NAME );
	}

	/**
	 * Displays a page using the named template
	 */
	public WOActionResults displayPageWithTemplate( SWPage page, Class<? extends SWGenericTemplate> templateClass ) {

		if( page == null )
			return handleError();

		SWGenericTemplate template = pageWithName( templateClass );

		if( !page.isAccessible() && !isLoggedIn() )
			return SWAdminErrorMessage.errorWithMessageAndStatusCode( "Public access to this page is not allowed", context(), 403 );

		if( page.isPasswordProtected() && !sessionHasPasswordForPage( page ) && !isLoggedIn() )
			template = pageWithName( SWPasswordFieldComponent.class );

		if( USStringUtilities.stringHasValue( page.externalURL() ) )
			return USHTTPUtilities.redirectTemporary( page.externalURL() );

		template.setSelectedPage( page );

		// FIXME: see if we can change this more generically
		request().setUserInfoForKey( page.primaryLanguage(), "language" );
		ERXLocalizer.setAvailableLanguages( new NSArray<String>( page.locale().getLanguage() ) );

		SoloWeb.sw().incrementNumberOfServedPagesSinceStartup();

		return template;
	}

	/**
	 * Allow us to take a quick peak at what our headers contain.
	 */
	public WOActionResults lookAtHeadersAction() {
		WOResponse r = new WOResponse();
		r.setContent( request().headers().toString() );
		return r;
	}

	/**
	 * the site being requested in this request. 
	 */
	private SWSite requestedSite() {
		return SWSite.siteMatchingHostName( ec(), USHTTPUtilities.host( request() ) );
	}

	/**
	 * If no site is found matching the host name, this method is used.
	 */
	private SWSite randomSite() {
		NSArray<SWSite> a = EOUtilities.objectsForEntityNamed( ec(), SWSite.ENTITY_NAME );

		if( USArrayUtilities.arrayHasObjects( a ) )
			return a.objectAtIndex( 0 );

		return null;
	}

	/**
	 * Indicates if the given user is logged in to SoloWeb.
	 */
	private boolean isLoggedIn() {
		SWSession s = (SWSession)existingSession();
		return (s != null) && s.isLoggedIn();
	}

	/**
	 * Indicates if the current session has a password for the given page.
	 */
	private boolean sessionHasPasswordForPage( SWPage aPage ) {
		SWSession s = (SWSession)existingSession();
		return (s != null) && s.arrayWithKeyContainsObject( SW_PASSWORD_PROTECTED_PAGES, aPage.pageID() );
	}

	private String searchString() {
		return request().stringFormValueForKey( SWC.URL_SEARCH_STRING );
	}

	private String branchID() {
		return request().stringFormValueForKey( SWC.URL_BRANCH_ID );
	}

	/**
	 * FIXME: Implement full RSS 2.0 and ATOM feeds. 
	 */
	public WOActionResults rssAction() {
		SWRSSComponent nextPage = pageWithName( SWRSSComponent.class );

		String categoryIDString = request().stringFormValueForKey( URL_CATEGORY );
		String countString = request().stringFormValueForKey( URL_COUNT );
		String detailPageName = request().stringFormValueForKey( SWC.URL_PAGE_NAME );

		Integer categoryID = new Integer( categoryIDString );
		int count = new Integer( countString ).intValue();

		nextPage.setFolderID( categoryID );
		nextPage.setCount( count );
		nextPage.setDetailPageName( detailPageName );

		return nextPage;
	}

	/**
	 * FIXME: Remove once all data has been moved to new SWDocument structure.
	 */
	public WOActionResults oldImageAction() {
		String idString = request().stringFormValueForKey( "pictureID" );
		Integer pictureID = USUtilities.integerFromObject( idString );

		if( pictureID != null ) {

			SWDocument d = SWDocument.fetchSWDocument( ec(), SWDocument.PICTURE_ID_KEY, pictureID );

			if( d != null )
				return SWDocumentRequestHandler.responseForDocument( d );
		}

		return new WOResponse();
	}
}