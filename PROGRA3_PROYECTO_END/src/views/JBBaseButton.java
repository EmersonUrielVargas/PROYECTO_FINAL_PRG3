package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Commands;
import controller.ControllerClient;

public class JBBaseButton extends JButton{

		private static final long serialVersionUID = 1L;

		public JBBaseButton(String imgPath, Color backgroundColor) {
			this.setIcon(new ImageIcon(getClass().getResource(imgPath)));	
			this.setBackground(backgroundColor);
			this.setBorder(null);
		}
		
		public JBBaseButton(String imgPath, Color backgroundColor, ControllerClient controllerApp, Commands command) {
			this.setIcon(new ImageIcon(getClass().getResource(imgPath)));	
			this.setBackground(backgroundColor);
			this.setBorder(null);
			this.setActionCommand(command.toString());
			this.addActionListener(controllerApp);
		}
		
		public JBBaseButton(String text, String imgPath, Color backgroundColor) {
			this.setText(text);
			this.setIcon(new ImageIcon(getClass().getResource(imgPath)));	
			this.setBackground(backgroundColor);
			this.setBorder(null);
		}

		
		public JBBaseButton(String imgPath, String imgPathPress, ControllerClient controllerApp, Commands command) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(imgPath));
			ImageIcon imageIconPress = new ImageIcon(getClass().getResource(imgPathPress));
			this.setIcon(imageIcon);	
			this.setBorder(null);
			this.setActionCommand(command.toString());
			this.addActionListener(controllerApp);
			this.setPressedIcon(imageIconPress);
			this.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
		}
}
