package falcons.client.abstractions;

import javax.swing.JOptionPane;

import falcons.client.network.PluginCall;

public abstract class AbstractPlugin {

	private String pluginID;
	private String versionID;

	/**
	 * 
	 * @return Returns the ID of the plugin.
	 */
	public String getPluginID() {
		return pluginID;
	}

	/**
	 * 
	 * @return Returns the ID of the plugins version.
	 */
	public String getVersionID() {
		return versionID;
	}

	/**
	 * Receives a call from the server and checks what it is that it is supposed
	 * to do. Checks that the version of the plugin sending the call is the same
	 * as the receiving one.
	 * 
	 * @param call
	 *            The PluginCall from the server.
	 */
	public abstract void receiveCall(PluginCall call);
}
