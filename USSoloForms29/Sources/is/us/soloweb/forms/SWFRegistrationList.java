package is.us.soloweb.forms;

import is.us.soloweb.SWSession;
import is.us.soloweb.forms.data.*;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWFRegistrationList extends ERXComponent {

	private EOEditingContext ec = session().defaultEditingContext();

	public SWFForm selectedForm;
	public SWFRegistration currentRegistration;
	public SWFField currentField;
	public int registrationIndex = 0;
	public int fieldIndex = 0;
	public NSArray _registrationList;
	public WODisplayGroup registrationDG;

	public String currentSearchValue;
	public SWFSearchField currentSearchField;
	public NSMutableDictionary currentSearchArgument;

	private boolean hasLoaded = false;
	private NSDictionary _cacheDictionary;
	private NSMutableArray _searchArguments = new NSMutableArray();
	private NSMutableArray sortOrderings = new NSMutableArray();
	private NSArray _searchFieldList;

	public SWFRegistrationList( WOContext context ) {
		super( context );
	}

	public int registrationIndexDisplay() {
		return registrationIndex + 1;
	}

	public NSMutableArray argumentsFromFixedSearch() {
		NSArray a = SWFUtilities.fixedSearchesForUserAndForm( ec, ((SWSession)session()).solowebUser(), selectedForm );

		if( USArrayUtilities.arrayHasObjects( a ) ) {
			Enumeration<SWFFixedSearch> e = a.objectEnumerator();
			NSMutableArray a2 = new NSMutableArray();

			while( e.hasMoreElements() ) {
				SWFFixedSearch fs = e.nextElement();

				if( fs.field() != null ) {
					SWFSearchField sf = new SWFSearchField();
					sf.field = fs.field();
					sf.name = fs.field().name();

					NSMutableDictionary d = new NSMutableDictionary();
					d.setObjectForKey( sf, "field" );

					if( USStringUtilities.stringHasValue( fs.value() ) )
						d.setObjectForKey( fs.value(), "searchString" );

					d.setObjectForKey( "TRUE", "isFixed" );
					a2.addObject( d );
				}

			}

			return a2;
		}
		else {
			return new NSMutableArray();
		}
	}

	public int currentIndex() {
		return fieldIndex + 1;
	}

	public WOComponent createRecord() {
		SWFRegistration newRegistration = SWFUtilities.registrationFromDictionary( ec, selectedForm, null, null );
		ec.saveChanges();

		NSMutableArray a = new NSMutableArray( registrationList() );
		a.addObject( newRegistration );
		setRegistrationList( a );

		return context().page();
	}

	public WOComponent deleteRegistration() {

		NSMutableArray a = new NSMutableArray( registrationList() );
		a.removeObject( currentRegistration );
		setRegistrationList( a );

		currentRegistration.deleteRegistration();
		ec.saveChanges();

		return context().page();
	}

	/*
	private void uglyHack() {

	}
	*/
	public SWFRegistrationField currentRegistrationField() {
		SWFField f = (SWFField)selectedForm.sortedPrimaryFields().objectAtIndex( fieldIndex );
		return (SWFRegistrationField)_cacheDictionary.valueForKey( "" + f.fieldID() + currentRegistration.registrationID() );
	}

	public NSArray registrationList() {
		return _registrationList;
	}

	public void setRegistrationList( NSArray newRegistrationList ) {
		_registrationList = newRegistrationList;
		populateCache();
	}

	public NSMutableArray searchArguments() {

		if( !hasLoaded ) {
			_searchArguments.addObjectsFromArray( argumentsFromFixedSearch() );
			hasLoaded = true;
		}

		return _searchArguments;
	}

	public void setSearchArguments( NSMutableArray newSearchArguments ) {
		_searchArguments = newSearchArguments;
	}

	public WOComponent addSearchArgument() {
		searchArguments().addObject( new NSMutableDictionary() );
		return context().page();
	}

	public WOComponent removeSearchArgument() {
		searchArguments().removeObject( currentSearchArgument );
		return context().page();
	}

	public WOComponent search() {
		setRegistrationList( SWFUtilities.searchRegistrations( ec, selectedForm, searchArguments() ) );
		return context().page();
	}

	public void populateCache() {
		_cacheDictionary = SWFUtilities.createCacheDictionary( registrationList() );
	}

	public WOComponent showPrintableVersion() {
		SWFPrintableRegistration nextPage = (SWFPrintableRegistration)pageWithName( "SWFPrintableRegistration" );
		nextPage.selectedRegistration = currentRegistration;
		nextPage.setFieldList( currentRegistration.form().sortedFields() );
		return nextPage;
	}

	public WOComponent showEditableVersion() {
		SWFEditRegistration nextPage = (SWFEditRegistration)pageWithName( "SWFEditRegistration" );
		nextPage.setSelectedRegistration( currentRegistration );
		return nextPage;
	}

	public WOComponent exportRegistrations() {
		SWFExportPanel nextPage = (SWFExportPanel)pageWithName( "SWFExportPanel" );
		nextPage.setForm( selectedForm );
		nextPage.setRegistrations( registrationList() );
		return nextPage;
	}

	public boolean allowRemovalOfArgument() {
		boolean isFixed = "TRUE".equals( currentSearchArgument.valueForKey( "isFixed" ) );
		boolean userPrivileged = ((SWSession)session()).solowebUser().hasPrivilegeFor( selectedForm.folder(), "editFormSettings" );

		if( isFixed )
			return userPrivileged;

		return true;
	}

	public boolean canAddMoreArguments() {
		return searchArguments().count() < 5;
	}

	public WOComponent sortByNumber() {
		sortRegistrationsWithKeyPath( "registrationID" );
		return context().page();
	}

	public WOComponent sortByDate() {
		sortRegistrationsWithKeyPath( "date" );
		return context().page();
	}

	public WOComponent sortByField() {
		sortRegistrationsWithKeyPath( "@field." + fieldIndex );
		return context().page();
	}

	public void sortRegistrationsWithKeyPath( String keyPath ) {

		if( sortOrderings.count() == 3 )
			sortOrderings.removeObjectAtIndex( 2 );

		EOSortOrdering s = new EOSortOrdering( keyPath, EOSortOrdering.CompareCaseInsensitiveAscending );
		sortOrderings.insertObjectAtIndex( s, 0 );

		setRegistrationList( EOSortOrdering.sortedArrayUsingKeyOrderArray( registrationList(), sortOrderings ) );
	}

	public NSArray searchFieldList() {
		if( _searchFieldList == null ) {
			_searchFieldList = SWFSearchField.fieldList( selectedForm.sortedFields() );
		}

		return _searchFieldList;
	}

	public WOResponse downloadFile() {
		return USHTTPUtilities.responseWithDataAndMimeType( currentRegistrationField().value(), currentRegistrationField().binaryValue(), null );
	}
}