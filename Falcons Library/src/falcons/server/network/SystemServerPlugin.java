package falcons.server.network;

import java.io.Serializable;
import java.util.*;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Plugin;
import falcons.plugin.utils.PluginCall;
import falcons.server.model.ConnectionModel;
import falcons.server.model.PluginLogic;
import falcons.utils.ClientInfo;

@Plugin(pluginID = "SystemPlugin", versionID = "1.0")
public class SystemServerPlugin implements Serializable {
	
	private static SystemServerPlugin instance = new SystemServerPlugin();
	private PluginLogic pluginLogic = PluginLogic.getInstance();
	private ConnectionModel connectionModel = ConnectionModel.getInstance();
	private List<ClientInfo> clients;
	private HashMap<String, String> serverPlugins;
	
	private SystemServerPlugin() {
		readPlugins();
	}
	
	/**
	 * @return The only instance of this class.
	 */
	public SystemServerPlugin getInstance() {
		return instance;
	}
	
	public void receiveCall(PluginCall call) {
		AbstractPluginData<?> data = call.getPluginData();
		
		if (data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			if(data.getMethodID().equals("receiveClientInfo")) {
				recieveClientInfo((ClientInfo) data.getData());
				broadcastClients();
			} else if(data.getMethodID().equals("deleteClient")) {
				deleteClient((ClientInfo) data.getData());
			} else {
				System.out.println("The methodID does not exist.");
			}
		} else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		} else {
			System.out.println("The method ID doesn't exist.");
		}
	}
	
	public void sendClientID(long id) {
		AbstractPluginData<Long> data = new AbstractPluginData<Long>("recieveID", "SystemPlugin", id);
		PluginCall call = new PluginCall("SystemPlugin", data, id);
		connectionModel.getConnection(id).send(call);
	}
	
	private void updateClients() {
		Collection<ClientInfo> clients = connectionModel.getConnectionList().values();
		
		for(ClientInfo client : clients) {
			this.clients.add(client);
		}
		
		this.clients.retainAll(clients);
		this.clients.add(new ClientInfo(-1, "Server", serverPlugins));
	}
	
	private void readPlugins() {
		serverPlugins = new HashMap<String, String>(PluginLogic.getPluginMap().size(), 1);
		Collection<String> pluginNames = PluginLogic.getPluginMap().keySet();
		
		for(String pluginName : pluginNames){
			String pluginVersion = PluginLogic.getPluginMap().get(pluginName).getClass().getAnnotation(Plugin.class).versionID();
			serverPlugins.put(pluginName, pluginVersion);
		}
	}
	
	private void sendClients(long id) {
		updateClients();
		// TODO Move the updateClients() call to where we actually update the List of connections to increase efficiency.
		AbstractPluginData<List<ClientInfo>> data = new AbstractPluginData<List<ClientInfo>>("recieveClients", "SystemPlugin", clients);
		PluginCall call = new PluginCall("SystemPlugin", data, id);
		connectionModel.getConnection(id).send(call);
	}
	
	private void recieveClientInfo(ClientInfo client) {
		connectionModel.addClientInfo(client.getID(), client);
	}
	
	private void deleteClient(ClientInfo client) {
		connectionModel.removeConnection(connectionModel.getConnection(client.getID()));
	}
	
	private void broadcastClients() {
		for(ClientInfo client : clients) 
			sendClients(client.getID());
	}
}
