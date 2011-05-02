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

	public ClientPreferencesModel() {
		// Do nasing.
	}
	
	public static ClientPreferencesModel getInstance() {
		if(instance == null){
			instance = new ClientPreferencesModel();
		}
		return instance;
	}

	/**
	 * @return the port
	 */
	public static int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public static void setPort(int port) {
		ClientPreferencesModel.port = port;
	}

	/**
	 * @return the ip
	 */
	public static String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public static void setIp(String ip) {
		ClientPreferencesModel.ip = ip;
	}
}
