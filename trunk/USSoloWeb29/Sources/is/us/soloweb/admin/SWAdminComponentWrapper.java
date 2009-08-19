package is.us.soloweb.admin;

import is.us.soloweb.util.SWC;

import com.webobjects.appserver.*;

import er.ajax.AjaxUtils;
import er.extensions.components.ERXComponent;

/**
 * Most components in the admin system are wrapped in SWAdminComoponentWrapper.
 * It contains standard header information such as links to the system's standard stylesheets and javascripts
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.5
 */

public class SWAdminComponentWrapper extends ERXComponent {

	public SWAdminComponentWrapper( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public void appendToResponse( WOResponse r, WOContext c ) {
		super.appendToResponse( r, c );
		AjaxUtils.addStylesheetResourceInHead( context(), r, SWC.FRAMEWORK_NAME, SWC.MAIN_CSS_FILE_NAME );
		AjaxUtils.addScriptResourceInHead( context(), r, SWC.FRAMEWORK_NAME, SWC.MAIN_JAVASCRIPT_NAME );
	}
}