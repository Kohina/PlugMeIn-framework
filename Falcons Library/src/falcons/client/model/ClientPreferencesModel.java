package falcons.client.model;

import org.simpleframework.xml.*;

@Root
class ClientPreferencesModel {

	private static ClientPreferencesModel instance = new ClientPreferencesModel();
	
	// Preference variables representing XML elements
	@Element
	private static int port;

	@Element
	private static String ip;
	
	@Element
	private static String name;

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
	static int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	static void setPort(int port) {
		ClientPreferencesModel.port = port;
	}

	/**
	 * @return the ip
	 */
	static String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	static void setIp(String ip) {
		ClientPreferencesModel.ip = ip;
	}

	static String getName() {
		String rname = name;
		return rname;
	}
	
	static void setName(String name) {
		this.name = name;
	}
}
