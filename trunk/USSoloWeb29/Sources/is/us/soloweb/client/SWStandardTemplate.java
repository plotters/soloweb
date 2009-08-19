package is.us.soloweb.client;

import is.us.soloweb.SWGenericTemplate;

import com.webobjects.appserver.WOContext;

/**
 * The default Template for displaying pages in a SoloWeb site.
 *
 * @author Hugi Þórðarson
 * @version 2.9
 * @since 2.3
 */

public class SWStandardTemplate extends SWGenericTemplate {

	public SWStandardTemplate( WOContext context ) {
		super( context );
	}
}
