package de.garden.sensors;

/**
 * Here we find a description of the weather based on the sensor readings<br><br>
 * 
 * @author grzeg
 *
 */
public enum WetterInformation {
	
//	*******************************************
//	*				  Attributs
//	*******************************************
	
	NICE("It is nice"), 
	BAD("The weather is bad"), 
	CLOUD("It is cloudy"), 
	PARTCLOUD("Partly cloudy"), 
	RAIN("It is raining"), 
	SUN("Sunny day"), 
	DARK("It is night"),
	COLD("It is cold"),
	HOT("It is hot"),
	DRY("Erde is dry"),
	WET("Erde is wet"),
	AIR("Air is to dry"),
	HUMID("It is humid"),
	CHARGING("Battery charging");
	
	/**
	 * text describing the weather 
	 */
	private String text;

//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * Standard constructor
	 * @param text
	 */
	private WetterInformation(String text) {
		this.text = text;
	}

//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * Getter for the wetter description
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	


}
