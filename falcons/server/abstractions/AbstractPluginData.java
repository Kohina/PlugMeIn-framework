package falcons.server.abstractions;

public abstract class AbstractPluginData {

	private String methodID;
	private String versionID;

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
