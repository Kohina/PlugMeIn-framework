package falcons.server.model;

import java.util.*;

import falcons.server.network.ConnectionThread;

public class ConnectionModel {
	
	private static ConnectionModel connectionModel = new ConnectionModel();
	private List<ConnectionThread> connections = new ArrayList<ConnectionThread>();
	
	private ConnectionModel() {
		//Do Nasing.
	}
	
	public static ConnectionModel getInstance() {
		return connectionModel;
	}
	
	/**
	 * Gets the ConnectionThread with the given ID.
	 * @param id The ID of the thread wanted.
	 * @return Always check if the returned value is null, if it's null the thread was not found.
	 */
	public ConnectionThread getThread(Long id) {
		boolean found = false;
		for(int i = 0;i<connections.size()-1; i++){
			if(connections.get(i).getId() == id){
				return connections.get(i);
			}
		}
		return null;
	}
	
	public Long getID(ConnectionThread thread) {
		return connections.get(connections.lastIndexOf(thread)).getId();
	}
	
	public void addThread(ConnectionThread thread) {
		connections.add(thread);
	}
	
	public void removeThread(Long id) {
		for(int i = 0; i<connections.size()-1; i++){
			if(connections.get(i).getId() == id){
				connections.remove(i);
			}
		}
	}
	
	public void removeThread(ConnectionThread thread) {
		connections.remove(thread);
	}
}
