package falcons.utils;

import java.util.*;

public class ClientTree {
	private HashMap<Long, HashMap<String, String>> clientMap;
	
	/*
	 * The empty constructor which initiates an empty ClientTree.
	 */
	public ClientTree() {
		clientMap = new HashMap<Long, HashMap<String, String>>();
	}
	
	/*
	 * Initiates a new ClientTree containing all the clients in the collection, but without any plugins connected to them.
	 * 
	 * @param clients	A collection of all the clients to add.
	 */
	public ClientTree(Collection<Long> clients) {
		clientMap = new HashMap<Long, HashMap<String, String>>(clients.size());
		Iterator<Long> iterator = clients.iterator();
		
		while(iterator.hasNext()) {
			clientMap.put(iterator.next(), null);
		}
	}
	
	/*
	 * Initiates a new ClientTree containing all the clients in the collection and with plugins connected to the client node.
	 * 
	 * @param clients	A collection of all the clients to add.
	 * @param client	The client to connect the plugins to.
	 * @param plugins	A HashMap<String, String> of all the plugins to connect to client.
	 */
	public ClientTree(Set<Long> clients, long client, HashMap<String, String> plugins) {
		clientMap = new HashMap<Long, HashMap<String, String>>(clients.size());

		Iterator<Long> iterator = clients.iterator();
		
		while(iterator.hasNext()) {
			clientMap.put(iterator.next(), null);
		}
		
		clientMap.put(client, plugins);
	}
	
	/*
	 * Creates a deep copy of an existing ClientTree.
	 * 
	 * @param clientTree	The ClientTree to be copied.
	 */
	public ClientTree(ClientTree clientTree) {
		clientMap = new HashMap<Long, HashMap<String, String>>(clientTree.size());
		Iterator<Long> clientIt = clientTree.iterator();
		
		while(clientIt.hasNext()) {
			long currentClient = clientIt.next();
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
	public void add(long id, HashMap<String, String> plugins) {
		clientMap.put(id, plugins);
	}
	
	/*
	 * Adds a new client to the ClientTree, but without any plugins.
	 * 
	 * @param id	The client's id.
	 */
	public void addClient(long id) {
		clientMap.put(id, null);
	}
	
	/*
	 * Returns an Iterator<Long> which iterates over all the clients in the tree.
	 */
	public Iterator<Long> iterator() {
		return clientMap.keySet().iterator();
	}
	
	/*
	 * Returns an Iterator<String> which iterates over all keys (i.e. pluginIDs) in the pluginMap belonging to the id supplied.
	 * 
	 * @param id	The id of the client whose pluginIDs you want to iterate over.
	 */
	private Iterator<String> keyIterator(long id) {
		return clientMap.get(id).keySet().iterator();
	}
	
	/*
	 * Returns an Iterator<String> which iterates over all values (i.e. versionIDs) in the pluginMap belonging to the id supplied.
	 * 
	 * @param id	The id of the client whose versionIDs you want to iterate over.
	 */
	private Iterator<String> valueIterator(long id) {
		return clientMap.get(id).values().iterator();
	}
	
	/*
	 * Returns the actual HashMap which the ClientTree is based around.
	 */
	private HashMap<Long, HashMap<String, String>> getClientMap() {
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
	public int size(long id) {
		return clientMap.get(id).size();
	}
	
	/*
	 * Returns a HashMap containing all the plugins associated with a certain client.
	 * 
	 * @param id	The client's id.
	 */
	public HashMap<String, String> getPlugins(long id) {
		return (HashMap<String, String>) clientMap.get(id).clone();
	}
}
