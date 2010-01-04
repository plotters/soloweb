package is.us.soloweb.interfaces;

import er.extensions.eof.ERXEnterpriseObject;

/**
 * Defines the interface for editable items in SoloWeb.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.4b4
 */

public interface SWInspectable extends ERXEnterpriseObject {

	public String name();

	public void setName( String name );

	public void delete();
}
