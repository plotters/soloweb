package is.us.soloweb.admin;

import is.us.soloweb.SWLoc;
import is.us.soloweb.SWSession;
import is.us.soloweb.SWSettings;
import is.us.soloweb.data.SWNewsItem;
import is.us.soloweb.interfaces.SWAsset;
import is.us.soloweb.interfaces.SWFolder;
import is.us.soloweb.util.SWAccessPrivilegeUtilities;
import is.us.soloweb.util.SWC;
import is.us.soloweb.util.SWFolderUtilities;
import is.us.util.USEOUtilities;
import is.us.util.USHierarchy;
import is.us.util.USHierarchyUtilities;
import is.us.util.USStringUtilities;
import is.us.util.USUtilities;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOModelGroup;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSMutableArray;

/**
 * The huge component that manages all assets.
 * 
 * @author Hugi Þórðarson
 * @version 2.9.2b4
 */

public class SWAssetManagement extends SWAdminComponent {

	public SWAsset currentObject;

	private SWFolder _selectedFolder;
	private SWAsset _selectedObject;
	private boolean _useID = false;
	private WOComponent _componentToReturn;
	private NSKeyValueCoding _record;
	private String _fieldName;
	private String _entityName;
	private String _folderEntityName;
	private String _editingComponentName;

	public String documentsTabName = SWLoc.string( "sfAdminTabDocuments", session() );
	public String privilegesTabName = SWLoc.string( "sfAdminTabAccessPrivileges", session() );

	public String selectedTab = documentsTabName;

	private NSArray<String> _tabs;

	public String searchString;

	public SWAssetManagement( WOContext c ) {
		super( c );
	}

	/**
	 * The asset name, abbreviated.
	 */
	public String shortName() {
		return USStringUtilities.abbreviate( currentObject.name(), 30 );
	}

	/**
	 * @return The tabs displayed to the user.
	 */
	public NSArray<String> tabs() {
		if( _tabs == null ) {
			NSMutableArray<String> tabs = new NSMutableArray<String>();
			tabs.addObject( documentsTabName );

			if( SWSettings.privilegesEnabled() && user().hasPrivilegeFor( selectedFolder(), SWC.PRIVILEGE_CAN_MANAGE_USERS ) ) {
				tabs.addObject( privilegesTabName );
			}

			_tabs = tabs.immutableClone();
		}

		return _tabs;
	}

	/**
	 * Search for a given document and select it.
	 */
	public WOActionResults search() {
		Integer id = new Integer( searchString );
		setSelectedObjectUsingID( id );
		return context().page();
	}

	/**
	 * I've got a feeling we can move some functionality around here.
	 */
	public void appendToResponse( WOResponse r, WOContext c ) {
		if( record() != null ) {
			if( selectedObject() != null ) {
				if( record().valueForKey( fieldName() ) != null ) {
					if( !useID() ) {
						setSelectedObject( (SWAsset)record().valueForKey( fieldName() ) );
					}
					else {
						setSelectedObjectUsingID( record().valueForKey( fieldName() ) );
					}
				}
			}
		}
		super.appendToResponse( r, c );
	}

	/**
	 * @return Primary key attribute name for the given entity.
	 */
	private String primaryKeyAttributeName() {
		return EOModelGroup.defaultGroup().entityNamed( entityName() ).primaryKeyAttributeNames().objectAtIndex( 0 );
	}

	/**
	 * @param object an object that can be converted to an Integer.
	 */
	private void setSelectedObjectUsingID( Object idObject ) {
		Integer id = USUtilities.integerFromObject( idObject );
		SWAsset object = (SWAsset)USEOUtilities.objectMatchingKeyAndValue( ec(), entityName(), primaryKeyAttributeName(), id );
		setSelectedObject( object );
	}

	public void setSelectedObject( SWAsset asset ) {
		if( asset != null ) {
			setSelectedFolder( asset.folder() );
		}

		_selectedObject = asset;
	}

	public void setSelectedFolder( SWFolder folder ) {
		_selectedFolder = folder;
		expandAllParents( _selectedFolder );
		setSelectedObject( null );
	}

	/**
	 * FIXME: This is just plain wrong.
	 */
	public String rowClass() {
		if( currentObject instanceof SWNewsItem ) {
			if( !((SWNewsItem)currentObject).isPublished() ) {
				return SWC.CSS_UNPUBLISHED;
			}
		}

		return null;
	}

	/**
	 * Indicates if the current object is selected.
	 */
	public boolean isSelected() {
		return currentObject.equals( selectedObject() );
	}

	/**
	 * Selectes the current object and returns the user to the calling page.
	 * 
	 * @return Te calling component.
	 */
	public WOActionResults selectObjectAndReturn() {

		if( !useID() ) {
			if( record() instanceof EOEnterpriseObject ) {
				((EOEnterpriseObject)record()).addObjectToBothSidesOfRelationshipWithKey( currentObject, fieldName() );
				ec().saveChanges();
			}
			else if( record() instanceof NSKeyValueCodingAdditions ) {
				((NSKeyValueCodingAdditions)record()).takeValueForKeyPath( currentObject, fieldName() );
			}
			else {
				record().takeValueForKey( currentObject, fieldName() );
			}
		}
		else {
			if( record() instanceof EOEnterpriseObject ) {
				((EOEnterpriseObject)record()).takeValueForKeyPath( currentObject.assetID(), fieldName() );
				ec().saveChanges();
			}
			else if( record() instanceof NSKeyValueCodingAdditions ) {
				((NSKeyValueCodingAdditions)record()).takeValueForKeyPath( currentObject.assetID(), fieldName() );
			}
			else {
				record().takeValueForKey( currentObject.assetID(), fieldName() );
			}
		}

		return returnBack();
	}

	public WOActionResults selectObject() {
		setSelectedObject( currentObject );
		return null;
	}

	public WOActionResults selectFolder() {
		setSelectedObject( null );
		return null;
	}

	public WOActionResults returnBack() {
		componentToReturn().ensureAwakeInContext( context() );
		return componentToReturn();
	}

	public WOActionResults deleteAsset() {
		currentObject.deleteAsset();
		setSelectedObject( null );
		return saveChanges();
	}

	public WOActionResults deleteSelectedFolder() {
		SWFolderUtilities.deleteFolder( selectedFolder() );
		setSelectedFolder( null );
		return saveChanges();
	}

	public WOActionResults createAsset() {
		SWAsset asset = (SWAsset)EOUtilities.createAndInsertInstance( ec(), entityName() );
		asset.setFolder( selectedFolder() );
		setSelectedObject( asset );
		return saveChanges();
	}

	public WOActionResults createRootFolder() {
		setSelectedFolder( SWFolderUtilities.newFolderWithNameAndParentFolder( ec(), null, null, folderEntityName() ) );
		return saveChanges();
	}

	public WOActionResults createSubFolder() {
		setSelectedFolder( SWFolderUtilities.newFolderWithNameAndParentFolder( ec(), null, selectedFolder(), folderEntityName() ) );
		return saveChanges();
	}

	public NSDictionary<String, String> privilegePairs() {
		return SWAccessPrivilegeUtilities.privilegePairsForObject( selectedFolder(), session() );
	}

	private void expandAllParents( USHierarchy object ) {
		NSArray<SWFolder> a = USHierarchyUtilities.everyParentNode( object, true );

		for( SWFolder nextParent : a ) {
			((SWSession)session()).addObjectToArrayWithKey( nextParent, folderEntityName() );
		}
	}

	public String entityName() {
		return _entityName;
	}

	public void setEntityName( String s ) {
		_entityName = s;
	}

	public String folderEntityName() {
		return _folderEntityName;
	}

	public void setFolderEntityName( String s ) {
		_folderEntityName = s;
	}

	public String editingComponentName() {
		return _editingComponentName;
	}

	public void setEditingComponentName( String s ) {
		_editingComponentName = s;
	}

	public void setUseID( boolean _useID ) {
		this._useID = _useID;
	}

	public boolean useID() {
		return _useID;
	}

	public void setComponentToReturn( WOComponent _componentToReturn ) {
		this._componentToReturn = _componentToReturn;
	}

	public WOComponent componentToReturn() {
		return _componentToReturn;
	}

	public void setRecord( NSKeyValueCoding _record ) {
		this._record = _record;
	}

	public NSKeyValueCoding record() {
		return _record;
	}

	public void setFieldName( String _fieldName ) {
		this._fieldName = _fieldName;
	}

	public String fieldName() {
		return _fieldName;
	}

	public SWFolder selectedFolder() {
		return _selectedFolder;
	}

	public SWAsset selectedObject() {
		return _selectedObject;
	}
}