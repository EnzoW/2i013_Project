package etu.upmc.project.config;

public enum Constants {

	;
	
	private String value;
	
	private Constants(String value) {
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
}
