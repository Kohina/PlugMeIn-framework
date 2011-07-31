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
	
	public ConnectedClientsModel(){
	
	}
	
	public void updateClients(){
		//TODO: this is implemented wrong, have to fix how to get clients first!
		AbstractPluginData<String> pluginData = new AbstractPluginData<String>("getClients", "1.0", "TicTacToePlugin");
		TicTacToePlugin.send(new PluginCall("SystemServerPlugin", pluginData, -1, -2));
		System.out.println("Here connectedclinetsmodel");
	}
	
	public HashMap<Integer, String> getClients(){
		return clientMap;
	}
	
	public void setClients(HashMap<Integer, String> hm){
		clientMap = hm;
		setChanged();
		notifyObservers();
	}
}