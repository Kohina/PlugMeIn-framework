package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Observer;

import javax.swing.JPanel;

import falcons.plugin.Pluggable;

public class ConnectedClientsLogic implements Pluggable, Serializable{

	private ConnectedClientsModel model;
	
	/**
	 * Creates the logic.
	 * 
	 * @param m
	 * 			The model to be used.
	 */
	public ConnectedClientsLogic(ConnectedClientsModel m){
		model = m;
	}
	
	/**
	 * Gets the connected clients.
	 * 
	 * @return
	 * 			The connected clients as a HashMap with the IDs as keys
	 */
	public HashMap<Integer, String> getClients(){
		return model.getClients();
	}
	
	/**
	 * Updates the list of the connected clients.
	 */
	public void updateClients(){
		model.updateClients();
	}

	/**
	 * Sets the list of the connected clients to hashMap.
	 * 
	 * @param hashMap
	 * 			The connected clients as a HashMap with the IDs as keys.
	 */
	public void setClients(HashMap<Integer, String> hashMap) {
		model.setClients(hashMap);
	}
}
