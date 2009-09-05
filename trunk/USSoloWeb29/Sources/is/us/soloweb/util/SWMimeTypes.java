package is.us.soloweb.util;

import java.util.List;

/**
 * For handling with mimetypes in data.
 * 
 * @author Hugi Þórðarson
 */

public class SWMimeTypes {

	public static final String XML = "text/xml";

	public static class SWMimeType {

		private String _mimeType;
		private String _extension;

		public SWMimeType( String extension, String mimeType ) {
			_extension = extension;
			_mimeType = mimeType;
		}
	}
}