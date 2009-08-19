package is.us.soloweb.interfaces;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSTimestamp;

/**
 * The SWTimedContent allows easy implementation of content that is only supposed to be displayed at a particular time.<br />
 * Use in combination with SWTimedContentUtilities.
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.7
 */

public interface SWTimedContent extends EOEnterpriseObject {

	/**
	* The time that the content becomes valid for display
	*/
	public NSTimestamp timeIn();

	/**
	 * The time that the content is invalidated
	 */
	public NSTimestamp timeOut();

	/**
	 * Checks both variables, timeIn() and timeOut() and verifies if the content is within it's display time
	 */
	public boolean isTimeValid();
}
