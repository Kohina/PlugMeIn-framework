package falcons.client;

import java.io.File;
import java.util.HashMap;

import falcons.client.model.ClientPreferencesLogic;
import falcons.client.model.PluginLogic;
import falcons.client.network.ClientDataInterpreter;
import falcons.client.view.ClientSystemTray;
import falcons.client.view.ClientView;
import falcons.client.view.ConnectionView;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;
import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class ClientImpl{
	
	private static ClientView clientView;
	private static ConnectionView connectionView;
	private static ClientSystemTray systemTray;	
	private static Client client;
	
	public static final File DIR = new File(System.getProperty("user.dir"));

	public void run(){
		clientView = new ClientView();
		connectionView = new ConnectionView();
		systemTray = new ClientSystemTray(clientView, connectionView);
		client = new Client();
		
		LibraryEvent event = new LibraryEvent(LibraryEventType.LOAD_PLUGINS);
		client.actionPerformed(event);
		
		LibraryEvent event2 = new LibraryEvent(LibraryEventType.GET_PLUGINS);		
		HashMap<String, Pluggable> pluginMap = ((HashMap<String, Pluggable>) client.getData(event2)); 

		Object[] nameSet = pluginMap.keySet().toArray();
		
		for(Object o : nameSet){
			String pluginName = o.toString();
			AbstractPlugin plugin = (AbstractPlugin) pluginMap.get(pluginName);
			clientView.addTab(pluginName, plugin.getMainPanel());
		}
	}

	
}
