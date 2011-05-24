package falcons.plugin.exported.ticTacToePlugin.controller;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
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
	
	public void turn(int i, boolean b){
		if(b){
			logic.turn(i);
		}
		else{
			logic.turn(i);
			
			AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("turn", "0.1", i);
			TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination()));
		}
	}
	
	public void updateClients(){
		clogic.updateClients();
	}
}
