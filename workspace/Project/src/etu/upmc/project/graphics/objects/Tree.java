package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.tools.Tools;

public class Tree extends CommonObject {

	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight, float information)
	{
		float treeHeight = 0;

		if (CellularAutomaton.isInStates(cellState, CellularAutomaton.FOREST_TREE))
		{
			gl.glColor3f(0.f,0.6f-(float)(0.2*Math.random()),0.f);
			treeHeight = Tools.map(information, 0, Forest.MAX_GROW_TREE, 1, 5);
		}
		else if (CellularAutomaton.isInStates(cellState, CellularAutomaton.FOREST_TREE_BURNING))
		{
			gl.glColor3f(1.f-(float)(0.2*Math.random()),0.f,0.f);
			treeHeight = Tools.map(information, 0, Forest.MAX_GROW_TREE, 1, 5);
		}
		else if (CellularAutomaton.isInStates(cellState, CellularAutomaton.FOREST_ASHES))
		{
			float gray = Tools.map(information, Forest.MIN_GROW_TREE, Forest.ASHES_DISP, 0, 0.5f);
			gl.glColor3f(gray, gray, gray);
			treeHeight = 1;			
		}

		treeHeight *=10;
		
		float altitude = (float)height * normalizeHeight ;

		gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude);
		gl.glVertex3f( offset+x*stepX-lenY/16.f, offset+y*stepY+lenY/2.f, altitude + treeHeight);
		gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
		gl.glVertex3f( offset+x*stepX+lenY/16.f, offset+y*stepY-lenY/2.f, altitude + treeHeight);

		gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
		gl.glVertex3f( offset+x*stepX-lenY/2.f, offset+y*stepY+lenY/16.f, altitude + treeHeight);
		gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
		gl.glVertex3f( offset+x*stepX+lenY/2.f, offset+y*stepY-lenY/16.f, altitude + treeHeight);
	}
}
