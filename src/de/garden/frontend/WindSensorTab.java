package de.garden.frontend;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class WindSensorTab extends JPanel {

//	*******************************************
//	*				  Attributs
//	*******************************************

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	public WindSensorTab() {
		this.setLayout(new GridLayout(1, 2, 5, 5));
		build();
	}

//	*******************************************
//	*				 Functions
//	*******************************************
	
	private void build() {
		JPanel label = new JPanel();
		label.add(getParent());
		
	}
}
