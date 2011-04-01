package falcons.client.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

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
				
				sendMessageTextField = new JTextField();
				sendMessageTextField.setText("test");
				sendMessageTextField.setPreferredSize(new java.awt.Dimension(285, 190));
				
				panel = new JPanel();
				panel.setAlignmentX(LEFT_ALIGNMENT);
				panel.add(sendMessageTextField);
				panel.add(getSendMessageButton());

				jTabbedPaneOut = new JTabbedPane();
				jTabbedPaneMain = new JTabbedPane();
				jTabbedPaneMain.setTabPlacement(JTabbedPane.LEFT);
				getContentPane().add(jTabbedPaneOut, BorderLayout.CENTER);
				getContentPane().add(jTabbedPaneMain, BorderLayout.CENTER);
				jTabbedPaneMain.addTab("Send Message", panel);
				jTabbedPaneMain.addTab("Wake on lan", comp);
				
				jTabbedPaneOut.addTab("Main", jTabbedPaneMain);
				jTabbedPaneOut.addTab("Connection", comp);
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

}
