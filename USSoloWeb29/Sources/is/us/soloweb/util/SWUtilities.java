package is.us.soloweb.util;

import is.us.soloweb.SoloWeb;
import is.us.soloweb.admin.*;
import is.us.soloweb.data.*;
import is.us.soloweb.interfaces.*;
import is.us.util.USStringUtilities;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.appserver.ERXApplication;
import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.9.2b6
 * 
 * FIXME: A more generic implementation should be in order.
 * FIXME: We're not accounting for plugins here.
 * FIXME: We're not accounting for access privileges here.
 */

public class SWUtilities {
	/*
		private static NSMutableDictionary<Class<? extends SWInspectable>, Class<? extends SWInspectionComponent>> _inspectionComponents = new NSMutableDictionary<Class<? extends SWInspectable>, Class<? extends SWInspectionComponent>>();

		static {
			_inspectionComponents.setObjectForKey( SWEditNewsItem.class, SWNewsItem.class );
			_inspectionComponents.setObjectForKey( SWEditDocument.class, SWDocument.class );
			//		_inspectionComponents.setObjectForKey( SWEditPage.class, SWPage.class);
			//		_inspectionComponents.setObjectForKey( SWEditSite.class, SWSite.class);
		}
	*/
	public static ERXComponent editObjectInContext( SWInspectable inspectable, WOContext context ) {

		if( inspectable instanceof SWNewsItem ) {
			SWAssetManagement nextPage = ERXApplication.erxApplication().pageWithName( SWAssetManagement.class );
			nextPage.setEntityName( SWNewsItem.class.getSimpleName() );
			nextPage.setFolderEntityName( SWNewsFolder.class.getSimpleName() );
			nextPage.setEditingComponentName( SWEditNewsItem.class.getSimpleName() );
			nextPage.setSelectedObject( (SWNewsItem)inspectable );
			return nextPage;
		}

		if( inspectable instanceof SWPage ) {
			SWInspectionComponent<SWPage> nextPage = ERXApplication.erxApplication().pageWithName( SWEditPage.class );
			nextPage.setSelectedObject( (SWPage)inspectable );
			nextPage.setCallingComponent( context.page() );
			return nextPage;
		}

		if( inspectable instanceof SWDocument ) {
			SWAssetManagement nextPage = ERXApplication.erxApplication().pageWithName( SWAssetManagement.class );
			nextPage.setEntityName( SWDocument.class.getSimpleName() );
			nextPage.setFolderEntityName( SWDocumentFolder.class.getSimpleName() );
			nextPage.setEditingComponentName( SWEditDocument.class.getSimpleName() );
			nextPage.setSelectedObject( (SWDocument)inspectable );
			return nextPage;
		}

		if( inspectable instanceof SWComponent ) {
			SWInspectionComponent<SWComponent> nextPage = ERXApplication.erxApplication().pageWithName( SWEditComponent.class );
			nextPage.setSelectedObject( (SWComponent)inspectable );
			nextPage.setCallingComponent( context.page() );
			return nextPage;
		}

		if( inspectable instanceof SWUser ) {
			SWInspectionComponent<SWUser> nextPage = ERXApplication.erxApplication().pageWithName( SWEditUser.class );
			nextPage.setSelectedObject( (SWUser)inspectable );
			nextPage.setCallingComponent( context.page() );
			return nextPage;
		}

		if( inspectable instanceof SWGroup ) {
			SWInspectionComponent<SWGroup> nextPage = ERXApplication.erxApplication().pageWithName( SWEditGroup.class );
			nextPage.setSelectedObject( (SWGroup)inspectable );
			nextPage.setCallingComponent( context.page() );
			return nextPage;
		}

		if( inspectable instanceof SWSite ) {
			SWInspectionComponent<SWSite> nextPage = ERXApplication.erxApplication().pageWithName( SWEditSite.class );
			nextPage.setSelectedObject( (SWSite)inspectable );
			nextPage.setCallingComponent( context.page() );
			return nextPage;
		}

		return null;
	}

	/**
	 * Indicates if we're logged into SoloWeb.
	 */
	public static boolean isLoggedIntoSoloWeb( WORequest request ) {

		if( request == null )
			return false;

		if( request.sessionID() == null )
			return false;

		if( ((NSArray)SoloWeb.sw().solowebSessions().valueForKeyPath( "sessionID" )).containsObject( request.sessionID() ) )
			return true;

		return false;
	}

	/**
	 * Fetches an HTML document and a WOD document matching the given IDs and attempts to create a template. 
	 */
	public static WOElement createTemplateFromSoloWebFiles( EOEditingContext ec, ERXComponent component, int htmlID, int wodID ) {
		String htmlString = USStringUtilities.stringFromDataUsingEncoding( SWDocument.documentWithID( ec, htmlID ).data().bytes(), SWC.ENCODING_UTF_8 );
		String wodString = USStringUtilities.stringFromDataUsingEncoding( SWDocument.documentWithID( ec, wodID ).data().bytes(), SWC.ENCODING_UTF_8 );
		return ERXComponent.templateWithHTMLString( "app", component.name(), htmlString, wodString, NSArray.EmptyArray, WOApplication.application().associationFactory(), WOApplication.application().namespaceProvider() );
	}
}