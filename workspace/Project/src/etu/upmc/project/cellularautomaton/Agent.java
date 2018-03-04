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
	private static final double DENSITY = 0.80;
	private static final int PREY_HUNGER_LIMIT = 500;
	private static final int PREDATOR_HUNGER_LIMIT = 1000;

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
				if(cpt.size() > 1)
				{
					switch(cpt.get(0))//pos du premier pred qu'on prend (même s'il y en a plusieurs un seul se met en chasse)
					{
					case 0 : //prédateur au sud ouest x-1 y-1
						//cas favori : fuire au nord est x+1 y+1:
						if(((x + 1 < this.width) && ((y + 1) < this.height)) && (y-1 >=0) && (x-1 >= 0))
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
						else if(((x + 1 < this.width) && ((y + 1) < this.height)) && (y-1 >=0) && (x-1 >= 0))
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
						if((x + 1 < this.width ) && ( x-1 >= 0) ) {
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
						else if((x + 1 < this.width ) && ( x-1 >= 0) )
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
						if((x+1 < this.width) && (y-1 >= 0) && (y+1 < this.height )) {
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
							else if((x+1 < this.width) && (y-1 >= 0) && (y+1 < this.height )) 
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
						if((y+1 < this.height) && (y-1 >= 0)) {
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
						else if((y+1 < this.height) && (y-1 >= 0))
						{
							int[] newPos = this.moveToEmpty(x,  y);
							if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
							{
								this.informations[x][y] = this.informations[x][y-1];
								this.informations[x][y-1] = 0;
								this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
								this.buffer[x][y-1] = AutomatonState.EMPTY;
							}
							else if((y+1 < this.height) && (y-1 >= 0))
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
						if((y-1 >= 0) && (y+1 < this.height)) {
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
						else if((y-1 >= 0) && (y+1 < this.height))
						{
							int[] newPos = this.moveToEmpty(x,  y);
							if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
							{
								this.informations[x][y] = this.informations[x][y+1];
								this.informations[x][y+1] = 0;
								this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
								this.buffer[x][y+1] = AutomatonState.EMPTY;
							}
							else if((y-1 >= 0) && (y+1 < this.height))
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
			}
			else if(this.nbNeighborsMoore(x, y, AutomatonState.AGENT_PREDATOR)>=1)
			{
				this.buffer[x][y] = AutomatonState.AGENT_PREY_FLEEING;	
			}
			else if(this.nbNeighborsMoore(x, y, AutomatonState.FOREST_GRASS)>=1)
			{
				int[] newPos = this.moveToEmpty(x, y);
				this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY;
				this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;

			}
			else 
			{
				int[] newPos = this.moveToEmpty(x, y);
				this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREY;
				this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
			}
			break;
		case AGENT_PREDATOR:
			// TODO: Si une proie est présente dans son voisinage --> poursuite
			//TEST : Poursuite avec posNeighborAgent
			this.informations[x][y]++;
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
				this.buffer[newPos[0]][newPos[1]] = AutomatonState.AGENT_PREDATOR;
				this.informations[newPos[0]][newPos[1]] = this.informations[x][y];
				this.informations[x][y] = 0;
				this.buffer[x][y] = AutomatonState.EMPTY;
			}
			break;
		case AGENT_PREDATOR_HUNTING :
			this.informations[x][y]++;
			break;
		case AGENT_PREY_FLEEING : 
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
				if(cpt.size() > 1)
				{
					switch(cpt.get(0))//pos du premier pred qu'on prend (même s'il y en a plusieurs un seul se met en chasse)
					{
					case 0 : //prédateur au sud ouest x-1 y-1
						//cas favori : fuire au nord est x+1 y+1:
						if(((x + 1 < this.width) && ((y + 1) < this.height)) && (y-1 >=0) && (x-1 >= 0))
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
						else if(((x + 1 < this.width) && ((y + 1) < this.height)) && (y-1 >=0) && (x-1 >= 0))
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
						if((x + 1 < this.width ) && ( x-1 >= 0) ) {
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
						else if((x + 1 < this.width ) && ( x-1 >= 0) )
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
						if((x+1 < this.width) && (y-1 >= 0) && (y+1 < this.height )) {
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
						else if((x+1 < this.width) && (y-1 >= 0) && (y+1 < this.height ))
						{
							int[] newPos = this.moveToEmpty(x,  y);
							if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
							{
								this.informations[x][y] = this.informations[x-1][y];
								this.informations[x-1][y] = 0;
								this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
								this.buffer[x-1][y] = AutomatonState.EMPTY;
							}
							else if((x+1 < this.width) && (y-1 >= 0) && (y+1 < this.height )) 
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
						if((y+1 < this.height) && (y-1 >= 0)) {
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
						else if((y+1 < this.height) && (y-1 >= 0))
						{
							int[] newPos = this.moveToEmpty(x,  y);
							if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
							{
								this.informations[x][y] = this.informations[x][y-1];
								this.informations[x][y-1] = 0;
								this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
								this.buffer[x][y-1] = AutomatonState.EMPTY;
							}
							else if((y+1 < this.height) && (y-1 >= 0))
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
						if((y-1 >= 0) && (y+1 < this.height)) {
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
						else if((y-1 >= 0) && (y+1 < this.height))
						{
							int[] newPos = this.moveToEmpty(x,  y);
							if(newPos[0]==x && newPos[1]==y) //cas ou la proie est entourée et pourchassée = RIP (elle se fait rattraper)
							{
								this.informations[x][y] = this.informations[x][y+1];
								this.informations[x][y+1] = 0;
								this.buffer[x][y] = AutomatonState.AGENT_PREDATOR;
								this.buffer[x][y+1] = AutomatonState.EMPTY;
							}
							else if((y-1 >= 0) && (y+1 < this.height))
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
					if(this.buffer[x-1][y-1]==AutomatonState.EMPTY || this.buffer[x-1][y-1]==AutomatonState.FOREST_GRASS)
					{
						returnValue[0]= x-1; returnValue[1]=y-1;
					}
				}
				break;	
			case 1 : //x-1 y
				if(!(x-1 < 0)) {
					if((this.buffer[x-1][y]==AutomatonState.EMPTY || this.buffer[x-1][y]==AutomatonState.FOREST_GRASS) && !(x-1 < 0))
					{
						returnValue[0]= x-1; returnValue[1]=y;
					}
				}
				break;
			case 2 : //x-1 y+1
				if((x-1 >= 0) && (y+1 < this.height)) {
					if((this.buffer[x-1][y+1]==AutomatonState.EMPTY || this.buffer[x-1][y+1]==AutomatonState.FOREST_GRASS)  && (x-1 >= 0) && (y+1 < this.height))
					{
						returnValue[0]= x-1; returnValue[1]=y+1;
					}
				}
				break;
			case 3 : //x y-1
				if(!(y-1 < 0)) {
					if(this.buffer[x][y-1]==AutomatonState.EMPTY || this.buffer[x][y-1]==AutomatonState.FOREST_GRASS)
					{
						returnValue[0]= x; returnValue[1]=y-1;
					}
				}
				break;
			case 4 : //x y+1
				if(!(y+1 >= this.height)) {
					if(this.buffer[x][y+1]==AutomatonState.EMPTY || this.buffer[x][y+1]==AutomatonState.FOREST_GRASS)
					{
						returnValue[0]= x; returnValue[1]=y+1;
					}
				}
				break;
			case 5 : //x+1 y-1
				if(!(x+1 >= this.height || y-1 < 0)) {
					if(this.buffer[x+1][y-1]==AutomatonState.EMPTY || this.buffer[x+1][y-1]==AutomatonState.FOREST_GRASS)
					{
						returnValue[0]= x+1; returnValue[1]=y-1;
					}
				}
				break;
			case 6 : //x+1 y
				if(!(x+1 >= this.height)) {
					if(this.buffer[x+1][y]==AutomatonState.EMPTY || this.buffer[x+1][y]==AutomatonState.FOREST_GRASS)
					{
						returnValue[0]= x+1; returnValue[1]=y;
					}
				}
				break;
			case 7 : //x+1 y+1
				if(!(x+1 >= this.width || y+1 >= this.height)) {
					if(this.buffer[x+1][y+1]==AutomatonState.EMPTY || this.buffer[x+1][y+1]==AutomatonState.FOREST_GRASS)
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
					if(i >= width || i < 0 || j >= height || j < 0)
					{
						continue;
					}
					if (this.buffer[i][j] == state)
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
