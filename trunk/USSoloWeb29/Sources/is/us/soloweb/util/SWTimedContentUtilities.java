package is.us.soloweb.util;

import is.us.soloweb.interfaces.SWTimedContent;

import java.util.Enumeration;

import com.webobjects.foundation.*;

/**
* A utility class that works on SWTimedContent objects.
*
* @author Hugi Þórðarson
* @version 2.7
* @since 2.7
*/

public class SWTimedContentUtilities extends Object {

	/**
	* Returns true if this content unit's display time has come. Returns true if no value is specified for timeIn
	*/
	private static boolean isTimeInValid( SWTimedContent timedContent ) {

		if( timedContent.timeIn() == null )
			return true;

		if( System.currentTimeMillis() > timedContent.timeIn().getTime() )
			return true;

		return false;
	}

	/**
	* Returns true if this content unit's display time has expired. Returns true if no value is specified for timeIn
	*/
	private static boolean isTimeOutValid( SWTimedContent timedContent ) {

		if( timedContent.timeOut() == null )
			return true;

		if( System.currentTimeMillis() < timedContent.timeOut().getTime() )
			return true;

		return false;
	}

	/**
	* Returns true if this content's display time has come, and has not expired. Returns true if no values are specified for timeIn or timeOut.
	*/
	public static boolean validateDisplayTime( SWTimedContent timedContent ) {
		return isTimeInValid( timedContent ) && isTimeOutValid( timedContent );
	}

	/**
	* Takes an Array of SWTimedContent objects and returns it with the ones whose display time is not valid filtered out
	*/
	public static NSArray validateDisplayTimeForArray( NSArray inputArray ) {

		if( inputArray == null )
			return null;

		NSMutableArray anArray = new NSMutableArray();
		Enumeration e = inputArray.objectEnumerator();

		while( e.hasMoreElements() ) {
			SWTimedContent timedContent = ((SWTimedContent)e.nextElement());

			if( timedContent != null )
				if( timedContent.isTimeValid() )
					anArray.addObject( timedContent );
		}

		return anArray;
	}
}