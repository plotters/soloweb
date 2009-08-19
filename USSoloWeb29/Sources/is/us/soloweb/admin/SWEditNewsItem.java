package is.us.soloweb.admin;

import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.3
 */

public class SWEditNewsItem extends SWInspectionComponent<SWNewsItem> {

	public SWEditNewsItem( WOContext context ) {
		super( context );
	}
}
