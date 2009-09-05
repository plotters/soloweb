package is.us.soloweb.util;

import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.SWFolder;
import is.us.util.USStringUtilities;

import java.io.File;
import java.util.Enumeration;
import java.util.zip.*;

import org.slf4j.*;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

/**
 * This class combines functionality for extracting data from Zip-archives
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.8
 */

public class SWZipUtilities {

	private static final Logger logger = LoggerFactory.getLogger( SWZipUtilities.class );

	public static void expandZipFileAndInsertIntoFolder( EOEditingContext ec, File file, SWFolder folder, String entityName, String folderEntityName ) {

		ZipFile zipFile = null;

		try {
			zipFile = new ZipFile( file );
			Enumeration e = zipFile.entries();
			Enumeration e2 = zipFile.entries();
			ZipEntry z;

			while( e.hasMoreElements() ) {
				z = (ZipEntry)e.nextElement();

				if( z.isDirectory() )
					generateFolderStructureForStringWithParentFolder( ec, z.getName(), folder, folderEntityName );
			}

			while( e2.hasMoreElements() ) {
				z = (ZipEntry)e2.nextElement();

				if( !z.isDirectory() )
					insertAsset( ec, z.getName(), new NSData( zipFile.getInputStream( z ), 4096 ), folder, entityName );
			}
		}
		catch( Exception e ) {
			logger.error( "Cannot expand zip file", e );
		}
		finally {
			try {
				zipFile.close();
			}
			catch( Exception e ) {
				logger.error( "Cannot expand zip file", e );
			}
		}

		ec.saveChanges();
	}

	private static SWFolder generateFolderStructureForStringWithParentFolder( EOEditingContext ec, String aString, SWFolder parentFolder, String folderEntityName ) {

		SWFolder workingDirectory = parentFolder;
		NSMutableArray pathArray = NSArray.componentsSeparatedByString( aString, "/" ).mutableClone();
		pathArray.removeObjectAtIndex( pathArray.count() - 1 );
		Enumeration e = pathArray.objectEnumerator();

		while( e.hasMoreElements() ) {
			String folderName = ((String)e.nextElement());
			SWFolder currentFolder = SWFolderUtilities.subFolderNamed( workingDirectory, folderName );

			if( currentFolder == null )
				workingDirectory = SWFolderUtilities.newFolderWithNameAndParentFolder( ec, folderName, workingDirectory, folderEntityName );
			else
				workingDirectory = currentFolder;
		}

		return workingDirectory;
	}

	/**
	 * FIXME: This whole class is bogus, it only supports SWDocuments. 
	 */
	private static void insertAsset( EOEditingContext ec, String path, NSData data, SWFolder parentFolder, String entityName ) {

		String newName = USStringUtilities.fileNameFromPath( path );
		SWFolder directory = SWFolderUtilities.subFolderFromPath( parentFolder, path );

		SWDocument newAsset = (SWDocument)EOUtilities.createAndInsertInstance( ec, entityName );

		newAsset.setName( newName );
		newAsset.setData( data );

		newAsset.setFolder( (SWDocumentFolder)directory );
	}
}