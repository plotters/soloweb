package is.us.soloweb.admin;

import is.us.soloweb.data.SWPage;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 */

public class SWEditPageGeneralInfo extends SWInspectionComponent<SWPage> {

	public SWEditPageGeneralInfo( WOContext context ) {
		super( context );
	}
}
