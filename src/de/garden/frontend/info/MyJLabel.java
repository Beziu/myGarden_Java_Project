package de.garden.frontend.info;

import java.awt.Graphics;

import javax.swing.JLabel;

/**
 * My attempt to overwrite the standard class JLabel,
 * not fully implemented<br><br>
 * 
 * @author grzeg
 *
 */
public class MyJLabel extends JLabel {
	
//	*******************************************
//	*				  Attributs
//	*******************************************
	
	/**
	 * Standard serial UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Returned text
	 */
	private String text;
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	/**
	 * Class constructor
	 * @param text
	 */
	public MyJLabel(String text) {
		super(text);
		this.text = text;
	}

//	*******************************************
//	*				 Functions
//	*******************************************
	
	/**
	 * My attempt to override paint function
	 */
	@Override
	public void paint(Graphics e) {
		super.paint(e);
		e.drawString(text, 20, 20);
	}
	
	/**
	 * Getter toString()
	 */
	public String toString() {
		return text;
	}

}
