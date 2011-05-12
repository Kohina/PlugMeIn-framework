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

	public ClientPreferencesModel() {
		// Do nasing.
	}
	
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

	String getName() {
		String rname = name;
		return rname;
	}
	
	void setName(String name) {
		this.name = name;
	}
}
