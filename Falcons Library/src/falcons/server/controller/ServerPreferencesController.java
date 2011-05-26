package falcons.server.controller;

import falcons.server.model.ServerPreferencesLogic;

public class ServerPreferencesController {
	
	/**
	 * Saves the preferences loaded inside the model to a xml-file
	 */
	void savePreferences() {
		ServerPreferencesLogic.savePreferences();
	}
	
	/**
	 * Loads the preferences from the ServerPreferences.xml
	 */
	void readPreferences() {
		ServerPreferencesLogic.readPreferences();
	}
}