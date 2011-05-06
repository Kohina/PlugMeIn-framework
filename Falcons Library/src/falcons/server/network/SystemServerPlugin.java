package falcons.server.network;

import java.io.Serializable;
import java.util.*;

import falcons.plugin.*;
import falcons.server.model.*;

@Plugin(pluginID = "SystemPlugin", versionID = "1.0")
public class SystemServerPlugin implements Serializable {
	
	private static SystemServerPlugin instance = new SystemServerPlugin();
	private Set<Long> clients;
	private HashMap<String, String> plugins;
	private PluginLogic pluginLogic;
	
	private SystemServerPlugin() {
		clients = new HashSet<Long>();
		plugins = new HashMap<String, String>();
		pluginLogic = PluginLogic.getInstance();
	}
	
	/**
	 * @return The only instance of this class.
	 */
	public SystemServerPlugin getInstance() {
		return instance;
	}
	
/*	public void receiveCall(PluginCall call) {
		AbstractPluginData data = call.getPluginData();
		
		if (data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			if(data.getMethodID().equals("receivePlugins")) {
				// TODO Do something with the list of plugins.
			} else if(data.getMethodID().equals("receiveClients")) {
				receiveClients((AbstractPluginData<Set<Long>>) call.getPluginData().getData());
			} else {
				System.out.println("The methodID does not exist.");
			}
		} else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		} else {
			System.out.println("The method ID doesn't exist.");
		}
	}
*/
	
	private void updateClients() {
		Object[] connectionSet = ConnectionModel.getInstance().getConnectionList().toArray();
		List<Long> currentIDs = new LinkedList<Long>();
		
		for(Object o : connectionSet) {
			ConnectionThread connection = (ConnectionThread) o;
			clients.add(connection.getId());
			currentIDs.add(connection.getId());
		}
		
		clients.retainAll(currentIDs);
	}
	
	private void updatePlugins() {
		Object[] nameSet = pluginLogic.getPluginMap().keySet().toArray();
		
		for(Object o : nameSet){
			String pluginName = o.toString();
			String pluginVersion = pluginLogic.getPluginMap().get(pluginName).getClass().getAnnotation(Plugin.class).versionID();
			plugins.put(pluginName, pluginVersion);
		}
		
		nameSet = plugins.keySet().toArray();
		
		for(Object o : nameSet) {
			String pluginName = o.toString();
			
			if(!pluginLogic.getPluginMap().containsKey(pluginName)) {
				plugins.remove(pluginName);
			}
		}
	}
	
	public void sendClients(long id) {
		updateClients();
		// TODO Move the updateClients() call to where we actually update the List of connections to increase efficiency.
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new AbstractPluginData<Set<Long>>("receiveClients", "SystemPlugin", clients), id));
	}
	
	public void sendPlugins(long id) {
		updatePlugins();
		// TODO Move the updatePlugins() call to where we actually update the HashMap of loaded Plugins to increase efficiency.
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new AbstractPluginData<HashMap<String, String>>("receivePlugins", "SystemPlugin", plugins), id));
	}
}
