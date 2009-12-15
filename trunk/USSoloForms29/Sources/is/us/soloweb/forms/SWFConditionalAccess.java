package is.us.soloweb.forms;

import is.us.soloweb.admin.SWAdminComponent;
import is.us.soloweb.data.SWGroup;
import is.us.soloweb.data.SWUser;
import is.us.soloweb.forms.data.SWFField;
import is.us.soloweb.forms.data.SWFFixedSearch;
import is.us.soloweb.forms.data.SWFForm;
import is.us.soloweb.interfaces.SWInspectable;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 */

public class SWFConditionalAccess extends SWAdminComponent {

	public SWFForm selectedForm;
	private NSArray _allUsersAndGroups;
	public SWInspectable currentUserOrGroup;
	public SWFField currentField;
	public SWFFixedSearch currentFixedSearch;

	public SWFConditionalAccess( WOContext context ) {
		super( context );
	}

	/**
	 * 
	 */
	public NSArray allGroups() {
		return SWGroup.allGroups( ec() );
	}

	/**
	 * 
	 */
	public NSArray allUsers() {
		return SWUser.allUsers( ec() );
	}

	/**
	 * 
	 */
	public NSArray allUsersAndGroups() {
		if( _allUsersAndGroups == null ) {
			_allUsersAndGroups = allGroups().arrayByAddingObjectsFromArray( allUsers() );
		}

		return _allUsersAndGroups;
	}

	/**
	 * 
	 */
	public WOComponent addArgument() {
		SWFFixedSearch fs = new SWFFixedSearch();
		ec().insertObject( fs );
		fs.addObjectToBothSidesOfRelationshipWithKey( selectedForm, "form" );

		return context().page();
	}

	/**
	 * 
	 */
	public EOEnterpriseObject selectedUserOrGroup() {
		if( currentFixedSearch.user() != null )
			return currentFixedSearch.user();
		else
			return currentFixedSearch.group();
	}

	/**
	 * 
	 */
	public void setSelectedUserOrGroup( EOEnterpriseObject newSelectedUserOrGroup ) {
		if( newSelectedUserOrGroup instanceof SWUser ) {
			currentFixedSearch.addObjectToBothSidesOfRelationshipWithKey( newSelectedUserOrGroup, "user" );
			if( currentFixedSearch.valueForKey( "group" ) != null ) {
				currentFixedSearch.removeObjectFromBothSidesOfRelationshipWithKey( currentFixedSearch.group(), "group" );
			}

		}
		else {
			currentFixedSearch.addObjectToBothSidesOfRelationshipWithKey( newSelectedUserOrGroup, "group" );
			if( currentFixedSearch.valueForKey( "user" ) != null ) {
				currentFixedSearch.removeObjectFromBothSidesOfRelationshipWithKey( currentFixedSearch.user(), "user" );
			}
		}
	}

	/**
	 * 
	 */
	public WOComponent removeFixedSearch() {
		currentFixedSearch.removeObjectFromBothSidesOfRelationshipWithKey( selectedForm, "form" );
		ec().deleteObject( currentFixedSearch );
		ec().saveChanges();
		return context().page();
	}
}