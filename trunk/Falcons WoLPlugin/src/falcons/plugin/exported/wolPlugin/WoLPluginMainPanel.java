package falcons.plugin.exported.wolPlugin;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.com.cloudgarden.layout.AnchorConstraint;
import falcons.plugin.exported.com.cloudgarden.layout.AnchorLayout;

import java.awt.Dimension;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
public class WoLPluginMainPanel extends javax.swing.JPanel implements Pluggable {
	private JLabel ipAdrLabel;
	private JLabel macAdrLabel;
	private JTextField macAdrStr;
	private JButton wakeUpButton;
	private JTextField ipAdrStr;
	private static WoLPluginMainPanel instance;

	public WoLPluginMainPanel() {
		// Do nasing...
	}
		
	private WoLPluginMainPanel(WoLPlugin mainPlugin) {
		super();
		initGUI();
		wakeUpButton.addActionListener(mainPlugin);
		setVisible(true);
	}
	
	public static WoLPluginMainPanel getInstance(WoLPlugin mainPlugin) {
		if(instance == null)
			instance = new WoLPluginMainPanel(mainPlugin);
		return instance;
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				wakeUpButton = new JButton();
				this.add(wakeUpButton, new AnchorConstraint(231, 696, 305, 523, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				wakeUpButton.setText("Wake Up!");
			}
			{
				macAdrStr = new JTextField();
				this.add(getMacAdrStr(), new AnchorConstraint(138, 678, 211, 271, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				macAdrStr.setPreferredSize(new java.awt.Dimension(163, 22));
			}
			{
				ipAdrStr = new JTextField();
				this.add(getIpAdrStr(), new AnchorConstraint(45, 678, 118, 271, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				ipAdrStr.setPreferredSize(new java.awt.Dimension(163, 22));
			}
			{
				macAdrLabel = new JLabel();
				this.add(macAdrLabel, new AnchorConstraint(135, 241, 208, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				macAdrLabel.setText("MAC-address:");
				macAdrLabel.setPreferredSize(new java.awt.Dimension(84, 22));
			}
			{
				ipAdrLabel = new JLabel();
				this.add(ipAdrLabel, new AnchorConstraint(41, 241, 115, 71, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				ipAdrLabel.setText("IP-address:");
				ipAdrLabel.setPreferredSize(new java.awt.Dimension(68, 22));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JTextField getIpAdrStr() {
		return ipAdrStr;
	}
	
	public JTextField getMacAdrStr() {
		return macAdrStr;
	}

	public JButton getWakeUpButton() {
		return wakeUpButton;
	}
}
