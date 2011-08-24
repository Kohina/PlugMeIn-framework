package falcons.server.network.model;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerThread extends Thread {

	private ServerSocket socket;
	
	public ServerThread(ServerSocket socket){
		this.socket = socket;
		
	}

	public void run(boolean listening) {
		while (listening) {
			if (!this.socket.isClosed()) {
				ConnectionThread thread;
				try {
					thread = new ConnectionThread(this.socket.accept());
					System.out
							.println("NEW CONNECTION RECEIVED, CREATING NEW CONNECTIONTHREAD");
					ConnectionModel.getInstance().addConnection(thread);
					thread.start();
				} catch (Exception e) {
					System.out.println("A connection could not be accepted.");
				}
			}
		}
	}
}