package falcons.plugin.manager;

import java.io.IOException;

import falcons.server.model.ConnectionModel;

public class DataInterpreter {

	private PluginModel model;

	/**
	 * The Constructor for the DataInterpreter. Takes a pluginModel as a
	 * parameter.
	 * 
	 * @param model
	 *            The list of all currently loaded plugins.
	 */
	public DataInterpreter(PluginModel model) {
		this.model = model;
	}

	/**
	 * Interpret where the PluginCall is supposed to be sent and then send it to
	 * the corresponding Plugin or client.
	 * 
	 * @param call
	 *            The PluginCall that's been received from the server.
	 */
	public void interpret(PluginCall call) {
		int destination = call.getDestination();
		
		if(destination < 0) {
			String plugin = call.getPluginID();
			model.getPluginMap().get(plugin).receiveCall(call);
		} else {
			System.out.println("ARRIVED!!");
			String plugin = call.getPluginID();
			model.getPluginMap().get(plugin).receiveCall(call);
			// GOTTA FIX THIS TODO ConnectionModel.getInstance().getThread(destination).send(call);
		}
	}
}
