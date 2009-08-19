package is.us.soloweb.settings;

import is.us.soloweb.SWSettings;
import is.us.soloweb.data.SWGroup;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

/**
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 */

public class SWSettingsAccessControl extends SWSettingsPanel {

	public SWGroup currentGroup;

	public SWSettingsAccessControl( WOContext context ) {
		super( context );
	}

	public NSArray<SWGroup> allGroups() {
		return SWGroup.allGroups( ec() );
	}

	public SWGroup selectedGroup() {
		return SWGroup.fetchSWGroup( ec(), SWGroup.GROUP_ID.eq( SWSettings.allUsersGroupID() ) );
	}

	public void setSelectedGroup( SWGroup g ) {
		if( g == null )
			selectedDictionary().takeValueForKey( null, SWSettings.ALL_USER_GROUP_ID );
		else
			selectedDictionary().takeValueForKey( g.groupID(), SWSettings.ALL_USER_GROUP_ID );
	}
}