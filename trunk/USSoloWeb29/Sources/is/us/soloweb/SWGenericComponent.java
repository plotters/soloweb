package is.us.soloweb;

import is.us.soloweb.data.*;

import com.webobjects.appserver.WOContext;

/**
 * SWGenericComponent is the common ancestor of all page components displayed on
 * an SWPage in SoloWeb. Subclass this to create your own custom components.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.3
 */

public abstract class SWGenericComponent extends SWAbstractComponent {

	public SWGenericComponent( WOContext context ) {
		super( context );
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

		return super.selectedPage();
	}
}