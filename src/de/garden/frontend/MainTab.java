package de.garden.frontend;

import javax.swing.JPanel;

import de.garden.middlepart.*;


/**
 * Main Tab on the garden software.<br><br>
 * It shows last sensor reading values and <br>
 * water pump status<br><br>
 *   
 * @author grzeg
 *
 */
public class MainTab extends JPanel {
	
//	*******************************************
//	*				  Attributs
//	*******************************************

	Bme250Autorun bmeData = new Bme250Autorun();
	Ina219Autorun ina = new Ina219Autorun();
	SoilMoistureAutorun soil = new SoilMoistureAutorun();
	
	Thread bme = new Thread(bmeData);
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	public MainTab() {
		bme.start();
		System.out.println(bmeData.getHumidity());
	}
	
	
//	*******************************************
//	*				 Functions
//	*******************************************
	


	
	

}
