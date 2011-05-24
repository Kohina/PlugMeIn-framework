package falcons.plugin.exported.ticTacToePlugin.controller;

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

	public void connect(int selectedIndex) {
		logic.setDestination((Long) clogic.getClients().get(clogic.getClients().keySet().toArray()[selectedIndex]));
		
		AbstractPluginData<Long> pluginData = new AbstractPluginData<Long>("startGame", "0.1", (Long) TicTacToePlugin.getData(new PluginEvent(PluginEventType.GET_CLIENTID)));
		TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination()));
	}
}
