package falcons.client.model;

import java.util.HashMap;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Plugin;
import falcons.pluginmanager.PluginLoader;

public class PluginLogic {
	
	public static void loadPlugins(){
		List<AbstractPlugin> pluginList = PluginLoader.loadPlugins();
		HashMap<String, AbstractPlugin> pluginMap = new HashMap<String, AbstractPlugin>();
		for(AbstractPlugin p : pluginList){
			pluginMap.put(p.getClass().getAnnotation(Plugin.class).pluginID(), p);
		}
		PluginModel.setPluginMap(pluginMap);
	}

	/**
	 * 
	 * @return Returns a map containing all the currently loaded plugins with
	 *         their pluginID as key.
	 */
	public static HashMap<String, AbstractPlugin> getPluginMap() {
		return PluginModel.getPlugins();
	}
}
