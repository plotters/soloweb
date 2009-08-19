package is.us.soloweb.forms;

import is.us.soloweb.forms.data.*;

import com.webobjects.appserver.*;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditFieldSets extends SWFAdminComponent {

	public SWFForm selectedForm;
	public SWFField currentField;
	public SWFFieldSet currentFieldSet;

	public SWFEditFieldSets( WOContext context ) {
		super( context );
	}

	public WOComponent addFieldSet() {
		selectedForm.addFieldSet();
		return saveChanges();
	}

	public WOComponent removeFieldSet() {
		selectedForm.removeFieldSet( currentFieldSet );
		return saveChanges();
	}

	public WOComponent fieldSetUp() {
		currentFieldSet.changeSortOrder( -1 );
		return saveChanges();
	}

	public WOComponent fieldSetDown() {
		currentFieldSet.changeSortOrder( 1 );
		return saveChanges();
	}
}