package etu.upmc.project;

import etu.upmc.project.config.Config;
import etu.upmc.project.graphics.Displayer3D;

public class Application {

	/* ****************************************************************
	 * 	Application Entry Point
	 * ****************************************************************/
	
	public static void main(String[] args) { //throws ParseException {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Config.loadConfig();
		World world = new World(300, 300);

		Displayer3D displayer3D = new Displayer3D();
		world.addObserver(displayer3D);

		world.init();
		world.run();
	}
}
