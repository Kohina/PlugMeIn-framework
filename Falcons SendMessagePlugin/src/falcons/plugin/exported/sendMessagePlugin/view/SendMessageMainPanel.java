package falcons.plugin.exported.sendMessagePlugin.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.sendMessagePlugin.controller.SendMessageController;
import falcons.plugin.exported.sendMessagePlugin.model.MessageModel;


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
public class SendMessageMainPanel extends JPanel implements Observer, Pluggable{
	
	private static SendMessageMainPanel instance = null;
	private JButton sendMessageButton;
	private JTextField messageTextField;
	private MessageModel model;
	private JLabel receivedMessageLabel;
	
	public SendMessageMainPanel(){
		
	}

	private SendMessageMainPanel(MessageModel model){
		this.model = model;
		model.addObserver(this);
		initGUI();
		setVisible(true);
	}

	public static SendMessageMainPanel getInstance(MessageModel model){
		if(instance == null){
			instance = new SendMessageMainPanel(model);
		}
		return instance;
	}
	
	private void initGUI() {
		try {
			{
				GridBagLayout thisLayout = new GridBagLayout();
				this.setPreferredSize(new java.awt.Dimension(177, 116));
				thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				thisLayout.rowHeights = new int[] {7, 7, 7, 7};
				thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				thisLayout.columnWidths = new int[] {7, 7, 7, 7};
				this.setLayout(thisLayout);
				this.add(getMessageTextField(), new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				this.add(getSendMessageButton(), new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				sendMessageButton.addActionListener(new SendMessageController(this));
				this.add(getReceivedMessageLabel(), new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private JTextField getMessageTextField() {
		if(messageTextField == null) {
			messageTextField = new JTextField();
			messageTextField.setText("Write your message here...");
		}
		return messageTextField;
	}
	
	private JButton getSendMessageButton() {
		if(sendMessageButton == null) {
			sendMessageButton = new JButton();
			sendMessageButton.setText("Send");
		}
		return sendMessageButton;
	}
	
	private JLabel getReceivedMessageLabel() {
		if(receivedMessageLabel == null) {
			receivedMessageLabel = new JLabel();
			receivedMessageLabel.setText("Received message:");
		}
		return receivedMessageLabel;
	}

	public String getSendMessageText(){
		return messageTextField.getText();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == model){
			receivedMessageLabel.setText("Received message: " + model.getReceivedMessage());
		}
	}
}