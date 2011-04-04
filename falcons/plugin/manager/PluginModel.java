package falcons.plugin.manager;

import java.util.HashMap;
import java.util.Map;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.SendMessagePlugin;

public class PluginModel {

	private static PluginModel instance;
	private HashMap<String, AbstractPlugin> pluginMap = new HashMap<String, AbstractPlugin>();

	/**
	 * The Constructor for the PluginModel. Should read the plugin folder and
	 * load all plugins into the pluginMap.
	 */
	private PluginModel() {
		pluginMap.put("SendMessage", new SendMessagePlugin());
		// pluginMap = pluginLoader.getPlugins();
	}
	
	public static PluginModel getInstance(){
			if(instance == null){
				instance = new PluginModel();
		}
		return instance;
	}

	/**
	 * 
	 * @return Returns a map containing all the currently loaded plugins with
	 *         their pluginID as key.
	 */
	public HashMap<String, AbstractPlugin> getPluginMap() {
		// Should be getPlugin(), we don't want something to change the map.
		return pluginMap;
	}

}