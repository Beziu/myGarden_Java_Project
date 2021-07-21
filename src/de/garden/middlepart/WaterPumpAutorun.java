package de.garden.middlepart;

import static de.garden.sensors.SensorsSettings.*;

import de.garden.sensors.*;

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
			
			WaterPump pump = new WaterPump();
			pump.setState(true);
			
			try {
				Thread.sleep(TIME_PUMP_WORKS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
