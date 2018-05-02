/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.events;

public interface EventInit extends Event {

	public double[][] getElevation();
	
	public int[][] getEnvironment();
	
	public int getWidth();
	
	public int getHeight();
}
