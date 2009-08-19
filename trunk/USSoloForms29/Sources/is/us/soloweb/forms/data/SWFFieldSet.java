package is.us.soloweb.forms.data;

import is.us.soloweb.forms.SWFFieldContainer;
import is.us.soloweb.forms.data.auto._SWFFieldSet;

import java.util.Enumeration;

import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.*;

/**
 * @author Hugi Þórðarson
 */

public class SWFFieldSet extends _SWFFieldSet implements SWFFieldContainer {

	public void changeSortOrder( int offset ) {
		NSMutableArray fieldSets = (NSMutableArray)form().sortedFieldSets();

		//Check where the component is in the array, remove it and insert it at +offset
		int i = fieldSets.indexOfObject( this );
		fieldSets.removeObjectAtIndex( i );
		fieldSets.insertObjectAtIndex( this, i + offset );

		// Go through all components and resort
		Enumeration e = fieldSets.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWFFieldSet aFieldSet = (SWFFieldSet)e.nextElement();
			aFieldSet.setSortNumber( new Integer( fieldSets.indexOfObject( aFieldSet ) ) );
		}
	}

	public boolean isFirst() {
		return (sortNumber().intValue() == 0);
	}

	public boolean isLast() {
		return (sortNumber().intValue() == (form().fieldSets().count() - 1));
	}

	public NSArray sortedFields() {
		EOSortOrdering s = new EOSortOrdering( "sortNumber", EOSortOrdering.CompareAscending );
		return EOSortOrdering.sortedArrayUsingKeyOrderArray( fields(), new NSArray( s ) );
	}

	public SWFField addField() {

		SWFField f = new SWFField();
		editingContext().insertObject( f );
		f.setSortNumber( new Integer( fields().count() ) );
		this.form().addObjectToBothSidesOfRelationshipWithKey( f, "fields" );
		this.addObjectToBothSidesOfRelationshipWithKey( f, "fields" );

		return f;
	}

	public void removeField( SWFField aField ) {
		this.form().removeObjectFromBothSidesOfRelationshipWithKey( aField, "fields" );
		this.removeObjectFromBothSidesOfRelationshipWithKey( aField, "fields" );

		editingContext().deleteObject( aField );
	}
}