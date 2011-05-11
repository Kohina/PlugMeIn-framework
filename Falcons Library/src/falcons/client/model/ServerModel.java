package falcons.client.model;

import java.util.HashMap;

import falcons.utils.ClientTree;

// TODO Finish implementing this class
class ServerModel {
	private static ServerModel instance;
	private ClientTree clientTree;
	private long id;
	
	static ServerModel getInstance(){
		if(instance == null){
			instance = new ServerModel();
		}
		return instance;
	}
	
	public HashMap<String, String> getPlugins(long id) {
		return clientTree.getPlugins(id);
	}
}
