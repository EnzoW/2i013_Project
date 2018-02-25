package etu.upmc.project.datatransmission;

import java.util.Observable;
import java.util.Observer;

import etu.upmc.project.World;

public class EventsManager extends Observable implements Observer 
{
	private int[][][] displayableBuffer;
	private int[][] statesBuffer;
	
	@Override
	public void update(Observable o, Object arg) 
	{
		if (!(o instanceof World) || !(arg instanceof Event))
		{
			throw new IllegalArgumentException(this.getClass().getName() + " : only an instance of the class \"World\" can be observable by " 
					+ this.getClass().getSimpleName() + ".");
		}

		this.displayableBuffer =  DataTranslation.translateToDisplayable(((World) o).getBuffer());
		this.statesBuffer = DataTranslation.translateToStates(((World) o).getBuffer());
		this.setChanged();
		this.notifyObservers(arg);
	}
	
	public int[][][] getDisplaybleBuffer()
	{
		return this.displayableBuffer;
	}
	
	public int[][] getStatesBuffer()
	{
		return this.statesBuffer;
	}
}
