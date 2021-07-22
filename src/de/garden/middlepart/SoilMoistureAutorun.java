package de.garden.middlepart;

import de.garden.backend.SoilMoistureDB;
import de.garden.backend.SoilMoistureDataBaseFunctions;

import static de.garden.sensors.SensorsSettings.*;

/**
 * Special class for multithreading process.<br><br>
 * In the class is build new object for simulated
 * readings from sensor circle. <br><br>
 * 
 * @author grzeg
 *
 */
public class SoilMoistureAutorun extends SoilMoistureDB implements Runnable {
	
	/**
	 * Used for Multitreading sensors reading simulations.
	 */
	@Override
	public void run() {
		
		for (int i = 0; i < LOOPS_NUMBER; i++) {
		
			SoilMoistureDB soilRead = new SoilMoistureDB();
			SoilMoistureDataBaseFunctions soilData = new SoilMoistureDataBaseFunctions();
		
			soilData.insertData(soilRead);
			System.out.println(soilRead);
			
			try {
				Thread.sleep(TIME_BETWEEN_READS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
