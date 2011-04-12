package falcons.plugin.exported.sendMessagePlugin.model;

import java.util.Observable;
import java.util.Observer;

public class MessageModel extends Observable {

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
