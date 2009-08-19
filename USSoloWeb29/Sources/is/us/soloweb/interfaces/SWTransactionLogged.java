package is.us.soloweb.interfaces;

import is.us.soloweb.data.SWUser;

import com.webobjects.foundation.NSTimestamp;

/**
 * @author Hugi Þórðarson
 */

public interface SWTransactionLogged {

	public NSTimestamp creationDate();

	public void setCreationDate( NSTimestamp t );

	public NSTimestamp modificationDate();

	public void setModificationDate( NSTimestamp t );

	public void setCreatedBy( SWUser user );

	public SWUser createdBy();

	public void setModifiedBy( SWUser user );

	public SWUser modifiedBy();
}
