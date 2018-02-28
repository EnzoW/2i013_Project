package etu.upmc.project.events;

import etu.upmc.project.cellularautomaton.AutomatonState;

public class DataTranslation 
{
	public static int[][][] translateToDisplayable(AutomatonState[][] buffer)
	{
		int[][][] displayableBuffer = new int[buffer.length][buffer[0].length][4];
		
		for (int x = 0; x < buffer.length; x++)
		{
			for (int y = 0; y < buffer[x].length; y++)
			{
				int[] colors;
				switch (buffer[x][y])
				{
				default:
				case EMPTY:
					colors = new int[] {0xFF000000, 255, 255, 255};
					break;
				case FOREST_TREE:
					colors = new int[] {0xFF000000, 0, 255, 0};
					break;
				case FOREST_TREE_BURNING:
					colors = new int[] {0xFF000000, 255, 0, 0};
					break;
				case FOREST_ASHES:
					colors = new int[] {0xFF000000, 0, 0, 0};
					break;
				case FOREST_GRASS:
					colors = new int[] {0xFF000000, 255, 255, 0};
					break;
				case AGENT_PREDATOR:
					colors = new int[] {0xFF000000, 0, 0, 255};
					break;
				case AGENT_PREY:
					colors = new int[] {0xFF000000, 139, 69, 19};
					break;
				}
				
				displayableBuffer[x][y] = colors;
			}
		}
		
		return displayableBuffer;
	}
	
	public static int[][] translateToStates(AutomatonState[][] buffer)
	{
		int[][] statesBuffer = new int[buffer.length][buffer[0].length];
		
		for (int x = 0; x < buffer.length; x++)
		{
			for (int y = 0; y < buffer[x].length; y++)
			{
				switch (buffer[x][y])
				{
				default:
				case EMPTY:
					statesBuffer[x][y] = 0;
					break;
				case FOREST_TREE:
					statesBuffer[x][y] = 1;
					break;
				case FOREST_TREE_BURNING:
					statesBuffer[x][y] = 2;
					break;
				case FOREST_ASHES:
					statesBuffer[x][y] = 3;
					break;
				case FOREST_GRASS:
					statesBuffer[x][y] = 4;
					break;
				case AGENT_PREDATOR:
					statesBuffer[x][y] = 5;
					break;
				case AGENT_PREY:
					statesBuffer[x][y] = 6;
					break;
				}
			}
		}
		return statesBuffer;
	}
}
