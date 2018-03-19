/**
 * 
 */
package etu.upmc.project.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tools {

	public static void shuffle(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int r = (int) (i + Math.random() * (array.length - i));

			int tmp = array[r];
			array[r] = array[i];
			array[i] = tmp;
		}
	}
	
	public static void shuffle(int[][] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int r = (int) (i + Math.random() * (array.length - i));

			int[] tmp = array[r].clone();
			array[r] = array[i].clone();
			array[i] = tmp.clone();
		}
	}

	public static float map(float value, float fromLow, float fromHigh, float toLow, float toHigh)
	{
		return (value - fromLow) * (toHigh - toLow) / (fromHigh - fromLow) + toLow;
	}

	public static double[][] load(String filename, double scaling, double landscapeAltitudeRatio)
	{
		double landscape[][] = null;

		try {
			BufferedImage bi = ImageIO.read(new File(filename));

			landscape = new double[bi.getWidth()][bi.getHeight()];

			for ( int x = 0 ; x != bi.getWidth() ; x++ )
			{
				for ( int y = 0 ; y != bi.getHeight() ; y++ )
				{
					int value = (bi.getRGB(x, y) & 0x00FF0000 ) / 0xF0000; 	// red
					landscape[x][bi.getHeight() - 1 - y] = value /255.0; // use only red as value.
				}
			}
		}
		catch ( IOException e )
		{
			System.err.println("[error] image \""+filename+"\" could not be loaded.");
			System.exit(-1);
		}

		landscape = Tools.scaleAndCenter(landscape, scaling, landscapeAltitudeRatio);
		landscape = Tools.smoothLandscape(landscape);

		return landscape;
	}

	public static double[][] scaleAndCenter(double[][] landscape, double scaling, double landscapeAltitudeRatio) 
	{
		double[][] myLandscape = landscape.clone();

		// * translate values to center around 0. re-scale, balance water/mountain.

		double minValue = landscape[0][0];
		double maxValue = landscape[0][0];

		for ( int x = 0 ; x != landscape.length ; x++ )
			for ( int y = 0 ; y != landscape[0].length ; y++ )
			{
				if (landscape[x][y] < minValue)
					minValue = landscape[x][y];
				else
					if ( landscape[x][y] > maxValue )
						maxValue = landscape[x][y];
			}

		double normalizeFactor = 1.0/(maxValue-minValue);

		for ( int x = 0 ; x != landscape.length ; x++ )
			for ( int y = 0 ; y != landscape[0].length ; y++ )
			{
				landscape[x][y] = landscape[x][y] - minValue;
				landscape[x][y] *= normalizeFactor; // [0;1]
				landscape[x][y] = landscape[x][y] - landscapeAltitudeRatio;
				landscape[x][y] *= scaling;
			}

		return myLandscape;
	}


	public static double[][] smoothLandscape (double[][] landscape)
	{
		int width 	= landscape.length;
		int height 	= landscape[0].length;

		// smoothing coasts (coast tiles will have a zero)
		for ( int x = 0 ; x != width ; x++ )
			for ( int y = 0 ; y != height ; y++ )
			{
				if ( landscape[x][y] < 0 )
				{
					if ( // one neighbor above ground is enough.
							landscape[(x-1+width)%width][(y-1+height)%height]>0 || landscape[x][(y-1+height)%height]>0 || landscape[(x+1)%width][(y-1+height)%height]>0 ||
							landscape[(x-1+width)%width][y]>0                   										 || landscape[(x+1)%width][y]>0      ||
							landscape[(x-1+width)%width][(y+1+height)%height]>0 || landscape[x][(y+1+height)%height]>0 || landscape[(x+1)%width][(y+1+height)%height]>0 ) 
						landscape[x][y] = 0.0;
				}
			}

		return landscape;
	}
}
