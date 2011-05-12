package falcons.utils;

import java.util.HashMap;

public class ClientInfo {
	private long id;
	private String name;
	private HashMap<String, String> plugins;
	
	public ClientInfo(long id, String name, HashMap<String, String> plugins) {
		this.id = id;
		setName(name);
		this.plugins = new HashMap<String, String>(plugins.size(), 1);
		setPlugins(plugins);
	}
	
	public ClientInfo(long id) {
		this.id = id;
	}
	
	public ClientInfo(ClientInfo clientInfo) {
		id = clientInfo.id;
		setName(clientInfo.getName());
		setPlugins(clientInfo.getPlugins());
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPlugins(HashMap<String, String> plugins) {
		this.plugins.putAll(plugins);
	}
	
	public long getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public HashMap<String, String> getPlugins() {
		return (HashMap<String, String>) plugins.clone();
	}
	
	public boolean isComplete() {
		if(name == null)
			return false;
		if(plugins == null)
			return false;
		return true;
	}
}
