package falcons.client.model;

import java.util.HashMap;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;

public class PluginModel {

	private static PluginModel instance;
	private static HashMap<String, Pluggable> pluginMap;

	/**
	 * The Constructor for the PluginModel. Should read the plugin folder and
	 * load all plugins into the pluginMap.
	 */
	private PluginModel() {
	}
	
	/**
	 * Returns the PluginModel instance.
	 * @return The instance.
	 */
	static PluginModel getInstance() {
			if(instance == null){
				instance = new PluginModel();
		}
		return instance;
	}
	
	/**
	 * Returns a hashmap containing all available plugins in the pluginMap.
	 * @return
	 */
	static HashMap<String, Pluggable> getPlugins(){
		return new HashMap<String, Pluggable>(pluginMap);
	}
	
	/**
	 * Updates the hashmap containing the available plugins.
	 * @param pluginMap A hashmap containing the plugins to add.
	 */
	static void setPluginMap(HashMap<String, Pluggable> pluginMap){
		PluginModel.pluginMap = pluginMap;
	}
}
