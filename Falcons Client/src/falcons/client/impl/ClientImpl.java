package falcons.client.impl;

import java.io.File;
import java.util.HashMap;

import falcons.client.Client;
import falcons.client.impl.view.ClientSystemTray;
import falcons.client.impl.view.ClientView;
import falcons.client.impl.view.ConnectionView;
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
		
		client.actionPerformed(new LibraryEvent(LibraryEventType.LOAD_PLUGINS));		
		HashMap<String, Pluggable> pluginMap = ((HashMap<String, Pluggable>) client.getData(new LibraryEvent(LibraryEventType.GET_PLUGINS))); 

		Object[] nameSet = pluginMap.keySet().toArray();
		
		for(Object o : nameSet){
			String pluginName = o.toString();
			AbstractPlugin plugin = (AbstractPlugin) pluginMap.get(pluginName);
			clientView.addTab(pluginName, plugin.getMainPanel());
		}
	}

	
}
