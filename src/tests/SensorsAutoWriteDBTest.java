package tests;

import de.garden.middlepart.*;

public class SensorsAutoWriteDBTest {

	public static void main(String[] args) {
		
		Bme250Autorun bme = new Bme250Autorun();
		Ina219Autorun ina = new Ina219Autorun();
		SoilMoistureAutorun soil = new SoilMoistureAutorun();
		
		//bme.start();
		//ina.start();
		//soil.start();

	}

}
