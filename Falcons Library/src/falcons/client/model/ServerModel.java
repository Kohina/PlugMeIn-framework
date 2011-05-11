package falcons.client.model;

import java.util.HashMap;

import falcons.utils.ClientTree;

// TODO Finish implementing this class
class ServerModel {
	private static ServerModel instance;
	private ClientTree clientTree;
	private long id;
	
	static ServerModel getInstance(){
		if(instance == null){
			instance = new ServerModel();
		}
		return instance;
	}
	
	public HashMap<String, String> getPlugins(long id) {
		return clientTree.getPlugins(id);
	}
	
	public void addClient(long id, HashMap<String, String> plugins) {
		clientTree.add(id, plugins);
	}
	
	public void addClient(long id) {
		clientTree.add(id);
	}
	
	public int numberOfClients() {
		return clientTree.size();
	}
	
	public int numberOfPlugins(long id) {
		return clientTree.size(id);
	}
	
	public void setID(long id) {
		this.id = id;
	}
}
