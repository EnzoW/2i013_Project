/**
 * 
 */
package etu.upmc.project.cellularautomaton;

import etu.upmc.project.tools.Tools;
/**
 * Humans are extension of the cellular automaton class
 * they exist on the same buffer than Agents
 * the information buffer needs to be extended to at least 3 dimensions for the new parameters
 * let's pray that the architecture doesn't break down (and so do I) when I try to implement more complexity	
 *
 */
public class Human extends CellularAutomaton {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	private static final int 	SPEED 					= 1;
	private static final double DENSITY_TRIBES      	= 0.01;
	private static final int 	HUMANS_PER_TRIBE 		= 10; //not random for now
	private static final double HUMAN_HUNGER_LIMIT  	= 2000;
	private static final int 	JOB_NONE 				= 0;
	private static final int 	JOB_LUMBERJACK         	= 1;
	private static final int 	JOB_HUNTER				= 2;
	private static final int 	NEW_BUILDING 			= 100;


	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	/**
	 * 
	 * @param width
	 * @param height
	 * @param buffer
	 * @param informations
	 * @param elevation
	 * @param updated
	 */
	public Human(int width, int height, int[][] buffer, int[][][] informations, double[][] elevation, boolean[][] updated) {
		super(width, height, buffer, informations, elevation, updated, SPEED);
	}


	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/

	@Override
	public void init() 
	{
		/* add tribe points then humans around */
		for ( int x = 0 ; x < this.width ; x++ )
		{
			for ( int y = 0 ; y < this.height ; y++ )
			{	
				int nbTribes = 0;
				if (DENSITY_TRIBES >= Math.random() && (this.isOnlyInState(x, y, EMPTY) || this.isOnlyInState(x, y, FOREST_GRASS)) && this.elevation[x][y] >= 0 && !this.lookAroundFor(x,y,TRIBE_MAIN))
				{
					this.addStates(x, y, TRIBE_MAIN);
					this.informations[x][y][1] = nbTribes;
					nbTribes++;
				}
			}
		}

		for ( int x = 0 ; x < this.width ; x++ )
		{
			for ( int y = 0 ; y < this.height ; y++ )
			{	
				if (this.isOnlyInState(x, y, TRIBE_MAIN))
				{
					for(int i = 0; i < HUMANS_PER_TRIBE; i++) 
					{
						for(int a = x-5; a < x+5; a++)
						{
							for(int b = y-5; b < y+5; b++)
							{
								if(this.isOnlyInState(a, b, EMPTY) || this.isOnlyInState(a, b, FOREST_GRASS))
								{
									this.addHuman(a, b, HUMAN_SIMPLE, i);
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void step(int x, int y) {
		if (!this.updated[x][y])
		{
			if(this.isInState(x, y, HUMAN_SIMPLE) && !this.checkHunger(x, y, HUMAN_SIMPLE))
			{
				if(this.nbNeighborsMoore(x, y, AGENT_PREDATOR) > 0)
				{

					//fight or flight ?
					if(this.nbNeighborsMoore(x, y, HUMAN_SIMPLE) > this.nbNeighborsMoore(x, y, AGENT_PREDATOR))
					{
						//more humans than predators, kill predator, reset hunger for humans around ?
						int[][] predPos  = this.findAll(x,y,AGENT_PREDATOR);
						int[][] humPos = this.findAll(x, y, HUMAN_SIMPLE);
						for(int a = 0; a < predPos.length; a++)
						{
							if(predPos[a][0] != -1) //case where there is not nothing
							{
								this.removeStates(predPos[a][0], predPos[a][1], AGENT_PREDATOR);
								this.informations[predPos[a][0]][predPos[a][1]][0] = 0;
							}
						}
						for(int a = 0; a < humPos.length;a++)
						{
							if(humPos[a][0] != -1)
							{
								this.informations[humPos[a][0]][humPos[a][1]][0] = 0;
								//eating the predator
							}
						}
					}
					else
					{
						this.removeStates(x, y, HUMAN_SIMPLE);
						this.informations[x][y][0] = 0;
						this.informations[x][y][1] = 0;
						this.informations[x][y][2] = 0;
						int[][] predPos  = this.findAll(x,y,AGENT_PREDATOR);
						for(int a = 0; a < predPos.length; a++)
						{
							if(predPos[a][0] != -1) //case where there is not nothing
							{
								this.informations[predPos[a][0]][predPos[a][1]][0] = 0;
							}
						}						
					}
				}
				else if(this.nbNeighborsMoore(x, y, FOREST_TREE) > 0)
				{
					this.informations[x][y][2]++;
					if(this.informations[x][y][2] > NEW_BUILDING)
					{
						//New buildings created ?
					}
				}
				else 
				{
					int[] newCoord = this.getRandomCoord(x, y);
					this.moveAgent(x, y, newCoord[0], newCoord[1], HUMAN_SIMPLE);
				}
			}
		}
	}

	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/

	/**
	 * @param x
	 * @param y
	 * @param state
	 */
	private int[][] findAll(int x, int y, int state) {
		int[][] returntab = new int[8][2];
		for(int a = 0; a < returntab.length; a ++)
		{
			for(int b = 0; b < returntab[0].length; b++)
			{
				returntab[a][b] = -1;
			}
		}
		int cpt = 0;
		for(int i = x-1; i < x+1; i++)
		{
			for (int j= y-1; j < y+1; j++)
			{
				cpt++;
				if(i >= 0 && i < this.width && j >=0 && j < this.height && this.isInState(x, y, state) && i != x && j != y)
				{
					returntab[cpt][0] = i;
					returntab[cpt][1] = j;
				}
			}
		}
		return returntab;
	}


	private boolean checkHunger(int x, int y, int type)
	{
		boolean isStarving = false;

		if (this.isInState(x, y, HUMAN_SIMPLE))
		{
			isStarving = this.informations[x][y][0] == HUMAN_HUNGER_LIMIT;

			if (isStarving)
			{
				this.removeStates(x, y, type);
				this.informations[x][y][0] = 0;
			}
			else
			{
				this.informations[x][y][0]++;
			}
		}

		return isStarving;
	}

	private boolean lookAroundFor(int x, int y, int state) 
	{
		for(int i = x - 5; i < x + 5; i++)
		{
			for(int j = y - 5; j < y + 5; j++)
			{
				if(this.isInState(i, j, state) && i != x && j != y)
				{
					return true;
				}
			}
		}
		return false;
	}


	private void addHuman(int x, int y, int state, int tribeNumber) 
	{
		if (!this.isOnlyInState(x, y, EMPTY) && !this.isOnlyInState(x, y, FOREST_GRASS))
		{
			throw new IllegalArgumentException(Agent.class.getSimpleName() + " : Cannot add agent to a non-empty position.");
		}
		this.addStates(x, y, state);
		this.informations[x][y][0] = 0;
		this.informations[x][y][1] = tribeNumber;
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

	private void moveAgent(int x, int y, int newX, int newY, int type)
	{
		if (!this.isOnlyInState(newX, newY, EMPTY) && !this.isOnlyInState(newX, newY, FOREST_GRASS) && !(x == newX && y == newY))
		{
			throw new IllegalArgumentException(Agent.class.getSimpleName() + " : Cannot move agent to a non-empty position.");
		}

		this.removeStates(x, y, type);
		this.informations[newX][newY][0] = this.informations[x][y][0];
		this.informations[newX][newY][1] = this.informations[x][y][1];
		this.informations[x][y][0] = 0;
		this.informations[x][y][1] = 0;
		this.addStates(newX, newY, type);
		this.updated[newX][newY] = true;
	}

}
