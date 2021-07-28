package tests;

import de.garden.backend.*;

/**
 * Reading from database test file <br><br>
 * @author grzeg
 *
 */
public class SensorsReadDataBaseTest {
	
	/**
	 * Run constructor to test
	 * @param args is not used
	 */
	public static void main(String[] args) {
		
		//******************************************
		// SoliMoisture sensor
		
		SoilMoistureDataBaseFunctions soilData = new SoilMoistureDataBaseFunctions();
		
//		soilData.selectData();
		soilData.schowAllData();
		
		
		System.out.println("\n");
		//******************************************
		// BME250 sensor
		
		Bme250DataBaseFunctions bmeData = new Bme250DataBaseFunctions();
		
//		bmeData.selectData();
		bmeData.schowAllData();
		
		
		System.out.println("\n");
		//******************************************
		// INA219 sensor
		
		Ina219DataBaseFunctions inaData = new Ina219DataBaseFunctions();
		
//		inaData.selectData();
		inaData.schowAllData();
		
	}

}
