package falcons.server.model;

import java.util.*;

import falcons.client.model.ServerLogic;
import falcons.server.network.ConnectionThread;
import falcons.utils.ClientInfo;

public class ConnectionModel {

	private static ConnectionModel instance = new ConnectionModel();
	private static HashMap<ConnectionThread, ClientInfo> connections = new HashMap<ConnectionThread, ClientInfo>();

	private ConnectionModel() {
		// Do Nasing.
	}

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

		ConnectionThread[] conns = (ConnectionThread[]) connections.keySet()
				.toArray();

		for (ConnectionThread c : conns) {
			if (c.getId() == id) {
				returnObject = c;
			}
		}
		return returnObject;
	}

	public void addConnection(ConnectionThread thread) {
		connections.put(thread, null);
	}
	
	public void addClientInfo(long id, ClientInfo client) {
		connections.put(getConnection(id), client);
	}

	public void removeConnection(ConnectionThread thread) {
		connections.remove(thread);
	}

	/**
	 * @return Returns a list with all the currently active ConnectionThreads.
	 */
	public HashMap<ConnectionThread, ClientInfo> getConnectionList() {
		return (HashMap<ConnectionThread, ClientInfo>) connections.clone();
	}

	public static HashMap<String, String> getClientPlugins(long id) {
		ConnectionThread[] conns = (ConnectionThread[]) connections.keySet()
				.toArray();
		ConnectionThread key = null;

		for (ConnectionThread c : conns) {
			if (c.getId() == id) {
				key = c;
			}
		}
		return connections.get(key).getPlugins();
	}

	public static List<ClientInfo> getClients() {
		List<ClientInfo> clients = new ArrayList<ClientInfo>();
		ConnectionThread[] conns = (ConnectionThread[]) connections.keySet()
				.toArray();

		for (ConnectionThread c : conns) {
			clients.add(connections.get(c));
		}
		return clients;
	}
}
