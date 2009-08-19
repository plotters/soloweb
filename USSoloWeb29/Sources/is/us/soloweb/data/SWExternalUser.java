package is.us.soloweb.data;

/**
 * A visitor to a SoloWeb system.
 * 
 * @author Hugi Þórðarson 
 */

public class SWExternalUser extends _SWExternalUser {
	
	/**
	 * Determines if the poster is the owner of the blog.
	 * 
	 * FIXME: Implement for all users.  
	 */
	public boolean isNotHugi() {
		return !"Hugi".equals( username() );
	}
}