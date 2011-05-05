package falcons.plugin.exported.sendMessagePlugin.model;

public class MessageLogic {

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
