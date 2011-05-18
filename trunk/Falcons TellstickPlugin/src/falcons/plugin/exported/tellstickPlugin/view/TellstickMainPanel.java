package falcons.plugin.exported.tellstickPlugin.view;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class TellstickMainPanel extends javax.swing.JFrame {
	private JLabel TellstickPluginHeaderLabel;
	private JTable TellstickPluginDeviceList;
	private JButton TellstickPluginGetDevicesButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TellstickMainPanel inst = new TellstickMainPanel();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TellstickMainPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				TellstickPluginHeaderLabel = new JLabel();
				getContentPane().add(TellstickPluginHeaderLabel);
				TellstickPluginHeaderLabel.setText("Tellstick Plugin");
				TellstickPluginHeaderLabel.setBounds(12, 12, 85, 15);
			}
			{
				TellstickPluginGetDevicesButton = new JButton();
				getContentPane().add(TellstickPluginGetDevicesButton);
				TellstickPluginGetDevicesButton.setText("Get devices");
				TellstickPluginGetDevicesButton.setBounds(12, 33, 81, 22);
			}
			{
				TableModel TellstickPluginDeviceListModel = 
					new DefaultTableModel(
							new String[][] { { "Device One Name", getContentPane().add(TellstickPluginGetDevicesButton) }, { "Three", "Four" } },
							new String[] { "Column 1", "Column 2" });
				TellstickPluginDeviceList = new JTable();
				getContentPane().add(TellstickPluginDeviceList);
				TellstickPluginDeviceList.setModel(TellstickPluginDeviceListModel);
				TellstickPluginDeviceList.setBounds(12, 66, 366, 53);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
