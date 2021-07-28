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
	
	/** wetter description */
	NICE("It is nice"), 
	
	/** wetter description */
	BAD("The weather is bad"),
	
	/** wetter description */
	CLOUD("It is cloudy"), 
	
	/** wetter description */
	PARTCLOUD("Partly cloudy"),
	
	/** wetter description */
	RAIN("It is raining"), 
	
	/** wetter description */
	SUN("Sunny day"), 
	
	/** wetter description */
	DARK("It is night"),
	
	/** wetter description */
	COLD("It is cold"),
	
	/** wetter description */
	HOT("It is hot"),
	
	/** wetter description */
	DRY("Erde is dry"),
	
	/** wetter description */
	WET("Erde is wet"),
	
	/** wetter description */
	AIR("Air is to dry"),
	
	/** wetter description */
	HUMID("It is humid"),
	
	/** wetter description */
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
	 * @param text is string 
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
