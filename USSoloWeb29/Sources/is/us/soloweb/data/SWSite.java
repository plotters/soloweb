package is.us.soloweb.data;

import is.us.soloweb.interfaces.*;
import is.us.soloweb.util.SWC;
import is.us.util.*;

import java.util.Locale;

import org.slf4j.*;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * An SWSite represents a site, and contains a tree of pages
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.3
 */

public class SWSite extends _SWSite implements SWCustomInfo, SWInspectable {

	private static final Logger logger = LoggerFactory.getLogger( SWSite.class );

	/**
	 * All sites in the database
	 */
	public static NSArray<SWSite> allSites( EOEditingContext ec ) {
		return SWSite.fetchAllSWSites( ec );
	}

	/**
	 * Sets the string containing the domain names this Site applies to
	 * Makes sure that the site name ends with the sitename delimiter.
	 *
	public void setQual( String value ) {
		value = USStringUtilities.replace( value, SWC.LF, SWC.SITENAME_DELIMITER );
		super.setQual( value );
	}
	*/

	/**
	 * An array with the languages selected for this site
	 */
	public NSArray<String> languageInArray() {
		if( language() != null )
			return NSArray.emptyArray();

		return new NSArray<String>( language() );
	}

	/**
	 * The site`s frontpage in an Array (for use with nested lists and such)
	 */
	public NSArray<SWPage> frontPageInArray() {
		return new NSArray<SWPage>( frontpage() );
	}

	/**
	 * Returns the site matching the host name specified.
	 */
	public static SWSite siteMatchingHostName( EOEditingContext ec, String hostName ) {
		logger.debug( "Fetching site for hostName: " + hostName );
		EOQualifier q = SWSite.QUAL.like( "*-" + hostName + "-*" );

		NSArray<SWSite> sites = null;

		try {
			sites = SWSite.fetchSWSites( ec, q, null );
		}
		catch( Exception e ) {
			logger.error( "Can't fetch sites", e );
		}

		if( !USArrayUtilities.arrayHasObjects( sites ) ) {
			return null;
		}

		return sites.objectAtIndex( 0 );
	}

	/**
	 * Creates a new site and a frontpage for it.
	 */
	public static SWSite create( EOEditingContext ec ) {
		SWSite site = new SWSite();
		SWPage frontPage = new SWPage();

		ec.insertObject( site );
		ec.insertObject( frontPage );

		site.setFrontpage( frontPage );

		frontPage.setSortNumber( SWC.FALSE_INTEGER );

		frontPage.setPublished( SWC.TRUE_INTEGER );
		frontPage.setAccessible( SWC.TRUE_INTEGER );

		return site;
	}

	public NSMutableDictionary _customInfo;

	public NSMutableDictionary customInfo() {
		if( _customInfo == null ) {
			_customInfo = USUtilities.dictionaryFromString( customInfoString() );
		}
		return _customInfo;
	}

	public void setCustomInfo( NSMutableDictionary d ) {
		_customInfo = d;
	}

	private Locale _locale = null;

	public Locale locale() {

		if( _locale == null && language() != null ) {

			try {
				_locale = new Locale( language() );
			}
			catch( Exception e ) {
				logger.error( "Couldn't construct locale for code: " + language(), e );
			}
		}

		return _locale;
	}

	public String englishLanguageName() {
		if( locale() == null )
			return null;

		return locale().getDisplayName( Locale.ENGLISH );
	}

	@Override
	public void setLanguage( String value ) {
		super.setLanguage( value );
		_locale = null;
	}
}