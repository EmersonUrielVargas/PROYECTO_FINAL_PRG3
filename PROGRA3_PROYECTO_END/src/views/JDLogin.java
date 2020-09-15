package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controller.Commands;
import controller.ControllerClient;
import enums.TypeUser;
import utils.Constants;

public class JDLogin extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLBaseLabel imagenJL,errorJL,nickNameJL,passwordJL,typeUserJL;
	private JTFBaseTextField jTFNickName;
	private JPasswordField jPFPassword;
	private JBBaseButton jBlogin;
	private JCBBaseComboBox jBCBTypeUser;
	private JLBaseLabel jBlImage;
	private JLBaseLabel jBLError;
	private JLBaseLabel jBLNickName;
	private JTFBaseTextField jBTFNickName;
	private JLBaseLabel jBLPassword;
	private JTFBaseTextField jBTFPassword;
	private JLBaseLabel jBLTypeUser;
	private JBBaseButton jBBlogin;
	
	public JDLogin(ControllerClient controller, Object[] TypeUser) {
		super();
		init(controller, TypeUser);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
	private void init(ControllerClient controllerApp, Object[] typeUser) {
		this.setSize(400, 700);
		this.nickNameJL = new JLBaseLabel(Constants.TEXT_LOGIN_LABEL, Constants.EIGHTEEN_BASE_FONT, Constants.DARK_GREEN);
		this.jTFNickName = new JTFBaseTextField(Constants.BASE_GREEN, Constants.EIGHTEEN_BASE_FONT,10);
		this.passwordJL =  new JLBaseLabel(Constants.TEXT_PASSWORD_LOGIN_LABEL, Constants.BASE_LOGIN_FONT, Constants.DARK_GREEN);
		this.jPFPassword = new JPasswordField(15);
		this.typeUserJL = new JLBaseLabel(Constants.TEXT_TYPE_USER_LOGIN_LABEL, Constants.EIGHTEEN_BASE_FONT, Constants.DARK_GREEN);
		this.jBCBTypeUser = new JCBBaseComboBox(controllerApp, typeUser);
		this.imagenJL = new JLBaseLabel(Constants.LOGIN_ICON);
		this.errorJL = new JLBaseLabel("", Constants.BASE_LOGIN_FONT, Color.RED);
		this.jBlogin = new JBBaseButton(Constants.LOGIN_BUTTON, Constants.BASE_GREEN);
		this.jBlogin.addActionListener(controllerApp);
		this.jBlogin.setActionCommand(Commands.C_LOG_IN.toString());
		this.setLayout(new GridLayout(2, 1, 40, 30));
		
		JPanel jPanelComponents = new JPanel();
		jPanelComponents.setSize(250, 250);
		jPanelComponents.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
		jPanelComponents.setLayout(new GridLayout(7,1,30,10));
		jPanelComponents.add(errorJL);
		jPanelComponents.add(nickNameJL);
		jPanelComponents.add(jTFNickName);
		jPanelComponents.add(passwordJL);		
		jPanelComponents.add(jPFPassword);
		jPanelComponents.add(new JPanel().add(jBlogin));
		jPanelComponents.add(new JLabel());
	
		this.add(imagenJL);
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
		this.errorJL.setText("");
		this.setVisible(false);
	}
	public void incorrectLogin() {
		this.errorJL.setText("La informacion no es correcta");
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new JDLogin(new ControllerClient(), TypeUser.values());
	}
	
	

}