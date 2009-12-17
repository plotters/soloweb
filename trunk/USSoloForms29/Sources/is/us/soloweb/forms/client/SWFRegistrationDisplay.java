package is.us.soloweb.forms.client;

import is.us.soloweb.forms.SWFFormAdminComponent;
import is.us.soloweb.forms.SWFSearchField;
import is.us.soloweb.forms.SWFUtilities;
import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFRegistration;
import is.us.soloweb.forms.data.SWFRegistrationField;
import is.us.util.USEOUtilities;
import is.us.util.USStringUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSPropertyListSerialization;

/**
 * @author Hugi Þórðarson
 */

public class SWFRegistrationDisplay extends SWFFormAdminComponent {

	public int registrationIndex = 0;
	public int fieldIndex = 0;
	public SWFRegistration currentRegistration;
	public String currentSearchValue;

	private NSDictionary _cacheDictionary;
	private NSArray _registrations;
	public NSMutableArray additionalSearchArguments = new NSMutableArray();
	public String registrationID;
	public SWFSearchField aSearchField;

	public SWFRegistrationDisplay( WOContext context ) {
		super( context );
	}

	public SWFRegistrationField currentRegistrationField() {
		SWFField f = (SWFField)fieldList().objectAtIndex( fieldIndex );
		return (SWFRegistrationField)_cacheDictionary.valueForKey( "" + f.fieldID() + currentRegistration.registrationID() );
	}

	public NSArray fieldList() {
		return USEOUtilities.fetchObjects( ec, SWFField.class, "fieldID", fieldIDList() );
	}

	private NSArray fieldIDList() {
		return NSPropertyListSerialization.arrayForString( (String)currentComponent().customInfo().valueForKey( "swfFieldList" ) );
	}

	public NSArray searchFieldList() {
		return SWFSearchField.fieldList( USEOUtilities.fetchObjects( ec, SWFField.class, "fieldID", searchFieldIDList() ) );
	}

	private NSArray searchFieldIDList() {
		return NSPropertyListSerialization.arrayForString( (String)currentComponent().customInfo().valueForKey( "swfSearchFieldList" ) );
	}

	public NSArray registrations() {
		if( _registrations == null ) {
			setRegistrations( SWFUtilities.searchRegistrations( ec, selectedForm(), convertedSearchArguments() ) );
		}

		return _registrations;
	}

	public void setRegistrations( NSArray value ) {
		_registrations = value;
		populateCache();
	}

	public void setCurrentSearchValue( String value ) {
		currentSearchValue = value;

		if( USStringUtilities.stringHasValue( value ) ) {
			NSMutableDictionary d = new NSMutableDictionary();
			d.setObjectForKey( aSearchField, "field" );
			d.setObjectForKey( value, "searchString" );
			additionalSearchArguments.addObject( d );
		}
	}

	public WOComponent search() {
		NSArray searchArray = additionalSearchArguments.arrayByAddingObjectsFromArray( convertedSearchArguments() );
		NSArray a = SWFUtilities.searchRegistrations( ec, selectedForm(), searchArray );
		setRegistrations( a );
		return context().page();
	}

	public void populateCache() {
		_cacheDictionary = SWFUtilities.createCacheDictionary( registrations() );
	}

	public NSMutableArray convertedSearchArguments() {
		NSMutableArray a = searchArguments();
		NSMutableArray result = new NSMutableArray();

		Enumeration e = a.objectEnumerator();

		while( e.hasMoreElements() ) {
			NSDictionary d = (NSDictionary)e.nextElement();
			NSMutableDictionary arg = new NSMutableDictionary();
			SWFSearchField sf = new SWFSearchField();
			sf.field = (SWFField)USEOUtilities.objectMatchingKeyAndValue( ec, "SWFField", "fieldID", d.objectForKey( "field" ) );
			sf.name = sf.field.name();

			arg.setObjectForKey( sf, "field" );
			arg.setObjectForKey( d.objectForKey( "searchString" ), "searchString" );
			result.addObject( arg );
		}

		return result;
	}

	public int registrationIndexDisplay() {
		return registrationIndex + 1;
	}
}