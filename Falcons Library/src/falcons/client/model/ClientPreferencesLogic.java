package falcons.client.model;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ClientPreferencesLogic {

	static Serializer serializer = new Persister();
	static File ClientPreferencesXML = new File("ClientPreferences.xml");

	/**
	 * Method that serializes the {@link ClientPreferencesModel} instance.
	 */
	public static void savePreferences(){
		try {
			serializer.write(ClientPreferencesModel.getInstance(), ClientPreferencesXML);
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
			temp = serializer.read(ClientPreferencesModel.getInstance(), ClientPreferencesXML);

			ClientPreferencesModel.getInstance().setIp(temp.getIp());
			ClientPreferencesModel.getInstance().setPort(temp.getPort());
		} catch (Exception e) {
			System.out.println("Failed to deserialize the XML file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static String getIp(){
		ClientPreferencesModel.getInstance();
		return new String(ClientPreferencesModel.getIp());
	}
	
	/**
	 * 
	 */
	public static int getPort() {
		ClientPreferencesModel.getInstance();
		int tempPort = ClientPreferencesModel.getPort();
		return tempPort;
	}
	
	/**
	 * 
	 */
	public static void setIp(String ip){
		ClientPreferencesModel.getInstance();
		ClientPreferencesModel.setIp(ip);
	}
	
	/**
	 * 
	 */
	public static void setPort(int port) {
		ClientPreferencesModel.getInstance();
		ClientPreferencesModel.setPort(port);
	}
}