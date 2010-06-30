package is.us.soloweb.forms.client;

import is.us.soloweb.forms.*;
import is.us.soloweb.forms.data.*;
import is.us.util.*;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * For diplaying form contents on the client side.
 * 
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

	/**
	 * 
	 * @return
	 */
	public SWFRegistrationField currentRegistrationField() {
		SWFField f = (SWFField)fieldList().objectAtIndex( fieldIndex );
		return (SWFRegistrationField)_cacheDictionary.valueForKey( "" + f.fieldID() + currentRegistration.registrationID() );
	}

	/**
	 * 
	 */
	@Override
	public NSArray fieldList() {
		return USEOUtilities.objectsMatchingKeyAndValues( ec, SWFField.class, "fieldID", SWFUtilities.convertElementsToIntegers( fieldIDList() ) );
	}

	/**
	 * 
	 * @return
	 */
	private NSArray fieldIDList() {
		return NSPropertyListSerialization.arrayForString( (String)currentComponent().customInfo().valueForKey( "swfFieldList" ) );
	}

	/**
	 * 
	 * @return
	 */
	public NSArray searchFieldList() {
		return SWFSearchField.fieldList( USEOUtilities.objectsMatchingKeyAndValues( ec, SWFField.class, "fieldID", searchFieldIDList() ) );
	}

	/**
	 * 
	 * @return
	 */
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

	/**
	 * 
	 * @return
	 */
	public WOComponent search() {
		NSArray searchArray = additionalSearchArguments.arrayByAddingObjectsFromArray( convertedSearchArguments() );
		NSArray a = SWFUtilities.searchRegistrations( ec, selectedForm(), searchArray );
		setRegistrations( a );
		return context().page();
	}

	/**
	 * 
	 */
	public void populateCache() {
		_cacheDictionary = SWFUtilities.createCacheDictionary( registrations() );
	}

	/**
	 * 
	 * @return
	 */
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

	/**
	 * 
	 * @return
	 */
	public int registrationIndexDisplay() {
		return registrationIndex + 1;
	}
}