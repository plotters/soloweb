package is.us.soloweb.forms;

import is.us.soloweb.SWSession;
import is.us.soloweb.forms.data.SWFForm;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditForm extends SWInspectionComponent<SWFForm> {

	public NSArray<String> tabs;
	public String selectedTab;

	public SWFEditForm( WOContext context ) {
		super( context );
	}

	/**
	 * FIXME: Add Actions tab.
	 */
	public NSArray<String> tabs() {
		if( ((SWSession)session()).solowebUser().hasPrivilegeFor( selectedObject().folder(), "editFormSettings" ) )
			return new NSArray<String>( new String[] { "General", "Registrations", "Fields", "Fixed search arguments" } );

		return new NSArray<String>( new String[] { "Registrations" } );
	}
}