package is.us.soloweb.forms;

import is.us.soloweb.forms.data.SWFField;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;
import com.webobjects.foundation.NSData;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWFFieldDisplay extends ERXComponent {

	public String currentValue;

	public SWFFieldDisplay( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public boolean currentCheckboxChecked() {
		if( USStringUtilities.stringHasValue( (currentString()) ) )
			return (currentString()).indexOf( currentValue + "\n" ) > -1;

		return false;
	}

	public void setCurrentCheckboxChecked( boolean newCurrentCheckboxChecked ) {
		if( newCurrentCheckboxChecked ) {
			if( !currentCheckboxChecked() ) {
				if( USStringUtilities.stringHasValue( (currentString()) ) ) {
					setCurrentString( currentString() + currentValue + "\n" );
				}
				else {
					setCurrentString( currentValue + "\n" );
				}
			}
		}
		else {
			if( currentCheckboxChecked() ) {
				String valueString = currentValue + "\n";
				int startOfValue = (currentString()).indexOf( valueString );
				int endOfValue = startOfValue + valueString.length();

				StringBuffer b = new StringBuffer();
				b.append( (currentString()).substring( 0, startOfValue ) );
				b.append( (currentString()).substring( endOfValue, (currentString()).length() ) );

				setCurrentString( b.toString() );
			}
		}
	}

	public SWFField currentField() {
		return (SWFField)valueForBinding( "currentField" );
	}

	public String currentString() {
		return (String)valueForBinding( "currentString" );
	}

	public void setCurrentString( String s ) {
		setValueForBinding( s, "currentString" );
	}

	public NSData currentData() {
		return (NSData)valueForBinding( "currentData" );
	}

	public void setCurrentData( NSData d ) {
		setValueForBinding( d, "currentData" );
	}

	public WOResponse binaryResponseForCurrentField() {
		String fileName = currentString();

		if( !USStringUtilities.stringHasValue( fileName ) )
			fileName = "Untitled document";

		return USHTTPUtilities.responseWithDataAndMimeType( fileName, currentData(), null );
	}
}