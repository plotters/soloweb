package is.us.soloweb.data;

import is.us.soloweb.interfaces.SWFolder;
import is.us.soloweb.interfaces.SWInheritsPrivileges;
import is.us.soloweb.util.SWFolderUtilities;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;

/**
 * An SWGroup represents a group of users with access to the SoloWeb system
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.4
 */

public class SWNewsFolder extends _SWNewsFolder implements SWFolder<SWNewsFolder, SWNewsItem> {

	/**
	 * Implementation of SWTransferable. Transfers this folder to a new parent
	 * folder
	 * 
	 * @param newOwner The destination parent object
	 */
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
	public NSArray<SWNewsFolder> sortedRootFolders( EOEditingContext ec ) {
		return SWFolderUtilities.sortedRootFolders( ec, this );
	}

	/**
	 * Returns all subfolders sorted alphabetically
	 * 
	 * @return An NSArray with subfolders
	 */
	public NSArray<SWNewsFolder> sortedSubFolders() {
		return SWFolderUtilities.sortedSubFolders( this );
	}

	/**
	 * Returns all items in this folder, sorted by default sort order.
	 */
	public NSArray<SWNewsItem> sortedDocuments() {
		return SWNewsItem.DATE.descs().sorted( documents() );
	}

	/**
	 * Number of items in this folder. Does not include subfolders.
	 */
	public int count() {
		return SWFolderUtilities.count( this );
	}

	/**
	 * Calculates the total size of items in this folder. Does not include
	 * subfolders.
	 */
	public long size() {
		return SWFolderUtilities.size( this );
	}

	/**
	 * Calculates the total size of items in this folder. Does not include
	 * subfolders.
	 */
	public double sizeKB() {
		return SWFolderUtilities.sizeKB( this );
	}

	/**
	 * Implementation of SWInheritsPrivileges - returns the object this object
	 * should inherit privileges from (the parent folder)
	 */
	public SWInheritsPrivileges inheritsPrivilegesFrom() {
		return parent();
	}

	/**
	 * Deletes this folder and all items contained in it
	 */
	public void deleteFolder() {
		SWFolderUtilities.deleteFolder( this );
	}

	/**
	 * Attempt to construct a legible name, based on the hierarchy
	 */
	public String nameIncludingHierarchy() {
		return SWFolderUtilities.nameIncludingHierarchy( this );
	}

	public Class documentEntityClass() {
		return SWNewsItem.class;
	}
}