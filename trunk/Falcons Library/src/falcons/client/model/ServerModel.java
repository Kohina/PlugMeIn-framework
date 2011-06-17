package falcons.client.model;

import java.util.*;

import falcons.utils.*;

// TODO Finish implementing this class
class ServerModel {
	private static ServerModel instance;
	private ClientInfo clientInfo;
	// TODO: It should only be one List or HashMap of connected clients, there is one in server/network/model/ConnectionModel.java
	private List<ClientInfo> clients = new ArrayList<ClientInfo>();
	
	static ServerModel getInstance(){
		if(instance == null){
			instance = new ServerModel();
		}
		return instance;
	}
	
	public HashMap<String, String> getPlugins(long id) {
		return getClientWithID(id).getPlugins();
	}
	
	public void addClient(ClientInfo client) {
		clients.add(client);
	}
	
	public int numberOfClients() {
		return clients.size();
	}
	
	public int numberOfPlugins(long id) {
		return getClientWithID(id).getPlugins().size();
	}
	
	public void setInfo(ClientInfo client) {
		clientInfo = client;
	}
	
	private ClientInfo getClientWithID(long id) {
		for(ClientInfo client : clients) 
			if(client.getID() == id)
				return client;
		return null;
	}
	
	public List<ClientInfo> getClients() {
		return clients;
	}
	
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
}
