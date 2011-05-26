package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.HashMap;

import javax.swing.JOptionPane;

import falcons.plugin.Pluggable;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.plugin.exported.TicTacToePlugin;

public class ConnectedClientsModel implements Pluggable, Serializable{
	
	private HashMap<String, Long> clientMap;
	
	public ConnectedClientsModel(){
	
	}
	
	public void updateClients(){
		clientMap = (HashMap<String, Long>) TicTacToePlugin.getData(new PluginEvent(PluginEventType.GET_CLIENTS));
		JOptionPane.showMessageDialog(null, clientMap.toString());
	}
	
	public HashMap getClients(){
		return clientMap;
	}
}