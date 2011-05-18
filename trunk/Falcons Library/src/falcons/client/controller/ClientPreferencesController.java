package falcons.client.controller;

import falcons.client.model.ClientPreferencesLogic;

class ClientPreferencesController {
	
	void savePreferences(){
		ClientPreferencesLogic.savePreferences();
	}
	
	void readPreferences(){
		ClientPreferencesLogic.readPreferences();
	}
}
