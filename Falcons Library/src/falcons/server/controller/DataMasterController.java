package falcons.server.controller;

import falcons.server.model.ConnectionModel;
import falcons.server.model.ServerPreferencesLogic;
import falcons.server.model.PluginLogic;
import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class DataMasterController {

	public Object getData(LibraryEvent e){
		LibraryEventType eventType = e.getEventType();
		Object returnObject = null;
		switch (eventType) {
		case GET_PLUGINS:
			returnObject = PluginLogic.getPluginMap();
			break;
		case GET_PORT:
			returnObject = ServerPreferencesLogic.getPort();
			break;
		case GET_CLIENTPLUGINS:
			returnObject = ConnectionModel.getClientPlugins(Long.parseLong(e.getId()));
			break;
		case GET_CLIENTS:
			returnObject = ConnectionModel.getClients();
			break;
		case GET_PLUGIN:
			returnObject = PluginLogic.getPluginMap().get(e.getId());
			break;
		default:
			break;
		}
		return returnObject;
	}
}
