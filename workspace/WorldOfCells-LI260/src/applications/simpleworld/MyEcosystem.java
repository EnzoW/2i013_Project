// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;



import javax.media.opengl.GL2;

import graphics.Landscape;
import worlds.World;

public class MyEcosystem {
    
	public static void main(String[] args) {

		WorldOfTrees myWorld = new WorldOfTrees();
		
		// param�tres:
		// 1: le "monde" (ou sont dŽfinis vos automates cellulaires et agents
		// 2: (ca dŽpend de la mŽthode : gŽnŽration alŽatoire ou chargement d'image)
		// 3: l'amplitude de l'altitude (plus la valeur est ŽlevŽe, plus haute sont les montagnes)
		// 4: la quantitŽ d'eau
		//Landscape myLandscape = new Landscape(myWorld, 128, 128, 0.1, 0.7);
//		Landscape myLandscape = new Landscape(myWorld, "landscape_paris-200.png", 0.2, 0.42);
		
		World world = new World() {
			
			@Override
			public void init(int __dxCA, int __dyCA, double[][] landscape) {
				super.init(__dxCA, __dyCA, landscape);
		    	
		    	// add colors
		    	
		    	for ( int x = 0 ; x < __dxCA ; x++ )
		    		for ( int y = 0 ; y < __dyCA ; y++ )
		    		{
			        	float color[] = new float[3];

			        	float height = (float) this.getCellHeight(x, y);
				    	
				        if ( height >= 0 )
				        {
				        	// snowy mountains
				        	/*
				        	color[0] = height / (float)this.getMaxEverHeight();
							color[1] = height / (float)this.getMaxEverHeight();
							color[2] = height / (float)this.getMaxEverHeight();
							/**/
				        	
							// green mountains
				        	/**/
				        	color[0] = height / ( (float)this.getMaxEverHeight() );
							color[1] = 0.9f + 0.1f * height / ( (float)this.getMaxEverHeight() );
							color[2] = height / ( (float)this.getMaxEverHeight() );
							/**/
				        }
				        else
				        {
				        	// water
							color[0] = -height;
							color[1] = -height;
							color[2] = 1.f;
				        }
				        this.cellsColorValues.setCellState(x, y, color);
		    		}
		    }
			
			@Override
			protected void stepCellularAutomata() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void stepAgents() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCellValue(int x, int y, int state) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void initCellularAutomata(int __dxCA, int __dyCA, double[][] landscape) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getCellValue(int x, int y) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void displayObjectAt(World _myWorld, GL2 gl, int cellState, int x, int y, double height, float offset,
					float stepX, float stepY, float lenX, float lenY, float normalizeHeight) {
				// TODO Auto-generated method stub
				
			}
		};
		Landscape myLandscape = new Landscape(myWorld, "water.png", 0.2, 0.4);
		
		Landscape.run(myLandscape);
    }

}
