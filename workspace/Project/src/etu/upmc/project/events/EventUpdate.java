/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.events;

public interface EventUpdate extends Event {

	public int[][] getBuffer();

	public int[][][] getInformations();
}
