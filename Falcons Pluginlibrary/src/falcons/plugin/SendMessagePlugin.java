package falcons.plugin;

import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import falcons.plugin.PluginCall;


//This is not supposed to exist here. TODO
@Plugin(description = "Send Message")
public class SendMessagePlugin extends AbstractPlugin {

	private String pluginID = "SendMessagePlugin";
	private String versionID = "0.1";

	/**
	 * The PluginData associated with the plugin
	 * 
	 * @author Printz
	 * 
	 */
	private class SendMessagePluginData extends AbstractPluginData {

		private String message;

		/**
		 * Constructor for the PluginData
		 * 
		 * @param methodID
		 *            "SendMessage" - the ID of the method to be used
		 * @param versionID
		 *            The ID of the plugin version
		 * @param message
		 *            The message to be sent.
		 */
		public SendMessagePluginData(String methodID, String versionID,
				String message) {
			super(methodID, versionID);
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

	}

	private class SendMessagePanel extends JPanel{
		
		private JTextField sendMessageTextField;
		private JButton sendMessageButton;
		private JPanel panel;
		
		private SendMessagePanel(){
			getPanel();
		}
		
		private JTextField getSendMessageTextField() {
			if(sendMessageTextField == null) {
				sendMessageTextField = new JTextField();
				sendMessageTextField.setPreferredSize(new Dimension(250,210));
				sendMessageTextField.setText("test");
			}
			return sendMessageTextField;
		}
		
		private JPanel getPanel(){
			if(panel == null){
				panel = new JPanel();
				panel.add(getSendMessageTextField());
				panel.add(getSendMessageButton());
			}
			return panel;
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
	
	public void receiveMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void sendMessage(long id) {
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall(this, getSendMessagePluginData(), id));
	}

	// TODO Should take a string as a parameter and use this as the message.
	public AbstractPluginData getSendMessagePluginData() {
		return new SendMessagePluginData("SendMessage", versionID,
				JOptionPane.showInputDialog("What do you want to send?"));
	}

	public JPanel getSendMessagePanel(){
		return new SendMessagePanel();
	}
	
	@Override
	public void receiveCall(PluginCall call) {
		AbstractPluginData data = call.getPluginData();

		if (data.getMethodID().equals("SendMessage")
				&& data.getVersionID().equals(versionID)) {
			receiveMessage(((SendMessagePluginData) data).getMessage());
		} else if (!data.getMethodID().equals("SendMessage")
				&& !data.getVersionID().equals(versionID)) {
			System.out
					.println("Both the methodID and the versionID is not the same as the plugin sending the call.");
		} else if (!data.getMethodID().equals("SendMessage")) {
			System.out
					.println("There doesn't exist a method with that methodID.");
		} else if (!data.getVersionID().equals(versionID)) {
			System.out
					.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		}

	}

	@Override
	public String getPluginID() {
		return pluginID;
	}

	@Override
	public String getVersionID() {
		return versionID;
	}

	@Override
	public JPanel getMainPanel() {
		return getSendMessagePanel();
	}

}
