package falcons.plugin.exported.sendMessagePlugin;

import falcons.plugin.AbstractPluginData;


/**
 * The PluginData associated with the plugin
 * 
 * @author Printz
 * 
 */
public class SendMessagePluginData extends AbstractPluginData{

	private String message;
	
	public SendMessagePluginData(){
		
	}

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