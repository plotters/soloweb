package is.us.soloweb;

import is.us.soloweb.data.SWComponent;
import is.us.soloweb.looks.SWStandardSiteLook;
import is.us.soloweb.util.SWC;

import com.webobjects.appserver.WOContext;

/**
 * SWGenericTemplate is the common ancestor of all Templates created in SoloWeb. In version 2.5, there is only on subclass, SWStandardTemplate, the default tempalte used to display components.
 *
 * @author Hugi Þórðarson
 * @version 2.8
 * @since 2.3
 */

public abstract class SWGenericTemplate extends SWAbstractComponent {

	public static final String SW_LOOK_COOKIE = "sw_look";
	private SWComponent _currentComponent;

	public SWGenericTemplate( WOContext context ) {
		super( context );
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

	public SWComponent currentComponent() {
		return _currentComponent;
	}

	public void setCurrentComponent( SWComponent c ) {
		_currentComponent = c;
	}
}