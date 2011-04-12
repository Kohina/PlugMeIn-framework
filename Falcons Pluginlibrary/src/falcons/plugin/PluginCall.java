package falcons.plugin;

import java.io.Serializable;


public class PluginCall implements Serializable {

	private String PluginID;
	private AbstractPluginData pluginData;
	private long destination;

	/**
	 * 
	 * @param plugin
	 *            The plugin sending the call.
	 * @param pluginData
	 *            The AbstractPluginData-object that contains all the relevant
	 *            information for the call.
	 * @param destination
	 *            The int that is an ID from the servers list of clients.
	 */
	public PluginCall(AbstractPlugin plugin, AbstractPluginData pluginData,
			long destination) {
		this.PluginID = plugin.getPluginID();
		this.pluginData = pluginData;
		this.destination = destination;
	}
	
	/**
	 * 
	 * @param PluginID
	 *            The ID of the plugin sending the call.
	 * @param pluginData
	 *            The AbstractPluginData-object that contains all the relevant
	 *            information for the call.
	 * @param destination
	 *            The int that is an ID from the servers list of clients.
	 */
	public PluginCall(String pluginID, AbstractPluginData pluginData,
			long destination) {
		this.PluginID = pluginID;
		this.pluginData = pluginData;
		this.destination = destination;
	}
	
	

	/**
	 * 
	 * @return Returns the PluginID
	 */
	public String getPluginID() {
		return PluginID;
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
	public long getDestination() {
		return destination;
	}
}
