/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import etu.upmc.project.log.Log;

public class Config {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	private static final String DIR_PATH 				= "config/";
	private static final String DEFAULT_CFG_FILE_NAME 	= "default.xml";
	private static final String CFG_FILE_DESCRIPTION	= "Project - 2i013";

	/* ****************************************************************
	 * 	Private context
	 * ****************************************************************/

	private static Properties properties;
	private static Config instance;
	private static boolean loaded;

	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	private Config() 
	{
		properties = new Properties();
		loaded = false;
	}

	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/

	public static double getProperty(Constants constant)
	{
		checkInstance();
		double returnValue = -1;

		if (!loaded)
		{
			Log.error("Configuration file not loaded.");
		}
		else 
		{
			try 
			{
				returnValue = Double.parseDouble(properties.getProperty(constant.name().split("'")[0]));
			}
			catch (NullPointerException e)
			{
				Log.warning("Value \"" + constant.name() + "\" not found in configuration file.");
			}
		}

		return returnValue;
	}

	
	public static double[] getProperties(Constants constant)
	{
		checkInstance();
		double[] returnValue = null;

		if (!loaded)
		{
			Log.error("Configuration file not loaded.");
		}
		else 
		{
			String[] prop = properties.getProperty(constant.name()).split(",");
			returnValue = new double[prop.length];
			try 
			{
				for (int i = 0; i < prop.length; i++)
				{
					returnValue[i] = Double.parseDouble(prop[i]);
				}
			}
			catch (NullPointerException e)
			{
				Log.error("Value \"" + constant.name() + "\" not found in configuration file.");
			}
		}

		return returnValue;
	}

	/**
	 * Load configuration file.
	 * 
	 * @param filename
	 * 		The relative path from the project root directory.
	 */
	public static void loadConfig(String filename)
	{
		checkInstance();

		if (loaded)
		{
			Log.warning("Configuration already loaded.");
		}
		else
		{
			try {
				FileInputStream fis = new FileInputStream(filename);
				properties.loadFromXML(fis);
				fis.close();
				loaded = true;
				Log.info("Configuration file successfully loaded.");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				Log.fatal("Cannot load default configuration file.");
				System.exit(-1);
			}
		}
	}

	/**
	 * Load the default configuration file.
	 */
	public static void loadConfig()
	{
		loadConfig(DIR_PATH + DEFAULT_CFG_FILE_NAME);
	}

	/**
	 * Save the configuration file as XML under project directory.
	 * 
	 * @param properties
	 * 			The configuration to store.
	 * @param filename
	 * 			The name of the file. It will be saved under config/ directory.
	 * 
	 * @see Properties 
	 */
	public static void saveConfig(Properties properties, String filename)
	{
		checkInstance();
		try {
			FileOutputStream fos = new FileOutputStream(DIR_PATH + filename);
			properties.storeToXML(fos, CFG_FILE_DESCRIPTION);
			Log.info("Succesfully wrote configuration file.");
		} catch (IOException e) {
			e.printStackTrace();
			Log.error("Unable to write file \"" + filename + "\".");
		}
	}


	/**
	 * Save the configuration file as XML. The file will be stored in the default config directory 
	 * with the current timestamp as filename.
	 * 
	 * @param properties
	 * 			The configutation to store.
	 * 
	 * @see Properties
	0 */
	public static void saveConfig(Properties properties)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		saveConfig(properties, DIR_PATH + timeStamp + ".xml");
	}

	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/

	private static void checkInstance()
	{
		if (instance == null)
		{
			instance = new Config();
		}
	}

}
