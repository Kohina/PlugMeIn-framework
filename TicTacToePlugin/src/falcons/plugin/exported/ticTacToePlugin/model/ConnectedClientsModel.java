package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.plugin.exported.TicTacToePlugin;

public class ConnectedClientsModel implements Pluggable, Serializable{
	
	private HashMap<String, Long> clientMap;
	private ArrayList<String> dataArray = new ArrayList<String>();
	
	public ConnectedClientsModel(){
	
	}
	
	public void updateClients(){
		//TODO Call is not recived by server, this causes errors
		//clientMap = (HashMap<String, Long>) TicTacToePlugin.getData(new PluginEvent(PluginEventType.GET_CLIENTS));
		dataArray.add("TicTacToePlugin");
		dataArray.add("" + TicTacToePlugin.getData(new PluginEvent(PluginEventType.GET_CLIENTID)));
		AbstractPluginData<ArrayList> pluginData = new AbstractPluginData<ArrayList>("getClients", "1.0", dataArray);
		TicTacToePlugin.send(new PluginCall("SystemServerPlugin", pluginData, -1));
		System.out.println("Here connectedclinetsmodel");
	}
	
	public HashMap getClients(){
		return clientMap;
	}
	
	public void setClients(HashMap<String, Long> hm){
		clientMap = hm;
		System.out.println("Here");
	}
}