package falcons.pluginmanager;

import javax.swing.JOptionPane;

import falcons.client.network.PluginCall;

public abstract class AbstractPlugin {

	private String pluginID;
	private String versionID;
	

	/**
	 * 
	 * @return Returns the ID of the plugin.
	 */
	public abstract String getPluginID();

	/**
	 * 
	 * @return Returns the ID of the plugins version.
	 */
	public abstract String getVersionID();

	/**
	 * Receives a call from the server and checks what it is that it is supposed
	 * to do. Checks that the version of the plugin sending the call is the same
	 * as the receiving one and that there actually exists a method with that ID.
	 * 
	 * @param call
	 *            The PluginCall from the server.
	 */
	public abstract void receiveCall(PluginCall call);
}
