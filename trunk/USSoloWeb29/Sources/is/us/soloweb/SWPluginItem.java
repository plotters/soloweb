package is.us.soloweb;

import com.webobjects.foundation.NSArray;

/**
 * A simple class that stores the name of a plugin, it's EOModels, and if schema should be dropped
 * or constructed for the current plugin. Just used in SWManageSettings.
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 * @since 2.5
 */

public class SWPluginItem {

	/**
	 * The plugin's name
	 */
	private String _name;

	/**
	 * The plugin's EOModels
	 */
	private NSArray<String> _models;

	/**
	 * Specifies if schema should be dropped for this model
	 */
	private boolean _dropSchema;

	/**
	 * Specifies if schema should be constructed for this model
	 */
	private boolean _constructSchema;

	/**
	 * The plugin's version identification string.
	 */
	private String _version;

	/**
	 * @return The Plugin's name
	 */
	public String name() {
		return _name;
	}

	public void setName( String newName ) {
		_name = newName;
	}

	public NSArray<String> models() {
		return _models;
	}

	public void setModels( NSArray<String> newModels ) {
		_models = newModels;
	}

	public String version() {
		return _version;
	}

	public void setVersion( String newVersion ) {
		_version = newVersion;
	}

	public String toString() {
		return "Name: " + name() + "\nModels: " + models() + "\ndropSchema: " + dropSchema() + "\nconstructSchema: " + constructSchema() + "\n";
	}

	public void setDropSchema( boolean dropSchema ) {
		this._dropSchema = dropSchema;
	}

	public boolean dropSchema() {
		return _dropSchema;
	}

	public void setConstructSchema( boolean constructSchema ) {
		this._constructSchema = constructSchema;
	}

	public boolean constructSchema() {
		return _constructSchema;
	}
}