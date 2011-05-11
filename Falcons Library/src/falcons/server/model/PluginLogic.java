package falcons.server.model;

import java.util.HashMap;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;
import falcons.plugin.Plugin;
import falcons.pluginmanager.PluginManager;

public class PluginLogic {
	
	private static PluginLogic instance;
	
	private PluginLogic(){
		
	}
	
	public static PluginLogic getInstance(){
		if(instance == null){
			return new PluginLogic();
		}else{
			return instance;
		}
	}
	
	public static void loadPlugins(){
		List<Pluggable> pluginList = PluginManager.loadPlugins();
		HashMap<String, Pluggable> pluginMap = new HashMap<String, Pluggable>();
		for(Pluggable p : pluginList){
			pluginMap.put(p.getClass().getAnnotation(Plugin.class).pluginID(), p);
		}
		
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
