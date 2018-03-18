package etu.upmc.project.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import etu.upmc.project.World;
import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.cellularautomaton.Forest;
import etu.upmc.project.events.Event;
import etu.upmc.project.events.EventInit;
import etu.upmc.project.events.EventUpdate;
import etu.upmc.project.tools.Tools;

public class Displayer2D extends JPanel implements Observer, Runnable
{
	private static final long serialVersionUID = -1797923502232033578L;
	private static final String NAME = "World";
	private static final int REFRESH_DELAY = 0;

	private int width;
	private int height;
	private BufferedImage bufferedImage;
	private double[][] elevation;
	private double minElevation;
	private Object lock;

	public Displayer2D() 
	{
		this.lock = new Object();
	}

	private void init()
	{
		this.bufferedImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		JFrame frame = new JFrame(NAME);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.setVisible(true);

		this.minElevation = 0;

		for (int x = 0; x < this.width ; x++)
		{
			for (int y = 0; y < this.height; y++)
			{
				if (this.elevation[x][y] < this.minElevation)
					this.minElevation = this.elevation[x][y];
			}
		}

		new Thread(this).start();
	}

	public void run() 
	{
		for (;;)
		{
			repaint();
			try {
				Thread.sleep(REFRESH_DELAY);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(this.bufferedImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		if (!(o instanceof World) || !(arg instanceof Event))
		{
			throw new IllegalArgumentException(this.getClass().getName() + " : only an instance of the class \"World\" can be observable by " 
					+ this.getClass().getSimpleName() + ".");
		}

		if (arg instanceof EventInit)
		{
			EventInit event = (EventInit) arg;
			this.width = event.getWidth();
			this.height = event.getHeight();
			this.elevation = event.getElevation();
			this.init();
		}
		else if (arg instanceof EventUpdate)
		{
			int[][] buffer = ((EventUpdate) arg).getBuffer();
			int[][] informations = ((EventUpdate) arg).getInformations();
			int[] colorValues = new int[this.width * this.height];

			int i = 0;

			for (int y = 0; y < buffer[0].length; y++)
			{
				for (int x = 0; x < buffer.length; x++)
				{
					int value = 0xFFFFFFFF;

					if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.FOREST_GRASS))
					{
						value = 0xFFFFFF00;
					}

					if (this.elevation[x][y] < 0)
					{
						int alpha = (int) Tools.map((float) -this.elevation[x][y], 0, (float) -this.minElevation, 127, 255);
						value = alpha << 24 | 0x000080;
					}
					else if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.FOREST_TREE))
					{
						value = 0xFF00FF00;
					}
					else if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.FOREST_TREE_BURNING))
					{
						value = 0xFFFF0000;
					}
					else if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.FOREST_ASHES))
					{
						int gray = (int) Tools.map(informations[x][y], Forest.MIN_GROW_TREE, Forest.ASHES_DISP, 0, 0xFF);
						value = 0xFF << 24 | gray << 16 | gray << 8 | gray;
					}
					else if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.AGENT_PREY))
					{
						value = 0xFF00FFFF;
					}
					else if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.AGENT_PREDATOR))
					{
						value = 0xFFFF00FF;
					}
					else if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.AGENT_PREY_FLEEING))
					{
						value = 0xFF007A7A;
					}
					else if (CellularAutomaton.isInStates(buffer[x][y], CellularAutomaton.AGENT_PREDATOR_HUNTING))
					{
						value = 0xFF8000FF;
					}

					colorValues[i] = value;
					i++;
				}
			}

			synchronized (this.lock) {
				this.bufferedImage.setRGB(0, 0, this.width, this.height, colorValues, 0, this.width);
			}
		}
	}
}
