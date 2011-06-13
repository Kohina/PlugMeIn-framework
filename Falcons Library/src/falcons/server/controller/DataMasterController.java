package falcons.server.controller;

import falcons.server.model.ServerPreferencesLogic;
import falcons.server.model.PluginLogic;
import falcons.server.network.model.ConnectionModel;
import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class DataMasterController {

	/**
	 * The method that tells the logic to return the specified data
	 * @param e The type of data that the server-implementation wants to recover
	 * @return	Returns the data that the server-implementation wanted
	 */
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
