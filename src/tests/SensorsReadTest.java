package tests;

import de.garden.backend.*;

public class SensorsReadTest {

	public static void main(String[] args) {
		
		SoilMoistureDB newData = new SoilMoistureDB();
		System.out.println(newData);
		System.out.println(newData.wetterLux());
		
		Bme250DB bmeData = new Bme250DB();
		System.out.println(bmeData);
		
		Ina219DB inaData = new Ina219DB();
		System.out.println(inaData);
		
	}

}
