package falcons.utils;

public class LibraryEvent {

	public static enum LibraryEventType {
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
		 * Tells the controller that it should return the IP.
		 */
		GET_IP,
		/**
		 * Tells the controller that it should return the Port.
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
		 * Tells the controller that it should return all loaded plugins.
		 */
		GET_PLUGINS,
		/*
		 * 
		 * ClientEvents
		 * 
		 */
		/**
		 * Tells the controller that it should return all clients connected to the server.
		 */
		GET_CLIENTS,
		/**
		 * Tells the controller that it should return all plugins connected to a specified client.
		 */
		GET_CLIENTPLUGINS,
		/**
		 * Tells the controller that it shoudl return the plugin with the supplied ID.
		 */
		GET_PLUGIN
	}
	
	private String ID;

	private LibraryEventType typeOfEvent;

	/**
	 * Creates a new ClientEvent that to be sent to the Client's controller.
	 * 
	 * @param e
	 *            This parameter is a ClientEventType. Each Type has a specified
	 *            meaning and this will tell the controller what to do.
	 */
	public LibraryEvent(LibraryEventType e) {
		typeOfEvent = e;
	}
	
	public LibraryEvent(LibraryEventType e, String ID){
		typeOfEvent = e;
		this.ID = ID;
	}

	/**
	 * Returns what type of event this is.
	 * 
	 * @return The type of event, specified by a ClientEventType.
	 */
	public LibraryEventType getEventType() {
		return typeOfEvent;
	}
	
	public String getId(){
		return ID;
	}

}
