package tests;

import de.garden.backend.*;

public class SensorsWriteDataBaseTest {

	public static void main(String[] args) {

		//******************************************
		// SoliMoisture sensor
		
		SoilMoistureDB soilRead = new SoilMoistureDB();
		SoilMoistureDataBaseFunctions soilData = new SoilMoistureDataBaseFunctions();
		
		soilData.insertData(soilRead);
		
		
		System.out.println("\n");
		//******************************************
		// BME250 sensor
		
		Bme250DB bmeRead = new Bme250DB();
		Bme250DataBaseFunctions bmeData = new Bme250DataBaseFunctions();
		
		bmeData.insertData(bmeRead);
		
		
		System.out.println("\n");
		//******************************************
		// INA219 sensor
		
		Ina219DB inaRead = new Ina219DB();
		Ina219DataBaseFunctions inaData = new Ina219DataBaseFunctions();
		
		inaData.insertData(inaRead);
		
		System.out.println("-----======  END  =====-----");
	}

}
