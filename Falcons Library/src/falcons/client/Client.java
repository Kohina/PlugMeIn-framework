package falcons.client;


import java.io.File;

import falcons.client.controller.ClientMasterController;
import falcons.client.controller.DataMasterController;
import falcons.utils.LibraryEvent;

// TODO Finish Implementing this class.
public class Client {
	
	private ClientMasterController controller;
	private DataMasterController dataController;
	
	public Client(){
		controller = new ClientMasterController();
		dataController = new DataMasterController();
	}
	
	public void actionPerformed(LibraryEvent e){
		controller.actionPerformed(e);
	}
	
	public Object getData(LibraryEvent e){
		return dataController.getData(e);
	}
}