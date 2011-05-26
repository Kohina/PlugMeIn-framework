package falcons.plugin;

import java.util.EventListener;

/**
 * 
 * @author Gustav
 *	An EventListener that listens to loaded plugins.
 */
public interface PluginEventListener extends EventListener{

	/**
	 * The method that tells the PluginEventListener that something has happened.
	 * @param p
	 * 			The PluginEvent that tells the PluginEventListener what has happened
	 */
	public void actionPerformed(PluginEvent p);
	
	/**
	 * The method that tells the PluginEventListener that the plugin wants some data.
	 * @param p
	 * 			The PluginEvent that tells the PluginEventListener what has happened
	 * @return
	 * 			The data that was requested
	 */
	public Object getData(PluginEvent p);
}