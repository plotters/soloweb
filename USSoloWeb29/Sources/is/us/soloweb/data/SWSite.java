package is.us.soloweb.data;

import is.us.soloweb.data.auto._SWSite;
import is.us.soloweb.interfaces.*;
import is.us.soloweb.util.SWC;
import is.us.util.*;
import is.us.wo.util.USC;

import java.util.Locale;

import org.slf4j.*;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * An SWSite represents a site, and contains a tree of pages
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.3
 */

public class SWSite extends _SWSite implements SWCustomInfo, SWInspectable {

	private Locale _locale = null;
	private static final Logger logger = LoggerFactory.getLogger( SWSite.class );

	/**
	 * All sites in the database
	 */
	public static NSArray<SWSite> allSites( EOEditingContext ec ) {
		return SWSite.fetchAllSWSites( ec );
	}

	/**
	 * @return an array containing all domains this site handles.
	 */
	public NSArray<String> domains() {
		NSMutableArray<String> list = new NSMutableArray<String>();

		if( !USStringUtilities.stringHasValue( qual() ) ) {
			return NSArray.emptyArray();
		}

		for( String next : qual().split( USC.LF ) ) {
			String domain = next.trim();
			if( domain.length() > 2 ) {
				domain = next.substring( 1, domain.length() - 1 );
				list.add( domain );
			}
		}

		return list;
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

	/**
	 * @return The site's locale.
	 */
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

	/**
	 * @return Name of the site's locale in english.
	 */
	public String englishLanguageName() {
		if( locale() == null )
			return null;

		return locale().getDisplayName( Locale.ENGLISH );
	}

	/**
	 * Overridden to nullify the locale.
	 */
	@Override
	public void setLanguage( String value ) {
		super.setLanguage( value );
		_locale = null;
	}
}