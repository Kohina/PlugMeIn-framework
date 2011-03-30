package client.view;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

import javax.swing.WindowConstants;
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
public class ClientView extends javax.swing.JFrame {
	private JTabbedPane jTabbedPaneOut, jTabbedPaneIn;

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
				jTabbedPaneOut = new JTabbedPane();
				jTabbedPaneIn = new JTabbedPane();
				jTabbedPaneIn.setTabPlacement(JTabbedPane.LEFT);
				getContentPane().add(jTabbedPaneOut, BorderLayout.CENTER);
				getContentPane().add(jTabbedPaneIn, BorderLayout.CENTER);
				jTabbedPaneIn.addTab("Send Message", component);
				jTabbedPaneIn.addTab("Wake on lan", component);
				jTabbedPaneOut.addTab("Main", jTabbedPaneIn);
				jTabbedPaneOut.addTab("Connection", component);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
