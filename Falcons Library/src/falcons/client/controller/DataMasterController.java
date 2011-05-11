package falcons.client.controller;

import java.util.HashMap;

import falcons.client.model.ClientPreferencesLogic;
import falcons.client.model.PluginLogic;
import falcons.plugin.Pluggable;
import falcons.utils.ClientTree;

public class DataMasterController {

	static HashMap<String, Pluggable> getPlugins(){
		return PluginLogic.getPluginMap();
	}

	static ClientTree getClients() {
		// TODO KOLLA HÄR WEEEEEEW
		return ServerLogic.getClient();
	}
	
	static String getIp() {
		return ClientPreferencesLogic.getIp();
	}
	
	static int getPort() {
		return ClientPreferencesLogic.getPort();
	}
}
