package falcons.client.model;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ClientPreferencesLogic {

	static Serializer serializer = new Persister();
	static File ClientPreferencesXML = new File("ClientPreferences.xml");

	/**
	 * Method that serializes the {@link ServerPreferencesModel} instance.
	 */
	public void savePreferences(){
		try {
			serializer.write(ServerPreferencesModel.getInstance(), ClientPreferencesXML);
		} catch (Exception e) {
			System.out.println("Failed to serialize the object.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that deserializes the XML file representing the {@link ServerPreferencesModel} instance.
	 */
	@SuppressWarnings("static-access")
	public static void readPreferences(){
		ServerPreferencesModel temp;
		try {
			temp = serializer.read(ServerPreferencesModel.getInstance(), ClientPreferencesXML);

			ServerPreferencesModel.getInstance().setIp(temp.getIp());
			ServerPreferencesModel.getInstance().setPort(temp.getPort());
		} catch (Exception e) {
			System.out.println("Failed to deserialize the XML file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static String getIp(){
		ServerPreferencesModel.getInstance();
		return new String(ServerPreferencesModel.getIp());
	}
	
	/**
	 * 
	 */
	public static int getPort() {
		ServerPreferencesModel.getInstance();
		int tempPort = ServerPreferencesModel.getPort();
		return tempPort;
	}
}