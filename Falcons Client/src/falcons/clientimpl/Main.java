package falcons.clientimpl;

import falcons.client.Client;
import falcons.clientimpl.view.ClientSystemTray;
import falcons.clientimpl.view.ClientView;
import falcons.clientimpl.view.ConnectionView;

public class Main {

	private static ClientSystemTray tray;
	private static Client client;

	public static void main(String args[]) {
		client  = new Client();
		tray = new ClientSystemTray(new ClientView(), new ConnectionView());
	}

}
