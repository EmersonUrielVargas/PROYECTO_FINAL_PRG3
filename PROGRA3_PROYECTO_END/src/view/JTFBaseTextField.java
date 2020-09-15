package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

import controller.ControllerClient;

public class JTFBaseTextField extends JTextField{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTFBaseTextField(String text, Font font, Color foreColor, ControllerClient controller) {
		this.setFont(font);
		this.setForeground(foreColor);
		this.setText(text);
		this.setFocusable(true);
        this.addKeyListener(controller);
	}
	
	public JTFBaseTextField(Font font, Color foreColor, ControllerClient controller) {
		this.setFont(font);
		this.setForeground(foreColor);
		this.setFocusable(true);
        this.addKeyListener(controller);
	}

}
