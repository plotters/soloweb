package is.us.soloweb.util;

import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.*;
import is.us.util.*;

import java.util.Enumeration;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXEOControlUtilities;

/**
 * @author A mixin for use with SWFolder
 */

public class SWFolderUtilities {

	private static final EOQualifier ROOT_FOLDER_QUALIFIER = SWDocumentFolder.PARENT_FOLDER_ID.isNull();
	private static final String PARENT_KEY = "parent";
	private static final String NAME_KEY = "name";

	/**
	 * Returns all folder objects without a parent folder (essentially root
	 * folders), sorted alphabetically
	 * 
	 * @param ec The calling EOEditingContext
	 * @return folder objects without a parent folder
	 */
	public static NSArray sortedRootFolders( EOEditingContext ec, SWFolder folder ) {
		EOFetchSpecification fs = new EOFetchSpecification( folder.entityName(), ROOT_FOLDER_QUALIFIER, null );
		NSArray a = ec.objectsWithFetchSpecification( fs );
		return USArrayUtilities.sortedArrayUsingIcelandicComparator( a, NAME_KEY );
	}

	/**
	 * Returns all subfolders sorted alphabetically
	 * 
	 * @return An NSArray with subfolders
	 */
	public static NSArray sortedSubFolders( SWFolder folder ) {
		return USArrayUtilities.sortedArrayUsingIcelandicComparator( folder.children(), NAME_KEY );
	}

	/**
	 * Returns the first instance of the named subfolder. If a folder with that
	 * name does not exist, or null is passed as the folder name, null is
	 * returned
	 */
	public static SWFolder subFolderNamed( SWFolder parentFolder, String folderName ) {

		if( folderName == null ) {
			return null;
		}

		NSArray<SWFolder> a = parentFolder.sortedSubFolders();

		for( SWFolder f : a ) {

			if( folderName.equals( f.name() ) ) {
				return f;
			}
		}

		return null;
	}

	/**
	 * Returns the named item from the folder
	 */
	public static SWAsset itemNamed( SWFolder folder, String itemName ) {

		if( itemName == null ) {
			return null;
		}

		Enumeration<SWAsset> e = folder.sortedDocuments().objectEnumerator();

		while( e.hasMoreElements() ) {
			SWAsset nextDocument = e.nextElement();

			if( itemName.equals( nextDocument.name() ) )
				return nextDocument;
		}

		return null;
	}

	/**
	 * Deletes this folder and all items contained in it
	 */
	public static void deleteFolder( SWFolder folder ) {
		NSArray<SWAsset> assets = folder.sortedDocuments();

		for( SWAsset asset : assets ) {
			asset.deleteAsset();
		}

		if( folder.parent() != null ) {
			folder.removeObjectFromBothSidesOfRelationshipWithKey( (EORelationshipManipulation)folder.parent(), PARENT_KEY );
		}

		folder.editingContext().deleteObject( folder );
	}

	/**
	 * Number of items in this folder. Does not include subfolders.
	 */
	public static int count( SWFolder folder ) {
		EOQualifier q = SWNewsItem.FOLDER_ID.eq( folder.folderID() );
		return ERXEOControlUtilities.objectCountWithQualifier( folder.editingContext(), folder.documentEntityClass().getSimpleName(), q );
	}

	/**
	 * Calculates the total size of items in this folder. Does not include
	 * subfolders.
	 */
	public static long size( SWFolder folder ) {
		int totalSize = 0;

		for( Object document : folder.documents() ) {
			totalSize += ((SWAsset)document).size();
		}

		return totalSize;
	}

	/**
	 * Calculates the total size of items in this folder. Does not include
	 * subfolders.
	 */
	public static double sizeKB( SWFolder folder ) {
		return ((double)size( folder )) / 1000d;
	}

	/**
	 * Attempt to construct a legible name, based on the hierarchy
	 */
	public static String nameIncludingHierarchy( SWFolder folder ) {
		NSArray a = USHierarchyUtilities.everyParentNodeReversed( folder, true );
		StringBuffer b = new StringBuffer();

		Enumeration e = a.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWFolder nextElement = (SWFolder)e.nextElement();
			b.append( " - " );
			b.append( nextElement.name() );
		}

		return b.toString();
	}

	/**
	 * Creates a new folder with the given parent folder.
	 */
	public static SWFolder newFolderWithNameAndParentFolder( EOEditingContext ec, String aName, SWFolder parentFolder, String folderEntityName ) {
		SWFolder newFolder = (SWFolder)EOUtilities.createAndInsertInstance( ec, folderEntityName );

		newFolder.setName( aName );
		newFolder.setInheritsPrivileges( SWC.TRUE_INTEGER );

		if( parentFolder != null ) {
			newFolder.addObjectToBothSidesOfRelationshipWithKey( parentFolder, PARENT_KEY );
		}

		return newFolder;
	}

	public static SWFolder subFolderFromPath( SWFolder aFolder, String pathString ) {

		if( pathString == null )
			return null;

		SWFolder workingDirectory = aFolder;
		NSMutableArray pathArray = NSArray.componentsSeparatedByString( pathString, "/" ).mutableClone();
		pathArray.removeObjectAtIndex( pathArray.count() - 1 );

		Enumeration e = pathArray.objectEnumerator();

		while( e.hasMoreElements() ) {
			workingDirectory = subFolderNamed( workingDirectory, ((String)e.nextElement()) );
		}

		return workingDirectory;
	}
}