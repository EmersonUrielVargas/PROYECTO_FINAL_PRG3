package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import controller.ControllerClient;

public class JBaseTextField extends JTextField{
	
	public JBaseTextField(String text, Font font, Color foreColor, ControllerClient controller) {
		this.setFont(font);
		this.setForeground(foreColor);
		this.setText(text);
		this.setFocusable(true);
        this.addKeyListener(controller);
	}
	
	public JBaseTextField(Font font, Color foreColor, ControllerClient controller) {
		this.setFont(font);
		this.setForeground(foreColor);
		this.setFocusable(true);
        this.addKeyListener(controller);
	}

}
