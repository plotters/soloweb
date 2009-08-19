package is.us.soloweb.admin;

import is.us.soloweb.data.SWTransaction;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

/**
 * @author Hugi Þórðarson
 */

public class SWPreviewTransaction extends ERXComponent {

	public String currentKey;
	public SWTransaction selectedObject;

	public SWPreviewTransaction( WOContext context ) {
		super( context );
	}

	public Object currentBeforeValue() {
		Object o = selectedObject.beforeDictionary().objectForKey( currentKey );

		if( "<com.webobjects.foundation.NSKeyValueCoding$Null>".equals( o ) )
			o = null;

		return o;
	}

	public Object currentAfterValue() {
		Object o = selectedObject.afterDictionary().objectForKey( currentKey );

		if( o == null )
			o = currentBeforeValue();

		if( "<com.webobjects.foundation.NSKeyValueCoding$Null>".equals( o ) )
			o = null;

		return o;
	}

	public String bgColor() {
		Object o = currentAfterValue();

		if( o == null )
			return null;

		if( o.equals( currentBeforeValue() ) )
			return null;

		return "99ff99";
	}
}