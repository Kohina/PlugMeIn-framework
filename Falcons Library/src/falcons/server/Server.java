package falcons.server;

import java.io.File;
import java.io.IOException;

import falcons.server.controller.DataMasterController;
import falcons.server.controller.ServerMasterController;
import falcons.server.network.ServerCommunicationCenter;
import falcons.utils.LibraryEvent;

public class Server {

	private ServerMasterController controller;
	private DataMasterController dataController;
	private ServerCommunicationCenter comCenter;
	private boolean started = false;
	private Thread serverThread;
	
	public Server() {
		controller = new ServerMasterController();
		dataController = new DataMasterController();
	}
	
	public void actionPerformed(LibraryEvent e) {
		controller.actionPerformed(e);
	}
	
	public Object getData(LibraryEvent e) {
		return dataController.getData(e);
	}
	
	public boolean startServer(){
		try {
			serverThread = new Thread((comCenter = new ServerCommunicationCenter()));
			started = true;
		} catch (IOException e) {
			System.out.println("Could not start server.");
			e.printStackTrace();
		}
		return started;
	}
	
	//TODO Need to find a better way to shut the server down.... :(
	public boolean stopServer(){
		comCenter = null;
		started = false;
		return !started;
	}
}