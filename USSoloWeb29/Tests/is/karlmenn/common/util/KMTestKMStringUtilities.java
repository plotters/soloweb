package is.karlmenn.common.util;

import static org.junit.Assert.*;
import is.us.util.USStringUtilities;

import org.junit.Test;

/**
 * @author Hugi Þórðarson
 */

public class KMTestKMStringUtilities {

	@Test
	public void testStringWithFormatMultiple() {
		testStringWithFormat( "Hæ {}, segirðu ekki allt {}?", new Object[] { "Hugi", "gott" }, "Hæ Hugi, segirðu ekki allt gott?" );
		testStringWithFormat( "...{}{}{}.{}.", new Object[] { new Integer( 1 ), "2", "3", "4" }, "...123.4." );
	}

	private void testStringWithFormat( String inputString, Object[] inputParams, String expectedResult ) {
		String realResult = USStringUtilities.stringWithFormat( inputString, inputParams );
		assertEquals( expectedResult, realResult );
		assertTrue( true );
	}
}
