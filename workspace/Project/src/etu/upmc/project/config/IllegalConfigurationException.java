/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.config;

public class IllegalConfigurationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IllegalConfigurationException()
	{
		super();
	}
	
	public IllegalConfigurationException(String message)
	{
		super(message);
	}
}
