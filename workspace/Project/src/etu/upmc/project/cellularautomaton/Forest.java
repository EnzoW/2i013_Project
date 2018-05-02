/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.cellularautomaton;

import etu.upmc.project.config.Config;
import etu.upmc.project.config.Constants;
import etu.upmc.project.landscape.LandscapeGenerator;
import etu.upmc.project.time.Time;
import etu.upmc.project.tools.Tools;

public class Forest extends CellularAutomaton
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int 	MAX_HEIGHT_TREE 		= 100000;
	public static final int 	MIN_HEIGHT_TREE 		= 2000;
	public static final int 	ASHES_DISP				= 250;
	public static final int 	INDEX_GROWING			= 0;
	public static final int 	INDEX_TYPE				= 2;

	private static final int 		SPEED 				= (int) Config.getProperty(Constants.SPEED_FOREST);
	private static final double[] 	BURNING_FACTOR 		= Config.getProperties(Constants.BURNING_FACTOR);
	private static final double 	DENSITY_TREES 		= Config.getProperty(Constants.DENSITY_TREES);
	private static final double 	DENSITY_GRASS 		= Config.getProperty(Constants.DENSITY_GRASS);
	private static final double[] 	PROB_TREE_BORN		= Config.getProperties(Constants.PROB_TREE_BORN);
	private static final double[] 	PROB_TREE_BURN		= Config.getProperties(Constants.PROB_TREE_BURN);
	private static final double[] 	PROB_GRASS_BORN		= Config.getProperties(Constants.PROB_GRASS_BORN);
	private static final double[] 	PROB_GRASS_BURN		= Config.getProperties(Constants.PROB_GRASS_BURN);

	/* ****************************************************************
	 * 	Private context
	 * ****************************************************************/

	private int[][] landscape;

	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public Forest(int width, int height, int[][] buffer, int[][][] informations, double[][] elevation, boolean[][] updated, int[][] landscape) 
	{
		super(width, height, buffer, informations, elevation, updated, SPEED);
		this.landscape = landscape;
	}

	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/

	@Override
	public void init() 
	{
		for ( int x = 0 ; x < this.width ; x++ )
		{
			for ( int y = 0 ; y < this.height ; y++ )
			{
				if (this.isOnlyInState(x, y, EMPTY) && this.landscape[x][y] == LandscapeGenerator.ENVIRONMENT_FOREST) 
				{
					if (DENSITY_TREES >= Math.random())
					{
						this.setStates(x, y, FOREST_TREE);
						this.informations[x][y][INDEX_GROWING] = (int) (Math.random() * (MAX_HEIGHT_TREE - MIN_HEIGHT_TREE) + MIN_HEIGHT_TREE);
						this.informations[x][y][INDEX_TYPE] = (int) ((Math.random() * 1000) % 3);
					}
					if (DENSITY_GRASS >= Math.random()) 
					{
						this.setStates(x, y, FOREST_GRASS);
						this.informations[x][y][INDEX_GROWING] = 0;
					}
				}
			}
		}
	}

	@Override
	public void step(int x, int y) 
	{
		int seasonIndex = Time.getInstance().getSeason().getValue();

		if (this.isOnlyInState(x, y, EMPTY))
		{
			if (this.landscape[x][y] == LandscapeGenerator.ENVIRONMENT_FOREST && Math.random() < PROB_TREE_BORN[seasonIndex])
			{
				this.setStates(x, y, FOREST_TREE);
				this.informations[x][y][INDEX_GROWING] = 0;
				this.informations[x][y][INDEX_TYPE] = (int) ((Math.random() * 1000) % 3);
			}

			if (this.landscape[x][y] == LandscapeGenerator.ENVIRONMENT_FOREST && Math.random() < PROB_GRASS_BORN[seasonIndex])
			{
				this.addState(x, y, FOREST_GRASS);
				this.informations[x][y][INDEX_GROWING] = 0;
			}
		}
		else
		{
			if (this.isInState(x, y, FOREST_TREE))
			{
				if (this.isFlammable(x, y) || Math.random() < PROB_TREE_BURN[seasonIndex] || this.isInState(x, y, FOREST_GRASS_BURNING)) 
				{
					this.setStates(x, y, FOREST_TREE_BURNING);
					this.informations[x][y][INDEX_TYPE] = 0;
				}
				if (this.informations[x][y][INDEX_GROWING] < MAX_HEIGHT_TREE)
				{
					this.informations[x][y][INDEX_GROWING]++;
				}
			}
			else if (this.isInState(x, y, FOREST_TREE_BURNING))
			{
				this.propagateFire(x, y);
				this.informations[x][y][INDEX_GROWING] -= this.informations[x][y][INDEX_GROWING] / BURNING_FACTOR[seasonIndex];
				if (this.informations[x][y][INDEX_GROWING] / BURNING_FACTOR[seasonIndex] == 0)
				{
					this.setStates(x, y, FOREST_TREE_ASHES);
					this.informations[x][y][INDEX_GROWING] = 0;
				}
				else
				{
					this.setStates(x, y, FOREST_TREE_BURNING);
				}
			}
			else if (this.isInState(x, y, FOREST_TREE_ASHES))
			{
				this.informations[x][y][INDEX_GROWING]++;

				if (this.informations[x][y][INDEX_GROWING] == ASHES_DISP)
				{
					this.setStates(x, y, EMPTY);
				}
				else
				{
					this.setStates(x, y, FOREST_TREE_ASHES);
				}
			}		
			
			if (this.isInState(x, y, FOREST_GRASS))
			{
				if (this.isFlammable(x, y) || Math.random() < PROB_GRASS_BURN[seasonIndex] || this.isInState(x, y, FOREST_TREE_BURNING)) 
				{
					int state = 0;
					if (this.isInState(x, y, FOREST_TREE, FOREST_TREE_BURNING, FOREST_TREE_ASHES))
					{
						state = this.buffer[x][y];
					}
					this.setStates(x, y, state);
					this.addState(x, y, FOREST_GRASS_BURNING);
				}
			}
			else if (this.isInState(x, y, FOREST_GRASS_BURNING))
			{
				this.changeState(x, y, FOREST_GRASS_BURNING, FOREST_GRASS_ASHES);
			}
			else if (this.isInState(x, y, FOREST_GRASS_ASHES))
			{
				this.removeStates(x, y, FOREST_GRASS_ASHES);
			}
		}
	}

	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/

	private boolean isFlammable(final int x, final int y)
	{
		float probBurn = 0;
		int nbCells = 0;
		
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y) && i >= 0 && i < this.width && j >= 0 && j < this.height)
				{
					if (this.isInState(i, j, FOREST_TREE_BURNING))
					{
						probBurn += Tools.map(this.informations[x][y][INDEX_GROWING], MIN_HEIGHT_TREE, MAX_HEIGHT_TREE, 1, 2);
					}
					
					if (this.isInState(i, j, FOREST_GRASS_BURNING))
					{
						probBurn++;
					}
					
					nbCells++;
				}
			}
		}
		
		probBurn /= nbCells;
		
		return Math.random() < Math.min(probBurn, 1);
	}
	
	private void propagateFire(final int x, final int y)
	{
		int distance = (int) Tools.map(this.informations[x][y][INDEX_GROWING], MIN_HEIGHT_TREE, MAX_HEIGHT_TREE, 0, 5);
		
		for (int i = 0; i < distance; i++)
		{
			for (int j = 0; j < distance; j++)
			{
				if (!(i == x && j == y) && i >= 0 && i < this.width && j >= 0 && j < this.height)
				{
					if (this.isInState(i, j, FOREST_TREE) && Math.random() < PROB_TREE_BURN[Time.getInstance().getSeason().getValue()] * distance)
					{
						this.changeState(i, j, FOREST_TREE, FOREST_TREE_BURNING);
					}
				}
			}
		}
	}
}
