package is.us.soloweb.forms;

import is.us.soloweb.forms.data.SWFForm;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditGeneralSettings extends SWFAdminComponent {

	public SWFForm selectedForm;

	public SWFEditGeneralSettings( WOContext context ) {
		super( context );
	}
}
