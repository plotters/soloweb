package is.us.soloweb.client;

import is.us.soloweb.SWSettings;
import is.us.soloweb.data.*;
import is.us.soloweb.util.*;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.ajax.AjaxHighlight;

/**
 * The default detail view for an SWNewsitem.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.7
 */

public class SWNewsDetail extends SoloNewsNewsList {

	public static final NSMutableArray<String> REJECTED_IP_ADDRESSES = new NSMutableArray<String>();

	/**
	 * Variables in the UI.
	 */
	public String userName = user().username();
	public String userUrl = user().url();
	public String userEmailAddress = user().emailAddress();
	public Integer userNotifyOnNewComments = user().notifyOnNewComments();
	public String text;
	public String hatesSpamString;
	public String exepectedSpamAnswer = localizedApplicationStringForKey( "commentsExpectedSpamAnswer" );

	/**
	 * Error message displayed to the user.
	 */
	private String _errorMessage;

	/**
	 * The comment currently being iterated over in the list.
	 */
	public SWComment currentComment;

	/**
	 * A variable for lazy initialization of user()
	 */
	private SWExternalUser _user;

	public SWNewsDetail( WOContext context ) {
		super( context );
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public SWNewsItem selectedNewsItem() {
		return (SWNewsItem)valueForBinding( "selectedNewsItem" );
	}

	/**
	 * FIXME: Move to consolidated URL-generation. 
	 */
	public String moreURL() {
		return SWURLGeneration.moreURLForNewsItem( context(), selectedNewsItem().newsItemID(), selectedPage(), detailPageName(), detailPageID() );
	}

	/**
	 * Current user 
	 */
	private SWExternalUser user() {
		if( _user == null ) {
			_user = SWExternalUserUtilities.userFromRequest( ec(), context().request() );
		}

		if( _user == null ) {
			_user = new SWExternalUser();
		}

		return _user;
	}

	public String errorMessage() {
		return _errorMessage;
	}

	public void setErrorMessage( String newErrorMessage ) {
		_errorMessage = newErrorMessage;
	}

	/**
	 * Here we're fetching the comments for the selected newsitem.
	 */
	public NSArray<SWComment> comments() {
		EOQualifier q = SWComment.NEWS_ITEM_ID.eq( selectedNewsItem().newsItemID() );
		EOFetchSpecification fs = new EOFetchSpecification( SWComment.ENTITY_NAME, q, SWComment.DATE.ascs() );
		return ec().objectsWithFetchSpecification( fs );
	}

	/**
	 * Now let's publish that comment...
	 */
	public WOActionResults publishComment() {
		String referer = USHTTPUtilities.referer( context().request() );
		String userAgent = USHTTPUtilities.userAgent( context().request() );
		String ipAddress = USHTTPUtilities.ipAddressFromRequest( context().request() );
		String uuid = SWExternalUserUtilities.readUserIDFromRequest( context().request() );

		if( !exepectedSpamAnswer.equalsIgnoreCase( hatesSpamString ) ) {
			if( USStringUtilities.stringHasValue( ipAddress ) )
				REJECTED_IP_ADDRESSES.addObject( ipAddress );

			return error( "Í þessum reit verður að standa " + SWC.QUOTE + exepectedSpamAnswer + SWC.QUOTE );
		}

		if( !USStringUtilities.stringHasValueTrimmed( text ) ) {
			return error( "Texti athugasemdar má ekki vera tómur" );
		}

		SWComment c = new SWComment();
		ec().insertObject( c );

		c.setDate( new NSTimestamp() );
		c.setName( userName );
		c.setUrl( userUrl );
		c.setEmailAddress( userEmailAddress );
		c.setNotifyOnNewComments( userNotifyOnNewComments );
		c.setText( text );
		c.setNewsItemID( selectedNewsItem().newsItemID() );
		c.setIpAddress( ipAddress );
		c.setUserAgent( userAgent );

		if( userName != null ) {
			if( user().editingContext() == null )
				ec().insertObject( user() );

			user().setUsername( userName );
			user().setUrl( userUrl );
			user().setEmailAddress( userEmailAddress );
			user().setNotifyOnNewComments( userNotifyOnNewComments );
			user().addToComments( c );
			user().setUuid( uuid );
		}

		ec().saveChanges();

		AjaxHighlight.highlight( c );

		NSMutableArray<String> emailAddressesToNotify = new NSMutableArray<String>();
		emailAddressesToNotify.addObject( SWSettings.webmasterEmail() );

		for( SWComment nextComment : comments() ) {
			String nextEmailAddress = nextComment.emailAddress();

			if( USUtilities.booleanFromObject( nextComment.notifyOnNewComments() ) && USStringUtilities.stringHasValue( nextEmailAddress ) && !emailAddressesToNotify.containsObject( nextEmailAddress ) && !nextEmailAddress.equals( userEmailAddress ) )
				emailAddressesToNotify.addObject( nextEmailAddress );
		}

		String emailSubject = "[" + USHTTPUtilities.host( context().request() ) + "] - " + SWC.SPACE + SWC.QUOTE + selectedNewsItem().name() + SWC.QUOTE;
		String emailContent = c.commentFormattedForEmail( referer );

		USMailSender.sendInMultipleEmails( SWSettings.webmasterEmail(), emailAddressesToNotify, emailSubject, emailContent, null );

		text = null;
		setErrorMessage( null );

		return null;
	}

	/**
	 * This action is invoked if an error occurs during the publishing process. 
	 */
	public WOActionResults error( String newErrorMessage ) {
		setErrorMessage( newErrorMessage );
		return null;
	}
}