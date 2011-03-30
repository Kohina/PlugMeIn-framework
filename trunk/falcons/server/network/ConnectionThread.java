package falcons.server.network;

import java.net.*;
import java.io.*;

public class ConnectionThread extends Thread{

	private ServerSocket socket = null;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	/*
	 *Contructor that sets the instace variable
	 * 
	 */
	public ConnectionThread(ServerSocket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		Socket clientSocket = null;
		in = (ObjectInputStream) clientSocket.getInputStream();
		out = (ObjectOutputStream) clientSocket.getOutputStream();
		PluginCall call;
		
		clientSocket = socket.accept();
		
		while ((call = (PluginCall) in.readObject()) != null) {	
			    interpreter.interpret(call);
		}
	}
	
	/**
	 * Sends a PluginCall to the connected client. Takes the PluginCall as a parameter.
	 * 
	 * @param call
	 * 				The PluginCall which should be sent to the client.
	 * @throws IOException
	 */
	public void send(PluginCall call) throws IOException {
		out.writeObject(call);
	}
}