package de.garden.middlepart;

import de.garden.backend.Ina219DB;
import de.garden.backend.Ina219DataBaseFunctions;

import static de.garden.sensors.SensorsSettings.*;

/**
 * Special class for multithreading process.<br><br>
 * In the class is build new object for simulated
 * readings from sensor circle. <br><br>
 * 
 * @author grzeg
 *
 */
public class Ina219Autorun extends Ina219DB implements Runnable {

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
