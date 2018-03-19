/**
 * 
 */
package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.CellularAutomaton;

public class Agent extends CommonObject {

	private static final float[][] COLORS_PREDATOR 	= 	{{0.5f, 0, 0},
														{0.6f, 0, 0},
														{0.55f, 0, 0},
														{0.45f, 0, 0},
														{0.5f, 0, 0}};
	
	private static final float[][] COLORS_PREY 		=   {{1f, 0, 1f},
														{1f, 0, 1f},
														{1f, 0, 1f},
														{1f, 0, 1f},
														{1f, 0, 1f}};
	
	
	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight)
	{
		float altitude = (float)height * normalizeHeight ;
		normalizeHeight /= 20;
		
		float[][] colors = CellularAutomaton.isInStates(cellState, CellularAutomaton.AGENT_PREDATOR, CellularAutomaton.AGENT_PREDATOR_HUNTING) ? COLORS_PREDATOR : COLORS_PREY;

		gl.glColor3f(colors[0][0], colors[0][1], colors[0][2]);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, altitude);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, altitude);

		gl.glColor3f(colors[1][0], colors[1][1], colors[1][2]);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, altitude);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, altitude);

		gl.glColor3f(colors[2][0], colors[2][1], colors[2][2]);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, altitude);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, altitude);

		gl.glColor3f(colors[3][0], colors[3][1], colors[3][2]);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, altitude);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, altitude);

		gl.glColor3f(colors[4][0], colors[4][1], colors[4][2]);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, altitude + 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, altitude + 0.1f*normalizeHeight);
	}
}
