package falcons.server.network.model;

import java.util.*;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.PluginCall;
import falcons.utils.ClientInfo;

public class ConnectionModel {

	private int nextID = 0;
	private static ConnectionModel instance = new ConnectionModel();
	private static HashMap<Integer, ConnectionThread> connections = new HashMap<Integer ,ConnectionThread>();
	private static HashMap<Integer, ClientInfo> clients = new HashMap<Integer ,ClientInfo>();

	
	/**
	 * Default Constructor
	 */
	private ConnectionModel() {
		// Do Nasing.
	}

	/**
	 * 
	 * @return Returns the models instance
	 */
	public static ConnectionModel getInstance() {
		if (instance == null) {
			instance = new ConnectionModel();
		}
		return instance;
	}

	/**
	 * Gets the ConnectionThread with the given ID.
	 * 
	 * @param id
	 *            The ID of the thread wanted.
	 * @return Always check if the returned value is null, if it's null the
	 *         thread was not found.
	 */
	public ConnectionThread getConnection(int id) {
		return connections.get(id);
	}

	/**
	 * Adds a new Client to the thread collection
	 * @param thread
	 * 					The thread to be added
	 */
	public void addConnection(ConnectionThread thread) {
		connections.put(nextID, thread);
		AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("receiveID", "1.0", nextID);
		thread.send(new PluginCall("SystemClientPlugin", pluginData, nextID, -1));
		nextID++;
	}
	
	/**
	 * Adds a new Client to the client collection
	 * @param id
	 * 			The id of the client to be added to the collection
	 * @param client
	 * 			The ClientInfo to be added to the collection
	 */
	public void addClientInfo(int id, ClientInfo client) {
		clients.put(id, client);
	}

	/**
	 * Removes a Client from the Client collection
	 * @param thread
	 */
	public void removeConnection(int ID, ConnectionThread thread) {
		thread.cancel();
		connections.remove(ID);
		clients.remove(ID);
	}

	/**
	 * @return Returns a list with all the currently active ConnectionThreads.
	 */
	public HashMap<Integer ,ConnectionThread> getConnectionList() {
		return (HashMap<Integer, ConnectionThread>) connections.clone();
	}

	/**
	 * Returns a hashmap with all the plugins that a specified client has loaded.
	 * @param id
	 * 			The id of the client that you want information from
	 * @return
	 * 			A hashmap with all the plugins that the specified client has loaded
	 */
	public static HashMap<String, String> getClientPlugins(long id) {
		//TODO: strange here
		ConnectionThread[] conns = (ConnectionThread[]) connections.keySet().toArray(new ConnectionThread[connections.size()]);
		ConnectionThread key = null;

		for (ConnectionThread c : conns) {
			if (c.getId() == id) {
				key = c;
			}
		}
		return clients.get(key).getPlugins();
	}

	/**
	 * Returns all the connected clients
	 * @return
	 * 			A List of all the connected clients
	 */
	public static List<ClientInfo> getClients() {
		List<ClientInfo> returnClients = new ArrayList<ClientInfo>();
		Collection<ClientInfo> client = clients.values();

		for (ClientInfo c : client) {
			returnClients.add(c);
		}
		return returnClients;
	}
}
