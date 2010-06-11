package is.us.soloweb.admin;

import is.us.soloweb.data.SWDocument;
import is.us.thirdparty.ImageInfo;
import is.us.util.*;
import is.us.util.USImageUtilities.CodecType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

/**
 * Used to preview and edit a picture in the admin system.
 * 
 * @author Hugi Þórðarson
 */

public class SWDocEditPicture extends SWDocEditGeneric {

	/**
	 * The color used for hightlighting when cropping, red, green, blue, transparency
	 */
	public static final Color HIGHLIGHT_COLOR = new Color( 0, 0, 0, 70 );

	public int scalePercentage = 100;
	public String compression = "70";

	public int width = 0;
	public int height = 0;

	public NSData tempData;

	public NSArray<String> qualityValues = new NSArray<String>( new String[] { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" } );

	public SWDocEditPicture( WOContext context ) {
		super( context );
	}

	public int width() {
		if( width == 0 ) {
			width = imageWidth();
		}

		return width;
	}

	public int height() {
		if( height == 0 ) {
			height = imageHeight();
		}

		return height;
	}

	public WOActionResults resize() {

		if( widthHasChanged() || heightHasChanged() ) {

			if( !widthHasChanged() )
				width = imageWidth();

			if( !heightHasChanged() )
				height = imageHeight();

			scale( document(), width, height, Integer.parseInt( compression ) );
		}

		scalePercentage = 100;
		width = imageWidth();
		height = imageHeight();

		return null;
	}

	public boolean sizeHasChanged() {
		return (scalePercentage != 0) && (scalePercentage != 100);
	}

	public boolean widthHasChanged() {
		return ((width != 0) && (width != imageWidth()));
	}

	public boolean heightHasChanged() {
		return ((height != 0) && (height != imageHeight()));
	}

	public String anURL() {
		int randomNumber = new Random().nextInt( 32000 );
		return document().documentURL( context() ) + "?" + randomNumber;
	}

	/* Image cropping code */

	public int x1 = -1;
	public int y1 = -1;
	public int x2 = -1;
	public int y2 = -1;

	public void setX( int newX ) {
		if( x1 < 0 )
			x1 = newX;
		else
			x2 = newX;
	}

	public void setY( int newY ) {
		if( y1 < 0 )
			y1 = newY;
		else
			y2 = newY;
	}

	public int x() {
		return 0;
	}

	public int y() {
		return 0;
	}

	public boolean hasTwoPoints() {
		return x1 > -1 && x2 > -1 && y1 > -1 && y2 > -1;
	}

	public WOActionResults selectAreaForCropping() {

		if( x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 )
			return null;

		BufferedImage image = bufferedImage();

		Graphics graphics = image.getGraphics();
		graphics.setColor( HIGHLIGHT_COLOR );
		graphics.fillRect( x1, y1, x2 - x1 + 1, y2 - y1 + 1 );

		tempData = new NSData( USImageUtilities.encode( image, 80, CodecType.JPEG ) );

		return null;
	}

	public WOActionResults performCrop() {
		BufferedImage image = bufferedImage();
		image = image.getSubimage( x1, y1, x2 - x1, y2 - y1 );
		document().setData( new NSData( USImageUtilities.encode( image, 80, CodecType.JPEG ) ) );
		tempData = null;

		x1 = -1;
		y1 = -1;
		x2 = -1;
		y2 = -1;

		return null;
	}

	public BufferedImage bufferedImage() {
		return USImageUtilities.bufferedImageFromData( document().data().bytes() );
	}

	private ImageInfo imageInfo() {
		return USImageUtilities.imageInfo( document().data().bytes() );
	}

	public int imageWidth() {
		return imageInfo().getWidth();
	}

	public int imageHeight() {
		return imageInfo().getHeight();
	}

	public String formatName() {
		return imageInfo().getFormatName();
	}

	/**
	 * Takes the given SWPicture and scales it to the given size
	 *
	 * @param document The picture to scale
	 * @param width The new width
	 * @param height The new height
	 * @param qualityPercent The JPEG quality to write out (1-100)
	 */
	private static void scale( SWDocument document, int width, int height, int qualityPercent ) {
		NSData d = new NSData( USImageUtilities.scale( document.data().bytes(), width, height, qualityPercent, USImageUtilities.CodecType.JPEG ) );

		if( d != null && d.length() > 0 )
			document.setData( d );
	}

	/**
	 * Takes the given SWPicture, scales it by the given percentage and resaves it as JPEG.
	 *
	 * @param document The picture to scale
	 * @param scalePercent The percentage to scale by (from 1-infinity)
	 * @param qualityPercent The JPEG quality to write out (1-100)
	 *
	private static void scale( SWDocument document, int scalePercent, int qualityPercent ) {

	    if( document != null ) {
	        int newWidth = (int)(float)(SWPictureUtilities.imageInfo( document.data() ).getWidth() * ( (float)scalePercent/(float)100 ));
	        int newHeight = (int)((float)SWPictureUtilities.imageInfo( document.data() ).getHeight() * ( (float)scalePercent/(float)100 ));
	        scale( document, newWidth, newHeight, qualityPercent );
	    }
	}
	 */
}