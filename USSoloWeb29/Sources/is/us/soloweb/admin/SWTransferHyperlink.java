package is.us.soloweb.admin;

import is.us.soloweb.interfaces.SWTransferable;

import com.webobjects.appserver.*;

/**
 * Invokes the transferring of a component using the SWTransferable interface.
 * To transfer an object using this component, first create a subclass of SWGenericTransferComponent<br />
 * Then, create an SWTransferHyperlink in your page, and pass it the folloeing bindings:
 *
 * <ul>
 * <li> <b>transferComponentName</b><br />The name of the transfercomponent to invoke (a subclass of "SWGenericTransferComponent").
 * <li> <b>record>/b><br />The record to transfer to a new owner
 * <li> <b>componentToReturn</b><br />The component instance to return to, after the transfer has been completed/canceled
 * </ul><br />
 *
 * @author Hugi Þórðarson
 */

public class SWTransferHyperlink extends SWAdminComponent {

	/**
	 * The name of the transfercomponent to invoke (a subclass of "SWGenericTransferComponent").
	 */
	public String transferComponentName;

	/**
	* Target frame
	*/
	public String target;

	/**
	 * The record to transfer ownership of
	 */
	public SWTransferable record;

	/**
	 * A WOComponent instance to return to after the transfer has been completed
	 */
	public WOComponent componentToReturn;

	public SWTransferHyperlink( WOContext context ) {
		super( context );
	}

	/**
	 * Creates and returns an instance of the "SWGenericTransferComponent" subclass specified
	 * in "transferComponentName" wit the given parameters, and returns it.
	 */
	public WOActionResults transfer() {
		SWTransferComponentGeneric nextPage = (SWTransferComponentGeneric)pageWithName( transferComponentName );

		nextPage.componentToReturn = componentToReturn;
		nextPage.record = record;

		return nextPage;
	}
}