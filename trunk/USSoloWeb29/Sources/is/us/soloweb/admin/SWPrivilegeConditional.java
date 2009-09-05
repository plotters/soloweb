package is.us.soloweb.admin;

import is.us.soloweb.SWSettings;
import is.us.util.USUtilities;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEnterpriseObject;

/**
 * @author Hugi Þórðarson
 */

public class SWPrivilegeConditional extends SWAdminComponent {

	private static final String CONDITION = "condition";
	private static final String RECORD = "record";
	private static final String PRIVILEGE_IDENTIFIER = "identifier";

	public SWPrivilegeConditional( WOContext context ) {
		super( context );
	}

	public String identifier() {
		return stringValueForBinding( PRIVILEGE_IDENTIFIER );
	}

	public EOEnterpriseObject record() {
		return (EOEnterpriseObject)valueForBinding( RECORD );
	}

	public Object condition() {
		return valueForBinding( CONDITION );
	}

	public boolean hasPrivilege() {

		if( !SWSettings.privilegesEnabled() )
			return true;

		if( record() != null && identifier() != null ) {
			return user().hasPrivilegeFor( record(), identifier() );
		}

		if( condition() != null )
			return USUtilities.booleanFromObject( condition() );

		return false;
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public boolean isStateless() {
		return true;
	}
}