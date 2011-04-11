package falcons.pluginmanager;

import java.io.IOException;

import javax.management.modelmbean.ModelMBean;

import falcons.plugin.PluginCall;

public class DataInterpreter {

	private PluginModel model;
	private boolean clientInterpreter;
	private static DataInterpreter instance;

	/**
	 * The Constructor for the DataInterpreter. Takes a pluginModel as a
	 * parameter.
	 * 
	 * @param model
	 *            The list of all currently loaded plugins.
	 */
	private DataInterpreter(boolean clientInterpreter) {
		model = model.getInstance();
		this.clientInterpreter = clientInterpreter;
	}

	public static DataInterpreter getInstance(boolean clientInterpreter) {
			if (instance == null) {
				instance = new DataInterpreter(clientInterpreter);
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
			System.out.println("COMMAND ARRIVED, SENDING TO PLUGIN");
			String plugin = call.getPluginID();
			model.getPluginMap().get(plugin).receiveCall(call);
		}
	}
}
