package falcons.server.network.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import falcons.plugin.PluginCall;

public class ConnectionThread extends Thread{

	private Socket socket = null;
	private ListeningThread listeningThread;
	private ObjectOutputStream out;

	public ConnectionThread(Socket socket){
		this.socket = socket;

	}

	public void run(){
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			listeningThread = new ListeningThread(socket.getInputStream());
			listeningThread.start();
		} catch (IOException e) {
			System.err.println("Couldn't initiate ListeningThread");
			e.printStackTrace();
		}
	}

	/**
	 * Sends a PluginCall to the connected client. Takes the PluginCall as a
	 * parameter.
	 *
	 * @param call
	 *            The PluginCall which should be sent to the client.
	 * @throws IOException
	 */
	public void send(PluginCall call) {
		try {
			out.writeObject(call);
		} catch (IOException e) {
			System.err.print("Could not write to the output stream.");
		}
	}
}
