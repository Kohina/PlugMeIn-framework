package falcons.utils;

public class ClientEvent {

	public static enum ClientEventType {
		/*
		 * 
		 * ClientPreferencesEvents
		 * 
		 */
		/**
		 * Tells the controller that it should save the preferences currently
		 * loaded
		 */
		SAVE_PREFERENCES,
		/**
		 * Tells the controller that is should read the preferences from the ClientPreferences.xml
		 */
		READ_PREFERENCES,
		/**
		 * Tells the controller that it should send the currently chosen IP to the View.
		 */
		GET_IP,
		/**
		 * Tells the controller that it should send the currently chosen port to the View.
		 */
		GET_PORT,
		
		/*
		 * 
		 * PluginEvents
		 * 
		 */
		/**
		 * Tells the controller that it should load all plugins inside the "/plugins/" folder.
		 */
		LOAD_PLUGINS,
		/**
		 * Tells the controller that it should send all the currently loaded plugins to the View.
		 */
		GET_PLUGINS
	}

	private ClientEventType typeOfEvent;

	/**
	 * Creates a new ClientEvent that to be sent to the Client's controller.
	 * 
	 * @param e
	 *            This parameter is a ClientEventType. Each Type has a specified
	 *            meaning and this will tell the controller what to do.
	 */
	public ClientEvent(ClientEventType e) {
		typeOfEvent = e;
	}

	/**
	 * Returns what type of event this is.
	 * 
	 * @return The type of event, specified by a ClientEventType.
	 */
	public ClientEventType getEventType() {
		return typeOfEvent;
	}

}
