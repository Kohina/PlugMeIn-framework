package falcons.client.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import falcons.client.model.ClientPreferencesLogic;
import falcons.plugin.PluginCall;

public final class ClientConnection extends Thread{

	private Socket socket = null;
	private ListeningThread listeningThread;
	private static ObjectOutputStream out;
	private static ClientConnection instance;

	/**
	 * Contructor
	 *
	 * @param ip
	 *            The IP-address of the server
	 * @param port
	 *            The port that the server uses to accept connections.
	 * @throws IOException
	 *             If an unhandled IOException is thrown then it could not find
	 *             the I/O Connection for the socket.
	 */
	private ClientConnection() throws IOException {
		try {
			// Create a new socket
			this.socket = new Socket(ClientPreferencesLogic.getIp(), ClientPreferencesLogic.getPort());

			start();
			// Catch UnknownHostException and tell the user about it.
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + ClientPreferencesLogic.getIp());
			// Catch IOException and tell the user about it.
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: " + ClientPreferencesLogic.getPort());
		}
	}

	/**
	 * Returns the {@link ClientConnection} instance.
	 * @return The instance.
	 */
	public static ClientConnection getInstance(){
		if(instance == null){
			try {
				instance = new ClientConnection();
			} catch (IOException e) {
				System.out.println("Failed to create ClientConnection.");
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * Starts the connection to the server and initiates the socket.
	 */
	public void run(){
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			listeningThread = new ListeningThread(socket.getInputStream());
		} catch (IOException e) {
			System.err.println("Could not initiat InputStream.");
			e.printStackTrace();
		}
		listeningThread.start();
	}

	
	/**
	 * Sends a PluginCall to the connected client. Takes the PluginCall as a
	 * parameter.
	 *
	 * @param call
	 *            The PluginCall which should be sent to the client.
	 * @throws IOException
	 */
	public static void send(PluginCall call) {
		try {
			out.writeObject(call);
		} catch (IOException e) {
			System.err.print("Could not write to the output stream.");
		}
	}

	/**
	 * Closes the connection to the server and disconnects the {@link ListeningThread}s.
	 */
	public void closeConnection(){
		try {
			SystemClientPlugin.getInstance().disconnect();
			out.close();
			listeningThread.close();
			out.flush();
			socket.close();
			listeningThread = null;
		} catch (SocketException e) {
			System.out.println("There was a socket exception when closing the connection.");
			e.printStackTrace();
				
		} catch (IOException e) {
			System.out.println("There was a I/O Exception when the connection was closed.");
			e.printStackTrace();
		}
	}
}
