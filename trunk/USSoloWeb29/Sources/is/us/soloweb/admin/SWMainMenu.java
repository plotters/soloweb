package is.us.soloweb.admin;

import is.us.soloweb.SoloWeb;
import is.us.soloweb.data.*;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * The "System menu" component, displayed at the top of the SoloWeb system.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.3
 */

public class SWMainMenu extends SWAdminComponent {

	/**
	 * The name of the current system being displayed
	 */
	public String currentKey;
	public String searchString;

	public SWMainMenu( WOContext context ) {
		super( context );
	}

	public NSDictionary<String, String> systemDictionary() {
		return SoloWeb.sw().activeSystems();
	}

	/**
	 * An array with all system names - the keys of the tempSystems dictionary
	 */
	public NSArray<String> theSystems() {
		return systemDictionary().allKeys();
	}

	/**
	 * Name of component to display for the current system name (when clicked)
	 */
	public String currentSystem() {
		return systemDictionary().objectForKey( currentKey );
	}

	public void sleep() {
		session().savePageInPermanentCache( this );
	}

	/**
	 * Logs out the current user and displays the "SWLoggedOut" component.
	 */
	public WOActionResults logout() {
		session().terminate();
		return pageWithName( SWLoggedOut.class );
	}

	public WOActionResults documentDB() {
		SWAssetManagement nextPage = pageWithName( SWAssetManagement.class );
		nextPage.setEntityName( SWDocument.class.getSimpleName() );
		nextPage.setFolderEntityName( SWDocumentFolder.class.getSimpleName() );
		nextPage.setEditingComponentName( SWEditDocument.class.getSimpleName() );
		return nextPage;
	}

	public WOActionResults newsDB() {
		SWAssetManagement nextPage = pageWithName( SWAssetManagement.class );
		nextPage.setEntityName( SWNewsItem.class.getSimpleName() );
		nextPage.setFolderEntityName( SWNewsFolder.class.getSimpleName() );
		nextPage.setEditingComponentName( SWEditNewsItem.class.getSimpleName() );
		return nextPage;
	}

	public WOActionResults search() {
		return null;
	}
}