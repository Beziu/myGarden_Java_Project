package de.garden.frontend;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This is main window in Grafic User Interface<br><br>
 * 
 * @author grzeg
 *
 */
public class MainWindow extends JFrame {
	
//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construktors for a buttons bar in menu. 
	 */
	private JMenuBar menuBar = new JMenuBar();
	
	/** Element in menu. */
	private JMenu menuFile = new JMenu("File");
	
	/** Element in menu. */
	private JMenu menuExtra = new JMenu("Extras");
	
	/** Element in menu. */
	private JMenuItem menuEnd = new JMenuItem("End");
	
	/** Element in menu. */
	private JMenuItem menuMain = new JMenuItem("Main");
	
	/** Element in menu. */
	private JMenuItem menuSoil = new JMenuItem("SoilMoisture");
	
	/** Element in menu. */
	private JMenuItem menuBme = new JMenuItem("BME 250");
	
	/** Element in menu. */
	private JMenuItem menuIna = new JMenuItem("INA 219");
	
	/** Element in menu. */
	private JMenuItem menuPump = new JMenuItem("Water Pump");
	
	/** JTabbedPane element */
	private TabsOrganisator mainBuilder = new TabsOrganisator();
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * Main window elements and construction 
	 */
	public MainWindow() {
		
		setTitle("Welcome to myGarden");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		menuBuilder();
		tabsBuilder();
		buttonsClicked();
		
	}
	
//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * Function creates link between clicked object in menu.
	 */
	private void buttonsClicked() {
		menuEnd.addActionListener(e -> System.exit(1));
		menuMain.addActionListener(e -> mainBuilder.setSelectedComponent(mainBuilder.getMainTab()));
		menuSoil.addActionListener(e -> mainBuilder.setSelectedComponent(mainBuilder.getSoilMoisureTab()));
		menuBme.addActionListener(e -> mainBuilder.setSelectedComponent(mainBuilder.getBme250Tab()));
		menuIna.addActionListener(e -> mainBuilder.setSelectedComponent(mainBuilder.getIna219Tab()));
		menuPump.addActionListener(e -> mainBuilder.setSelectedComponent(mainBuilder.getWaterPumpTab()));
	}

	/**
	 * Function organize a menu bar elements
	 */
	private void menuBuilder() {
		menuBar.add(menuFile);
		menuBar.add(menuExtra);
		
		menuFile.add(menuEnd);
		
		menuExtra.add(menuMain);
		menuExtra.add(menuSoil);
		menuExtra.add(menuBme);
		menuExtra.add(menuIna);
		menuExtra.add(menuPump);
		
		setJMenuBar(menuBar);
	}
	
	/**
	 * Function build tabbed elements 
	 */
	private void tabsBuilder() {
		this.add(mainBuilder);
	}
	

}
