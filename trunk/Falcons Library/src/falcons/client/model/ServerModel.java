package falcons.client.model;

import java.util.*;

import falcons.utils.*;

/**
 * @author weeeeeew
 *
 * Contains a simplified model over the server available to the client,
 * for it to be able to know which other clients are available and so on.
 * Also contains the same info about the client itself.
 * Uses the singleton design pattern.
 */
class ServerModel {
	private static ServerModel instance;
	private ClientInfo clientInfo;
	private List<ClientInfo> clients = new ArrayList<ClientInfo>();
	
	/**
	 * Returns the only instance of this class.
	 * @return The instance.
	 */
	static ServerModel getInstance(){
		if(instance == null){
			instance = new ServerModel();
		}
		return instance;
	}
	
	/**
	 * Gets the plugins associated with a certain client as a HashMap<String, String>.
	 * @param id The id of the client you want to get the plugins of.
	 * @return The plugins associated with the client.
	 */
	public HashMap<String, String> getPlugins(long id) {
		return (HashMap<String, String>) getClientWithID(id).getPlugins().clone();
	}
	
	/**
	 * Adds a client to the model.
	 * @param client The client to add.
	 */
	public void addClient(ClientInfo client) {
		clients.add(client);
	}
	
	/**
	 * Gets the number of clients loaded on the server.
	 * @return The number of clients loaded.
	 */
	public int numberOfClients() {
		return clients.size();
	}
	
	/**
	 * Gets the number of plugins loaded on a certain client.
	 * @param id The id of the client to get the number of plugins on.
	 * @return The number of plugins loaded on the client.
	 */
	public int numberOfPlugins(long id) {
		return getClientWithID(id).getPlugins().size();
	}
	
	/**
	 * Sets the info about the client itself.
	 * @param client The information that describes this client.
	 */
	public void setInfo(ClientInfo client) {
		clientInfo = client;
	}
	
	/**
	 * Gets the client with a specific id.
	 * @param id The id of the client to get.
	 * @return The client with the id if such a client exists, null otherwise.
	 */
	private ClientInfo getClientWithID(long id) {
		for(ClientInfo client : clients) 
			if(client.getID() == id)
				return client;
		return null;
	}
	
	/**
	 * Gets a deep copy of the client list.
	 * @return The list of the clients.
	 */
	public List<ClientInfo> getClients() {
		List<ClientInfo> clientsCopy = new ArrayList<ClientInfo>(clients.size());
		
		for(ClientInfo client : clients)
			clientsCopy.add(client.clone());
		return clientsCopy;
	}
	
	/**
	 * Gets a deep copy of this client's ClientInfo.
	 * @return A copy of this client's ClientInfo.
	 */
	public ClientInfo getClientInfo() {
		return clientInfo.clone();
	}
}
