package etu.upmc.project;

import etu.upmc.project.graphics.Displayer3D;

public class Main {
	
	public static void main(String[] args) {
		World world = new World();
		Displayer3D displayer = new Displayer3D();
		
		world.addObserver(displayer);
		
		world.init();
		world.run();
	}
}
