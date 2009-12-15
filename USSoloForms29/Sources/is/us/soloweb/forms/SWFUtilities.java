package is.us.soloweb.forms;

import is.us.soloweb.data.SWGroup;
import is.us.soloweb.data.SWUser;
import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFForm;
import is.us.soloweb.forms.data.SWFRegistration;
import is.us.soloweb.forms.data.SWFRegistrationField;
import is.us.util.USArrayUtilities;
import is.us.util.USStringUtilities;

import java.util.Enumeration;

import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

/**
 * @author Hugi Þórðarson
 */

public class SWFUtilities {

	private static NSDictionary<String, String> _fieldTypes;
	private static NSArray<String> _fieldTypeNames;

	public static final String TYPE_TEXT_FIELD = "TEXT_FIELD";
	public static final String TYPE_TEXT_AREA = "TEXT_AREA";
	public static final String TYPE_CHECKBOX = "CHECKBOX";
	public static final String TYPE_CHECKBOX_LIST = "CHECKBOX_LIST";
	public static final String TYPE_RADIO_BUTTON_LIST = "RADIO_BUTTON_LIST";
	public static final String TYPE_POP_UP_MENU = "POP_UP_MENU";
	public static final String TYPE_BINARY_DATA = "BINARY_DATA";

	public static NSDictionary<String, String> fieldTypes() {
		if( _fieldTypes == null ) {
			NSMutableDictionary<String, String> d = new NSMutableDictionary<String, String>();
			d.setObjectForKey( TYPE_TEXT_FIELD, "Text field" );
			d.setObjectForKey( TYPE_TEXT_AREA, "Text area" );
			d.setObjectForKey( TYPE_CHECKBOX, "Checkbox" );
			d.setObjectForKey( TYPE_CHECKBOX_LIST, "Checkbox list" );
			d.setObjectForKey( TYPE_RADIO_BUTTON_LIST, "Radio buttons" );
			d.setObjectForKey( TYPE_POP_UP_MENU, "Pop-up menu" );
			d.setObjectForKey( TYPE_BINARY_DATA, "File" );
			_fieldTypes = d.immutableClone();
		}

		return _fieldTypes;
	}

	public static NSArray<String> fieldTypeNames() {
		if( _fieldTypeNames == null ) {
			_fieldTypeNames = fieldTypes().allKeys();
		}

		return _fieldTypeNames;
	}

	/**
	 * 
	 */
	public static SWFRegistrationField registrationField( EOEditingContext ec, SWFField field, SWFRegistration registration ) {
		EOQualifier q1 = new EOKeyValueQualifier( "registration", EOQualifier.QualifierOperatorEqual, registration );
		EOQualifier q2 = new EOKeyValueQualifier( "field", EOQualifier.QualifierOperatorEqual, field );
		EOQualifier q3 = new EOAndQualifier( new NSArray<EOQualifier>( new EOQualifier[] { q1, q2 } ) );
		EOFetchSpecification fs = new EOFetchSpecification( "SWFRegistrationField", q3, null );
		NSArray<SWFRegistrationField> a = ec.objectsWithFetchSpecification( fs );
		return USArrayUtilities.arrayHasObjects( a ) ? (SWFRegistrationField)a.objectAtIndex( 0 ) : null;
	}

	/**
	 * 
	 */
	public static NSData binaryValueForFieldAndRegistration( EOEditingContext ec, SWFField field, SWFRegistration registration ) {
		SWFRegistrationField regField = registrationField( ec, field, registration );
		return (regField != null) ? regField.binaryValue() : null;
	}

	/**
	 * 
	 */
	public static String valueForFieldAndRegistration( EOEditingContext ec, SWFField field, SWFRegistration registration ) {
		SWFRegistrationField regField = registrationField( ec, field, registration );
		return (regField != null) ? regField.value() : null;
	}

	/**
	 * 
	 */
	public static void setStringValueForFieldAndRegistration( String value, SWFField field, SWFRegistration registration ) {

		EOEditingContext ec = registration.editingContext();
		SWFRegistrationField registrationField = registrationField( ec, field, registration );

		if( USStringUtilities.stringHasValue( value ) ) {
			if( registrationField == null ) {
				registrationField = new SWFRegistrationField();
				ec.insertObject( registrationField );
				field.addObjectToBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
				registration.addObjectToBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
			}

			if( !value.equals( registrationField.value() ) ) {
				registrationField.setValue( value );
			}
		}
		else {
			if( registrationField != null ) {
				field.removeObjectFromBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
				registration.removeObjectFromBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
				ec.deleteObject( registrationField );
			}
		}
	}

	/**
	 * 
	 */
	public static void setBinaryValueForFieldAndRegistration( NSData binaryValue, SWFField field, SWFRegistration registration ) {

		EOEditingContext ec = registration.editingContext();
		SWFRegistrationField registrationField = registrationField( ec, field, registration );

		if( binaryValue != null && binaryValue.length() > 0 ) {
			if( registrationField == null ) {
				registrationField = new SWFRegistrationField();
				ec.insertObject( registrationField );
				field.addObjectToBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
				registration.addObjectToBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
			}

			if( !binaryValue.equals( registrationField.binaryValue() ) ) {
				registrationField.setBinaryValue( binaryValue );
			}
		}
		else {
			if( registrationField != null ) {
				field.removeObjectFromBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
				registration.removeObjectFromBothSidesOfRelationshipWithKey( registrationField, "registrationFields" );
				ec.deleteObject( registrationField );
			}
		}
	}

	/**
	 * 
	 */
	public static SWFRegistration registrationFromDictionary( EOEditingContext ec, SWFForm form, NSDictionary stringValues, NSDictionary binaryValues ) {
		SWFRegistration registration = new SWFRegistration();
		ec.insertObject( registration );

		if( stringValues != null ) {
			Enumeration<SWFField> e = stringValues.keyEnumerator();

			while( e.hasMoreElements() ) {
				SWFField field = e.nextElement();
				String value = (String)stringValues.objectForKey( field );
				SWFUtilities.setStringValueForFieldAndRegistration( value, field, registration );
			}
		}

		ec.saveChanges();

		if( binaryValues != null ) {
			Enumeration<SWFField> e = binaryValues.keyEnumerator();

			while( e.hasMoreElements() ) {
				SWFField field = e.nextElement();
				NSData value = (NSData)binaryValues.objectForKey( field );
				SWFUtilities.setBinaryValueForFieldAndRegistration( value, field, registration );
			}
		}

		registration.addObjectToBothSidesOfRelationshipWithKey( form, "form" );

		ec.saveChanges();

		return registration;
	}

	/**
	 * 
	 */
	public static NSArray fixedSearchesForUserAndForm( EOEditingContext ec, SWUser user, SWFForm form ) {
		NSArray a = form.fixedSearches();

		if( !USArrayUtilities.arrayHasObjects( a ) )
			return NSArray.EmptyArray;

		/* Add searches for this user */
		NSMutableArray fixedSearches = new NSMutableArray();
		EOQualifier q1 = new EOKeyValueQualifier( "user", EOQualifier.QualifierOperatorEqual, user );
		fixedSearches.addObjectsFromArray( EOQualifier.filteredArrayWithQualifier( a, q1 ) );

		NSArray groups = user.groups();

		if( !USArrayUtilities.arrayHasObjects( groups ) )
			return fixedSearches;

		Enumeration e = groups.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWGroup group = (SWGroup)e.nextElement();
			EOQualifier q2 = new EOKeyValueQualifier( "group", EOQualifier.QualifierOperatorEqual, group );
			fixedSearches.addObjectsFromArray( EOQualifier.filteredArrayWithQualifier( a, q2 ) );
		}

		return fixedSearches;
	}

	/**
	 * 
	 */
	public static NSArray<SWFRegistration> searchRegistrations( EOEditingContext ec, SWFForm form, NSArray searchArguments ) {

		Enumeration e = searchArguments.objectEnumerator();
		NSMutableArray<EOQualifier> qualArr = new NSMutableArray<EOQualifier>();
		int i = 0;

		while( e.hasMoreElements() ) {
			NSDictionary argument = (NSDictionary)e.nextElement();
			SWFSearchField searchField = (SWFSearchField)argument.objectForKey( "field" );
			Object searchString = argument.objectForKey( "searchString" );

			if( searchField != null && searchString != null ) {

				if( searchField.keyPath != null ) {
					qualArr.addObject( new EOKeyValueQualifier( searchField.keyPath, searchField.searchOperator, searchString ) );
				}
				else {
					SWFField field = searchField.field;

					EOKeyValueQualifier q1;
					EOKeyValueQualifier q2;

					if( i == 0 ) {
						q1 = new EOKeyValueQualifier( "registrationFields.fieldID", EOQualifier.QualifierOperatorEqual, field.fieldID() );
						q2 = new EOKeyValueQualifier( "registrationFields.value", EOQualifier.QualifierOperatorLike, "*" + searchString + "*" );
					}
					else {
						q1 = new EOKeyValueQualifier( "registrationFields" + i + ".fieldID", EOQualifier.QualifierOperatorEqual, field.fieldID() );
						q2 = new EOKeyValueQualifier( "registrationFields" + i + ".value", EOQualifier.QualifierOperatorLike, "*" + searchString + "*" );
					}

					qualArr.addObjectsFromArray( new NSArray( new Object[] { q1, q2 } ) );
					i++;
				}
			}
		}
		qualArr.addObject( new EOKeyValueQualifier( "formID", EOQualifier.QualifierOperatorEqual, form.formID() ) );

		EOQualifier q = new EOAndQualifier( qualArr );
		EOFetchSpecification fs = new EOFetchSpecification( "SWFRegistration", q, null );

		return ec.objectsWithFetchSpecification( fs );
	}

	/**
	 * 
	 */
	public static NSDictionary createCacheDictionary( NSArray registrationList ) {
		NSMutableDictionary cacheDictionary = new NSMutableDictionary();

		Enumeration e = registrationList.objectEnumerator();

		while( e.hasMoreElements() ) {
			NSArray a = ((SWFRegistration)e.nextElement()).registrationFields();

			Enumeration e2 = a.objectEnumerator();

			while( e2.hasMoreElements() ) {
				SWFRegistrationField regField = (SWFRegistrationField)e2.nextElement();
				cacheDictionary.setObjectForKey( regField, "" + regField.fieldID() + regField.registrationID() );
			}
		}

		return cacheDictionary;
	}
}