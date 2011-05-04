package falcons.client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import falcons.client.model.ClientPreferencesLogic;

public class ClientCommunicationCenter implements Runnable {

	private Socket socket = null;
	private ClientDataInterpreter interpreter;
	private ObjectInputStream in = null;
	// TODO create an output.
	private ObjectOutputStream out = null;

	/**
	 * Contructor for the CommunicationCenter.
	 * 
	 * @param interpreter
	 *            The DataInterpreter that's being used by the client.
	 * @param ip
	 *            The IP-address of the server
	 * @param port
	 *            The port that the server uses to accept connections.
	 * @throws IOException
	 *             If an unhandled IOException is thrown then it could not find
	 *             the I/O Connection for the socket.
	 */
	public ClientCommunicationCenter(ClientDataInterpreter interpreter)
			throws IOException {
		interpreter.getInstance(true);
		try {
			// Create a new socket
			this.socket = new Socket(ClientPreferencesLogic.getIp(), ClientPreferencesLogic.getPort());
			// Catch UnknownHostException and tell the user about it.
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + ClientPreferencesLogic.getIp());
			// Catch IOException and tell the user about it.
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: " + ClientPreferencesLogic.getPort());
		}
	}

	/**
	 * Start listening to the socket.
	 * 
	 * @throws IOException
	 *             If an unhandled IOException is thrown then we lost connection
	 *             to the inputstream.
	 * @throws ClassNotFoundException
	 *             If an unhandled ClassNotFoundException is thrown a disallowed
	 *             object was sent to the client.
	 */
	private void client() throws IOException, ClassNotFoundException {
		ConnectionThread thread = new ConnectionThread(socket);
		thread.start();
		}

	@Override
	public void run() {
		try {
			System.out.println("CLIENT STARTED");
			client();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
