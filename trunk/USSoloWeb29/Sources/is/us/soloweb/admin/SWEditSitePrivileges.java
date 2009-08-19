package is.us.soloweb.admin;

import is.us.soloweb.data.SWSite;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWEditSitePrivileges extends SWInspectionComponent<SWSite> {

	public SWEditSitePrivileges( WOContext context ) {
		super( context );
	}
}
