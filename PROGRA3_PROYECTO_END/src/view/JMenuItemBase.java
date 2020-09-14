package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JMenuItemBase extends JMenuItem{

	private static final long serialVersionUID = 1L;

	public JMenuItemBase(String text, ControllerClient controllerApp, Commands command) {
		this.setText(text);
		this.setFont(Constants.FOURTEEN_BOLD_TAHOMA_FONT);
		this.setForeground(Color.WHITE);
		this.setActionCommand(command.toString());
		this.addActionListener(controllerApp);
		this.setBorder(BorderFactory.createEmptyBorder(Constants.SUBCATEGORIES_JMENU_VERTIC_SIZE, Constants.SUBCATEGORIES_JMENU_HORIZ_SIZE,
				 Constants.SUBCATEGORIES_JMENU_VERTIC_SIZE, Constants.SUBCATEGORIES_JMENU_HORIZ_SIZE));
		this.setBackground(Constants.DARK_GREEN);
	}
	
	public JMenuItemBase(String text) {
		this.setText(text);
		this.setFont(Constants.FOURTEEN_BOLD_TAHOMA_FONT);
		this.setForeground(Color.WHITE);
		this.setBorder(BorderFactory.createEmptyBorder( Constants.SUBCATEGORIES_JMENU_VERTIC_SIZE, Constants.SUBCATEGORIES_JMENU_HORIZ_SIZE,
				 Constants.SUBCATEGORIES_JMENU_VERTIC_SIZE, Constants.SUBCATEGORIES_JMENU_HORIZ_SIZE));
		this.setBackground(Constants.DARK_GREEN);
	}

}
