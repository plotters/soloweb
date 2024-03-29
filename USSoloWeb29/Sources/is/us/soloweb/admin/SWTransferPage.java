package is.us.soloweb.admin;

import is.us.soloweb.data.SWPage;

import com.webobjects.appserver.*;

/**
 * A component for copying a page - or transferring it to a new parent page
 *
 * @author Hugi Þórðarson
 */

public class SWTransferPage extends SWTransferComponentGeneric {

	public int currentIndex;

	public SWTransferPage( WOContext context ) {
		super( context );
	}

	@Override
	public WOActionResults selectObject() {
		if( !shouldCopy ) {
			return super.selectObject();
		}
		else {
			((SWPage)currentParent).insertSubPageAtIndex( ((SWPage)record).createCopy(), 0 );
			return returnBack();
		}
	}

	public WOActionResults returnBack() {
		ec().saveChanges();
		componentToReturn.ensureAwakeInContext( context() );
		return componentToReturn;
	}
}