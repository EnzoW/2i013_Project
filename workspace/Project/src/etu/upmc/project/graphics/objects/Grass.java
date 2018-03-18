/**
 * 
 */
package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.CellularAutomaton;

/**
 * @author Enzo
 *
 */
public class Grass extends CommonObject {
	public static void displayObjectAt(GL2 gl, CellularAutomaton cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight )
	{
		gl.glColor3f(0.5f,0.f,0.f);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.f);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.f);

		gl.glColor3f(0.6f,0.f,0.f);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.f);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.f);

		gl.glColor3f(0.55f,0.f,0.f);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.f);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.f);

		gl.glColor3f(0.45f,0.f,0.f);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.f);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.f);

		gl.glColor3f(0.5f,0.f,0.f);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
		gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
	}
}
