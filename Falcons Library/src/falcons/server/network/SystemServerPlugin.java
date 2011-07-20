package falcons.server.network;

import java.io.Serializable;
import java.util.*;

import falcons.client.model.ServerLogic;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.server.model.PluginLogic;
import falcons.server.network.model.ConnectionModel;
import falcons.utils.ClientInfo;

@Plugin(pluginID = "SystemPlugin", versionID = "1.0")
public class SystemServerPlugin {

	private static SystemServerPlugin instance = null;
	private ConnectionModel connectionModel = ConnectionModel.getInstance();
	private List<ClientInfo> clients;
	private HashMap<String, String> serverPlugins;

	/**
	 * Default Contructor
	 */
	private SystemServerPlugin() {
		clients = new ArrayList<ClientInfo>();
		readPlugins();
		updateClients();
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
				broadcastClients();
			} else if (data.getMethodID().equals("deleteClient")) {
				deleteClient((ClientInfo) data.getData());
				broadcastClients();
			/*} else if (data.getMethodID().equals("getClients")){
				System.out.println("Here SystemServerPlugin");
				ArrayList dataArray = (ArrayList) data.getData();
				Long id = Long.parseLong((String)dataArray.get(1));
				getClients((String)dataArray.get(0), id);*/
			} else {
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

	/*private void getClients(String plugin, Long id) {
		
		List<ClientInfo> clients = connectionModel.getClients();
		HashMap<String, Long> hm = new HashMap<String, Long>();
		for(ClientInfo c : clients){
			hm.put(c.getName(), c.getID());
		}
		
		AbstractPluginData<HashMap<String, Long>> data = new AbstractPluginData<HashMap<String, Long>>("getClients", "0.1", hm);
		PluginCall call = new PluginCall(plugin, data, id);
		connectionModel.getConnection(id).send(call);
		System.out.println("Here SystemServerPlugin");
	}*/

	public void sendClientID(long id) {
		AbstractPluginData<Long> data = new AbstractPluginData<Long>(
				"receiveID", "1.0", id);
		PluginCall call = new PluginCall("SystemPlugin", data, id);
		connectionModel.getConnection(id).send(call);
	}

	private void updateClients() {
		Collection<ClientInfo> clientList = connectionModel.getConnectionList()
				.values();

		for (ClientInfo client : clientList) {
			if (client != null) {
				this.clients.add(client);
			}
		}

		this.clients.retainAll(clientList);
		this.clients.add(new ClientInfo(-1, "Server", serverPlugins));
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

	private void sendClients(long id) {
		if (id != -1) {
			// TODO Move the updateClients() call to where we actually update
			// the List of connections to increase efficiency.
			AbstractPluginData<List<ClientInfo>> data = new AbstractPluginData<List<ClientInfo>>(
					"receiveClients", "1.0", clients);
			PluginCall call = new PluginCall("SystemPlugin", data, id);
			connectionModel.getConnection(id).send(call);
		}
	}

	private void receiveClientInfo(ClientInfo client) {
		connectionModel.addClientInfo(client.getID(), client);
		updateClients();
	}

	private void deleteClient(ClientInfo client) {
		connectionModel.removeConnection(connectionModel.getConnection(client.getID()));
		System.out.println("Connection closed.");
		updateClients();
	}
	
	//Sends the clientList to all connected clients
	private void broadcastClients() {
		updateClients();
		for (ClientInfo client : clients)
			sendClients(client.getID());
	}
}
