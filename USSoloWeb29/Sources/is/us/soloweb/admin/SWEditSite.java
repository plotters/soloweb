package is.us.soloweb.admin;

import is.us.soloweb.*;
import is.us.soloweb.data.SWSite;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * SWEditSite is used to edit information for an SWSite
 *
 * @author Hugi Þórðarson
 */

public class SWEditSite extends SWInspectionComponent<SWSite> {

	public String selectedTab = SWLoc.string( "eSiteTabGeneral", session() );
	public NSArray<String> tabs = tabDictionary().allKeys();

	public SWEditSite( WOContext context ) {
		super( context );
	}

	public NSDictionary<String, String> tabDictionary() {
		NSMutableDictionary<String, String> activeSiteEditingComponents = new NSMutableDictionary<String, String>( SoloWeb.sw().activeSiteEditingComponents() );
		activeSiteEditingComponents.setObjectForKey( SWEditSiteGeneralInfo.class.getSimpleName(), SWLoc.string( "eSiteTabGeneral", session() ) );

		if( SWSettings.privilegesEnabled() )
			activeSiteEditingComponents.setObjectForKey( SWEditSitePrivileges.class.getSimpleName(), SWLoc.string( "eSiteTabAccessPrivileges", session() ) );

		return activeSiteEditingComponents;
	}

	public String selectedEditingComponentName() {
		return tabDictionary().objectForKey( selectedTab );
	}

	/**
	 * Deletes the selected site
	 */
	public WOActionResults deleteSite() {
		ec().deleteObject( selectedObject() );
		((SWSession)session()).setSelectedSite( null );
		return saveChanges();
	}
}