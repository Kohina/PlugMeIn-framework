package falcons.client.model;

import java.util.HashMap;

import falcons.utils.*;

// TODO Finish implementing this class
class ServerModel {
	private static ServerModel instance;
	private ClientTree clientTree;
	private ClientInfo info;
	
	static ServerModel getInstance(){
		if(instance == null){
			instance = new ServerModel();
		}
		return instance;
	}
	
	public HashMap<String, String> getPlugins(ClientInfo client) {
		return clientTree.getPlugins(client);
	}
	
	public void addClient(ClientInfo client, HashMap<String, String> plugins) {
		clientTree.add(client, plugins);
	}
	
	public void addClient(ClientInfo client) {
		clientTree.add(client);
	}
	
	public int numberOfClients() {
		return clientTree.size();
	}
	
	public int numberOfPlugins(ClientInfo client) {
		return clientTree.size(client);
	}
	
	public void setInfo(long id, String name) {
		info = new ClientInfo(id, new String(name));
	}
}
