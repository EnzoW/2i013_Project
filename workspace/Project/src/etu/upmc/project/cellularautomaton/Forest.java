package etu.upmc.project.cellularautomaton;

import etu.upmc.project.config.Config;
import etu.upmc.project.config.Constants;
import etu.upmc.project.landscape.LandscapeGenerator;

public class Forest extends CellularAutomaton
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int 	MAX_GROW_TREE 		= 100000;
	public static final int 	MIN_GROW_TREE 		= 2000;
	public static final int 	ASHES_DISP			= 2000;
	
	private static final int 	SPEED 				= (int) Config.getProperty(Constants.SPEED_FOREST);
	private static final int 	BURNING_FACTOR 		= (int) Config.getProperty(Constants.BURNING_FACTOR);
	private static final double DENSITY_TREES 		= Config.getProperty(Constants.DENSITY_TREES);
	private static final double DENSITY_GRASS 		= Config.getProperty(Constants.DENSITY_GRASS);
	private static final double PROB_TREE_BORN		= Config.getProperty(Constants.PROB_TREE_BORN);
	private static final double PROB_GRASS_BORN		= Config.getProperty(Constants.PROB_GRASS_BORN);
	private static final double PROB_TREE_BURN		= Config.getProperty(Constants.PROB_TREE_BURN);

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
				if (this.isOnlyInState(x, y, CellularAutomaton.EMPTY) && this.landscape[x][y] == LandscapeGenerator.ENVIRONMENT_FOREST) 
				{
					if (DENSITY_TREES >= Math.random())
					{
						this.setStates(x, y, CellularAutomaton.FOREST_TREE);
						this.informations[x][y][0] = (int) (Math.random() * (MAX_GROW_TREE - MIN_GROW_TREE) + MIN_GROW_TREE);
					}
					if (DENSITY_GRASS >= Math.random()) 
					{
						this.setStates(x, y, CellularAutomaton.FOREST_GRASS);
						this.informations[x][y][0] = 0;
					}
				}
			}
		}
	}

	@Override
	public void step(int x, int y) 
	{
		if (this.isOnlyInState(x, y, CellularAutomaton.EMPTY))
		{
			if (this.landscape[x][y] == LandscapeGenerator.ENVIRONMENT_FOREST && Math.random() > PROB_TREE_BORN)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_TREE);
				this.informations[x][y][0] = 0;
			}
			
			if (this.landscape[x][y] == LandscapeGenerator.ENVIRONMENT_FOREST && Math.random() > PROB_GRASS_BORN)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_GRASS);
				this.informations[x][y][0] = 0;
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_TREE))
		{
			if (super.nbNeighborsMoore(x, y, CellularAutomaton.FOREST_TREE_BURNING) > (int)(Math.random() * 4) || Math.random() > PROB_TREE_BURN)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_TREE_BURNING);
			}
			if (this.informations[x][y][0] < MAX_GROW_TREE)
			{
				this.informations[x][y][0]++;
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_TREE_BURNING))
		{
			this.informations[x][y][0] -= this.informations[x][y][0] / BURNING_FACTOR;
			if (this.informations[x][y][0] / BURNING_FACTOR == 0)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_ASHES);
				this.informations[x][y][0] = 0;
			}
			else
			{
				this.setStates(x, y, CellularAutomaton.FOREST_TREE_BURNING);
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_ASHES))
		{
			this.informations[x][y][0]++;
		
			if (this.informations[x][y][0] == ASHES_DISP)
			{
				this.setStates(x, y, CellularAutomaton.EMPTY);
			}
			else
			{
				this.setStates(x, y, CellularAutomaton.FOREST_ASHES);
			}
		}		
	}
}
