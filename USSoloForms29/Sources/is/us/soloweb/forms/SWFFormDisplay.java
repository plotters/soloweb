package is.us.soloweb.forms;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.forms.data.SWFForm;
import is.us.util.USUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Hugi Þórðarson
 */

public class SWFFormDisplay extends SWGenericComponent {

	private EOEditingContext ec = session().defaultEditingContext();

	public SWFFormDisplay( WOContext context ) {
		super( context );
	}

	public SWFForm selectedForm() {
		return SWFForm.formWithID( ec, formID() );
	}

	private Integer formID() {
		return USUtilities.integerFromObject( currentComponent().customInfo().valueForKey( "formID" ) );
	}
}
