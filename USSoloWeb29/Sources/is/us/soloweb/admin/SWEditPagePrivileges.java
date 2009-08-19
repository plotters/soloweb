package is.us.soloweb.admin;

import is.us.soloweb.data.SWPage;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWEditPagePrivileges extends SWInspectionComponent<SWPage> {

	public SWEditPagePrivileges( WOContext context ) {
		super( context );
	}
}
