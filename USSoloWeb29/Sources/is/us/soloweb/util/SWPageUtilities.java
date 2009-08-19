package is.us.soloweb.util;

import is.us.soloweb.data.*;
import is.us.util.USStringUtilities;
import is.us.wo.util.USHTTPUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSArray;

/**
 * SWPageUtilities is the preferred way to fetch SWPage objects from the DB.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b5
 * @since 2.3
 */

public class SWPageUtilities {

	private static NSArray<String> PREFETCH_PATHS = new NSArray<String>( new String[] { SWPage.COMPONENTS_KEY, SWPage.SITE_KEY } );

	/**
	 * Fetches the specified page from the DB. If no page is found, null is returned.
	 *
	 * @param ec The editing context to fetch the page into
	 * @param pageID The pageID of the page to fetch
	 */
	public static SWPage pageWithID( EOEditingContext ec, Number pageID ) {
		return pageMatchingKeyAndValue( ec, SWPage.PAGE_ID_KEY, pageID );
	}

	/**
	 * Fetches the named page from the DB. If no page is found, null is returned.
	 *
	 * @param ec The editing context to fetch the page into
	 * @param pageName The linking name of the page to fetch
	 */
	public static SWPage pageNamed( EOEditingContext ec, String pageName ) {
		return pageMatchingKeyAndValue( ec, SWPage.SYMBOL_KEY, pageName );
	}

	/**
	 * Fetches the named page from the DB. If no page is found, null is returned.
	 *
	 * @param ec The editing context to fetch the page into
	 * @param aName The linking name of the page to fetch
	 */
	private static SWPage pageWithNameAndHost( EOEditingContext ec, String aName, String host ) {

		if( aName.endsWith( SWC.FORWARD_SLASH ) )
			aName = aName.substring( 0, aName.length() - 1 );

		EOQualifier q = new EOKeyValueQualifier( SWPage.SYMBOL_KEY, EOQualifier.QualifierOperatorEqual, aName );
		EOFetchSpecification fs = new EOFetchSpecification( SWPage.ENTITY_NAME, q, null );
		fs.setPrefetchingRelationshipKeyPaths( PREFETCH_PATHS );
		NSArray<SWPage> fetchedPages = ec.objectsWithFetchSpecification( fs );

		if( fetchedPages.count() == 0 ) {
			return null;
		}

		// Account for multiple linking names in the DB and match with the domain name.
		if( fetchedPages.count() > 1 ) {
			Enumeration<SWPage> e = fetchedPages.objectEnumerator();

			while( e.hasMoreElements() ) {
				SWPage p = e.nextElement();
				SWSite site = p.siteForThisPage();

				if( site != null ) {
					String currentHost = site.qual();
					if( USStringUtilities.stringHasValue( currentHost ) ) {
						if( currentHost.indexOf( host ) > -1 ) {
							return p;
						}
					}
				}
			}
		}

		return fetchedPages.objectAtIndex( 0 );
	}

	/**
	 * Fetches the page matching the specified criteria from the DB. If no page is found, null is returned.
	 *
	 * @param ec The editing context to fetch the page into
	 * @param aName The linking name of the page to fetch
	 */
	private static SWPage pageMatchingKeyAndValue( EOEditingContext ec, String aKey, Object aValue ) {
		EOQualifier q = new EOKeyValueQualifier( aKey, EOQualifier.QualifierOperatorEqual, aValue );
		EOFetchSpecification fs = new EOFetchSpecification( SWPage.ENTITY_NAME, q, null );
		fs.setPrefetchingRelationshipKeyPaths( PREFETCH_PATHS );
		fs.setFetchLimit( 1 );
		return (SWPage)ec.objectsWithFetchSpecification( fs ).lastObject();
	}

	/**
	 * TODO: Shouldn't we be checking the host name as well.
	 * TODO: If no host is specified, return the first available site.
	 * TODO: Review and clean up
	 */
	public static SWPage pageFromRequest( EOEditingContext ec, WORequest request ) {

		String pageID = request.stringFormValueForKey( SWC.URL_PAGE_ID );

		if( pageID != null ) {
			return pageWithID( ec, new Integer( pageID ) );
		}

		String pageName = request.stringFormValueForKey( SWC.URL_PAGE_NAME );

		if( pageName != null ) {
			String host = USHTTPUtilities.host( request );
			return pageWithNameAndHost( ec, pageName, host );
		}

		String hostNameFromURL = request.stringFormValueForKey( SWC.URL_HOST_NAME );

		if( hostNameFromURL != null ) {
			SWSite s = SWSite.siteMatchingHostName( ec, hostNameFromURL );

			if( s != null ) {
				return s.frontpage();
			}
		}

		if( pageName != null ) {
			String host = USHTTPUtilities.host( request );
			return pageWithNameAndHost( ec, pageName, host );
		}

		String redirectHeader = USHTTPUtilities.redirectURL( request );

		if( redirectHeader != null ) {
			if( redirectHeader.startsWith( SWC.FORWARD_SLASH ) ) {
				redirectHeader = redirectHeader.substring( 1, redirectHeader.length() );
			}

			return SWPageUtilities.pageMatchingKeyAndValue( ec, SWPage.SYMBOL_KEY, redirectHeader );
		}

		return null;
	}
}