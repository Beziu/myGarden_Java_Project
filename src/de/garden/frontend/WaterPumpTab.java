package de.garden.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.garden.sensors.WaterPump;

/**
 * This tab will show Water pump state. <br> 
 * Here can switch on/off water pump manually <br><br>
 * 
 * @author grzeg
 *
 */
public class WaterPumpTab extends JPanel implements ActionListener {
	
//	*******************************************
//	*				  Attributs
//	*******************************************

	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Switch the Water Pump to ON position
	 */
	private JButton btnON = new JButton("ON");

	/**
	 * Switch the Water Pump to OFF position
	 */
	private JButton btnOFF = new JButton("OFF");
	
	/**
	 * Import WaterPump class
	 */
	private WaterPump pump = new WaterPump();
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * Default construktor
	 */
	public WaterPumpTab() {
		this.setLayout(new GridLayout(1, 2, 5, 5));
		build();
		buttonsConfigState();
	}

//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * Have a tab Water Pump elements
	 */
	private void build() {
		add(btnON, 0);
		add(btnOFF, 1);
	}
	
	/**
	 * Buttons settings
	 */
	private void buttonsConfigState() {
		btnON.setToolTipText("Click this button to switch ON Water Pump ");
		btnOFF.setToolTipText("Click this button to switch OFF Water Pump ");
		
		btnON.setMnemonic(KeyEvent.VK_N);
		btnOFF.setMnemonic(KeyEvent.VK_F);
		
		btnON.setActionCommand("disable");
		btnOFF.setActionCommand("enable");
		
		btnOFF.setEnabled(false);
		
		btnON.addActionListener(this);
		btnOFF.addActionListener(this);
		
		btnON.setFont(new Font("Verdana",Font.BOLD, 30));
		btnOFF.setFont(new Font("Verdana", Font.BOLD, 30));
		
		btnON.setForeground(Color.RED);
		btnOFF.setForeground(new Color(0, 150, 0));
		
	}
	
	/**
	 * Override ActionListner function
	 */
	public void actionPerformed(ActionEvent e ) {
		if ("disable".equals(e.getActionCommand())) {
			btnON.setEnabled(false);
			btnOFF.setEnabled(true);
			pump.setState(false);
			System.out.println(pump.toString());
		} else {
			btnON.setEnabled(true);
			btnOFF.setEnabled(false);
			pump.setState(true);
			System.out.println(pump.toString());
		}
	}
	
	
}
