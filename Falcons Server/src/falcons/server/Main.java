package falcons.server;

import java.io.IOException;

import javax.swing.JOptionPane;

import falcons.plugin.manager.DataInterpreter;
import falcons.plugin.manager.PluginModel;
import falcons.server.model.ConnectionModel;
import falcons.server.network.ServerCommunicationCenter;

public class Main {

	private static PluginModel pluginModel;
	private static DataInterpreter interpreter;
	private static int port = 45678;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		pluginModel = pluginModel.getInstance();
		interpreter = interpreter.getInstance(false);
		Thread comThread = new Thread(new ServerCommunicationCenter(interpreter,
				port, ConnectionModel.getInstance()));
		comThread.start();
	}

}
