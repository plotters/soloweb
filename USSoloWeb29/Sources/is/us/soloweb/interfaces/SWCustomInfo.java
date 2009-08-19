package is.us.soloweb.interfaces;

import com.webobjects.foundation.NSMutableDictionary;

/**
 * Objects that use customInfoString and want their stuff to be automatically synchronized with an
 * NSDictionary should implement this interface.
 * 
 * @author Hugi Þórðarson
 * @version 2.9
 */

public interface SWCustomInfo {

	public NSMutableDictionary customInfo();

	public void setCustomInfo( NSMutableDictionary d );

	public String customInfoString();

	public void setCustomInfoString( String s );
}
