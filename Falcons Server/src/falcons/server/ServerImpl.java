package falcons.server;

import java.util.HashMap;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;
import falcons.server.view.ServerView;
import falcons.server.view.ServerSystemTray;
import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class ServerImpl {
	
	private ServerView serverView;
	private static ServerSystemTray tray;
	private static Server server;
	
	public void run(){
		serverView = new ServerView();
		server = new Server();
		tray = new ServerSystemTray(serverView);
		server.actionPerformed(new LibraryEvent(LibraryEventType.LOAD_PLUGINS));
		server.actionPerformed(new LibraryEvent(LibraryEventType.READ_PREFERENCES));
		
		HashMap<String, Pluggable> pluginMap = ((HashMap<String, Pluggable>) server.getData(new LibraryEvent(LibraryEventType.GET_PLUGINS)));

		Object[] nameSet = pluginMap.keySet().toArray();

		for(Object o : nameSet){
			String pluginName = o.toString();
			AbstractPlugin plugin = (AbstractPlugin) pluginMap.get(pluginName);
			serverView.addTab(pluginName, plugin.getMainPanel());
		}
		
		server.startServer();
	}

}
