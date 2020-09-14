package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import controller.Commands;
import controller.ControllerClient;

public class JButtonBase extends JButton{

	private static final long serialVersionUID = 1L;

	public JButtonBase(String imgPath, Color backgroundColor) {
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));	
		this.setBackground(backgroundColor);
		this.setBorder(null);
	}
	
	public JButtonBase(String imgPath, Color backgroundColor, ControllerClient controllerApp, Commands command) {
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));	
		this.setBackground(backgroundColor);
		this.setBorder(null);
		this.setActionCommand(command.toString());
		this.addActionListener(controllerApp);
	}
	
	public JButtonBase(String text, String imgPath, Color backgroundColor) {
		this.setText(text);
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));	
		this.setBackground(backgroundColor);
		this.setBorder(null);
	}

	public JButtonBase(String imgPath, String imgPathPress, ControllerClient controllerApp, Commands command) {
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));	
		this.setBorder(null);
		this.setActionCommand(command.toString());
		this.addActionListener(controllerApp);
		this.setPressedIcon(new ImageIcon(getClass().getResource(imgPathPress)));
	}
}






