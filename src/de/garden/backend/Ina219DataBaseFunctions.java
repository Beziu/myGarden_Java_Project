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
 * Here are all Data Base functions for INA219 sensor<br>
 * uses interface<br><br>
 * 
 * @author grzeg
 *
 */
public class Ina219DataBaseFunctions implements DataBaseDAO {
	
//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * List all values from the sensor.
	 */
	private List<Ina219DB> allReadedValues = new ArrayList<Ina219DB>();
	
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
	public void insertData(Ina219DB valRead) {
		try (Connection connection = DriverManager.getConnection(ADDRESS, USER, PASSWORT)) {
			
			Statement statement = connection.createStatement();
			String sqlQuestion = "INSERT INTO " + INA_TABLE;
			sqlQuestion += " VALUES (NULL, ";
			sqlQuestion += valRead.getVolts() + ",";
			sqlQuestion += valRead.getAmpers() + ", '";
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
			String sqlQuestion = "SELECT * FROM " + INA_TABLE;
			ResultSet answerDB = statement.executeQuery(sqlQuestion);
			
			while (answerDB.next()) {
				int id = answerDB.getInt("INA_ID");
				double volts = answerDB.getDouble("VOLT");
				double ampers = answerDB.getDouble("AMPER");
				LocalDateTime timeRead = LocalDateTime.of(
						answerDB.getDate("DT").toLocalDate(), 
						answerDB.getTime("DT").toLocalTime());
				
				Ina219DB newRead = new Ina219DB(id, volts, ampers, timeRead); 
				
				allReadedValues.add(newRead);
			}
			//System.out.println(allReadedValues);
			
		} catch (SQLException e) {
			System.out.println("Someting goes wrong :( !!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter for list all values from the sensor.
	 * @return list from data bank
	 */
	public List<Ina219DB> getAllData() {
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
		
//			System.out.println("INA219 lastID: " + lastID);
			
		} catch (SQLException e) {
			System.out.println("Someting goes wrong :( !!!");
			e.printStackTrace();
		}
		return lastID;
	}

}
