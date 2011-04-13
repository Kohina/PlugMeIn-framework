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
		 *            The ID of the method to be used
		 * @param versionID
		 *            The ID of the plugin version
		 * @param data
		 *            The data to be sent.
		 */
		public SystemPluginData(String methodID, String versionID, E data) {
			super(methodID, versionID);
			this.data = data;
		}

		/**
		 * @return The data sent in the call.
		 */
		public E getData() {
			return data;
		}

	}
	
	private static SystemPlugin instance = new SystemPlugin();
	private List<Long> clients;
	private HashMap<String, String> plugins;
	
	private SystemPlugin() {
		// Do Nasing
	}
	
	/**
	 * @return The only instance of this class.
	 */
	public SystemPlugin getInstance() {
		return instance;
	}
	
	public void updateClients() {
		// TODO Somehow sync the local List of clients with the ConnectionModel's list of connections.
	}
	
	public void updatePlugins() {
		// TODO Somehow sync the local HashMap of plugins with the ServerModel's list.
	}
	
	public void sendClients(long id) {
		updateClients();
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new SystemPluginData<List<Long>>("getClients", "SystemPlugin", clients), id));
	}
	
	public void sendPlugins(long id) {
		updatePlugins();
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new SystemPluginData<HashMap<String, String>>("getPlugins", "SystemPlugin", plugins), id));
	}
}
