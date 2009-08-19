package is.us.soloweb.forms.data;

import is.us.soloweb.forms.data.auto._SWFFormFolder;
import is.us.soloweb.interfaces.*;
import is.us.soloweb.util.SWFolderUtilities;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 */

public class SWFFormFolder extends _SWFFormFolder implements SWFolder<SWFFormFolder>, SWInspectable {

	public NSArray sortedDocuments() {
		return SWFolderUtilities.sortedDocuments( this );
	}

	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( parent(), PARENT_KEY );
		this.addObjectToBothSidesOfRelationshipWithKey( newOwner, PARENT_KEY );
	}

	public NSArray sortedRootFolders( EOEditingContext ec ) {
		return SWFolderUtilities.sortedRootFolders( ec, this );
	}

	public NSArray sortedSubFolders() {
		return SWFolderUtilities.sortedSubFolders( this );
	}

	public int size() {
		return SWFolderUtilities.size( this );
	}

	public int count() {
		return SWFolderUtilities.count( this );
	}

	public SWInheritsPrivileges inheritsPrivilegesFrom() {
		return parent();
	}

	public NSArray itemSordOrderings() {
		return SWFForm.NAME.ascs();
	}
}