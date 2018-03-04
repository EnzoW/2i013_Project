package etu.upmc.project.cellularautomaton;

import java.util.ArrayList;
import java.util.Collections;

import javax.security.auth.x500.X500Principal;

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
				if (DENSITY >= Math.random() && this.buffer[x][y] == AutomatonState.EMPTY && 
						!(this.nbNeighborsMoore(x, y, AutomatonState.FOREST_TREE)==4))
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
		case AGENT_PREY :
			this.informations[x][y]++; //nourriture
			if(this.informations[x][y]>PREY_HUNGER_LIMIT)
			{
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
				break; //meurt de faim
			}
			if(this.nbNeighborsMoore(x, y, AutomatonState.AGENT_PREDATOR_HUNTING) >= 1)
			{
				boolean[] closePred = this.getNeighborhood(x, y, AutomatonState.AGENT_PREDATOR_HUNTING);
				ArrayList<Integer> cpt = new ArrayList<Integer>();
				for(int i = 0; i < 8; i++)
				{
					if(closePred[i])
					{
						cpt.add(i);
					}
				}//onprends un predateur et on réagit en fonction
				Collections.shuffle(cpt); //on a enlevé le biais en prenant le chasseur à la position 0
				//on déplace le chasseur choisit aléatoirement et la proie en même temps
				this.buffer[x][y] = AutomatonState.AGENT_PREY_FLEEING;

				switch(cpt.get(0))//pos du premier pred qu'on prend (même s'il y en a plusieurs un seul se met en chasse)
				{
				case 0 : //prédateur au sud ouest x-1 y-1
					//cas favori : fuire au nord est x+1 y+1:
					if( ((x + 1) <= this.width) || ((y + 1) <= this.height))
					{
						if(this.buffer[x+1][y+1] == AutomatonState.EMPTY)
						{
							this.informations[x+1][y+1] = this.informations[x][y];
							this.informations[x][y] = this.informations[x-1][y-1];
							this.informations[x-1][y-1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x+1][y+1] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x-1][y-1] = AutomatonState.EMPTY;
						}
					}
					else 
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x-1][y-1];
							this.informations[x-1][y-1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x-1][y-1] = AutomatonState.EMPTY;
						}
						else 
						{//bougenormalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x-1][y-1];
							this.informations[x-1][y-1] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x-1][y-1] = AutomatonState.EMPTY;
						}
					}
					break;
				case 1 : //pod pred = x-1 y
					if(x + 1 >= this.width) {
						if(this.buffer[x+1][y] == AutomatonState.EMPTY)
						{
							this.informations[x+1][y] = this.informations[x][y];
							this.informations[x][y] = this.informations[x-1][y];
							this.informations[x-1][y] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x+1][y] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x-1][y] = AutomatonState.EMPTY;
						}
					}
					else
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x-1][y];
							this.informations[x-1][y] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x-1][y] = AutomatonState.EMPTY;
						}
						else 
						{//bougenormalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x-1][y];
							this.informations[x-1][y] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x-1][y] = AutomatonState.EMPTY;
						}
					}
					break;
				case 2 : //pos pred : x-1 y+1
					if(!(x+1 >= this.width || y-1 < 0)) {
						if(this.buffer[x+1][y-1] == AutomatonState.EMPTY)
						{
							this.informations[x+1][y-1] = this.informations[x][y];
							this.informations[x][y] = this.informations[x-1][y+1];
							this.informations[x-1][y+1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x+1][y-1] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x-1][y+1] = AutomatonState.EMPTY;
						}
					}
					else
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x-1][y];
							this.informations[x-1][y] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x-1][y] = AutomatonState.EMPTY;
						}
						else 
						{//bouge normalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x-1][y+1];
							this.informations[x-1][y+1] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x-1][y+1] = AutomatonState.EMPTY;
						}
					}
					break;
				case 3 : //x y-1
					if(!(y+1 >= this.height)) {
						if(this.buffer[x][y+1] == AutomatonState.EMPTY)
						{
							this.informations[x][y+1] = this.informations[x][y];
							this.informations[x][y] = this.informations[x][y-1];
							this.informations[x][y-1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x][y+1] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y-1] = AutomatonState.EMPTY;
						}
					}
					else
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x][y-1];
							this.informations[x][y-1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x][y-1] = AutomatonState.EMPTY;
						}
						else 
						{//bouge normalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x][y-1];
							this.informations[x][y-1] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x][y-1] = AutomatonState.EMPTY;
						}
					}
					break;
				case 4 : //x y+1
					if(!(y-1 < 0)) {
						if(this.buffer[x][y-1] == AutomatonState.EMPTY)
						{
							this.informations[x][y-1] = this.informations[x][y];
							this.informations[x][y] = this.informations[x][y+1];
							this.informations[x][y+1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x][y-1] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y+1] = AutomatonState.EMPTY;
						}
					}
					else
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x][y+1];
							this.informations[x][y+1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x][y+1] = AutomatonState.EMPTY;
						}
						else 
						{//bouge normalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x][y+1];
							this.informations[x][y+1] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x][y+1] = AutomatonState.EMPTY;
						}
					}
					break;
				case 5 : //x+1 y-1
					if(!(x-1 < 0 || y+1 >= this.height)) {
						if(this.buffer[x-1][y+1] == AutomatonState.EMPTY)
						{
							this.informations[x-1][y+1] = this.informations[x][y];
							this.informations[x][y] = this.informations[x+1][y-1];
							this.informations[x+1][y-1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x-1][y+1] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x+1][y-1] = AutomatonState.EMPTY;
						}
					}
					else
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x+1][y-1];
							this.informations[x+1][y-1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x+1][y-1] = AutomatonState.EMPTY;
						}
						else 
						{//bouge normalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x+1][y-1];
							this.informations[x+1][y-1] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x+1][y-1] = AutomatonState.EMPTY;
						}
					}
					break;
				case 6 : //x+1 y
					if(!(x-1 < 0)) {
						if(this.buffer[x-1][y] == AutomatonState.EMPTY)
						{
							this.informations[x-1][y] = this.informations[x][y];
							this.informations[x][y] = this.informations[x+1][y];
							this.informations[x+1][y] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x+1][y] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x+1][y] = AutomatonState.EMPTY;
						}
					}
					else
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x+1][y];
							this.informations[x+1][y] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x+1][y] = AutomatonState.EMPTY;
						}
						else 
						{//bouge normalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x+1][y];
							this.informations[x+1][y] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x+1][y] = AutomatonState.EMPTY;
						}
					}
					break;
				case 7 : //x+1 y+1
					if(!(x-1 < 0 || y-1 < 0)) {
						if(this.buffer[x-1][y-1] == AutomatonState.EMPTY)
						{
							this.informations[x-1][y-1] = this.informations[x][y];
							this.informations[x][y] = this.informations[x+1][y+1];
							this.informations[x+1][y+1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x-1][y-1] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x+1][y+1] = AutomatonState.EMPTY;
						}
					}
					else
					{
						int[] newPos = this.moveToEmpty(x,  y);
						if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
						{
							this.informations[x][y] = this.informations[x+1][y+1];
							this.informations[x+1][y+1] = 0;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
							this.buffer[x+1][y+1] = AutomatonState.EMPTY;
						}
						else 
						{//bouge normalement ET ON FAIT BOUGER LE PREDATOR QUI CHASSE EN MEME TEMPS
							this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
							this.informations[x][y] = this.informations[x+1][y+1];
							this.informations[x+1][y+1] = 0;
							this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY_FLEEING;
							this.buffer[x][y] = AutomatonState.AGENT_PREDATOR_HUNTING;
							this.buffer[x+1][y+1] = AutomatonState.EMPTY;
						}
					}
					break;
				default:
					break;

				}
			}
			else if(this.nbNeighborsMoore(x, y, AutomatonState.AGENT_PREDATOR)>=1)
			{
				this.informations[x][y]++;
				this.buffer[x][y] = AutomatonState.AGENT_PREY_FLEEING;	
				break;
			}
			else if(this.nbNeighborsVN(x, y, AutomatonState.FOREST_GRASS)>=1)
			{
				//TODO : herbes et manger trop mort rn

				break;
			}
			else 
			{
				int[] newPos = this.moveToEmpty(x, y);
				this.buffer[newPos[0]][newPos[1]] = this.buffer[x][y];
				this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
			}
			break;
		case AGENT_PREDATOR:
			// TODO: Si une proie est présente dans son voisinage --> poursuite
			//TEST : Poursuite avec posNeighborAgent
			this.informations[x][y]++;
			if(this.nbNeighborsVN(x, y, AutomatonState.FOREST_TREE)==4)
			{
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
				break;
			}
			if(this.informations[x][y]>PREDATOR_HUNGER_LIMIT)
			{
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
				break;
			}
			if(this.nbNeighborsMoore(x, y, AutomatonState.AGENT_PREY_FLEEING)>=1) 
			{
				this.buffer[x][y]=AutomatonState.AGENT_PREDATOR_HUNTING;
				break;
			}
			else 
			{
				int[] newPos = this.moveToEmpty(x, y);
				this.buffer[newPos[0]][newPos[1]] = this.buffer[x][y];
				this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
			}
			break;
		default:
			break;
		}
	}

	/**
	 * @param x
	 * @param y
	 * @return int[0] : x  
	 * 		   int[1]:  y
	 */

	protected int[] moveToEmpty(final int x, final int y) 
	{
		/*
		 * on bouge dans une case de Moore sur une case vide 
		 * TODO :on évite les types d'automate dangereux (pas se mettre à côté d'un prédateur ou d'un feu de forêt
		 */

		int[] rand = {0, 1, 2, 3, 4, 5, 6, 7};
		Tools.shuffle(rand);
		int[] returnValue= new int[] {x,y};
		for(int i = 0; i < 8; i++)
		{
			switch(rand[i])
			{
			case 0 : //x-1 y-1
				if(!(x-1 < 0 || y-1 < 0)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY)
					{
						returnValue[0]= x-1; returnValue[1]=y-1;
					}
				}
				break;	
			case 1 : //x-1 y
				if(!(x-1 < 0)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY && !(x-1 < 0))
					{
						returnValue[0]= x-1; returnValue[1]=y;
					}
				}
				break;
			case 2 : //x-1 y+1
				if(!(x-1 < 0 || y+1 >= this.height)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY && !(x-1 < 0 || y+1 > height))
					{
						returnValue[0]= x-1; returnValue[1]=y+1;
					}
				}
				break;
			case 3 : //x y-1
				if(!(y-1 < 0)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY)
					{
						returnValue[0]= x; returnValue[1]=y-1;
					}
				}
				break;
			case 4 : //x y+1
				if(!(y+1 >= this.height)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY)
					{
						returnValue[0]= x; returnValue[1]=y+1;
					}
				}
				break;
			case 5 : //x+1 y-1
				if(!(x+1 >= this.height || y-1 < 0)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY)
					{
						returnValue[0]= x+1; returnValue[1]=y-1;
					}
				}
				break;
			case 6 : //x+1 y
				if(!(x+1 >= this.height)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY)
					{
						returnValue[0]= x+1; returnValue[1]=y;
					}
				}
				break;
			case 7 : //x+1 y+1
				if(!(x+1 >= this.width || y+1 >= this.height)) {
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY)
					{
						returnValue[0]= x+1; returnValue[1]=y+1;
					}
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
	//	protected int[] posNeighborAgent(final int x, final int y)
	//	{
	//		//V1 de la poursuite/fuite : ne marche que pour la poursuite � v�rifier l'int�r�t par rapport � la V2 plus loin ci dessous
	//		ArrayList<Integer[]> randTabPos = new ArrayList<Integer[]>(); // on introduit une liste de couples que l'on va randomiser
	//		Integer[] tab = {(x+1+width)%width,(y+height)%height}; randTabPos.add(tab); //x+1,y
	//		Integer[] tab2 = {(x+width)%width,(y+1+height)%height}; randTabPos.add(tab2); //x,y+1
	//		Integer[] tab3 = {(x-1+width)%width,(y+height)%height}; randTabPos.add(tab3); //x-1,y
	//		Integer[] tab4 = {(x+width)%width,(y-1+height)%height}; randTabPos.add(tab4); //x,y-1
	//
	//		Collections.shuffle(randTabPos); //on randomise les couples de positions (voisinage de VN)
	//
	//		if(this.buffer[x][y]==AutomatonState.AGENT_PREDATOR) 
	//		{		
	//			if(this.buffer[randTabPos.get(0)[0]][randTabPos.get(0)[1]]==AutomatonState.AGENT_PREY)
	//			{
	//				int[] tabRetour = {randTabPos.get(0)[0],randTabPos.get(0)[1]};
	//				return tabRetour;
	//			}
	//			if(this.buffer[randTabPos.get(1)[0]][randTabPos.get(1)[1]]==AutomatonState.AGENT_PREY)
	//			{
	//				int[] tabRetour = {randTabPos.get(1)[0],randTabPos.get(1)[1]};
	//				return tabRetour;
	//			}
	//			if(this.buffer[randTabPos.get(2)[0]][randTabPos.get(2)[1]]==AutomatonState.AGENT_PREY)
	//			{
	//				int[] tabRetour = {randTabPos.get(2)[0],randTabPos.get(2)[1]};
	//				return tabRetour;
	//			}
	//			if(this.buffer[randTabPos.get(3)[0]][randTabPos.get(3)[1]]==AutomatonState.AGENT_PREY)
	//			{
	//				int[] tabRetour = {randTabPos.get(3)[0],randTabPos.get(3)[1]};
	//				return tabRetour;
	//			}
	//		}
	//		if(this.buffer[x][y]==AutomatonState.AGENT_PREY)
	//		{		
	//			//V2 de la fuite/pourchasse : avec un switch et une liste randomis�e pour ne pas introduire de biais
	//			ArrayList<Integer> randInt = new ArrayList<Integer>(); 
	//			randInt.add(0); randInt.add(1); randInt.add(2); randInt.add(3);
	//			Collections.shuffle(randInt);
	//			for(int i=0;i<4;i++)
	//			{
	//				switch(randInt.get(i))
	//				{
	//				case 0 :
	//					if(this.buffer[(x+width)%width][(y+1+height)%height]==AutomatonState.AGENT_PREDATOR)
	//					{
	//						int[] returnTab = {(x+width)%width,(y-1+height)%height};
	//						return returnTab;
	//					}
	//					break;
	//				case 1 :
	//					if(this.buffer[(x+1+width)%width][(y+height)%height]==AutomatonState.AGENT_PREDATOR)
	//					{
	//						int[] returnTab = {(x-1+width)%width,(y+height)%height};
	//						return returnTab;
	//					}
	//					break;
	//				case 2 :
	//					if(this.buffer[(x+width)%width][(y-1+height)%height]==AutomatonState.AGENT_PREDATOR)
	//					{
	//						int[] returnTab = {(x+width)%width,(y+1+height)%height};
	//						return returnTab;
	//					}
	//					break;
	//				case 3 :
	//					if(this.buffer[(x-1+width)%width][(y+height)%height]==AutomatonState.AGENT_PREDATOR)
	//					{
	//						int[] returnTab = {(x+1+width)%width,(y+height)%height};
	//						return returnTab;
	//					}
	//					break;
	//				}
	//			}
	//
	//		}
	//		int[] tabNull = {x,y};
	//		//System.out.println("non trouv�");
	//		return tabNull;
	//	}

	//	public int[] posNearestFood(final int x, final int y)
	//	{		
	//		ArrayList<Integer> randInt = new ArrayList<Integer>(); 
	//		randInt.add(0); randInt.add(1); randInt.add(2); randInt.add(3);
	//		Collections.shuffle(randInt);
	//		for(int i=0;i<4;i++)
	//		{
	//			switch(randInt.get(i))
	//			{
	//			case 0 :
	//				if(this.buffer[(x+width)%width][(y+1+height)%height]==AutomatonState.FOREST_GRASS)
	//				{
	//					int[] returnTab = {(x+width)%width,(y+1+height)%height};
	//					return returnTab;
	//				}
	//				break;
	//			case 1 :
	//				if(this.buffer[(x+1+width)%width][(y+height)%height]==AutomatonState.FOREST_GRASS)
	//				{
	//					int[] returnTab = {(x+1+width)%width,(y+height)%height};
	//					return returnTab;
	//				}
	//				break;
	//			case 2 :
	//				if(this.buffer[(x+width)%width][(y-1+height)%height]==AutomatonState.FOREST_GRASS)
	//				{
	//					int[] returnTab = {(x+width)%width,(y-1+height)%height};
	//					return returnTab;
	//				}
	//				break;
	//			case 3 :
	//				if(this.buffer[(x-1+width)%width][(y+height)%height]==AutomatonState.FOREST_GRASS)
	//				{
	//					int[] returnTab = {(x-1+width)%width,(y+height)%height};
	//					return returnTab;
	//				}
	//				break;
	//			}
	//		}
	//		int[] tabNull = {x,y};
	//		return tabNull;
	//	}
	protected boolean[] getNeighborhood(final int x, final int y, final AutomatonState state)
	{
		boolean[] neighbors = new boolean[8];
		int n = 0;
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					if(i > width || i < 0 || j > height || j < 0)
					{
						continue;
					}
					if (this.buffer[i] [j] == state)
					{

						neighbors[n]=true;
					}
					n++;
				}
			}
		}
		return neighbors;
	}
}
