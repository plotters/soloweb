package is.us.soloweb.admin;

import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.*;

/**
 * @author Hugi Þórðarson
 * @since 2.3
 */

public class SWEditNewsItem extends SWInspectionComponent<SWNewsItem> {

	public SWEditNewsItem( WOContext context ) {
		super( context );
	}

	/**
	 * Previews the selected item.
	 */
	public WOActionResults preview() {
		SWNewsPreview nextPage = pageWithName( SWNewsPreview.class );
		nextPage.setSelectedObject( selectedObject() );
		return nextPage;
	}
}
