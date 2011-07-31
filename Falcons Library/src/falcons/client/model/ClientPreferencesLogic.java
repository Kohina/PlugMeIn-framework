package falcons.client.model;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ClientPreferencesLogic {

	static Serializer serializer = new Persister();
	static File ClientPreferencesXML = new File("ClientPreferences.xml");
	private static ClientPreferencesModel clientPreferencesModel = ClientPreferencesModel.getInstance();

	/**
	 * Method that serializes the {@link ClientPreferencesModel} instance.
	 */
	public static void savePreferences(){
		try {
			serializer.write(clientPreferencesModel, ClientPreferencesXML);
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
			temp = serializer.read(clientPreferencesModel, ClientPreferencesXML);

			clientPreferencesModel.setIp(temp.getIp());
			clientPreferencesModel.setPort(temp.getPort());
		} catch (Exception e) {
			System.out.println("Failed to deserialize the XML file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the IP in the {@link ClientPreferencesModel} object.
	 * @return The IP in the object.
	 */
	public static String getIp(){
		return clientPreferencesModel.getIp();
	}
	
	/**
	 * Returns the port in the {@link ClientPreferencesModel} object.
	 * @return The port of the object.
	 */
	public static int getPort() {
		return clientPreferencesModel.getPort();
	}
	
	/**
	 * Sets the IP in the {@link ClientPreferencesModel} object.
	 */
	public static void setIp(String ip){
		ClientPreferencesModel.getInstance().setIp(ip);
	}
	
	/**
	 * Sets the port in the {@link ClientPreferencesModel} object.
	 */
	public static void setPort(int port) {
		ClientPreferencesModel.getInstance().setPort(port);
	}
	
	/**
	 * Returns the name from the {@link ClientPreferencesModel} object.
	 * @return The name of the object.
	 */
	public static String getName(){
		return clientPreferencesModel.getName();
	}
	
	/**
	 * Sets the name of in {@link ClientPreferencesModel} object.
	 * @param name The name to update with.
	 */
	public static void setName(String name){
		clientPreferencesModel.setName(name);
	}
	
	public static void setID(int id){
		clientPreferencesModel.setID(id);
	}
	
	public static int getID(){
		return clientPreferencesModel.getID();
	}
}