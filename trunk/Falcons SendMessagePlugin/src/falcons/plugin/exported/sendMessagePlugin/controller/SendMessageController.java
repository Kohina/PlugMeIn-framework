package falcons.plugin.exported.sendMessagePlugin.controller;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.sendMessagePlugin.SendMessagePlugin;
import falcons.plugin.exported.sendMessagePlugin.model.MessageLogic;
import falcons.plugin.exported.sendMessagePlugin.view.SendMessageMainPanel;

public class SendMessageController implements Pluggable {
	
	private SendMessageMainPanel view;
	private MessageLogic logic;
	
	public SendMessageController(){
	}

	public SendMessageController(SendMessageMainPanel view, MessageLogic logic) {
		this.view = view;
		this.logic = logic;
	}
	
	public void sendMessage(String data) {
		AbstractPluginData<String> pluginData = new AbstractPluginData<String>("SendMessage", "0.1", data);
		PluginCall call = new PluginCall("Send Message", pluginData, -1L);
		SendMessagePlugin.send(call);
	}
	
	public void receiveMessage(String message){
		logic.receiveMessage(message);
	}
}
