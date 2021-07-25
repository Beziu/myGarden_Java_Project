package de.garden.frontend.info;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJLabel extends JLabel {
	
	String text;
	
	public MyJLabel(String text) {
		super(text);
		this.text = text;
	}

	@Override
	public void paint(Graphics e) {
		super.paint(e);
		e.drawString(text, 20, 20);
	}
	
	public String toString() {
		return text;
	}

}
