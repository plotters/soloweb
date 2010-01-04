package is.us.soloweb.forms.data;

import is.us.soloweb.data.SWDocument;
import is.us.soloweb.forms.data.auto._SWFFormFolder;
import is.us.soloweb.interfaces.SWFolder;
import is.us.soloweb.interfaces.SWInheritsPrivileges;
import is.us.soloweb.interfaces.SWInspectable;
import is.us.soloweb.util.SWFolderUtilities;
import is.us.util.USArrayUtilities;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 */

public class SWFFormFolder extends _SWFFormFolder implements SWFolder<SWFFormFolder, SWFForm>, SWInspectable {

	public NSArray<SWFForm> sortedDocuments() {
		return USArrayUtilities.sortedArrayUsingIcelandicComparator( documents(), SWDocument.NAME_KEY );

	}

	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( parent(), PARENT_KEY );
		this.addObjectToBothSidesOfRelationshipWithKey( newOwner, PARENT_KEY );
	}

	public NSArray<SWFFormFolder> sortedRootFolders( EOEditingContext ec ) {
		return SWFolderUtilities.sortedRootFolders( ec, this );
	}

	public NSArray<SWFFormFolder> sortedSubFolders() {
		return SWFolderUtilities.sortedSubFolders( this );
	}

	public long size() {
		return SWFolderUtilities.size( this );
	}

	public double sizeKB() {
		return SWFolderUtilities.sizeKB( this );
	}

	public int count() {
		return SWFolderUtilities.count( this );
	}

	public SWInheritsPrivileges inheritsPrivilegesFrom() {
		return parent();
	}

	public Class documentEntityClass() {
		return SWFForm.class;
	}

	public void deleteFolder() {
		SWFolderUtilities.deleteFolder( this );
	}
}