package falcons.client.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

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
public class ClientView extends javax.swing.JFrame {
	private JTabbedPane jTabbedPaneMain;
	private JPanel panel, holder, connectionPanel, pluginPanel, wakeOnLanPanel;
	private JTextField sendMessageTextField, IPTextField, temp, portTextField;
	private JLabel portLabel, IPLabel, autoCon;
	private JButton sendMessageButton, connectButton;
	private JCheckBox autoConnect = new JCheckBox();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ClientView inst = new ClientView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ClientView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{	
				UIManager.put("TabbedPane.selected", new Color(218,218,218));

				jTabbedPaneMain = new JTabbedPane();
				jTabbedPaneMain.setTabPlacement(JTabbedPane.LEFT);
				jTabbedPaneMain.setBackground(new Color(190,190,190));
				
				getContentPane().add(jTabbedPaneMain, BorderLayout.CENTER);
				
				addTab("Send Message", getPanel());
				addTab("Wake on lan", getWakeOnLanPanel());
				
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void addTab(String s, JPanel p){
		jTabbedPaneMain.addTab("<html><body marginwidth=5 marginheight=5>" + s + "</body></html>", p);
	}
	
	/*Buttons*/
	private JButton getSendMessageButton() {
		if(sendMessageButton == null) {
			sendMessageButton = new JButton();
			sendMessageButton.setSize(200, 100);
			sendMessageButton.setText("Send");
		}
		return sendMessageButton;
	}
	
	private JButton getConnectButton() {
		if(connectButton == null) {
			connectButton = new JButton();
			connectButton.setSize(200, 100);
			connectButton.setText("Connect");
			connectButton.setPreferredSize(new java.awt.Dimension(59, 19));
		}
		return connectButton;
	}
	
	/*TextFields*/
	private JTextField getTemp() {
		if(temp == null) {
			temp = new JTextField();
			temp.setText("temp");
			temp.setPreferredSize(new Dimension(250,210));
		}
		return temp;
	}
	
	private JTextField getSendMessageTextField() {
		if(sendMessageTextField == null) {
			sendMessageTextField = new JTextField();
			sendMessageTextField.setPreferredSize(new Dimension(250,210));
			sendMessageTextField.setText("test");
		}
		return sendMessageTextField;
	}
	
	private JTextField getPortTextField() {
		if(portTextField == null) {
			portTextField = new JTextField();
			portTextField.setPreferredSize(new java.awt.Dimension(50, 23));
		}
		return portTextField;
	}

	private JTextField getIPTextField() {
		if(IPTextField == null) {
			IPTextField = new JTextField();
			IPTextField.setPreferredSize(new java.awt.Dimension(230, 23));
		}
		return IPTextField;
	}
	
	/*Panels*/
	private JPanel getWakeOnLanPanel(){
		if(wakeOnLanPanel == null){
			wakeOnLanPanel = new JPanel();
			wakeOnLanPanel.add(getTemp());
			//wakeOnLanPanel.setPreferredSize(new java.awt.Dimension(379, 121));
		}
		return wakeOnLanPanel;
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
			connectionPanel.add(getPortLabel(), c);
			c.gridx = 1;
			c.gridy = 1;
			connectionPanel.add(getPortTextField(), c);
			c.gridx = 2;
			c.gridy = 1;
			connectionPanel.add(getAutoCon(), c);
			c.gridx = 3;
			c.gridy = 1;
			connectionPanel.add(autoConnect, c);
			c.gridx = 3;
			c.gridy = 2;
			connectionPanel.add(getConnectButton(), c);
			
			connectionPanel.setPreferredSize(new java.awt.Dimension(379, 121));
		}
		return connectionPanel;
	}
	
	private JPanel getPluginPanel() {
		if(pluginPanel == null) {
			pluginPanel = new JPanel();
			TitledBorder title = BorderFactory.createTitledBorder("Plugins");
			pluginPanel.setBorder(title);
		}
		return pluginPanel;
	}
	
	private JPanel getHolder(){
		if(holder == null){
			holder = new JPanel(new GridLayout(2,1));
			holder.add(getConnectionPanel());
			holder.add(getPluginPanel());
		}
		return holder;
	}
	
	private JPanel getPanel(){
		if(panel == null){
			panel = new JPanel();
			panel.add(getSendMessageTextField());
			panel.add(getSendMessageButton());
		}
		return panel;
	}
	
	/*Labels*/
	private JLabel getIPLabel() {
		if(IPLabel == null) {
			IPLabel = new JLabel();
			IPLabel.setText("IP-adress: ");
			IPLabel.setPreferredSize(new java.awt.Dimension(60, 16));
		}
		return IPLabel;
	}
	
	private JLabel getPortLabel() {
		if(portLabel == null) {
			portLabel = new JLabel();
			portLabel.setText("Port: ");
		}
		return portLabel;
	}
	
	private JLabel getAutoCon() {
		if(autoCon == null) {
			autoCon = new JLabel();
			autoCon.setText(" Auto connect");
		}
		return autoCon;
	}
}
