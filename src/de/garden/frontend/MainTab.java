package de.garden.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.garden.backend.Bme250DB;
import de.garden.backend.Bme250DataBaseFunctions;
import de.garden.backend.Ina219DB;
import de.garden.backend.Ina219DataBaseFunctions;
import de.garden.backend.SoilMoistureDB;
import de.garden.backend.SoilMoistureDataBaseFunctions;
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

	/**
	 * Default Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * To have a control of the water pump
	 */
	WaterPump pump = new WaterPump();
	
	/**
	 * To control a water pump witch timer
	 */
	WaterPumpAutorun pumpAuto = new WaterPumpAutorun();

	/**
	 * Get new values from the Soil Moisture sensor
	 */
	SoilMoistureDB soilSensorRead = new SoilMoistureDB();
	
	/**
	 * Reading and Writing values in to database to SoilMosture table
	 */
	SoilMoistureDataBaseFunctions soilDBFunctions = new SoilMoistureDataBaseFunctions();

	/**
	 * Get new values from the INA219 sensor
	 */
	Bme250DB bmeSensorRead = new Bme250DB();
	
	/**
	 * Reading and Writing values in to database to BME250 table
	 */
	Bme250DataBaseFunctions bmeDBFunctions = new Bme250DataBaseFunctions();
	
	/**
	 * Get new values from the INA219 sensor
	 */
	Ina219DB inaSensorRead = new Ina219DB();
	
	/**
	 * Reading and Writing values in to database to INA219 table
	 */
	Ina219DataBaseFunctions inaDBFunctions = new Ina219DataBaseFunctions();

	/**
	 * To run auto reading form the BME250 Sensor
	 */
	Bme250Autorun bmeData = new Bme250Autorun();
	
	/**
	 * To run auto reading form the INA219 Sensor
	 */
	Ina219Autorun inaData = new Ina219Autorun();
	
	/**
	 * To run auto reading form the Soil Moisture Sensor
	 */
	SoilMoistureAutorun soilData = new SoilMoistureAutorun();
	
	/**
	 * Creats a 12 felds for grid layout
	 */
	private JPanel[] unit = new JPanel[12];

	/**
	 * Array witch labels fields Names
	 */
	private JLabel[] labelName = new JLabel[9];
	
	/**
	 * Array witch labels fields Values
	 */
	private JLabel[] labelValue = new JLabel[9];

	/**
	 * Start button to start collectins data from sensors
	 */
	private JButton btnStart = new JButton("Start");
	
	/**
	 * Refresh button to refresh values in grid layout
	 */
	private JButton btnRefresh = new JButton("Refresh");
	
	/**
	 * Label for Wetter
	 */	
	private JLabel[] labelWetter = new JLabel[4];
	
	/**
	 * List all values from the BME250 sensor.
	 */
	List<Bme250DB> bmeList = new ArrayList<Bme250DB>();

 	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * Class standard constructor
	 */
	public MainTab() {
		build();
	}

//	*******************************************
//	*				 Functions
//	*******************************************

	/**
	 * One private build for the constructor tab
	 */
	private void build() {
		buttonsFunction();

		// Sets a labels name in one style 
		for (int i = 0; i < labelName.length; i++) {
			labelName[i] = new JLabel();
			labelName[i].setHorizontalAlignment(0);
			labelName[i].setFont(new Font("Verdana", Font.BOLD, 25));
		}
		
		// Set a name for the labels
		labelName[0].setText("Temperature");
		labelName[1].setText("Humidity");
		labelName[2].setText("Pressure");
		labelName[3].setText("Temperature");
		labelName[4].setText("Sun Ligh");
		labelName[5].setText("Soil Moisture");
		labelName[6].setText("Battery Volt");
		labelName[7].setText("Battery Amper");
		labelName[8].setText("Water Pump");
		
		// Sets a labels values in one style
		for (int i = 0; i < labelValue.length; i++) {
			labelValue[i] = new JLabel();
			labelValue[i].setHorizontalAlignment(0);
			labelValue[i].setFont(new Font("Verdana", Font.BOLD, 30));
			labelValue[i].setForeground(Color.RED);
		}
		
		// Sets a labels to show wetter
		for (int i = 0; i < labelWetter.length; i++) {
			labelWetter[i] = new JLabel();
			labelWetter[i].setHorizontalAlignment(0);
			labelWetter[i].setFont(new Font("Verdana", Font.BOLD, 12));
			labelWetter[i].setForeground(Color.RED);
		}
		
		btnStart.setFont(new Font("Verdana", Font.BOLD, 20));
		btnRefresh.setFont(new Font("Verdana", Font.BOLD, 20));
		
		gridOrganize();
	}
	
	/**
	 * All buttons and click on functions
	 */
	private void buttonsFunction() {
		btnStart.addActionListener(e -> {
			if (!actionStart.isAlive()) {
				actionStart.start();
				refreshValues();
				btnStart.setEnabled(false);
			}
		});
		
		btnRefresh.addActionListener(e -> {
			refreshValues();
		});
	}
	
	/**
	 * Valuses to refresh when new datas from sensors comes
	 */
	private void refreshValues() {
		labelValue[0].setText(bmeSensorRead.getTemperature() + "°C");
		labelValue[1].setText(bmeSensorRead.getHumidity() + "%");
		labelValue[2].setText(bmeSensorRead.getPressure() + "hPa");
		labelValue[3].setText(soilSensorRead.getTemperature() + "°C");
		labelValue[4].setText(soilSensorRead.getLux() + "%");
		labelValue[5].setText(soilSensorRead.getMoisture() + "%");
		labelValue[6].setText(inaSensorRead.getVolts() + "V");
		labelValue[7].setText(inaSensorRead.getAmpers() + "A");
		pumpAuto.isState();
		labelValue[8].setText(pumpAuto.toString());
		labelWetter[0].setText("" + bmeSensorRead.wetter());
		labelWetter[1].setText("" + soilSensorRead.wetterLux());
		labelWetter[2].setText("" + soilSensorRead.wetterTemp());
		labelWetter[3].setText("" + soilSensorRead.wetterErd());
	}
	
	/**
	 * One automatic function to simulates count 'LOOPS_NUMBER' of 
	 * reading from sensors every time sequence 'TIME_BETWEEN_READS'
	 */
	Thread actionStart = new Thread( () -> {
		for (int i = 0; i < LOOPS_NUMBER; i++) {
			
			System.out.println("\n New Sensor Reading Cycle");
			soilSensorRead = new SoilMoistureDB();
			soilDBFunctions = new SoilMoistureDataBaseFunctions();
			soilDBFunctions.insertData(soilSensorRead);
			System.out.println(soilSensorRead.toStringConsole());
			
			bmeSensorRead = new Bme250DB();
			bmeDBFunctions = new Bme250DataBaseFunctions();
			bmeDBFunctions.insertData(bmeSensorRead);
			System.out.println(bmeSensorRead.toStringConsole());
			
			inaSensorRead = new Ina219DB();
			inaDBFunctions = new Ina219DataBaseFunctions();
			inaDBFunctions.insertData(inaSensorRead);
			System.out.println(inaSensorRead.toStringConsole());
			
			Thread water = new Thread(pumpAuto);
			
			if (soilSensorRead.getMoisture() < 50) {
				pumpAuto.setState(true);
				water.start();
				System.out.println(pumpAuto.toStringConsole());
			}
			
			refreshValues();
			
			while (water.isAlive()) {}
			
			refreshValues();
			
			try {
				Thread.sleep(TIME_BETWEEN_READS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
//	private void setColorValues(JLabel label, Double value) {
//		
//		if ()
//		
//	}

	/**
	 * Main grid layout organizer for all Tabs elements
	 */
	private void gridOrganize() {
		this.setLayout(new GridLayout(4, 3));
		
		for (int i = 0; i <= 8; i++) {
			unit[i] = new JPanel();
			unit[i].setLayout(new GridLayout(2, 1));
			unit[i].add(labelName[i], 0);
			unit[i].add(labelValue[i], 1);
			add(unit[i], i);
		}
		
		add(btnStart);
		
		unit[10] = new JPanel();
		unit[10].setLayout(new GridLayout(4, 1));
		unit[10].add(labelWetter[0], 0);
		unit[10].add(labelWetter[1], 1);
		unit[10].add(labelWetter[2], 2);
		unit[10].add(labelWetter[3], 3);
		add(unit[10], 10);
		
		add(btnRefresh);
		
	}

}
