package falcons.client;


import java.io.File;
import java.io.IOException;

import falcons.client.controller.ClientMasterController;
import falcons.client.controller.DataMasterController;
import falcons.client.network.ClientConnection;
import falcons.client.network.SystemClientPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.PluginCall;
import falcons.utils.LibraryEvent;

// TODO Finish Implementing this class.
public class Client {

	private ClientMasterController controller;
	private DataMasterController dataController;
	private ClientConnection connection = null;
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
		connection = ClientConnection.getInstance();
		connected = true;
		return connected;
	}

	public boolean disconnect(){
		SystemClientPlugin.getInstance().disconnect();
		try{
			connection.closeConnection();
		}catch(Exception e){
			System.out.println("We had an exception while closing the connection.");
		}
		connected = false;
		return !connected;
	}

	public boolean connected(){
		return connected;
	}
}