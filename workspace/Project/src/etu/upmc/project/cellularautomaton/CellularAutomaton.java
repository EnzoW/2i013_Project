package etu.upmc.project.cellularautomaton;

public abstract class CellularAutomaton 
{
	/* ****************************************************************
	 * 	Private Context
	 * ****************************************************************/

	protected int width;
	protected int height;
	protected int[][] buffer;
	protected int[][] informations;
	protected double[][] elevation;
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/
	
	public CellularAutomaton(int width, int height, int[][] buffer, int[][] informations, double[][] elevation) 
	{
		this.width = width;
		this.height = height;
		this.buffer = buffer;
		this.informations = informations;
		this.elevation = elevation;
	}
	
	/* ****************************************************************
	 * 	Abstract public methods
	 * ****************************************************************/
	
	abstract public void init();
	
	abstract public void step(int x, int y);
	
	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/
	
	protected int nbNeighborsVN(final int x, final int y, final int state)
	{
		int nbNeighbors = 0;
		int indexY = y - 1 >= 0 ? (y - 1) % this.height : this.height - 1;
		int indexX = x - 1 >= 0 ? (x - 1) % this.width : this.width - 1;

		nbNeighbors += AutomatonState.isInState(this.buffer[x][indexY], state) ? 1 : 0;
		indexY = y + 1 >= 0 ? (y + 1) % this.height : this.height - 1;
		nbNeighbors += AutomatonState.isInState(this.buffer[x][indexY], state) ? 1 : 0;
		nbNeighbors += AutomatonState.isInState(this.buffer[indexX][y], state) ? 1 : 0;
		indexX = x + 1 >= 0 ? (x + 1) % this.width : this.width - 1;
		nbNeighbors += AutomatonState.isInState(this.buffer[indexX][y], state) ? 1 : 0;

		return nbNeighbors;
	}
	
	protected int nbNeighborsMoore(final int x, final int y, final int state)
	{
		int nbNeighbors = 0;
		
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					int indexX = i >= 0 ? i % this.width : this.width - 1;
					int indexY = j >= 0 ? j % this.height : this.height - 1;
					nbNeighbors += AutomatonState.isInState(this.buffer[indexX][indexY], state) ? 1 : 0;
				}
			}
		}
		return nbNeighbors;
	}	
}
