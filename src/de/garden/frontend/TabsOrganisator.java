package de.garden.frontend;

import java.awt.Color;

import javax.swing.JTabbedPane;

/**
 * Here are Tabs what we see in mainwindow
 * 
 * @author grzeg
 *
 */
public class TabsOrganisator extends JTabbedPane {

//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Add element MainTab to Tabs in tabbed window
	 */
	private MainTab mainTab = new MainTab();
	
	/**
	 * Add element SoilMoistureTab to Tabs in tabbed window
	 */
	private SoilMoistureTab soilTab = new SoilMoistureTab();
	
	/**
	 * Add element Bme250Tab to Tabs in tabbed window
	 */
	private Bme250Tab bmeTab = new Bme250Tab();
	
	/**
	 * Add element Ina219Tab to Tabs in tabbed window
	 */
	private Ina219Tab inaTab = new Ina219Tab();
	
	/**
	 * Add element WaterPumpTab to Tabs in tabbed window
	 */
	private WaterPumpTab pumpTab = new WaterPumpTab();
	
	/**
	 * Add element WindSensorTab to Tabs in tabbed window
	 */
	private WindSensorTab windTab = new WindSensorTab();
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * JTabbedPane construktor
	 */
	public TabsOrganisator() {
		builder();
	}

//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * JTabbedPane tabs elements configurator  
	 */
	private void builder() {
		
		mainTab.setBackground(Color.LIGHT_GRAY);
		soilTab.setBackground(Color.DARK_GRAY);
		bmeTab.setBackground(Color.DARK_GRAY);
		inaTab.setBackground(Color.DARK_GRAY);
		pumpTab.setBackground(Color.DARK_GRAY);
		windTab.setBackground(Color.DARK_GRAY);
		
		add(mainTab, "Informations");
		add(soilTab, "SoilMoisture");
		add(bmeTab, "BME 250");
		add(inaTab, "INA 219");
		add(pumpTab, "Water Pump");
		add(windTab, "Wind Sensor");
	}
	
	/**
	 * Getter to tab.
	 * @return MainTab
	 */
	public MainTab getMainTab() {
		return mainTab;
	}
	
	/**
	 * Getter to tab.
	 * @return SoilMoistureTab
	 */
	public SoilMoistureTab getSoilMoisureTab() {
		return soilTab;
	}
	
	/**
	 * Getter to tab.
	 * @return Bme250Tab
	 */
	public Bme250Tab getBme250Tab() {
		return bmeTab;
	}
	
	/**
	 * Getter to tab.
	 * @return Ina219Tab
	 */
	public Ina219Tab getIna219Tab() {
		return inaTab;
	}
	
	/**
	 * Getter to tab.
	 * @return WaterPumpTab
	 */
	public WaterPumpTab getWaterPumpTab() {
		return pumpTab;
	}
	
	/**
	 * Getter to tab.
	 * @return WindSensorTab
	 */
	public WindSensorTab getWindSensorTab() {
		return windTab;
	}
	
}
