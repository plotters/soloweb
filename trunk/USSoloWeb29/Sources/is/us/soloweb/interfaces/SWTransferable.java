package is.us.soloweb.interfaces;

import com.webobjects.eocontrol.EOEnterpriseObject;

/**
 * The SWTransferable protocol allows for a unified interface for transferring objects.
 *
 * @author Hugi Þórðarson
 * @version 2.5
 * @since 2.5
 */

public interface SWTransferable extends EOEnterpriseObject {

	/**
	 * @return Name of the item.
	 */
	public String name();

	/**
	 * Implement this method for your objects, and you will be able to use the standard object transfer mechanism provided in SWAdmin
	 *
	 * @param newOwner The destination object
	 */
	public void transferOwnership( EOEnterpriseObject newOwner );
}
