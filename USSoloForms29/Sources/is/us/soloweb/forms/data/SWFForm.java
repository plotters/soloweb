package is.us.soloweb.forms.data;

import is.us.soloweb.forms.SWFFieldContainer;
import is.us.soloweb.forms.data.auto._SWFForm;
import is.us.soloweb.interfaces.*;
import is.us.util.*;

import java.util.Enumeration;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 */

public class SWFForm extends _SWFForm implements SWAsset, SWFFieldContainer, SWInspectable {

	public NSArray<SWFField> sortedFields() {
		NSMutableArray<EOSortOrdering> sortOrderings = new NSMutableArray<EOSortOrdering>();

		if( USArrayUtilities.arrayHasObjects( fieldSets() ) ) {
			sortOrderings.addObject( new EOSortOrdering( "fieldSet.sortNumber", EOSortOrdering.CompareAscending ) );
		}

		sortOrderings.addObject( new EOSortOrdering( "sortNumber", EOSortOrdering.CompareAscending ) );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( fields(), sortOrderings );
	}

	public NSArray<SWFField> sortedFieldsExcludingAdminFields() {
		Enumeration<SWFField> e = sortedFields().objectEnumerator();
		NSMutableArray<SWFField> fieldArray = new NSMutableArray<SWFField>();

		while( e.hasMoreElements() ) {
			SWFField nextField = e.nextElement();

			if( !USUtilities.numberIsTrue( nextField.adminField() ) ) {
				fieldArray.addObject( nextField );
			}
		}

		return fieldArray;
	}

	public NSArray<SWFField> fieldsNotInFieldSet() {
		EOQualifier q = new EOKeyValueQualifier( "fieldSet", EOQualifier.QualifierOperatorEqual, null );
		return EOQualifier.filteredArrayWithQualifier( fields(), q );
	}

	public NSArray<SWFRegistration> sortedRegistrations() {
		EOSortOrdering s = new EOSortOrdering( "sortedRegistrationFields.value", EOSortOrdering.CompareCaseInsensitiveAscending );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( registrations(), new NSArray( s ) );
	}

	public static SWFForm formWithID( EOEditingContext ec, Number number ) {

		if( number == null )
			return null;

		EOQualifier q = new EOKeyValueQualifier( "formID", EOQualifier.QualifierOperatorEqual, number );
		EOFetchSpecification fs = new EOFetchSpecification( "SWFForm", q, null );

		NSArray<SWFForm> a = ec.objectsWithFetchSpecification( fs );

		if( USArrayUtilities.arrayHasObjects( a ) ) {
			return a.objectAtIndex( 0 );
		}

		return null;
	}

	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( folder(), "folder" );
		this.addObjectToBothSidesOfRelationshipWithKey( newOwner, "folder" );
	}

	public SWFFieldSet addFieldSet() {

		SWFFieldSet f = new SWFFieldSet();
		editingContext().insertObject( f );
		f.setSortNumber( new Integer( fieldSets().count() ) );
		this.addObjectToBothSidesOfRelationshipWithKey( f, "fieldSets" );

		if( USArrayUtilities.arrayHasObjects( fields() ) && fieldSets().count() == 1 ) {
			Enumeration<SWFField> e = fields().objectEnumerator();

			while( e.hasMoreElements() ) {
				SWFField nextField = e.nextElement();
				f.addObjectToBothSidesOfRelationshipWithKey( nextField, "fields" );
			}
		}

		return f;
	}

	public void removeFieldSet( SWFFieldSet aFieldSet ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( aFieldSet, "fieldSets" );
		editingContext().deleteObject( aFieldSet );
	}

	public NSArray<SWFRegistration> registrationsMatchingString( String searchString ) {
		EOQualifier q = new EOKeyValueQualifier( "registrationFields.value", EOQualifier.QualifierOperatorLike, "*" + searchString + "*" );
		EOQualifier q2 = new EOKeyValueQualifier( "form", EOQualifier.QualifierOperatorEqual, this );
		EOQualifier q3 = new EOAndQualifier( new NSArray( new Object[] { q, q2 } ) );

		EOSortOrdering s = new EOSortOrdering( "date", EOSortOrdering.CompareCaseInsensitiveAscending );

		EOFetchSpecification fs = new EOFetchSpecification( "SWFRegistration", q3, new NSArray( s ) );
		NSArray<SWFRegistration> a = editingContext().objectsWithFetchSpecification( fs );

		if( USArrayUtilities.arrayHasObjects( a ) ) {
			NSSet<SWFRegistration> set = new NSSet<SWFRegistration>( a );
			return set.allObjects();
		}

		return NSArray.emptyArray();
	}

	public NSArray<SWFField> requiredFields() {
		EOQualifier q = new EOKeyValueQualifier( "required", EOQualifier.QualifierOperatorEqual, new Integer( 1 ) );
		return EOQualifier.filteredArrayWithQualifier( fields(), q );
	}

	public NSArray<String> emailAddresses() {
		return USUtilities.stringToArrayOfTrimmedStrings( notifyEmailAddresses() );
	}

	public NSArray<SWFField> sortedPrimaryFields() {
		EOQualifier q = new EOKeyValueQualifier( "primaryField", EOQualifier.QualifierOperatorEqual, new Integer( 1 ) );
		return EOQualifier.filteredArrayWithQualifier( sortedFields(), q );
	}

	public NSArray<SWFFieldSet> sortedFieldSets() {
		EOSortOrdering s = new EOSortOrdering( "sortNumber", EOSortOrdering.CompareAscending );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( fieldSets(), new NSArray<EOSortOrdering>( s ) );
	}

	public SWFolder containingFolder() {
		return folder();
	}

	public void setContainingFolder( SWFolder newFolder ) {
		if( this.folder() != null )
			this.removeObjectFromBothSidesOfRelationshipWithKey( this.folder(), "folder" );

		this.addObjectToBothSidesOfRelationshipWithKey( newFolder, "folder" );
	}

	public void deleteAsset() {
		this.removeObjectFromBothSidesOfRelationshipWithKey( folder(), "folder" );
		editingContext().deleteObject( this );
	}

	public Number assetID() {
		return formID();
	}

	public SWFField addField() {
		SWFField f = new SWFField();
		editingContext().insertObject( f );
		f.setSortNumber( new Integer( fields().count() ) );
		this.addObjectToBothSidesOfRelationshipWithKey( f, "fields" );
		return f;
	}

	public void removeField( SWFField aField ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( aField, "fields" );
		editingContext().deleteObject( aField );
	}

	// FIXME: Auto-generated method stub
	public NSTimestamp date() {
		return null;
	}

	// FIXME: Auto-generated method stub
	public void setDate( NSTimestamp date ) {}

	// FIXME:Auto-generated method stub
	public long size() {
		return 0;
	}

	// FIXME:Auto-generated method stub
	public double sizeKB() {
		return 0;
	}

	public void setFolder( SWFolder folder ) {
		super.setFolder( (SWFFormFolder)folder );
	}
}