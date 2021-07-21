package de.garden.middlepart;

import static de.garden.sensors.SensorsSettings.*;

import de.garden.backend.Ina219DB;
import de.garden.backend.Ina219DataBaseFunctions;

/**
 * Automation for the water pump.
 * 
 * @author grzeg
 *
 */
public class WaterPumpAutorun extends Thread implements Runnable {

	/**
	 * Used for Multitreading sensors reading simulations.
	 */
	@Override
	public void run() {
		
		for (int i = 0; i < LOOPS_NUMBER; i++) {
			
			Ina219DB inaRead = new Ina219DB();
			Ina219DataBaseFunctions inaData = new Ina219DataBaseFunctions();
			
			inaData.insertData(inaRead);
			System.out.println(inaRead);
			
			try {
				Thread.sleep(TIME_BETWEEN_READS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
