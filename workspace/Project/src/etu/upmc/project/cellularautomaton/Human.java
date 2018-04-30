/**
 * 
 */
package etu.upmc.project.cellularautomaton;

import java.util.ArrayList;

import etu.upmc.project.tools.Tools;
/**
 * Humans are extension of the cellular automaton class
 * they exist on the same buffer than Agents
 * the information buffer needs to be extended to at least 3 dimensions for the new parameters
 * let's pray that the architecture doesn't break down (and me too) when I try to implement more complexity	
 *
 */
public class Human extends CellularAutomaton {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	private static final int 	SPEED 					= 1;
	private static final double DENSITY_TRIBES      	= 0.0001;
	private static final double	DENSITY_HUMANS 			= 0.10; //not random for now
	private static final double HUMAN_HUNGER_LIMIT  	= 200000;
	private static final int 	NEW_BUILDING 			= 100;
	private static final double PROB_KILLING_PREY 		= 0.8;
	private static final int 	CARRY_CAPACITY 			= 10;


	private ArrayList<Tribe> tribes;
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
		this.tribes = new ArrayList<Tribe>();
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
					this.tribes.add(new Tribe(x,y));
					for(int a = x-10; a < x+10; a++)
					{
						for(int b = y-10; b < y+10; b++)
						{
							if( a >= 0 && a < this.width && b >= 0 && b < this.height)
							{
								if(Math.random() < DENSITY_HUMANS && this.isOnlyInState(a, b, EMPTY) || this.isOnlyInState(a, b, FOREST_GRASS))
								{

									this.addHuman(a, b, HUMAN_SIMPLE, this.informations[x][y][1]);
									this.tribes.get(this.informations[x][y][1]).addHuman(a, b);
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
			int[] pos = {x, y};
			int i = this.tribes.get(this.informations[x][y][1]).findHuman(pos);
			int[] newCoord = moveHuman(x, y);
			int[] newPos = {newCoord[0], newCoord[1]};
			this.tribes.get(this.informations[x][y][1]).changePosOfHuman(i, newPos);
			this.updated[newCoord[0]][newCoord[1]] = true;

		}
	}

	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/
	/**
	 * @param x
	 * @param y
	 */
	private int[] moveHuman(int x, int y) 
	{

		int[] returnCoords = new int[] {x, y};
		if(!this.updated[x][y])
		{
			if( x >= 0 && x < this.width && y >= 0 && y < this.height)
			{
				if(this.isInState(x, y, HUMAN_RETURN) && !this.checkHunger(x, y, HUMAN_RETURN))
				{
					//path finding to the tribe centre if too far away from it
					returnCoords = this.findPathToBase(x, y);
					if(this.distanceTo(x, y, this.tribes.get(this.informations[x][y][1]).getTribe_main_pos()) < 10)
					{
						this.changeState(x, y, HUMAN_RETURN, HUMAN_SIMPLE);
						this.tribes.get(this.informations[x][y][1]).addRessources(this.informations[x][y][2]);
						this.informations[x][y][2] = 0;
						if(this.tribes.get(this.informations[x][y][1]).getRessources() > NEW_BUILDING)
						{
							this.addBuilding(this.informations[x][y][1], this.getRandomCoord(this.tribes.get(this.informations[x][y][1]).getTribe_main_pos()[0], this.tribes.get(this.informations[x][y][1]).getTribe_main_pos()[1]));
						}
					}
				}
				else if(this.isInState(x, y, HUMAN_SIMPLE) && !this.checkHunger(x, y, HUMAN_SIMPLE))
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
					else if(this.nbNeighborsMoore(x, y, AGENT_PREY) > 0)
					{
						if(Math.random() > PROB_KILLING_PREY)
						{
							int[][] preyPos  = this.findAll(x, y, AGENT_PREY);
							for(int a = 0; a < preyPos.length; a++)
							{
								if(preyPos[a][0] != -1) //case where there is not nothing
								{
									this.removeStates(preyPos[a][0], preyPos[a][1], AGENT_PREY);
									this.informations[preyPos[a][0]][preyPos[a][1]][0] = 0;
								}
							}
							int[][] humPos = this.findAll(x, y, HUMAN_SIMPLE);
							for(int a = 0; a < humPos.length;a++)
							{
								if(humPos[a][0] != -1)
								{
									this.informations[humPos[a][0]][humPos[a][1]][0] = 0;
									//eating the prey
								}
							}
						}
						else
						{
							returnCoords = this.getRandomCoord(x, y);
							this.moveAgent(x, y, returnCoords[0], returnCoords[1], HUMAN_SIMPLE);
						}
					}
					else if(this.nbNeighborsMoore(x, y, FOREST_TREE) > 0)
					{
						this.informations[x][y][2]++;
						this.destroyATree(x,y);
						if(this.informations[x][y][2] > CARRY_CAPACITY)
						{
							this.changeState(x, y, HUMAN_SIMPLE, HUMAN_RETURN);
						}
					}
					else 	
					{
						int[] newCoords = this.getRandomCoord(x, y);
						this.moveAgent(x, y, newCoords[0], newCoords[1], HUMAN_SIMPLE);
						returnCoords = newCoords;
					}
				}
			}
		}
		return returnCoords;
	}



	/**
	 * @param x
	 * @param y
	 */
	private void destroyATree(int x, int y) 
	{
		int[][] treePos = this.findAll(x, y, FOREST_TREE);
		for(int i = 0; i < treePos.length; i++)
		{
			if(treePos[i][0] != -1)
			{
				this.removeStates(treePos[i][0], treePos[i][1], FOREST_TREE);
			}
		}
	}


	/**
	 * @param i
	 * @param randomCoord
	 */
	private boolean addBuilding(int i, int[] randomCoord) 
	{
		boolean returnvalue = false;
		if(!(randomCoord[0] == this.tribes.get(i).getTribe_main_pos()[0] && randomCoord[1] == this.tribes.get(i).getTribe_main_pos()[1]))
		{
			if( randomCoord[0] >= 0 && randomCoord[0] < this.width && randomCoord[1] >= 0 && randomCoord[1] < this.height)
			{
				if(this.isEmpty(randomCoord[0], randomCoord[1])) 
				{
					this.addStates(randomCoord[0], randomCoord[1], BUILDING);
					this.informations[randomCoord[0]][randomCoord[1]][1] = i;
					returnvalue = true;
					this.tribes.get(i).removeRessources(NEW_BUILDING);
				}
			}
		}
		return returnvalue;
	}


	private int[] findPathToBase(int x, int y)
	{
		int[] returnCoords = new int[2];
		int[] Tribe_main_pos = this.tribes.get(this.informations[x][y][1]).getTribe_main_pos();
		if(this.distanceTo(x, y, this.tribes.get(this.informations[x][y][1]).getTribe_main_pos()) > 100)
		{
			int distLineFree = this.distLineFree(x, y, this.tribes.get(this.informations[x][y][1]).getTribe_main_pos()[0]);
			if(distLineFree == this.distanceTo(x, y, this.tribes.get(this.informations[x][y][1]).getTribe_main_pos()))
			{
				//if tribe centre is to the right
				if(x - Tribe_main_pos[0] > 0)
				{//up ?
					if(y - Tribe_main_pos[1] > 0)
					{
						if( x+1 >= 0 && x+1 < this.width && y+1 >= 0 && y+1 < this.height)
						{
							if(this.isEmpty(x+1,y+1))
							{
								this.moveAgent(x,y,x+1,y+1,HUMAN_RETURN);
								returnCoords[0] = x+1; returnCoords[1] = y+1;
							}
						}
						else if( x+1 >= 0 && x+1 < this.width && y >= 0 && y < this.height)
						{
							if(this.isEmpty(x+1, y))
							{
								this.moveAgent(x, y, x+1, y, HUMAN_RETURN);
								returnCoords[0] = x+1; returnCoords[1] = y;

							}
						}
						else if( x >= 0 && x < this.width && y+1 >= 0 && y+1 < this.height)
						{
							if(this.isEmpty(x, y+1))
							{
								this.moveAgent(x, y, x, y+1, HUMAN_RETURN);
								returnCoords[0] = x; returnCoords[1] = y+1;

							}
						}
						else
						{//nothing free = random move
							returnCoords = this.getRandomCoord(x, y);
							this.moveAgent(x, y, returnCoords[0], returnCoords[1], HUMAN_RETURN);
						}
					}
					else //left ?
					{
						if( x+1 >= 0 && x+1 < this.width && y-1 >= 0 && y-1 < this.height)
						{
							if(this.isEmpty(x+1, y-1))
							{
								this.moveAgent(x, y, x+1, y-1, HUMAN_RETURN);
								returnCoords[0] = x+1; returnCoords[1] = y-1;

							}
						}
						else if( x+1 >= 0 && x+1 < this.width && y >= 0 && y < this.height)
						{
							if(this.isEmpty(x+1, y))
							{
								this.moveAgent(x, y, x+1, y, HUMAN_RETURN);
								returnCoords[0] = x+1; returnCoords[1] = y;

							}
						}
						else if( x >= 0 && x < this.width && y-1 >= 0 && y-1 < this.height)
						{
							if(this.isEmpty(x, y-1))
							{
								this.moveAgent(x, y, x, y-1, HUMAN_RETURN);
								returnCoords[0] = x; returnCoords[1] = y-1;

							}
						}
						else	
						{//nothing free = random move
							returnCoords = this.getRandomCoord(x, y);
							this.moveAgent(x, y, returnCoords[0], returnCoords[1], HUMAN_RETURN);
						}
					}
				}
				else//down?
				{//right

					if(y - Tribe_main_pos[1] > 0)
					{
						if( x-1 >= 0 && x-1 < this.width && y+1 >= 0 && y+1 < this.height)
						{
							if(this.isEmpty(x-1,y+1))
							{
								this.moveAgent(x, y, x-1, y+1, HUMAN_RETURN);
								returnCoords[0] = x-1; returnCoords[1] = y+1;

							}
						}
						else if( x-1 >= 0 && x-1 < this.width && y >= 0 && y < this.height)
						{
							if(this.isEmpty(x-1, y))
							{
								this.moveAgent(x, y, x-1, y, HUMAN_RETURN);
								returnCoords[0] = x-1; returnCoords[1] = y;

							}
						}
						else if( x >= 0 && x < this.width && y+1 >= 0 && y+1 < this.height)
						{
							if(this.isEmpty(x, y+1))
							{
								this.moveAgent(x, y, x, y+1, HUMAN_RETURN);
								returnCoords[0] = x; returnCoords[1] = y+1;

							}
						}
						else
						{//nothing free = random move
							returnCoords = this.getRandomCoord(x, y);
							this.moveAgent(x, y, returnCoords[0], returnCoords[1], HUMAN_RETURN);
						}
					}
					else //left ?
					{
						if( x-1 >= 0 && x-1 < this.width && y-1 >= 0 && y-1 < this.height)
						{
							if(this.isEmpty(x-1, y-1))
							{
								this.moveAgent(x, y, x+1, y-1, HUMAN_RETURN);
								returnCoords[0] = x+1; returnCoords[1] = y-1;

							}
						}
						else if( x-1 >= 0 && x-1 < this.width && y >= 0 && y < this.height)
						{
							if(this.isEmpty(x-1, y))
							{
								this.moveAgent(x, y, x+1, y, HUMAN_RETURN);
								returnCoords[0] = x; returnCoords[1] = y;

							}
						}
						else if( x >= 0 && x < this.width && y-1 >= 0 && y-1 < this.height)
						{
							if(this.isEmpty(x, y-1))
							{
								this.moveAgent(x, y, x, y-1, HUMAN_RETURN);
								returnCoords[0] = x; returnCoords[1] = y-1;

							}
						}
						else
						{//nothing free = random move
							returnCoords = this.getRandomCoord(x, y);
							this.moveAgent(x, y, returnCoords[0], returnCoords[1], HUMAN_RETURN);
						}
					}
				}
			}
		}
		return returnCoords;
	}


	/**
	 * @param x
	 * @param distanceTo
	 * @return
	 */
	private int distLineFree(int x,int y, int distanceTo) {
		for(int i = x; i < distanceTo; i++)
		{
			if( x >= 0 && x < this.width && y >= 0 && y < this.height)
			{
				if(this.isInState(i, y, FOREST_TREE,FOREST_TREE_BURNING))
				{
					return i;
				}
			}
		}
		return distanceTo;
	}


	/**
	 * @param x
	 * @param y
	 * @param tribe_main_pos
	 * @return
	 */
	private int distanceTo(int x, int y, int[] tribe_main_pos) 
	{
		return (int) Math.sqrt(Math.pow((double) (x-tribe_main_pos[0]),2) + Math.sqrt(Math.pow((double) (y-tribe_main_pos[1]), 2)));
	}


	/**
	 * @param x
	 * @param y
	 * @param state
	 */
	private int[][] findAll(int x, int y, int state) {
		int[][] coord = new int[8][2];
		int n = 0;

		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					if (j >= 0 && i >= 0 && j < this.height && i < this.width && this.isInState(i, j, state))
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



	private boolean checkHunger(int x, int y, int type)
	{
		boolean isStarving = false;
		if( x >= 0 && x < this.width && y >= 0 && y < this.height)
		{
			if (this.isInState(x, y, HUMAN_SIMPLE))
			{
				isStarving = this.informations[x][y][0] == HUMAN_HUNGER_LIMIT;

				if (isStarving)
				{
					this.tribes.get(this.informations[x][y][1]).removeAtPos(x,y);
					this.removeStates(x, y, type);
					this.informations[x][y][0] = 0;
				}
				else
				{
					this.informations[x][y][0]++;
				}
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
				if( i >= 0 && i < this.width && j >= 0 && j < this.height)
				{
					if(this.isInState(i, j, state) && i != x && j != y)
					{
						return true;
					}
				}
			}
		}
		return false;
	}


	private void addHuman(int x, int y, int state, int tribeNumber) 
	{
		if( x >= 0 && x < this.width && y >= 0 && y < this.height)
		{
			if (!(this.elevation[x][y] > 0) && !this.isOnlyInState(x, y, EMPTY) && !this.isOnlyInState(x, y, FOREST_GRASS))
			{
				throw new IllegalArgumentException(Agent.class.getSimpleName() + " : Cannot add agent to a non-empty position.");
			}

			this.addStates(x, y, state);
			this.informations[x][y][0] = 0;
			this.informations[x][y][1] = tribeNumber;
			this.informations[x][y][2] = 0;
		}
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
		if( x >= 0 && x < this.width && y >= 0 && y < this.height && newX >= 0 && newX < this.width && newY >= 0 && newY < this.height)
		{
			if (!this.isOnlyInState(newX, newY, EMPTY) && !this.isOnlyInState(newX, newY, FOREST_GRASS) && !(x == newX && y == newY))
			{
				throw new IllegalArgumentException(Agent.class.getSimpleName() + " : Cannot move agent to a non-empty position.");
			}

			this.removeStates(x, y, type);
			this.informations[newX][newY][0] = this.informations[x][y][0];
			this.informations[newX][newY][1] = this.informations[x][y][1];
			this.informations[newX][newY][2] = this.informations[x][y][2];
			this.informations[x][y][0] = 0;
			this.informations[x][y][1] = 0;
			this.informations[x][y][2] = 0;
			this.addStates(newX, newY, type);
			this.updated[newX][newY] = true;
		}
	}

}
