package falcons.server.controller;

import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class ServerMasterController {

	private ServerPreferencesController prefCont;
	private PluginController pluginCont;
	private NetworkController netCont;

	/**
	 * Constructor, instantiates all the sub-controllers.
	 */
	public ServerMasterController() {
		prefCont = new ServerPreferencesController();
		pluginCont = new PluginController();
		netCont = new NetworkController(); //TODO Remove?
	}

	/**
	 * Called by the Server-object when actionPerformed is called from the
	 * ServerView. Determines which type of action was performed and asks the
	 * correct sub-controller to handle it.
	 * 
	 * @param e
	 *            The ServerEvent associated with the action that the View was
	 *            asking for.
	 */
	public void actionPerformed(LibraryEvent e) {
		LibraryEventType type = e.getEventType();

		switch (type) {
		
		case LOAD_PLUGINS:
			pluginCont.loadPlugins();
			break;
		case READ_PREFERENCES:
			prefCont.readPreferences();
			break;
		case SAVE_PREFERENCES:
			prefCont.savePreferences();
			break;
		default:
			break;
		}
	}

}
