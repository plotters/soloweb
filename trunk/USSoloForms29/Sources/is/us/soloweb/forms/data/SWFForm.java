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

	public NSArray sortedFields() {
		NSMutableArray sortOrderings = new NSMutableArray();
		if( USArrayUtilities.arrayHasObjects( fieldSets() ) ) {
			sortOrderings.addObject( new EOSortOrdering( "fieldSet.sortNumber", EOSortOrdering.CompareAscending ) );
		}
		sortOrderings.addObject( new EOSortOrdering( "sortNumber", EOSortOrdering.CompareAscending ) );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( fields(), sortOrderings );
	}

	public NSArray sortedFieldsExcludingAdminFields() {
		Enumeration e = sortedFields().objectEnumerator();
		NSMutableArray fieldArray = new NSMutableArray();

		while( e.hasMoreElements() ) {
			SWFField nextField = (SWFField)e.nextElement();
			if( !USUtilities.numberIsTrue( nextField.adminField() ) )
				fieldArray.addObject( nextField );
		}

		return fieldArray;
	}

	public NSArray fieldsNotInFieldSet() {
		EOQualifier q = new EOKeyValueQualifier( "fieldSet", EOQualifier.QualifierOperatorEqual, null );
		return EOQualifier.filteredArrayWithQualifier( fields(), q );
	}

	public NSArray sortedRegistrations() {
		EOSortOrdering s = new EOSortOrdering( "sortedRegistrationFields.value", EOSortOrdering.CompareCaseInsensitiveAscending );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( registrations(), new NSArray( s ) );
	}

	public static SWFForm formWithID( EOEditingContext ec, Number number ) {

		if( number == null )
			return null;

		EOQualifier q = new EOKeyValueQualifier( "formID", EOQualifier.QualifierOperatorEqual, number );
		EOFetchSpecification fs = new EOFetchSpecification( "SWFForm", q, null );

		NSArray a = ec.objectsWithFetchSpecification( fs );

		if( a != null && a.count() > 0 )
			return (SWFForm)a.objectAtIndex( 0 );

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
			Enumeration e = fields().objectEnumerator();

			while( e.hasMoreElements() ) {
				SWFField nextField = (SWFField)e.nextElement();
				f.addObjectToBothSidesOfRelationshipWithKey( nextField, "fields" );
			}
		}

		return f;
	}

	public void removeFieldSet( SWFFieldSet aFieldSet ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( aFieldSet, "fieldSets" );
		editingContext().deleteObject( aFieldSet );
	}

	public NSArray registrationsMatchingString( String searchString ) {
		EOQualifier q = new EOKeyValueQualifier( "registrationFields.value", EOQualifier.QualifierOperatorLike, "*" + searchString + "*" );
		EOQualifier q2 = new EOKeyValueQualifier( "form", EOQualifier.QualifierOperatorEqual, this );
		EOQualifier q3 = new EOAndQualifier( new NSArray( new Object[] { q, q2 } ) );

		EOSortOrdering s = new EOSortOrdering( "date", EOSortOrdering.CompareCaseInsensitiveAscending );

		EOFetchSpecification fs = new EOFetchSpecification( "SWFRegistration", q3, new NSArray( s ) );
		NSArray a = editingContext().objectsWithFetchSpecification( fs );

		if( USArrayUtilities.arrayHasObjects( a ) ) {
			NSSet set = new NSSet( a );
			return set.allObjects();
		}

		return NSArray.EmptyArray;
	}

	public NSArray requiredFields() {
		EOQualifier q = new EOKeyValueQualifier( "required", EOQualifier.QualifierOperatorEqual, new Integer( 1 ) );
		return EOQualifier.filteredArrayWithQualifier( fields(), q );
	}

	public NSArray emailAddresses() {
		return USUtilities.stringToArrayOfTrimmedStrings( notifyEmailAddresses() );
	}

	public NSArray sortedPrimaryFields() {
		EOQualifier q = new EOKeyValueQualifier( "primaryField", EOQualifier.QualifierOperatorEqual, new Integer( 1 ) );
		return EOQualifier.filteredArrayWithQualifier( sortedFields(), q );
	}

	public NSArray sortedFieldSets() {
		EOSortOrdering s = new EOSortOrdering( "sortNumber", EOSortOrdering.CompareAscending );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( fieldSets(), new NSArray( s ) );
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
	public int size() {
		return 0;
	}

	public void setFolder( SWFolder folder ) {
		super.setFolder( (SWFFormFolder)folder );
	}
}