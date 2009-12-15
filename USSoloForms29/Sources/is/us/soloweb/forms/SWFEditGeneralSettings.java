package is.us.soloweb.forms;

import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.forms.data.SWFForm;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditGeneralSettings extends SWAdminComponent {

	public SWFForm selectedForm;

	public SWFEditGeneralSettings( WOContext context ) {
		super( context );
	}
}
