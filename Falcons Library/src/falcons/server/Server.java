package falcons.server;

import java.io.File;
import falcons.server.controller.ServerMasterController;
import falcons.utils.LibraryEvent;

public class Server {

	private ServerMasterController controller;
	
	public Server() {
		controller = new ServerMasterController();
	}
	
	public void actionPerformed(LibraryEvent e) {
		controller.actionPerformed(e);
	}
}