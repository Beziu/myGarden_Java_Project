package de.garden.middlepart;

import de.garden.backend.Bme250DB;
import de.garden.backend.Bme250DataBaseFunctions;

import static de.garden.sensors.SensorsSettings.*;

/**
 * Special class for multithreading process.<br><br>
 * In the class is build new object for simulated
 * readings from sensor circle. <br><br>
 * 
 * @author grzeg
 *
 */
public class Bme250Autorun extends Bme250DB implements Runnable {

	/**
	 * Used for Multitreading sensors reading simulations.
	 */
	@Override
	public void run() {
		for (int i = 0; i < LOOPS_NUMBER; i++) {
	
			Bme250DB bmeRead = new Bme250DB();
			Bme250DataBaseFunctions bmeData = new Bme250DataBaseFunctions();
		
			bmeData.insertData(bmeRead);
			System.out.println(bmeRead);
			
			try {
				Thread.sleep(TIME_BETWEEN_READS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
