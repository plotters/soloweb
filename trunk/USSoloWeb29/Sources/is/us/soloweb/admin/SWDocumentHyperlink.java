package is.us.soloweb.admin;

import is.us.soloweb.data.*;
import is.us.util.USUtilities;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSKeyValueCoding;

import er.extensions.components.ERXComponent;
import er.extensions.foundation.ERXStringUtilities;

/**
 * Use this component to select an SWDocument to use. To use this component,
 * include it in your page, and specify a record to connect to a picture, the
 * name of the relationship pointing to the SWDocument, and an instance of a
 * WOComponent to return to, once picture selection has been completed.
 * 
 * @author Hugi Þórðarson
 * @since 2.5
 */

public class SWDocumentHyperlink extends ERXComponent {

	/**
	 * The record to bind to an SWPicture
	 */
	public NSKeyValueCoding record;

	/**
	 * Indicates if we should set an ID, rather than an SWDocument object.
	 */
	public boolean useID = false;

	/**
	 * The name of the relationship that points to the SWDocument
	 */
	public String fieldName;

	/**
	 * A WOComponent instance to return after picture selection has been
	 * completed
	 */
	public WOComponent componentToReturn;

	/**
	 * A unique identifier for this object.
	 */
	private String _uniqueIdentifier;

	public SWDocumentHyperlink( WOContext context ) {
		super( context );
	}

	/**
	 * The method invoked when the user clicks the "select picture" button.
	 * Takes the user to "SWSelectAsset" where a picture can be selected.
	 */
	public WOActionResults selectDocument() {

		SWAssetManagement nextPage = pageWithName( SWAssetManagement.class );

		if( componentToReturn == null )
			componentToReturn = context().page();

		nextPage.setEntityName( SWDocument.class.getSimpleName() );
		nextPage.setFolderEntityName( SWDocumentFolder.class.getSimpleName() );
		nextPage.setEditingComponentName( SWEditDocument.class.getSimpleName() );
		nextPage.setComponentToReturn( componentToReturn );
		nextPage.setRecord( record );
		nextPage.setFieldName( fieldName );
		nextPage.setUseID( useID );
		nextPage.setSelectedObject( selectedDocument() );

		return nextPage;
	}

	/**
	 * returns the currently selected document (if any)
	 */
	public SWDocument selectedDocument() {

		if( record == null )
			return null;

		Object o = record.valueForKey( fieldName );

		if( !useID ) {
			return (SWDocument)o;
		}
		else {
			Integer i = USUtilities.integerFromObject( o );
			return SWDocument.documentWithID( session().defaultEditingContext(), i );
		}
	}

	public WOActionResults nullifyDocument() {
		record.takeValueForKey( null, fieldName );
		session().defaultEditingContext().saveChanges();
		return null;
	}

	public String uniqueIdentifier() {
		if( _uniqueIdentifier == null ) {
			_uniqueIdentifier = ERXStringUtilities.safeIdentifierName( String.valueOf( System.currentTimeMillis() ), name() );
		}

		return _uniqueIdentifier;
	}
}