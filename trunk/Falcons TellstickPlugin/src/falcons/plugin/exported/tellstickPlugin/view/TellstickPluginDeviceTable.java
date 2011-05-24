package falcons.plugin.exported.tellstickPlugin.view;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.TableView.TableRow;


import falcons.plugin.Pluggable;
import falcons.plugin.exported.pkj.no.tellstick.device.TellstickDevice;

public class TellstickPluginDeviceTable extends JTable implements Pluggable {

	ArrayList<TellstickDevice> devices;
	JTable table;
	
	public TellstickPluginDeviceTable(ArrayList<TellstickDevice> devices) {
		super();
		
		try {
			Object deviceInfo[][] = {{"lol", "lal"}, {"lil", "lyl"}};
			String[] columnNames = {"Namn", "On/Off"};
			
			table = new JTable(deviceInfo, columnNames);
			table.setSize(200, 100);
			
//			TableColumn name = new TableColumn(1);
//			TableColumn onOff = new TableColumn(2);
//			
//			table.addColumn(name);
//			table.addColumn(onOff);
//			
//			for(TellstickDevice device : devices) {
//				addDeviceToArray(deviceInfo, device);
//			}
			
			super.add(table);
			table.repaint();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Method that adds a {@link TellstickDevice} to a multi dimensional array.
	 * @param array The array to add to.
	 * @param device The {@link TellstickDevice} to add.
	 */
	public void addDeviceToArray(Object[][] array, TellstickDevice device) {
		
	}
}