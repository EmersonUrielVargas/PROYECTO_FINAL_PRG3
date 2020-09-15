package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLBaseLabel extends JLabel{

	
	public JLBaseLabel(String iconPathName, Color background) {
		this.setIcon(new ImageIcon(getClass().getResource(iconPathName)));
		this.setBackground(background);
	}

	public JLBaseLabel(Color background) {
		this.setBackground(background);
		this.setBorder(null);
	}
	
	public JLBaseLabel(String text, Color foreground,Font font) {
		this.setText(text);
		this.setForeground(foreground);
		this.setFont(font);
		
	}
}
