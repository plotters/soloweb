package is.us.soloweb.data;

import is.us.soloweb.interfaces.*;
import is.us.soloweb.util.SWFolderUtilities;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSArray;

/**
 * An SWDocumentFolder represents a folder containing SWDocument objects
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.7
 */

public class SWDocumentFolder extends _SWDocumentFolder implements SWFolder<SWDocumentFolder>, SWInspectable {

	/**
	 * Implementation of SWTransferable. Transfers this folder to a new parent folder
	 *
	 * @param newOwner The destination parent object
	 */
	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( parent(), PARENT_KEY );
		this.addObjectToBothSidesOfRelationshipWithKey( newOwner, PARENT_KEY );
	}

	/**
	 * Returns all folder objects without a parent folder (essentially root folders), sorted alphabetically
	 *
	 * @param ec The calling EOEditingContext
	 * @return folder objects without a parent folder
	 */
	public NSArray<SWDocumentFolder> sortedRootFolders( EOEditingContext ec ) {
		return SWFolderUtilities.sortedRootFolders( ec, this );
	}

	/**
	 * Returns all subfolders sorted alphabetically
	 *
	 * @return An NSArray with subfolders
	 */
	public NSArray<SWDocumentFolder> sortedSubFolders() {
		return SWFolderUtilities.sortedSubFolders( this );
	}

	/**
	 * Returns all items in this folder, sorted by default sort order.
	 */
	public NSArray<SWDocument> sortedDocuments() {
		return SWFolderUtilities.sortedDocuments( this );
	}

	/**
	 * Number of items in this folder. Does not include subfolders.
	 */
	public int count() {
		return SWFolderUtilities.count( this );
	}

	/**
	 * Calculates the total size of items in this folder. Does not include subfolders.
	 */
	public int size() {
		return SWFolderUtilities.size( this );
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

	/**
	 * Implementation of SWInheritsPrivileges - returns the object this object should inherit privileges from (the parent folder)
	 */
	public SWInheritsPrivileges inheritsPrivilegesFrom() {
		return parent();
	}

	/**
	 * The default sort ordering to use for objects in this folder.
	 */
	public NSArray<EOSortOrdering> itemSordOrderings() {
		return SWDocument.NAME.ascInsensitives();
	}
}