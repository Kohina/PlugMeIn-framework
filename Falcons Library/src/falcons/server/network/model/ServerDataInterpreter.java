package falcons.server.network.model;

import java.io.IOException;

import javax.management.modelmbean.ModelMBean;

import falcons.client.model.PluginLogic;
import falcons.plugin.utils.PluginCall;

public class ServerDataInterpreter {
	private static ServerDataInterpreter instance;

	/**
	 * The Constructor for the DataInterpreter.
	 */
	private ServerDataInterpreter() {
	}

	public static ServerDataInterpreter getInstance() {
			if (instance == null) {
				instance = new ServerDataInterpreter();
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
			String pluginName = call.getPluginID();
			falcons.server.model.PluginLogic.getPluginMap().get(pluginName).receiveCall(call);
	}
}
