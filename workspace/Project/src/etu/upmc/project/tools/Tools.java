/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.tools;

public class Tools {

	public static void shuffle(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int r = (int) (i + Math.random() * (array.length - i));

			int tmp = array[r];
			array[r] = array[i];
			array[i] = tmp;
		}
	}
	
	public static void shuffle(int[][] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int r = (int) (i + Math.random() * (array.length - i));

			int[] tmp = array[r].clone();
			array[r] = array[i].clone();
			array[i] = tmp.clone();
		}
	}

	public static float map(float value, float fromLow, float fromHigh, float toLow, float toHigh)
	{
		return (value - fromLow) * (toHigh - toLow) / (fromHigh - fromLow) + toLow;
	}
}
