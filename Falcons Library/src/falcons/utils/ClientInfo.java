package falcons.utils;

import java.util.HashMap;

/*
 * Class that contains information such as id, name and loaded plugins about a certain client.
 */
public class ClientInfo {
	private long id;
	private String name;
	private HashMap<String, String> plugins;
	
	/*
	 * Creates a new ClientInfo with the specified properties.
	 * 
	 * @param id	The id of the client.
	 * @param name	The name of the client.
	 * @param plugins	A HashMap<String, String> containing all the loaded plugins on the client.
	 */
	public ClientInfo(long id, String name, HashMap<String, String> plugins) {
		this.id = id;
		setName(name);
		this.plugins = new HashMap<String, String>(plugins.size(), 1);
		setPlugins(plugins);
	}
	
	/*
	 * Creates a new ClientInfo with only an id.
	 * 
	 * @param id	The id of the client.
	 */
	public ClientInfo(long id) {
		this.id = id;
	}
	
	/*
	 * Creates a new ClientInfo-object from an existing one.
	 * 
	 * @param clientInfo	The ClientInfo to make a copy of.
	 */
	public ClientInfo(ClientInfo clientInfo) {
		id = clientInfo.id;
		setName(clientInfo.getName());
		setPlugins(clientInfo.getPlugins());
	}
	
	/*
	 * Changes the name of the object.
	 * 
	 * @param name	The new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Changes the plugins loaded on the plugin.
	 * 
	 * @param plugins	The new pluginMap.
	 */
	public void setPlugins(HashMap<String, String> plugins) {
		this.plugins.putAll(plugins);
	}
	
	/*
	 * Gets the ID of the client.
	 * 
	 * @return The ID.
	 */
	public long getID() {
		return id;
	}
	
	/*
	 * Gets the name of the client.
	 * 
	 * @return The name.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Gets a HashMap<String, String> representation of the client's loaded plugins.
	 * 
	 * @return A deep copy of the pluginMap.
	 */
	public HashMap<String, String> getPlugins() {
		return (HashMap<String, String>) plugins.clone();
	}
	
	/*
	 * Checks if the ClientInfo is complete, i.e. contains both a name and a pluginMap.
	 * 
	 * @return True if the object is complete, false otherwise.
	 */
	public boolean isComplete() {
		if(name == null)
			return false;
		if(plugins == null)
			return false;
		return true;
	}
}
