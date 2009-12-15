package is.us.soloweb.forms;

import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.forms.data.SWFField;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditField extends SWAdminComponent {

	private SWFField _selectedField;
	private WOComponent _componentToReturnTo;

	public SWFEditField( WOContext context ) {
		super( context );
	}

	public void setSelectedField( SWFField aField ) {
		_selectedField = aField;
	}

	public SWFField selectedField() {
		return _selectedField;
	}

	public void setComponentToReturnTo( WOComponent component ) {
		_componentToReturnTo = component;
	}

	public WOComponent componentToReturnTo() {
		return _componentToReturnTo;
	}

	public WOComponent saveChanges() {
		ec().saveChanges();
		componentToReturnTo().ensureAwakeInContext( context() );
		return componentToReturnTo();
	}

	/**
	 * FIXME: Does this belong here? 
	 */
	public NSDictionary<String, String> privilegePairs() {
		NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
		d.setObjectForKey( "canEditValue", "Edit value" );
		return d;
	}
}
