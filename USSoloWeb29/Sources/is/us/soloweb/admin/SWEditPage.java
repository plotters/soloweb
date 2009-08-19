package is.us.soloweb.admin;

import is.us.soloweb.*;
import is.us.soloweb.data.SWPage;
import is.us.soloweb.interfaces.SWInspectionComponent;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * SWEditPage is displayed when editing pages, and contains among other things
 * the tabs to select a new component type.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.3
 */

public class SWEditPage extends SWInspectionComponent<SWPage> {

	// Localized strings
	private static final String EPT_GENERAL = "eptGeneral";
	private static final String EPT_CONTENT = "eptContent";
	private static final String EPT_ACCESS_PRIVILEGES = "eptAccessPrivileges";
	private static final String SOLOWEB_SELECTED_PAGE_TAB = "solowebSelectedPageTab";

	public SWEditPage( WOContext context ) {
		super( context );
	}

	public NSDictionary<String, String> tabDictionary() {
		NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>( SoloWeb.sw().activePageEditingComponents() );

		if( user().hasPrivilegeFor( selectedObject(), SWC.PRIVILEGE_CAN_MANAGE_PAGE ) )
			d.setObjectForKey( SWEditPageGeneralInfo.class.getSimpleName(), SWLoc.string( EPT_GENERAL, session() ) );

		if( user().hasPrivilegeFor( selectedObject(), SWC.PRIVILEGE_CAN_MANAGE_CONTENT ) )
			d.setObjectForKey( SWEditPageContent.class.getSimpleName(), SWLoc.string( EPT_CONTENT, session() ) );

		if( SWSettings.privilegesEnabled() )
			if( user().hasPrivilegeFor( selectedObject(), SWC.PRIVILEGE_CAN_MANAGE_USERS ) )
				d.setObjectForKey( SWEditPagePrivileges.class.getSimpleName(), SWLoc.string( EPT_ACCESS_PRIVILEGES, session() ) );

		return d;
	}

	public String selectedComponentName() {
		return tabDictionary().objectForKey( selectedTab() );
	}

	/**
	 * The currently selected tab
	 */
	public String selectedTab() {
		String selected = (String)((SWSession)session()).customInfo().valueForKey( SOLOWEB_SELECTED_PAGE_TAB );

		if( selected == null ) {
			selected = SWLoc.string( EPT_CONTENT, session() );
		}

		return selected;
	}

	/**
	 * Sets the selected tab
	 */
	public void setSelectedTab( String newSelectedTab ) {
		((SWSession)session()).customInfo().takeValueForKey( newSelectedTab, SOLOWEB_SELECTED_PAGE_TAB );
	}

	/**
	 * The editing tabs to display at the top of the editing page.
	 */
	public NSArray<String> tabs() {
		return tabDictionary().allKeys();
	}

	/**
	 * Creates a new SWPage below all other subpages in the sortorder and
	 * expands the selected page's branch in the site tree.
	 */
	public WOActionResults createSubPage() {
		SWPage p = selectedObject().createSubPage();

		if( !((SWSession)session()).arrayWithKeyContainsObject( SWPage.class.getSimpleName(), selectedObject() ) )
			((SWSession)session()).addObjectToArrayWithKey( selectedObject(), SWPage.class.getSimpleName() );

		setSelectedObject( p );
		setSelectedTab( SWLoc.string( EPT_GENERAL, session() ) );

		return saveChanges();
	}

	/**
	 * Deletes the selected page and all it's content
	 */
	public WOActionResults deletePage() {
		selectedObject().deletePage();

		setSelectedObject( null );
		setSelectedTab( SWLoc.string( EPT_GENERAL, session() ) );

		return saveChanges();
	}

	/**
	 * For re-ordering the subpages of the selected page. 
	 */
	public WOActionResults movePage() {
		SWReorderSubpages nextPage = pageWithName( SWReorderSubpages.class );
		nextPage.setSelectedObject( selectedObject() );
		nextPage.componentToReturnTo = this;
		return nextPage;
	}
}