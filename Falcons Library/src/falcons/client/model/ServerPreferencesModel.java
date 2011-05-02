package falcons.client.model;

import org.simpleframework.xml.*;

@Root
class ServerPreferencesModel {

	private static ServerPreferencesModel instance = new ServerPreferencesModel();
	
	// Preference variables representing XML elements
	@Element
	private static int port;

	@Element
	private static String ip;

	public ServerPreferencesModel() {
		// Do nasing.
	}
	
	public static ServerPreferencesModel getInstance() {
		if(instance == null){
			instance = new ServerPreferencesModel();
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
		ServerPreferencesModel.port = port;
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
		ServerPreferencesModel.ip = ip;
	}
}
