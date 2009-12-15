package is.us.soloweb.forms;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFForm;
import is.us.soloweb.util.SWDictionary;
import is.us.util.USArrayUtilities;
import is.us.util.USEOUtilities;
import is.us.util.USUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSPropertyListSerialization;

/**
 * @author Hugi Þórðarson
 */

public class SWFFormAdminComponent extends SWGenericComponent {

	public SWFForm currentForm;
	public String currentTemplate;
	public EOEditingContext ec = session().defaultEditingContext();
	public String currentComponentKey;

	public SWFField currentField;
	public SWFField currentSearchField;

	/**
	 * FIXME: IS this correct???
	 */
	public String currentSearchValue;

	public NSMutableDictionary currentSearchArgument;
	public SWFField selectedSearchArgumentField;
	public String newSearchString;

	public SWFFormAdminComponent( WOContext context ) {
		super( context );
	}

	public NSMutableDictionary<String, String> componentsAndKeys() {
		NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
		d.setObjectForKey( "SWFFormDisplay", "Skráning" );
		d.setObjectForKey( "SWFRegistrationDisplay", "Skráningalisti" );
		return d;
	}

	public NSArray<String> componentKeys() {
		return componentsAndKeys().allKeys();
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

	public NSArray<SWFForm> allObjects() {
		return USEOUtilities.allObjectsForEntitySortedByKey( ec, "SWFForm", "name" );
	}

	public SWFForm selectedForm() {
		return SWFForm.formWithID( ec, formID() );
	}

	public void setSelectedForm( SWFForm f ) {
		if( f != null )
			currentComponent().customInfo().takeValueForKey( f.formID(), "formID" );
	}

	public Integer formID() {
		Object o = currentComponent().customInfo().valueForKey( "formID" );
		return USUtilities.integerFromObject( o );
	}

	private NSArray fieldIDList() {
		return NSPropertyListSerialization.arrayForString( (String)currentComponent().customInfo().valueForKey( "swfListFields" ) );
	}

	private void setFieldIDList( NSArray a ) {
		SWDictionary d = (SWDictionary)currentComponent().customInfo().clone();
		String listString = NSPropertyListSerialization.stringFromPropertyList( a );
		currentComponent().customInfo().setObjectForKey( listString, "swfListFields" );
	}

	public NSArray fieldList() {
		return stringArrayToObjectArray( ec, "SWFField", "fieldID", fieldIDList() );
	}

	public static NSArray stringArrayToObjectArray( EOEditingContext editingContext, String entityName, String key, NSArray objectArray ) {

		if( !USArrayUtilities.arrayHasObjects( objectArray ) )
			return null;

		Enumeration e = objectArray.objectEnumerator();
		NSMutableArray resultArray = new NSMutableArray();

		while( e.hasMoreElements() ) {
			EOEnterpriseObject eo = USEOUtilities.objectMatchingKeyAndValue( editingContext, entityName, key, e.nextElement() );

			if( eo != null )
				resultArray.addObject( eo );
		}

		return resultArray;
	}

	public NSArray fieldsToAddToList() {
		NSMutableArray a = new NSMutableArray( selectedForm().fields() );
		a.removeObjectsInArray( fieldList() );
		return a;
	}

	public NSMutableArray searchArguments() {
		NSMutableArray a = new NSMutableArray();
		NSArray b = NSPropertyListSerialization.arrayForString( (String)currentComponent().customInfo().valueForKey( "swfSearchArguments" ) );

		if( USArrayUtilities.arrayHasObjects( b ) )
			a.addObjectsFromArray( b );

		return a;
	}

	public void setSearchArguments( NSMutableArray newSearchArguments ) {
		SWDictionary d = (SWDictionary)currentComponent().customInfo().clone();
		String listString = NSPropertyListSerialization.stringFromPropertyList( newSearchArguments );
		currentComponent().customInfo().setObjectForKey( listString, "swfSearchArguments" );
	}

	public WOComponent addSearchArgument() {
		NSMutableArray a = searchArguments().mutableClone();

		NSMutableDictionary d = new NSMutableDictionary();
		d.setObjectForKey( selectedSearchArgumentField.fieldID(), "field" );
		d.setObjectForKey( newSearchString, "searchString" );
		selectedSearchArgumentField = null;
		newSearchString = null;
		a.addObject( d );
		setSearchArguments( a );
		return context().page();
	}

	public WOComponent removeSearchArgument() {
		NSMutableArray a = searchArguments().mutableClone();
		a.removeObject( currentSearchArgument );
		setSearchArguments( a );
		return context().page();
	}

	public SWFField currentSearchArgumentField() {
		return (SWFField)USEOUtilities.objectMatchingKeyAndValue( ec, "SWFField", "fieldID", currentSearchArgument.valueForKey( "field" ) );
	}

	public void setCurrentSearchArgumentField( SWFField value ) {
		currentSearchArgument.takeValueForKey( value.fieldID(), "field" );
	}

	public boolean isDisplayComponent() {
		return "SWFRegistrationDisplay".equals( currentComponent().templateName() );
	}

	public void setCurrentComponent() {
		currentComponent().setCustomInfo( (SWDictionary)currentComponent().customInfo().clone() );
	}
}
