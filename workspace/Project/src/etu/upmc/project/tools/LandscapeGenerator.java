package etu.upmc.project.tools;

public class LandscapeGenerator {

	public static final int ENVIRONMENT_SAND		= 1 << 1;
	public static final int ENVIRONMENT_FOREST		= 1 << 2;
	public static final int ENVIRONMENT_WATER		= 1 << 3;
	public static final int ENVIRONMENT_VOLCANO		= 1 << 4;

	public static int[][] generateLandscape(double[][] altitude, double[][] moisture)
	{
		//TODO : use two heightmaps, one for altitude, the other for moisture aka the amount of water in the soil
		//TODO : can be used for growing trees faster and having sand
		int width = altitude[0].length;
		int height = altitude.length;
		int[][] buffer = new int[width][height];

		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				if(altitude[x][y] > 0.75)
				{
					if(Math.random() > 0.8)
					{
						buffer[x][y] = ENVIRONMENT_VOLCANO;
					}
				}

				if(altitude[x][y] <= -0.3) 
				{
					buffer[x][y] = ENVIRONMENT_WATER;
				}

				if(altitude[x][y] > 0.0 && altitude[x][y] < 0.3) //sable et arbre aka sarbre (sabre ? sabbre ?)
				{

					//TODO : use moisture heightmap for cleaner distribution ?
					boolean waterCloseBy = false;
					// cas idéal ou on est loin des bordures pour pouvoir tester autour sans problème
					if(x >= 5 && y >= 5 && x+5 < width && y+5 < height) 
					{
						for(int a = x-5; a < x+5;a++)
						{
							for(int b = y-5; b < y + 5; b++)
							{
								if(altitude[a][b] <= 0.0)
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
								if(altitude[a][b] <= 0.0)
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
								if(altitude[a][b] <= 0.0)
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
								if(altitude[a][b] <= 0.0)
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
								if(altitude[a][b] <= 0.0)
								{
									waterCloseBy = true;
								}
							}
						}
					}
					//on ne s'occupe pas des coins : zone trop petite
					if(waterCloseBy)
					{
						buffer[x][y] = ENVIRONMENT_FOREST;
					}
					else 
					{
						buffer[x][y] = ENVIRONMENT_SAND;
					}
				}
			}
		}
		return buffer;
	}
}



