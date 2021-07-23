package de.garden.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import de.garden.frontend.info.SoilMoistureOutput;
import de.garden.backend.Bme250DB;
import de.garden.backend.Bme250DataBaseFunctions;
import de.garden.frontend.info.MyJLabel;
import de.garden.middlepart.*;
import de.garden.sensors.WaterPump;

import static de.garden.sensors.SensorsSettings.*;


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

	WaterPump pump = new WaterPump();
	//Bme250Autorun bmeData = new Bme250Autorun();
	Ina219Autorun inaData = new Ina219Autorun();
	SoilMoistureAutorun soilData = new SoilMoistureAutorun();

	Bme250DB bmeRead = new Bme250DB();
	Bme250DataBaseFunctions bmeDB = new Bme250DataBaseFunctions();
	
	//Thread bme = new Thread(bmeData);
	Thread soil = new Thread(soilData);
	Thread ina = new Thread(inaData);
	
	SoilMoistureOutput temp = new SoilMoistureOutput();
	
	private JPanel[] unit = new JPanel[12];
	private JButton btnStart = new JButton("Start");
	private JButton btnStop = new JButton("Stop");
	
	private MyJLabel bmeAuto = new MyJLabel("");
	public int bmeValue = 0;
	

 	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	public MainTab() {
		build();

		//System.out.println(bmeData);
		System.out.println(bmeRead);
		
		
		Thread actionStart = new Thread( () -> {
			for (int i = 0; i < LOOPS_NUMBER; i++) {
				
				bmeRead = new Bme250DB();
				bmeDB = new Bme250DataBaseFunctions();
			
				bmeDB.insertData(bmeRead);
				System.out.println(bmeRead);
				
				bmeAuto.removeAll();
				bmeAuto.paint
				
				try {
					Thread.sleep(TIME_BETWEEN_READS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		actionStart.start();
		
		bmeAuto = new MyJLabel("" + bmeRead.getPressure());
	}

//	*******************************************
//	*				 Functions
//	*******************************************

	private void build() {
		

		
		//repaint();
		buttonsFunction();
		gridOrganize();
		
	}
	
	private void buttonsFunction() {
		btnStart.addActionListener(e -> {
//			bme.start();
//			ina.start();
//			soil.start();
		});
		btnStop.addActionListener(e -> {
			
			System.out.println(bmeAuto.toString());
			System.out.println("Read: " + bmeRead);
			//System.out.println("Data: " + bmeData);
//			bme.stop();
//			ina.stop();
//			soil.stop();
		});
	}

	private void gridOrganize() {
		this.setLayout(new GridLayout(4, 3));
		
		unit[0] = new JPanel();
		unit[0].setLayout(new GridLayout(2, 1));
		//unit[0].setFont(new Font("Verdana",Font.BOLD, 30));
		unit[0].add(new JLabel("Temperature", 0), 0);
		unit[0].add(new JLabel("" + bmeRead.getTemperature(), 0), 1);
		add(unit[0], 0);
		
		unit[1] = new JPanel();
		unit[1].setLayout(new GridLayout(2, 1));
		unit[1].add(new JLabel("Humidity", 0), 0);
		unit[1].add(new JLabel("" + bmeRead.getHumidity(), 0), 1);
		add(unit[1], 1);
		
		unit[2] = new JPanel();
		unit[2].setLayout(new GridLayout(2, 1));
		unit[2].add(new JLabel("Pressure", 0), 0);
		//unit[2].add(new MyJLabel("" + bmeRead.getPressure()), 1);
		unit[2].add(bmeAuto);
		add(unit[2], 2);
		
		unit[3] = new JPanel();
		unit[3].setLayout(new GridLayout(2, 1));
		unit[3].add(new JLabel("Temperature", 0), 0);
		unit[3].add(new JLabel("" + soilData.getTemperature(), 0), 1);
		add(unit[3], 3);
		
		unit[4] = new JPanel();
		unit[4].setLayout(new GridLayout(2, 1));
		unit[4].add(new JLabel("Sun Ligh", 0), 0);
		unit[4].add(new JLabel("" + soilData.getLux(), 0), 1);
		add(unit[4], 4);
		
		unit[5] = new JPanel();
		unit[5].setLayout(new GridLayout(2, 1));
		unit[5].add(new JLabel("Soil Moisture", 0), 0);
		unit[5].add(new JLabel("" + soilData.getMoisture(), 0), 1);
		add(unit[5], 5);
		
		unit[6] = new JPanel();
		unit[6].setLayout(new GridLayout());
		unit[6].add(new JLabel("Battery Volts", 0));
		unit[6].add(new MyJLabel("" + inaData.getVolts()), 1);
		add(unit[6], 6);
		
		unit[7] = new JPanel();
		unit[7].setLayout(new GridLayout());
		unit[7].add(new JLabel("Battery Ampers", 0));
		unit[7].add(new JLabel("" + inaData.getAmpers()), 1);
		add(unit[7], 7);
		
		unit[8] = new JPanel();
		unit[8].setLayout(new GridLayout());
		//unit[8].add(new JLabel("Pump Status: ", 0));
		unit[8].add(new JLabel(" " + pump.toString()));
		add(unit[8], 8);
		
		unit[9] = new JPanel();
		unit[9].add(btnStart);
		add(unit[9], 9);
		
		unit[10] = new JPanel();
		unit[10].setLayout(new GridLayout());
		unit[10].add(new JLabel("" + soilData.skyLooks()));
		add(unit[10], 10);
		
		unit[11] = new JPanel();
		unit[11].add(btnStop);
		add(unit[11], 11);
		
	}

}
