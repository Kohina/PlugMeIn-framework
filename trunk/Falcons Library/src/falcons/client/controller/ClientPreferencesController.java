package falcons.client.controller;

import java.util.prefs.Preferences;

import falcons.client.model.ClientPreferencesLogic;

class ClientPreferencesController {
	
	/**
	 * Serializes the {@link Preferences} object, saving the preferences.
	 */
	void savePreferences(){
		ClientPreferencesLogic.savePreferences();
	}
	
	/**
	 * Deserializes the preferences XML-file to a {@link Preferences} object.
	 */
	void readPreferences(){
		ClientPreferencesLogic.readPreferences();
	}
	
	/**
	 * Sets the IP to the {@link Preferences} object.
	 * @param Ip The IP.
	 */
	void setIp(String Ip){
		ClientPreferencesLogic.setIp(Ip);
	}
	
	/**
	 * Sets the port to the {@link Preferences} object.
	 * @param port The port.
	 */
	void setPort(String port){
		ClientPreferencesLogic.setPort(Integer.parseInt(port));
	}
}
