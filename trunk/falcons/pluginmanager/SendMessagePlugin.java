package falcons.pluginmanager;

import javax.swing.JOptionPane;

import falcons.client.abstractions.AbstractPlugin;
import falcons.client.abstractions.AbstractPluginData;
import falcons.client.network.PluginCall;

//This is not supposed to exist here. TODO
public class SendMessagePlugin extends AbstractPlugin {

	private String pluginID = "SendMessagePlugin";
	private String versionID = "0.1";

	/**
	 * The PluginData associated with the plugin
	 * 
	 * @author Printz
	 * 
	 */
	class SendMessagePluginData extends AbstractPluginData {

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

	@Override
	public void receiveCall(PluginCall call) {
		AbstractPluginData data = call.getPluginData();

		if (data.getMethodID().equals("SendMessage")
				&& data.getVersionID().equals(versionID)) {
			JOptionPane.showMessageDialog(null,
					((SendMessagePluginData) data).getMessage());
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

}
