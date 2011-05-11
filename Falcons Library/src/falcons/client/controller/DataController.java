package falcons.client.controller;

import java.util.HashMap;

import falcons.client.model.PluginLogic;
import falcons.plugin.Pluggable;
import falcons.utils.ClientTree;

//TODO Should act a bit like the MasterController, only 
//it is supposed to return Data from the models.
public class DataController {

	static HashMap<String, Pluggable> getPlugins(){
		return PluginLogic.getPluginMap();
	}

	static ClientTree getClients() {
		// TODO FIX MODEL FOR CLIENTS ON THE SERVER.
		return null;
	}
}
