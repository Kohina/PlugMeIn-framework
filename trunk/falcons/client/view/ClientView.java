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
	
	/**
	 * Adds a new tab
	 * 
	 * @param s - String containing pluginName
	 * @param p - JPanel with pluginContent
	 */
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
	
	/*Panels*/
	private JPanel getWakeOnLanPanel(){
		if(wakeOnLanPanel == null){
			wakeOnLanPanel = new JPanel();
			wakeOnLanPanel.add(getTemp());
			//wakeOnLanPanel.setPreferredSize(new java.awt.Dimension(379, 121));
		}
		return wakeOnLanPanel;
	}
	
	private JPanel getPanel(){
		if(panel == null){
			panel = new JPanel();
			panel.add(getSendMessageTextField());
			panel.add(getSendMessageButton());
		}
		return panel;
	}
}
