package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.graphics.Displayer3D;

public class Agent {

	private static final float AGENT_SIZE = 0.5f;

	private static final float[] COLORS_PREY 				= {0, 0, 1, 1};
	private static final float[] COLORS_PREY_FLEEING 		= {0, 1, 1, 1};
	private static final float[] COLORS_PREY_YOUNGLING		= {.5f, .5f, 1, 1f};
	private static final float[] COLORS_PREDATOR 			= {.5f, 0, .5f, 1};
	private static final float[] COLORS_PREDATOR_HUNTING 	= {1, 0, 0, 1};
	private static final float[] COLORS_PREDATOR_YOUNGLING 	= {1f, 0, 1f, 1f};


	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, float height)
	{
		float[] colors = CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREDATOR) ? COLORS_PREDATOR : 
			CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREDATOR_HUNTING) ? COLORS_PREDATOR_HUNTING :
			CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREY) ? COLORS_PREY : 
			CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREY_FLEEING) ? COLORS_PREY_FLEEING :
			CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREY_YOUNGLING) ? COLORS_PREY_YOUNGLING :
			COLORS_PREDATOR_YOUNGLING;

		height *= Displayer3D.HEIGHT_FACTOR;

		gl.glColor4f(colors[0], colors[1], colors[2], colors[3]);
		gl.glVertex3f(x - AGENT_SIZE, y - AGENT_SIZE, height);
		gl.glVertex3f(x - AGENT_SIZE, y - AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + AGENT_SIZE, y - AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + AGENT_SIZE, y - AGENT_SIZE, height);

		gl.glVertex3f(x + AGENT_SIZE, y + AGENT_SIZE, height);
		gl.glVertex3f(x + AGENT_SIZE, y + AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - AGENT_SIZE, y + AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - AGENT_SIZE, y + AGENT_SIZE, height);

		gl.glVertex3f(x + AGENT_SIZE, y - AGENT_SIZE, height);
		gl.glVertex3f(x + AGENT_SIZE, y - AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + AGENT_SIZE, y + AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + AGENT_SIZE, y + AGENT_SIZE, height);

		gl.glVertex3f(x - AGENT_SIZE, y + AGENT_SIZE, height);
		gl.glVertex3f(x - AGENT_SIZE, y + AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - AGENT_SIZE, y - AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - AGENT_SIZE, y - AGENT_SIZE, height);

		gl.glVertex3f(x - AGENT_SIZE, y - AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - AGENT_SIZE, y + AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + AGENT_SIZE, y + AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + AGENT_SIZE, y - AGENT_SIZE, height + 0.01f * Displayer3D.HEIGHT_FACTOR);
	}
}
