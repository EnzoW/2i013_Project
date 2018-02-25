/**
 * 
 */
package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

/**
 * @author Enzo
 *
 */
public class Agent extends CommonObject {

	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight )
	{
		normalizeHeight /= 10;
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
