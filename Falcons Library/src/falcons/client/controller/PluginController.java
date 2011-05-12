package falcons.client.controller;

import falcons.client.model.PluginLogic;
import falcons.client.model.ServerLogic;
import falcons.plugin.utils.PluginEvent;
import falcons.plugin.utils.PluginEvent.PluginEventType;
import falcons.plugin.utils.PluginEventListener;

class PluginController implements PluginEventListener {
	
	void loadPlugins(){
		PluginLogic.loadPlugins();
	}

	@Override
	public void actionPerformed(PluginEvent p) {
		PluginEventType e = p.getTypeOfEvent();
		switch (e) {
		case SEND:
			NetworkController.send(p.getPluginCall());
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
			returnObject = ServerLogic.getClients();
			break;
		case GET_PLUGINMAP:
			returnObject =  PluginLogic.getPluginMap();
			break;
		default:
			break;
		}
		return returnObject;
	}
}
