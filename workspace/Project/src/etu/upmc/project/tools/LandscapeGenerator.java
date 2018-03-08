/**
 * 
 */
package etu.upmc.project.tools;

public class LandscapeGenerator {
	
	public static final int ENVIRNMENT_SAND			= 1 << 1;
	public static final int ENVIRNMENT_FOREST		= 1 << 2;	
	public static final int ENVIRNMENT_WATER		= 1 << 3;
	public static final int ENVIRNMENT_VOLCANO		= 1 << 4;	

	public static int[][] generateLandscape(double[][] altitude)
	{
		int[][] buffer = new int[altitude.length][altitude[0].length];
		// altitude et buffer déjà instancié
		return buffer;
	}
}
