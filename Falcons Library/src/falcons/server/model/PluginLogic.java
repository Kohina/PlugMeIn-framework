package falcons.server.model;

import java.util.HashMap;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Plugin;
import falcons.pluginmanager.PluginLoader;

public class PluginLogic {
	
	private PluginLoader pluginLoader = new PluginLoader();
	
	public void loadPlugins(){
		List<AbstractPlugin> pluginList = pluginLoader.loadPlugins();
		HashMap<String, AbstractPlugin> pluginMap = new HashMap<String, AbstractPlugin>();
		for(AbstractPlugin p : pluginList){
			pluginMap.put(p.getClass().getAnnotation(Plugin.class).pluginID(), p);
		}
		
	}

	/**
	 * 
	 * @return Returns a map containing all the currently loaded plugins with
	 *         their pluginID as key.
	 */
	public HashMap<String, AbstractPlugin> getPluginMap() {
		return PluginModel.getPlugins();
	}
}
