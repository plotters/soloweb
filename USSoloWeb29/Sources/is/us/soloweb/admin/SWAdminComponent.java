package is.us.soloweb.admin;

import is.us.soloweb.SWSession;
import is.us.soloweb.data.SWUser;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.components.ERXComponent;

/**
 * SWAdminComponent is the common ancestor of most components presented in the SWAdmin framework.
 * It's function is to check if a user has logged in, - if he hasn't, nothing is appended to the response
 *
 * @author Hugi Þórðarson
 */

public abstract class SWAdminComponent extends ERXComponent {

	public SWAdminComponent( WOContext context ) {
		super( context );
	}

	/**
	 * A convenience variable to access the session's defaultEditingContext()
	 */
	public EOEditingContext ec() {
		return session().defaultEditingContext();
	}

	/**
	 * Returns a response, based on if the user is logged in or not.
	 */
	@Override
	public void appendToResponse( WOResponse aResponse, WOContext aContext ) {
		if( ((SWSession)session()).isLoggedIn() || !requiresLogin() ) {
			super.appendToResponse( aResponse, aContext );
		}
		else {
			super.appendToResponse( notLoggedInResponse(), aContext );
		}
	}

	private boolean requiresLogin() {
		return true;
	}

	/**
	 * This is returned if no user is logged in.
	 */
	private WOResponse notLoggedInResponse() {
		WOResponse r = new WOResponse();
		r.setContent( "You must log in to view this component." );
		return r;
	}

	/**
	 * The logged in user.
	 */
	public SWUser user() {
		return ((SWSession)session()).solowebUser();
	}

	/**
	 * Saves changes made in the current session.
	 */
	public WOActionResults saveChanges() {
		ec().saveChanges();
		return null;
	}
}