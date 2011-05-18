package falcons.plugin.exported.tellstickPlugin.view;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.TableView.TableRow;

import org.eclipse.swt.widgets.TableItem;

import pkj.no.tellstick.device.TellstickDevice;

import falcons.plugin.Pluggable;

public class TellstickPluginDeviceTable extends JTable implements Pluggable {

	ArrayList<TellstickDevice> devices;
	JTable table;
	
	public TellstickPluginDeviceTable(ArrayList<TellstickDevice> devices) {
		super();
		
		try {
			table = new JTable();
			table.setSize(200, 100);
			
			TableColumn name = new TableColumn(1);
			TableColumn onOff = new TableColumn(2);
			
			table.addColumn(name);
			table.addColumn(onOff);
			
			for(TellstickDevice device : devices) {
				addDeviceToTable(table, device);
			}
			
			table.repaint();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Method that adds a {@link TellstickDevice} to a JTable.
	 * @param table The table to add the row to.
	 * @param device The {@link TellstickDevice} to add.
	 */
	public void addDeviceToTable(JTable table, TellstickDevice device) {
		
	}
}
