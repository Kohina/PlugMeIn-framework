package falcons.server.controller;

import falcons.server.controller.NetworkController;
import falcons.server.model.PluginLogic;
import falcons.server.network.model.ConnectionModel;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEventListener;
import falcons.plugin.PluginEvent.PluginEventType;

public class PluginController implements PluginEventListener {

	/**
	 * Tells the PluginLogic to load all plugins.s
	 */
	void loadPlugins(){
		PluginLogic.loadPlugins();
		Object[] keys = PluginLogic.getPluginMap().keySet().toArray();
		for(Object o : keys){
			((AbstractPlugin) PluginLogic.getPluginMap().get(o)).addEventListener(this);
		}
	}

	@Override
	/**
	 * The method that handles all the requests from the plugins
	 * @param The type of event that has occured
	 */
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
			returnObject =  PluginLogic.getPluginMap();
			break;
		default:
			break;
		}
		return returnObject;
	}

}
