package falcons.plugin.alarmplugin.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.PluginCall;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.plugin.alarmplugin.AlarmPlugin;
import falcons.plugin.alarmplugin.controller.AlarmController;
import falcons.plugin.alarmplugin.model.Alarm;
import falcons.plugin.alarmplugin.model.Clock;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AlarmMainPanel extends javax.swing.JPanel implements
		ActionListener {
	private JList clientList;
	private JLabel formatLabel;
	private JButton setAlarmButton;
	private JTextField dateTextField;
	private AlarmController controller;
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
	private HashMap<String, Long> clientMap;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public AlarmMainPanel(Clock clock, AlarmController controller) {
		super();
		this.controller = controller;
		clientMap = (HashMap<String, Long>) AlarmPlugin.getData(new PluginEvent(PluginEventType.GET_CLIENTS));
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(259, 218));
			GridBagLayout thisLayout = new GridBagLayout();
			this.setSize(177, 116);
			thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
			thisLayout.rowHeights = new int[] { 7, 7, 7, 7 };
			thisLayout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
			thisLayout.columnWidths = new int[] { 7, 7, 7, 7 };
			this.setLayout(thisLayout);
			{
				ListModel clientListModel = new DefaultComboBoxModel(clientMap
						.keySet().toArray());
				clientList = new JList();
				this.add(clientList, new GridBagConstraints(0, 0, 1, 4, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0,
						0));
				clientList.setModel(clientListModel);
			}
			{
				formatLabel = new JLabel();
				this.add(formatLabel, new GridBagConstraints(1, 0, 3, 1, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
						0, 0));
				formatLabel.setText("Input in this way: MM/dd HH:mm");
			}
			{
				dateTextField = new JTextField();
				this.add(dateTextField, new GridBagConstraints(1, 1, 3, 1, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
						0, 0));
				dateTextField.setText("Date and time goes here");
			}
			{
				setAlarmButton = new JButton();
				this.add(setAlarmButton, new GridBagConstraints(2, 3, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				setAlarmButton.setText("Set Alarm");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setAlarmButton) {

			long destination = clientMap
					.get(clientMap.keySet().toArray()[clientList
							.getSelectedIndex()]);
			try {
				HashMap<Date, Alarm> data = new HashMap<Date, Alarm>();
				data.put(sdf.parse(dateTextField.getText()), new Alarm(
						new PluginCall("Alarm", null, destination), false));
				controller.setAlarm(data);
			} catch (ParseException e1) {
				JOptionPane
						.showMessageDialog(null,
								"You need to write the time in this format: MM/dd HH:mm");
				e1.printStackTrace();
			}

		}
	}
}
