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
	
	public void close() throws IOException {
		in.close();
	}
	
	public void run(){
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
	
	public PluginCall getCall() throws IOException, ClassNotFoundException {
		if (socket.isInputShutdown()) {
			return null;
		} else {
			return (PluginCall) in.readObject();
		}
	}
}