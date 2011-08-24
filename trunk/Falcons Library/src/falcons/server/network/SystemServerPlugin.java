package falcons.server.network;

import java.io.Serializable;
import java.util.*;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.plugin.PluginClientInfo;
import falcons.server.model.PluginLogic;
import falcons.server.network.model.ConnectionModel;
import falcons.utils.ClientInfo;

@Plugin(pluginID = "SystemServerPlugin", versionID = "1.0")
public class SystemServerPlugin {

	private static SystemServerPlugin instance = null;
	private ConnectionModel connectionModel = ConnectionModel.getInstance();
	private HashMap<String, String> serverPlugins;

	/**
	 * Default Contructor
	 */
	private SystemServerPlugin() {
		readPlugins();
	}

	/**
	 * @return The only instance of this class.
	 */
	public static SystemServerPlugin getInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = new SystemServerPlugin();
			return instance;
		}
	}

	public void receiveCall(PluginCall call) {
		AbstractPluginData<?> data = call.getPluginData();

		if (data.getVersionID().equals(
				this.getClass().getAnnotation(Plugin.class).versionID())) {
			if (data.getMethodID().equals("receiveClientInfo")) {
				receiveClientInfo((ClientInfo) data.getData());
			} else if (data.getMethodID().equals("deleteClient")) {
				deleteClient((ClientInfo) data.getData());
			} 
			else if(data.getMethodID().equals("getClients")){
				getClients(call.getSender(), (String) data.getData());
			}
			else if(data.getMethodID().equals("getMe")){
				getMe(call.getSender(), (String) data.getData());
			}
			else {
				System.out.println("The methodID does not exist.");
			}
		} else if (!data.getVersionID().equals(
				this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out
					.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		} else {
			System.out.println("The method ID doesn't exist.");
		}
	}

	private void getClients(int sender, String plugin) {
		List<PluginClientInfo> returnClients = new ArrayList<PluginClientInfo>();
		List<ClientInfo> clients = connectionModel.getClients();
		
		for(ClientInfo c: clients){
			if (c.getPlugins().containsKey(plugin) && c.getID() != sender) {
				returnClients.add(new PluginClientInfo(c.getID(), c.getName()));
			}
		}
		AbstractPluginData<List<PluginClientInfo>> data = new AbstractPluginData<List<PluginClientInfo>>("receiveClients", "1.0", returnClients);
		ConnectionModel.getInstance().getConnection(sender).send(new PluginCall(plugin, data, sender, -1));
	}
	
	private void getMe(int sender, String plugin){
		List<ClientInfo> clients = connectionModel.getClients();
		for(ClientInfo c: clients){
			if (c.getID() == sender) {
				AbstractPluginData<PluginClientInfo> data = new AbstractPluginData<PluginClientInfo>("receiveMe", "1.0", new PluginClientInfo(c.getID(), c.getName()));
				ConnectionModel.getInstance().getConnection(sender).send(new PluginCall(plugin, data, sender, -1));
			}
		}
	}

	private void readPlugins() {
		serverPlugins = new HashMap<String, String>(PluginLogic.getPluginMap()
				.size(), 1);
		Collection<String> pluginNames = PluginLogic.getPluginMap().keySet();

		for (String pluginName : pluginNames) {
			String pluginVersion = PluginLogic.getPluginMap().get(pluginName)
					.getClass().getAnnotation(Plugin.class).versionID();
			serverPlugins.put(pluginName, pluginVersion);
		}
	}

	private void receiveClientInfo(ClientInfo client) {
		connectionModel.addClientInfo(client.getID(), client);
	}

	private void deleteClient(ClientInfo client) {
		connectionModel.removeConnection(connectionModel.getConnection(client.getID()));
		System.out.println("Connection closed.");
	}
}
