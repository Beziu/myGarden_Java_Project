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
	 * @param volts is volts
	 * @param ampers is ampers
	 */
	public Ina219DB(double volts, double ampers) {
		this.volts = volts;
		this.ampers = ampers;
	}
	
	/**
	 * All values class constructor, can be used to manual writing arguments
	 * @param primaryKey is ID in database
	 * @param volts is volts
	 * @param ampers is ampers
	 * @param readTime is data and time
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
	 * @return string to the table view
	 */
	@Override
	public String toString() {
		return " Index= " + primaryKey
				+ ", Volts= " + volts 
				+ "V,\t    Ampers= " + ampers 
				+ "A,\t Read Time= " + readTime;
	}
	
	/**
	 * toStringTabel() is moded toString special to console viev
	 * @return string to the console
	 */
	public String toStringConsole() {
		return " Ina219 Sensor Read [ "
				+ "Volts= " + volts 
				+ "V,\t Ampers= " + ampers 
				+ "A,\t Read Time= " + readTime + " ]";
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
	 * @param primaryKey is table ID in database
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
	 * @param readTime is date and time
	 */
	public void setReadTime(LocalDateTime readTime) {
		this.readTime = readTime;
	}
	
}
