package falcons.server.network;

import java.net.*;
import java.io.*;

public class ConnectionThread extends Thread{

	private Socket socket = null;
	private DataInterpreter interpreter;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	/*
	 *Contructor that sets the instace variable
	 * 
	 */
	public ConnectionThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		Socket clientSocket = null;
		try {
			in = (ObjectInputStream) clientSocket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out = (ObjectOutputStream) clientSocket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PluginCall call;
		
		try {
			while ((call = (PluginCall) in.readObject()) != null) {	
				    interpreter.interpret(call);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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