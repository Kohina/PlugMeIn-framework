package falcons.client.network;

import java.io.IOException;

import javax.management.modelmbean.ModelMBean;

import falcons.client.model.PluginLogic;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.utils.PluginCall;

public class ClientDataInterpreter {

	private static ClientDataInterpreter instance;

	/**
	 * The Constructor for the DataInterpreter. 
	 */
	private ClientDataInterpreter() {
	}

	public static ClientDataInterpreter getInstance() {
			if (instance == null) {
				instance = new ClientDataInterpreter();
		}
		return instance;
	}

	/**
	 * Interpret where the PluginCall is supposed to be sent and then send it to
	 * the corresponding Plugin or client.
	 * 
	 * @param call
	 *            The PluginCall that's been received from the server.
	 */
	public void interpret(PluginCall call) {
		long destination = call.getDestination();
		//TODO Should this^ be removed? The call should already be at its destination?

//		if (clientInterpreter) {
			String pluginName = call.getPluginID();
			((AbstractPlugin) PluginLogic.getPluginMap().get(pluginName)).receiveCall(call);
//		}
	}
}
