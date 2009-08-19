package is.us.soloweb.interfaces;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSTimestamp;

/**
 * An SWAsset represents a system asset that can be stored in the folder file system
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.7
 */

public interface SWAsset<E extends SWFolder> extends SWTransferable, EOEnterpriseObject {

	public String name();

	public void setName( String name );

	public NSTimestamp date();

	public void setDate( NSTimestamp date );

	public int size();

	public E folder();

	public void setFolder( E folder );

	public void deleteAsset();

	public Number assetID();
}
