package de.garden.backend;

import de.garden.sensors.SoilMoisture;
import java.time.LocalDateTime;

/**
 * Extends SoilMoinstaure class to work whits Data Bank.<br>
 * It have values like: primaryKey and Date-Time,<br>
 * they are nesessary to work whits Data Bank<br><br>
 * 
 * Empty class constructor generates random values from sensor.<br>
 * Including Date and Time of sensor read and laiter it will storage<br>
 * these values in one of the Data Bank table.<br><br>  
 * 
 * @author grzeg
 *
 */
public class SoilMoistureDB extends SoilMoisture {

//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * Unique ID key to identify in DataBase
	 */
	private int primaryKey;
	
	/**
	 * Date and time last readed values from sensor
	 */
	private LocalDateTime readTime;

//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * This constructor creates symulated one time<br>
	 * random readed data from the sensor.
	 */
	public SoilMoistureDB() {
		super();
		LocalDateTime nowTime = LocalDateTime.now();
		this.setReadTime(nowTime);
	}

	/**
	 * Recovery class connstructor from Parent class.
	 * @param temperature
	 * @param lux
	 * @param moisture
	 */
	public SoilMoistureDB(double temperature, int lux, int moisture) {
		super(temperature, lux, moisture);
	}
	
	/**
	 * All values class constructor, can be used to manual writing arguments
	 * @param primaryKey
	 * @param temperature
	 * @param lux
	 * @param moisture
	 * @param dt
	 */
	public SoilMoistureDB(int primaryKey, double temperature, int lux, int moisture, LocalDateTime dt) {
		super(temperature, lux, moisture);
		this.setPrimaryKey(primaryKey);
		this.setReadTime(dt);
	}
	
//	*******************************************
//	*				 Functions
//	*******************************************

	/**
	 * This function is override, 
	 * becouse it have all values, 
	 * includes values from Parent class.
	 */
	@Override
	public String toString() {
		return " Row= " + primaryKey 
				+ ",\t Temperature= " + getTemperature() 
				+ "°C,\t lux= " + getLux() 
				+ "%,\t moisture=" + getMoisture() 
				+ "%,\t           readTime= " + readTime;
	}

	/**
	 * Getter for primaryKey
	 * @return primaryKey from Data Base
	 */
	public int getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * Setter for primaryKey, used in class constructor
	 * @param primaryKey
	 */
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * Getter for date and time.
	 * @return time and date of readed sensor values
	 */
	public LocalDateTime getReadTime() {
		return readTime;
	}

	/**
	 * Setter date and time, used in class constructor
	 * @param readTime
	 */
	public void setReadTime(LocalDateTime readTime) {
		this.readTime = readTime;
	}
	
	/** only for testing */
	public void dataReader() {
		SoilMoistureDB newRead = new SoilMoistureDB();
		System.out.println(newRead);
	}
	
}
