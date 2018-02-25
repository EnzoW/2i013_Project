package etu.upmc.project.cellularautomaton;

public abstract class CellularAutomaton 
{

	protected int width;
	protected int height;
	protected AutomatonState[][] buffer;
	
	public CellularAutomaton(int width, int height, AutomatonState[][] buffer) 
	{
		this.width = width;
		this.height = height;
		this.buffer = buffer;
	}
	
	abstract public void init();
	
	abstract public void step(int x, int y);
	
	protected int nbNeighborsVN(final int x, final int y, final AutomatonState state)
	{
		int nbNeighbors = 0;
		int indexY = y - 1 >= 0 ? (y - 1) % this.height : this.height - 1;
		int indexX = x - 1 >= 0 ? (x - 1) % this.width : this.width - 1;

		nbNeighbors += this.buffer[x][indexY] == state ? 1 : 0;
		indexY = y + 1 >= 0 ? (y + 1) % this.height : this.height - 1;
		nbNeighbors += this.buffer[x][indexY] == state ? 1 : 0;
		nbNeighbors += this.buffer[indexX][y] == state ? 1 : 0;
		indexX = x + 1 >= 0 ? (x + 1) % this.width : this.width - 1;
		nbNeighbors += this.buffer[indexX][y] == state ? 1 : 0;

		return nbNeighbors;
	}
	
	protected int nbNeighborsMoore(final int x, final int y, final AutomatonState state)
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
					nbNeighbors += this.buffer[indexX][indexY] == state ? 1 : 0;
				}
			}
		}
		return nbNeighbors;
	}	
}
