package is.us.soloweb.interfaces;

import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.util.SWAccessPrivilegeUtilities;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSDictionary;

/**
 * 
 * @author Hugi Þórðarson
 */

public abstract class SWInspectionComponent<E extends SWInspectable> extends SWAdminComponent {

	private E _selectedObject;
	private WOComponent _callingComponent;

	public SWInspectionComponent( WOContext context ) {
		super( context );
	}

	public E selectedObject() {
		return _selectedObject;
	}

	public void setSelectedObject( E object ) {
		_selectedObject = object;
	}

	/**
	 * Deletes the selected object
	 */
	public WOActionResults deleteObject() {
		selectedObject().delete();
		setSelectedObject( null );
		return saveChanges();
	}

	/**
	 * Privileges for the selected Object.
	 */
	public NSDictionary<String, String> privilegePairs() {
		return SWAccessPrivilegeUtilities.privilegePairsForObject( selectedObject(), session() );
	}

	public void setCallingComponent( WOComponent _callingComponent ) {
		this._callingComponent = _callingComponent;
	}

	public WOComponent callingComponent() {
		return _callingComponent;
	}

	public WOActionResults saveChangesAndReturn() {
		ec().saveChanges();
		callingComponent().ensureAwakeInContext( context() );
		return callingComponent();
	}
}
