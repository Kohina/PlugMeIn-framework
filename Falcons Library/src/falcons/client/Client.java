package falcons.client;


import java.io.File;

import falcons.client.controller.ClientMasterController;
import falcons.utils.LibraryEvent;

// TODO Finish Implementing this class.
public class Client {
	
	private ClientMasterController controller;
	
	public Client(){
		controller = new ClientMasterController();
	}
	
	public void actionPerformed(LibraryEvent e){
		controller.actionPerformed(e);
	}
}