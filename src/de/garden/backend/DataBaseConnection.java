package de.garden.backend;

/**
 * Here are all constans attributs what are nessesary<br>
 * to make data bank connection.<br><br>
 * 
 * @author grzeg
 *
 */
public class DataBaseConnection {	
	
	/**
	 * Driver and address of data base connection.
	 */
	public static final String ADDRESS = "jdbc:mysql://localhost:3306/myGarden";
	
	/**
	 * Data base user.
	 */
	public static final String USER = "root";
	
	/**
	 * Data base password.
	 */
	public static final String PASSWORT = "";
	
	/**
	 * Name of tabele to stored readed values from SoilMoisture sensor.
	 */
	public static final String SM_TABLE = "soilmoisture";
	
	/**
	 * Name of tabele to stored readed values from BME250 sensor.
	 */
	public static final String BME_TABLE = "bme250";
	
	/**
	 * Name of tabele to stored readed values from INA219 sensor.
	 */
	public static final String INA_TABLE = "ina219";
	
}
