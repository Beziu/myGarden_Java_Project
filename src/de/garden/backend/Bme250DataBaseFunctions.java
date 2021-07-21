package de.garden.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static de.garden.backend.DataBaseConnection.*;

/**
 * Here are all Data Base functions for BME250 sensor<br>
 * uses interface<br><br>
 * 
 * @author grzeg
 *
 */
public class Bme250DataBaseFunctions implements DataBaseDAO {

//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * List all values from the sensor.
	 */
	private List<Bme250DB> allReadedValues = new ArrayList<Bme250DB>();
	
//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * Function saves readed sensor data in to data base.<br> 
	 * @param valRead is Object and have last readed sensor values
	 */
	public void insertData(Bme250DB valRead) {
		try (Connection connection = DriverManager.getConnection(ADDRESS, USER, PASSWORT)) {
			
			Statement statement = connection.createStatement();
			String sqlQuestion = "INSERT INTO " + BME_TABLE;
			sqlQuestion += " VALUES (NULL, ";
			sqlQuestion += valRead.getTemperature() + ",";
			sqlQuestion += valRead.getHumidity() + ",";
			sqlQuestion += valRead.getPressure() + ", '";
			sqlQuestion += valRead.getReadTime() + "')";
			
			statement.execute(sqlQuestion);

		} catch (SQLException e) {
			System.out.println("Someting goes wrong :( !!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Function creates list of all saved in data bank values readed from sensor.
	 */
	public void selectData() {
		try (Connection connection = DriverManager.getConnection(ADDRESS, USER, PASSWORT)) {
			
			Statement statement = connection.createStatement();
			String sqlQuestion = "SELECT * FROM " + BME_TABLE;
			ResultSet answerDB = statement.executeQuery(sqlQuestion);
			
			while (answerDB.next()) {
				int id = answerDB.getInt("BME_ID");
				double temperature = answerDB.getDouble("TEMPERATURE");
				int humidity = answerDB.getInt("HUMIDITY");
				int pressure = answerDB.getInt("PRESSURE");
				LocalDateTime timeRead = LocalDateTime.of(
						answerDB.getDate("DT").toLocalDate(), 
						answerDB.getTime("DT").toLocalTime());
				
				Bme250DB newRead = new Bme250DB(id, temperature, humidity, pressure, timeRead); 
				
				allReadedValues.add(newRead);
			}
//			System.out.println(allReadedValues);
			
		} catch (SQLException e) {
			System.out.println("Someting goes wrong :( !!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter for list all values from the sensor.
	 * @return list from data bank
	 */
	public List<Bme250DB> getAllData() {
		return allReadedValues;
	}
	
	/**
	 * Schows in console all sensors values storages in data base.
	 */
	public void schowAllData() {
		allReadedValues.forEach(e -> System.out.println(e));
	}
	
	/**
	 * Schow all entries form database als String output. <br>
	 * @return String of elements
	 */
	public String schowAllDataAsString() {
		selectData();
		String my = "";
		
		for(Object name : allReadedValues) {
			my += name.toString();
			my += "\n";
		}
		return my;
	}
	
}
