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
 * Here are all Data Base functions for SoilMoisure sensor<br>
 * uses interface<br><br>
 * 
 * @author grzeg
 *
 */
public class SoilMoistureDataBaseFunctions implements DataBaseDAO {
	
//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * List all values from the sensor.
	 */
	private List<SoilMoistureDB> allReadedValues = new ArrayList<SoilMoistureDB>();
	
	/**
	 * Last primarykey;
	 */
	private int lastID;

//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * Function saves readed sensor data in to data base.<br>
	 * @param valRead is Object and have last readed sensor values
	 */
	public void insertData(SoilMoistureDB valRead) {
		try (Connection connection = DriverManager.getConnection(ADDRESS, USER, PASSWORT)) {
			
			Statement statement = connection.createStatement();
			String sqlQuestion = "INSERT INTO " + SM_TABLE;
			sqlQuestion += " VALUES (NULL, ";
			sqlQuestion += valRead.getTemperature() + ",";
			sqlQuestion += valRead.getLux() + ",";
			sqlQuestion += valRead.getMoisture() + ", '";
			sqlQuestion += valRead.getReadTime() + "')";
			
			statement.execute(sqlQuestion);

		} catch (SQLException e) {
			System.out.println("Someting goes wrong :( !!!");
			e.printStackTrace();
		}
	}

	/**
	 * Function creates list of all saved in data bank values readed from sensor 
	 */
	public void selectData() {
		try (Connection connection = DriverManager.getConnection(ADDRESS, USER, PASSWORT)) {
			
			Statement statement = connection.createStatement();
			String sqlQuestion = "SELECT * FROM " + SM_TABLE;
			ResultSet answerDB = statement.executeQuery(sqlQuestion);
			
			while (answerDB.next()) {
				int id = answerDB.getInt("SOIL_ID");
				double temperature = answerDB.getDouble("TEMPERATURE");
				int lux = answerDB.getInt("LUX");
				int moisture = answerDB.getInt("MOISTURE");
				LocalDateTime timeRead = LocalDateTime.of(
						answerDB.getDate("DT").toLocalDate(), 
						answerDB.getTime("DT").toLocalTime());
				
				SoilMoistureDB newRead = new SoilMoistureDB(id, temperature, lux, moisture, timeRead); 
				
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
	public List<SoilMoistureDB> getAllData() {
		return allReadedValues;
	}
	
	/**
	 * Schows in console all sensors values storages in data base.
	 */
	public void schowAllData() {
		selectData();
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

	/**
	 * Getter to lastID. 
	 * @return last primaryKey value from table
	 */
	public int getLastID() {
		try (Connection connection = DriverManager.getConnection(ADDRESS, USER, PASSWORT)) {
			
			Statement statement = connection.createStatement();
			String sqlQuestion = "SELECT @@IDENTITY";// FROM " + SM_TABLE;
			ResultSet answerDB = statement.executeQuery(sqlQuestion);
			
			lastID = answerDB.getInt("SOIL_ID");
		
//			System.out.println("SoilMoisture lastID: " + lastID);
			
		} catch (SQLException e) {
			System.out.println("Someting goes wrong :( !!!");
			e.printStackTrace();
		}
		return lastID;
	}

}
