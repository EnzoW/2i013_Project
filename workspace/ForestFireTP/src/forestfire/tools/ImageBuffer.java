package forestfire.tools;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class is a wrap-up of the classic BufferedImage class. It provides simplified accessing method for RGB image.
 * You may want to display this image by enclosing it into an ImageFrame object.
 * 
 * @author nicolas
 * 20070919
 *
 */
public class ImageBuffer extends BufferedImage {

	public ImageBuffer(int width, int height) {
		super(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	/**
	 * update forest.
 	 * 	cells[x][y] == 0 : no tree
	 *  cells[x][y] == 1 : tree
	 *  cells[x][y] == 2 : burning tree
	 * @param cells
	 */
	public void updateForest (int[][] cells)
	{
		if ( cells.length != this.getWidth() )
		{
			System.err.println("array length does not match with image length.");
			System.exit(-1);
		}
		
		for ( int y = 0 ; y != cells[0].length ; y++ )
			for ( int x = 0 ; x != cells.length ; x++ )
			{
				switch ( cells[x][y]  )
				{
					case 0:
						this.setPixel(x,y,255,255,255);
						break;
					case 1:
						this.setPixel(x,y,0,255,0);
						break;
					default:
					case 2:
						this.setPixel(x,y,255,0,0);
				}
			}
	}
	
    static public ImageBuffer loadFromDisk( String __filename)
    {
    	ImageBuffer image = null; 
    	try {
    		BufferedImage bi = ImageIO.read(new File(__filename));
    		image = new ImageBuffer(bi.getWidth(),bi.getHeight());
    		for ( int x = 0 ; x != bi.getWidth() ; x++ )
    			for ( int y = 0 ; y != bi.getHeight() ; y++ )
    				image.setRGB(x, y, bi.getRGB(x, y));
    	}
    	catch ( IOException e )
    	{
    		System.err.println("[error] image \""+__filename+"\" could not be loaded.");
    	}
    	return image;
    }
    
    /**
     * save current image buffer to PNG file. 
     * @param __filename output filename without extension
     */
    public void saveToDisk( String __filename )
    {
    	try {
    		ImageIO.write(this, "png", new File(__filename + ".png"));
    	}
    	catch ( IOException e )
    	{
    		System.err.println("[error] image \""+__filename+"\" could not be written to disk.");
    	}
    }
    
    /**
     * set target pixel color (RGB) -- color values btw 0 and 255
     * @param x
     * @param y
     * @param rgb a 3-values array containing [red,green,blue] values
     */
    public void setPixel( int x, int y , int rgb[] )
    {
    	this.setPixel(x, y, rgb[0] , rgb[1] , rgb[2]);
    }


    /**
     * set target pixel color (RGB) -- color values btw 0 and 255
     * @param x
     * @param y
     * @param red
     * @param green
     * @param blue
     */
    public void setPixel( int x, int y , int red, int green, int blue )
    {
    	int colorValues;
    	colorValues = 0xFF000000; // alpha set non transparent
		colorValues += red * 256*256; // red
		colorValues += green * 256; // green
		colorValues += blue ; // blue
    	this.setRGB(x, y, colorValues);
    }
    
    /**
     * return target pixel color
     * @param x
     * @param y
     * @return a 3-values array containing [red,green,blue] values -- color values btw 0 and 255
     */
    public int[] getPixel( int x, int y )
    {
    	int [] rgb = new int[3];
		int rawvalue = this.getRGB(x, y);
		rgb[0] = ( rawvalue & 0x00FF0000 ) / (int)Math.pow(256,2); // red
		rgb[1] = ( rawvalue & 0x0000FF00 ) / 256; // green
		rgb[2] = ( rawvalue & 0x000000FF ); // blue
    	return rgb;
    }

    // HSV methods (same as RGB but handles HSV values in and out) -- all values btw [0..1]
    public double[] getPixelHSB( int x, int y )
    {
    	int[] rgb = this.getPixel(x, y);
    	float[] hsvFloat = java.awt.Color.RGBtoHSB(rgb[0], rgb[1], rgb[2], null);
    	double[] hsv = new double[3];
    	for (int i = 0; i < hsv.length; i++) 			
    		hsv[i] = hsvFloat[i];
    	return hsv;
    }
    public void setPixelHSB( int x, int y , double[] hsb)
    {
    	this.setPixelHSB(x, y, hsb[0], hsb[1], hsb[2]);
    }
    public void setPixelHSB( int x, int y , double h, double s, double b )
    {
    	int rgb = java.awt.Color.HSBtoRGB((float)h,(float)s,(float)b);
    	this.setRGB(x, y, rgb);
    }
    
    /**
     * fill screen with given color values (cls means "clear screen")
     * @param r
     * @param g
     * @param b
     */
	public void cls(int r, int g, int b) 
	{
		for ( int x = 0 ; x != this.getWidth() ; x++ )
			for ( int y = 0 ; y != this.getHeight() ; y++ )
				this.setPixel(x,y,r,g,b);
	}


    
    public void writeText(String __text)
    {
    	Graphics2D g = this.createGraphics();
    	g.setColor(Color.GREEN);
        g.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 36));
        g.drawString("Hello, World!", 10, 50);
        g.dispose();
    }
}
