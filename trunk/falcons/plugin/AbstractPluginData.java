package falcons.plugin;

public abstract class AbstractPluginData {

	private String methodID;
	private String versionID;

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
