package falcons.client;


import java.io.File;
import java.io.IOException;

import falcons.client.controller.ClientMasterController;
import falcons.client.controller.DataMasterController;
import falcons.client.network.ClientConnection;
import falcons.client.network.SystemClientPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.utils.PluginCall;
import falcons.utils.LibraryEvent;

// TODO Finish Implementing this class.
public class Client {
	
	private ClientMasterController controller;
	private DataMasterController dataController;
	private ClientConnection connection;
	private boolean connected = false;
	
	public Client(){
		controller = new ClientMasterController();
		dataController = new DataMasterController();
	}
	
	public void actionPerformed(LibraryEvent e){
		controller.actionPerformed(e);
	}
	
	public Object getData(LibraryEvent e){
		return dataController.getData(e);
	}
	
	public boolean connect(){
		try {
			connection = new ClientConnection();
			connected = true;
		} catch (IOException e) {
			System.out.println("Could not connect to server.");
			e.printStackTrace();
		}
		return connected;
	}
	
	public boolean disconnect(){
		SystemClientPlugin.disconnect();
		connection.closeConnection();
		connected = false;
		return !connected;
	}
}