package falcons.communication;

import java.io.Serializable;
import java.util.*;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.pluginmanager.PluginModel;
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
	private Set<Long> clients;
	private HashMap<String, String> plugins;
	private PluginModel pluginModel;
	
	private SystemPlugin() {
		clients = new HashSet<Long>();
		plugins = new HashMap<String, String>();
		pluginModel = PluginModel.getInstance();
	}
	
	/**
	 * @return The only instance of this class.
	 */
	public SystemPlugin getInstance() {
		return instance;
	}
	
	public void updateClients() {
		Object[] connectionSet = ConnectionModel.getInstance().getConnectionList().toArray();
		List<Long> currentIDs = new LinkedList<Long>();
		
		for(Object o : connectionSet) {
			ConnectionThread connection = (ConnectionThread) o;
			clients.add(connection.getId());
			currentIDs.add(connection.getId());
		}
		
		clients.retainAll(currentIDs);
	}
	
	public void updatePlugins() {
		Object[] nameSet = pluginModel.getPluginMap().keySet().toArray();
		
		for(Object o : nameSet){
			String pluginName = o.toString();
			String pluginVersion = pluginModel.getPluginMap().get(pluginName).getClass().getAnnotation(Plugin.class).versionID();
			plugins.put(pluginName, pluginVersion);
		}
		
		nameSet = plugins.keySet().toArray();
		
		for(Object o : nameSet) {
			String pluginName = o.toString();
			
			if(!pluginModel.getPluginMap().containsKey(pluginName)) {
				plugins.remove(pluginName);
			}
		}
	}
	
	public void sendClients(long id) {
		updateClients();
		// TODO Move the updateClients() call to where we actually update the List of connections to increase efficiency.
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new SystemPluginData<Set<Long>>("getClients", "SystemPlugin", clients), id));
	}
	
	public void sendPlugins(long id) {
		updatePlugins();
		// TODO Move the updatePlugins() call to where we actually update the HashMap of loaded Plugins to increase efficiency.
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new SystemPluginData<HashMap<String, String>>("getPlugins", "SystemPlugin", plugins), id));
	}
}
