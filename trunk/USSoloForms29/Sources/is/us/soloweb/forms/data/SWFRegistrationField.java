package is.us.soloweb.forms.data;

import is.us.soloweb.forms.data.auto._SWFRegistrationField;
import is.us.util.USStringUtilities;

/**
 * @author Hugi Þórðarson
 */

public class SWFRegistrationField extends _SWFRegistrationField {

	public boolean isBinaryFile() {
		return binaryValue() != null;
	}

	public int binaryFileSize() {
		if( binaryValue() != null ) {
			int i = binaryValue().length();

			if( i > 1024 )
				return binaryValue().length() / 1024;
			else
				return 1;
		}

		return 0;
	}

	public String valueWithBreaks() {
		return USStringUtilities.convertBreakString( value() );
	}
}