package etu.upmc.project.cellularautomaton;

public class Forest extends CellularAutomaton
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int 	MAX_GROW_TREE 		= 10000;
	public static final int 	MIN_GROW_TREE 		= 20;
	public static final int 	ASHES_DISP			= 500;
	public static final int 	BURNING_ITERATIONS 	= 100;

	private static final double DENSITY_TREES 		= 0.70d;
	private static final double DENSITY_GRASS 		= 0.30d;
	private static final double PROB_TREE_BORN		= 0.99999d;
	private static final double PROB_TREE_BURN		= 0.99999d;

	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public Forest(int width, int height, int[][] buffer, int[][] informations, double[][] elevation) 
	{
		super(width, height, buffer, informations, elevation);
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
				if (this.isOnlyInState(x, y, CellularAutomaton.EMPTY)) 
				{
					if (DENSITY_TREES >= Math.random() && this.elevation[x][y] >= 0 && this.elevation[x][y] < 0.8) 
					{
						this.setStates(x, y, CellularAutomaton.FOREST_TREE);
						this.informations[x][y] = (int) (Math.random() * (MAX_GROW_TREE - MIN_GROW_TREE) + MIN_GROW_TREE);
					}
					if (DENSITY_GRASS >= Math.random() && this.elevation[x][y] >= 0) 
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
			if (this.elevation[x][y] >= 0 && Math.random() > PROB_TREE_BORN)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_TREE);
				this.informations[x][y] = 0;
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_TREE))
		{
			if (super.nbNeighborsVN(x, y, CellularAutomaton.FOREST_TREE_BURNING) > (int)(Math.random() * 4) || Math.random() > PROB_TREE_BURN)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_TREE_BURNING);
				this.informations[x][y] = BURNING_ITERATIONS;
			}
			if (this.informations[x][y] < MAX_GROW_TREE)
			{
				this.informations[x][y]++;
			}
		}
		else if (this.isOnlyInState(x, y, CellularAutomaton.FOREST_TREE_BURNING))
		{
			this.informations[x][y]--;
			if (this.informations[x][y] == MIN_GROW_TREE)
			{
				this.setStates(x, y, CellularAutomaton.FOREST_ASHES);
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
