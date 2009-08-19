package is.us.soloweb;

import is.us.soloweb.data.*;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.WOApplication;
import com.webobjects.foundation.*;

import er.extensions.appserver.ERXSession;
import er.extensions.localization.ERXLocalizer;

/**
 * SWSession is the replacement for WOSession for SoloWeb applications.
 * It is the same as WOSession, but also stores the current active user,
 * if a user is logged in to the SoloWeb system, and also keeps a
 * customInfo dictionary, like many other SW-objects.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2.b4
 * @since 2.3
 */

public abstract class SWSession extends ERXSession {

	private static final String CS_KEYPATH = "@cs";
	private static final String LS_KEYPATH = "@ls";
	private static final String AS_KEYPATH = "@as";

	private NSMutableDictionary<?, ?> _customInfo;
	private SWUser _solowebUser;
	private SWSite _selectedSite;
	private NSTimestamp _startTime;
	private boolean _isLoggedIn = false;

	public SWSession() {
		ERXLocalizer.setAvailableLanguages( new NSArray<String>( SWC.DEFAULT_LANGUAGE ) );
		setCustomInfo( new NSMutableDictionary<Object, Object>() );
		setStartTime( new NSTimestamp() );
	}

	public NSTimestamp startTime() {
		return _startTime;
	}

	private void setStartTime( NSTimestamp t ) {
		_startTime = t;
	}

	/**
	 * Set the current active user.
	 */
	public void setSolowebUser( SWUser user ) {
		_solowebUser = user;
		SoloWeb.sw().solowebSessions().addObject( this );
		defaultEditingContext().setUserInfoForKey( user, SWC.SW_USER_USERINFO_KEY );
	}

	public SWUser solowebUser() {
		return _solowebUser;
	}

	/**
	 * Set the current active user.
	 */
	public void setSelectedSite( SWSite s ) {
		_selectedSite = s;
	}

	public SWSite selectedSite() {
		return _selectedSite;
	}

	/**
	 * A dictionary to store special information, like many other SW-objects provide.
	 */
	public NSMutableDictionary customInfo() {
		return _customInfo;
	}

	/**
	 * A method to set the customInfo dictionary
	 */
	public void setCustomInfo( NSMutableDictionary<?, ?> d ) {
		_customInfo = d;
	}

	public void terminate() {
		SoloWeb.sw().solowebSessions().removeObject( this );
		super.terminate();
	}

	public void addObjectToArrayWithKey( Object anObject, String key ) {
		arrayWithKey( key ).addObject( anObject );
	}

	public void removeObjectFromArrayWithKey( Object anObject, String key ) {
		arrayWithKey( key ).removeObject( anObject );
	}

	public boolean arrayWithKeyContainsObject( String key, Object anObject ) {
		return arrayWithKey( key ).containsObject( anObject );
	}

	public NSMutableArray arrayWithKey( String key ) {
		Object theArray = customInfo().objectForKey( key );

		if( theArray == null ) {
			customInfo().setObjectForKey( new NSMutableArray(), key );
			theArray = customInfo().objectForKey( key );
		}

		return (NSMutableArray<?>)theArray;
	}

	/**
	 * Localization
	 */
	public Object valueForKeyPath( String keypath ) {

		if( keypath.startsWith( LS_KEYPATH ) )
			return localizedStringForKey( keypath.substring( 4, keypath.length() ) );

		if( keypath.startsWith( CS_KEYPATH ) )
			return confirmStringForKey( keypath.substring( 4, keypath.length() ) );

		if( keypath.startsWith( AS_KEYPATH ) )
			return localizedApplicationStringForKey( keypath.substring( 4, keypath.length() ) );

		return super.valueForKeyPath( keypath );
	}

	public Object valueForKey( String keypath ) {

		if( keypath.startsWith( LS_KEYPATH ) )
			return localizedStringForKey( keypath.substring( 4, keypath.length() ) );

		if( keypath.startsWith( CS_KEYPATH ) )
			return confirmStringForKey( keypath.substring( 4, keypath.length() ) );

		if( keypath.startsWith( AS_KEYPATH ) )
			return localizedApplicationStringForKey( keypath.substring( 4, keypath.length() ) );

		return super.valueForKey( keypath );
	}

	public String localizedStringForKey( String key ) {
		return WOApplication.application().resourceManager().stringForKey( key, SWC.STRINGS_FILE_NAME, SWC.LOCALIZED_STRING_NOT_FOUND, SWC.FRAMEWORK_NAME, languages() );
	}

	public String localizedApplicationStringForKey( String key ) {
		return WOApplication.application().resourceManager().stringForKey( key, SWC.STRINGS_FILE_NAME, SWC.LOCALIZED_STRING_NOT_FOUND, application().name(), languages() );
	}

	private String confirmStringForKey( String key ) {
		StringBuilder b = new StringBuilder();

		b.append( "return confirm('" );
		b.append( localizedStringForKey( key ) );
		b.append( "');" );

		return b.toString();
	}

	public void setIsLoggedIn( boolean b ) {
		_isLoggedIn = b;
	}

	public boolean isLoggedIn() {
		return _isLoggedIn;
	}
}