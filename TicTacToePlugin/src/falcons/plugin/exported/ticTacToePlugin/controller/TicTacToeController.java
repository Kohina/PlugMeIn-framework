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
	
	/**
	 * DO NOT USE.
	 */
	public TicTacToeController(){
		
	}
	
	/**
	 * Creates the controller.
	 * 
	 * @param view
	 * 			The view to be used.
	 * @param logic
	 * 			The logic to be used.
	 * @param clogic
	 * 			The ConnectedClientsLogic to be used.
	 */
	public TicTacToeController(TicTacToeMainPanel view, TicTacToeLogic logic, ConnectedClientsLogic clogic) {
		this.view = view;
		this.logic = logic;
		this.clogic = clogic;
	}
	
	/**
	 * Changes i.
	 * 
	 * @param i
	 * 			The int to be changed.
	 */
	public void change(int i) {
		logic.change(i);
	}
	
	/**
	 * Checks who has the next turn.
	 * 
	 * @return
	 * 			True if it is your turn, false otherwise.
	 */
	public boolean getMe(){
		return logic.getMe();
	}
	
	/**
	 * Updates the list of clients in ConnectedClientsLogic.
	 */
	public void updateClients(){
		clogic.updateClients();
	}
	
	/**
	 * Gets the connected clients.
	 * 
	 * @return
	 * 			The connected clients as a HashMap with IDs as keys.
	 */
	public HashMap<Integer, String> getClients(){
		return clogic.getClients();
	}
	
	/**
	 * Sets the connected clients.
	 * 
	 * @param hashMap
	 * 			The connected clients as a HashMap.
	 */
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
		
		AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("invite", "0.1", null);
		TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination(), -2));
	}

	/**
	 * Resets the game. (Probably, I didn't write the code to this plugin.)
	 * 
	 * @param b
	 * 			A value.
	 */
	public void reset(boolean b) {
		logic.reset();
		if(b){
			AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("end", "0.1", null);
			TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination(), -2));
		}
	}
}
