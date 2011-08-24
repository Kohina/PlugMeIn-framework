package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;

import javax.swing.JOptionPane;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.plugin.exported.TicTacToePlugin;

public class ConnectedClientsModel extends Observable implements Pluggable, Serializable{
	
	private HashMap<Integer, String> clientMap;
	
	/**
	 * The default constructor.
	 */
	public ConnectedClientsModel(){
	
	}
	
	/**
	 * Updates the list of clients.
	 */
	public void updateClients(){
		AbstractPluginData<String> pluginData = new AbstractPluginData<String>("getClients", "1.0", "TicTacToePlugin");
		TicTacToePlugin.send(new PluginCall("SystemServerPlugin", pluginData, -1, -2));
		System.out.println("Here connectedclinetsmodel");
	}
	
	/**
	 * Gets the connected clients.
	 * 
	 * @return
	 * 			The connected clients as a HashMap with the IDs as keys.
	 */
	public HashMap<Integer, String> getClients(){
		return clientMap;
	}
	
	/**
	 * Sets the list of connected clients.
	 * 
	 * @param hm
	 * 			The connected clients as a HashMap with the IDs as keys.
	 */
	public void setClients(HashMap<Integer, String> hm){
		clientMap = hm;
		setChanged();
		notifyObservers();
	}
}