package falcons.plugin.exported.ticTacToePlugin.controller;

import java.util.HashMap;
import java.util.Observer;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.plugin.exported.TicTacToePlugin;
import falcons.plugin.exported.ticTacToePlugin.model.ConnectedClientsLogic;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeLogic;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

public class TicTacToeController implements Pluggable{

	private TicTacToeMainPanel view;
	private TicTacToeLogic logic;
	private ConnectedClientsLogic clogic;
	
	public TicTacToeController(){
		
	}
	
	public TicTacToeController(TicTacToeMainPanel view, TicTacToeLogic logic, ConnectedClientsLogic clogic) {
		this.view = view;
		this.logic = logic;
		this.clogic = clogic;
	}
	
	public void changeO(int i) {
		logic.changeO(i);
		AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("turn", "0.1", i);
		TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination(), 0));
	}
	
	public void changeX(int i){
		logic.changeX(i);
	}
	
	public void updateClients(){
		clogic.updateClients();
	}
	
	public HashMap<Integer, String> getClients(){
		return clogic.getClients();
	}
	
	public void setClients(HashMap<Integer, String> hashMap){
		clogic.setClients(hashMap);
	}
	
	/**
	 * Connect to opponent, and sets destination to opponents ID
	 * 
	 * @param dest - an int representing the client that has been selected as opponent
	 */
	public void connect(int dest) {
		logic.setDestination(dest);
		
		AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("startGame", "0.1", null);
		TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination(), -2));
	}
}
