package is.us.soloweb.search;

import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.util.SWC;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * SWNewsSearch allows you to search the contents of SoloWeb news.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.5
 */

public class SWNewsSearch extends Object {

	private Integer _folderID;
	private String _searchString;
	private EOEditingContext _editingContext;
	private NSArray<EOSortOrdering> _sortOrderings = new NSArray<EOSortOrdering>( new EOSortOrdering( "date", EOSortOrdering.CompareDescending ) );

	/**
	 * The default constructor if you want to search all news in the SoloWeb site
	 *
	 * @param editingContext The editing context to fetch the objects into
	 * @param string The string to search for
	 */
	public SWNewsSearch( EOEditingContext newEditingContext, String string ) {
		setEditingContext( newEditingContext );
		setSearchString( string );
	}

	/**
	 * The default constructor if you want to search a specific folder in the SoloWeb site.
	 *
	 * @param editingContext The editing context to fetch the objects into
	 * @param string The string to search for
	 * @param folderID The ID of the news folder to search
	 */
	public SWNewsSearch( EOEditingContext newEditingContext, String string, Integer folderID ) {
		setEditingContext( newEditingContext );
		setSearchString( string );
		setFolderID( folderID );
	}

	/**
	 * Sets the EditingContext to fetch the objects into
	 *
	 * @param newEditingContext The editingConrtext to fetch into
	 */
	public void setEditingContext( EOEditingContext newEditingContext ) {
		_editingContext = newEditingContext;
	}

	public EOEditingContext editingContext() {
		return _editingContext;
	}

	/**
	 * Sets the string to search for
	 *
	 * @param newSearchString The string to search for
	 */
	public void setSearchString( String newSearchString ) {
		_searchString = newSearchString;
	}

	public String searchString() {
		return _searchString;
	}

	/**
	 * Sets the folder to search
	 *
	 * @param folderID ID of the folder to search
	 */
	public void setFolderID( Integer folderID ) {
		_folderID = folderID;
	}

	public Integer folderID() {
		return _folderID;
	}

	public NSArray<EOSortOrdering> sortOrderings() {
		return _sortOrderings;
	}

	/**
	 * Sets an array of EOSortOrderings used to sort the newsitems fetched.
	 * The default is to sort descendingly by date.
	 *
	 * @param newSortOrderings The array of sortorderings
	 */
	public void setSortOrderings( NSArray<EOSortOrdering> newSortOrderings ) {
		_sortOrderings = newSortOrderings;
	}

	public NSArray<SWNewsItem> search() {

		EOQualifier q1 = containsQualifierForAttributeAndString( SWNewsItem.NAME_KEY, searchString() );
		EOQualifier q2 = containsQualifierForAttributeAndString( SWNewsItem.EXCERPT_KEY, searchString() );
		EOQualifier q3 = containsQualifierForAttributeAndString( SWNewsItem.TEXT_KEY, searchString() );

		NSMutableArray<EOQualifier> qualifierArray = new NSMutableArray<EOQualifier>();
		qualifierArray.addObject( q1 );
		qualifierArray.addObject( q2 );
		qualifierArray.addObject( q3 );
		EOOrQualifier orQual = new EOOrQualifier( qualifierArray );

		qualifierArray = new NSMutableArray<EOQualifier>();
		qualifierArray.addObject( orQual );
		EOQualifier q4 = new EOKeyValueQualifier( SWNewsItem.PUBLISHED_KEY, EOQualifier.QualifierOperatorEqual, SWC.TRUE_INTEGER );
		qualifierArray.addObject( q4 );

		if( folderID() != null )
			qualifierArray.addObject( new EOKeyValueQualifier( SWNewsItem.FOLDER_ID_KEY, EOQualifier.QualifierOperatorEqual, folderID() ) );

		EOAndQualifier andQual = new EOAndQualifier( qualifierArray );

		EOFetchSpecification fs = new EOFetchSpecification( SWNewsItem.class.getSimpleName(), andQual, sortOrderings() );

		return editingContext().objectsWithFetchSpecification( fs );
	}

	/**
	 * Creates a qualifier that chacks if a text attribute contains the given substring. 
	 */
	private static EOQualifier containsQualifierForAttributeAndString( String attributeName, String searchString ) {
		return new EOKeyValueQualifier( attributeName, EOQualifier.QualifierOperatorCaseInsensitiveLike, "*" + searchString + "*" );
	}
}
