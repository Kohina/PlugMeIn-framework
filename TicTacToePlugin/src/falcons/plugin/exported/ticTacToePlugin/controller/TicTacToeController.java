package falcons.plugin.exported.ticTacToePlugin.controller;

import java.util.HashMap;

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
	
	public TicTacToeController(TicTacToeMainPanel view, TicTacToeLogic logic) {
		this.view = view;
		this.logic = logic;
		clogic = new ConnectedClientsLogic();
	}
	
	public void changeO(int i) {
		logic.changeO(i);
		AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("turn", "0.1", i);
		TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination()));
	}
	
	public void changeX(int i){
		logic.changeX(i);
	}
	
	public void updateClients(){
		clogic.updateClients();
	}
	
	public HashMap getClients(){
		return clogic.getClients();
	}
	
	/**
	 * Connect to opponent, and sets destination to opponents ID
	 * 
	 * @param selectedIndex - an int representing wich client from a list that has been selected as opponent
	 */
	public void connect(int selectedIndex) {
		logic.setDestination((Long) clogic.getClients().get(clogic.getClients().keySet().toArray()[selectedIndex]));
		
		AbstractPluginData<Long> pluginData = new AbstractPluginData<Long>("startGame", "0.1", (Long) TicTacToePlugin.getData(new PluginEvent(PluginEventType.GET_CLIENTID)));
		TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination()));
	}
}
