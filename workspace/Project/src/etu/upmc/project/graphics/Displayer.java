package etu.upmc.project.graphics;

import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import etu.upmc.project.datatransmission.Event;
import etu.upmc.project.datatransmission.EventsManager;

public class Displayer extends BufferedImage implements Observer
{
	public Displayer(int width, int height) 
	{
		super(width, height, TYPE_INT_ARGB);
	}

	private void init()
	{
		ImageFrame.makeFrame("World", this, this.getWidth(), this.getHeight());
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		if (!(o instanceof EventsManager) || !(arg instanceof Event))
		{
			throw new IllegalArgumentException(this.getClass().getName() + " : only an instance of the class \"EventsManager\" can be observable by " 
					+ this.getClass().getSimpleName() + ".");
		}

		Event event = (Event) arg;

		if (event == Event.INIT)
		{
			this.init();
		}
		else if (event == Event.UPDATE)
		{
			int[][][] displayableBuffer = ((EventsManager) o).getDisplaybleBuffer();

			for (int x = 0; x < displayableBuffer.length; x++)
			{
				for (int y = 0; y < displayableBuffer[x].length; y++)
				{
					int colorValues;
					colorValues =  displayableBuffer[x][y][0]; // alpha set non transparent
					colorValues += displayableBuffer[x][y][1] * 0x10000; // red
					colorValues += displayableBuffer[x][y][2] * 256; // green
					colorValues += displayableBuffer[x][y][3]; // blue
					this.setRGB(x, y, colorValues);
				}
			}
		}
	}
}
