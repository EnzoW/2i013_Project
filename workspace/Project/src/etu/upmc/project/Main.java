package etu.upmc.project;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import etu.upmc.project.graphics.Displayer2D;
import etu.upmc.project.graphics.Displayer3D;

public class Main {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/
	private static final String OPT_NO_HMI = "hmi_disable";
	private static final String OPT_STATS = "stats";
	
	/* ****************************************************************
	 * 	Application Entry Point
	 * ****************************************************************/
	
	public static void main(String[] args) throws ParseException {
		Options options = new Options();
		CommandLineParser parser = new DefaultParser();
		options.addOption(OPT_NO_HMI, false, "Launch the program without HMI.");
		options.addOption(OPT_STATS, false, "Enable statistics and create a csv file in stats/ after execution.");
		CommandLine cmd = parser.parse(options, args);
		World world = new World(200, 200);

		if (!cmd.hasOption(OPT_NO_HMI))
		{
//			Displayer2D displayer2D = new Displayer2D();
//			world.addObserver(displayer2D);
			Displayer3D displayer3D = new Displayer3D();
			world.addObserver(displayer3D);
		}

		world.init();
		world.run();
	}
}
