package etu.upmc.project.cellularautomaton;

public class Forest extends CellularAutomaton
{

	private static final double density = 0.90;

	public Forest(int width, int height, AutomatonState[][] buffer) 
	{
		super(width, height, buffer);
	}

	@Override
	public void init() 
	{
		for ( int x = 0 ; x < this.width ; x++ )
		{
			for ( int y = 0 ; y < this.height ; y++ )
			{
				if (density >= Math.random() && this.buffer[x][y] == AutomatonState.EMPTY)
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
