/**
 * 
 */
package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.AutomatonState;

/**
 * @author Enzo
 *
 */
public class Agent extends CommonObject {

	public static void displayObjectAt(GL2 gl, AutomatonState cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight )
	{
		normalizeHeight /= 10;

		if (cellState == AutomatonState.AGENT_PREDATOR)
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
		else if (cellState == AutomatonState.AGENT_PREY)
		{
			gl.glColor3f(1.f, 0.f, 1.f);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.f);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.f);

			gl.glColor3f(1.f, 0.f, 1.f);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.f);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.f);

			gl.glColor3f(1.f, 0.f, 1.f);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.f);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.f);

			gl.glColor3f(1.f, 0.f, 1.f);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.f);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.f);

			gl.glColor3f(1.f, 0.f, 1.f);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX-lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY+lenY, 0.1f*normalizeHeight);
			gl.glVertex3f( offset+x*stepX+lenX, offset+y*stepY-lenY, 0.1f*normalizeHeight);
		}
	}
}
