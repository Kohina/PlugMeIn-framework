package falcons.server.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import falcons.plugin.manager.DataInterpreter;

public class CommunicationCenter {

	private ServerSocket socket = null;
	private DataInterpreter interpreter;

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
	public CommunicationCenter(DataInterpreter interpreter, String ip, int port)
			throws IOException {

		try {
			// Create an interpreter associated with the client
			this.interpreter = interpreter;
			// Create a new socket
			this.socket = new ServerSocket(port);
			// Catch UnknownHostException and tell the user about it.
			new ConnectionThread(socket.accept()).start();
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + ip);
			// Catch IOException and tell the user about it.
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: " + ip);
		}
	}
}
