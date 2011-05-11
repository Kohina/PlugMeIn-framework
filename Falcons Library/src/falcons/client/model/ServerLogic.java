package falcons.client.model;

import java.util.HashMap;

import falcons.utils.ClientInfo;

public class ServerLogic {
	private static ServerModel serverModel = ServerModel.getInstance();
	
	public static HashMap<String, String> getPlugins(long id) {
		return serverModel.getPlugins(id);
	}
	
	public static void addClient(long id, String name, HashMap<String, String> plugins) {
		serverModel.addClient(new ClientInfo(id, name, plugins));
	}
	
	public static void addClient(ClientInfo client) {
		serverModel.addClient(client);
	}
	
	public static int numberOfClients() {
		return serverModel.numberOfClients();
	}
	
	public static int numberOfPlugins(long id) {
		return serverModel.numberOfPlugins(id);
	}
	
	public static void setInfo(long id, String name, HashMap<String, String> plugins) {
		serverModel.setInfo(new ClientInfo(id, name, plugins));
	}
	
	public static void setInfo(ClientInfo client) {
		serverModel.setInfo(new ClientInfo(client));
	}
}
