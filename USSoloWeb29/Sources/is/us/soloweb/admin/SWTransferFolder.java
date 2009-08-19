package is.us.soloweb.admin;

import is.us.soloweb.interfaces.SWFolder;

import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWTransferFolder extends SWTransferComponentGeneric {

	public SWTransferFolder( WOContext context ) {
		super( context );
	}

	public boolean isFolder() {
		return record instanceof SWFolder;
	}
}
