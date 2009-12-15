package is.us.soloweb.forms;

import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFFieldSet;
import is.us.soloweb.forms.data.SWFForm;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditFieldSets extends SWAdminComponent {

	public SWFForm selectedForm;
	public SWFField currentField;
	public SWFFieldSet currentFieldSet;

	public SWFEditFieldSets( WOContext context ) {
		super( context );
	}

	public WOActionResults addFieldSet() {
		selectedForm.addFieldSet();
		return saveChanges();
	}

	public WOActionResults removeFieldSet() {
		selectedForm.removeFieldSet( currentFieldSet );
		return saveChanges();
	}

	public WOActionResults fieldSetUp() {
		currentFieldSet.changeSortOrder( -1 );
		return saveChanges();
	}

	public WOActionResults fieldSetDown() {
		currentFieldSet.changeSortOrder( 1 );
		return saveChanges();
	}
}