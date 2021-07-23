package de.garden.frontend.info;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyJLabel extends JPanel {
	
	String text;
	
	public MyJLabel(String text) {
		this.text = text;
	}

	@Override
	public void paint(Graphics e) {
		super.paint(e);
		e.drawString(text, 10, 10);
	}
	
	public String toString() {
		return text;
	}

}
