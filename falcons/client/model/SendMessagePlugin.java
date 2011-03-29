package falcons.client.model;

import javax.swing.JOptionPane;

import falcons.client.abstractions.AbstractPlugin;
import falcons.client.abstractions.AbstractPluginData;
import falcons.client.network.PluginCall;

//This is not supposed to exist here. TODO
public class SendMessagePlugin extends AbstractPlugin {
	
	/**
	 * The PluginData associated with the plugin
	 * @author Printz
	 *
	 */
	class SendMessagePluginData extends AbstractPluginData{
		
		private String message;
		
		/**
		 * Constructor for the PluginData
		 * @param methodID "SendMessage" - the ID of the method to be used
		 * @param versionID The ID of the plugin version
		 * @param message The message to be sent.
		 */
		public SendMessagePluginData(String methodID, String versionID, String message) {
			super(methodID, versionID);
			this.message = message;
		}
		
		public String getMessage(){
			return message;
		}
		
	}

	@Override
	public void receiveCall(PluginCall call) {
		AbstractPluginData data = call.getPluginData();
		
		if(data.getMethodID().equals("SendMessage")){
			JOptionPane.showMessageDialog(null, ((SendMessagePluginData)data).getMessage());
		}

	}

}
