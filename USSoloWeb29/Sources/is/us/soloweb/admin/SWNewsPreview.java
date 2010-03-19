package is.us.soloweb.admin;

import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.WOContext;

/**
 * Preview component for raw news items.
 * 
 * @author Hugi Thordarson
 */

public class SWNewsPreview extends SWInspectionComponent<SWNewsItem> {

	public SWNewsPreview( WOContext context ) {
		super( context );
	}
}