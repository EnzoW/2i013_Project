package etu.upmc.project.cellularautomaton;

import java.util.ArrayList;
import java.util.Collections;

import etu.upmc.project.tools.Tools;

/**
 * @author Quentin S.
 * @date 24/02
 */
public class Agent extends CellularAutomaton 
{
	private static final double DENSITY = 0.20;
	private static final int PREY_HUNGER_LIMIT = 50;
	private static final int PREDATOR_HUNGER_LIMIT = 100;

	public Agent(int width, int height, AutomatonState[][] buffer, int[][] informations, double[][] elevation) 
	{
		super(width, height, buffer, informations, elevation);
	}

	@Override
	public void init() 
	{
		for ( int x = 0 ; x < this.width ; x++ )
		{
			for ( int y = 0 ; y < this.height ; y++ )
			{
				if (DENSITY >= Math.random() && this.buffer[x][y] == AutomatonState.EMPTY)
				{
					this.buffer[x][y] = Math.random() < 0.5 ? AutomatonState.AGENT_PREDATOR : AutomatonState.AGENT_PREY;
				}
			}
		}
	}

	@Override
	public void step(int x, int y) 
	{
		switch (this.buffer[x][y]) 
		{
		case EMPTY:
			break;
		case AGENT_PREY:
			// TODO: Si un prédateur est présent dans son voisinage --> fuite
			//Test fuite avec posNeighborAgent
			if(this.nbNeighborsVN(x, y, AutomatonState.FOREST_TREE)==4)
			{
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
				break;
			}
			this.informations[x][y]++;
			if(this.informations[x][y]>PREY_HUNGER_LIMIT)
			{
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
				break;
			}
			if(this.nbNeighborsVN(x, y, AutomatonState.AGENT_PREDATOR)>=1)
			{
				int[] fleeingPos = this.posNeighborAgent(x, y);
				this.buffer[x][y]=AutomatonState.EMPTY; 
				//TODO: Vérifier les cas où on est entouré ou alors où on fuit sur un prédateur
				this.buffer[fleeingPos[0]][fleeingPos[1]]=AutomatonState.AGENT_PREY;
				this.informations[fleeingPos[0]][fleeingPos[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
				break;
			}
			else if(this.nbNeighborsVN(x, y, AutomatonState.FOREST_GRASS)>=1)
			{
				int[] eatingPos = this.posNearestFood(x, y);
				this.buffer[x][y] = AutomatonState.EMPTY;
				this.buffer[eatingPos[0]][eatingPos[1]] = AutomatonState.AGENT_PREY;
				this.informations[x][y] = 0;
				this.informations[eatingPos[0]][eatingPos[1]] = 0;
				break;
			}
			else 
			{
				int[] posEmpty = this.moveToEmpty(x,y);
				this.buffer[x][y]=AutomatonState.EMPTY;
				this.buffer[posEmpty[0]][posEmpty[1]]=AutomatonState.AGENT_PREY;
				this.informations[posEmpty[0]][posEmpty[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
			}
			break;
		case AGENT_PREDATOR:
			// TODO: Si une proie est présente dans son voisinage --> poursuite
			//TEST : Poursuite avec posNeighborAgent
			if(this.nbNeighborsVN(x, y, AutomatonState.FOREST_TREE)==4)
			{
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
				break;
			}
			this.informations[x][y]++;
			if(this.informations[x][y]>PREDATOR_HUNGER_LIMIT)
			{
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
				break;
			}
			if(this.nbNeighborsVN(x, y, AutomatonState.AGENT_PREY)>=1) 
			{
				int[] huntingPos = this.posNeighborAgent(x, y);
				this.buffer[x][y]=AutomatonState.EMPTY; 
				this.buffer[huntingPos[0]][huntingPos[1]]=AutomatonState.AGENT_PREDATOR;
				this.informations[huntingPos[0]][huntingPos[1]] = 0;
				this.informations[x][y] = 0;
			}
			else 
			{
				int[] posEmpty = this.moveToEmpty(x,y);
				this.buffer[x][y]=AutomatonState.EMPTY;
				this.buffer[posEmpty[0]][posEmpty[1]]=AutomatonState.AGENT_PREDATOR;
				this.informations[posEmpty[0]][posEmpty[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
			}
			break;
		default:
			break;
		}
	}

	protected int[] moveToEmpty(final int x, final int y) 
	{
		/*
		 * Utilisation de la V2 de fuite. 
		 * Possibilit� de cr�er une fonction qui fait cette V2 avec le type d'automate recherch� en param
		 */

		int[] rand = {0, 1, 2, 3};
		int[] returnValue = new int[] {x, y};
		Tools.shuffle(rand);

		for(int i = 0; i < 4; i++)
		{
			switch(rand[i])
			{
			case 0 :
				if(this.buffer[(x + width) % width][(y + 1 + height) % height] == AutomatonState.EMPTY)
				{
					returnValue = new int[]{(x + width) % width, (y + 1 + height) % height};
				}
				break;
			case 1 :
				if(this.buffer[(x + 1 + width) % width][(y + height) % height] == AutomatonState.EMPTY)
				{
					returnValue = new int[]{(x + 1 + width) % width, (y + height) % height};
				}
				break;
			case 2 :
				if(this.buffer[(x + width) % width][(y - 1 + height) % height] == AutomatonState.EMPTY)
				{
					returnValue = new int[]{(x + width) % width, (y - 1 + height) % height};
				}
				break;
			case 3 :
				if(this.buffer[(x - 1 + width) % width][(y + height) % height] == AutomatonState.EMPTY)
				{
					returnValue = new int[]{(x - 1 + width) % width, (y + height) % height};
				}
				break;
			default:
				break;
			}
		}

		return returnValue;
	}

	/*
	 * On cherche la position de l'agent int�ressant dans le voisinage de VN
	 * autour de l'�l�ment � la position x y donn�e
	 * besoin de randomiser les x et y pour ne pas introduire un biais 
	 * p/r � la direction dans laquelle on regarde en premier
	 * besoin de racourcir
	 * Renvoie la pos de la proie si pr�dateur en param 
	 * Renvoie la pos de fuite si proie en param
	 */
	protected int[] posNeighborAgent(final int x, final int y)
	{
		//V1 de la poursuite/fuite : ne marche que pour la poursuite � v�rifier l'int�r�t par rapport � la V2 plus loin ci dessous
		ArrayList<Integer[]> randTabPos = new ArrayList<Integer[]>(); // on introduit une liste de couples que l'on va randomiser
		Integer[] tab = {(x+1+width)%width,(y+height)%height}; randTabPos.add(tab); //x+1,y
		Integer[] tab2 = {(x+width)%width,(y+1+height)%height}; randTabPos.add(tab2); //x,y+1
		Integer[] tab3 = {(x-1+width)%width,(y+height)%height}; randTabPos.add(tab3); //x-1,y
		Integer[] tab4 = {(x+width)%width,(y-1+height)%height}; randTabPos.add(tab4); //x,y-1

		Collections.shuffle(randTabPos); //on randomise les couples de positions (voisinage de VN)

		if(this.buffer[x][y]==AutomatonState.AGENT_PREDATOR) 
		{		
			if(this.buffer[randTabPos.get(0)[0]][randTabPos.get(0)[1]]==AutomatonState.AGENT_PREY)
			{
				int[] tabRetour = {randTabPos.get(0)[0],randTabPos.get(0)[1]};
				return tabRetour;
			}
			if(this.buffer[randTabPos.get(1)[0]][randTabPos.get(1)[1]]==AutomatonState.AGENT_PREY)
			{
				int[] tabRetour = {randTabPos.get(1)[0],randTabPos.get(1)[1]};
				return tabRetour;
			}
			if(this.buffer[randTabPos.get(2)[0]][randTabPos.get(2)[1]]==AutomatonState.AGENT_PREY)
			{
				int[] tabRetour = {randTabPos.get(2)[0],randTabPos.get(2)[1]};
				return tabRetour;
			}
			if(this.buffer[randTabPos.get(3)[0]][randTabPos.get(3)[1]]==AutomatonState.AGENT_PREY)
			{
				int[] tabRetour = {randTabPos.get(3)[0],randTabPos.get(3)[1]};
				return tabRetour;
			}
		}
		if(this.buffer[x][y]==AutomatonState.AGENT_PREY)
		{		
			//V2 de la fuite/pourchasse : avec un switch et une liste randomis�e pour ne pas introduire de biais
			ArrayList<Integer> randInt = new ArrayList<Integer>(); 
			randInt.add(0); randInt.add(1); randInt.add(2); randInt.add(3);
			Collections.shuffle(randInt);
			for(int i=0;i<4;i++)
			{
				switch(randInt.get(i))
				{
				case 0 :
					if(this.buffer[(x+width)%width][(y+1+height)%height]==AutomatonState.AGENT_PREDATOR)
					{
						int[] returnTab = {(x+width)%width,(y-1+height)%height};
						return returnTab;
					}
					break;
				case 1 :
					if(this.buffer[(x+1+width)%width][(y+height)%height]==AutomatonState.AGENT_PREDATOR)
					{
						int[] returnTab = {(x-1+width)%width,(y+height)%height};
						return returnTab;
					}
					break;
				case 2 :
					if(this.buffer[(x+width)%width][(y-1+height)%height]==AutomatonState.AGENT_PREDATOR)
					{
						int[] returnTab = {(x+width)%width,(y+1+height)%height};
						return returnTab;
					}
					break;
				case 3 :
					if(this.buffer[(x-1+width)%width][(y+height)%height]==AutomatonState.AGENT_PREDATOR)
					{
						int[] returnTab = {(x+1+width)%width,(y+height)%height};
						return returnTab;
					}
					break;
				}
			}

		}
		int[] tabNull = {x,y};
		//System.out.println("non trouv�");
		return tabNull;
	}

	public int[] posNearestFood(final int x, final int y)
	{		
		ArrayList<Integer> randInt = new ArrayList<Integer>(); 
		randInt.add(0); randInt.add(1); randInt.add(2); randInt.add(3);
		Collections.shuffle(randInt);
		for(int i=0;i<4;i++)
		{
			switch(randInt.get(i))
			{
			case 0 :
				if(this.buffer[(x+width)%width][(y+1+height)%height]==AutomatonState.FOREST_GRASS)
				{
					int[] returnTab = {(x+width)%width,(y+1+height)%height};
					return returnTab;
				}
				break;
			case 1 :
				if(this.buffer[(x+1+width)%width][(y+height)%height]==AutomatonState.FOREST_GRASS)
				{
					int[] returnTab = {(x+1+width)%width,(y+height)%height};
					return returnTab;
				}
				break;
			case 2 :
				if(this.buffer[(x+width)%width][(y-1+height)%height]==AutomatonState.FOREST_GRASS)
				{
					int[] returnTab = {(x+width)%width,(y-1+height)%height};
					return returnTab;
				}
				break;
			case 3 :
				if(this.buffer[(x-1+width)%width][(y+height)%height]==AutomatonState.FOREST_GRASS)
				{
					int[] returnTab = {(x-1+width)%width,(y+height)%height};
					return returnTab;
				}
				break;
			}
		}
		int[] tabNull = {x,y};
		return tabNull;
	}
}
