package de.garden.frontend.info;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.garden.middlepart.*;
import de.garden.sensors.WaterPump;


/**
 * Main Tab on the garden software.<br><br>
 * It shows last sensor reading values and <br>
 * water pump status<br><br>
 *   
 * @author grzeg
 *
 */
public class SoilMoistureOutput extends JPanel {
	
//	*******************************************
//	*				  Attributs
//	*******************************************

	SoilMoistureAutorun soilData = new SoilMoistureAutorun();
	
	Thread soil = new Thread(soilData);

	private JPanel[] unit = new JPanel[3];

 	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	public SoilMoistureOutput() {
		this.setLayout(new GridLayout(1, 3));
		build();
	}

//	*******************************************
//	*				 Functions
//	*******************************************

	@Override
	public void paint (Graphics e) {
		super.paint(e);
		
		unit[0] = new JPanel();
		unit[0].setLayout(new GridLayout(2, 1));
		unit[0].add(new JLabel("Temperature", 0), 0);
		unit[0].add(new JLabel("" + soilData.getTemperature(), 0), 1);
		add(unit[0], 0);
		
		unit[1] = new JPanel();
		unit[1].setLayout(new GridLayout(2, 1));
		unit[1].add(new JLabel("Sun Ligh", 0), 0);
		unit[1].add(new JLabel("" + soilData.getLux(), 0), 1);
		add(unit[1], 1);
		
		unit[2] = new JPanel();
		unit[2].setLayout(new GridLayout(2, 1));
		unit[2].add(new JLabel("Soil Moisture", 0), 0);
		unit[2].add(new JLabel("" + soilData.getMoisture(), 0), 1);
		add(unit[2], 2);

	}
	
	private void build() {	
		repaint();
	}

	

}
