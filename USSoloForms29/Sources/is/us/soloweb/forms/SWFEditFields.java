package is.us.soloweb.forms;

import is.us.soloweb.forms.data.SWFField;
import is.us.util.USUtilities;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWFEditFields extends ERXComponent {

	private EOEditingContext ec = session().defaultEditingContext();

	public SWFField currentField;
	public String currentFieldType;

	public SWFEditFields( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public WOComponent addField() {
		fieldContainer().addField();
		return saveChanges();
	}

	public WOComponent removeField() {
		fieldContainer().removeField( currentField );
		return saveChanges();
	}

	public WOComponent fieldUp() {
		currentField.changeSortOrder( -1 );
		return saveChanges();
	}

	public WOComponent fieldDown() {
		currentField.changeSortOrder( 1 );
		return saveChanges();
	}

	public NSArray<String> fieldTypes() {
		return SWFUtilities.fieldTypeNames();
	}

	public String selectedFieldType() {
		return USUtilities.keyForValueFromStringDictionary( currentField.type(), SWFUtilities.fieldTypes() );
	}

	public void setSelectedFieldType( String newSelectedFieldType ) {
		currentField.setType( SWFUtilities.fieldTypes().objectForKey( newSelectedFieldType ) );
	}

	public WOComponent editField() {
		SWFEditField nextPage = pageWithName( SWFEditField.class );
		nextPage.setSelectedField( currentField );
		nextPage.setComponentToReturnTo( context().page() );
		return nextPage;
	}

	public WOComponent saveChanges() {
		ec.saveChanges();
		return context().page();
	}

	public SWFFieldContainer fieldContainer() {
		return (SWFFieldContainer)valueForBinding( "fieldContainer" );
	}

	public NSArray<SWFField> fields() {
		return (NSArray)valueForBinding( "fields" );
	}
}