package is.us.soloweb.forms;

import is.us.soloweb.forms.data.SWFField;

/**
 * @author Hugi Þórðarson
 */

public interface SWFFieldContainer {

	public SWFField addField();

	public void removeField( SWFField field );
}
