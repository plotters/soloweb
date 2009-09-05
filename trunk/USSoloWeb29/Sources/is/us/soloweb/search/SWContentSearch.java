package is.us.soloweb.search;

import is.us.soloweb.data.*;
import is.us.soloweb.util.SWC;
import is.us.util.*;

import java.util.Enumeration;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * SWContentSearch allows you to search the contents in a SoloWeb using a single object.
 * In it's current incarnation, the search does a brute force search of the database, returning
 * all pages, even ones not published. If different functionality is required, the user
 * will have to construct a new EOQualifier and filter out undesirable objects.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.5
 */

public class SWContentSearch {

	private Integer _branchID;
	private String _searchString;
	private EOEditingContext _editingContext;
	private NSArray<EOSortOrdering> _sortOrderings = new NSArray<EOSortOrdering>( new EOSortOrdering( "name", EOSortOrdering.CompareAscending ) );

	/**
	 * The default constructor if you want to search the entire contents of the SoloWeb system, all sites, all content.
	 *
	 * @param editingContext The editing context to fetch the objects into
	 * @param string The string to search for
	 */
	public SWContentSearch( EOEditingContext newEditingContext, String newSearchString ) {
		setEditingContext( newEditingContext );
		setSearchString( newSearchString );
	}

	/**
	 * The default constructor if you want to search a branch in the SoloWeb site.
	 *
	 * @param editingContext The editing context to fetch the objects into
	 * @param string The string to search for
	 * @param branchID The ID of the branch (SWPage object) you want to search below in the  hierarchy. The object specified by branchID is included in the search hierarchy.
	 */
	public SWContentSearch( EOEditingContext newEditingContext, String newSearchString, Integer newBranchID ) {
		setEditingContext( newEditingContext );
		setSearchString( newSearchString );
		setBranchID( newBranchID );
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
	 * Sets the branch to search
	 *
	 * @param newSearchString The ID of the branch to search
	 */
	public void setBranchID( Integer newBranchID ) {
		_branchID = newBranchID;
	}

	public Integer branchID() {
		return _branchID;
	}

	/**
	 * Creates the qualifier that's used to search the content.
	 *
	 * @param string The string to search for
	 * @param attributeNames The attributes to search
	 */
	private static EOQualifier stringContainedInAttributes( String string, NSArray<String> attributeNames ) {
		NSMutableArray<EOQualifier> qualArray = new NSMutableArray<EOQualifier>();
		Enumeration<String> e = attributeNames.objectEnumerator();

		while( e.hasMoreElements() ) {
			String attributeName = e.nextElement();
			qualArray.addObject( new EOKeyValueQualifier( attributeName, EOQualifier.QualifierOperatorCaseInsensitiveLike, "*" + string + "*" ) );
		}

		return new EOOrQualifier( qualArray );
	}

	/**
	 * Returns the components found by searching
	 */
	private NSArray<SWComponent> components() {

		// FrontBase:
		NSArray searchKeyPaths = new NSArray( new Object[] { "textOne", "textTwo", "page.name", "page.text", "page.keywords" } );

		// ORACLE og MSSQL:				
		//		NSArray<String> searchKeyPaths = new NSArray<String>( new String[] { "page.name", "page.text", "page.keywords" } );

		EOQualifier textQualifier = stringContainedInAttributes( _searchString, searchKeyPaths );
		EOQualifier publishedQualifier = new EOKeyValueQualifier( "published", EOQualifier.QualifierOperatorEqual, SWC.TRUE_INTEGER );
		EOQualifier andQual = new EOAndQualifier( new NSArray<EOQualifier>( new EOQualifier[] { textQualifier, publishedQualifier } ) );

		EOFetchSpecification fs = new EOFetchSpecification( SWComponent.ENTITY_NAME, andQual, null );

		return _editingContext.objectsWithFetchSpecification( fs );
	}

	/**
	 * Returns pages found by a brute force search of the entire SoloWeb system.
	 */
	private NSArray<SWPage> results() {

		NSMutableSet<SWPage> pageSet = new NSMutableSet<SWPage>();
		Enumeration<SWComponent> componentEnumerator = components().objectEnumerator();

		while( componentEnumerator.hasMoreElements() ) {
			SWComponent aComponent = componentEnumerator.nextElement();
			pageSet.addObject( aComponent.page() );
		}

		Enumeration<SWPage> pageEnumerator = pageSet.allObjects().objectEnumerator();
		NSMutableArray<SWPage> resultArray = new NSMutableArray<SWPage>();

		while( pageEnumerator.hasMoreElements() ) {
			SWPage aPage = pageEnumerator.nextElement();

			if( aPage.isAccessible() )
				resultArray.addObject( aPage );
		}

		EOSortOrdering.sortArrayUsingKeyOrderArray( resultArray, sortOrderings() );

		return resultArray.immutableClone();
	}

	/**
	 * Searches only the branch specified by branchID.
	 *
	 * @param branchID The ID of the branch (SWPage object) you want to search below in the  hierarchy. The object specified by branchID is included in the search hierarchy.
	 */
	private NSArray<SWPage> searchBranch( Integer branchNumber ) {
		SWPage parentPage = (SWPage)USEOUtilities.objectMatchingKeyAndValue( _editingContext, SWPage.ENTITY_NAME, SWPage.PAGE_ID_KEY, branchNumber );
		NSMutableArray<SWPage> anArray = new NSMutableArray<SWPage>();

		Enumeration<SWPage> pageEnumerator = results().objectEnumerator();

		while( pageEnumerator.hasMoreElements() ) {
			SWPage page = pageEnumerator.nextElement();

			if( parentPage.isParentPageOfPage( page, true ) )
				anArray.addObject( page );
		}

		return anArray;
	}

	public NSArray<EOSortOrdering> sortOrderings() {
		return _sortOrderings;
	}

	/**
	 * Sets an array of EOSortOrderings used to sort the pages fetched.
	 * The default is to sort ascendingly by name.
	 *
	 * @param newSortOrderings The array of sortorderings
	 */
	public void setSortOrderings( NSArray<EOSortOrdering> newSortOrderings ) {
		_sortOrderings = newSortOrderings;
	}

	/**
	 * Performs a search of pages, searching only the specified branch if any
	 */
	public NSArray<SWPage> search() {

		if( !USStringUtilities.stringHasValue( _searchString ) ) {
			return null;
		}

		if( branchID() != null ) {
			return searchBranch( branchID() );
		}

		return results();
	}
}