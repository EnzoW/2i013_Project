package etu.upmc.project.cellularautomaton;

import etu.upmc.project.tools.Tools;

public class Agent extends CellularAutomaton 
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	private static final int 		SPEED 					= 5;
	private static final double 	DENSITY 				= 0.10;
	private static final double 	PROB_PREY_FLEE 			= 0.95;
	private static final double 	PROB_AGENT_MOVE 		= 0.20;
	private static final int	 	PREY_HUNGER_LIMIT 		= 1000;
	private static final int 		PREDATOR_HUNGER_LIMIT 	= 1000;
	
	/* ****************************************************************
	 * 	Private context
	 * ****************************************************************/
	
	private boolean[][] updated;
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public Agent(int width, int height, int[][] buffer, int[][] informations, double[][] elevation, boolean[][] updated) 
	{
		super(width, height, buffer, informations, elevation, SPEED);
		this.updated = updated;
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
				if (DENSITY >= Math.random() && (this.isOnlyInState(x, y, EMPTY) || this.isOnlyInState(x, y, FOREST_GRASS)) && this.elevation[x][y] >= 0)
				{
					if (Math.random() < 0.5d)
					{
						this.addStates(x, y, AGENT_PREDATOR);
						this.informations[x][y] = (int) (Math.random() * PREDATOR_HUNGER_LIMIT);
					}
					else
					{
						this.addStates(x, y, AGENT_PREY);
						this.informations[x][y] = (int) (Math.random() * PREY_HUNGER_LIMIT);
					}
				}
			}
		}
	}

	@Override
	public void step(int x, int y) {
		if (!this.updated[x][y])
		{
			if (this.isInState(x, y, AGENT_PREY))
			{
				if (!checkHunger(x, y, AGENT_PREY))
				{
					if (this.nbNeighborsMoore(x, y, AGENT_PREDATOR) > 0)
					{
						int[][] predators = this.getPredatorsCoords(x, y);
						for (int[] predator : predators)
						{
							if (predator[0] != -1)
							{
								this.changeState(predator[0], predator[1], AGENT_PREDATOR, AGENT_PREDATOR_HUNTING);
							}
						}
						this.changeState(x, y, AGENT_PREY, AGENT_PREY_FLEEING);
					}
					else if (!checkHunger(x, y, AGENT_PREY) && Math.random() < PROB_AGENT_MOVE)
					{
						int[] coord = this.getRandomCoord(x, y);
						this.moveAgent(x, y, coord[0], coord[1], AGENT_PREY);
					}
				}
			}
			else if (this.isInState(x, y, AGENT_PREDATOR))
			{
				if (!this.checkHunger(x, y, AGENT_PREDATOR) && Math.random() < PROB_AGENT_MOVE)
				{
					int[] coord = this.getRandomCoord(x, y);
					this.moveAgent(x, y, coord[0], coord[1], AGENT_PREDATOR);
				}
			}
			else if (this.isInState(x, y, AGENT_PREY_FLEEING))
			{
				if (!checkHunger(x, y, AGENT_PREY_FLEEING))
				{
					int[] coordPrey = this.getPreyFleeingNewCoord(x, y);
					int[][] predators = this.getPredatorsCoords(x, y);
					boolean isPredators = false;
					
					moveAgent(x, y, coordPrey[0], coordPrey[1], AGENT_PREY_FLEEING);
					
					for (int[] coords : predators)
					{
						if (coords[0] != -1)
						{
							if (this.isInState(coords[0], coords[1], AGENT_PREDATOR))
							{
								this.changeState(coords[0], coords[1], AGENT_PREDATOR, AGENT_PREDATOR_HUNTING);
							}
	
							int[] newCoords = this.getPredatorHuntingNewCoord(coords[0], coords[1]);
							moveAgent(coords[0], coords[1], newCoords[0], newCoords[1], AGENT_PREDATOR_HUNTING);
							isPredators = true;
						}
					}
					
					if (!isPredators)
					{
						this.changeState(coordPrey[0], coordPrey[1], AGENT_PREY_FLEEING, AGENT_PREY);
					}
				}
			}
			else if (this.isInState(x, y, AGENT_PREDATOR_HUNTING))
			{
				if (!checkHunger(x, y, AGENT_PREDATOR_HUNTING) && this.nbNeighborsMoore(x, y, AGENT_PREY_FLEEING) == 0)
				{
					this.changeState(x, y, AGENT_PREDATOR_HUNTING, AGENT_PREDATOR);
				}
			}
		}
	}


	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/
	
	private boolean checkHunger(int x, int y, int type)
	{
		int limit = type == AGENT_PREDATOR || type == AGENT_PREDATOR_HUNTING ? PREDATOR_HUNGER_LIMIT : PREY_HUNGER_LIMIT;
		boolean isStarving = this.informations[x][y] == limit;
		
		if (isStarving)
		{
			this.removeStates(x, y, type);
			this.informations[x][y] = 0;
		}
		else
		{
			this.informations[x][y]++;
		}
		
		return isStarving;
	}
	
	private void moveAgent(int x, int y, int newX, int newY, int type)
	{
		if (this.isInState(newX, newY, AGENT_PREY_FLEEING) && type == AGENT_PREDATOR_HUNTING)
		{
			/* Remove prey (eaten) */
			this.removeStates(newX, newY, AGENT_PREY_FLEEING);
			/* Reset hunger counter of the predator */
			this.informations[x][y] = 0;
		}
		
		if (this.isInState(newX, newY, FOREST_GRASS) && (type == AGENT_PREY || type == AGENT_PREY_FLEEING))
		{
			this.removeStates(newX, newY, FOREST_GRASS);
			this.informations[x][y] = 0;
		}

		this.removeStates(x, y, type);
		this.informations[newX][newY] = this.informations[x][y];
		this.informations[x][y] = 0;
		this.addStates(newX, newY, type);
		this.updated[newX][newY] = true;
	}
	
	private int[] getPreyFleeingNewCoord(final int x, final int y)
	{
		int[][] coord = new int[8][2];
		int n = 0;

		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					if (j >= 0 && i >= 0 && j < this.height && i < this.width && (this.isOnlyInState(i, j, EMPTY) || this.isOnlyInState(i, j, FOREST_GRASS)) && this.elevation[i][j] >= 0
							&& super.nbNeighborsVN(i, j, AGENT_PREDATOR_HUNTING) == 0)
					{
						coord[n][0] = i;
						coord[n][1] = j;
					}
					else
					{
						coord[n][0] = -1;
						coord[n][1] = -1;
					}
					n++;
				}
			}
		}

		Tools.shuffle(coord);
		
		int i;
		for (i = 0; i < coord.length - 1; i++)
		{
			if (coord[i][0] != -1)
			{
				break;
			}
		}
		
		if (coord[i][0] == -1 || Math.random() > PROB_PREY_FLEE)
		{
			coord[i][0] = x;
			coord[i][1] = y;
		}
			
		return coord[i];
	}
	
	private int[] getPredatorHuntingNewCoord(final int x, final int y)
	{
		int[] coord = new int[] {x, y};
		
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					if (j >= 0 && i >= 0 && j < this.height && i < this.width && this.elevation[i][j] >= 0)
					{
						if (this.isInState(i, j, AGENT_PREY_FLEEING))
						{
							coord[0] = i;
							coord[1] = j;
							break;
						}
						else if ((this.isOnlyInState(i, j, EMPTY) || this.isOnlyInState(i, j, FOREST_GRASS)) && this.nbNeighborsVN(i, j, AGENT_PREY_FLEEING) > 0)
						{
							coord[0] = i;
							coord[1] = j;
						}
					}
				}
			}
		}
		
		return coord;
	}
	
	private int[][] getPredatorsCoords(final int x, final int y)
	{
		int[][] coord = new int[8][2];
		int n = 0;
		
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					if (j >= 0 && i >= 0 && j < this.height && i < this.width && (this.isInState(i, j, AGENT_PREDATOR)))
					{
						coord[n][0] = i;
						coord[n][1] = j;
					}
					else
					{
						coord[n][0] = -1;
						coord[n][1] = -1;
					}
					n++;
				}
			}
		}

		return coord;
	}
	
	private int[] getRandomCoord(final int x, final int y)
	{
		int[][] coord = new int[8][2];
		int n = 0;

		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					if (j >= 0 && i >= 0 && j < this.height && i < this.width && (this.isOnlyInState(i, j, EMPTY) || this.isOnlyInState(i, j, FOREST_GRASS)) && this.elevation[i][j] >= 0)
					{
						coord[n][0] = i;
						coord[n][1] = j;
					}
					else
					{
						coord[n][0] = -1;
						coord[n][1] = -1;
					}
					n++;
				}
			}
		}

		Tools.shuffle(coord);
		
		int i;
		for (i = 0; i < coord.length - 1; i++)
		{
			if (coord[i][0] != -1)
			{
				break;
			}
		}
		
		if (coord[i][0] == -1)
		{
			coord[i][0] = x;
			coord[i][1] = y;
		}
		
		return coord[i];
	}
}
