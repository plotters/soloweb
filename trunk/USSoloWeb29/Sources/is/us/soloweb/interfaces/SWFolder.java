package is.us.soloweb.interfaces;

import is.us.util.USHierarchy;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSArray;

/**
 * SWFolder is a common interface for all folders in SoloWeb
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.7
 */

public interface SWFolder<E> extends EOEnterpriseObject, USHierarchy, SWTransferable, SWInheritsPrivileges {

	/**
	 * The folder's name
	 */
	public String name();

	/**
	 * The folder's name
	 */
	public void setName( String newName );

	/**
	 * Sorted root folders of this type
	 */
	public NSArray<E> sortedRootFolders( EOEditingContext ec );

	/**
	 * The folder's sorted subfolders
	 */
	public NSArray<E> sortedSubFolders();

	/**
	 * Unsorted documents in this folder. 
	 */
	public NSArray<? extends SWAsset> documents();

	/**
	 * Sorted documents in this folder.
	 */
	public NSArray<? extends SWAsset> sortedDocuments();

	/**
	 * @return The total size of objects in the folder. 
	 */
	public int size();

	/**
	 * The folder ID. 
	 */
	public Integer folderID();

	/**
	 * Calculates the number of files in the folder. 
	 */
	public int count();

	/**
	 * Default sort orderings for the items this folder contains.
	 * 
	 * FIXME: This should not be required.
	 */
	public NSArray<EOSortOrdering> itemSordOrderings();
}