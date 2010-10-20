package is.us.soloweb.data;

import is.us.soloweb.data.auto._SWNewsItem;
import is.us.soloweb.interfaces.*;
import is.us.soloweb.util.SWTimedContentUtilities;
import is.us.util.*;

import java.io.StringWriter;

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSTimestamp;

/**
 * An SWNewsItem represents a newsitem in the SoloWeb system
 * 
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.3
 */

public class SWNewsItem extends _SWNewsItem implements SWTimedContent, SWAsset<SWNewsFolder>, SWTransactionLogged {

	/**
	 * Returns the newsItem's excerpt with breaks encoded to BR-tags
	 */
	public String excerptWithBreaks() {
		return USStringUtilities.convertBreakString( excerpt() );
	}

	/**
	 * Returns the newsItem's text with breaks encoded to BR-tags
	 */
	public String textWithBreaks() {
		return USStringUtilities.convertBreakString( text() );
	}

	/**
	 * Indicates if this object has been published, and if it's display time has
	 * come
	 */
	public boolean isPublished() {
		return USUtilities.numberIsTrue( published() ) && isTimeValid();
	}

	/**
	 * Indicates if the text of this newsitem should be break encoded
	 */
	public boolean shouldEncodeBreaks() {
		return USUtilities.numberIsTrue( encodeBreaks() );
	}

	/**
	 * Implementation of SWTransferable
	 */
	@Override
	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( folder(), FOLDER_KEY );
		this.addObjectToBothSidesOfRelationshipWithKey( newOwner, FOLDER_KEY );
	}

	/**
	 * Indicates if this object's display time has come and has not expired
	 */
	@Override
	public boolean isTimeValid() {
		return SWTimedContentUtilities.validateDisplayTime( this );
	}

	/**
	 * @return All comments for the selected newsitem.
	 *
	public NSArray<SWComment> comments() {
		EOQualifier q = SWComment.NEWS_ITEM_ID.eq( newsItemID() );
		EOFetchSpecification fs = new EOFetchSpecification( SWComment.ENTITY_NAME, q, SWComment.DATE.ascs() );
		return editingContext().objectsWithFetchSpecification( fs );
	}
	*/

	@Override
	public Number assetID() {
		return newsItemID();
	}

	@Override
	public void deleteAsset() {
		editingContext().deleteObject( this );
	}

	@Override
	public void awakeFromInsertion( EOEditingContext anEC ) {
		super.awakeFromInsertion( anEC );
		setDate( new NSTimestamp() );
	}

	/**
	 * @return The asset's size in bytes.
	 */
	@Override
	public long size() {
		if( text() == null ) {
			return 0;
		}

		return text().length();
	}

	/**
	 * @return The asset's size in kilobytes.
	 */
	@Override
	public double sizeKB() {
		return size() / 1000d;
	}

	/**
	 * @return The newsitem's text, formatted for display.
	 */
	public String textRendered() {
		String s = super.text();

		if( isWikiMarkup() && s != null ) {
			StringWriter writer = new StringWriter();
			MarkupLanguage language = new TextileLanguage();
			HtmlDocumentBuilder builder = new HtmlDocumentBuilder( writer );
			MarkupParser parser = new MarkupParser( language, builder );
			parser.parse( s, false );
			s = writer.toString();
		}

		if( USUtilities.booleanFromObject( encodeBreaks() ) ) {
			s = USStringUtilities.convertBreakString( s );
		}

		return s;
	}

	/**
	 * Indicates if the text in this component should be rendered using the
	 * Textile engine.
	 */
	public boolean isWikiMarkup() {
		return USUtilities.booleanFromObject( wikiMarkup() );
	}
}