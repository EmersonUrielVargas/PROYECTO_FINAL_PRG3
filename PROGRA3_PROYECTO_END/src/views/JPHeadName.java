package views;

import java.awt.GridLayout;

import javax.swing.JPanel;

import utils.Constants;

public class JPHeadName extends JPanel{
	private JLBaseLabel jLNameUser;
	private JLBaseLabel jLTypeUser;
	
	public JPHeadName(String nameUser, String typeUser) {
		super();
		this.setSize(100, 50);
		this.setLayout(new GridLayout(2, 1));
		this.jLNameUser = new JLBaseLabel(nameUser, Constants.BASE_FONT, Constants.BASE_GREEN);
		this.jLTypeUser = new JLBaseLabel(typeUser, Constants.FOURTEEN_BOLD_BASE_FONT, Constants.DARK_GREEN);
		this.add(jLNameUser);
		this.add(jLTypeUser);
		this.setVisible(true);
	}
	

}
