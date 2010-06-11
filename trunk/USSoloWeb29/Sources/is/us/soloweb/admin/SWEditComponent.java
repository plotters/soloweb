package is.us.soloweb.admin;

import is.us.soloweb.*;
import is.us.soloweb.client.*;
import is.us.soloweb.data.SWComponent;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.*;

/**
 * SWEditComponent is displayed when editing components, and contains among other things
 * the tabs to select a new component type.
 *
 * @author Hugi Þórðarson
 */

public class SWEditComponent extends SWInspectionComponent<SWComponent> {

	private final String _defaultTabName = SWLoc.string( "cpteContent", session() );

	/**
	 * Name of the currently selected tab in the component type tab panel
	 */
	private String _tabPanelSelection;

	/**
	 * The tab currently being iterated over in the panel
	 */
	public String currentType;

	public SWEditComponent( WOContext context ) {
		super( context );
	}

	public String tabPanelSelection() {
		if( _tabPanelSelection == null ) {
			_tabPanelSelection = activeSystemsAndComponents().objectForKey( selectedObject().templateName() );

			if( _tabPanelSelection == null )
				_tabPanelSelection = _defaultTabName;
		}

		return _tabPanelSelection;
	}

	public void setTabPanelSelection( String s ) {
		_tabPanelSelection = s;
	}

	/**
	 * All possible types of components and their corresponding editing components
	 */
	public NSDictionary<String, String> projectTypes() {
		NSMutableDictionary<String, String> activeComponents = new NSMutableDictionary<String, String>( SoloWeb.sw().activeComponents() );
		activeComponents.setObjectForKey( SWCAText.class.getName(), SWLoc.string( "cpteContent", session() ) );
		activeComponents.setObjectForKey( SWCANews.class.getName(), SWLoc.string( "cpteNews", session() ) );
		activeComponents.setObjectForKey( SWCADocuments.class.getName(), SWLoc.string( "cpteDocuments", session() ) );
		activeComponents.setObjectForKey( SWCAGeneric.class.getName(), "Generic" );
		return activeComponents;
	}

	public NSDictionary<String, String> activeSystemsAndComponents() {
		NSMutableDictionary<String, String> activeSystemsAndComponents = new NSMutableDictionary<String, String>( SoloWeb.sw().activeSystemsAndComponents() );
		activeSystemsAndComponents.setObjectForKey( SWLoc.string( "cpteContent", session() ), ButurTemplate001.class.getSimpleName() );
		activeSystemsAndComponents.setObjectForKey( SWLoc.string( "cpteContent", session() ), ButurTemplate002.class.getSimpleName() );
		activeSystemsAndComponents.setObjectForKey( SWLoc.string( "cpteContent", session() ), ButurTemplate003.class.getSimpleName() );
		activeSystemsAndComponents.setObjectForKey( SWLoc.string( "cpteContent", session() ), ButurTemplate004.class.getSimpleName() );
		activeSystemsAndComponents.setObjectForKey( SWLoc.string( "cpteNews", session() ), SoloNewsNewsList.class.getSimpleName() );
		activeSystemsAndComponents.setObjectForKey( SWLoc.string( "cpteDocuments", session() ), SWSFComponent.class.getSimpleName() );
		activeSystemsAndComponents.setObjectForKey( SWLoc.string( "cpteDocuments", session() ), SWSFFileList.class.getSimpleName() );
		return activeSystemsAndComponents;
	}

	/**
	 * All tabs to display for component type selection
	 */
	public NSArray<String> types() {
		return projectTypes().allKeys();
	}

	/**
	 * The name of the component editing component to display.
	 */
	@Override
	public String componentName() {
		return projectTypes().objectForKey( currentType );
	}
}