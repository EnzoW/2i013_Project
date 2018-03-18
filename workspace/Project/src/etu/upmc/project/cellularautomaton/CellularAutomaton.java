package etu.upmc.project.cellularautomaton;

public abstract class CellularAutomaton 
{
	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/
	
	public static final int EMPTY					= 0;
	public static final int FOREST_TREE				= 1 << 0;
	public static final int FOREST_TREE_BURNING		= 1 << 1;
	public static final int FOREST_ASHES			= 1 << 2;
	public static final int FOREST_GRASS			= 1 << 3;
	public static final int AGENT_PREY				= 1 << 4;
	public static final int AGENT_PREDATOR			= 1 << 5;
	public static final int AGENT_PREY_FLEEING		= 1 << 6;
	public static final int AGENT_PREDATOR_HUNTING	= 1 << 7;
	
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
	 * 	Public methods
	 * ****************************************************************/
	
	public static boolean isInStates(int value, int... states)
	{
		boolean returnValue = false;
		
		for (int state : states)
		{
			returnValue = returnValue || ((state & value) == state);
		}
		
		return returnValue;
	}
	
	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/
	
	protected boolean isInState(int x, int y, int... states)
	{
		boolean returnValue = false;
		
		for (int state : states)
		{
			returnValue = returnValue || ((state & this.buffer[x][y]) == state);
		}
		
		return returnValue;
	}
	
	protected boolean isOnlyInState(int x, int y, int state)
	{
		return ((state & this.buffer[x][y]) == state) && ((this.buffer[x][y] & ~state) == 0);
	}
	
	protected void setStates(int x, int y, int states)
	{
		this.buffer[x][y] = states;
	}
	
	protected void addStates(int x, int y, int states)
	{
		this.buffer[x][y] |= states;
	}

	protected void changeState(int x, int y, int oldState, int newState)
	{
		this.removeStates(x, y, oldState);
		this.addStates(x, y, newState);
	}
	
	protected void removeStates(int x, int y, int states)
	{
		this.buffer[x][y] &= ~states;
	}
	
	protected int nbNeighborsVN(final int x, final int y, final int state)
	{
		int nbNeighbors = 0;
		int indexY = y - 1 >= 0 ? (y - 1) % this.height : this.height - 1;
		int indexX = x - 1 >= 0 ? (x - 1) % this.width : this.width - 1;

		nbNeighbors += this.isInState(x, indexY, state) ? 1 : 0;
		indexY = y + 1 >= 0 ? (y + 1) % this.height : this.height - 1;
		nbNeighbors += this.isInState(x, indexY, state) ? 1 : 0;
		nbNeighbors += this.isInState(indexX, y, state) ? 1 : 0;
		indexX = x + 1 >= 0 ? (x + 1) % this.width : this.width - 1;
		nbNeighbors += this.isInState(indexX, y, state) ? 1 : 0;

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
					nbNeighbors += this.isInState(indexX, indexY, state) ? 1 : 0;
				}
			}
		}
		return nbNeighbors;
	}	
}
