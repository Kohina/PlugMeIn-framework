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
		/**
		 * Tells the controller that it should set the IP.
		 */
		SET_IP,
		/**
		 * Tells the controller that it should set the port.
		 */
		SET_PORT,
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
		 * Tells the controller that it should return the plugin with the supplied ID.
		 */
		GET_PLUGIN
	}
	
	private String ID;

	private LibraryEventType typeOfEvent;
	private Object data;

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
	
	/**
	 * Creates a new ClientEvent that is to be sent to the client/server
	 * @param e
	 * 			This is a ClientEventType. Each Type has a specified meaning
	 * 			and this will tell the controller what to do
	 * @param id
	 * 			The ID of a specified Plugin
	 */
	public LibraryEvent(LibraryEventType e, String id) {
		ID = id;
		typeOfEvent = e;
	}
	
	/**
	 * Creates a new ClientEvent that is to be sent to the client/server
	 * @param e
	 * 			This is a ClientEventTyp that specifies what the implementation
	 * 			wants to do
	 * @param data
	 * 			This is the data that the ClientEventType needs to send to the implementation
	 */
	public LibraryEvent(LibraryEventType e, Object data ) {
		typeOfEvent = e;
		this.data = data;
	}

	/**
	 * Returns what type of event this is.
	 * 
	 * @return The type of event, specified by a ClientEventType.
	 */
	public LibraryEventType getEventType() {
		return typeOfEvent;
	}

	/**
	 * 
	 * @return Returns the data associated with the Event
	 */
	public Object getData() {
		return data;
	}
	
	/**
	 * 
	 * @return Returns the ID Associated wih the Event
	 */
	public String getId() {
		return ID;
	}
}
