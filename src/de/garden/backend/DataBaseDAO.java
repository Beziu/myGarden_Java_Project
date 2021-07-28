package de.garden.backend;

/**
 * Interface to manage data collection<br><br>
 * 
 * @author grzeg
 *
 */
public interface DataBaseDAO {
	
	/**
	 * Schow all entries form database als String output.<br> 
	 * @return rows from databank in one String
	 */
	public String schowAllDataAsString();
	
	/**
	 * Extracts all data from the database and puts it in the list
	 */
	void selectData();
	
	/**
	 * Print data to the console
	 */
	void schowAllData();
	
	/**
	 * Returns the last key entered in the database
	 * @return last database entry primary key
	 */
	int getLastID();
	
}
