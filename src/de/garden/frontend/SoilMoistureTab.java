package de.garden.frontend;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.garden.backend.DataBaseDAO;
import de.garden.backend.SoilMoistureDataBaseFunctions;

/**
 * This tab will show archiwize sensors readed values<br> 
 * from data base in table view model <br><br>
 * 
 * @author grzeg
 *
 */
public class SoilMoistureTab extends JPanel {

//	*******************************************
//	*				  Attributs
//	*******************************************

	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Text Area to schow database output
	 */
	private JTextArea textArea = new JTextArea(31, 77);
	
	/**
	 * Input data to textArea
	 */
	private DataBaseDAO readString = new SoilMoistureDataBaseFunctions();
	
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * Tabs constructor
	 */
	public SoilMoistureTab() {
		setLayout(new FlowLayout (FlowLayout.CENTER));
		build();
	}
	
//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * Have a JPane elements
	 */
	private void build() {
		add(textArea);
		textArea.setText(readString.schowAllDataAsString());
	}
}
