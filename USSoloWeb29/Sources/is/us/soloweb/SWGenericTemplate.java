package is.us.soloweb;

import is.us.soloweb.data.*;
import is.us.soloweb.looks.SWStandardSiteLook;
import is.us.soloweb.util.*;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;

/**
 * SWGenericTemplate is the common ancestor of all Templates created in SoloWeb. In version 2.5, there is only on subclass, SWStandardTemplate, the default tempalte used to display components.
 *
 * @author Hugi Þórðarson
 * @version 2.8
 * @since 2.3
 */

public abstract class SWGenericTemplate extends SWAbstractComponent {

	/**
	 * The currently selected page
	 */
	private SWPage _selectedPage;
	private SWComponent _currentComponent;

	private EOEditingContext _ec;

	public SWGenericTemplate( WOContext context ) {
		super( context );
	}

	/**
	 * The editingContext
	 */
	private EOEditingContext ec() {
		if( _ec == null ) {
			_ec = ERXEC.newEditingContext();
		}

		return _ec;
	}

	/**
	 * Returns the name of the SiteLook to display for this page, specified in SWSite. If no look is specified, the "SWStandardSiteLook" is displayed.
	 */
	public String lookName() {

		String lookName = context().request().stringFormValueForKey( SWC.URL_LOOK );

		if( lookName != null )
			return lookName;

		lookName = selectedPage().look();

		if( lookName != null )
			return lookName;

		lookName = selectedPage().siteForThisPage().look();

		if( lookName != null )
			return lookName;

		return SWStandardSiteLook.class.getSimpleName();
	}

	/**
	 * Returns the selected page.
	 */
	public SWPage selectedPage() {
		if( _selectedPage == null )
			_selectedPage = SWPageUtilities.pageFromRequest( ec(), context().request() );

		return _selectedPage;
	}

	/**
	 * Sets the selected page.
	 */
	public void setSelectedPage( SWPage p ) {
		_selectedPage = p;
	}

	public SWComponent currentComponent() {
		return _currentComponent;
	}

	public void setCurrentComponent( SWComponent c ) {
		_currentComponent = c;
	}
}