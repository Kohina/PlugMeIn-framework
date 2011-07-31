package falcons.server.network.model;

import java.io.IOException;

import javax.management.modelmbean.ModelMBean;

import falcons.client.model.PluginLogic;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.PluginCall;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.server.network.SystemServerPlugin;

public class ServerDataInterpreter {
	private static ServerDataInterpreter instance;

	/**
	 * The Constructor for the DataInterpreter.
	 */
	private ServerDataInterpreter() {
	}

	/**
	 * @return Returns the instance of the ServerDataInterpreter
	 */
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
		// TODO: Find a way to know if the call is to be executed on the server
		// or just forwarded
		if (call.getDestination() != -1) {
			ConnectionModel.getInstance().getConnection(call.getDestination()).send(call);
		} 
		else {
			String pluginName = call.getPluginID();
			if (pluginName.equals("SystemServerPlugin")) {
				SystemServerPlugin.getInstance().receiveCall(call);
			} else {
				((AbstractPlugin) falcons.server.model.PluginLogic
						.getPluginMap().get(pluginName)).receiveCall(call);
			}
		}
	}
}
