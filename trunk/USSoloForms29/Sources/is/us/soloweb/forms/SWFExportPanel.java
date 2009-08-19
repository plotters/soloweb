package is.us.soloweb.forms;

import is.us.soloweb.forms.data.*;
import is.us.util.USStringUtilities;

import java.util.Enumeration;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 */

public class SWFExportPanel extends SWFAdminComponent {

	private NSArray _registrations;
	private SWFForm _form;

	public SWFField currentField;
	public SWFField selectedField;
	public NSMutableArray exportFields = new NSMutableArray();
	public NSArray<String> encodingList = new NSArray( new String[] { "ISO-8859-1", "UTF-8", "UTF-16" } );

	public String currentEncoding;
	public String selectedEncoding;
	public static final NSTimestampFormatter formatter = new NSTimestampFormatter( "%d.%m.%Y" );

	public static final String VERTICAL_TAB = String.valueOf( (char)11 );
	public static final String FIELD_SEPARATOR = String.valueOf( (char)9 );
	public static final String RECORD_SEPARATOR = String.valueOf( (char)13 );

	public SWFExportPanel( WOContext context ) {
		super( context );
	}

	public void setRegistrations( NSArray list ) {
		_registrations = list;
	}

	public NSArray registrations() {
		return _registrations;
	}

	public void setForm( SWFForm aForm ) {
		_form = aForm;
	}

	public SWFForm form() {
		return _form;
	}

	public WOActionResults registrationListAsText() {

		Enumeration e = registrations().objectEnumerator();
		StringBuffer b = new StringBuffer();

		while( e.hasMoreElements() ) {
			SWFRegistration nextRegistration = (SWFRegistration)e.nextElement();
			b.append( nextRegistration.registrationID() );
			b.append( FIELD_SEPARATOR );
			b.append( formatDate( nextRegistration.date() ) );

			Enumeration e2 = exportFields.objectEnumerator();

			while( e2.hasMoreElements() ) {
				SWFField nextField = (SWFField)e2.nextElement();
				String value = SWFUtilities.valueForFieldAndRegistration( ec(), nextField, nextRegistration );
				value = USStringUtilities.replace( value, "\r\n", "\n" );
				value = USStringUtilities.replace( value, "\r", "\n" );
				value = USStringUtilities.replace( value, "\n", VERTICAL_TAB );
				b.append( FIELD_SEPARATOR );

				if( value != null )
					b.append( value );
			}

			b.append( RECORD_SEPARATOR );
		}

		WOResponse r = new WOResponse();
		r.setHeader( "text/plain", "content-type" );
		r.setContent( b.toString() );

		return r;
	}

	public WOComponent addToExportSet() {
		exportFields.addObject( selectedField );
		return context().page();
	}

	public WOComponent removeField() {
		exportFields.removeObject( currentField );
		return context().page();
	}

	private String formatDate( NSTimestamp ts ) {
		return formatter.format( ts );
	}

	public NSArray fieldList() {
		NSMutableArray a = form().sortedFields().mutableClone();
		a.removeObjectsInArray( exportFields );
		return a;
	}
}