package is.us.soloweb.forms;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 */

public class SWFFormAdmin extends SWFAdminComponent {

	public SWFFormAdmin( WOContext context ) {
		super( context );
	}

	/**
	 * FIXME: Re-add special privileges for forms.
	 */
	public NSDictionary<String, String> privilegePairs() {
		NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
		d.setObjectForKey( "allowToSee", "See folders" );
		d.setObjectForKey( "canManageUsers", "Manage privileges" );
		d.setObjectForKey( "editFormSettings", "Edit forms" );
		return d;
	}
}
