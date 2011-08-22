package falcons.client.network;

import java.io.Serializable;
import java.util.*;

import falcons.client.controller.ClientMasterController;
import falcons.client.model.ClientPreferencesLogic;
import falcons.client.model.PluginLogic;
import falcons.plugin.*;
import falcons.utils.ClientInfo;
import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

@Plugin(pluginID = "SystemClientPlugin", versionID = "1.0")
public class SystemClientPlugin implements Serializable {

	private static SystemClientPlugin instance = new SystemClientPlugin();
	private List<ClientInfo> clients;

	/**
	 * @return The only instance of this class.
	 */
	public static SystemClientPlugin getInstance() {
		return instance;
	}
	
	//TODO: Maybe clean-up?
	public void receiveCall(PluginCall call) {
		AbstractPluginData<?> data = call.getPluginData();

		if (data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			if(data.getMethodID().equals("receiveID")) {
				receiveID((Integer) data.getData());
			} else {
				System.out.println("The methodID does not exist.");
			}
		} else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		} else {
			System.out.println("The method ID doesn't exist.");
		}
	}

	private void receiveID(int id) {
		HashMap<String, String> plugins = new HashMap<String, String>(PluginLogic.getPluginMap().size(), 1);
		Collection<String> pluginNames = PluginLogic.getPluginMap().keySet();

		for(String pluginName : pluginNames){
			String pluginVersion = PluginLogic.getPluginMap().get(pluginName).getClass().getAnnotation(Plugin.class).versionID();
			plugins.put(pluginName, pluginVersion);
		}
		new ClientMasterController().actionPerformed(new LibraryEvent(LibraryEventType.SET_ID, id));
		ClientInfo info = new ClientInfo(id, ClientPreferencesLogic.getName(), plugins);
		AbstractPluginData<ClientInfo> data = new AbstractPluginData<ClientInfo>("receiveClientInfo", "1.0", info);
		ClientConnection.send(new PluginCall("SystemServerPlugin", data, -1, id));
	}

	public void disconnect() {
		//TODO: Ever client have to be able to send a identification ID so the server knows which client to remove
		//AbstractPluginData<ClientInfo> data = new AbstractPluginData<ClientInfo>("deleteClient", "1.0", ServerLogic.getClientInfo());
		//PluginCall call = new PluginCall("SystemPlugin", data, -1);
		//ClientConnection.send(call);
		AbstractPluginData<Integer> data = new AbstractPluginData<Integer>("deleteClient", "1.0");
		PluginCall call = new PluginCall("SystemServerPlugin", data, -1, -2);
	}
}
