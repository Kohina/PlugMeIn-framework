package falcons.plugin.exported.sendMessagePlugin.model;

import java.io.Serializable;

import falcons.plugin.Pluggable;

public class MessageLogic implements Pluggable, Serializable {

	MessageModel model;

	public MessageLogic(){

	}

	public MessageLogic(MessageModel model) {
		this.model = model;
	}

	public void receiveMessage(String message) {
		model.setReceivedMessage(message);
	}
}
