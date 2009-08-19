package is.us.soloweb.interfaces;

/**
 * Defines the interface for editable items in SoloWeb.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.4b4
 */

public interface SWInspectable {

	public String name();

	public void setName( String name );

	public void delete();
}
