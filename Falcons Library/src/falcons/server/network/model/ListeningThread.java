package falcons.server.network.model;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import falcons.plugin.PluginCall;

public class ListeningThread extends Thread {

	private ObjectInputStream in;
	private ServerDataInterpreter interpreter;
	private Socket socket;
	private boolean running = true;
	
	/**
	 * A Constructor that constructs a ListeningThread connected to a socket
	 * @param socket
	 * 				The socket that is supposed to be binded
	 */
	public ListeningThread(Socket socket){
		try {
			this.socket = socket;
			this.in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.err.println("Could not get connect to InputStream.");
			e.printStackTrace();
		}
		interpreter = interpreter.getInstance();
	}
	
	/**
	 * Closes the socket inside this thread
	 * @throws IOException
	 * 					Throws an exception if the close-action was not successful
	 */
	public void close(){
		try {
			running = false;
			in.close();
		} catch (IOException e) {
			System.err.println("Unable to close inputstream in ListeningThread");
			e.printStackTrace();
		}
	}
	
	/**
	 * Starts the thread
	 */
	public void run(){
		System.out.println("Here SystemListeningThread");
		try {
			PluginCall call;
			while ((call = getCall()) != null) {
				interpreter.interpret(call);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Fetches the call in the inputstream
	 * @return Returns the call next inside the inputstream if there is one.
	 * @throws IOException
	 * 						It was not possible to get the PluginCall
	 * @throws ClassNotFoundException
	 * 						It could not find the class of the object inside the inputstream
	 */
	public PluginCall getCall() throws IOException, ClassNotFoundException {
		if (!running) {
			return null;
		} else {
			return (PluginCall) in.readObject();
		}
	}
}