package etu.upmc.project.cellularautomaton;

public class Forest extends CellularAutomaton
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/
	
	private static final double DENSITY = 0.90;

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
				if (DENSITY >= Math.random() && this.buffer[x][y] == AutomatonState.EMPTY && this.elevation[x][y] > 0)
				{
					this.buffer[x][y] = AutomatonState.FOREST_TREE;
				}
			}
		}
		
		this.buffer[this.width / 2][this.height / 2] = AutomatonState.FOREST_TREE_BURNING;
	}

	@Override
	public void step(int x, int y) 
	{
		switch (this.buffer[x][y]) 
		{
		case EMPTY:
			break;
		case FOREST_TREE:
			this.buffer[x][y] = (nbNeighborsMoore(x, y, AutomatonState.FOREST_TREE_BURNING) > 0) ? AutomatonState.FOREST_TREE_BURNING : AutomatonState.FOREST_TREE;
			break;
		case FOREST_TREE_BURNING:
			this.buffer[x][y] = AutomatonState.EMPTY;
			break;
		default:
			break;
		}		
	}

}
