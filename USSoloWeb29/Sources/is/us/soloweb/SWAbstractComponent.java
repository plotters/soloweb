package is.us.soloweb;

import is.us.soloweb.data.SWPage;
import is.us.soloweb.util.*;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

/**
 * Common functionality for all WOComponens in SoloWeb.
 * 
 * @author Hugi Þórðarson
 */

public abstract class SWAbstractComponent extends ERXComponent {

	private EOEditingContext _ec;

	/**
	 * The currently selected page
	 */
	private SWPage _selectedPage;

	private static final String ICELANDIC = "Icelandic";
	private static final String LANGUAGE = "language";

	/**
	 * Localization
	 */
	private static final String LOC_KEYPATH = "@ls";

	public SWAbstractComponent( WOContext context ) {
		super( context );
	}

	/**
	 * Returns the selected page.
	 */
	public SWPage selectedPage() {
		if( _selectedPage == null ) {
			_selectedPage = SWPageUtilities.pageFromRequest( ec(), context().request() );
		}

		return _selectedPage;
	}

	/**
	 * Sets the selected page.
	 */
	public void setSelectedPage( SWPage p ) {
		_selectedPage = p;
	}

	/**
	 * The editingContext
	 */
	protected EOEditingContext ec() {
		if( _ec == null ) {
			_ec = ERXEC.newEditingContext();
		}

		return _ec;
	}

	/**
	 * Overridden for localization support.
	 */
	public Object valueForKeyPath( String keypath ) {

		if( keypath.startsWith( LOC_KEYPATH ) )
			return localizedString( keypath.substring( 4, keypath.length() ) );

		return super.valueForKeyPath( keypath );
	}

	/**
	 * Overridden for localization support.
	 */
	public Object valueForKey( String keypath ) {

		if( keypath.startsWith( LOC_KEYPATH ) )
			return localizedString( keypath.substring( 4, keypath.length() ) );

		return super.valueForKey( keypath );
	}

	/**
	 * FIXME: Default language should be settable.
	 */
	private static final String defaultLanguage() {
		return ICELANDIC;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String localizedString( String key ) {
		String language = (String)context().request().userInfoForKey( LANGUAGE );

		if( language == null ) {
			language = defaultLanguage();
		}

		NSArray<String> languages = new NSArray<String>( language );
		String returnString = WOApplication.application().resourceManager().stringForKey( key, SWC.STRINGS_FILE_NAME, SWC.LOCALIZED_STRING_NOT_FOUND, SWC.FRAMEWORK_NAME, languages );

		return returnString;
	}
}