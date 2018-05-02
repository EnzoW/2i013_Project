/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.log;

public class Log {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/
	
	private static LogLevel LOG_LEVEL 	= LogLevel.DEBUG;
	
	private static final String DEBUG 	= (char)27 + "[34m[  DEBUG  ] ";
	private static final String INFO 	= (char)27 + "[35m[  INFO   ] ";
	private static final String WARNING = (char)27 + "[33m[ WARNING ] ";
	private static final String ERROR 	= (char)27 + "[91m[  ERROR  ] ";
	private static final String FATAL 	= (char)27 + "[31m[  FATAL  ] ";
	private static final String END 	= (char)27 + "[0m\n";
	
	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/
	
	public static void setLogLevel(LogLevel logLevel)
	{
		Log.LOG_LEVEL = logLevel;
	}
	
	public static void debug(String format, Object... args)
	{
		if (LOG_LEVEL.compareTo(LogLevel.DEBUG) <= 0)
		{
			System.out.printf(DEBUG + format + END, args);
		}
	}
	
	public static void info(String format, Object... args)
	{
		if (LOG_LEVEL.compareTo(LogLevel.INFO) <= 0)
		{
			System.out.printf(INFO + format + END, args);
		}
	}
	
	public static void warning(String format, Object... args)
	{
		if (LOG_LEVEL.compareTo(LogLevel.WARNING) <= 0)
		{
			System.out.printf(WARNING + format + END, args);
		}
	}
	
	public static void error(String format, Object... args)
	{
		if (LOG_LEVEL.compareTo(LogLevel.ERROR) <= 0)
		{
			System.out.printf(ERROR + format + END, args);
		}
	}
	
	public static void fatal(String format, Object... args)
	{
		if (LOG_LEVEL.compareTo(LogLevel.FATAL) <= 0)
		{
			System.out.printf(FATAL + format + END, args);
		}
	}
}