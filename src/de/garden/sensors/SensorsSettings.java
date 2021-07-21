package de.garden.sensors;

/**
 * Here are all constans attributs what are nessesary<br>
 * to make data bank connection.<br><br>
 * 
 * @author grzeg
 *
 */
public class SensorsSettings {

	/**
	 * TIME_BETWEEN_READS is time in miliseconds, <br>
	 * how often values from sensor shoud be read. 
	 */
	public static final int TIME_BETWEEN_READS = 30000;
	
	/**
	 * TIME_PUMP_WORKS is time in miliseconds, <br>
	 * how long garden is watering.
	 */
	public static final int TIME_PUMP_WORKS = 10000;
	
	/**
	 * LOOPS_NUMBER is number of loops.<br>
	 * Use it to count how many loops simulation will have.<br>
	 * How many sensor reads schould be in simulation circle.  
	 */
	public static final int LOOPS_NUMBER = 10;
}
