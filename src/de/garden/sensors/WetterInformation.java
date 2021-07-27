package de.garden.sensors;

/**
 * Here we find a description of the weather based on the sensor readings<br><br>
 * 
 * @author grzeg
 *
 */
public enum WetterInformation {
	
	NICE("It is nice"), 
	BAD("The weather is bad"), 
	CLOUD("It is cloudy"), 
	PARTCLOUD("Partly cloudy"), 
	RAIN("It is raining"), 
	SUN("Sunny day"), 
	DARK("It is night"),
	COLD("It is cold"),
	HOT("It is hot"),
	DRY("It is dry"),
	HUMID("It is humid");
	
	/**
	 * text describing the weather 
	 */
	private String text;

	/**
	 * Standard constructor
	 * @param text
	 */
	private WetterInformation(String text) {
		this.text = text;
	}

	/**
	 * Getter for the wetter description
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	


}
