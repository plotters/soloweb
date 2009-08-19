package is.us.soloweb.data;

import is.us.soloweb.interfaces.*;
import is.us.soloweb.util.SWTimedContentUtilities;
import is.us.util.*;

import java.util.Enumeration;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.*;

/**
 * An SWComponent represents a part of a page
 *
 * @author Hugi Þórðarson
 * @version 2.5
 * @since 2.3
 */

public class SWComponent extends _SWComponent implements SWTransferable, SWTimedContent, USSortable, SWCustomInfo, SWInspectable {

	/**
	 * Used to shift the component`s sort ordering. Throws NSArrayOutOfBoundsException if the number specified exceeds allowed limits.
	 *
	 * @param offset The number of seats to move the component by. A negative number means moving the component up, a positive number moves it down.
	 */
	public void changeSortOrder( int offset ) {
		NSMutableArray<SWComponent> components = (NSMutableArray<SWComponent>)page().sortedComponents();

		// Check where the component is in the array, remove it and insert it at +offset
		int i = components.indexOfObject( this );
		components.removeObjectAtIndex( i );
		components.insertObjectAtIndex( this, i + offset );

		// Go through all components and resort
		Enumeration<SWComponent> e = components.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWComponent aComponent = e.nextElement();
			aComponent.setSortNumber( new Integer( components.indexOfObject( aComponent ) ) );
		}
	}

	/**
	 * Indicates if this component is at the top of the page.
	 */
	public boolean isFirst() {
		return USSortableUtilities.isFirst( this );
	}

	/**
	 * Indicates if this component is at the bottom of the page.
	 */
	public boolean isLast() {
		return USSortableUtilities.isLast( this, page().components() );
	}

	/**
	 * textTwo with all instances of "\n" converted to <br /> for correct HTML-display
	 */
	public String textTwoWithBreaks() {
		return USStringUtilities.convertBreakString( textTwo() );
	}

	/**
	 * Indicates if this object has been published, and if it's display time has come
	 */
	public boolean isPublished() {
		return USUtilities.numberIsTrue( published() ) && isTimeValid();
	}

	public NSMutableDictionary _customInfo;

	public NSMutableDictionary customInfo() {
		if( _customInfo == null ) {
			_customInfo = USUtilities.dictionaryFromString( customInfoString() );
		}
		return _customInfo;
	}

	public void setCustomInfo( NSMutableDictionary d ) {
		_customInfo = d;
	}

	/**
	 * A convenience method to transfer a component to another page. Takes care of all sorting issues and other stuff
	 *
	 * @param newOwner the page to transfer ownership to
	 */
	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.page().removeComponent( this );
		((SWPage)newOwner).insertComponentAtIndex( this, 0 );
	}

	/**
	 * FIXME: Make reusable. 
	 */
	public SWComponent createCopy() {
		SWComponent nc = new SWComponent();
		editingContext().insertObject( nc );

		nc.setTextOne( textOne() );
		nc.setTextTwo( textTwo() );
		nc.setDocument( document() );
		nc.setCustomInfoString( customInfoString() );
		nc.setTemplateName( templateName() );
		nc.setEncodeBreaks( encodeBreaks() );
		nc.setPublished( published() );
		nc.setSortNumber( sortNumber() );
		nc.setTimeIn( timeIn() );
		nc.setTimeOut( timeOut() );

		return nc;
	}

	public boolean isTimeValid() {
		return SWTimedContentUtilities.validateDisplayTime( this );
	}

	/**
	 * FIXME: Implement
	 */
	public String name() {
		return textOne();
	}

	/**
	 * FIXME: Implement 
	 */
	public void setName( String name ) {
		setTextOne( name );
	}
}