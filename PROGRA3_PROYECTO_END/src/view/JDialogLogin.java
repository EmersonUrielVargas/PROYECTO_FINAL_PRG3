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
import controller.ControllerClient;
import utils.Constants;

public class JDialogLogin extends JDialog {
	private JLBaseLabel jlImage;
	private JLBaseLabel jLError;
	private JLBaseLabel jLNickName;
	private JTFBaseTextField jTFNickName;
	private JLBaseLabel jLPassword;
	private JPasswordField jPFPassword;
	private JLBaseLabel jLTypeUser;
	private JBBaseButton jBlogin;
	private JCBaseComboBox jBCBTypeUser;
	
	public JDialogLogin(ControllerClient controller, Object[] TypeUser) {
		super();
		init(controller, TypeUser);
		
	}
	
	private void init(ControllerClient controllerApp, Object[] typeUser) {
		this.setSize(400, 700);
		this.jLNickName = new JLBaseLabel(Constants.TEXT_LOGIN_LABEL, Constants.EIGHTEEN_BASE_FONT, Constants.DARK_GREEN);
		this.jTFNickName = new JTFBaseTextField(Constants.BASE_GREEN, Constants.EIGHTEEN_BASE_FONT,10);
		this.jLPassword =  new JLBaseLabel(Constants.TEXT_PASSWORD_LOGIN_LABEL, Constants.BASE_LOGIN_FONT, Constants.DARK_GREEN);
		this.jPFPassword = new JPasswordField(15);
		this.jLTypeUser = new JLBaseLabel(Constants.TEXT_TYPE_USER_LOGIN_LABEL, Constants.EIGHTEEN_BASE_FONT, Constants.DARK_GREEN);
		this.jBCBTypeUser = new JCBaseComboBox(controllerApp, typeUser);
		this.jlImage = new JLBaseLabel(Constants.LOGIN_ICON);
		this.jLError = new JLBaseLabel("", Constants.BASE_LOGIN_FONT, Color.RED);
		this.jBlogin = new JBBaseButton(Constants.LOGIN_BUTTON, Constants.BASE_GREEN);
		this.jBlogin.addActionListener(controllerApp);
		this.jBlogin.setActionCommand(Commands.C_LOG_IN.toString());
		this.setLayout(new GridLayout(2, 1, 40, 30));
		
		JPanel jPanelComponents = new JPanel();
		jPanelComponents.setSize(250, 250);
		jPanelComponents.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
		jPanelComponents.setLayout(new GridLayout(7,1,30,10));
		jPanelComponents.add(jLError);
		jPanelComponents.add(jLNickName);
		jPanelComponents.add(jTFNickName);
		jPanelComponents.add(jLPassword);		
		jPanelComponents.add(jPFPassword);
		jPanelComponents.add(new JPanel().add(jBlogin));
		jPanelComponents.add(new JLabel());
	
		this.add(jlImage);
		this.add(jPanelComponents);
		this.setVisible(false);
		this.setResizable(false);
	}
	
	public String[] getDataLogIn() {
		String[] data = new String[2];
		data[0] = this.jTFNickName.getText();
		data[1] = String.copyValueOf(this.jPFPassword.getPassword());
		return data;
	}
	
	public void restoreValue() {
		this.jTFNickName.setText("");
		this.jPFPassword.setText("");
		this.jLError.setText("");
		this.setVisible(false);
	}
	public void incorrectLogin() {
		this.jLError.setText("La informacion no es correcta");
	}
	
	

}
