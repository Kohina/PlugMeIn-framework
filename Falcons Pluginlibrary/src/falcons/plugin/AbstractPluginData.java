package falcons.plugin;

import java.io.Serializable;


public class AbstractPluginData<E> implements Serializable, Pluggable {

	private final String methodID;
	private final String versionID;
	private final E data;
	
	/**
	 * The default constructor for AbstractPluginData, sets everything to null. Should generally not be used.
	 */
	protected AbstractPluginData() {
		methodID = null;
		versionID = null;
		data = null;
	}

	/**
	 * The constructor for an AbstructPluginData without the actual data.
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
		data = null;
	}
	
	/**
	 * The constructor for an AbstructPluginData.
	 * 
	 * @param methodID
	 *            The ID of the method inside the Plugin that's going to be
	 *            used.
	 * @param versionID
	 *            The ID of the version of the Plugin.
	 */
	public AbstractPluginData(String methodID, String versionID, E data) {
		this.methodID = methodID;
		this.versionID = versionID;
		this.data = data;
	}

	/**
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
	
	/**
	 * 
	 * @return Returns the Data that is included inside this object.
	 */
	public E getData() {
		return data;
	}
}
