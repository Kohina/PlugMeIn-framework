package falcons.server.network;

import falcons.server.abstractions.AbstractPluginData;
import falcons.server.model.PluginModel;

public class DataInterpreter {

	private PluginModel model;

	/**
	 * Constructor. 
	 * Takes a pluginModel as a parameter and sets the instace variable.
	 * 
	 * @param model - The list of all currently loaded plugins.
	 */
	public DataInterpreter(PluginModel model) {
		this.model = model;
	}

	/**
	 * Interpret where the PluginCall is supposed to be sent and then send it to
	 * the corresponding Plugin.
	 * 
	 * @param call - The PluginCall that's been received from the server.
	 */
	public void interpret(PluginCall call) {
		String plugin = call.getPluginID();
		model.getPluginMap().get(plugin).receiveCall(call);
	}
}