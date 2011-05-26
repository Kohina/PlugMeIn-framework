package falcons.client.controller;

import java.util.HashMap;
import java.util.List;

import falcons.client.model.PluginLogic;
import falcons.client.model.ServerLogic;
import falcons.client.network.ClientConnection;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEventListener;
import falcons.plugin.PluginEvent.PluginEventType;
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
			List<ClientInfo> clients = ServerLogic.getClients();
			HashMap<String, Long> clientData = new HashMap<String, Long>();
			for(ClientInfo c : clients){
				clientData.put(c.getName(), c.getID());
			}
			returnObject = clientData;
			break;
		case GET_PLUGINMAP:
			returnObject =  PluginLogic.getPluginMap();
			break;
		case GET_CLIENTID:
			returnObject = ServerLogic.getClientInfo().getID();
		default:
			break;
		}
		return returnObject;
	}
}
