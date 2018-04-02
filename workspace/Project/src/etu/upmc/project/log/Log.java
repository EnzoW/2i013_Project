package etu.upmc.project.log;

public class Log {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/
	
	private static final LogLevel LOG_LEVEL = LogLevel.DEBUG;
	
	private static final String DEBUG 	= "[  DEBUG  ] ";
	private static final String INFO 	= "[  INFO   ] ";
	private static final String WARNING = "[ WARNING ] ";
	private static final String ERROR 	= "[  ERROR  ] ";
	private static final String FATAL 	= "[  FATAL  ] ";
	
	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/
	
	public static void debug(String log)
	{
		if (LOG_LEVEL.compareTo(LogLevel.DEBUG) <= 0)
		{
			System.out.println(DEBUG + log);
		}
	}
	
	public static void info(String log)
	{
		if (LOG_LEVEL.compareTo(LogLevel.INFO) <= 0)
		{
			System.out.println(INFO + log);
		}
	}
	
	public static void warning(String log)
	{
		if (LOG_LEVEL.compareTo(LogLevel.WARNING) <= 0)
		{
			System.out.println(WARNING + log);
		}
	}
	
	public static void error(String log)
	{
		if (LOG_LEVEL.compareTo(LogLevel.ERROR) <= 0)
		{
			System.out.println(ERROR + log);
		}
	}
	
	public static void fatal(String log)
	{
		if (LOG_LEVEL.compareTo(LogLevel.FATAL) <= 0)
		{
			System.out.println(FATAL + log);
		}
	}
}
