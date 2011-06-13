package falcons.client.network;

import java.io.Serializable;
import java.util.*;

import falcons.client.model.ClientPreferencesLogic;
import falcons.client.model.PluginLogic;
import falcons.client.model.ServerLogic;
import falcons.plugin.*;
import falcons.utils.ClientInfo;

@Plugin(pluginID = "SystemPlugin", versionID = "1.0")
public class SystemClientPlugin implements Serializable {

	private static SystemClientPlugin instance = new SystemClientPlugin();
	private List<ClientInfo> clients;

	/**
	 * @return The only instance of this class.
	 */
	public static SystemClientPlugin getInstance() {
		return instance;
	}

	public void receiveCall(PluginCall call) {
		AbstractPluginData<?> data = call.getPluginData();

		if (data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			if(data.getMethodID().equals("receiveID")) {
				receiveID((Long) data.getData());
				sendClientInfo();
			} else if(data.getMethodID().equals("receiveClients")) {
				receiveClients((List<ClientInfo>) call.getPluginData().getData());
			} else {
				System.out.println("The methodID does not exist.");
			}
		} else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		} else {
			System.out.println("The method ID doesn't exist.");
		}
	}

	private void receiveID(Long id) {
		HashMap<String, String> plugins = new HashMap<String, String>(PluginLogic.getPluginMap().size(), 1);
		Collection<String> pluginNames = PluginLogic.getPluginMap().keySet();

		for(String pluginName : pluginNames){
			String pluginVersion = PluginLogic.getPluginMap().get(pluginName).getClass().getAnnotation(Plugin.class).versionID();
			plugins.put(pluginName, pluginVersion);
		}
		ServerLogic.setInfo(id, ClientPreferencesLogic.getName(), plugins);
	}

	private void sendClientInfo() {
		AbstractPluginData<ClientInfo> data = new AbstractPluginData<ClientInfo>("receiveClientInfo", "1.0", ServerLogic.getClientInfo());
		PluginCall call = new PluginCall("SystemPlugin", data, -1);
		ClientConnection.send(call);
	}

	private void receiveClients(List<ClientInfo> clients) {
		for(ClientInfo client : clients) {
			ServerLogic.addClient(client);
		}
	}

	public void disconnect() {
		AbstractPluginData<ClientInfo> data = new AbstractPluginData<ClientInfo>("deleteClient", "1.0", ServerLogic.getClientInfo());
		PluginCall call = new PluginCall("SystemPlugin", data, -1);
		ClientConnection.send(call);
	}
}
