package is.us.soloweb.forms;

import is.us.soloweb.forms.data.SWFField;
import is.us.util.USArrayUtilities;

import java.util.Enumeration;

import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSSelector;

/**
 * @author Hugi Þórðarson
 */

public class SWFSearchField {

	public String name;
	public SWFField field;
	public String keyPath;
	public NSSelector searchOperator;
	public String dateFormatString;

	/**
	 * Generates a
	 * 
	 * @param fields
	 * @return
	 */
	public static NSArray<SWFSearchField> fieldList( NSArray<SWFField> fields ) {

		if( !USArrayUtilities.arrayHasObjects( fields ) )
			return NSArray.emptyArray();

		NSMutableArray<SWFSearchField> a = new NSMutableArray<SWFSearchField>();
		SWFSearchField arg = null;

		arg = new SWFSearchField();
		arg.keyPath = "registrationID";
		arg.name = "Registration number";
		arg.searchOperator = EOQualifier.QualifierOperatorEqual;
		a.addObject( arg );

		arg = new SWFSearchField();
		arg.keyPath = "date";
		arg.name = "Date after (and including)...";
		arg.searchOperator = EOQualifier.QualifierOperatorGreaterThanOrEqualTo;
		arg.dateFormatString = "%d.%m.%Y";
		a.addObject( arg );

		arg = new SWFSearchField();
		arg.keyPath = "date";
		arg.name = "Date before...";
		arg.searchOperator = EOQualifier.QualifierOperatorLessThanOrEqualTo;
		arg.dateFormatString = "%d.%m.%Y";
		a.addObject( arg );

		Enumeration<SWFField> e = fields.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWFField f = (SWFField)e.nextElement();
			arg = new SWFSearchField();
			arg.field = f;
			arg.name = f.name();
			a.addObject( arg );
		}

		return a;
	}

	@Override
	public boolean equals( Object o ) {
		if( o instanceof SWFSearchField ) {
			if( this.field != null ) {
				return this.field.equals( ((SWFSearchField)o).field );
			}

			if( this.keyPath != null && this.searchOperator != null ) {
				return this.keyPath.equals( ((SWFSearchField)o).keyPath ) && this.searchOperator.equals( ((SWFSearchField)o).searchOperator );
			}
		}

		return false;
	}
}