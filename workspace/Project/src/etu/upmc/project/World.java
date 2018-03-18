package etu.upmc.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Observable;

import etu.upmc.project.cellularautomaton.Agent;
import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.events.EventInit;
import etu.upmc.project.events.EventUpdate;
import etu.upmc.project.tools.Tools;

public class World extends Observable 
{
	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	private static final int DELAY 						= 100;
	private static final double SCALING					= 0.2;
	private static final double ALTITUDE_RATIO 			= 0.42;
	private static final String FILENAME 				= "landscape_paris-200.png";
	private static final String STATS_FILE_PREFIX 		= "stats/project_";

	/* ****************************************************************
	 * 	Private Context
	 * ****************************************************************/

	private int width;
	private int height;
	private int randomX[];
	private int randomY[];
	private static boolean running;
	private int[][] buffer;
	private int[][] informations;
	private boolean[][] agentsUpdated;
	private double[][] elevation;
	private ArrayList<CellularAutomaton> automatons;
	private static StringBuilder stringBuilder;
	private static boolean stats;
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	public World() 
	{
		running = true;
		World.stats = false;
	}

	public World(boolean stats)
	{
		this();
		World.stringBuilder = new StringBuilder();
		World.stringBuilder.append("# Format : nbPreys, nbPredators, nbTrees, nbTreesBurning, nbGrasses\n");
		World.stats = true;
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
		/* Statistics */
		int iteration = 0;
		int nbPreys = 0;
		int nbPredators = 0;
		int nbTrees = 0;
		int nbTreesBurning = 0;
		int nbGrasses = 0;

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
		while (running)
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

			if (World.stats)
			{
				World.stringBuilder.append(iteration + "," + nbPreys + "," + nbPredators + "," + nbTrees + "," + nbTreesBurning + "," + nbGrasses + "\n");
				iteration++;
				nbPreys 		= 0;
				nbPredators 	= 0;
				nbTrees	 		= 0;
				nbTreesBurning 	= 0;
				nbGrasses 		= 0;
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

	public static void stop()
	{
		
		if (World.stats) {
			running = false;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
			File file = new File(STATS_FILE_PREFIX + simpleDateFormat.format(timestamp) + ".csv");
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(file);
				fileWriter.write(stringBuilder.toString());
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		System.exit(0);
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
