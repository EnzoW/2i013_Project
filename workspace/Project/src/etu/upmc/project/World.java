package etu.upmc.project;

import java.util.ArrayList;
import java.util.Observable;

import etu.upmc.project.cellularautomaton.Agent;
import etu.upmc.project.cellularautomaton.AutomatonState;
import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.datatransmission.Event;

public class World extends Observable 
{
	
	private static int delay = 100;
	
	private int width;
	private int height;
	private int randomX[];
	private int randomY[];
	private AutomatonState[][] buffer;
	private ArrayList<CellularAutomaton> automatons;
	
	public World(int width, int height) 
	{
		this.width = width;
		this.height = height;
		this.randomX = new int[width];
		this.randomY = new int[height];
		this.buffer = new AutomatonState[width][height];
		this.automatons = new ArrayList<>();
		
		this.automatons.add(new Agent(width, height, this.buffer));
		this.automatons.add(new Forest(width, height, this.buffer));
	}
	
	public void init()
	{
		for (int x = 0; x < this.width; x++)
		{
			for (int y = 0; y < this.height; y++)
			{
				this.buffer[x][y] = AutomatonState.EMPTY;
			}
		}
		
		for (CellularAutomaton cellularAutomaton : this.automatons)
		{
			cellularAutomaton.init();
		}
		
		for (int i = 0; i < this.width; i++)
		{
			this.randomX[i] = i;
		}
		
		for (int i = 0; i < this.height; i++)
		{
			this.randomY[i] = i;
		}
		
		this.setChanged();
		this.notifyObservers(Event.INIT);
	}
	
	public void run()
	{
		for (;;)
		{
			if (Math.random() > 0.5d)
			{
				this.shuffle(this.randomX);
				for (int x : this.randomX)
				{
					this.shuffle(this.randomY);
					for (int y : this.randomY)
					{
						this.step(x, y);
					}
				}
			}
			else
			{
				this.shuffle(this.randomY);
				for (int y : this.randomY)
				{
					this.shuffle(this.randomX);
					for (int x : this.randomX)
					{
						this.step(x, y);
					}
				}
			}
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.setChanged();
			this.notifyObservers(Event.UPDATE);
		}
	}
	
	private void step(final int x, final int y)
	{
		for (CellularAutomaton cellularAutomaton : this.automatons)
		{
			cellularAutomaton.step(x, y);
		}
	}
	
	private void shuffle(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int r = (int) (i + Math.random() * (array.length - i));
			
			int tmp = array[r];
			array[r] = array[i];
			array[i] = tmp;
		}
	}
	
	public AutomatonState[][] getBuffer()
	{
		return this.buffer;
	}
}
