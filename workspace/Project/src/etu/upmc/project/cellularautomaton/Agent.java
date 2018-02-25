/**
 * 
 */
package etu.upmc.project.cellularautomaton;

/**
 * @author Quentin S.
 * @date 24/02
 */
public class Agent extends CellularAutomaton 
{
	private static double density = 0.05;
	
	/**
	 * @param width
	 * @param height
	 * @param buffer
	 */
	public Agent(int width, int height, AutomatonState[][] buffer) 
	{
		super(width, height, buffer);
	}

	@Override
	public void init() 
	{
		for ( int x = 0 ; x < this.width ; x++ )
		{
			for ( int y = 0 ; y < this.height ; y++ )
			{
				if (density >= Math.random() && this.buffer[x][y] == AutomatonState.EMPTY)
				{
					this.buffer[x][y] = Math.random() > 0.5 ? AutomatonState.AGENT_PREDATOR : AutomatonState.AGENT_PREY;
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
		case AGENT_PREY:
			// TODO: Si un prédateur est présent dans son voisinage --> fuite
			this.buffer[x][y] = AutomatonState.AGENT_PREY; //(nbNeighborsMoore(x, y, AutomatonState.AGENT_PREDATOR) > 0) ? AutomatonState.EMPTY : AutomatonState.AGENT_PREY;
			break;
		case AGENT_PREDATOR:
			// TODO: Si une proie est présente dans son voisinage --> poursuite
			this.buffer[x][y] =  AutomatonState.AGENT_PREDATOR;
			break;
		default:
			break;
		}
	}

}
