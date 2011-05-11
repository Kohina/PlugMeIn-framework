package falcons.server.controller;

import falcons.plugin.utils.PluginCall;
import falcons.server.model.ConnectionModel;

public class NetworkController {
	static void send(PluginCall call){
		ConnectionModel.getConnection(call.getDestination()).send(call);
	}

}