package is.us.soloweb.interfaces;

import is.us.util.USHierarchy;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;

/**
 * SWFolder is a common interface for all folders in SoloWeb
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.7
 */

public interface SWFolder<E, T> extends EOEnterpriseObject, USHierarchy, SWTransferable, SWInheritsPrivileges, SWInspectable {

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
	public NSArray<T> documents();

	/**
	 * Sorted documents in this folder.
	 */
	public NSArray<T> sortedDocuments();

	/**
	 * @return The total size of objects in the folder in bytes.
	 */
	public long size();

	/**
	 * @return The total size of objects in the folder in kilobytes.
	 */
	public double sizeKB();

	/**
	 * The folder ID.
	 */
	public Integer folderID();

	/**
	 * Calculates the number of files in the folder.
	 */
	public int count();

	/**
	 * The entity name of the document objects in the folder.
	 */
	public Class documentEntityClass();
}