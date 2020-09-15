package views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import controller.ControllerClient;

public class JCBBaseComboBox extends JComboBox<Object>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JCBBaseComboBox(ControllerClient controller,Object[] list) {
		this.addItemListener(controller);
		this.setModel(new DefaultComboBoxModel<>(list));
	}
	
	
	public JCBBaseComboBox(ControllerClient controller) {
		this.addItemListener(controller);
	}
	
	public void updateList(Object[] list) {
		this.setModel(new DefaultComboBoxModel<>(list));
	}
	
	
	
}