package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBase extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public JLabelBase(String imgPath) {
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
	}
	
	public JLabelBase(String text, Font font, Color foreGroundColor) {
		super(text);
		this.setFont(font);
		this.setForeground(foreGroundColor);
	}
	
	public JLabelBase(String text, Font font, Color foreGroundColor, int alignment) {
		super(text);
		this.setFont(font);
		this.setForeground(foreGroundColor);
		this.setHorizontalAlignment(alignment);
	}
	
	public JLabelBase(String imgPath, String text, Font font, Color foreGroundColor) {
		super(text);
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
		this.setFont(font);
		this.setForeground(foreGroundColor);
	}
	
	public JLabelBase(String imgPath, String text, Font font, Color foreGroundColor, int alignment) {
		super(text);
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
		this.setFont(font);
		this.setForeground(foreGroundColor);
		this.setHorizontalAlignment(alignment);
	}

}
