/**
 * 
 */
package etu.upmc.project.events;

import etu.upmc.project.cellularautomaton.AutomatonState;

/**
 * @author Enzo
 *
 */
public interface EventUpdate extends Event {

	public AutomatonState[][] getBuffer();

	public int[][] getInformations();
}
