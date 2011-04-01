package falcons.client.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;

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
	private JTabbedPane jTabbedPaneOut, jTabbedPaneMain;
	private JTextField sendMessageTextField;
	private JPanel panel;
	private JPanel connectionPanel;
	private JTextField temp;
	private JButton sendMessageButton;

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
				
				panel = new JPanel();
				panel.add(getSendMessageTextField());
				panel.add(getSendMessageButton());

				jTabbedPaneOut = new JTabbedPane();
				jTabbedPaneMain = new JTabbedPane();
				jTabbedPaneMain.setTabPlacement(JTabbedPane.LEFT);
				getContentPane().add(jTabbedPaneOut, BorderLayout.CENTER);
				getContentPane().add(getConnectionPanel(), BorderLayout.NORTH);
				getContentPane().add(jTabbedPaneMain, BorderLayout.CENTER);
				jTabbedPaneMain.addTab("Send Message", panel);
				jTabbedPaneMain.addTab("Wake on lan", getTemp());

				jTabbedPaneOut.addTab("Main", jTabbedPaneMain);
				jTabbedPaneOut.addTab("Connection", getConnectionPanel());
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JButton getSendMessageButton() {
		if(sendMessageButton == null) {
			sendMessageButton = new JButton();
			sendMessageButton.setSize(200, 100);
			sendMessageButton.setText("Send");
		}
		return sendMessageButton;
	}
	
	private JTextField getTemp() {
		if(temp == null) {
			temp = new JTextField();
			temp.setText("temp");
		}
		return temp;
	}
	private JTextField getSendMessageTextField() {
		if(sendMessageTextField == null) {
			sendMessageTextField = new JTextField();
			sendMessageTextField.setPreferredSize(new java.awt.Dimension(285, 190));
			sendMessageTextField.setText("test");
		}
		return sendMessageTextField;
	}
	
	private JPanel getConnectionPanel() {
		if(connectionPanel == null) {
			connectionPanel = new JPanel();
			TitledBorder title = BorderFactory.createTitledBorder("Server connection");
			connectionPanel.setBorder(title);
		}
		return connectionPanel;
	}
}
