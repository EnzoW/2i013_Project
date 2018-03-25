package etu.upmc.project.graphics.objects;

import javax.media.opengl.GL2;

import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.graphics.Displayer3D;
import etu.upmc.project.tools.Tools;

public class Tree {

	private static final float TREE_SIZE = 0.25f;
	
	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, float height, float information)
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

		gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR);
		gl.glVertex3f(x, y + TREE_SIZE, height * Displayer3D.HEIGHT_FACTOR + treeHeight);
		gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR );
		gl.glVertex3f(x, y - TREE_SIZE, height * Displayer3D.HEIGHT_FACTOR + treeHeight);

		gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR );
		gl.glVertex3f(x - TREE_SIZE, y, height * Displayer3D.HEIGHT_FACTOR + treeHeight);
		gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR );
		gl.glVertex3f(x + TREE_SIZE, y, height * Displayer3D.HEIGHT_FACTOR + treeHeight);
	}
}
