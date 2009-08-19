package is.us.soloweb.forms;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.components.ERXComponent;

/**
 * 
 * @author Hugi Þórðarson
 */

public abstract class SWFAdminComponent extends ERXComponent {

	public SWFAdminComponent( WOContext context ) {
		super( context );
	}

	/**
	 * The editing context we're working with. 
	 */
	public EOEditingContext ec() {
		return session().defaultEditingContext();
	}

	/**
	 * Saves changes to the current page. 
	 */
	public WOComponent saveChanges() {
		ec().saveChanges();
		return context().page();
	}
}
