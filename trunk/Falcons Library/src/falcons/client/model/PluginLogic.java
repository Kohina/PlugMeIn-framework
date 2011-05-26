package falcons.client.model;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;
import falcons.plugin.Plugin;
import falcons.pluginmanager.PluginManager;
import falcons.client.model.PluginModel;

public class PluginLogic {

	/**
	 * Transfers all of the plugins from the pluginList to a hash map called pluginMap.
	 */
	public static void loadPlugins() {
		List<Pluggable> pluginList;
		pluginList = PluginManager.loadPlugins();
		HashMap<String, Pluggable> pluginMap = new HashMap<String, Pluggable>();
		for (Pluggable p : pluginList) {
			if (p instanceof AbstractPlugin) {
				pluginMap.put(p.getClass().getAnnotation(Plugin.class).pluginID(), p);
			}
		}
		PluginModel.setPluginMap(pluginMap);

	}

	/**
	 * 
	 * @return Returns a map containing all the currently loaded plugins with
	 *         their pluginID as key.
	 */
	public static HashMap<String, Pluggable> getPluginMap() {
		return PluginModel.getPlugins();
	}
}
