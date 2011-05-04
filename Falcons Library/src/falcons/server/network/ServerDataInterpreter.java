package falcons.server.network;

import java.io.IOException;

import javax.management.modelmbean.ModelMBean;

import falcons.client.model.PluginLogic;
import falcons.plugin.PluginCall;

public class ServerDataInterpreter {

	private boolean clientInterpreter;
	private static ServerDataInterpreter instance;

	/**
	 * The Constructor for the DataInterpreter. Takes a pluginModel as a
	 * parameter.
	 * 
	 * @param model
	 *            The list of all currently loaded plugins.
	 */
	private ServerDataInterpreter(boolean clientInterpreter) {
		this.clientInterpreter = clientInterpreter;
	}

	public static ServerDataInterpreter getInstance(boolean clientInterpreter) {
			if (instance == null) {
				instance = new ServerDataInterpreter(clientInterpreter);
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
			falcons.server.model.PluginLogic.getInstance().getPluginMap().get(pluginName).receiveCall(call);
		}
	}
}
