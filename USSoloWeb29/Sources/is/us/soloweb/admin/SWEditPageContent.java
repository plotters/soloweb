package is.us.soloweb.admin;

import is.us.soloweb.SWSession;
import is.us.soloweb.data.SWComponent;
import is.us.soloweb.data.SWPage;
import is.us.soloweb.interfaces.SWInspectionComponent;
import is.us.soloweb.util.SWUtilities;
import is.us.util.USSortable;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 */

public class SWEditPageContent extends SWInspectionComponent<SWPage> {

	/**
	 * The current component being iterated over
	 */
	public SWComponent currentComponent;
	public int currentIndex;

	public SWEditPageContent( WOContext context ) {
		super( context );
	}

	/**
	 * Moves the current component up by one
	 */
	public WOActionResults moveComponentUp() {
		currentComponent.changeSortOrder( USSortable.UP );
		return saveChanges();
	}

	/**
	 * Moves the current component down by one
	 */
	public WOActionResults moveComponentDown() {
		currentComponent.changeSortOrder( USSortable.DOWN );
		return saveChanges();
	}

	/**
	 * Inserts a new component above all other components on the page.
	 */
	public WOActionResults insertComponentAbove() {
		if( currentComponent == null )
			return insertComponentAtIndex( 0 );

		return insertComponentAtIndex( currentComponent.sortNumber().intValue() );
	}

	/**
	 * Inserts a new component above the current component
	 */
	public WOActionResults insertComponentBelow() {
		return insertComponentAtIndex( currentComponent.sortNumber().intValue() + 1 );
	}

	/**
	 * Creates a new component and inserts it at the specified index
	 * 
	 * @param anInt The index to insert the component at.
	 */
	private WOActionResults insertComponentAtIndex( int anInt ) {
		SWComponent c = new SWComponent();
		ec().insertObject( c );
		selectedObject().insertComponentAtIndex( c, anInt );

		((SWSession)session()).customInfo().takeValueForKey( new NSMutableArray<SWComponent>( c ), SWComponent.class.getSimpleName() );

		return saveChanges();
	}

	public WOActionResults selectComponent() {
		return SWUtilities.editObjectInContext( currentComponent, context() );
	}

	/**
	 * Deletes the current component
	 */
	public WOActionResults deleteComponent() {

		selectedObject().removeComponent( currentComponent );
		ec().deleteObject( currentComponent );
		return saveChanges();
	}

	/**
	 * Returns the name of the template to display for the current component. If
	 * a bogus templateName is specified, an SWAdminErrorMessage is appended to
	 * the response instead.
	 */
	public String templateName() {
		try {
			pageWithName( currentComponent.templateName() );
			return currentComponent.templateName();
		}
		catch( Exception e ) {
			return SWAdminErrorMessage.class.getName();
		}
	}

	public String componentMenuClass() {
		if( !currentComponent.isPublished() )
			return "swmenu unpbublishedcomponentmenu";

		return "swmenu";
	}
}