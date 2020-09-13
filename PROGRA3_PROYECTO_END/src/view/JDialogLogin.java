package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Commands;
import controller.ControllerApp;
import controller.ControllerClient;
import utils.Constants;

public class JDialogLogin extends JDialog {
	private JBaseLabel jBlImage;
	private JBaseLabel jBLError;
	private JBaseLabel jBLNickName;
	private JBaseTextField jBTFNickName;
	private JBaseLabel jBLPassword;
	private JBaseTextField jBTFPassword;
	private JBaseLabel jBLTypeUser;
	private JBaseButton jBBlogin;
	private JBaseComboBox jBCBTypeUser;
	
	public JDialogLogin(ControllerClient controller) {
		super();
		setSize(500,400);
		
	}
	
	private JLBaseLabel jLabelId;
	private JTextField jTextFieldId;
	private JLBaseLabel jLabelPassword;
	private JPasswordField jPasswordField;
	private JLabel iconLogin;
	private JLBaseLabel jLabelIncorrectLogin;
	private JBBaseButton jBlogin;
	


	private void init(ControllerClient controllerApp) {
		this.setSize(400, 600);
		this.jBLNickName = new JLBaseLabel(Constants.TEXT_LOGIN_LABEL, Constants.EIGHTEEN_BASE_FONT, Constants.DARK_GREEN);
		this.jTextFieldId =new JTextField(10);
		this.jLabelPassword =  new JLBaseLabel(Constants.TEXT_PASSWORD_LOGIN_LABEL, Constants.BASE_LOGIN_FONT, Constants.DARK_GREEN);
		this.jPasswordField = new JPasswordField(15);
		this.iconLogin = new JLabel(new ImageIcon(getClass().getResource(Constants.LOGIN_ICON)));
		this.jLabelIncorrectLogin = new JLBaseLabel("", Constants.BASE_LOGIN_FONT, Color.RED);
		this.jBlogin = new JBBaseButton(Constants.LOGIN_BUTTON, Constants.BASE_GREEN);
		this.jBlogin.addActionListener(controllerApp);
		this.jBlogin.setActionCommand(Commands.C_LOG_IN.toString());
		this.setLayout(new GridLayout(2, 1, 40, 30));
		
		JPanel jPanelComponents = new JPanel();
		jPanelComponents.setSize(250, 250);
		jPanelComponents.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
		jPanelComponents.setLayout(new GridLayout(7,1,30,10));
		jPanelComponents.add(jLabelIncorrectLogin);
		jPanelComponents.add(jLabelId);
		jPanelComponents.add(jTextFieldId);
		jPanelComponents.add(jLabelPassword);		
		jPanelComponents.add(jPasswordField);
		jPanelComponents.add(new JPanel().add(jBlogin));
		jPanelComponents.add(new JLabel());
	
		this.add(iconLogin);
		this.add(jPanelComponents);
		this.setVisible(false);
		this.setResizable(false);
	}
	
	public String[] getDataLogIn() {
		String[] data = new String[2];
		data[0] = this.jTextFieldId.getText();
		data[1] = String.copyValueOf(this.jPasswordField.getPassword());
		return data;
	}
	
	public void restoreValue() {
		this.jTextFieldId.setText("");
		this.jPasswordField.setText("");
		this.jLabelIncorrectLogin.setText("");
		this.setVisible(false);
	}
	public void incorrectLogin() {
		this.jLabelIncorrectLogin.setText("La informacion no es correcta");
	}
	
	

}
