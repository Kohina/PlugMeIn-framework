package falcons.plugin;

import java.io.Serializable;

public class PluginCall implements Serializable {

	private String pluginID;
	private AbstractPluginData pluginData;
	private int destination;
	private int sender;

	/**
	 * Creates a new PluginCall based on a plugin.
	 * 
	 * @param plugin
	 *            The plugin sending the call.
	 * @param pluginData
	 *            The AbstractPluginData-object that contains all the relevant
	 *            information for the call.
	 * @param destination
	 *            The int that is an ID from the servers list of clients.
	 * @param sender
	 * 				The ID of the client that's sending the PluginCall.
	 */
	public PluginCall(AbstractPlugin plugin, AbstractPluginData pluginData, int destination, int sender) {
		this.pluginID = plugin.getClass().getAnnotation(Plugin.class).pluginID();
		this.pluginData = pluginData;
		this.destination = destination;
		this.sender = sender;
	}
	
	/**
	 * Creates a new PluginCall based on the name of a plugin as a String.
	 * 
	 * @param pluginID
	 *            The ID of the plugin sending the call.
	 * @param pluginData
	 *            The AbstractPluginData-object that contains all the relevant
	 *            information for the call.
	 * @param destination
	 *            The int that is an ID from the servers list of clients.
	 * @param sender
	 * 				The ID of the client that's sending the PluginCall.
	 */
	public PluginCall(String pluginID, AbstractPluginData pluginData, int destination, int sender) {
		this.pluginID = pluginID;
		this.pluginData = pluginData;
		this.destination = destination;
		this.sender = sender;
	}

	/**
	 * 
	 * @return Returns the PluginID as a String.
	 */
	public String getPluginID() {
		return pluginID;
	}

	/**
	 * 
	 * @return Returns the AbstractPluginData associated with the PluginCall.
	 */
	public AbstractPluginData getPluginData() {
		return pluginData;
	}

	/**
	 * 
	 * @return Returns the destination of the PluginCall as an int.
	 */
	public int getDestination() {
		return destination;
	}
	
	/**
	 * 
	 * @return Returns the ID of the client that sent the PluginCall.
	 */
	public int getSender() {
		return sender;
	}

	/**
	 * 
	 * @param sender
	 * 			Sets the sender of the PluginCall.
	 */
	public void setSender(int sender) {
		this.sender = sender;
	}
}
