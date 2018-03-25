package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.graphics.Displayer3D;

public class Agent {

	private static final float AGENT_SIZE = 0.5f;

	private static final float[] COLORS_PREDATOR 			= {.5f, 0, .5f};
	private static final float[] COLORS_PREY 				= {0, 0, 1};
	private static final float[] COLORS_PREDATOR_HUNTING 	= {1, 0, 0};
	private static final float[] COLORS_PREY_FLEEING 		= {0, 1, 1};


	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, float height)
	{
		float[] colors = CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREDATOR) ? COLORS_PREDATOR : 
			CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREDATOR_HUNTING) ? COLORS_PREDATOR_HUNTING :
			CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREY) ? COLORS_PREY : COLORS_PREY_FLEEING;

		height *= Displayer3D.HEIGHT_FACTOR;

		gl.glColor3f(colors[0], colors[1], colors[2]);
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
