package is.us.soloweb.admin;

import is.us.soloweb.*;
import is.us.soloweb.client.*;
import is.us.soloweb.data.SWDocument;
import is.us.util.USUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.9.2
 */

public class SWCADocuments extends SWGenericComponent {

	private static final String DOCUMENT_ID_STRING = "documentID";

	public SWCADocuments( WOContext c ) {
		super( c );
	}

	public NSArray<String> componentKeys() {
		return componentsAndKeys().allKeys();
	}

	public NSMutableDictionary<String, String> componentsAndKeys() {
		NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
		d.setObjectForKey( SWSFComponent.class.getSimpleName(), SWLoc.string( "docComponentSingleDocument", session() ) );
		d.setObjectForKey( SWSFFileList.class.getSimpleName(), SWLoc.string( "docComponentListOfDocuments", session() ) );
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

	public SWDocument selectedDocument() {
		return SWDocument.documentWithID( session().defaultEditingContext(), documentIDFromDictionary() );
	}

	public void setSelectedDocument( SWDocument document ) {

		if( document == null )
			currentComponent().customInfo().takeValueForKey( null, DOCUMENT_ID_STRING );
		else
			currentComponent().customInfo().takeValueForKey( document.documentID().toString(), DOCUMENT_ID_STRING );
	}

	public Integer documentIDFromDictionary() {
		Object o = currentComponent().customInfo().valueForKey( DOCUMENT_ID_STRING );
		return USUtilities.integerFromObject( o );
	}

	public WOActionResults self() {
		return this;
	}
}