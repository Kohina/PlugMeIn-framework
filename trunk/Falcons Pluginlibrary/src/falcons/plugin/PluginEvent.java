package falcons.plugin;

import java.io.IOException;
import java.io.ObjectOutputStream;


public class PluginEvent {
	
	private PluginCall call;

	public static enum PluginEventType{
		/**
		 * Tells the PluginEventListener that it should send a call included in the PluginEvent-object.
		 */
		SEND,
		
		/**
		 * Tells the PluginEventListener that it should return a map with the currently loaded plugins
		 * that looks like this: HashMap<String, Pluggable>
		 */
		GET_PLUGINMAP,
		
		/**
		 * Tells the PluginEventListener that it should return a map with the currently connected clients
		 * that looks like this: HashMap<String, Long>
		 */
		GET_CLIENTS, 
		
		/**
		 * Tells the PluginEventListener that it should return a long that is the ID of the client/server
		 * that has loaded the plugin.
		 */
		GET_CLIENTID
	}
	
	private PluginEventType typeOfEvent;

	/**
	 * Constructor that sets PluginEventType
	 * 
	 * @param e - This is a PluginEventType (enum) that will tell the controller the task to be done
	 */
	public PluginEvent(PluginEventType e){
		typeOfEvent = e;
	}
	
	/**
	 * Constructor that sets the PluginEventType and includes a PluginCall in the event.
	 * 
	 * @param e This si a PluginEventType (enum) that tells the controller what task to perform
	 * @param call This is a PluginCall that is to be sent somewhere
	 */
	public PluginEvent(PluginEventType e, PluginCall call){
		typeOfEvent = e;
		this.call = call;
	}
	
	/**
	 * Returns the type of the event
	 * 
	 * @return PluginEventType (enum)
	 */
	public PluginEventType getTypeOfEvent(){
		return typeOfEvent;
	}
	
	/**
	 * Adds a PluginCall to the Event
	 * @param call
	 * 				the call that is to be added
	 */
	public void addPluginCall(PluginCall call) {
		this.call = call;
	}
	
	/**
	 * Returns the PluginCall that is included in the Event.
	 * @return
	 * 			Returns the PluginCall
	 */
	public PluginCall getPluginCall() {
		return call;
	}
}