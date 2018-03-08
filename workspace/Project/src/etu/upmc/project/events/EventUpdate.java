/**
 * 
 */
package etu.upmc.project.events;

/**
 * @author Enzo
 *
 */
public interface EventUpdate extends Event {

	public int[][] getBuffer();

	public int[][] getInformations();
}
