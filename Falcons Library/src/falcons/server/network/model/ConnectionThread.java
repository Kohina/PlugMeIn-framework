package falcons.server.network.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import falcons.plugin.PluginCall;

public class ConnectionThread extends Thread{
	
	private Socket socket;
	private ListeningThread listeningThread;
	private ObjectOutputStream out;

	public ConnectionThread(Socket socket){
		this.socket = socket;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The method that starts the thread
	 */
	public void run(){
		listeningThread = new ListeningThread(socket);
		listeningThread.start();
	}
	
	public void cancel(){
		listeningThread.close();
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			System.err.println("Unable to flush/close output stream in ConnectionThread");
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			System.err.println("Unable to close Socket in ConnectionThread");
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
			System.out.println(call.getPluginData().toString());
			out.writeObject(call);
		} catch (IOException e) {
			System.err.print("Could not write to the output stream.");
		}
	}
}
