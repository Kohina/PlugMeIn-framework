package falcons.client.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.SocketException;

import falcons.plugin.PluginCall;

public class ListeningThread extends Thread {

	private ObjectInputStream in;
	private ClientDataInterpreter interpreter;
	
	/**
	 * Constructor, opens up a new {@link ListeningThread}.
	 * @param in
	 */
	public ListeningThread(InputStream in){
		try {
			this.in = new ObjectInputStream(in);
		} catch (IOException e) {
			System.err.println("Could not get connect to InputStream.");
			e.printStackTrace();
		}
		interpreter = interpreter.getInstance();
	}
	
	/**
	 * Interprets and runs a PluginCall.
	 */
	public void run(){
		try {
			PluginCall call;
			while ((call = (PluginCall) in.readObject()) != null) {
				interpreter.interpret(call);
			}
		} catch (SocketException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() throws IOException {
		in.close();
	}
}
