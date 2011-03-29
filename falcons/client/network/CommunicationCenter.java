package falcons.client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommunicationCenter {

	private Socket socket = null;
	private DataInterpreter interpreter;
	private ObjectInputStream in = null;
	private ObjectOutputStream out = null;
	
	public CommunicationCenter (DataInterpreter interpreter, String ip, int port){
		
		try {
			// Create an interpreter associated with the client
			this.interpreter = interpreter;
			// Create a new socket
			this.socket = new Socket(ip, port);
		// Catch UnknownHostException and tell the user about it.
		} catch (UnknownHostException) {
			System.err.println("Don't know about host: " + ip);
			System.exit(1);
		// Catch IOException and tell the user about it.
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: " + ip);
			System.exit(1);
		}
		// Associate the input and output stream to ObjectStreams.
		in = socket.getInputStream();
		out = socket.getOutputStream();
	}
	
	private void client(){
		// The holder of the PluginCall received through the InputStream.
		AbstractPluginCall call;
		
		// Always listen.
		while(call = in.readObject() !=null){
			interpreter.interpret(call);
		}
	}
}
