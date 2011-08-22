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

	/**
	 * Default Contructor
	 */
	public Server() {
		controller = new ServerMasterController();
		dataController = new DataMasterController();
	}

	/**
	 * The method that tells what the server-implementation wants the library to do
	 * @param e
	 * 			The LibraryEvent that tells the library what to do.
	 */
	public void actionPerformed(LibraryEvent e) {
		controller.actionPerformed(e);
	}

	/**
	 * This method fetches data from the library's model.
	 * @param e The type of data to be fetched
	 * @return The data to be fetched
	 */
	public Object getData(LibraryEvent e) {
		return dataController.getData(e);
	}

	/**
	 * Starts the server
	 * @return
	 * 			True if server successfully started.
	 */
	public boolean startServer(){
		try {
			comCenter = new ServerCommunicationCenter();
			serverThread = new Thread(comCenter);
			serverThread.start();
			started = true;
		} catch (IOException e) {
			System.out.println("Could not start server.");
			e.printStackTrace();
		}
		return started;
	}

	//TODO Need to find a better way to shut the server down.... :(
	
	/**
	 * Stops the server
	 * @return
	 * 			True if the server was stopped.
	 */
	public boolean stopServer(){
		comCenter.shutdown();
		started = false;
		return !started;
	}
}