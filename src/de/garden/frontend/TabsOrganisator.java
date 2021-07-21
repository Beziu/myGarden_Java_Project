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
	 * Add element to Tabs in tabbed window
	 */
	private MainTab mainTab = new MainTab();
	
	/**
	 * Add element to Tabs in tabbed window
	 */
	private SoilMoistureTab soilTab = new SoilMoistureTab();
	
	/**
	 * Add element to Tabs in tabbed window
	 */
	private Bme250Tab bmeTab = new Bme250Tab();
	
	/**
	 * Add element to Tabs in tabbed window
	 */
	private Ina219Tab inaTab = new Ina219Tab();
	
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
		
		mainTab.setBackground(Color.DARK_GRAY);
		soilTab.setBackground(Color.BLACK);
		bmeTab.setBackground(Color.DARK_GRAY);
		inaTab.setBackground(Color.DARK_GRAY);
		
		add(mainTab, "Informations");
		add(soilTab, "SoilMoisture");
		add(bmeTab, "BME 250");
		add(inaTab, "INA 219");
	}
	
	/**
	 * Getter to tab.
	 * @return 
	 */
	public MainTab getMainTab() {
		return mainTab;
	}
	
	/**
	 * Getter to tab.
	 * @return 
	 */
	public SoilMoistureTab getSoilMoisureTab() {
		return soilTab;
	}
	
	/**
	 * Getter to tab.
	 * @return 
	 */
	public Bme250Tab getBme250Tab() {
		return bmeTab;
	}
	
	/**
	 * Getter to tab.
	 * @return 
	 */
	public Ina219Tab getIna219Tab() {
		return inaTab;
	}
	
}
