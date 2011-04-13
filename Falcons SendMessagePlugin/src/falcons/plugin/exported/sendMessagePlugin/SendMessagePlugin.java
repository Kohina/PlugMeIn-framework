package falcons.plugin.exported.sendMessagePlugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import falcons.plugin.*;
import falcons.plugin.exported.sendMessagePlugin.model.*;
import falcons.plugin.exported.sendMessagePlugin.view.SendMessageMainPanel;

@Plugin(pluginID = "Send Message", versionID = "0.1")
public class SendMessagePlugin extends AbstractPlugin {

	MessageModel messageModel;
	MessageLogic messageLogic;
	static SendMessageMainPanel mainPanel;

	public SendMessagePlugin() {
		messageModel = new MessageModel();
		messageLogic = new MessageLogic(messageModel);
		mainPanel = SendMessageMainPanel.getInstance(messageModel);
	}

	// Comment the main-method when done with testing.
	/*public static void main(String args[]) {
		SendMessagePlugin p = new SendMessagePlugin();
		JFrame frame = new JFrame();
		frame.getContentPane().add(mainPanel);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}*/

	@Override
	public void receiveCall(PluginCall call) {
		AbstractPluginData data = call.getPluginData();

		if (data.getMethodID().equals("SendMessage")
				&& data.getVersionID()
						.equals(this.getClass().getAnnotation(Plugin.class)
								.versionID())) {
			messageLogic.receiveMessage(((SendMessagePluginData) data)
					.getMessage());
		} else if (!data.getMethodID().equals("SendMessage")
				&& !data.getVersionID()
						.equals(this.getClass().getAnnotation(Plugin.class)
								.versionID())) {
			System.out
					.println("Both the methodID and the versionID is not the same as the plugin sending the call.");
		} else if (!data.getMethodID().equals("SendMessage")) {
			System.out
					.println("There doesn't exist a method with that methodID.");
		} else if (!data.getVersionID().equals(
				this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out
					.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		}

	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}
}
