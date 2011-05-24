package falcons.server.model;

import java.util.HashMap;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;

public class PluginModel {

	private static PluginModel instance;
	private static HashMap<String,Pluggable> pluginMap;

	/**
	 * The Constructor for the PluginModel. Should read the plugin folder and
	 * load all plugins into the pluginMap.
	 */
	private PluginModel() {
	}
	
	static PluginModel getInstance(){
			if(instance == null){
				instance = new PluginModel();
		}
		return instance;
	}
	
	static HashMap<String, Pluggable> getPlugins(){
		return new HashMap<String, Pluggable>(pluginMap);
	}
	
	static void setPluginMap(HashMap<String, Pluggable> pluginMap){
		PluginModel.pluginMap = pluginMap;
	}
}
