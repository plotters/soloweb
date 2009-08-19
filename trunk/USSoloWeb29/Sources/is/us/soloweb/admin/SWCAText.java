package is.us.soloweb.admin;

import is.us.soloweb.SWGenericComponent;
import is.us.soloweb.client.*;

import com.webobjects.appserver.*;

/**
 * For editing the standard, built in SoloWeb components (ButurTemplate00x) 
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.4
 */

public class SWCAText extends SWGenericComponent {

	private static final String TMPL_1_NAME = ButurTemplate001.class.getSimpleName();
	private static final String TMPL_2_NAME = ButurTemplate002.class.getSimpleName();
	private static final String TMPL_3_NAME = ButurTemplate003.class.getSimpleName();
	private static final String TMPL_4_NAME = ButurTemplate004.class.getSimpleName();

	public SWCAText( WOContext context ) {
		super( context );
	}

	public void appendToResponse( WOResponse r, WOContext c ) {
		//		String s = currentComponent().templateName();
		//		
		//		if( !TMPL_1_NAME.equals( s ) && !TMPL_2_NAME.equals( s ) && !TMPL_3_NAME.equals( s ) && !TMPL_4_NAME.equals( s ) )
		//			currentComponent().setTemplateName( TMPL_4_NAME );
		//
		super.appendToResponse( r, c );
	}
}
