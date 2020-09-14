package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import controller.ControllerClient;

public class JCBaseComboBox extends JComboBox{
	
	public JCBaseComboBox(ControllerClient controller,Object[] list) {
		this.addItemListener(controller);
		this.setModel(new DefaultComboBoxModel<>(list));
	}
	
	
	public JCBaseComboBox(ControllerClient controller) {
		this.addItemListener(controller);
	}
	
	public void updateList(Object[] list) {
		this.setModel(new DefaultComboBoxModel<>(list));
	}
	
	
	
}
