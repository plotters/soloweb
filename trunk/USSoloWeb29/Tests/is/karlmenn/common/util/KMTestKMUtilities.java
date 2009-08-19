package is.karlmenn.common.util;

import static org.junit.Assert.*;
import is.us.util.USUtilities;

import org.junit.Test;

import com.webobjects.foundation.NSMutableDictionary;

/**
 * @author Hugi Þórðarson
 */

public class KMTestKMUtilities {

	@Test
	public void integerFromObject() {
		assertEquals( new Integer( 1 ), USUtilities.integerFromObject( new Integer( 1 ) ) );
		assertEquals( new Integer( 2 ), USUtilities.integerFromObject( "2" ) );
		assertEquals( new Integer( 3 ), USUtilities.integerFromObject( new Float( 3.3 ) ) );
		assertEquals( new Integer( 4 ), USUtilities.integerFromObject( new Double( 4.444 ) ) );
		assertEquals( new Integer( 5555 ), USUtilities.integerFromObject( new Long( 5555 ) ) );
		assertEquals( new Integer( 6 ), USUtilities.integerFromObject( new Double( 6.999999 ) ) );
	}

	@Test
	public void booleanFromObject() {
		assertFalse( USUtilities.booleanFromObject( null ) );
		assertTrue( USUtilities.booleanFromObject( 1 ) );
		assertTrue( USUtilities.booleanFromObject( -1 ) );
		assertFalse( USUtilities.booleanFromObject( 0 ) );
		assertFalse( USUtilities.booleanFromObject( new Double( 0 ) ) );
		assertFalse( USUtilities.booleanFromObject( new Long( 0 ) ) );
		assertFalse( USUtilities.booleanFromObject( new Long( 0 ) ) );
		assertFalse( USUtilities.booleanFromObject( "false" ) );
		assertTrue( USUtilities.booleanFromObject( "true" ) );
		assertFalse( USUtilities.booleanFromObject( "fsdfsdf" ) );
		assertTrue( USUtilities.booleanFromObject( new Long( 1 ) ) );
		assertTrue( USUtilities.booleanFromObject( new Long( 10 ) ) );
		assertTrue( USUtilities.booleanFromObject( new Long( 2 ) ) );
		assertTrue( USUtilities.booleanFromObject( new Long( 3 ) ) );
		assertTrue( USUtilities.booleanFromObject( new Long( 3 ) ) );
	}

	@Test
	public void numberIsTrue() {
		assertFalse( USUtilities.numberIsTrue( null ) );
		assertFalse( USUtilities.numberIsTrue( 0 ) );
		assertFalse( USUtilities.numberIsTrue( 2 ) );
		assertTrue( USUtilities.numberIsTrue( 1 ) );
	}

	@Test
	public void dictionaryFromString() {
		assertEquals( new NSMutableDictionary(), USUtilities.dictionaryFromString( null ) );
		assertEquals( new NSMutableDictionary(), USUtilities.dictionaryFromString( "{}" ) );
		assertEquals( new NSMutableDictionary( "value", "key" ), USUtilities.dictionaryFromString( "{ \"key\"=\"value\"; }" ) );
	}

	@Test
	public void stringFromObject() {
		assertEquals( "1", USUtilities.stringFromObject( new Integer( 1 ) ) );
	}
}