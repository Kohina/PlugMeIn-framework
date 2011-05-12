package falcons.server.controller;

import falcons.plugin.PluginCall;
import falcons.server.network.model.ConnectionModel;

public class NetworkController {
	static void send(PluginCall call){
		ConnectionModel.getInstance().getConnection(call.getDestination()).send(call);
	}
}