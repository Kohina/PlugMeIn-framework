package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Observer;

import javax.swing.JPanel;

import falcons.plugin.Pluggable;

public class ConnectedClientsLogic implements Pluggable, Serializable{

	private ConnectedClientsModel model;
	
	public ConnectedClientsLogic(ConnectedClientsModel m){
		model = m;
	}
	
	public HashMap<Integer, String> getClients(){
		return model.getClients();
	}
	
	public void updateClients(){
		model.updateClients();
	}

	public void setClients(HashMap<Integer, String> hashMap) {
		model.setClients(hashMap);
	}
}
