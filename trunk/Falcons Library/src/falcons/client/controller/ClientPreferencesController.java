package falcons.client.controller;

import falcons.client.model.ClientPreferencesLogic;

class ClientPreferencesController {
	
	void savePreferences(){
		ClientPreferencesLogic.savePreferences();
	}
	
	void readPreferences(){
		ClientPreferencesLogic.readPreferences();
	}
	
	void setIp(String Ip){
		ClientPreferencesLogic.setIp(Ip);
	}
	
	void setPort(int port){
		ClientPreferencesLogic.setPort(port);
	}
}
