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
	
	/**
	 * Default constructor.
	 */
	public Client(){
		controller = new ClientMasterController();
		dataController = new DataMasterController();
	}

	/**
	 * Called by the Client-object when actionPerformed is called from the
	 * ClientView. Determines which type of action was performed and asks the
	 * correct sub-controller to handle it.
	 *
	 * @param e
	 *            The ClientEvent associated with the action that the View was
	 *            asking for.
	 */
	public void actionPerformed(LibraryEvent e){
		controller.actionPerformed(e);
	}

	/**
	 * Returns the data associated with a LibraryEvent.
	 * @param e The LibraryEvent to return the data from.
	 * @return A general objcet containing the data.
	 */
	public Object getData(LibraryEvent e){
		return dataController.getData(e);
	}

	/**
	 * Fetches a {@link ClientConnection} which starts a connection to the server.
	 * @return True if the connection is completed.
	 */
	public boolean connect(){
		connection = ClientConnection.getInstance();
		connected = true;
		return connected;
	}

	/**
	 * Closes the {@link ClientConnection} which disconnects from the server.
	 * @return Returns true if the disconnection is succesful.
	 */
	public boolean disconnect(){
		SystemClientPlugin.getInstance().disconnect();
		try{
			connection.closeConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		connected = false;
		return !connected;
	}

	/**
	 * Checks if there is an established connection.
	 * @return True if there is an connection established, otherwise false.
	 */
	public boolean connected(){
		return connected;
	}
}