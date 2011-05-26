package falcons.server.model;

import org.simpleframework.xml.*;

@Root
class ServerPreferencesModel {

	private static ServerPreferencesModel instance = new ServerPreferencesModel();
	
	// Preference variables representing XML elements
	@Element
	private static int port;

	public ServerPreferencesModel() {
		// Do nasing.
	}
	
	/**
	 * 
	 * @return Returns the instance of the model
	 */
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

}
