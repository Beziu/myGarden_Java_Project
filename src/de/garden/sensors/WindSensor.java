package de.garden.sensors;

import java.util.Random;

/**
 * This is wind sensor, it measure rps from 
 * wind turbine and says how strong ist wind<br><br>
 *  
 * @author grzeg
 *
 */
public class WindSensor {
	
//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * Shows how strong is wind
	 */
	protected int rpms;
	
	/**
	 * Check is wind or not
	 */
	protected boolean wind;
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * Standard constructor
	 * @param rpms is wind
	 * @param wind is true or false
	 */
	public WindSensor(int rpms, boolean wind) {
		super();
		this.rpms = rpms;
		this.wind = wind;
	}
	
	/**
	 * Random walues for wind sensor generator
	 */
	public WindSensor() {
		Random lotto= new Random();
		this.rpms = lotto.nextInt(200);;
		this.wind = lotto.nextBoolean();
	}
	
//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * Getter for woind speed
	 * @return rps from turbine
	 */
	public int getRpms() {
		return rpms;
	}

	/**
	 * Setter for woind speed
	 * @param rpms
	 */
	public void setRpms(int rpms) {
		this.rpms = rpms;
	}

	/**
	 * Chcecker for is wind
	 * @return
	 */
	public boolean isWind() {
		return wind;
	}

	/**
	 * Setter for wind
	 * @param wind
	 */
	public void setWind(boolean wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "WindSensor [rpms=" + rpms + ", wind=" + wind + "]";
	}

}
