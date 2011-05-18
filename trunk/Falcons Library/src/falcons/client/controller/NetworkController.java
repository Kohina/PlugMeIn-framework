package falcons.client.controller;

import falcons.client.network.ClientConnection;
import falcons.plugin.PluginCall;

public class NetworkController {

	static void send(PluginCall call){
		ClientConnection.send(call);
	}

}
