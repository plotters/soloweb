package is.us.soloweb.client;

import is.us.soloweb.SWSettings;
import is.us.soloweb.data.*;
import is.us.soloweb.util.*;
import is.us.util.*;
import is.us.wo.util.USHTTPUtilities;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

import er.ajax.AjaxHighlight;

/**
 * The default detail view for an SWNewsitem, including comment publishing.
 *
 * @author Hugi Þórðarson
 * @version 2.9.6
 * @since 2.7
 */

public class SWNewsDetail extends SoloNewsNewsList {

	/**
	 * Contains IP-addresses that attempted to publish a comment,
	 * but failed to pass the spam check. Spambots.
	 * 
	 */
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
	public String expectedSpamAnswer = localizedString( "commentsExpectedSpamAnswer" );
	public String errorMessage;

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

	/**
	 * Currently selected news item.
	 */
	@Override
	public SWNewsItem selectedNewsItem() {
		return (SWNewsItem)valueForBinding( "selectedNewsItem" );
	}

	/**
	 * Current user.
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

	/**
	 * Now let's publish that comment...
	 */
	public WOActionResults publishComment() {
		String referer = USHTTPUtilities.referer( context().request() );
		String userAgent = USHTTPUtilities.userAgent( context().request() );
		String ipAddress = USHTTPUtilities.ipAddressFromRequest( context().request() );
		String userID = SWExternalUserUtilities.readUserIDFromRequest( context().request() );

		if( !expectedSpamAnswer.equalsIgnoreCase( hatesSpamString ) ) {
			addRejectedIPAddress( ipAddress );
			return error( "commentsWrongSpamAnswerError", expectedSpamAnswer );
		}

		if( !USStringUtilities.stringHasValueTrimmed( text ) ) {
			return error( "commentsNoTextError", null );
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
			user().setUuid( userID );
		}

		ec().saveChanges();

		AjaxHighlight.highlight( c );

		NSMutableSet<String> emailAddressesToNotify = new NSMutableSet<String>();

		if( USStringUtilities.stringHasValue( SWSettings.webmasterEmail() ) )
			emailAddressesToNotify.addObject( SWSettings.webmasterEmail() );

		for( SWComment nextComment : selectedNewsItem().comments() ) {
			String nextEmailAddress = nextComment.emailAddress();

			if( USUtilities.booleanFromObject( nextComment.notifyOnNewComments() ) && USStringUtilities.stringHasValue( nextEmailAddress ) && !nextEmailAddress.equals( userEmailAddress ) )
				emailAddressesToNotify.addObject( nextEmailAddress );
		}

		String emailSubject = "[" + USHTTPUtilities.host( context().request() ) + "] - " + SWC.SPACE + SWC.QUOTE + selectedNewsItem().name() + SWC.QUOTE;
		String emailContent = c.commentFormattedForEmail( referer );

		USMailSender.sendInMultipleEmails( SWSettings.webmasterEmail(), emailAddressesToNotify.allObjects(), emailSubject, emailContent, null );

		text = null;
		errorMessage = null;

		return null;
	}

	/**
	 * Marks an IP address rejected by the spam check.
	 * 
	 * @param ipAddress The rejected address
	 */
	private void addRejectedIPAddress( String ipAddress ) {
		if( USStringUtilities.stringHasValue( ipAddress ) ) {
			REJECTED_IP_ADDRESSES.addObject( ipAddress );
		}
	}

	/**
	 * This action is invoked if an error occurs during the publishing process. 
	 */
	public WOActionResults error( String errorKey, Object... vars ) {
		errorMessage = USStringUtilities.stringWithFormat( localizedString( errorKey ), vars );
		return null;
	}

	@Override
	public String moreURL() {
		return SWURLGeneration.moreURLForNewsItem( context(), selectedNewsItem().newsItemID(), selectedPage(), detailPageName(), detailPageID() );
	}
}