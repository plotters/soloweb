package is.us.soloweb.admin;

import is.us.soloweb.data.SWSite;
import is.us.soloweb.interfaces.SWInspectionComponent;

import java.util.Locale;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.*;

import er.extensions.foundation.ERXArrayUtilities;

/**
 * @author Hugi Þórðarson
 * 
 * FIXME: Finish implementing locale popup.
 */

public class SWEditSiteGeneralInfo extends SWInspectionComponent<SWSite> {

	public String currentLocaleName;

	public SWEditSiteGeneralInfo( WOContext context ) {
		super( context );
	}

	public NSArray<String> availableLocales() {
		NSMutableArray<String> localeNames = new NSMutableArray<String>();

		for( Locale l : Locale.getAvailableLocales() ) {
			localeNames.addObject( l.getLanguage() );
		}

		NSArray<String> a = ERXArrayUtilities.arrayWithoutDuplicates( localeNames );
		return ERXArrayUtilities.sortedArrayUsingComparator( a, NSComparator.AscendingCaseInsensitiveStringComparator );
	}
}