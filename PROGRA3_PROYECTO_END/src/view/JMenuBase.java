package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import utils.Constants;

public class JMenuBase extends JMenu{

	private static final long serialVersionUID = 1L;

	
	public JMenuBase(String text, int borderHorizontalSize) {
		this.setText(text);
		this.setFont(Constants.FOURTEEN_BOLD_TAHOMA_FONT);
		this.setForeground(Color.WHITE);
		this.setBorder(BorderFactory.createEmptyBorder(Constants.CATEGORIES_JMENU_VERTIC_SIZE, borderHorizontalSize,
				Constants.CATEGORIES_JMENU_VERTIC_SIZE, borderHorizontalSize));
		this.setBackground(Constants.DARK_GREEN);
		this.setOpaque(true);
	}
	
	public JMenuBase(String text) {
		this.setText(text);
		this.setFont(Constants.FOURTEEN_BOLD_TAHOMA_FONT);
		this.setForeground(Color.WHITE);
		this.setBorder(BorderFactory.createEmptyBorder(Constants.CATEGORIES_JMENU_VERTIC_SIZE, Constants.CATEGORIES_JMENU_HORIZ_SIZE,
				Constants.CATEGORIES_JMENU_VERTIC_SIZE, Constants.CATEGORIES_JMENU_HORIZ_SIZE));
		this.setBackground(Constants.DARK_GREEN);
		this.setOpaque(true);
	}

}
