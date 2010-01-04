package is.us.soloweb.data;

import is.us.soloweb.interfaces.SWFolder;
import is.us.soloweb.interfaces.SWInheritsPrivileges;
import is.us.soloweb.util.SWFolderUtilities;
import is.us.util.USArrayUtilities;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;

/**
 * An SWDocumentFolder represents a folder containing SWDocument objects
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.7
 */

public class SWDocumentFolder extends _SWDocumentFolder implements SWFolder<SWDocumentFolder> {

	/**
	 * Implementation of SWTransferable. Transfers this folder to a new parent
	 * folder
	 * 
	 * @param newOwner The destination parent object
	 */
	@Override
	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( parent(), PARENT_KEY );
		this.addObjectToBothSidesOfRelationshipWithKey( newOwner, PARENT_KEY );
	}

	/**
	 * Returns all folder objects without a parent folder (essentially root
	 * folders), sorted alphabetically
	 * 
	 * @param ec The calling EOEditingContext
	 * @return folder objects without a parent folder
	 */
	@Override
	public NSArray<SWDocumentFolder> sortedRootFolders( EOEditingContext ec ) {
		return SWFolderUtilities.sortedRootFolders( ec, this );
	}

	/**
	 * Returns all subfolders sorted alphabetically
	 * 
	 * @return An NSArray with subfolders
	 */
	@Override
	public NSArray<SWDocumentFolder> sortedSubFolders() {
		return SWFolderUtilities.sortedSubFolders( this );
	}

	/**
	 * Returns all items in this folder, sorted by default sort order.
	 */
	@Override
	public NSArray<SWDocument> sortedDocuments() {
		return USArrayUtilities.sortedArrayUsingIcelandicComparator( documents(), SWDocument.NAME_KEY );
	}

	/**
	 * Number of items in this folder. Does not include subfolders.
	 */
	@Override
	public int count() {
		return SWFolderUtilities.count( this );
	}

	/**
	 * Calculates the total size of items in this folder. Does not include
	 * subfolders.
	 */
	@Override
	public long size() {
		return SWFolderUtilities.size( this );
	}

	/**
	 * Calculates the total size of items in this folder. Does not include
	 * subfolders.
	 */
	@Override
	public double sizeKB() {
		return SWFolderUtilities.sizeKB( this );
	}

	/**
	 * Implementation of SWInheritsPrivileges - returns the object this object
	 * should inherit privileges from (the parent folder)
	 */
	@Override
	public SWInheritsPrivileges inheritsPrivilegesFrom() {
		return parent();
	}

	/**
	 * Deletes this folder and all items contained in it
	 */
	public void deleteFolder() {
		SWFolderUtilities.deleteFolder( editingContext(), this );
	}

	/**
	 * Attempt to construct a legible name, based on the hierarchy
	 */
	public String nameIncludingHierarchy() {
		return SWFolderUtilities.nameIncludingHierarchy( this );
	}
}