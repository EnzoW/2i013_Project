package etu.upmc.project.cellularautomaton;

public class AutomatonState {
	
	public static final int EMPTY					= 1 << 0;
	public static final int FOREST_TREE				= 1 << 1;
	public static final int FOREST_TREE_BURNING		= 1 << 2;
	public static final int FOREST_ASHES			= 1 << 3;
	public static final int FOREST_GRASS			= 1 << 4;
	public static final int AGENT_PREY				= 1 << 5;
	public static final int AGENT_PREDATOR			= 1 << 6;
	public static final int AGENT_PREY_FLEEING		= 1 << 7;
	public static final int AGENT_PREDATOR_HUNTING	= 1 << 8;
	
	public static boolean isInState(int value, int... states)
	{
		boolean returnValue = false;
		
		for (int state : states)
		{
			returnValue = returnValue || (state & value) == state;
		}
		
		return returnValue;
	}
	
	public static void setStates(int[][] buffer, int x, int y, int... states)
	{
		buffer[x][y] = 0;
		
		for (int state : states)
		{
			buffer[x][y] |= state;
		}
	}
	
	public static void addStates(int[][] buffer, int x, int y, int... states)
	{
		for (int state : states)
		{
			buffer[x][y] |= state;
		}
	}
}
