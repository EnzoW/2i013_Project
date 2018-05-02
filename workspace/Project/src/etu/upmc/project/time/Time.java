/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.time;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import etu.upmc.project.log.Log;

public class Time
{

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final int 	HOURS_INDEX 		= 0;
	public static final int 	MINS_INDEX 			= 1;
	public static final int 	TIME_DAY_TRANSITION = 60;
	private static final String DAYS_FILE 			= "config/days_file.csv";
	private static final int 	NB_COLUMNS_FILE 	= 3;
	
	/* ****************************************************************
	 * 	Private context
	 * ****************************************************************/

	private long 	time;
	private double 	speed;
	private HashMap<String, String[]> sunHourly;

	/* ****************************************************************
	 * 	Singleton
	 * ****************************************************************/

	private static Time instance;

	public static Time getInstance()
	{
		if (instance == null)
		{
			instance = new Time();
		}
		
		return instance;
	}
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/

	private Time()
	{
		this.sunHourly = new HashMap<>();
		this.loadDaysFile();
		
		this.time = Calendar.getInstance().getTimeInMillis();
		this.speed = 1;
		TimerTask task = new TimerTask()
		{

			@Override
			public void run()
			{
				Time.this.time += 100 * Time.this.speed;
			}
		};
		new Timer().scheduleAtFixedRate(task, 0, 100); /* Every 100 milliseconds */ 
	}

	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/

	public int getSunrise()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		String key = simpleDateFormat.format(new Date(this.time));
		return Integer.parseInt(this.sunHourly.get(key)[0]);
	}
	
	public int getNightfall()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		String key = simpleDateFormat.format(new Date(this.time));
		
		return Integer.parseInt(this.sunHourly.get(key)[1]);
	}

	public int getTimeOfDay()
	{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(this.time));
		int time = c.get(Calendar.HOUR_OF_DAY);
		time *= 100;
		time += c.get(Calendar.MINUTE);
		
		return time;
	}
	
	public void incrementSpeed(float i)
	{
		this.speed += i;
	}

	public void decrementSpeed(float i)
	{
		if (this.speed - i >= 0)
		{
			this.speed -= i;
		}
	}

	public double getSpeed()
	{
		return this.speed;
	}
	
	public boolean isDaytime()
	{
		int time = this.getTimeOfDay();
		
		return time < this.getNightfall() && time > this.getSunrise();
	}

	public Calendar getCurrentDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(this.time);

		return calendar;
	}

	public Seasons getSeason()
	{
		MonthDay now = MonthDay.now(Clock.offset(Clock.systemDefaultZone(), Duration.ofMillis(this.time - Calendar.getInstance().getTimeInMillis())));
		Seasons season;

		if (now.isAfter(Seasons.WINTER_BEGINNING) && now.isBefore(Seasons.SPRING_BEGINNING))
		{
			season = Seasons.WINTER;
		}
		else if (now.isAfter(Seasons.SPRING_BEGINNING) && now.isBefore(Seasons.SUMMER_BEGINNING))
		{
			season = Seasons.SPRING;
		}
		else if (now.isAfter(Seasons.SUMMER_BEGINNING) && now.isBefore(Seasons.FALL_BEGINNING))
		{
			season = Seasons.SUMMER;
		}
		else
		{
			season = Seasons.FALL;
		}

		return season;
	}
	
	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/
	
	private void loadDaysFile()
	{
        BufferedReader br = null;
        String line = "";
        int cptLine = 0;
        
        try {
            br = new BufferedReader(new FileReader(DAYS_FILE));
            while ((line = br.readLine()) != null) 
            {
                String[] day = line.split(",");
                if (day.length == NB_COLUMNS_FILE)
                {
                	String[] hours = {day[1], day[2]};
                	this.sunHourly.put(day[0], hours);
                }
                else
                {
                	Log.fatal("Days file corupted. Line %d : \"%s\".", cptLine, line);
                	System.exit(-1);
                }
                cptLine++;
            }
            br.close();
        } catch (FileNotFoundException e) {
        	Log.fatal("Unable to find days file. (%s).", DAYS_FILE);
        	System.exit(-1);
        } catch (IOException e) {
        	Log.fatal("Unable to open days file. (%s).", DAYS_FILE);
        	System.exit(-1);
        }
        
        Log.info("Loaded days configuration file successfully.");
	}
}
