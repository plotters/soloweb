package is.us.soloweb.admin;

import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.SWInspectionComponent;
import is.us.soloweb.util.SWURLGeneration;
import is.us.util.*;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * For editing of documents.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 */

public class SWEditDocument extends SWInspectionComponent<SWDocument> {

	private static final String EXT_PNG = "png";
	private static final String EXT_GIF = "gif";
	private static final String EXT_JPG = "jpg";
	private static final String EXT_TXT = "txt";
	private static final String EXT_ZIP = "zip";

	/**
	 * The name of the file currently being uploaded from disk.
	 */
	public String filename;

	/**
	 * The content data of the picture being uploaded to the server.
	 */
	public NSData data;

	/**
	 * The url to fetch data from.
	 */
	public String urlToFetchDataFrom;

	/**
	 * The document type currently being iterated through in the list
	 */
	public SWDocumentType currentDocumentType;

	public SWEditDocument( WOContext context ) {
		super( context );
	}

	public NSArray<SWDocumentType> documentTypes() {
		return SWDocumentType.allDocumentTypes( ec() );
	}

	/**
	 * Uploads data and saves changes
	 */
	public WOActionResults saveChanges() {

		NSData finalData = null;
		String finalName = null;

		if( USStringUtilities.stringHasValue( urlToFetchDataFrom ) ) {
			finalData = new NSData( USDataUtilities.readBytesFromURL( urlToFetchDataFrom ) );
			finalName = urlToFetchDataFrom;
			urlToFetchDataFrom = null;
		}

		if( data != null ) {
			if( data.length() != 0 ) {
				finalData = data;
				finalName = filename;
			}
		}

		if( finalData != null ) {
			selectedObject().setData( finalData );
			selectedObject().setDocumentType( SWDocumentType.documentTypeFromPath( ec(), finalName ) );

			if( !USStringUtilities.stringHasValue( selectedObject().name() ) && USStringUtilities.stringHasValue( finalName ) )
				selectedObject().setName( USStringUtilities.fileNameFromPath( finalName ) );
		}

		return super.saveChanges();
	}

	/**
	 * Edits a document, based on its type. 
	 */
	public WOActionResults edit() {
		Class<? extends SWDocEditGeneric> editComponentClass = null;
		String documentName = selectedObject().name();

		if( documentName != null ) {
			if( documentName.toLowerCase().endsWith( EXT_ZIP ) )
				editComponentClass = SWDocEditZip.class;

			if( documentName.toLowerCase().endsWith( EXT_TXT ) )
				editComponentClass = SWDocEditText.class;

			if( documentName.toLowerCase().endsWith( EXT_JPG ) || documentName.toLowerCase().endsWith( EXT_GIF ) || documentName.toLowerCase().endsWith( EXT_PNG ) )
				editComponentClass = SWDocEditPicture.class;
		}

		if( editComponentClass == null ) {
			editComponentClass = SWDocEditText.class;
		}

		SWDocEditGeneric nextPage = pageWithName( editComponentClass );
		nextPage.setDocument( selectedObject() );
		return nextPage;
	}

	/**
	 * @return The URL for the selected document.
	 */
	public String documentURL() {
		return SWURLGeneration.urlForObjectInContext( selectedObject(), context() );
	}
}