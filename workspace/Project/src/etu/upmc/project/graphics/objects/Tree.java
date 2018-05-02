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
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.graphics.Displayer3D;
import etu.upmc.project.time.Time;
import etu.upmc.project.tools.Tools;

public class Tree {

	private static final float 		TREE_SIZE 	= 0.25f;
	private static final boolean 	TREES 		= false;

	private static final float[][]	COLORS_TREE_WINTER 	= {
			{0.33f, 0.41f, 0.48f},
			{0.22f, 0.20f, 0.21f},
			{0.64f, 0.64f, 0.64f}};
	
	private static final float[][]	COLORS_TREE_SPRING 	= {
			{0.58f, 0.36f, 0.32f},
			{0.62f, 0.62f, 0.18f},
			{0.22f, 0.30f, 0.04f}};
	
	private static final float[][]	COLORS_TREE_SUMMER 	= {
			{0.22f, 0.34f, 0.06f},
			{0.30f, 0.39f, 0.02f},
			{0.22f, 0.30f, 0.04f}};
	
	private static final float[][]	COLORS_TREE_FALL 	= {
			{0.96f, 0.59f, 0.14f},
			{0.89f, 0.41f, 0.09f},
			{0.34f, 0.11f, 0.11f}};
	
	public static void displayObjectAt(GL2 gl, int cellState, float x, float y, float height, int[] informations)
	{
		float treeHeight = 0;

		if (CellularAutomaton.isInStates(cellState, CellularAutomaton.FOREST_TREE))
		{
			float[] color = new float[3];

			switch (Time.getInstance().getSeason())
			{
			case FALL:
				System.arraycopy(COLORS_TREE_FALL[informations[Forest.INDEX_TYPE]], 0, color, 0, 3);
				break;
			case SPRING:
				System.arraycopy(COLORS_TREE_SPRING[informations[Forest.INDEX_TYPE]], 0, color, 0, 3);
				break;
			case SUMMER:
				System.arraycopy(COLORS_TREE_SUMMER[informations[Forest.INDEX_TYPE]], 0, color, 0, 3);
				break;
			case WINTER:
				System.arraycopy(COLORS_TREE_WINTER[informations[Forest.INDEX_TYPE]], 0, color, 0, 3);
				break;
			default:
				/* Should not happen */
				break;
			}

			gl.glColor3f(color[0], color[1], color[2]);
			treeHeight = Tools.map(informations[Forest.INDEX_GROWING], 0, Forest.MAX_HEIGHT_TREE, 1, 5);
		}
		else if (CellularAutomaton.isInStates(cellState, CellularAutomaton.FOREST_TREE_BURNING))
		{
			gl.glColor3f(1.f-(float)(0.2*Math.random()),0.f,0.f);
			treeHeight = Tools.map(informations[Forest.INDEX_GROWING], 0, Forest.MAX_HEIGHT_TREE, 1, 5);
		}
		else if (CellularAutomaton.isInStates(cellState, CellularAutomaton.FOREST_TREE_ASHES))
		{
			float gray = Tools.map(informations[Forest.INDEX_GROWING], 0, Forest.ASHES_DISP, 0, 0.5f);
			gl.glColor3f(gray, gray, gray);
			treeHeight = 1;			
		}

		if (TREES)
		{
			gl.glVertex3f(x, y + TREE_SIZE, height * Displayer3D.HEIGHT_FACTOR + treeHeight);
			gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR);
			gl.glVertex3f(x, y - TREE_SIZE, height * Displayer3D.HEIGHT_FACTOR + treeHeight);
			gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR );

			gl.glVertex3f(x - TREE_SIZE, y, height * Displayer3D.HEIGHT_FACTOR + treeHeight);
			gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR );
			gl.glVertex3f(x + TREE_SIZE, y, height * Displayer3D.HEIGHT_FACTOR + treeHeight);
			gl.glVertex3f(x, y, height * Displayer3D.HEIGHT_FACTOR );
		}
		else
		{
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
}
