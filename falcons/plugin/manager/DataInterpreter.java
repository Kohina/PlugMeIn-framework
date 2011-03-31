package falcons.plugin.manager;

import java.io.IOException;

import falcons.server.model.ConnectionModel;

public class DataInterpreter {

	private PluginModel model;
	private boolean clientInterpreter;

	/**
	 * The Constructor for the DataInterpreter. Takes a pluginModel as a
	 * parameter.
	 * 
	 * @param model
	 *            The list of all currently loaded plugins.
	 */
	public DataInterpreter(PluginModel model, boolean clientInterpreter) {
		this.model = model;
		this.clientInterpreter = clientInterpreter;
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
			System.out.println("COMMAND ARRIVED, SENDING TO PLUGIN");
			String plugin = call.getPluginID();
			model.getPluginMap().get(plugin).receiveCall(call);
		} else if(clientInterpreter){
			System.out.println("COMMAND ARRIVED, SENDING TO PLUGIN");
			String plugin = call.getPluginID();
			model.getPluginMap().get(plugin).receiveCall(call);
		} else {
			System.out.println("SENDING COMMAND TO CLIENT");
			ConnectionModel.getInstance().getThread(destination).send(call);
		}
	}
}
