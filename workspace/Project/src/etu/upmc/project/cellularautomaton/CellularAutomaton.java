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
	public static final int AGENT_PREY_YOUNGLING    = 1 << 8;
	public static final int AGENT_PREDATOR_YOUNGLING= 1 << 9;
	public static final int GROUND_PREY_TRACKS      = 1 << 10;
	public static final int HUMAN_SIMPLE			= 1 << 11;
	public static final int TRIBE_MAIN				= 1 << 12;
	public static final int HUMAN_RETURN 			= 1 << 13;
	public static final int BUILDING 				= 1 << 14;


	/* ****************************************************************
	 * 	Private Context
	 * ****************************************************************/

	protected int width;
	protected int height;
	protected int[][] buffer;
	protected int[][][] informations;
	protected double[][] elevation;
	protected boolean[][] updated;
	protected int speed;

	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	/**
	 * 
	 * @param width 
	 * 			The global width of the world.
	 * @param height
	 * 			The global height of the world. 
	 * @param buffer
	 * 			The common buffer which containes all CAs states.
	 * @param informations
	 * 			An additional buffer to store informations.
	 * @param elevation
	 * 			The terrain elevation.
	 * @param speed
	 * 			The execution speed of the automaton. The automaton will be updated all the "speed" iterations.
	 */
	public CellularAutomaton(int width, int height, int[][] buffer, int[][][] informations, double[][] elevation, boolean[][] updated, int speed) 
	{
		this.width = width;
		this.height = height;
		this.buffer = buffer;
		this.informations = informations;
		this.elevation = elevation;
		this.updated = updated;
		this.speed = speed;
	}

	/* ****************************************************************
	 * 	Abstract public methods
	 * ****************************************************************/

	abstract public void init();

	abstract public void step(int x, int y);

	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/

	public int getSpeed()
	{
		return this.speed;
	}

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

	protected boolean isEmpty(int x, int y)
	{
		return this.isOnlyInState(x, y, EMPTY) || this.isOnlyInState(x, y, FOREST_GRASS);
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
		if (!this.isOnlyInState(x, y, EMPTY) && !this.isOnlyInState(x, y, FOREST_GRASS))
		{
			throw new IllegalArgumentException(CellularAutomaton.class.getSimpleName() + " : Cannot add a state to an non-empty cell.");
		}

		this.buffer[x][y] |= states;
	}

	protected void changeState(int x, int y, int oldState, int newState)
	{
		this.removeStates(x, y, oldState);
		this.addStates(x, y, newState);
	}

	protected void removeStates(int x, int y, int states)
	{
		if (!this.isInState(x, y, states))
		{
			throw new IllegalArgumentException(CellularAutomaton.class.getSimpleName() + " : Cannot remove the state. The cell is not in.");
		}
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
