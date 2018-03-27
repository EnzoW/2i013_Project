package etu.upmc.project.cellularautomaton;

import etu.upmc.project.landscape.LandscapeGenerator;

public class Forest extends CellularAutomaton
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int 	MAX_GROW_TREE 		= 100000;
	public static final int 	MIN_GROW_TREE 		= 2000;
	public static final int 	ASHES_DISP			= 2000;
	
	private static final int 	SPEED 				= 1;
	private static final int 	BURNING_FACTOR 		= 50; // Lower is the value, faster trees will burn.
	private static final double DENSITY_TREES 		= 0.70d;
	private static final double DENSITY_GRASS 		= 0.50d;
	private static final double PROB_TREE_BORN		= 0.9999d;
	private static final double PROB_GRASS_BORN		= 0.999d;
	private static final double PROB_TREE_BURN		= 0.9999d;

	/* ****************************************************************
	 * 	Private context
	 * ****************************************************************/
	
	private int[][] landscape;
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public Forest(int width, int height, int[][] buffer, int[][] informations, double[][] elevation, int[][] landscape) 
	{
		super(width, height, buffer, informations, elevation, SPEED);
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
						this.informations[x][y] = (int) (Math.random() * (MAX_GROW_TREE - MIN_GROW_TREE) + MIN_GROW_TREE);
					}
					if (DENSITY_GRASS >= Math.random()) 
					{
						this.setStates(x, y, CellularAutomaton.FOREST_GRASS);
						this.informations[x][y] = 0;
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
				this.informations[x][y] = 0;
			}
			
			if (this.landscape[x][y] == LandscapeGenerator.ENVIRONMENT_FOREST && Math.random() > PROB_GRASS_BORN)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_GRASS);
				this.informations[x][y] = 0;
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_TREE))
		{
			if (super.nbNeighborsMoore(x, y, CellularAutomaton.FOREST_TREE_BURNING) > (int)(Math.random() * 4) || Math.random() > PROB_TREE_BURN)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_TREE_BURNING);
			}
			if (this.informations[x][y] < MAX_GROW_TREE)
			{
				this.informations[x][y]++;
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_TREE_BURNING))
		{
			this.informations[x][y] -= this.informations[x][y] / BURNING_FACTOR;
			if (this.informations[x][y] / BURNING_FACTOR == 0)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_ASHES);
				this.informations[x][y] = 0;
			}
			else
			{
				this.setStates(x, y, CellularAutomaton.FOREST_TREE_BURNING);
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_ASHES))
		{
			this.informations[x][y]++;
		
			if (this.informations[x][y] == ASHES_DISP)
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
