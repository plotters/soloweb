package is.us.soloweb.data;

import is.us.soloweb.interfaces.*;
import is.us.soloweb.util.SWTimedContentUtilities;
import is.us.util.*;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSTimestamp;

/**
 * An SWNewsItem represents a newsitem in the SoloWeb system
 *
 * @author Hugi Þórðarson
 * @version 2.7
 * @since 2.3
 */

public class SWNewsItem extends _SWNewsItem implements SWTimedContent, SWAsset<SWNewsFolder>, SWInspectable, SWTransactionLogged {

	/**
	 * Returns the newsItem's excerpt with breaks encoded to BR-tags
	 */
	public String excerptWithBreaks() {
		return USStringUtilities.convertBreakString( excerpt() );
	}

	/**
	 * Returns the newsItem's excerpt with breaks encoded to BR-tags
	 *
	public String generatedExcerptWithBreaks() {
		if( excerptWithBreaks() != null)
			return excerptWithBreaks();

		return USStringUtilities.convertBreakString( excerpt() );
	}
	*/

	/**
	 * Returns the newsItem's text with breaks encoded to BR-tags
	 */
	public String textWithBreaks() {
		return USStringUtilities.convertBreakString( text() );
	}

	/**
	 * Indicates if this object has been published, and if it's display time has come
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
	public void transferOwnership( EOEnterpriseObject newOwner ) {
		this.removeObjectFromBothSidesOfRelationshipWithKey( folder(), FOLDER_KEY );
		this.addObjectToBothSidesOfRelationshipWithKey( newOwner, FOLDER_KEY );
	}

	/**
	 * Indicates if this object's display time has come and has not expired
	 */
	public boolean isTimeValid() {
		return SWTimedContentUtilities.validateDisplayTime( this );
	}

	public Number assetID() {
		return newsItemID();
	}

	public void deleteAsset() {
		editingContext().deleteObject( this );
	}

	public void awakeFromInsertion( EOEditingContext anEC ) {
		super.awakeFromInsertion( anEC );
		setDate( new NSTimestamp() );
	}

	public int size() {
		if( text() == null )
			return 0;

		return text().length();
	}
}