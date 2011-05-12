package falcons.client.controller;

import java.util.HashMap;

import falcons.client.model.ClientPreferencesLogic;
import falcons.client.model.PluginLogic;
import falcons.client.model.ServerLogic;
import falcons.plugin.Pluggable;
import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class DataMasterController {
	
	public Object getData(LibraryEvent e){
		LibraryEventType eventType = e.getEventType();
		Object returnObject = null;
		switch (eventType) {
		case GET_IP:
			returnObject = ClientPreferencesLogic.getIp();
			break;
		case GET_PLUGINS:
			returnObject = PluginLogic.getPluginMap();
			break;
		case GET_PORT:
			returnObject = ClientPreferencesLogic.getPort();
			break;
		case GET_CLIENTPLUGINS:
			returnObject = ServerLogic.getPlugins(Long.parseLong(e.getId()));
			break;
		case GET_CLIENTS:
			returnObject = ServerLogic.getClients();
		case GET_PLUGIN:
			returnObject = PluginLogic.getPluginMap().get(e.getId());
		default:
			break;
		}
		return returnObject;
	}
}
