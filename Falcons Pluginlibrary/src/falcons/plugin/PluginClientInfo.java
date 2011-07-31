package falcons.plugin;

import java.io.Serializable;

/**
 * Class that contains information such as id, name and loaded plugins about a certain client.
 */
public class PluginClientInfo implements Serializable {
	private int id;
	private String name;
	
	/**
	 * Creates a new ClientInfo with the specified properties.
	 * 
	 * @param id	The id of the client.
	 * @param name	The name of the client.
	 * 
	 */
	public PluginClientInfo(int id, String name) {
		this.id = id;
		setName(name);
	}
	
	/**
	 * Creates a new ClientInfo with only an id.
	 * 
	 * @param id	The id of the client.
	 */
	public PluginClientInfo(int id) {
		this.id = id;
	}
	
	/**
	 * Creates a new ClientInfo-object from an existing one.
	 * 
	 * @param clientInfo	The ClientInfo to make a copy of.
	 */
	public PluginClientInfo(PluginClientInfo clientInfo) {
		id = clientInfo.id;
		setName(clientInfo.getName());
	}
	
	/**
	 * Changes the name of the object.
	 * 
	 * @param name	The new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the ID of the client.
	 * 
	 * @return The ID.
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Gets the name of the client.
	 * 
	 * @return The name.
	 */
	public String getName() {
		return name;
	}
}
