package de.garden.middlepart;

import static de.garden.sensors.SensorsSettings.*;

import de.garden.sensors.*;

/**
 * This class is extends WaterPump class<br><br>
 * 
 * It have automation for the water pump.<br><br>
 * 
 * @author grzeg
 *
 */
public class WaterPumpAutorun extends WaterPump implements Runnable {

	/**
	 * Used for Multitreading sensors reading simulations.
	 */
	@Override
	public void run() {
		
//		for (int i = 0; i < LOOPS_NUMBER; i++) {
//			
//			WaterPump pump = new WaterPump();
//			pump.setState(true);
			
			try {
				Thread.sleep(TIME_PUMP_WORKS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			setState(false);
			System.out.println(toStringConsole());
//		}
		
	}
	
}
