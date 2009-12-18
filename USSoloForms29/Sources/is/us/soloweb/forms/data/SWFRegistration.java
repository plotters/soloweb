package is.us.soloweb.forms.data;

import is.us.soloweb.SWSettings;
import is.us.soloweb.forms.SWFUtilities;
import is.us.soloweb.forms.data.auto._SWFRegistration;
import is.us.soloweb.interfaces.SWInspectable;
import is.us.template.USTemplateSimple;
import is.us.util.USDataUtilities;
import is.us.util.USMailSender;
import is.us.util.USStringUtilities;
import is.us.util.USUtilities;
import is.us.wo.util.USC;

import java.io.File;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSRange;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Hugi Þórðarson
 */

public class SWFRegistration extends _SWFRegistration implements SWInspectable {

	private static final Logger logger = LoggerFactory.getLogger( SWFRegistration.class );

	public NSArray<SWFRegistrationField> sortedRegistrationFields() {
		EOSortOrdering s = new EOSortOrdering( "field.sortNumber", EOSortOrdering.CompareAscending );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( registrationFields(), new NSArray<EOSortOrdering>( s ) );
	}

	public NSArray<SWFRegistrationField> sortedPrimaryRegistrationFields() {
		EOQualifier q = new EOKeyValueQualifier( "field.primaryField", EOQualifier.QualifierOperatorEqual, new Integer( 1 ) );
		return EOQualifier.filteredArrayWithQualifier( sortedRegistrationFields(), q );
	}

	public NSArray<SWFRegistrationField> sortedRegistrationFieldsExcludingAdminFields() {
		Enumeration<SWFRegistrationField> e = sortedRegistrationFields().objectEnumerator();
		NSMutableArray<SWFRegistrationField> fieldArray = new NSMutableArray<SWFRegistrationField>();

		while( e.hasMoreElements() ) {
			SWFRegistrationField nextField = e.nextElement();

			if( nextField.field() != null )
				if( !USUtilities.numberIsTrue( nextField.field().adminField() ) )
					fieldArray.addObject( nextField );
		}

		return fieldArray.immutableClone();
	}

	public void deleteRegistration() {
		removeObjectFromBothSidesOfRelationshipWithKey( form(), "form" );
		editingContext().deleteObject( this );
	}

	/**
	 * Send an email containing this registration.
	 */
	public void sendNotification() {

		if( USStringUtilities.stringHasValue( form().fromEmailAddress() ) && USStringUtilities.stringHasValue( form().notifyEmailAddresses() ) ) {
			String from = form().fromEmailAddress();
			String subject = form().name();

			USTemplateSimple t = new USTemplateSimple();
			t.setTemplateString( subject );
			t.setVariables( registrationAsDictionary() );
			subject = t.parse();

			NSArray<String> addresses = form().emailAddresses();
			NSArray<String> to = addresses.subarrayWithRange( new NSRange( 0, 1 ) );
			NSArray<String> cc = null;

			if( addresses.count() > 1 ) {
				cc = addresses.subarrayWithRange( new NSRange( 1, addresses.count() - 1 ) );
			}

			NSMutableArray<String> tmpFiles = new NSMutableArray<String>();
			Enumeration<SWFRegistrationField> e = binaryFieldsWithValues().objectEnumerator();

			while( e.hasMoreElements() ) {
				SWFRegistrationField rf = e.nextElement();
				try {
					File f = new File( ((String)SWSettings.settingForKey( "documentLocationOnDisk" )) + rf.value() );
					USDataUtilities.writeBytesToFile( rf.binaryValue().bytes(), f );
					tmpFiles.addObject( f.getAbsolutePath() );
				}
				catch( Exception ex ) {
					logger.error( "Error", ex );
				}
			}

			USMailSender.composeEmailWithAlternateTextAndAttachments( from, to, cc, null, "SoloForm: " + subject, registrationAsPlainText(), registrationAsHTML(), tmpFiles );

			Enumeration<String> e2 = tmpFiles.objectEnumerator();

			while( e2.hasMoreElements() ) {
				String s = e2.nextElement();

				try {
					File f = new File( s );
					f.delete();
				}
				catch( Exception ex ) {
					logger.error( "Error", ex );
				}
			}
		}
	}

	private NSArray<SWFRegistrationField> binaryFieldsWithValues() {
		EOQualifier q = new EOKeyValueQualifier( "binaryValue", EOQualifier.QualifierOperatorNotEqual, null );
		return EOQualifier.filteredArrayWithQualifier( registrationFields(), q );
	}

	private NSDictionary registrationAsDictionary() {
		NSMutableDictionary d = new NSMutableDictionary();

		for( SWFRegistrationField regField : sortedRegistrationFields() ) {
			String key = regField.field().name();
			Object value = regField.value();

			if( value == null )
				value = USC.EMPTY_STRING;

			d.setObjectForKey( value, key );
		}

		return d;
	}

	private String registrationAsPlainText() {
		Enumeration<SWFRegistrationField> e = sortedRegistrationFields().objectEnumerator();
		StringBuffer b = new StringBuffer();

		while( e.hasMoreElements() ) {
			SWFRegistrationField next = e.nextElement();
			b.append( next.field().name() );
			b.append( ": " );
			b.append( next.value() );
			b.append( "\n" );
		}

		return b.toString();
	}

	private String registrationAsHTML() {
		Enumeration<SWFRegistrationField> e = sortedRegistrationFields().objectEnumerator();
		StringBuffer b = new StringBuffer();

		while( e.hasMoreElements() ) {
			SWFRegistrationField next = e.nextElement();
			b.append( "<p>" );
			b.append( "<b>" );
			b.append( next.field().name() );
			b.append( ": " );
			b.append( "</b>" );
			b.append( USStringUtilities.convertBreakString( next.value() ) );
			b.append( "</p>" );
		}

		return b.toString();
	}

	public void awakeFromInsertion( EOEditingContext anEC ) {
		super.awakeFromInsertion( anEC );
		setDate( new NSTimestamp() );
	}

	public Object valueForKeyPath( String keypath ) {
		if( keypath.startsWith( "@field" ) ) {
			String key = keypath.substring( 7, keypath.length() );
			return valueForFieldNumber( key );
		}
		else {
			return super.valueForKeyPath( keypath );
		}
	}

	public Object valueForFieldNumber( String number ) {
		SWFField field = form().sortedPrimaryFields().objectAtIndex( new Integer( number ).intValue() );
		return SWFUtilities.valueForFieldAndRegistration( editingContext(), field, this );
	}

	/**
	 * FIXME: That's a kludge.
	 */
	public String name() {
		if( registrationID() != null )
			return registrationID().toString();

		return null;
	}

	/**
	 * FIXME: That's a kludge.
	 */
	public void setName( String name ) {}
}