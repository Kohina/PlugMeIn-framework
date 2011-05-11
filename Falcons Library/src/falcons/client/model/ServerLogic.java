package falcons.client.model;

import java.util.HashMap;

import falcons.utils.ClientInfo;

public class ServerLogic {
	private static ServerModel serverModel = ServerModel.getInstance();
	
	public static HashMap<String, String> getPlugins(ClientInfo client) {
		return serverModel.getPlugins(client);
	}
	
	public static void addClient(ClientInfo client, HashMap<String, String> plugins) {
		serverModel.addClient(client, plugins);
	}
	
	public static void addClient(ClientInfo client) {
		serverModel.addClient(client);
	}
	
	public static int numberOfClients() {
		return serverModel.numberOfClients();
	}
	
	public static int numberOfPlugins(ClientInfo client) {
		return serverModel.numberOfPlugins(client);
	}
	
	public static void setInfo(long id, String name) {
		serverModel.setInfo(id, name);
	}
	
	public static void setInfo(ClientInfo client) {
		serverModel.setInfo(client.getID(), client.getName());
	}
}
