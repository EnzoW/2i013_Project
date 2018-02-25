package etu.upmc.project;

import etu.upmc.project.datatransmission.EventsManager;
import etu.upmc.project.graphics.Landscape;

public class Main {
	
	public static int width = 200;
	public static int height = 200;
	
	public static void main(String[] args) {
		World world = new World(width, height);
		EventsManager eventsManager = new EventsManager();
//		Displayer displayer = new Displayer(width, height);
		Landscape landscape = new Landscape(width, height);
		
		world.addObserver(eventsManager);
//		eventsManager.addObserver(displayer);
		eventsManager.addObserver(landscape);
		
		world.init();
		world.run();
	}
}
