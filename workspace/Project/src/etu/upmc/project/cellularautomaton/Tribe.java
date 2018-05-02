/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.cellularautomaton;

import java.util.ArrayList;

public class Tribe {

	private ArrayList<int[]> humans;
	private int[] tribe_main_pos;
	private int ressources;

	public Tribe(int x, int y)
	{
		tribe_main_pos = new int[] {x,y};
		humans = new ArrayList<int[]>();
		ressources = 0;
	}

	
	public void changePosOfHuman(int index, int[] newPos)
	{
		if (index < this.humans.size())
		{
			this.humans.remove(index);
			this.humans.add(index, newPos);
		}
	}
	public void addHuman(int x, int y)
	{
		this.humans.add(new int[] {x,y});
	}

	public ArrayList<int[]> getHumans()
	{
		return this.humans;
	}

	/**
	 * @return int[2] tribe_main_pos
	 */
	public int[] getTribe_main_pos() {
		return tribe_main_pos;
	}
	
	public int getRessources()
	{
		return this.ressources;
	}
	
	public void addRessources(int a)
	{
		this.ressources+=a;
	}
	
	public void removeRessources(int a)
	{
		this.ressources-=a;
	}
	/**
	 * @param x
	 * @param y
	 */
	public void removeAtPos(int x, int y) 
	{
		for(int i = 0; i < this.humans.size(); i++)
		{
			if(this.humans.get(i)[0] == x && this.humans.get(i)[1] == y)
			{
				this.humans.remove(i);
			}
		}
	}
	
	public int findHuman(int[] pos)
	{
		int index = 0;
		for(int i = 0; i < this.humans.size(); i++)
		{
			if(this.humans.get(i)[0] == pos[0] && pos[1] == this.humans.get(i)[1])
			{
				index = i;
			}
		}
		return index;
	}


}
