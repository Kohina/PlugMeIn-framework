package falcons.client.model;

import org.simpleframework.xml.*;

@Root
class ClientPreferencesModel {

	private static ClientPreferencesModel instance = new ClientPreferencesModel();
	
	// Preference variables representing XML elements
	@Element
	private int port;

	@Element
	private String ip;
	
	@Element
	private String name;
	
	@Element
	private int ID;

	public ClientPreferencesModel() {
		// Do nasing.
	}
	
	/**
	 * Returns the instance of the {@link ClientPreferencesModel}.
	 * @return The instance.
	 */
	static ClientPreferencesModel getInstance() {
		if(instance == null){
			instance = new ClientPreferencesModel();
		}
		return instance;
	}

	/**
	 * @return the port
	 */
	int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the ip
	 */
	String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Returns the name of the object.
	 * @return A string object containing the name.
	 */
	String getName() {
		String rname = name;
		return rname;
	}
	
	/**
	 * Sets the name of the object.
	 * @param name The name to update with.
	 */
	void setName(String name) {
		this.name = name;
	}

	public void setID(int id) {
		ID = id;
	}

	public int getID() {
		return ID;
	}
}
