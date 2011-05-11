package falcons.plugin.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;

// TODO: Check
public class PluginEvent {

	public static enum PluginEventType{
		// TODO: Comment plix
		SEND,
		
		GET_PLUGINMAP,
		
		GET_CLIENTS
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
	 * Returns the type of the event
	 * 
	 * @return PluginEventType (enum)
	 */
	public PluginEventType getTypeOfEvent(){
		return typeOfEvent;
	}
}