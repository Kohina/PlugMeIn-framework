package falcons.server;

import java.io.IOException;

import falcons.server.model.ServerPreferencesLogic;
import falcons.server.network.ServerCommunicationCenter;
import falcons.server.view.ServerSystemTray;

public class Main {

	private static ServerImpl server;
	
	public static void main(String[] args) throws IOException {
		server = new ServerImpl();
		server.run();
	}

}
