package de.garden.backend;

import de.garden.sensors.Ina219;
import java.time.LocalDateTime;

/**
 * Extends INA219 class to work whits Data Bank<br>
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
public class Ina219DB extends Ina219 {

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
	public Ina219DB() {
		super();
		LocalDateTime nowTime = LocalDateTime.now();
		this.setReadTime(nowTime);
	}
	
	/**
	 * Recovery class connstructor from Parent class.
	 * @param volts
	 * @param ampers
	 */
	public Ina219DB(double volts, double ampers) {
		this.volts = volts;
		this.ampers = ampers;
	}
	
	/**
	 * All values class constructor, can be used to manual writing arguments
	 * @param primaryKey
	 * @param volts
	 * @param ampers
	 * @param dt
	 */
	public Ina219DB(int primaryKey, double volts, double ampers, LocalDateTime readTime) {
		this.primaryKey = primaryKey;
		this.volts = volts;
		this.ampers = ampers;
		this.readTime = readTime;
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
		return " Index= " + primaryKey
				+ ",\t volts= " + volts 
				+ "V,\t    ampers= " + ampers 
				+ "A,\t readTime= " + readTime + "]";
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
	
}
