/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.landscape;

import etu.upmc.project.config.Config;
import etu.upmc.project.config.Constants;

public class LandscapeGenerator {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int ENVIRONMENT_WATER		= 1 << 0;
	public static final int ENVIRONMENT_SAND		= 1 << 1;
	public static final int ENVIRONMENT_FOREST		= 1 << 2;
	
	private static final double SCALING 			= Config.getProperty(Constants.SCALING);
	private static final double ALTITUDE_RATIO 		= Config.getProperty(Constants.ALTITUDE_RATIO);
	private static final double FEATURE_SIZE 		= Config.getProperty(Constants.FEATURE_SIZE);
	private static final double FOREST_ALTITUDE 	= Config.getProperty(Constants.FOREST_ALTITUDE);
	public 	static final double WATER_ALTITUDE 		= Config.getProperty(Constants.WATER_ALTITUDE);

	public static int[][] generateLandscape(int width, int height, double[][] elevation)
	{
		int[][] buffer = new int[width][height];
		double[] minMax = GenerateAltitude(width, height, elevation);
		double minValue = minMax[0];
		double maxValue = minMax[1];
		double normalizeFactor = 1.0 / (maxValue - minValue);

		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				elevation[x][y] = elevation[x][y] - minValue;
				elevation[x][y] *= normalizeFactor; // [0;1]
				elevation[x][y] = elevation[x][y] - ALTITUDE_RATIO;
				elevation[x][y] *= SCALING;
			}
		}

		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				if(elevation[x][y] <= WATER_ALTITUDE * minValue) 
				{
					buffer[x][y] = ENVIRONMENT_WATER;
				}

				if(elevation[x][y] > WATER_ALTITUDE * minValue && elevation[x][y] < FOREST_ALTITUDE * maxValue) //sable et arbre aka sarbre (sabre ? sabbre ?)
				{
					boolean waterCloseBy = false;
					if (x >= 5 && y >= 5 && x + 5 < width && y + 5 < height) 
					{
						for (int a = x - 5; a < x + 5; a++)
						{
							for (int b = y - 5; b < y + 5; b++)
							{
								if (elevation[a][b] <= 0.0)
								{
									waterCloseBy = true;
								}
							}
						}
					} //cas speciaux des quatres bords :
					else if(x >= 5 && y >= 5 && x+5 >= width && y+5 < height) //au bord est : x+5>=width
					{
						for(int a = x-5; a < x;a++)
						{
							for(int b = y-5; b < y + 5; b++)
							{
								if(elevation[a][b] <= 0.0)
								{
									waterCloseBy = true;
								}
							}
						}
					}
					else if(x >= 5 && y < 5 && x+5 < width && y+5 < height) //au bord sud : y-5<0
					{
						for(int a = x-5; a < x + 5;a++)
						{
							for(int b = y; b < y + 5; b++)
							{
								if(elevation[a][b] <= 0.0)
								{
									waterCloseBy = true;
								}
							}
						}
					}
					else if(x < 5 && y >= 5 && x+5 < width && y+5 < height) //bord ouest : x-5<0
					{
						for(int a = x; a < x+5;a++)
						{
							for(int b = y-5; b < y + 5; b++)
							{
								if(elevation[a][b] <= 0.0)
								{
									waterCloseBy = true;
								}
							}
						}
					}
					else if(x >= 5 && y >= 5 && x+5 < width && y+5 >= height) //bord nord : y+5>height
					{
						for(int a = x-5; a < x+5;a++)
						{
							for(int b = y-5; b < y; b++)
							{
								if(elevation[a][b] <= 0.0)
								{
									waterCloseBy = true;
								}
							}
						}
					}
					//on ne s'occupe pas des coins : zone trop petite
					if(waterCloseBy)
					{
						buffer[x][y] = ENVIRONMENT_SAND;
					}
					else 
					{
						buffer[x][y] = ENVIRONMENT_FOREST;
					}
				}
			}
		}

		return buffer;
	}
	
	private static double[] GenerateAltitude(final int width, final int height, double[][] elevation) 
	{
		OpenSimplexNoise landscape = new OpenSimplexNoise((long)(Math.random() * 1000));
//		SimplexNoise noise = new SimplexNoise(10, 0.7, (int) (Math.random() * 1000));
		double min, max;
		
		min = Double.MAX_VALUE;
		max = Double.MIN_VALUE;
		
		for (int x = 0; x < width; x++) 
		{
			for (int y = 0; y < height; y++) 
			{
//				elevation[x][y] = noise.getNoise(x, y, 0);
				elevation[x][y] = landscape.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 0);
				if (elevation[x][y] < min)
				{
					min = elevation[x][y];
				}
				else if (elevation[x][y] > max)
				{
					max = elevation[x][y];
				}
			}
		}
		
		return new double[] {min, max};
	}
}