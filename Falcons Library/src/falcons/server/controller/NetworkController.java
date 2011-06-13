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
		if(ConnectionModel.getInstance().getConnection(call.getDestination()) == null){
			System.out.println("all your base belong to _us");
		}
		ConnectionModel.getInstance().getConnection(call.getDestination()).send(call);
	}
}