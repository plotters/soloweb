package is.us.soloweb.forms;

import is.us.soloweb.forms.data.*;
import is.us.util.USEOUtilities;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWFFieldListPalette extends ERXComponent {

	private EOEditingContext ec = session().defaultEditingContext();

	public String fieldString;
	public SWFForm selectedForm;
	public SWFField currentField;
	public SWFField selectedField;

	public SWFFieldListPalette( WOContext context ) {
		super( context );
	}

	public WOComponent addFieldToList() {
		NSMutableArray a = new NSMutableArray( fieldList() );
		a.addObject( selectedField );
		setFieldIDList( (NSArray)a.valueForKey( "fieldID" ) );
		return context().page();
	}

	public WOComponent removeFieldfromList() {
		NSMutableArray a = new NSMutableArray( fieldList() );
		a.removeObject( currentField );
		setFieldIDList( (NSArray)a.valueForKey( "fieldID" ) );
		return context().page();
	}

	private NSArray fieldIDList() {
		return NSPropertyListSerialization.arrayForString( fieldString );
	}

	private void setFieldIDList( NSArray a ) {
		String listString = NSPropertyListSerialization.stringFromPropertyList( a );
		fieldString = listString;
	}

	public NSArray fieldList() {
		return USEOUtilities.fetchObjects( ec, SWFField.class, "fieldID", fieldIDList() );
	}

	public NSArray fieldsToAddToList() {

		if( selectedForm == null )
			return NSArray.EmptyArray;

		NSMutableArray a = new NSMutableArray( selectedForm.fields() );
		a.removeObjectsInArray( fieldList() );
		return a;
	}
}