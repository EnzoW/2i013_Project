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

	private static final double DENSITY_TREES 		= 0.45d;
	private static final double DENSITY_GRASS 		= 0.90d;
	private static final double PROB_TREE_BORN		= 0.9999d;
	private static final double PROB_TREE_BURN		= 0.999999d;

	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public Forest(int width, int height, AutomatonState[][] buffer, int[][] informations, double[][] elevation) 
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
				if (DENSITY_TREES >= Math.random() && this.buffer[x][y] == AutomatonState.EMPTY && this.elevation[x][y] >= 0)
				{
					this.buffer[x][y] 		= AutomatonState.FOREST_TREE;
					this.informations[x][y] = (int) (Math.random() * (MAX_GROW_TREE - MIN_GROW_TREE) + MIN_GROW_TREE);
				}
				
				if (DENSITY_GRASS >= Math.random() && this.buffer[x][y] == AutomatonState.EMPTY && this.elevation[x][y] >= 0)
				{
					this.buffer[x][y] 		= AutomatonState.FOREST_GRASS;
					this.informations[x][y] = 0;
				}
			}
		}
	}

	@Override
	public void step(int x, int y) 
	{
		switch (this.buffer[x][y]) 
		{
		case EMPTY:
			if (this.elevation[x][y] >= 0 && Math.random() > PROB_TREE_BORN)
			{
				this.buffer[x][y] = AutomatonState.FOREST_TREE;
				this.informations[x][y] = 0;
			}
			break;
		case FOREST_TREE:
			if (super.nbNeighborsVN(x, y, AutomatonState.FOREST_TREE_BURNING) > Math.random() * 8 || Math.random() > PROB_TREE_BURN)
			{
				this.buffer[x][y] = AutomatonState.FOREST_TREE_BURNING;
				this.informations[x][y] = BURNING_ITERATIONS;
			}
			if (this.informations[x][y] < MAX_GROW_TREE)
			{
				this.informations[x][y]++;
			}
			break;
		case FOREST_TREE_BURNING:
			this.informations[x][y]--;
			this.buffer[x][y] = this.informations[x][y] == MIN_GROW_TREE ? AutomatonState.FOREST_ASHES : AutomatonState.FOREST_TREE_BURNING;
			break;
		case FOREST_ASHES:
			this.informations[x][y]++;
			this.buffer[x][y] = this.informations[x][y] == ASHES_DISP ? AutomatonState.EMPTY : AutomatonState.FOREST_ASHES;
			break;
		default:
			break;
		}		
	}

}
