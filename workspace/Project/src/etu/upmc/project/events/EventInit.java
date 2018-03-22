/**
 * 
 */
package etu.upmc.project.events;

/**
 * @author Enzo
 *
 */
public interface EventInit extends Event {

	public double[][] getElevation();
	
	public int[][] getEnvironment();
	
	public int getWidth();
	
	public int getHeight();
}
