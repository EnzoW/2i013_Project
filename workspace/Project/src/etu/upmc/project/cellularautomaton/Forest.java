package etu.upmc.project.cellularautomaton;

public class Forest extends CellularAutomaton
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int 	MAX_GROW_TREE 		= 1000;
	public static final int 	MIN_GROW_TREE 		= 20;
	public static final int 	ASHES_DISP			= 1000;
	public static final int 	BURNING_ITERATIONS 	= 100;

	private static final double DENSITY_TREES 		= 0.55d;
	private static final double DENSITY_GRASS 		= 0d;
	private static final double PROB_TREE_BORN		= 0.9999d;
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
				if (AutomatonState.isInState(this.buffer[x][y], AutomatonState.EMPTY)) 
				{
					if (DENSITY_TREES >= Math.random() && this.elevation[x][y] >= 0) 
					{
						AutomatonState.setStates(this.buffer, x, y, AutomatonState.FOREST_TREE);
						this.informations[x][y] = (int) (Math.random() * (MAX_GROW_TREE - MIN_GROW_TREE) + MIN_GROW_TREE);
					}
					if (DENSITY_GRASS >= Math.random() && this.elevation[x][y] >= 0) 
					{
						AutomatonState.addStates(this.buffer, x, y, AutomatonState.FOREST_GRASS);
						this.informations[x][y] = 0;
					}
				}
			}
		}
	}

	@Override
	public void step(int x, int y) 
	{
		if (AutomatonState.isInState(this.buffer[x][y], AutomatonState.EMPTY))
		{
			if (this.elevation[x][y] >= 0 && Math.random() > PROB_TREE_BORN)
			{
				AutomatonState.setStates(this.buffer, x, y, AutomatonState.FOREST_TREE);
				this.informations[x][y] = 0;
			}
		}
		else if (AutomatonState.isInState(this.buffer[x][y], AutomatonState.FOREST_TREE))
		{
			if (super.nbNeighborsVN(x, y, AutomatonState.FOREST_TREE_BURNING) > Math.random() * 8 || Math.random() > PROB_TREE_BURN)
			{
				AutomatonState.setStates(this.buffer, x, y, AutomatonState.FOREST_TREE_BURNING);
				this.informations[x][y] = BURNING_ITERATIONS;
			}
			if (this.informations[x][y] < MAX_GROW_TREE)
			{
				this.informations[x][y]++;
			}
		}
		else if (AutomatonState.isInState(this.buffer[x][y], AutomatonState.FOREST_TREE_BURNING))
		{
			this.informations[x][y]--;
			if (this.informations[x][y] == MIN_GROW_TREE)
			{
				AutomatonState.setStates(this.buffer, x, y, AutomatonState.FOREST_ASHES);
			}
			else
			{
				AutomatonState.setStates(this.buffer, x, y, AutomatonState.FOREST_TREE_BURNING);
			}
		}
		else if (AutomatonState.isInState(this.buffer[x][y], AutomatonState.FOREST_ASHES))
		{
			this.informations[x][y]++;
		
			if (this.informations[x][y] == ASHES_DISP)
			{
				AutomatonState.setStates(this.buffer, x, y, AutomatonState.EMPTY);
			}
			else
			{
				AutomatonState.setStates(this.buffer, x, y, AutomatonState.FOREST_ASHES);
			}
		}		
	}

}
