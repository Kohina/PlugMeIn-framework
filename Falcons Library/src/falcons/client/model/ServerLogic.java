package falcons.client.model;

import java.util.HashMap;

public class ServerLogic {
	private static ServerModel serverModel = ServerModel.getInstance();
	
	public static HashMap<String, String> getPlugins(long id) {
		return serverModel.getPlugins(id);
	}
}
