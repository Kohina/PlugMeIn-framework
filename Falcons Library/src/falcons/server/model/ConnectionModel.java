package falcons.server.model;

import java.util.*;

import falcons.client.model.ServerLogic;
import falcons.server.network.ConnectionThread;

public class ConnectionModel {
	
	private static ConnectionModel instance = new ConnectionModel();
	private List<ConnectionThread> connections = new ArrayList<ConnectionThread>();
	
	private ConnectionModel() {
		//Do Nasing.
	}
	
	public static ConnectionModel getInstance() {
			if(instance == null){
				instance = new ConnectionModel();
			}
		return instance;
	}
	
	/**
	 * Gets the ConnectionThread with the given ID.
	 * @param id The ID of the thread wanted.
	 * @return Always check if the returned value is null, if it's null the thread was not found.
	 */
	public ConnectionThread getConnection(Long id) {
		boolean found = false;
		for(int i = 0;i<connections.size()-1; i++){
			if(connections.get(i).getId() == id){
				return connections.get(i);
			}
		}
		return null;
	}
	
	public Long getConnectionID(ConnectionThread thread) {
		return connections.get(connections.lastIndexOf(thread)).getId();
	}
	
	public void addConnection(ConnectionThread thread) {
		connections.add(thread);
	}
	
	public void removeConnection(Long id) {
		for(int i = 0; i<connections.size()-1; i++){
			if(connections.get(i).getId() == id){
				connections.remove(i);
			}
		}
	}
	
	public void removeConnection(ConnectionThread thread) {
		connections.remove(thread);
	}
	
	/**
	 * @return Returns a list with all the currently active ConnectionThreads.
	 */
	public List<ConnectionThread> getConnectionList() {
		// TODO Should be getConnection(), we don't want something to change the list. (Or perhaps return a deep copy of the list?)
		return connections;
	}

	public static HashMap<String, String> getClientPlugins(long clientID) {
		return ServerLogic.getPlugins(clientID);
	}

	public static Set<ClientInfo> getClients() {
		return ServerLogic.getClients();
	}
}
