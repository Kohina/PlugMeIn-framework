package falcons.plugin;

import java.io.Serializable;

public abstract class AbstractPluginData implements Serializable {

	private final String methodID;
	private final String versionID;

	/**
	 * The constructor for an AbstructPluginData
	 * 
	 * @param methodID
	 *            The ID of the method inside the Plugin that's going to be
	 *            used.
	 * @param versionID
	 *            The ID of the version of the Plugin.
	 */
	public AbstractPluginData(String methodID, String versionID) {
		this.methodID = methodID;
		this.versionID = versionID;
	}

	/**
	 * 
	 * @return Returns the ID of the method to be used.
	 */
	public String getMethodID() {
		return methodID;
	}

	/**
	 * 
	 * @return Returns the ID of the version of the plugin that sent the data
	 *         object.
	 */
	public String getVersionID() {
		return versionID;
	}
}
