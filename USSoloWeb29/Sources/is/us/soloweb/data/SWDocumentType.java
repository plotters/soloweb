package is.us.soloweb.data;

import is.us.soloweb.interfaces.SWInspectable;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * An SWDocumentType represents a document type in SoloWeb
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.7
 * 
 * FIXME: Eliminate and replace with SWMimeType.
 */

public class SWDocumentType extends _SWDocumentType implements SWInspectable {

	private static final NSArray<EOSortOrdering> DEFAULT_SORT_ORDERINGS = new NSArray<EOSortOrdering>( new EOSortOrdering( "name", EOSortOrdering.CompareCaseInsensitiveAscending ) );
	private static final EOFetchSpecification ALL_TYPES_FS = new EOFetchSpecification( "SWDocumentType", null, DEFAULT_SORT_ORDERINGS );

	/**
	 * Returns all documentType objects in the database, sorted by name
	 *
	 * @param ec The EOEditingContext to fetch into
	 */
	public static NSArray<SWDocumentType> allDocumentTypes( EOEditingContext ec ) {
		return ec.objectsWithFetchSpecification( ALL_TYPES_FS );
	}

	/**
	 * Takes the given string, finds the extension and returns the appropriate document type, or null, if none is found.
	 *
	 * @param ec The EOEditingContext to fetch the documentType into
	 * @param path The Path to look at
	 */
	public static SWDocumentType documentTypeFromPath( EOEditingContext ec, String path ) {
		String extension = NSPathUtilities.pathExtension( path );
		return documentTypeWithExtension( ec, extension );
	}

	/**
	 * Takes the given extension and returns the appropriate document type, or null, if none is found.
	 *
	 * @param ec The EOEditingContext to fetch the documentType into
	 * @param extension The extension to search for ("pdf", "xls", etc).
	 */
	public static SWDocumentType documentTypeWithExtension( EOEditingContext ec, String extension ) {
		EOQualifier q = new EOKeyValueQualifier( "extension", EOQualifier.QualifierOperatorCaseInsensitiveLike, extension );
		EOFetchSpecification fs = new EOFetchSpecification( "SWDocumentType", q, null );
		return (SWDocumentType)ec.objectsWithFetchSpecification( fs ).lastObject();
	}
}