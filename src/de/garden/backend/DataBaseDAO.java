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
	String schowAllDataAsString();
	
}
