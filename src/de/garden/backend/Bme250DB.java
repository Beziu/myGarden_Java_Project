package de.garden.backend;

import de.garden.sensors.Bme250;
import java.time.LocalDateTime;

/**
 * Extends BME250 class to work whits Data Bank<br>
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
public class Bme250DB extends Bme250 {

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
	public Bme250DB() {
		super();
		LocalDateTime nowTime = LocalDateTime.now();
		this.setReadTime(nowTime);
	}
	
	/**
	 * Recovery class connstructor from Parent class.
	 * @param temperature is temperature
	 * @param humidity is humidity
	 * @param pressure is pressure
	 */
	public Bme250DB(double temperature, int humidity, int pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	
	/**
	 * All values class constructor, can be used to manual writing arguments
	 * @param primaryKey is ID in database
	 * @param temperature is temperature
	 * @param humidity is humidity
	 * @param pressure is pressure
	 * @param readTime is time and date
	 */
	public Bme250DB(int primaryKey, double temperature, int humidity, int pressure, LocalDateTime readTime) {
		this.primaryKey = primaryKey;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
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
				+ ",\t Temperature= " + temperature 
				+ "°C,\t   Humidity= " + humidity 
				+ "%,\t  Pressure= " + pressure 
				+ "hPa,\t Read Time= " + readTime;
	}
	
	/**
	 * toStringTabel() is moded toString special to console viev
	 * @return string to the console
	 */
	public String toStringConsole() {
		return " BME250 Sensor Read [ " 
				+ "Temperature= " + temperature 
				+ "°C,\t Humidity= " + humidity 
				+ "%,\t Pressure= " + pressure 
				+ "hPa,\t Read Time= " + readTime + " ]";
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
