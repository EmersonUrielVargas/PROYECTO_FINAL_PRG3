package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

import view.MyJframe;

public class ControllerClient implements ActionListener, ItemListener, KeyListener {
	
	private final int PORT = 24170;
	private final String HOST = "186.114.217.181";
	
	private MyJframe jframe;
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;
	

	public ControllerClient() throws FileNotFoundException, IOException{
		this.socket = new Socket(HOST, PORT);
		this.out = new DataOutputStream(socket.getOutputStream());
		this.in = new DataInputStream(socket.getInputStream());
		loadView();
	}
	
	private void loadView() {
		try {
			String[] dataload = in.readUTF().split("!");
			this.jframe = new MyJframe(dataload[0],this,dataload[1],dataload[2],dataload[3]);
			this.jframe.getMyJMenuBar().setTexts(dataload[4], dataload[5]);
			this.jframe.getPrincipalJPanel().setText(dataload[6], dataload[7],
					dataload[8], dataload[9],dataload[10]);
			this.jframe.getjPanelDiscounts().setTexts(dataload[11],dataload[12],dataload[13]);
			this.jframe.getjPanelCalculate().setTexts(dataload[14],dataload[15], dataload[16]);
			loadList();
		} catch (IOException e) {
			
		}
				
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case AC_JB_SEARCH:
			try {
				out.writeUTF("Search!"+getdataVehicleSelect());
				jframe.getPrincipalJPanel().setTextValue(in.readUTF());
			} catch (IOException e2) {
			
			}
			break;
		case AC_JB_CALCULATE:
			try {
				String valueVehicle = jframe.getPrincipalJPanel().getTxValue();
				Boolean discountEarlier = jframe.getjPanelDiscounts().getCBIsearlyPayment();
				Boolean discountService = jframe.getjPanelDiscounts().getCBIspublic();
				Boolean discountLocal = jframe.getjPanelDiscounts().getCBIslocal();
				String dataToPay = "Calculate!"+valueVehicle+discountEarlier+discountService+discountLocal;
				jframe.getjPanelCalculate().getTxValueToPay().setText(in.readUTF());
			} catch (IOException e1) {
				
			}
			break;
		case AC_JB_CLEAN:
			jframe.getPrincipalJPanel().setTextValue("");
			jframe.getjPanelCalculate().getTxValueToPay().setText("");
			jframe.getjPanelDiscounts().cleanCheckBox();
			break;
			
		case AC_CB_EARLYER:
			
		case AC_CB_LOCAL:
			break;
		case AC_CB_PUBLIC:
			break;
		case AC_MI_HELP:
			break;
		case AC_MI_SETTINGS:
			break;

		default:
			break;
		}
		
	}
	
	private String getdataVehicleSelect() {
		String brand = (String) jframe.getPrincipalJPanel().getTxBrand().getSelectedItem();
		String line = (String) jframe.getPrincipalJPanel().getTxLine().getSelectedItem();
		String model = (String) jframe.getPrincipalJPanel().getTxModel().getSelectedItem();
		return brand+"/"+line+"/"+model;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() ==(this.jframe.getPrincipalJPanel().getTxBrand())) {
			loadLines((String)this.jframe.getPrincipalJPanel().getTxBrand().getSelectedItem());
		}
		if (e.getSource()==(this.jframe.getPrincipalJPanel().getTxLine())) {
			loadModels((String)this.jframe.getPrincipalJPanel().getTxLine().getSelectedItem(),
					  (String)this.jframe.getPrincipalJPanel().getTxBrand().getSelectedItem());
		}
		if (e.getSource()==(this.jframe.getPrincipalJPanel().getTxModel())) {
	
		}
		
	}
	private void loadModels(String brand, String line) {
		try {
			out.writeUTF("LoadModels!"+brand+"/"+line);
			String[] models = in.readUTF().split("/");
			jframe.updateModels(models);
		} catch (IOException e) {
		
		}
		
	}

	private void loadLines(String brand) {
		try {
			out.writeUTF("LoadLines!"+brand);
			Object[] lines = in.readUTF().split("/");
			jframe.updateLines(lines);
		} catch (IOException e) {
			
		}
		
	}
	
	private void UpdateBrands() {
		try {
			Object[] brands = (in.readUTF()).split("/");
			jframe.updateBrands(brands);
		} catch (IOException e) {	
		}
	}
	
	private void UpdateLines() {
		try {
			Object[] lines = (in.readUTF()).split("/");
			jframe.updateBrands(lines);
		} catch (IOException e) {	
		}
	}
	
	private void UpdateModels() {
		try {
			Object[] models = (in.readUTF()).split("/");
			jframe.updateBrands(models);
		} catch (IOException e) {	
		}
	}
	
	private void loadList() {
		UpdateBrands();
		UpdateLines();
		UpdateModels();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
     	new ControllerClient();
	}

}
