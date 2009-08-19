package is.us.soloweb;

import is.us.soloweb.data.SWPage;
import is.us.soloweb.util.SWPageUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

/**
 * SWGenericSiteLook is the common ancestor of all Site Looks created for SoloWeb.
 * Subclass this to create your own custom look component.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b2
 * @since 2.3
 */

public abstract class SWGenericSiteLook extends ERXComponent {

	/**
	 * The currently selected page.
	 */
	private SWPage _selectedPage;

	private EOEditingContext _ec;

	public SWGenericSiteLook( WOContext context ) {
		super( context );
	}

	/**
	 * The editingContext
	 */
	private EOEditingContext ec() {
		if( _ec == null ) {
			_ec = ERXEC.newEditingContext();
		}

		return _ec;
	}

	/**
	 * Returns the selected page.
	 */
	public SWPage selectedPage() {
		if( _selectedPage == null )
			_selectedPage = SWPageUtilities.pageFromRequest( ec(), context().request() );

		return _selectedPage;
	}

	/**
	 * Sets the currently selected page.
	 */
	public void setSelectedPage( SWPage p ) {
		_selectedPage = p;
	}
}