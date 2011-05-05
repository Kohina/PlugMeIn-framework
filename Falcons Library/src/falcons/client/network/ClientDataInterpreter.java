package falcons.client.network;

import java.io.IOException;

import javax.management.modelmbean.ModelMBean;

import falcons.client.model.PluginLogic;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.PluginCall;

public class ClientDataInterpreter {

	private boolean clientInterpreter;
	private static ClientDataInterpreter instance;

	/**
	 * The Constructor for the DataInterpreter. Takes a pluginModel as a
	 * parameter.
	 * 
	 * @param model
	 *            The list of all currently loaded plugins.
	 */
	private ClientDataInterpreter(boolean clientInterpreter) {
		this.clientInterpreter = clientInterpreter;
	}

	public static ClientDataInterpreter getInstance(boolean clientInterpreter) {
			if (instance == null) {
				instance = new ClientDataInterpreter(clientInterpreter);
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

		if (clientInterpreter) {
			String pluginName = call.getPluginID();
			((AbstractPlugin) PluginLogic.getPluginMap().get(pluginName)).receiveCall(call);
		}
	}
}
