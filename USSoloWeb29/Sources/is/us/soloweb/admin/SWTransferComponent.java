package is.us.soloweb.admin;

import is.us.soloweb.data.*;

import com.webobjects.appserver.*;

/**
 * A component for transferring of an SWComponent to a new page
 *
 * @author Hugi Þórðarson
 * @version 2.9.2
 * @since 2.5
 */

public class SWTransferComponent extends SWTransferComponentGeneric {

	public SWTransferComponent( WOContext context ) {
		super( context );
	}

	public WOActionResults selectObject() {
		if( !shouldCopy ) {
			return super.selectObject();
		}
		else {
			((SWPage)currentParent).insertComponentAtIndex( ((SWComponent)record).createCopy(), 0 );
			ec().saveChanges();
			return componentToReturn;
		}
	}
}