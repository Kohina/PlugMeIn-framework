package falcons.client.controller;

import java.util.HashMap;
import java.util.List;

import falcons.client.model.ClientPreferencesLogic;
import falcons.client.model.PluginLogic;
import falcons.client.network.ClientConnection;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEventListener;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.server.network.model.ConnectionModel;
import falcons.utils.ClientInfo;

class PluginController implements PluginEventListener {

	/**
	 * Loads all of the available plugins from the loaded list of plugin.
	 */
	void loadPlugins(){
		PluginLogic.loadPlugins();
		Object[] keys = PluginLogic.getPluginMap().keySet().toArray();
		for(Object o : keys){
			((AbstractPlugin) PluginLogic.getPluginMap().get(o)).addEventListener(this);
		}
	}

	@Override
	public void actionPerformed(PluginEvent p) {
		PluginEventType e = p.getTypeOfEvent();
		switch (e) {
		case SEND:
			p.getPluginCall().setSender(ClientPreferencesLogic.getID());
			ClientConnection.send(p.getPluginCall());
			break;
		default:
			break;
		}
	}

	@Override
	public Object getData(PluginEvent p) {
		PluginEventType e = p.getTypeOfEvent();
		Object returnObject = null;
		switch (e) {
		case GET_CLIENTS:
			//TODO: This should be done returning the serverlist of clients!
			returnObject = ConnectionModel.getClients();
			break;
		case GET_PLUGINMAP:
			returnObject =  PluginLogic.getPluginMap();
			break;
		case GET_CLIENTID:
			//TODO: This should be done by the server
		default:
			break;
		}
		return returnObject;
	}
}
