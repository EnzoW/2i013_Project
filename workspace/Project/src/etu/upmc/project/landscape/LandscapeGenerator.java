package etu.upmc.project.landscape;

public class LandscapeGenerator {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int ENVIRONMENT_WATER		= 1 << 0; // 1
	public static final int ENVIRONMENT_SAND		= 1 << 1; // 2
	public static final int ENVIRONMENT_FOREST		= 1 << 2; // 4
	public static final int ENVIRONMENT_VOLCANO		= 1 << 3; // 8
	
	public static final double WATER_ALTITUDE 		= 0.1;
	
	private static final double SCALING 			= 1;
	private static final double ALTITUDE_RATIO 		= 0.3;
	private static final double FOREST_ALTITUDE 	= 0.4;
	private static final int 	NB_MAX_VOLCANO		= 2;
	private static final double FEATURE_SIZE 		= 64;

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

		int iteratorVolcano = 0;
		
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				if(elevation[x][y] > 0.99 * maxValue && iteratorVolcano < NB_MAX_VOLCANO && Math.random() < 0.2)
				{
					buffer[x][y] = ENVIRONMENT_VOLCANO;
					iteratorVolcano++;
				}

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
					}//cas spéciaux des quatres bords :
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