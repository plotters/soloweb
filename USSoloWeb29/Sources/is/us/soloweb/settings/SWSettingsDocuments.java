package is.us.soloweb.settings;

import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.data.SWDocumentType;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSArray;

/**
 * Managing settings for Documents in SoloWeb.
 *  
 * @author Hugi Þórðarson
 */

public class SWSettingsDocuments extends SWAdminComponent {

	public SWDocumentType currentDocumentType;

	public SWSettingsDocuments( WOContext c ) {
		super( c );
	}

	public NSArray<SWDocumentType> documentypes() {
		return SWDocumentType.allDocumentTypes( ec() );
	}

	public WOActionResults save() {
		return saveChanges();
	}

	public WOActionResults createDocumentType() {
		SWDocumentType dt = new SWDocumentType();
		ec().insertObject( dt );
		return saveChanges();
	}

	public WOActionResults deleteDocumentType() {
		ec().deleteObject( currentDocumentType );
		return saveChanges();
	}
}