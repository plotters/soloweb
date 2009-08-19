package is.us.soloweb.admin;

import is.us.soloweb.data.SWPage;
import is.us.soloweb.interfaces.SWInspectionComponent;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSMutableArray;

/**
 * A component for reordering the subpagse of the selected page.
 * 
 * @author Hugi Thordarson
 */

public class SWReorderSubpages extends SWInspectionComponent<SWPage> {

	public WOComponent componentToReturnTo;
	public SWPage currentPage;
	public NSMutableArray<SWPage> pageArray;

	public void setSelectedObject( SWPage p ) {
		super.setSelectedObject( p );
		pageArray = p.sortedSubPages().mutableClone();
	}

	public SWReorderSubpages( WOContext context ) {
		super( context );
	}

	public WOActionResults reorder() {
		int i = 0;

		for( SWPage nextPage : pageArray ) {
			nextPage.setSortNumber( i++ );
		}

		return null;
	}

	/**
	 * REturns to the component that invoked this page. 
	 */
	public WOActionResults returnToPreviousPage() {
		ec().saveChanges();
		componentToReturnTo.ensureAwakeInContext( context() );
		return componentToReturnTo;
	}
}