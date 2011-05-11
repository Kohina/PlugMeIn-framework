package falcons.server.controller;

import falcons.server.controller.NetworkController;
import falcons.server.model.ConnectionModel;
import falcons.server.model.PluginLogic;
import falcons.plugin.utils.PluginEvent;
import falcons.plugin.utils.PluginEvent.PluginEventType;
import falcons.plugin.utils.PluginEventListener;

public class PluginController implements PluginEventListener {
	
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
			returnObject = ConnectionModel.getClients();
			break;
		case GET_PLUGINMAP:
			returnObject =  PluginLogic.getInstance().getPluginMap();
			break;
		default:
			break;
		}
		return returnObject;
	}
	
}
