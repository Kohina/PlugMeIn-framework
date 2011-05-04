package falcons.server.model;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ServerPreferencesLogic {

	static Serializer serializer = new Persister();
	static File ServerPreferencesXML = new File("ServerPreferences.xml");

	/**
	 * Method that serializes the {@link ClientPreferencesModel} instance.
	 */
	public void savePreferences(){
		try {
			serializer.write(ClientPreferencesModel.getInstance(), ServerPreferencesXML);
		} catch (Exception e) {
			System.out.println("Failed to serialize the object.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that deserializes the XML file representing the {@link ClientPreferencesModel} instance.
	 */
	@SuppressWarnings("static-access")
	public static void readPreferences(){
		ClientPreferencesModel temp;
		try {
			temp = serializer.read(ClientPreferencesModel.getInstance(), ServerPreferencesXML);

			ClientPreferencesModel.getInstance().setPort(temp.getPort());
		} catch (Exception e) {
			System.out.println("Failed to deserialize the XML file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static int getPort() {
		ClientPreferencesModel.getInstance();
		int tempPort = ClientPreferencesModel.getPort();
		return tempPort;
	}
}