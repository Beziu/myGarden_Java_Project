package tests;

import de.garden.middlepart.*;

/**
 * Automatic write to database test file<br><br>
 * 
 * @author grzeg
 *
 */
public class SensorsAutoWriteDBTest {

	/**
	 * Run constructor to test
	 * @param args is not used
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Bme250Autorun bme = new Bme250Autorun();
		Ina219Autorun ina = new Ina219Autorun();
		SoilMoistureAutorun soil = new SoilMoistureAutorun();
		
//		bme.start();
//		ina.start();
//		soil.start();

	}

}
