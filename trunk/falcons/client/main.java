package falcons.client;

import java.io.IOException;

import falcons.client.network.CommunicationCenter;
import falcons.plugin.SendMessagePlugin;
import falcons.plugin.manager.DataInterpreter;
import falcons.plugin.manager.PluginModel;

public class main {

	private static PluginModel pluginModel;
	private static DataInterpreter interpreter;
	private static int port = 45678;
	private static SendMessagePlugin p = new SendMessagePlugin(); 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		pluginModel = pluginModel.getInstance();
		interpreter = interpreter.getInstance(true);
		pluginModel.getPluginMap().put(p.getPluginID(), p);
		Thread comThread;
		try {
			comThread = new Thread(new CommunicationCenter(interpreter, "127.0.0.1", port));
			comThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
