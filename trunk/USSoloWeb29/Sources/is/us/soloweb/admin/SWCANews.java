package is.us.soloweb.admin;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.client.SoloNewsNewsList;
import is.us.soloweb.data.SWNewsFolder;
import is.us.util.USUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.9.2
 */

public class SWCANews extends SWGenericComponent {

	private EOEditingContext ec = session().defaultEditingContext();

	/**
	 * A variable the iteration in the categories pop-up-menu
	 */
	public SWNewsFolder currentFolder;

	/**
	 * Default constructor
	 */
	public SWCANews( WOContext context ) {
		super( context );
	}

	/**
	 * We set the Template Name for this component in appendToResponse,
	 * so the correct template is automatically selected when the SoloNews tab is selected.
	 */
	public void appendToResponse( WOResponse r, WOContext c ) {
		currentComponent().setTemplateName( SoloNewsNewsList.class.getSimpleName() );
		super.appendToResponse( r, c );
	}

	/**
	 * Returns all SWNewsFolder Objects
	 */
	public NSArray<SWNewsFolder> allCategories() {
		EOFetchSpecification fs = new EOFetchSpecification( SWNewsFolder.ENTITY_NAME, null, null );
		return ec.objectsWithFetchSpecification( fs );
	}

	/**
	 * This method retrieves the "category" selection from the customInfo Dictionary in
	 * the component, and selects the folder object with the corresponding primary key.
	 */
	public SWNewsFolder selectedFolder() {
		Integer folderID = USUtilities.integerFromObject( currentComponent().customInfo().valueForKey( "category" ) );

		if( folderID != null )
			return SWNewsFolder.fetchSWNewsFolder( ec, SWNewsFolder.FOLDER_ID_KEY, folderID );

		return null;
	}

	public void setSelectedFolder( SWNewsFolder folder ) {
		if( folder == null )
			currentComponent().customInfo().takeValueForKey( null, "category" );
		else
			currentComponent().customInfo().takeValueForKey( folder.folderID().toString(), "category" );
	}

	/**
	 * Possible image alignments. 
	 */
	public NSArray<String> imageAlignment() {
		return new NSArray<String>( new String[] { "left", "right" } );
	}

	/**
	 * Possible sort fields. 
	 */
	public NSArray<String> sortKeys() {
		return new NSArray<String>( new String[] { "By date", "Alphabetically", "Random" } );
	}

	/**
	 * Possible sort directions. 
	 */
	public NSArray<String> sortOrderings() {
		return new NSArray<String>( new String[] { "Descending", "Ascending" } );
	}

	/**
	 * TODO: Review!
	 */
	public NSArray<String> componentKeys() {
		return componentsAndKeys().allKeys();
	}

	public NSMutableDictionary<String, String> componentsAndKeys() {
		NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
		d.setObjectForKey( SoloNewsNewsList.class.getSimpleName(), "A list of news" );
		return d;
	}

	public String selectedComponentKey() {
		Enumeration<String> e = componentsAndKeys().objectEnumerator();

		while( e.hasMoreElements() ) {
			String s = e.nextElement();
			if( s.equals( currentComponent().templateName() ) )
				return componentsAndKeys().allKeysForObject( s ).lastObject();
		}

		return null;
	}

	public void setSelectedComponentKey( String newKey ) {
		currentComponent().setTemplateName( (String)componentsAndKeys().valueForKey( newKey ) );
	}
}