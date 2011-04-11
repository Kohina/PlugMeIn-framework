package falcons.client.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class ConnectionView extends javax.swing.JFrame {
	private JPanel holder, connectionPanel, pluginPanel;
	private JLabel IPLabel, portLabel, autoConLabel;
	private JTextField IPTextField, portTextField;
	private JButton connectButton;
	private JCheckBox autoConnect = new JCheckBox();
	
	public ConnectionView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
			getContentPane().add(getHolder(), BorderLayout.CENTER);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/*Panels*/
	private JPanel getHolder(){
		if(holder == null){
			holder = new JPanel(new GridLayout(2,1));
			holder.add(getConnectionPanel());
			holder.add(getPluginPanel());
		}
		return holder;
	}

	private JPanel getPluginPanel() {
		if(pluginPanel == null) {
			pluginPanel = new JPanel();
			TitledBorder title = BorderFactory.createTitledBorder("Plugins");
			pluginPanel.setBorder(title);
		}
		return pluginPanel;
	}

	
	private JPanel getConnectionPanel() {
		if(connectionPanel == null) {
			connectionPanel = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			
			TitledBorder title = BorderFactory.createTitledBorder("Server connection");
			connectionPanel.setBorder(title);
			
			c.gridx = 0;
			c.gridy = 0;
			connectionPanel.add(getIPLabel(), c);
			c.gridx = 1;
			c.gridy = 0;
			c.gridwidth = 3;
			connectionPanel.add(getIPTextField(), c);
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.insets = new Insets(0,20,0,0);
			connectionPanel.add(getPortLabel(), c);
			c.gridx = 1;
			c.gridy = 1;
			c.insets = new Insets(0,0,0,0);
			connectionPanel.add(getPortTextField(), c);
			c.gridx = 2;
			c.gridy = 1;
			c.insets = new Insets(0,25,0,0);
			connectionPanel.add(getAutoConLabel(), c);
			c.gridx = 3;
			c.gridy = 1;
			c.insets = new Insets(0,5,0,0);
			connectionPanel.add(autoConnect, c);
			c.gridx = 2;
			c.gridy = 2;
			c.gridwidth = 2;
			c.insets = new Insets(0,65,0,0);
			connectionPanel.add(getConnectButton(), c);
			
			connectionPanel.setPreferredSize(new java.awt.Dimension(379, 121));
		}
		return connectionPanel;
	}
	
	/*Buttons*/
	private JButton getConnectButton() {
		if(connectButton == null) {
			connectButton = new JButton();
			connectButton.setText("Connect");
			connectButton.setPreferredSize(new java.awt.Dimension(85, 19));
		}
		return connectButton;
	}
	
	/*Labels*/
	private JLabel getAutoConLabel() {
		if(autoConLabel == null) {
			autoConLabel = new JLabel();
			autoConLabel.setText("       Auto connect:");
		}
		return autoConLabel;
	}
	private JLabel getIPLabel() {
		if(IPLabel == null) {
			IPLabel = new JLabel();
			IPLabel.setText("IP-adress: ");
			IPLabel.setPreferredSize(new java.awt.Dimension(70, 16));
		}
		return IPLabel;
	}
	
	private JLabel getPortLabel() {
		if(portLabel == null) {
			portLabel = new JLabel();
			portLabel.setText("Port: ");
			portLabel.setPreferredSize(new java.awt.Dimension(30, 16));
		}
		return portLabel;
	}
	
	/*TextFileds*/
	private JTextField getIPTextField() {
		if(IPTextField == null) {
			IPTextField = new JTextField();
			IPTextField.setPreferredSize(new java.awt.Dimension(200, 23));
		}
		return IPTextField;
	}
	
	private JTextField getPortTextField() {
		if(portTextField == null) {
			portTextField = new JTextField();
			portTextField.setPreferredSize(new java.awt.Dimension(50, 23));
		}
		return portTextField;
	}
}
