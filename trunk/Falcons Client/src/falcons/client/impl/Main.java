package falcons.client.impl;

import falcons.client.Client;
import falcons.client.impl.view.ClientSystemTray;
import falcons.client.impl.view.ClientView;
import falcons.client.impl.view.ConnectionView;

public class Main {

	private static ClientSystemTray tray;
	public static ClientImpl client;

	public static void main(String args[]) {
		client  = new ClientImpl();
		client.run();
	}

}
