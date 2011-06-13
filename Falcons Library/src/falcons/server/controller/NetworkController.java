package falcons.server.controller;

import falcons.plugin.PluginCall;
import falcons.server.network.model.ConnectionModel;

public class NetworkController {
	
	/**
	 * The method that sends PluginCalls to the clients
	 * @param call
	 * 				The Call to be sent
	 */
	static void send(PluginCall call){
		ConnectionModel.getInstance().getConnection(call.getDestination()).send(call);
	}
}