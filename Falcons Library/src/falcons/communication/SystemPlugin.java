package falcons.communication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.PluginCall;
import falcons.server.model.ConnectionModel;
import falcons.server.network.ConnectionThread;

public class SystemPlugin implements Serializable {
	private class SystemPluginData<E> extends AbstractPluginData {

		private E data;

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
		public SystemPluginData(String methodID, String versionID, E data) {
			super(methodID, versionID);
			this.data = data;
		}

		public E getData() {
			return data;
		}

	}
	
	private static SystemPlugin instance = new SystemPlugin();
	List<Long> clients;
	HashMap<String, String> plugins;
	
	private SystemPlugin() {
		
	}
	
	public SystemPlugin getInstance() {
		return instance;
	}
	
	public void updateClients() {
		// TODO Somehow sync the list of clients with the list of connections.
	}
	
	public void sendClients(long id) {
		updateClients();
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new SystemPluginData<List<Long>>("getClients", "SystemPlugin", clients), id));
	}
}
