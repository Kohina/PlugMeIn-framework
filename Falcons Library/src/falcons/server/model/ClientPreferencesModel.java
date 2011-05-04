package falcons.server.model;

import org.simpleframework.xml.*;

@Root
class ClientPreferencesModel {

	private static ClientPreferencesModel instance = new ClientPreferencesModel();
	
	// Preference variables representing XML elements
	@Element
	private static int port;

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

}
