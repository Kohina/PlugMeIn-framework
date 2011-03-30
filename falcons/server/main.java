package falcons.server;

import java.io.IOException;

import javax.swing.JOptionPane;

import falcons.plugin.manager.DataInterpreter;
import falcons.plugin.manager.PluginModel;
import falcons.server.model.ConnectionModel;
import falcons.server.network.CommunicationCenter;

public class main {

	private static DataInterpreter interpreter;
	private static PluginModel pluginModel = new PluginModel();
	private static int port = 45678;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Thread comThread = new Thread(new CommunicationCenter(interpreter,
				port, ConnectionModel.getInstance()));
		comThread.start();
	}

}
