package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.HashMap;

import falcons.plugin.Pluggable;

public class ConnectedClientsLogic implements Pluggable, Serializable{

	private ConnectedClientsModel model;
	
	public ConnectedClientsLogic(){
		model = new ConnectedClientsModel();
	}
	
	public HashMap getClients(){
		return model.getClients();
	}
	
	public void updateClients(){
		model.updateClients();
	}
}
