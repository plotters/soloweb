package is.us.soloweb.admin;

import com.webobjects.appserver.*;

import er.extensions.components.ERXComponent;

/**
 * If you want to display an error message to a system user, SWErrorMessage is the way to go. Use the static method errorWithMessage to create your error message.
 *
 * @author Hugi Þórðarson
 * @version 2.8
 * @since 2.4
 */

public class SWAdminErrorMessage extends ERXComponent {

	public String errorDetails;
	public String errorMessage;

	public SWAdminErrorMessage( WOContext context ) {
		super( context );
	}

	/**
	 * Non synchronized component
	 */
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public static WOResponse errorWithMessage( String error, WOContext aContext ) {
		return errorWithMessageAndStatusCode( error, aContext, 200 );
	}

	/**
	 * Use this method to display error messages. The error string along with header information from the context is presented to the user.
	 */
	public static WOResponse errorWithMessageAndStatusCode( String error, WOContext aContext, int statusCode ) {
		SWAdminErrorMessage nextPage = (SWAdminErrorMessage)WOApplication.application().pageWithName( SWAdminErrorMessage.class.getName(), aContext );
		nextPage.setErrorMessage( error );

		WOResponse r = nextPage.generateResponse();
		r.setStatus( statusCode );
		return r;
	}

	/**
	 * This method is intentionally undocumented
	 */
	public void setErrorMessage( String newErrorMessage ) {
		errorMessage = newErrorMessage;

		String f = "<B>Form values</B><br />" + context().request().formValues() + "<br /><br />";
		String h = "<B>Header values</B><br />" + context().request().headers() + "<br /><br />";

		errorDetails = f + h;
	}

	/**
	 * This method is intentionally undocumented
	 */
	public static WOResponse handleException( Throwable anException, WOContext aContext ) {
		return errorWithMessage( anException.toString(), aContext );
	}

	/**
	 * This method is intentionally undocumented
	 */
	public static WOResponse handlePageRestorationErrorInContext( WOContext aContext ) {
		return errorWithMessage( "Page could not be restored in context.", aContext );
	}

	/**
	 * This method is intentionally undocumented
	 */
	public static WOResponse handleSessionCreationErrorInContext( WOContext aContext ) {
		return errorWithMessage( "Session could not be created.", aContext );
	}

	/**
	 * This method is intentionally undocumented
	 */
	public static WOResponse handleSessionRestorationErrorInContext( WOContext aContext ) {
		String appPath = "/Apps" + WOApplication.application().baseURL();
		String s = "Session has expired - the maximum period of inactivity before session termination is " + (WOApplication.application().sessionTimeOut().intValue() / 60) + " minutes. Click <A href=\"" + appPath + "\" target=\"top\">here</A> to reconnect.";
		return errorWithMessage( s, aContext );
	}
}