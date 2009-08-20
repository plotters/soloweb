package is.us.soloweb.forms.data;

import is.us.soloweb.forms.SWFUtilities;
import is.us.soloweb.forms.data.auto._SWFField;
import is.us.soloweb.interfaces.SWInspectable;
import is.us.util.*;

import java.util.Enumeration;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 */

public class SWFField extends _SWFField implements SWInspectable {

	public String type() {
		String s = super.type();

		if( s == null )
			s = SWFUtilities.TYPE_TEXT_FIELD;

		return s;
	}

	public String aboveTextWithBreaks() {
		return USStringUtilities.convertBreakString( aboveText() );
	}

	public String explanatoryTextWithBreaks() {
		return USStringUtilities.convertBreakString( explanatoryText() );
	}

	public String nameWithBreaks() {
		return USStringUtilities.convertBreakString( name() );
	}

	/**
	 * When the field is initially created, we set it's type to a text field.
	 */
	@Override
	public void awakeFromInsertion( EOEditingContext ec ) {
		super.awakeFromInsertion( ec );
		setType( SWFUtilities.TYPE_TEXT_FIELD );
	}

	public boolean isRequired() {
		return !(required() == null || required().intValue() == 0);
	}

	public NSArray<String> valueList() {
		return USUtilities.stringToArrayOfTrimmedStrings( valuelistString() );
	}

	public boolean isTextField() {
		return SWFUtilities.TYPE_TEXT_FIELD.equals( type() );
	}

	public boolean isTextArea() {
		return SWFUtilities.TYPE_TEXT_AREA.equals( type() );
	}

	public boolean isCheckbox() {
		return SWFUtilities.TYPE_CHECKBOX.equals( type() );
	}

	public boolean isPopUpMenu() {
		return SWFUtilities.TYPE_POP_UP_MENU.equals( type() );
	}

	public boolean isRadioButtonList() {
		return SWFUtilities.TYPE_RADIO_BUTTON_LIST.equals( type() );
	}

	public boolean isCheckboxList() {
		return SWFUtilities.TYPE_CHECKBOX_LIST.equals( type() );
	}

	public boolean isBinaryFile() {
		return SWFUtilities.TYPE_BINARY_DATA.equals( type() );
	}

	public void changeSortOrder( int offset ) {
		NSMutableArray<SWFField> fields = null;

		if( fieldSet() != null )
			fields = fieldSet().sortedFields().mutableClone();
		else
			fields = form().sortedFields().mutableClone();

		//Check where the component is in the array, remove it and insert it at +offset
		int i = fields.indexOfObject( this );
		fields.removeObjectAtIndex( i );
		fields.insertObjectAtIndex( this, i + offset );

		// Go through all components and resort
		Enumeration<SWFField> e = fields.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWFField aField = e.nextElement();
			aField.setSortNumber( new Integer( fields.indexOfObject( aField ) ) );
		}
	}

	/**
	 * Indicates if this field is first in list.
	 */
	public boolean isFirst() {
		return sortNumber().intValue() == 0;
	}

	/**
	 * Indicates if this field is last in list (if it's in a fieldset, it checks that, otherwise, it checks the form).
	 */
	public boolean isLast() {
		if( fieldSet() != null )
			return sortNumber().intValue() == (fieldSet().fields().count() - 1);
		else
			return sortNumber().intValue() == (form().fields().count() - 1);
	}
}