package falcons.client.controller;

import falcons.client.network.ClientConnection;
import falcons.plugin.utils.PluginCall;

public class NetworkController {

	static void send(PluginCall call){
		ClientConnection.getInstance().send(call);
	}

}
