package falcons.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import falcons.utils.ClientInfo;

public class ServerLogic {
	private static ServerModel serverModel = ServerModel.getInstance();

	/**
	 * Returns the plugins available on the connected server.
	 * @param id The ID of the particular plugin.
	 * @return A particular plugin from a plugin hasmap.
	 */
	public static HashMap<String, String> getPlugins(long id) {
		return serverModel.getPlugins(id);
	}
	
	/**
	 * Adds a client to the serverModel. 
	 * @param id The ID of the plugin.
	 * @param name The name of the plugin.
	 * @param plugins
	 */
	public static void addClient(long id, String name, HashMap<String, String> plugins) {
		serverModel.addClient(new ClientInfo(id, name, plugins));
	}
	
	/**
	 * Add a ClientInfo object to the serverModel 
	 * @param client
	 */
	public static void addClient(ClientInfo client) {
		serverModel.addClient(client);
	}
	
	/**
	 * Returns the number of clients connected to the server.
	 * @return The number of clients connected to the server.
	 */
	public static int numberOfClients() {
		return serverModel.numberOfClients();
	}
	
	/**
	 * Returns the number of plugins installed on the server.
	 * @param id 
	 * @return The number of plugins.
	 */
	public static int numberOfPlugins(long id) {
		return serverModel.numberOfPlugins(id);
	}
	
	/**
	 * Updates the serverModels info.
	 * @param id 
	 * @param name
	 * @param plugins
	 */
	public static void setInfo(long id, String name, HashMap<String, String> plugins) {
		serverModel.setInfo(new ClientInfo(id, name, plugins));
	}
	
	
	public static void setInfo(ClientInfo client) {
		serverModel.setInfo(new ClientInfo(client));
	}
	
	public static ClientInfo getClientInfo() {
		return serverModel.getClientInfo();
	}
	
	public static List<ClientInfo> getClients() {
		List<ClientInfo> clients = serverModel.getClients();
		
		for(ClientInfo c : clients) {
			clients.add(new ClientInfo(c.getID(), c.getName(), c.getPlugins()));
		}
		
		return clients;
	}
}
