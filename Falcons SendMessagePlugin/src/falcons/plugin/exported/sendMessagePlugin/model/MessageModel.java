package falcons.plugin.exported.sendMessagePlugin.model;

import java.util.Observable;
import java.util.Observer;

import falcons.plugin.Pluggable;

public class MessageModel extends Observable implements Pluggable {

	private String receivedMessage;

	public MessageModel() {
		// Do nasing...
	}

	void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
		notifyObservers();
	}

	public String getReceivedMessage() {
		return new String(receivedMessage);
	}

}
