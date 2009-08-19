package is.us.soloweb.data;

import is.us.soloweb.util.SWC;
import is.us.util.USStringUtilities;

/**
 * A comment in a SoloWeb system.
 * 
 * @author Hugi Þórðarson 
 */

public class SWComment extends _SWComment {

	/**
	 * @return a useable version of the URL entered.
	 */
	public String fixedUrl() {
		return USStringUtilities.fixUrl( url() );
	}

	/**
	 * @return true if this record has no URL.
	 */
	public boolean noUrl() {
		return !USStringUtilities.stringHasValue( url() );
	}

	/**
	 * The text as displayed to the user.
	 */
	public String textForDisplay() {
		String s = text();

		s = USStringUtilities.replace( s, "<", "&lt;" );
		s = USStringUtilities.replace( s, "<", "&gt;" );
		s = USStringUtilities.convertBreakString( s );

		//		MarkdownProcessor markdown_processor = new MarkdownProcessor();
		//		s = markdown_processor.markdown( text() );

		//		MarkupParser parser = new MarkupParser( new TextileLanguage() );
		//		s = parser.parseToHtml( text() );

		return s;
	}

	/**
	 * Formats a comment for notification emails.
	 */
	public String commentFormattedForEmail( String refererURL ) {
		StringBuffer b = new StringBuffer();
		b.append( name() );
		b.append( " skrifar:" );
		b.append( SWC.LF );
		b.append( SWC.LF );
		b.append( text() );
		b.append( SWC.LF );
		b.append( SWC.LF );
		b.append( refererURL );
		return b.toString();
	}
}