package falcons.client.network;

import java.io.Serializable;
import java.util.*;

import falcons.client.model.PluginLogic;
import falcons.plugin.*;
import falcons.plugin.utils.PluginCall;

@Plugin(pluginID = "SystemPlugin", versionID = "1.0")
public class SystemClientPlugin implements Serializable {
	
	private static SystemClientPlugin instance = new SystemClientPlugin();
	private Set<Long> clients;
	private HashMap<String, String> plugins;
	
	private SystemClientPlugin() {
		clients = new HashSet<Long>();
		plugins = new HashMap<String, String>();
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
				receiveClients((Set<Long>) call.getPluginData().getData());
			} else if(data.getMethodID().equals("receivePlugins")) {
				receivePlugins((HashMap<String, String>) call.getPluginData().getData());
			} else {
				System.out.println("The methodID does not exist.");
			}
		} else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		} else {
			System.out.println("The method ID doesn't exist.");
		}
	}
	
	private void receivePlugins(HashMap<String, String> plugins) {
		// TODO Auto-generated method stub
	}

	private void receiveClients(Set<Long> clients) {
		// TODO Auto-generated method stub
	}

	private void updatePlugins() {
		Object[] nameSet = PluginLogic.getPluginMap().keySet().toArray();
		
		for(Object o : nameSet){
			String pluginName = o.toString();
			String pluginVersion = PluginLogic.getPluginMap().get(pluginName).getClass().getAnnotation(Plugin.class).versionID();
			plugins.put(pluginName, pluginVersion);
		}
		
		nameSet = plugins.keySet().toArray();
		
		for(Object o : nameSet) {
			String pluginName = o.toString();
			
			if(!PluginLogic.getPluginMap().containsKey(pluginName)) {
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
