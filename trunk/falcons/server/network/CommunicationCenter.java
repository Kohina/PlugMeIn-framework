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
	private boolean listening = true;
	private ConnectionModel model;

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
	public CommunicationCenter(DataInterpreter interpreter, int port, ConnectionModel model)
			throws IOException {

		try {
			this.model = model;
			// Create an interpreter associated with the client
			this.interpreter = interpreter;
			// Create a new socket
			this.socket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the client");
		}
		
		server();
	}
	
	public void server(){
		while(listening){
			try {
				ConnectionThread thread = new ConnectionThread(socket.accept());
				model.addThread(thread);
				thread.giveID(model.getID(thread));
				thread.start();
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for the connection to the client");
				e.printStackTrace();
			}
		}
	}
}
