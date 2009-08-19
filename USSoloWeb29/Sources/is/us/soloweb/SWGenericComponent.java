package is.us.soloweb;

import is.us.soloweb.data.*;
import is.us.soloweb.util.*;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;

/**
 * SWGenericComponent is the common ancestor of all page components displayed on
 * an SWPage in SoloWeb. Subclass this to create your own custom components.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.3
 */

public abstract class SWGenericComponent extends SWAbstractComponent {

	private EOEditingContext _ec;

	public SWGenericComponent( WOContext context ) {
		super( context );
	}

	/**
	 * The editingContext
	 */
	protected EOEditingContext ec() {
		if( _ec == null ) {
			_ec = ERXEC.newEditingContext();
		}

		return _ec;
	}

	public SWComponent currentComponent() {
		return (SWComponent)valueForBinding( "currentComponent" );
	}

	public void setCurrentComponent( SWComponent c ) {
		setValueForBinding( c, "currentComponent" );
	}

	/**
	 * The SWPage currently being displayed.
	 */
	public SWPage selectedPage() {

		if( currentComponent() != null )
			return currentComponent().page();

		SWPage p = (SWPage)valueForBinding( SWC.SELECTED_PAGE );

		if( p != null )
			return p;

		return SWPageUtilities.pageFromRequest( ec(), context().request() );
	}
}