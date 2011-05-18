package falcons.plugin;

import java.io.IOException;
import java.io.ObjectOutputStream;


public class PluginEvent {
	
	private PluginCall call;

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
	
	public void addPluginCall(PluginCall call) {
		this.call = call;
	}

	public PluginCall getPluginCall() {
		return call;
	}
}