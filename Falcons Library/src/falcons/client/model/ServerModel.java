package falcons.client.model;

import java.util.*;

import falcons.utils.*;

// TODO Finish implementing this class
class ServerModel {
	private static ServerModel instance;
	private ClientInfo info;
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
		info = client;
	}
	
	private ClientInfo getClientWithID(long id) {
		for(ClientInfo client : clients) 
			if(client.getID() == id)
				return client;
		return null;
	}
	
	public List<ClientInfo> getClients() {
		List<ClientInfo> clients = new ArrayList<ClientInfo>(this.clients.size());
		Iterator<ClientInfo> it = this.clients.iterator();
		
		while(it.hasNext()) {
			ClientInfo currentClient = it.next();
			
			clients.add(new ClientInfo(currentClient.getID(), currentClient.getName(), currentClient.getPlugins()));
		}
		
		return clients;
	}
}
