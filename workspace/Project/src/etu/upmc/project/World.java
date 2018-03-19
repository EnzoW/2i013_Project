package etu.upmc.project;

import java.util.ArrayList;
import java.util.Observable;

import etu.upmc.project.cellularautomaton.Agent;
import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.events.EventInit;
import etu.upmc.project.events.EventUpdate;
import etu.upmc.project.tools.HeightMapGenerator;
import etu.upmc.project.tools.Tools;

public class World extends Observable 
{
	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	private static final int DELAY 						= 10;

	/* ****************************************************************
	 * 	Private Context
	 * ****************************************************************/

	private int width;
	private int height;
	private int randomX[];
	private int randomY[];
	private int[][] buffer;
	private int[][] informations;
	private boolean[][] agentsUpdated;
	private double[][] elevation;
	private ArrayList<CellularAutomaton> automatons;
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public World(int width, int height) 
	{
		this.width = width;
		this.height = height;
	}

	/* ****************************************************************
	 * 	Public Methods
	 * ****************************************************************/

	public void init()
	{
		this.elevation = HeightMapGenerator.GenerateAltitude(this.width, this.height);
		
		this.elevation = Tools.scaleAndCenter(this.elevation, 0.4, 0.5);
		this.elevation = Tools.smoothLandscape(this.elevation);
		
		this.randomX = new int[width];
		this.randomY = new int[height];
		this.buffer = new int[width][height];
		this.informations = new int[width][height];
		this.agentsUpdated = new boolean[width][height];
		this.automatons = new ArrayList<>();

		this.automatons.add(new Agent(width, height, this.buffer, this.informations, this.elevation, this.agentsUpdated));
		this.automatons.add(new Forest(width, height, this.buffer, this.informations, this.elevation));

		for (int x = 0; x < this.width; x++)
		{
			this.randomX[x] = x;
			for (int y = 0; y < this.height; y++)
			{
				this.buffer[x][y] = CellularAutomaton.EMPTY;
				this.informations[x][y] = 0;
				this.randomY[y] = y;
				this.agentsUpdated[x][y] = false;
			}
		}

		for (CellularAutomaton cellularAutomaton : this.automatons)
		{
			cellularAutomaton.init();
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
		EventUpdate eventUpdate = new EventUpdate() {

			@Override
			public int[][] getBuffer() {
				return World.this.buffer;
			}

			@Override
			public int[][] getInformations() {
				return World.this.informations;
			}

		};
		
		/* Main automaton loop */
		while (true)
		{
			this.setChanged();
			this.notifyObservers(eventUpdate);

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
			
			for (int x = 0; x < this.width; x++)
			{
				for (int y = 0; y < this.height; y++)
				{
					this.agentsUpdated[x][y] = false;
				}
			}

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
