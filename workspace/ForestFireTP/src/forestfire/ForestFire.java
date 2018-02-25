package forestfire;
import forestfire.tools.ImageBuffer;
import forestfire.tools.ImageFrame;

public class ForestFire {

	private static final int dx = 750;
	private static final int dy = 750;

	public static void main(String[] args) {

		int[][] forest = new int[dx][dy];
		int[] randomY = new int[dy];
		int[] randomX = new int[dx];
		
		int delai = 0; //100;
		double densite = 0.5; //0.55; // seuil de percolation ˆ 0.55

		ImageBuffer image = new ImageBuffer(dx,dy);
		ImageFrame.makeFrame("Forest fire", image, delai, dx, dy);

		/* Initialisation */
		for ( int x = 0 ; x != dx ; x++ )
			for ( int y = 0 ; y != dy ; y++ )
				if ( densite >= Math.random() )
					forest[(int)x][(int)y]=1; // tree
		
		for (int i = 0; i < randomY.length; i++)
			randomY[i] = i;
		
		for (int i = 0; i < randomX.length; i++)
			randomX[i] = i;

		
		forest[dx/2][dy/2] = 2; // burning tree

		/* Run */
		for (;;)
		{
			/* Affichage de l'état courant */
			image.updateForest(forest);

			if (Math.random() > 0.5d) {
				/* Mise à jour de l'automate */
				shuffle(randomX);
				for (int x : randomX) {
					shuffle(randomY);
					for (int y : randomY) {
						switch (forest[x][y]) {
						case 0:
							break;
						case 1:
							forest[x][y] = (nbNeighborsMoore(forest, x, y, 2) > 0) ? 2 : 1;
							break;
						default:
						case 2:
							forest[x][y]++;
							break;
						case 10:
							forest[x][y] = 0;
							break;
						}
					}
				} 
			}
			else
			{
				shuffle(randomY);
				for (int y : randomY)
				{
					shuffle(randomX);
					for (int x : randomX)
					{
						switch (forest[x][y])
						{
						case 0:
							break;
						case 1:
							forest[x][y] = (nbNeighborsMoore(forest, x, y, 2) > 0) ? 2 : 1;
							break;
						default:
						case 2:
							forest[x][y]++;
							break;
						case 10:
							forest[x][y] = 0;
							break;					
						}
					}
				}
			}
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static int nbNeighborsVN(int[][] tableauCourant, final int x, final int y, final int i)
	{
		int nbNeighbors = 0;
		int indexY = y - 1 >= 0 ? (y - 1) % ForestFire.dy : ForestFire.dy - 1;
		int indexX = x - 1 >= 0 ? (x - 1) % ForestFire.dx : ForestFire.dx - 1;

		nbNeighbors += tableauCourant[x][indexY] == i ? 1 : 0;
		indexY = y + 1 >= 0 ? (y + 1) % ForestFire.dy : ForestFire.dy - 1;
		nbNeighbors += tableauCourant[x][indexY] == i ? 1 : 0;
		nbNeighbors += tableauCourant[indexX][y] == i ? 1 : 0;
		indexX = x + 1 >= 0 ? (x + 1) % ForestFire.dx : ForestFire.dx - 1;
		nbNeighbors += tableauCourant[indexX][y] == i ? 1 : 0;

		return nbNeighbors;
	}
	
	private static int nbNeighborsMoore(int[][] currentArray, final int x, final int y, final int state)
	{
		int nbNeighbors = 0;
		
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				if (!(i == x && j == y))
				{
					int indexX = i >= 0 ? i % ForestFire.dx : ForestFire.dx - 1;
					int indexY = j >= 0 ? j % ForestFire.dy : ForestFire.dy - 1;
					nbNeighbors += currentArray[indexX][indexY] == state ? 1 : 0;
				}
			}
		}
		return nbNeighbors;
	}	
	
	private static void shuffle(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int r = (int) (i + Math.random() * (array.length - i));
			
			int tmp = array[r];
			array[r] = array[i];
			array[i] = tmp;
		}
	}

}
