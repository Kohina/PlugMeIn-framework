package falcons.communication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.server.network.ConnectionThread;

public class SystemPlugin implements Serializable {
	List<Long> connections;
	HashMap<String, String> plugins;
	
	public SystemPlugin(List<ConnectionThread> connections, List<AbstractPlugin> plugins) {
		for(int i = 0; i < connections.size(); i++) {
			this.connections.add(connections.get(i).getId());
		}
		
		for(int i = 0; i < plugins.size(); i++) {
			this.plugins.put(plugins.get(i).getPluginID(), plugins.get(i).getVersionID());
		}
	}
}
