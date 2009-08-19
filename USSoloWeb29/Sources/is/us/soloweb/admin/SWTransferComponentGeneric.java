package is.us.soloweb.admin;

import is.us.soloweb.interfaces.SWTransferable;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEnterpriseObject;

/**
 * This component defines the basis for transfer of objects that implement the SWTransferable interface.
 * To use this component, create your own subclass, displaying a list of the possible destination objects.
 * Make the parent objects iterate over the "currentParent" variable.
 * When a destination object is clicked, invoke the selectObject method. The object "record" will be transferred
 * from it's previous parent to "currentParent", changes are saved and the WOComponent instance
 * stored in "componentToReturn" is returned.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.4
 */

public abstract class SWTransferComponentGeneric extends SWAdminComponent {

	/**
	 * Indicates if we should copy or move.
	 */
	public boolean shouldCopy = false;

	/**
	 * The parent object currently being iterated over
	 */
	public EOEnterpriseObject currentParent;

	/**
	 * The record to transfer between parents. Must implement "SWTransferable"
	 */
	public SWTransferable record;

	/**
	 * The component to return to when the transfer operation has been completed or canceled
	 */
	public WOComponent componentToReturn;

	public SWTransferComponentGeneric( WOContext context ) {
		super( context );
	}

	/**
	 * Takes "record", moves it's ownership to "currentParent", saves changes and returns "componentToReturn"
	 */
	public WOActionResults selectObject() {
		record.transferOwnership( currentParent );
		ec().saveChanges();

		componentToReturn.ensureAwakeInContext( context() );
		return componentToReturn;
	}

	/**
	 * Just returns "componentToReturn" without executing a transfer.
	 */
	public WOActionResults cancel() {
		componentToReturn.ensureAwakeInContext( context() );
		return componentToReturn;
	}
}