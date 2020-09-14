package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import controller.ControllerClient;

public class JComboBoxBase extends JComboBox{
	
	public JComboBoxBase(ControllerClient controller,Object[] list) {
		this.addItemListener(controller);
		this.setModel(new DefaultComboBoxModel<>(list));
	}
	
	
	public JComboBoxBase(ControllerClient controller) {
		this.addItemListener(controller);
	}
	
	public void updateList(Object[] list) {
		this.setModel(new DefaultComboBoxModel<>(list));
	}
	
	
	
}
