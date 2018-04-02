package etu.upmc.project.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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
	
	private Properties properties;
	
	/* ****************************************************************
	 * 	Singleton
	 * ****************************************************************/
	
	private static Config instance;
	
	public static Config getInstance()
	{
		if (instance == null)
		{
			instance = new Config();
		}
		
		return instance;
	}
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/
	
	private Config() {
		this.properties = new Properties();
	}
	
	/**
	 * Load configuration file.
	 * 
	 * @param filename
	 * 		The relative path from the project root directory.
	 */
	public void loadConfig(String filename)
	{
		try {
			FileInputStream fis = new FileInputStream(filename);
			this.properties.loadFromXML(fis);
			
			for (Constants constant : Constants.values())
			{
				constant.setValue(this.properties.getProperty(constant.name(), constant.getValue()));
			}
			
			fis.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.err.println("Fatal : cannot load default configuration file. Exit...");
			System.exit(-1);
		}
	}
	
	/**
	 * Load the default configuration file.
	 */
	public void loadConfig()
	{
		this.loadConfig(DIR_PATH + DEFAULT_CFG_FILE_NAME);
	}
	
	/**
	 * Save the configuration file as XML under project directory.
	 * 
	 * @param properties
	 * 			The configuration to store.
	 * @param filename
	 * 			The relative path to the file.
	 * 
	 * @see Properties 
	 */
	public void saveConfig(Properties properties, String filename)
	{
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			properties.storeToXML(fos, CFG_FILE_DESCRIPTION);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error : unable to write file \"" + filename + "\".");
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
	 */
	public void saveConfig(Properties properties)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		this.saveConfig(properties, DIR_PATH + timeStamp + ".xml");
	}
}
