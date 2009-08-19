package is.us.soloweb.search;

import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.interfaces.SWInspectable;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b6
 * @since 2.9.2b6
 * 
 * FIXME: Not implemented
 */

public class SWGenericSearch {

	public static NSArray<? extends SWInspectable> search( EOEditingContext ec, String searchString ) {
		EOQualifier q = new EOKeyValueQualifier( "name", EOQualifier.QualifierOperatorLike, "*" + searchString + "*" );
		EOFetchSpecification fs = new EOFetchSpecification( SWNewsItem.ENTITY_NAME, q, null );
		NSArray<SWNewsItem> a = ec.objectsWithFetchSpecification( fs );
		return a;
	}

	public static NSArray<? extends SWInspectable> recentStuff( EOEditingContext ec ) {
		EOQualifier q = SWNewsItem.MODIFICATION_DATE.isNotNull();
		EOFetchSpecification fs = new EOFetchSpecification( SWNewsItem.ENTITY_NAME, q, SWNewsItem.MODIFICATION_DATE.descs() );

		fs.setFetchLimit( 20 );

		return ec.objectsWithFetchSpecification( fs );
	}
}
