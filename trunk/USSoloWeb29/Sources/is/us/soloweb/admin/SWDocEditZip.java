package is.us.soloweb.admin;

import com.webobjects.appserver.*;

/**
 * For viewing and working with zip-files in SoloWeb.
 *  
 * @author Hugi Þórðarson
 * 
 * TODO: zip, improve interface.
 * TODO: zip, show status of expansion.
 * TODO: zip, view file contents.
 */

public class SWDocEditZip extends SWDocEditGeneric {

	public SWDocEditZip( WOContext context ) {
		super( context );
	}

	public WOActionResults expandZipFile() {
		document().expandZip();
		return null;
	}
}