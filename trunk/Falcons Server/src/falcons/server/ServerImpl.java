package falcons.server;

import falcons.server.view.ServerSystemTray;
import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class ServerImpl {
	
	private static ServerSystemTray tray;
	private static Server server;
	
	public void run(){
		server = new Server();
		tray = new ServerSystemTray();
		server.actionPerformed(new LibraryEvent(LibraryEventType.LOAD_PLUGINS));
		server.actionPerformed(new LibraryEvent(LibraryEventType.READ_PREFERENCES));
		server.startServer();
	}

}
