package is.us.soloweb.forms;

import is.us.soloweb.SWPlugin;

import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 */

public class SWFPrimary {

	static {
		SWPlugin aPlugin = new SWPlugin();
		aPlugin.setName( "SoloForms" );
		aPlugin.setVersion( "2.9b1" );
		aPlugin.setComponents( new NSArray<String>( new String[] { "SWFRegistrationDisplay", "SWFFormDisplay" } ) );
		aPlugin.setModels( new NSArray<String>( new String[] { "SoloForms" } ) );
		aPlugin.setMainAdminComponent( "SWFFormAdmin" );
		aPlugin.setComponentAdminComponent( "SWFFormAdminComponent" );
		aPlugin.registerWithApplication();
	}
}
