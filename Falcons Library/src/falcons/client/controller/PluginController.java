package falcons.client.controller;

import java.util.HashMap;

import falcons.client.model.PluginLogic;
import falcons.plugin.Pluggable;

class PluginController {
	
	void loadPlugins(){
		PluginLogic.loadPlugins();
	}
	
	HashMap<String, Pluggable> getPluginMap(){
		return PluginLogic.getPluginMap();
	}
}
