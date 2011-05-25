package falcons.plugin.exported.sendMessagePlugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import falcons.plugin.*;
import falcons.plugin.exported.sendMessagePlugin.controller.SendMessageController;
import falcons.plugin.exported.sendMessagePlugin.model.*;
import falcons.plugin.exported.sendMessagePlugin.view.SendMessageMainPanel;

@Plugin(pluginID = "Send Message", versionID = "0.1")
public class SendMessagePlugin extends AbstractPlugin {

	private MessageModel messageModel;
	private MessageLogic messageLogic;
	private SendMessageMainPanel mainPanel;
	private SendMessageController controller;

	public SendMessagePlugin() {
		messageModel = new MessageModel();
		messageLogic = new MessageLogic(messageModel);
		mainPanel = SendMessageMainPanel.getInstance(messageModel);
		controller = new SendMessageController(mainPanel, messageLogic);
		mainPanel.setController(controller);
	}

	@Override
	public void receiveCall(PluginCall call) {
		String data = (String) call.getPluginData().getData();

		if (call.getPluginData().getMethodID().equals("SendMessage")) {
			controller.receiveMessage(data);
		}

	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}
}
