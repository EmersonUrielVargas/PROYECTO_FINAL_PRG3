package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JBaseLabel extends JLabel{

	
	public JBaseLabel(String iconPathName, Color background) {
		this.setIcon(new ImageIcon(getClass().getResource(iconPathName)));
		this.setBackground(background);
	}

	public JBaseLabel(Color background) {
		this.setBackground(background);
		this.setBorder(null);
	}
	
	public JBaseLabel(String text, Color foreground,Font font) {
		this.setText(text);
		this.setForeground(foreground);
		this.setFont(font);
		
	}
}
