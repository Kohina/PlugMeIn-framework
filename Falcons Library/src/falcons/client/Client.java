package falcons.client;


import java.io.File;

import falcons.client.controller.ClientMasterController;
import falcons.utils.ClientEvent;

public class Client {
	
	private ClientMasterController controller;
	
	public Client(){
		controller = new ClientMasterController();
	}
	
	public void actionPerformed(ClientEvent e){
		controller.actionPerformed(e);
	}
}