package falcons.server.network;

import java.util.*;

public class ConnectionModel {
	
	private static ConnectionModel connectionModel = new ConnectionModel();
	private List<ConnectionThread> connections;
	
	private ConnectionModel() {
		connections = new ArrayList<ConnectionThread>();
	}
	
	public ConnectionModel getInstance() {
		return connectionModel;
	}
	
	public ConnectionThread getThread(int id) {
		return connections.get(id);
	}
	
	public void addThread(ConnectionThread thread) {
		connections.add(thread);
	}
	
	public void removeThread(int id) {
		connections.remove(id);
	}
	
	public void removeThread(ConnectionThread thread) {
		connections.remove(thread);
	}
}
