package falcons.utils;

import java.util.*;

public class ClientTree {
	private HashMap<ClientInfo, HashMap<String, String>> clientMap;
	
	/*
	 * The empty constructor which initiates an empty ClientTree.
	 */
	public ClientTree() {
		clientMap = new HashMap<ClientInfo, HashMap<String, String>>();
	}
	
	/*
	 * Creates a new ClientTree containing the specified client and plugins.
	 * 
	 * @param id	The id of the client to add.
	 * @param plugins	The pluginMap containing all the plugins tied to the specified client. 
	 */
	public ClientTree(ClientInfo client, HashMap<String, String> plugins) {
		clientMap = new HashMap<ClientInfo, HashMap<String, String>>();
		
		clientMap.put(client, plugins);
	}
	
	/*
	 * Creates a deep copy of an existing ClientTree.
	 * 
	 * @param clientTree	The ClientTree to be copied.
	 */
	public ClientTree(ClientTree clientTree) {
		clientMap = new HashMap<ClientInfo, HashMap<String, String>>(clientTree.size());
		Iterator<ClientInfo> clientIt = clientTree.iterator();
		
		while(clientIt.hasNext()) {
			ClientInfo currentClient = clientIt.next();
			Iterator<String> keyIt = clientTree.keyIterator(currentClient);
			Iterator<String> valueIt = clientTree.valueIterator(currentClient);
			HashMap<String, String> pluginMap = new HashMap<String, String>(clientTree.size(currentClient));
			
			while(keyIt.hasNext()) {
				pluginMap.put(keyIt.next(), valueIt.next());
			}
			
			clientMap.put(currentClient, pluginMap);
		}
	}
	
	/*
	 * Adds a new client and its plugins to the ClientTree.
	 * 
	 * @param id	The client's id.
	 * @param plugins	The client's plugins.
	 */
	public void add(ClientInfo client, HashMap<String, String> plugins) {
		clientMap.put(client, plugins);
	}
	
	/*
	 * Adds a new client to the ClientTree, but without any plugins.
	 * 
	 * @param id	The client's id.
	 */
	public void add(ClientInfo client) {
		clientMap.put(client, null);
	}
	
	public void add(ClientTree clientTree) {
		Iterator<ClientInfo> clientIt = clientTree.iterator();
		
		while(clientIt.hasNext()) {
			ClientInfo currentClient = clientIt.next();
			
			clientMap.put(currentClient, (HashMap<String, String>) clientTree.getPlugins(currentClient).clone());
		}
	}
	
	/*
	 * Returns an Iterator<Long> which iterates over all the clients in the tree.
	 */
	public Iterator<ClientInfo> iterator() {
		return clientMap.keySet().iterator();
	}
	
	/*
	 * Returns an Iterator<String> which iterates over all keys (i.e. pluginIDs) in the pluginMap belonging to the id supplied.
	 * 
	 * @param id	The id of the client whose pluginIDs you want to iterate over.
	 */
	public Iterator<String> keyIterator(ClientInfo client) {
		return clientMap.get(client).keySet().iterator();
	}
	
	/*
	 * Returns an Iterator<String> which iterates over all values (i.e. versionIDs) in the pluginMap belonging to the id supplied.
	 * 
	 * @param id	The id of the client whose versionIDs you want to iterate over.
	 */
	public Iterator<String> valueIterator(ClientInfo client) {
		return clientMap.get(client).values().iterator();
	}
	
	/*
	 * Returns the actual HashMap which the ClientTree is based around.
	 */
	private HashMap<ClientInfo, HashMap<String, String>> getClientMap() {
		return clientMap;
	}
	
	/*
	 * Returns the number of clients in the ClientTree.
	 */
	public int size() {
		return clientMap.size();
	}
	
	/*
	 * Returns the number of plugins associated with a certain client.
	 * 
	 * @param id	The client's id.
	 */
	public int size(ClientInfo client) {
		return clientMap.get(client).size();
	}
	
	/*
	 * Returns a HashMap containing all the plugins associated with a certain client.
	 * 
	 * @param id	The client's id.
	 */
	public HashMap<String, String> getPlugins(ClientInfo client) {
		
		return (HashMap<String, String>) clientMap.get(client).clone();
	}
}
