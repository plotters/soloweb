package is.us.soloweb.interfaces;

import com.webobjects.eocontrol.EOEnterpriseObject;

/**
 * Implemented by classes that can inherit privileges from another object
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.7
 */

public interface SWInheritsPrivileges extends EOEnterpriseObject {

	/**
	* Indicates if this object should inherit privileges
	*/
	public Integer inheritsPrivileges();

	/**
	 * Indicates if this object should inherit privileges
	*/
	public void setInheritsPrivileges( Integer newValue );

	/**
	 * The object that this object should inherit privileges from
	 */
	public SWInheritsPrivileges inheritsPrivilegesFrom();
}
