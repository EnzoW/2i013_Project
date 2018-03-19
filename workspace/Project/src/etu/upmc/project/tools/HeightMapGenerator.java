package etu.upmc.project.tools;

import etu.upmc.project.tools.simplexnoise.OpenSimplexNoise;

public class HeightMapGenerator {

	private static final double FEATURE_SIZE = 100;

	public static double[][] GenerateAltitude(final int width, final int height) 
	{
		OpenSimplexNoise Landscape = new OpenSimplexNoise((long) (int) (Math.random() * 1000));
		double[][] heightMap = new double[width][height];
		for (int x = 0; x < width; x++) 
		{
			for (int y = 0; y < height; y++) 
			{
				heightMap[x][y] = Landscape.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 0.0);
			}
		}
		return heightMap;
	}
}
