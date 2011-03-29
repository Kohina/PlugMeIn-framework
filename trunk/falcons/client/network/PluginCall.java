package falcons.client.network;

import falcons.client.abstractions.AbstractPluginData;

public class PluginCall {

	private String PluginID;
	private AbstractPluginData pluginData;
	private int destination;
	
	/**
	 * 
	 * @param PluginID The ID of the plugin sending the call.
	 * @param pluginData The AbstractPluginData-object that contains all the relevant information for the call.
	 * @param destination The int that is an ID from the servers list of clients.
	 */
	public PluginCall(String PluginID, AbstractPluginData pluginData, int destination){
		this.PluginID = PluginID;
		this.pluginData = pluginData;
		this.destination = destination;
	}
	
	/**
	 * 
	 * @return Returns the PluginID
	 */
	public String getPluginID(){
		return PluginID;
	}
	
	/**
	 * 
	 * @return Returns the AbstractPluginData associated with the PluginCall.
	 */
	public AbstractPluginData getPluginData(){
		return pluginData;
	}
	
	/**
	 * 
	 * @return Returns the destination of the PluginCall as an int.
	 */
	public int getDestination(){
		return destination;
	}
}
