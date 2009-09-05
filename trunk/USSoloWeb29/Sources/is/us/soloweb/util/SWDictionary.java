package is.us.soloweb.util;

import is.us.util.*;

import java.io.File;

import org.slf4j.*;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.*;

/**
 * SWDictionary wraps com.webobjects.foundation's NSMutableDictionary and adds two key features:
 *
 * You can assign a file to the dictionary, and it will be kept in sync with the dictionary's contents
 * The dictionary implements neccessary code for automatic encoding/decoding to/from an ascii-plist, so it can be used for  custom attributes in EOF
 * 
 * Not all methods in NSMutableDictionary are implemented by SWDictionary, but you can easily convert between the types by calling this.propertiesDict().mutableClone()
 *
 * @author Hugi Þórðarson
 * @version 2.9.2b3
 * @since 2.5
 */

public class SWDictionary<E, T> extends NSMutableDictionary {

	private static final Logger logger = LoggerFactory.getLogger( SWDictionary.class );

	private NSDictionary<E, T> propertiesDict;
	private File file;
	private EOEnterpriseObject owningObject;

	public EOEnterpriseObject owningObject() {
		return owningObject;
	}

	public void setOwningObject( EOEnterpriseObject newObject ) {
		owningObject = newObject;
	}

	/**
	 * Initializes an empty SWDictionary
	 */
	public SWDictionary() {
		setPropertiesDict( new NSDictionary() );
	}

	/**
	 * Initializes an SWDictionary using the specified File. If the file does not exist,
	 * an empty SWDictionary is created and the file is then written to disk.
	 *
	 * @param newFile the File to write to
	 */
	public SWDictionary( File newFile ) {
		setFile( newFile );

		if( !newFile.exists() ) {
			setPropertiesDict( new NSDictionary() );
		}

		read();
	}

	/**
	 * Initializes an SWDictionary from a standard ascii-plist String using NSPropertyListSerialization.
	 *
	 * @param aString A standard ascii-plist string
	 */
	public SWDictionary( String aString ) {
		try {
			setPropertiesDict( (NSDictionary)NSPropertyListSerialization.propertyListFromString( aString ) );
		}
		catch( Exception e ) {
			logger.error( "======> SWDictionary initialization with String \"" + aString + "\" failed", e );
		}
	}

	/**
	 * Initializes an SWDictionary from an NSData object. First converts the NSData to
	 * a string using UTF-8 Encoding, then reads it using NSPropertyListSerialization.
	 *
	 * @param aString A standard ascii-plist string
	 */
	public SWDictionary( NSData data ) {
		try {
			String aString = USStringUtilities.stringFromDataUsingEncoding( data.bytes(), SWC.ENCODING_UTF_8 );
			setPropertiesDict( (NSDictionary)NSPropertyListSerialization.propertyListFromString( aString ) );
		}
		catch( Exception e ) {
			logger.error( "======> SWDictionary initialization with Data failed", e );
		}
	}

	/**
	 * Returns the SWDictionary's contents as an NSDictionary
	 */
	private NSDictionary propertiesDict() {
		return propertiesDict;
	}

	/**
	 * Sets the SWDictionary's contents from an NSDictionary
	 *
	 * @param newDictionary The NSDictionary to read from
	 */
	private void setPropertiesDict( NSDictionary newDictionary ) {
		propertiesDict = newDictionary;
		write();
	}

	/**
	 * Standard implementation of this NSKeyValueCoding method
	 * 
	 * FIXME: This is fucked up, find out why it exists.
	 */
	public Object valueForKey( String s ) {

		Object obj = propertiesDict().valueForKey( s );

		if( obj == null && s != null ) {
			if( s.equals( "owningObject" ) )
				return owningObject();
		}
		else if( obj instanceof NSDictionary )
			obj = new NSMutableDictionary( (NSDictionary)obj );

		return obj;
	}

	/**
	 * Same implementation of NSKeyValueCoding as in NSMutableDictionary. calls setObjectForKey(), unless
	 * the specified value is null, in which case the specified key is removed.
	 */

	public void takeValueForKey( Object myValue, String myKey ) {
		takeValueForKeyRemovingIfNull( myValue, myKey, true );
	}

	/**
	 * Returns the object stored by this key. Corresponds to NSDictionary.objectForKey()
	 *
	 * @param aKey The key
	 */
	public Object objectForKey( Object aKey ) {
		return valueForKey( (String)aKey );
	}

	/**
	 * Returns the object stored by this key. Corresponds to NSDictionary.objectForKey()
	 */
	public void setObjectForKey( Object myValue, String myKey ) {
		takeValueForKeyRemovingIfNull( myValue, myKey, false );
	}

	/**
	 * Reads the File specified for this dictionary object
	 */
	private void read() {
		try {
			String s = USStringUtilities.readStringFromFileUsingEncoding( file(), SWC.ENCODING_UTF_8 );
			NSDictionary aDict = (NSDictionary)NSPropertyListSerialization.propertyListFromString( s );
			setPropertiesDict( aDict );
		}
		catch( Exception e ) {
			setPropertiesDict( new NSDictionary() );
		}
	}

	/**
	 * Writes the dictionary's contents to the dictionary's file
	 */
	public void write() {
		if( file() != null ) {
			String s = NSPropertyListSerialization.stringFromPropertyList( propertiesDict );
			USStringUtilities.writeStringToFileUsingEncoding( s, file, SWC.ENCODING_UTF_8 );
		}
	}

	/**
	 * Returns the file specified for this dictionary. This file is always kept in sync with the dictionary's contents.
	 */
	private File file() {
		return file;
	}

	/**
	 * Sets the file for this dictionary. This file is always kept in sync with the dictionary's contents.
	 *
	 * @param newFile The file to keep in sync with the dictionary
	 */
	private void setFile( File newFile ) {
		file = newFile;
	}

	/**
	 * A method required by EOF to support reading data from a custom attribute. Just returns a new dictionary constructed by calling 'new SWDictionary( aString )' 
	 *
	 * @param newFile The file to keep in sync with the dictionary
	 */
	public static SWDictionary objectWithArchiveData( String aString ) {
		return new SWDictionary( aString );
	}

	/**
	 * A method required by EOF to support saving to a custom attribute. Returns the dictionary serialized by NSPropertyListSerialization
	 */
	public String archiveData() {
		String aString = NSPropertyListSerialization.stringFromPropertyList( propertiesDict() );
		return aString;
	}

	/**
	 * Returns all key-values stored in the dictionary
	 */
	public NSArray allKeys() {
		return propertiesDict().allKeys();
	}

	/**
	 * Removes the specified object from the Dictionary
	 *
	 * @param aKey The key reference to the object to remove
	 */
	public Object removeObjectForKey( Object aKey ) {
		Object anObject = propertiesDict().objectForKey( aKey );
		NSMutableDictionary aDict = new NSMutableDictionary( propertiesDict() );
		aDict.removeObjectForKey( aKey );
		setPropertiesDict( aDict );

		write();

		return anObject;
	}

	/**
	 * Attempt to coerce the value returned by "key" to a boolean
	 */
	public boolean booleanValueForKey( String key ) {
		Object o = valueForKey( key );
		return USUtilities.booleanFromObject( o );
	}

	/**
	 * Attempt to coerce the value returned by "key" to a String
	 */
	public String stringValueForKey( String key ) {
		Object o = valueForKey( key );
		return USUtilities.stringFromObject( o );
	}

	/**
	 * Attempt to coerce the value returned by "key" to an Integer
	 */
	public Integer integerValueForKey( String key ) {
		Object o = valueForKey( key );
		return USUtilities.integerFromObject( o );
	}

	/**
	 * Displays the contents of the SWDictionary as a String
	 */
	public String toString() {
		return propertiesDict().toString();
	}

	public boolean equals( Object o ) {
		return false;
	}

	/**
	 * Creates a new SWDictionary object, identical to the calling one.
	 */
	public Object clone() {

		SWDictionary newInstance = new SWDictionary();

		newInstance.setPropertiesDict( propertiesDict() );
		newInstance.setFile( file() );
		newInstance.setOwningObject( owningObject() );

		return newInstance;
	}

	public boolean hasFile() {
		return file().exists();
	}

	private void takeValueForKeyRemovingIfNull( Object myValue, String myKey, boolean removeIfNull ) {

		NSMutableDictionary aDict = new NSMutableDictionary( propertiesDict() );

		if( myValue == null && removeIfNull )
			aDict.removeObjectForKey( myKey );
		else
			aDict.setObjectForKey( myValue, myKey );

		setPropertiesDict( aDict );

		if( owningObject() != null ) {
			owningObject().takeValueForKey( this.clone(), "customInfo" );
		}

		write();
	}
}