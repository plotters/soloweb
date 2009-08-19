package is.us.soloweb.util;

import is.us.soloweb.data.SWNewsItem;
import is.us.util.USArrayUtilities;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * SWNewsUtilities contains some convenience methods to fetch news
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.7
 */

public class SWNewsUtilities extends Object {

	private static final NSArray<EOSortOrdering> NEWS_DEFAULT_SORT_ORDERINGS = SWNewsItem.DATE.descs();
	private static final EOQualifier PUBLISHED_QUALIFIER = SWNewsItem.PUBLISHED.eq( SWC.TRUE_INTEGER );

	/**
	 * Finds the folder with the given ID and returns a specified amount of news from it, sorted descendingly by date
	 *
	 * @param ec The EOEditingContext to fetch into
	 * @param numberOfItems The number of newsitem to fetch
	 * @param folderID The primary key of the folder to fetch from
	 */
	public static NSArray<SWNewsItem> recentNewsFromFolderWithID( EOEditingContext ec, Integer numberOfItems, Integer folderID ) {

		try {
			NSMutableArray<EOQualifier> basicArray = new NSMutableArray<EOQualifier>();

			if( folderID != null ) {
				basicArray.addObject( new EOKeyValueQualifier( SWNewsItem.FOLDER_ID_KEY, EOQualifier.QualifierOperatorEqual, folderID ) );
			}

			basicArray.addObject( PUBLISHED_QUALIFIER );
			EOAndQualifier basicQualifier = new EOAndQualifier( basicArray );

			NSMutableArray<EOQualifier> inArray = new NSMutableArray<EOQualifier>();
			inArray.addObject( new EOKeyValueQualifier( SWNewsItem.TIME_IN_KEY, EOQualifier.QualifierOperatorLessThan, new NSTimestamp() ) );
			inArray.addObject( new EOKeyValueQualifier( SWNewsItem.TIME_IN_KEY, EOQualifier.QualifierOperatorEqual, null ) );
			EOQualifier inQualifier = new EOOrQualifier( inArray );

			NSMutableArray<EOQualifier> outArray = new NSMutableArray<EOQualifier>();
			outArray.addObject( new EOKeyValueQualifier( SWNewsItem.TIME_OUT_KEY, EOQualifier.QualifierOperatorGreaterThan, new NSTimestamp() ) );
			outArray.addObject( new EOKeyValueQualifier( SWNewsItem.TIME_OUT_KEY, EOQualifier.QualifierOperatorEqual, null ) );
			EOQualifier outQualifier = new EOOrQualifier( outArray );

			EOAndQualifier q = new EOAndQualifier( new NSArray<EOQualifier>( new EOQualifier[] { basicQualifier, inQualifier, outQualifier } ) );

			EOFetchSpecification fs = new EOFetchSpecification( SWNewsItem.class.getSimpleName(), q, NEWS_DEFAULT_SORT_ORDERINGS );

			if( numberOfItems != null )
				fs.setFetchLimit( numberOfItems );

			NSArray<SWNewsItem> fetchedNews = ec.objectsWithFetchSpecification( fs );
			return fetchedNews;
		}
		catch( Exception e ) {
			e.printStackTrace();
			return NSArray.emptyArray();
		}
	}

	/**
	 * Constructs a list of news matching the given parameters.
	 * 
	 * @param ec
	 * @param folderID
	 * @param daysToInclude
	 * @param daysToExclude
	 * @param sortOrderings
	 * @param itemsToShow
	 * @param itemsToSkip
	 * @param randomSort
	 * @return
	 */
	public static NSArray<SWNewsItem> news( EOEditingContext ec, Integer folderID, Integer daysToInclude, Integer daysToExclude, NSArray<EOSortOrdering> sortOrderings, Integer itemsToShow, Integer itemsToSkip, boolean randomSort ) {

		EOQualifier q = new EOKeyValueQualifier( SWNewsItem.FOLDER_ID_KEY, EOQualifier.QualifierOperatorEqual, folderID );
		EOQualifier q2 = new EOKeyValueQualifier( SWNewsItem.PUBLISHED_KEY, EOQualifier.QualifierOperatorEqual, SWC.TRUE_INTEGER );

		EOQualifier qp1 = new EOKeyValueQualifier( SWNewsItem.TIME_IN_KEY, EOQualifier.QualifierOperatorLessThan, new NSTimestamp() );
		EOQualifier qp2 = new EOKeyValueQualifier( SWNewsItem.TIME_IN_KEY, EOQualifier.QualifierOperatorEqual, null );

		EOQualifier qp3 = new EOKeyValueQualifier( SWNewsItem.TIME_OUT_KEY, EOQualifier.QualifierOperatorGreaterThan, new NSTimestamp() );
		EOQualifier qp4 = new EOKeyValueQualifier( SWNewsItem.TIME_OUT_KEY, EOQualifier.QualifierOperatorEqual, null );

		EOQualifier q8 = new EOOrQualifier( new NSArray<EOQualifier>( new EOQualifier[] { qp1, qp2 } ) );
		EOQualifier q9 = new EOOrQualifier( new NSArray<EOQualifier>( new EOQualifier[] { qp3, qp4 } ) );

		NSMutableArray<EOQualifier> qualArr = new NSMutableArray<EOQualifier>();

		qualArr.addObject( q );
		qualArr.addObject( q2 );

		qualArr.addObject( q8 );
		qualArr.addObject( q9 );

		if( daysToInclude != null ) {
			NSTimestamp now = new NSTimestamp();
			NSTimestamp targetDate = now.timestampByAddingGregorianUnits( 0, 0, -daysToInclude, 0, 0, 0 );
			EOQualifier q3 = new EOKeyValueQualifier( SWNewsItem.DATE_KEY, EOQualifier.QualifierOperatorGreaterThan, targetDate );
			qualArr.addObject( q3 );
		}

		if( daysToExclude != null ) {
			NSTimestamp now = new NSTimestamp();
			NSTimestamp targetDate = now.timestampByAddingGregorianUnits( 0, 0, -daysToExclude, 0, 0, 0 );
			EOQualifier q4 = new EOKeyValueQualifier( SWNewsItem.DATE_KEY, EOQualifier.QualifierOperatorLessThan, targetDate );
			qualArr.addObject( q4 );
		}

		EOAndQualifier qual = new EOAndQualifier( qualArr );
		EOFetchSpecification fs = new EOFetchSpecification( SWNewsItem.ENTITY_NAME, qual, sortOrderings );

		int itemsToFetch = 0;

		if( itemsToShow != null )
			itemsToFetch += itemsToShow;

		if( itemsToSkip != null )
			itemsToFetch += itemsToSkip;

		fs.setFetchLimit( itemsToFetch );

		NSArray<SWNewsItem> fetchedNewsItems = ec.objectsWithFetchSpecification( fs ).mutableClone();

		if( itemsToSkip != null ) {
			NSMutableArray<SWNewsItem> skippedItemArray = fetchedNewsItems.mutableClone();
			skippedItemArray.removeObjectsInRange( new NSRange( 0, itemsToSkip ) );
			fetchedNewsItems = skippedItemArray;
		}

		if( randomSort ) {
			return USArrayUtilities.arrayByRandomizingArray( fetchedNewsItems );
		}

		return fetchedNewsItems;
	}

}