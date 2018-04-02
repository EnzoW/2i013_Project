package etu.upmc.project.cellularautomaton;

import etu.upmc.project.tools.Tools;

public class Agent extends CellularAutomaton 
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	private static final int 		SPEED 					= 10;
	private static final double 	DENSITY 				= 0.10;
	private static final double 	PROB_PREY_FLEE 			= 0.95;
	private static final double 	PROB_PREDATOR_HUNT 		= 0.75;
	private static final double 	PROB_AGENT_MOVE 		= 0.20;
	private static final double 	PREY_NATALITY_RATE      = 0.05;
	private static final double     PREDATOR_NATALITY_RATE  = 0.01;
	private static final int	 	PREY_HUNGER_LIMIT 		= 1000;
	private static final int 		PREDATOR_HUNGER_LIMIT 	= 1000;
	private static final int 		PREY_GROWING_TIME 		= 10;
	private static final int 		PREDATOR_GROWING_TIME	= 10;


	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public Agent(int width, int height, int[][] buffer, int[][][] informations, double[][] elevation, boolean[][] updated) 
	{
		super(width, height, buffer, informations, elevation, updated, SPEED);
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
						this.informations[x][y][0] = (int) (Math.random() * PREDATOR_HUNGER_LIMIT);
					}
					else
					{
						this.addStates(x, y, AGENT_PREY);
						this.informations[x][y][0] = (int) (Math.random() * PREY_HUNGER_LIMIT);
					}
				}
			}
		}
	}

	@Override
	public void step(int x, int y) {
		if (!this.updated[x][y])
		{
			/********* Prey *********/
			if (this.isInState(x, y, AGENT_PREY) && !checkHunger(x, y, AGENT_PREY))
			{
				/* Flee */
				if (this.nbNeighborsMoore(x, y, AGENT_PREDATOR) > 0)
				{
					int[][] predators = this.getPredatorsCoords(x, y);
					for (int[] predator : predators)
					{
						if (predator[0] != -1 && this.isInState(predator[0], predator[1], AGENT_PREDATOR))
						{
							this.changeState(predator[0], predator[1], AGENT_PREDATOR, AGENT_PREDATOR_HUNTING);
						}
					}
					this.changeState(x, y, AGENT_PREY, AGENT_PREY_FLEEING);
				}
				/* Reproduction */
				else if (this.nbNeighborsMoore(x, y, AGENT_PREY) > 0 && this.getNbNeighborsEmpty(x, y) > 4 && Math.random() < PREY_NATALITY_RATE)
				{
					int[] coord = this.getRandomCoord(x, y);
					if (!(coord[0] == x && coord[1] == y))
					{
						this.addAgent(coord[0], coord[1], AGENT_PREY_YOUNGLING);
						int[] newcoord = this.getRandomCoord(x, y);
						
						if(newcoord[0] == x && newcoord[1] == y)
						{
							this.removeStates(coord[0], coord[1], AGENT_PREY_YOUNGLING);
							this.moveAgent(x, y, newcoord[0], newcoord[1], AGENT_PREY);
						}
						else
						{
							this.moveAgent(x, y, newcoord[0], newcoord[1], AGENT_PREY);	
						}
					}
				}
				/* Default */
				else if (Math.random() < PROB_AGENT_MOVE)
				{
					int[] coord = this.getRandomCoord(x, y);
					this.moveAgent(x, y, coord[0], coord[1], AGENT_PREY);
				}
			}

			/********* Predator *********/
			else if (this.isInState(x, y, AGENT_PREDATOR) && !this.checkHunger(x, y, AGENT_PREDATOR))
			{
				/* Reproduction */
				if (this.nbNeighborsMoore(x, y, AGENT_PREDATOR) > 0 && this.getNbNeighborsEmpty(x, y) > 4 && Math.random() < PREDATOR_NATALITY_RATE)
				{
					int[] coord = this.getRandomCoord(x, y);
					if (!(coord[0] == x && coord[1] == y))
					{
						this.addAgent(coord[0], coord[1], AGENT_PREDATOR_YOUNGLING);
						int[] newcoord = this.getRandomCoord(x, y);
						if(newcoord[0] == x && newcoord[1] == y)
						{
							this.removeStates(coord[0], coord[1], AGENT_PREDATOR_YOUNGLING);
							this.moveAgent(x, y, coord[0], coord[1], AGENT_PREDATOR);
						}
						else
						{
							this.moveAgent(x, y, newcoord[0], newcoord[1], AGENT_PREDATOR);
						}
					}

				}
				/* Default */
				else if (Math.random() < PROB_AGENT_MOVE)
				{
					int[] coord = this.getRandomCoord(x, y);
					this.moveAgent(x, y, coord[0], coord[1], AGENT_PREDATOR);
				}
			}

			/********* Prey Fleeing *********/
			else if (this.isInState(x, y, AGENT_PREY_FLEEING) && !checkHunger(x, y, AGENT_PREY_FLEEING))
			{
				if (this.nbNeighborsMoore(x, y, AGENT_PREDATOR_HUNTING) == 0)
				{
					this.changeState(x, y, AGENT_PREY_FLEEING, AGENT_PREY);
				}
				else
				{
					int[] coordPrey = this.getPreyFleeingNewCoord(x, y);
					int[][] predators = this.getPredatorsCoords(x, y);

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
						}
					}
				}
			}

			/********* Predator Hunting *********/
			else if (this.isInState(x, y, AGENT_PREDATOR_HUNTING) && !checkHunger(x, y, AGENT_PREDATOR_HUNTING))
			{
				if (this.nbNeighborsMoore(x, y, AGENT_PREY_FLEEING) == 0)
				{
					this.changeState(x, y, AGENT_PREDATOR_HUNTING, AGENT_PREDATOR);
				}
			}
			
			/********* Prey Youngling *********/
			else if (this.isInState(x, y, AGENT_PREY_YOUNGLING))
			{
				this.informations[x][y][0]++;
				if (this.informations[x][y][0] >= PREY_GROWING_TIME)
				{
					this.informations[x][y][0] = 0;
					this.changeState(x, y, AGENT_PREY_YOUNGLING, AGENT_PREY);
				}
				else
				{
					int coord[] = this.getRandomCoord(x, y);
					this.moveAgent(x, y, coord[0], coord[1], AGENT_PREY_YOUNGLING);
				}
			}
			
			/********* Predator Youngling *********/
			else if (this.isInState(x, y, AGENT_PREDATOR_YOUNGLING))
			{
				this.informations[x][y][0]++;
				if (this.informations[x][y][0] >= PREDATOR_GROWING_TIME)
				{
					this.informations[x][y][0] = 0;
					this.changeState(x, y, AGENT_PREDATOR_YOUNGLING, AGENT_PREDATOR);
				}
				else
				{
					int coord[] = this.getRandomCoord(x, y);
					this.moveAgent(x, y, coord[0], coord[1], AGENT_PREDATOR_YOUNGLING);
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
		boolean isStarving = this.informations[x][y][0] == limit;

		if (isStarving)
		{
			this.removeStates(x, y, type);
			this.informations[x][y][0] = 0;
		}
		else
		{
			this.informations[x][y][0]++;
		}

		return isStarving;
	}

	private void addAgent(int x, int y, int type)
	{
		if (!this.isOnlyInState(x, y, EMPTY) && !this.isOnlyInState(x, y, FOREST_GRASS))
		{
			throw new IllegalArgumentException(Agent.class.getSimpleName() + " : Cannot add agent to a non-empty position.");
		}

		this.addStates(x, y, type);
		this.informations[x][y][0] = 0;
		this.updated[x][y] = true;
	}

	private void moveAgent(int x, int y, int newX, int newY, int type)
	{
		if (this.isInState(newX, newY, AGENT_PREY_FLEEING) && type == AGENT_PREDATOR_HUNTING)
		{
			/* Remove prey (eaten) */
			this.removeStates(newX, newY, AGENT_PREY_FLEEING);
			/* Reset hunger counter of the predator */
			this.informations[x][y][0] = 0;
		}

		if (this.isInState(newX, newY, FOREST_GRASS) && (type == AGENT_PREY || type == AGENT_PREY_FLEEING))
		{
			this.removeStates(newX, newY, FOREST_GRASS);
			this.informations[x][y][0] = 0;
		}

		this.removeStates(x, y, type);
		this.informations[newX][newY][0] = this.informations[x][y][0];
		this.informations[x][y][0] = 0;
		this.addStates(newX, newY, type);
		this.updated[newX][newY] = true;
	}

	private int getNbNeighborsEmpty(final int x, final int y)
	{
		int nbEmpty = 0;
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if(i < this.width && j < this.height && i > 0 && j > 0)
				{
					if(this.isOnlyInState(i, j, EMPTY) || this.isOnlyInState(i, j, FOREST_GRASS))
					{
						nbEmpty++;
					}
				}

			}
		}

		return nbEmpty;
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
		int[][] coord = new int[8][2];
		int n = 0;

		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					if (j >= 0 && i >= 0 && j < this.height && i < this.width && this.elevation[i][j] >= 0 && // Check the bounds.
							(this.isInState(i, j, AGENT_PREY_FLEEING) || // If the cell contains the prey, we add it to the array of valid positions.
									((this.isOnlyInState(i, j, EMPTY) || this.isOnlyInState(i, j, FOREST_GRASS)) && this.nbNeighborsVN(i, j, AGENT_PREY_FLEEING) > 0))) // If the cell is empty and is in the prey's neighborhood, we add it too.
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

		if (coord[i][0] == -1 || Math.random() > PROB_PREDATOR_HUNT)
		{
			coord[i][0] = x;
			coord[i][1] = y;
		}

		return coord[i];
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
					if (j >= 0 && i >= 0 && j < this.height && i < this.width && (this.isInState(i, j, AGENT_PREDATOR, AGENT_PREDATOR_HUNTING)))
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
