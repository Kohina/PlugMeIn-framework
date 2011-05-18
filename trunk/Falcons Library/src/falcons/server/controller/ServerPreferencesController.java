package falcons.server.controller;

import falcons.server.model.ServerPreferencesLogic;

public class ServerPreferencesController {
	void savePreferences() {
		ServerPreferencesLogic.savePreferences();
	}
	
	void readPreferences() {
		ServerPreferencesLogic.readPreferences();
	}
}