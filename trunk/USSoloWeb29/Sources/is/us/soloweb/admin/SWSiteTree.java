package is.us.soloweb.admin;

import is.us.soloweb.SWSession;
import is.us.soloweb.data.*;
import is.us.soloweb.util.SWUtilities;

import com.webobjects.appserver.*;

/**
 * The site tree displayed to the left when you log into a SoloWeb system.
 *
 * @author Hugi Þórðarson
 */

public class SWSiteTree extends SWAdminComponent {

	/**
	 * The current site being iterated over
	 */
	public SWSite currentSite;

	/**
	 * The current page being iterated over
	 */
	public SWPage currentPage;

	public SWSiteTree( WOContext context ) {
		super( context );
	}

	/**
	 * Creates a new site and a frontpage for it.
	 */
	public WOActionResults newSite() {
		SWSite site = SWSite.create( ec() );
		((SWSession)session()).setSelectedSite( site );
		return saveChanges();
	}

	/**
	 * Selects the current page and displays it for editing in an SWEditPage component.
	 */
	public WOActionResults selectPage() {
		return SWUtilities.editObjectInContext( currentPage, context() );
	}
}