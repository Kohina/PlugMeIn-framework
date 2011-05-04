package falcons.client;

import java.io.File;
import falcons.client.model.ClientPreferencesLogic;
import falcons.client.model.PluginLogic;
import falcons.client.network.ClientDataInterpreter;
import falcons.client.view.ClientSystemTray;
import falcons.client.view.ClientView;
import falcons.client.view.ConnectionView;

public class Client{
	
	private static ClientView clientView;
	private static ConnectionView connectionView;
	private static ClientSystemTray systemTray;	
	
	public static final File DIR = new File(System.getProperty("user.dir"));

	public void run(){
		ClientPreferencesLogic.readPreferences();
		PluginLogic.loadPlugins();

		clientView = new ClientView();
		connectionView = new ConnectionView();
		systemTray = new ClientSystemTray(clientView, connectionView);

		Object[] nameSet = PluginLogic.getPluginMap().keySet().toArray();
		
		for(Object o : nameSet){
			String pluginName = o.toString();
			clientView.addTab(pluginName, PluginLogic.getPluginMap().get(pluginName).getMainPanel());
		}
	}

	
}
