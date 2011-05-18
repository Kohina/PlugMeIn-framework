package falcons.server;

import java.io.IOException;

import falcons.server.model.ServerPreferencesLogic;
import falcons.server.network.ServerCommunicationCenter;

public class Main {

	private static int port = 45678;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerPreferencesLogic.readPreferences();
		Thread comThread = new Thread(new ServerCommunicationCenter());
		comThread.start();
	}

}
