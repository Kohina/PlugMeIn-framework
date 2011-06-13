package falcons.server.model;

import java.util.HashMap;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;

public class PluginModel {

	private static PluginModel instance;
	private static HashMap<String,Pluggable> pluginMap;

	/**
	 * Default constructor
	 */
	private PluginModel() {
	}
	
	/**
	 * 
	 * @return Returns this model-instance
	 */
	static PluginModel getInstance(){
			if(instance == null){
				instance = new PluginModel();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return Returns the loaded plugins
	 */
	static HashMap<String, Pluggable> getPlugins(){
		return new HashMap<String, Pluggable>(pluginMap);
	}
	
	/**
	 * Sets the current map of the loaded plugins with a new one
	 * @param pluginMap The map to be set as the new pluginMap
	 */
	static void setPluginMap(HashMap<String, Pluggable> pluginMap){
		PluginModel.pluginMap = pluginMap;
	}
}
