package falcons.server.network;

import java.util.*;

public class ConnectionModel {
	
	private static ConnectionModel connectionModel = new ConnectionModel();
	private List<ConnectionThread> connections = new ArrayList<ConnectionThread>();
	
	private ConnectionModel() {
		//Do Nothing.
	}
	
	public static ConnectionModel getInstance() {
		return connectionModel;
	}
	
	public ConnectionThread getThread(int id) {
		return connections.get(id);
	}
	
	public int getID(ConnectionThread thread) {
		return connections.lastIndexOf(thread);
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
