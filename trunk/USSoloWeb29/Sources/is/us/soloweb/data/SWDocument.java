package is.us.soloweb.data;

import is.us.soloweb.SWSettings;
import is.us.soloweb.data.auto._SWDocument;
import is.us.soloweb.interfaces.SWAsset;
import is.us.soloweb.util.*;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import java.io.*;

import org.slf4j.*;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * An SWDocument represents a binary document.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.7
 */

public class SWDocument extends _SWDocument implements SWAsset<SWDocumentFolder> {

	private static final Logger logger = LoggerFactory.getLogger( SWDocument.class );

	private String _documentLocationOnDisk = SWSettings.documentLocationOnDisk();
	private NSData _temporaryData = null;

	public SWDocument() {
		initDocumentWatcher();
	}

	private void initDocumentWatcher() {
		NSSelector<Void> saveSelector = new NSSelector<Void>( "writeTemporaryDataToDiskIfRequired", new Class[] { NSNotification.class } );
		NSNotificationCenter.defaultCenter().addObserver( this, saveSelector, EOEditingContext.EditingContextDidSaveChangesNotification, null );
	}

	/**
	 * @return The full path to the document on disk
	 * 
	 *         Warning: Data storage should be implementation agnostic, so use
	 *         data() where possible.
	 */
	private String path() {
		return _documentLocationOnDisk + documentID();
	}

	/**
	 * @return The file on disk
	 * 
	 *         Warning: Data storage will become implementation agnostic, so use
	 *         data() where possible.
	 */
	private File file() {
		return new File( path() );
	}

	/**
	 * @return The document's data
	 */
	public NSData data() {
		if( documentID() == null ) {
			return _temporaryData;
		}

		byte[] b = USDataUtilities.readBytesFromFile( file() );

		if( b == null )
			return NSData.EmptyData;

		return new NSData( b );

	}

	/**
	 * Sets the document's data
	 */
	public void setData( NSData newData ) {

		if( documentID() == null ) {
			_temporaryData = newData;
		}
		else {
			USDataUtilities.writeBytesToFile( newData.bytes(), file() );
		}
	}

	/**
	 * Synchronizes the data on disk. This method is called by the frameworks
	 * and should not be invoked by a framework consumer.
	 */
	public void writeTemporaryDataToDiskIfRequired( NSNotification n ) {
		if( _temporaryData != null && documentID() != null ) {
			USDataUtilities.writeBytesToFile( _temporaryData.bytes(), file() );
			_temporaryData = null;
		}
	}

	/**
	 * @return The asset's size in bytes.
	 */
	public long size() {
		File f = file();

		if( f.exists() )
			return (int)f.length();

		if( _temporaryData != null )
			return _temporaryData.length();

		return 0;
	}

	/**
	 * @return The asset's size in kibibytes.
	 */
	public double sizeKB() {
		return size() / 1000d;
	}

	/**
	 * @return The document matching the specified ID
	 * 
	 * @param ec The EOEditingContext to fetch into
	 * @param id The ID of the document to fetch
	 */
	public static SWDocument documentWithID( EOEditingContext ec, Integer id ) {
		return (SWDocument)USEOUtilities.objectMatchingKeyAndValue( ec, SWDocument.ENTITY_NAME, SWDocument.DOCUMENT_ID_KEY, id );
	}

	/**
	 * @return A universally acceptable (downloadable) name for the document.
	 */
	public String nameForDownload() {
		return USHTTPUtilities.makeFilenameURLFriendly( name(), extension() );
	}

	/**
	 * Deletes this document from the DB and it's data from the disk
	 */
	public void deleteAsset() {

		if( file() != null ) {
			file().delete();
		}

		removeObjectFromBothSidesOfRelationshipWithKey( folder(), FOLDER_KEY );
		editingContext().deleteObject( this );
	}

	/**
	 * Implementation of SWTransferable
	 */
	public void transferOwnership( EOEnterpriseObject newOwner ) {
		removeObjectFromBothSidesOfRelationshipWithKey( folder(), FOLDER_KEY );
		addObjectToBothSidesOfRelationshipWithKey( newOwner, FOLDER_KEY );
	}

	/**
	 * Returns the full URL for downloading this document through the Appserver
	 */
	public String documentURL( WOContext context ) {
		return SWURLGeneration.urlForObjectInContext( this, context );
	}

	public Number assetID() {
		return documentID();
	}

	/**
	 * Expands this document's zip data.
	 */
	public void expandZip() {
		SWZipUtilities.expandZipFileAndInsertIntoFolder( editingContext(), file(), folder(), SWDocument.ENTITY_NAME, SWDocumentFolder.ENTITY_NAME );
	}

	/**
	 * Indicates if this document has non-null data( with some length as well).
	 */
	public boolean hasData() {
		if( file().exists() && file().length() > 0 )
			return true;

		if( _temporaryData != null && _temporaryData.length() > 0 )
			return true;

		return false;
	}

	/**
	 * FIXME: Implement in the database.
	 */
	public NSTimestamp date() {
		return null;
	}

	/**
	 * FIXME: Implement in the database.
	 */
	public void setDate( NSTimestamp date ) {
		;
	}

	/**
	 * Attempts to convert the stored data to a String using UTF-8 encoding.
	 */
	public String string() {
		NSData data = data();

		if( data == null )
			return null;

		if( data.length() == 0 )
			return SWC.EMPTY_STRING;

		return USStringUtilities.stringFromDataUsingEncoding( data.bytes(), SWC.ENCODING_UTF_8 );
	}

	/**
	 * Stores the given string as binary data using UTF-8 encoding.
	 */
	public void setString( String s ) {
		if( s == null ) {
			setData( null );
		}
		else {
			try {
				setData( new NSData( s.getBytes( SWC.ENCODING_UTF_8 ) ) );
			}
			catch( UnsupportedEncodingException e ) {
				logger.debug( "Can't convert string to data using encoding UTF-8", e );
			}
		}
	}

	/**
	 * @return The name of the icon file for this document.
	 */
	public String icon() {
		if( extension() != null )
			return "ext/" + extension() + ".png";

		return null;
	}

	/**
	 * @return The file's extension. If there is no stored extension, we fetch
	 *         it from the document's name.
	 */
	@Override
	public String extension() {
		String storedExtension = super.extension();

		if( storedExtension == null ) {
			return NSPathUtilities.pathExtension( name() );
		}

		return storedExtension;
	}
}