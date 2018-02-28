package etu.upmc.project;

import java.util.ArrayList;
import java.util.Observable;

import etu.upmc.project.cellularautomaton.Agent;
import etu.upmc.project.cellularautomaton.AutomatonState;
import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.events.DataTranslation;
import etu.upmc.project.events.EventInit;
import etu.upmc.project.events.EventUpdate;
import etu.upmc.project.tools.Tools;

public class World extends Observable 
{
	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/
	
	private static final int DELAY = 100;
	private static final String FILENAME = "landscape_paris-200.png";
	private static final double SCALING	= 0.2;
	private static final double ALTITUDE_RATIO = 0.42;
	
	/* ****************************************************************
	 * 	Private Context
	 * ****************************************************************/
	
	private int width;
	private int height;
	private int randomX[];
	private int randomY[];
	private AutomatonState[][] buffer;
	private int[][] informations;
	private double[][] elevation;
	private ArrayList<CellularAutomaton> automatons;
	
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/
	
	public World() 
	{
		
	}
	
	/* ****************************************************************
	 * 	Public Methods
	 * ****************************************************************/
	
	public void init()
	{
		this.elevation = Tools.load(FILENAME, SCALING, ALTITUDE_RATIO);
		this.width = this.elevation[0].length;
		this.height = this.elevation.length;
		this.randomX = new int[width];
		this.randomY = new int[height];
		this.buffer = new AutomatonState[width][height];
		this.informations = new int[width][height];
		this.automatons = new ArrayList<>();
		
		this.automatons.add(new Agent(width, height, this.buffer, this.informations, this.elevation));
		this.automatons.add(new Forest(width, height, this.buffer, this.informations, this.elevation));
		
		for (int x = 0; x < this.width; x++)
		{
			for (int y = 0; y < this.height; y++)
			{
				this.buffer[x][y] = AutomatonState.EMPTY;
				this.informations[x][y] = 0;
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
		
		EventInit eventInit = new EventInit() {
			
			@Override
			public int getWidth() {
				return World.this.width;
			}
			
			@Override
			public int getHeight() {
				return World.this.height;
			}
			
			@Override
			public double[][] getElevation() {
				return World.this.elevation;
			}

		};
		
		this.setChanged();
		this.notifyObservers(eventInit);
	}
	
	public void run()
	{
		
		for (;;)
		{
			if (Math.random() > 0.5d)
			{
				Tools.shuffle(this.randomX);
				for (int x : this.randomX)
				{
					Tools.shuffle(this.randomY);
					for (int y : this.randomY)
					{
						this.step(x, y);
					}
				}
			}
			else
			{
				Tools.shuffle(this.randomY);
				for (int y : this.randomY)
				{
					Tools.shuffle(this.randomX);
					for (int x : this.randomX)
					{
						this.step(x, y);
					}
				}
			}
			
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			EventUpdate eventUpdate = new EventUpdate() {

				@Override
				public int[][] getBuffer() {
					return DataTranslation.translateToStates(World.this.buffer);
				}
				
			};
			
			this.setChanged();
			this.notifyObservers(eventUpdate);
		}
	}

	/* ****************************************************************
	 * 	Private Methods
	 * ****************************************************************/
	
	private void step(final int x, final int y)
	{
		for (CellularAutomaton cellularAutomaton : this.automatons)
		{
			cellularAutomaton.step(x, y);
		}
	}
}
