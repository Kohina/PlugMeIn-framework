package falcons.server.network;

import java.net.*;
import java.io.*;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.SendMessagePlugin;
import falcons.plugin.manager.DataInterpreter;
import falcons.plugin.manager.PluginCall;

public class ConnectionThread extends Thread{

	private int id = -1;
	private Socket socket = null;
	private DataInterpreter interpreter;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	private SendMessagePlugin p = new SendMessagePlugin();
	
	/*
	 *Contructor that sets the instace variable
	 * 
	 */
	public ConnectionThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		System.out.println("CONNECTIONTHREAD STARTED");
/*		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		//Hardcoded stuff delete later
		send(new PluginCall(p, p.getSendMessagePluginData(), 0));
		System.out.println("SENT");
		
/*		try {
			while ((call = (PluginCall) in.readObject()) != null) {	
				    interpreter.interpret(call);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
	}
	/**
	 * Sends a PluginCall to the connected client. Takes the PluginCall as a parameter.
	 * 
	 * @param call
	 * 				The PluginCall which should be sent to the client.
	 * @throws IOException
	 */
	public void send(PluginCall call) {
		try {
			out.writeObject(call);
		} catch(IOException e) {
			System.err.print("Could not write to the output stream.");
		}
	}
	
	public void giveID(int id) {
		if(id != -1) {
			this.id = id; 
		} else {
			System.err.print("Thread already has an ID.");
		}
	}
	
	public int getID() {
		return id;
	}
}