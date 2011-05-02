package falcons.client.network;

import java.io.Serializable;
import java.util.*;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.pluginmanager.PluginModel;
import falcons.server.network.ConnectionThread;

@Plugin(pluginID = "SystemPlugin", versionID = "1.0")
public class SystemClientPlugin implements Serializable {
	
	private static SystemClientPlugin instance = new SystemClientPlugin();
	private Set<Long> clients;
	private HashMap<String, String> plugins;
	private PluginModel pluginModel;
	
	private SystemClientPlugin() {
		clients = new HashSet<Long>();
		plugins = new HashMap<String, String>();
		pluginModel = PluginModel.getInstance();
	}
	
	/**
	 * @return The only instance of this class.
	 */
	public SystemClientPlugin getInstance() {
		return instance;
	}
	
	public void receiveCall(PluginCall call) {
		AbstractPluginData data = call.getPluginData();
		
		if (data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			if(data.getMethodID().equals("receivePlugins")) {
				// TODO Do something with the list of plugins.
			} else if(data.getMethodID().equals("receiveClients")) {
				receiveClients((AbstractPluginData<Set<Long>>) call.getPluginData().getData());
			} else if(data.getMethodID().equals("receivePlugins")) {
				receivePlugins((AbstractPluginData<HashMap<String, String>>) call.getPluginData().getData());
			} else {
				System.out.println("The methodID does not exist.");
			}
		} else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		} else {
			System.out.println("The method ID doesn't exist.");
		}
	}
	
	private void receivePlugins(AbstractPluginData<HashMap<String, String>> data) {
		// TODO Auto-generated method stub
		
	}

	private void receiveClients(AbstractPluginData<Set<Long>> data) {
		// TODO Auto-generated method stub
	}

	private void updatePlugins() {
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
	
	public void sendPlugins(long id) {
		updatePlugins();
		// TODO Move the updatePlugins() call to where we actually update the HashMap of loaded Plugins to increase efficiency.
		ConnectionModel.getInstance().getConnection(id)
				.send(new PluginCall("SystemPlugin", new AbstractPluginData<HashMap<String, String>>("receivePlugins", "SystemPlugin", plugins), id));
	}
}
