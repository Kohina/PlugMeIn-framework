package falcons.client.impl.view;

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
				this.setIconImage(new ImageIcon("http://i.imgur.com/Q19tq.png").getImage());
				UIManager.put("TabbedPane.selected", new Color(218,218,218));

				jTabbedPaneMain = new JTabbedPane();
				jTabbedPaneMain.setTabPlacement(JTabbedPane.LEFT);
				jTabbedPaneMain.setBackground(new Color(190,190,190));
				
				getContentPane().add(jTabbedPaneMain, BorderLayout.CENTER);				
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
	
	/*TextFields*/
	private JTextField getTemp() {
		if(temp == null) {
			temp = new JTextField();
			temp.setText("temp");
			temp.setPreferredSize(new Dimension(250,210));
		}
		return temp;
	}
}
