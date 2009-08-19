package is.us.soloweb.util;

import is.us.soloweb.data.SWTransaction;
import is.us.util.USArrayUtilities;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSArray;

/**
 * A mixin for use in classes, to fetch creation and modification dates.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.9.2b6
 * 
 * FIXME: Implement as a mixin.
 */
public class SWTransactionLoggedUtilities {

	/**
	 * Fetch the transaction matching these parameters. 
	 */
	private static SWTransaction transactionFromParameters( EOEditingContext ec, String entityName, Integer oid, String action ) {
		EOQualifier q = SWTransaction.ENTITY_NAME_STRING.eq( entityName ).and( SWTransaction.OBJECT_ID.eq( oid ) ).and( SWTransaction.ACTION.eq( action ) );

		EOFetchSpecification fs = new EOFetchSpecification( SWTransaction.ENTITY_NAME, q, SWTransaction.DATE.descs() );
		fs.setFetchLimit( 1 );

		NSArray<SWTransaction> a = ec.objectsWithFetchSpecification( fs );

		if( USArrayUtilities.arrayHasObjects( a ) )
			return a.objectAtIndex( 0 );

		return null;
	}

	/*
	public void setCreationDate( NSTimestamp t );

	public NSTimestamp modificationDate();

	public void setModificationDate( NSTimestamp t );

	public void setCreatedBy( SWUser user );

	public SWUser createdBy();

	public void setModifiedBy( SWUser user );

	public SWUser modifiedBy();
	*/
}
