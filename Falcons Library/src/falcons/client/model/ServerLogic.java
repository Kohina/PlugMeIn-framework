package falcons.client.model;

import java.util.HashMap;

public class ServerLogic {
	private static ServerModel serverModel = ServerModel.getInstance();
	
	public static HashMap<String, String> getPlugins(long id) {
		return serverModel.getPlugins(id);
	}
	
	public static void addClient(long id, HashMap<String, String> plugins) {
		serverModel.addClient(id, plugins);
	}
	
	public static void addClient(long id) {
		serverModel.addClient(id);
	}
	
	public static int numberOfClients() {
		return serverModel.numberOfClients();
	}
	
	public static int numberOfPlugins(long id) {
		return serverModel.numberOfPlugins(id);
	}
	
	public static void setID(long id) {
		serverModel.setID(id);
	}
}
