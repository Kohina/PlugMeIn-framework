package falcons.server.model;

import java.util.HashMap;
import falcons.plugin.AbstractPlugin;

public class PluginModel {

	private static PluginModel instance;
	private static HashMap<String, AbstractPlugin> pluginMap;

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
	
	static HashMap<String, AbstractPlugin> getPlugins(){
		return new HashMap<String, AbstractPlugin>(pluginMap);
	}
	
	static void setPluginMap(HashMap<String, AbstractPlugin> pluginMap){
		PluginModel.pluginMap = pluginMap;
	}
}
