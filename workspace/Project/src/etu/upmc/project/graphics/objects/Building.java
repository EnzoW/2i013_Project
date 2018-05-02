/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.graphics.Displayer3D;

public class Building {

	private static final float 		BUILDING_SIZE 		= 1f;
	private static final float[] 	COLORS_BUILDING 	= {.66f, 0.66f, .66f};

	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, float height)
	{
		gl.glColor3f(COLORS_BUILDING[0], COLORS_BUILDING[1], COLORS_BUILDING[2]);
		gl.glVertex3f(x - BUILDING_SIZE, y - BUILDING_SIZE, height);
		gl.glVertex3f(x - BUILDING_SIZE, y - BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + BUILDING_SIZE, y - BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + BUILDING_SIZE, y - BUILDING_SIZE, height);

		gl.glVertex3f(x + BUILDING_SIZE, y + BUILDING_SIZE, height);
		gl.glVertex3f(x + BUILDING_SIZE, y + BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - BUILDING_SIZE, y + BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - BUILDING_SIZE, y + BUILDING_SIZE, height);

		gl.glVertex3f(x + BUILDING_SIZE, y - BUILDING_SIZE, height);
		gl.glVertex3f(x + BUILDING_SIZE, y - BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + BUILDING_SIZE, y + BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + BUILDING_SIZE, y + BUILDING_SIZE, height);

		gl.glVertex3f(x - BUILDING_SIZE, y + BUILDING_SIZE, height);
		gl.glVertex3f(x - BUILDING_SIZE, y + BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - BUILDING_SIZE, y - BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - BUILDING_SIZE, y - BUILDING_SIZE, height);

		gl.glVertex3f(x - BUILDING_SIZE, y - BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x - BUILDING_SIZE, y + BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + BUILDING_SIZE, y + BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x + BUILDING_SIZE, y - BUILDING_SIZE, height + 0.20f * Displayer3D.HEIGHT_FACTOR);
	}
}
