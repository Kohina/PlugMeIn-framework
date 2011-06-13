package falcons.server.network.model;

import java.util.*;

import falcons.client.model.ServerLogic;
import falcons.utils.ClientInfo;

public class ConnectionModel {

	private static ConnectionModel instance = new ConnectionModel();
	private static HashMap<ConnectionThread, ClientInfo> connections = new HashMap<ConnectionThread, ClientInfo>();

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
	public ConnectionThread getConnection(long id) {
		ConnectionThread returnObject = null;

		ConnectionThread[] conns = (ConnectionThread[]) connections.keySet().toArray(new ConnectionThread[connections.size()]);

		for (ConnectionThread c : conns) {
			if (c.getId() == id) {
				returnObject = c;
			}
			System.out.println(c.getId());
		}
		return returnObject;
	}

	/**
	 * Adds a new Client to the thread collection
	 * @param thread
	 * 					The thread to be added
	 */
	public void addConnection(ConnectionThread thread) {
		connections.put(thread, null);
	}
	
	/**
	 * Adds a new Client to the client collection
	 * @param id
	 * 			The id of the client to be added to the collection
	 * @param client
	 * 			The ClientInfo to be added to the collection
	 */
	public void addClientInfo(long id, ClientInfo client) {
		connections.put(getConnection(id), client);
	}

	/**
	 * Removes a Client from the Client collection
	 * @param thread
	 */
	public void removeConnection(ConnectionThread thread) {
		thread.cancel();
		connections.remove(thread);
	}

	/**
	 * @return Returns a list with all the currently active ConnectionThreads.
	 */
	public HashMap<ConnectionThread, ClientInfo> getConnectionList() {
		return (HashMap<ConnectionThread, ClientInfo>) connections.clone();
	}

	/**
	 * Returns a hashmap with all the plugins that a specified client has loaded.
	 * @param id
	 * 			The id of the client that you want information from
	 * @return
	 * 			A hashmap with all the plugins that the specified client has loaded
	 */
	public static HashMap<String, String> getClientPlugins(long id) {
		ConnectionThread[] conns = (ConnectionThread[]) connections.keySet().toArray(new ConnectionThread[connections.size()]);
		ConnectionThread key = null;

		for (ConnectionThread c : conns) {
			if (c.getId() == id) {
				key = c;
			}
		}
		return connections.get(key).getPlugins();
	}

	/**
	 * Returns all the connected clients
	 * @return
	 * 			A List of all the connected clients
	 */
	public static List<ClientInfo> getClients() {
		List<ClientInfo> clients = new ArrayList<ClientInfo>();
		ConnectionThread[] conns = (ConnectionThread[]) connections.keySet().toArray(new ConnectionThread[connections.size()]);

		for (ConnectionThread c : conns) {
			clients.add(connections.get(c));
		}
		return clients;
	}
}
