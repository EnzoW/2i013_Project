/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.graphics.Displayer3D;

public class Human
{
	private static final float HUMAN_SIZE = 0.75f;

	private static final float[] COLORS_HUMAN_SIMPLE 	= {.94f, 0.90f, .55f, 1};
	private static final float[] COLORS_TRIBE_MAIN 		= {.94f, 0.90f, .55f, 1};
	private static final float[] COLORS_HUMAN_RETURN 	= {.94f, 0.90f, .55f, 1};

	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, float height)
	{
		float[] colors = CellularAutomaton.isInStates(cellState, CellularAutomaton.HUMAN_SIMPLE) ? COLORS_HUMAN_SIMPLE : 
			CellularAutomaton.isInStates(cellState, CellularAutomaton.TRIBE_MAIN) ? COLORS_TRIBE_MAIN :
			COLORS_HUMAN_RETURN;

		height *= Displayer3D.HEIGHT_FACTOR;

		gl.glColor4f(colors[0], colors[1], colors[2], colors[3]);
		gl.glVertex3f(x - HUMAN_SIZE, y - HUMAN_SIZE, height);
		gl.glVertex3f(x - HUMAN_SIZE, y - HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + HUMAN_SIZE, y - HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + HUMAN_SIZE, y - HUMAN_SIZE, height);

		gl.glVertex3f(x + HUMAN_SIZE, y + HUMAN_SIZE, height);
		gl.glVertex3f(x + HUMAN_SIZE, y + HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - HUMAN_SIZE, y + HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - HUMAN_SIZE, y + HUMAN_SIZE, height);

		gl.glVertex3f(x + HUMAN_SIZE, y - HUMAN_SIZE, height);
		gl.glVertex3f(x + HUMAN_SIZE, y - HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + HUMAN_SIZE, y + HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + HUMAN_SIZE, y + HUMAN_SIZE, height);

		gl.glVertex3f(x - HUMAN_SIZE, y + HUMAN_SIZE, height);
		gl.glVertex3f(x - HUMAN_SIZE, y + HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - HUMAN_SIZE, y - HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - HUMAN_SIZE, y - HUMAN_SIZE, height);

		gl.glVertex3f(x - HUMAN_SIZE, y - HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - HUMAN_SIZE, y + HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + HUMAN_SIZE, y + HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + HUMAN_SIZE, y - HUMAN_SIZE, height + 0.05f * Displayer3D.HEIGHT_FACTOR);
	}
}
