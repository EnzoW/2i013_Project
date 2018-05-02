/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.time;

import java.time.MonthDay;

public enum Seasons
{
	WINTER(0),
	SPRING(1),
	SUMMER(2),
	FALL(3);
	
	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/
	
	public static final MonthDay WINTER_BEGINNING   = MonthDay.of(12, 21);
	public static final MonthDay SPRING_BEGINNING   = MonthDay.of(3, 21);
	public static final MonthDay SUMMER_BEGINNING   = MonthDay.of(6, 22);
	public static final MonthDay FALL_BEGINNING 	= MonthDay.of(9, 22);
	
	/* ****************************************************************
	 * 	Private context
	 * ****************************************************************/
	
	private final int value;
	
	/* ****************************************************************
	 * 	Constructor
	 * ****************************************************************/
	
	private Seasons(int value)
	{
		this.value = value;
	}
	
	/* ****************************************************************
	 * 	Public methods
	 * ****************************************************************/
	
	public int getValue()
	{
		return this.value;
	}
}