package is.us.soloweb.admin;

import is.us.soloweb.data.SWTransaction;
import is.us.util.*;

import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

/**
 * 
 * 
 * @author Hugi Þórðarson
 */

public class SWTransactionLogViewer extends SWAdminComponent {

	/**
	 * The date to search for.
	 */
	public NSTimestamp date = new NSTimestamp();

	/**
	 * The transactions displayed on the page.
	 */
	public NSArray<SWTransaction> transactions;

	/**
	 * Transaction currently being iterated over. 
	 */
	public SWTransaction currentTransaction;

	public SWTransactionLogViewer( WOContext context ) {
		super( context );
	}

	public WOActionResults search() {
		NSTimestamp dateFrom = USTimestampUtilities.normalizeTimestampToMidnight( date );
		NSTimestamp dateTo = dateFrom.timestampByAddingGregorianUnits( 0, 0, 1, 0, 0, 0 );

		EOQualifier q = SWTransaction.USER_ID.isNotNull().and( USEOUtilities.qualifierBetweenDates( SWTransaction.DATE_KEY, dateFrom, dateTo ) );
		EOFetchSpecification fs = new EOFetchSpecification( SWTransaction.ENTITY_NAME, q, SWTransaction.DATE.descs() );

		transactions = ec().objectsWithFetchSpecification( fs );

		return context().page();
	}

	/**
	 * Allows th user to take a peek at the current transaction. 
	 */
	public WOActionResults inpsectTransaction() {
		SWPreviewTransaction nextPage = pageWithName( SWPreviewTransaction.class );
		nextPage.selectedObject = currentTransaction;
		return nextPage;
	}

	public String currentName() {
		return (String)currentTransaction.afterDictionary().objectForKey( "name" );
	}
}